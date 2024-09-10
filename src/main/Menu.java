package main;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.SortedMap;

import login.*;
import system.*;

public class Menu {

	public static ArrayList<User> users = new ArrayList<>();
	public static ArrayList<Estufa> estufas = new ArrayList<>();
	private static User usuarioLogado;

	public static void main(String[] args) {
		users.add(new User("Eduardo", "Eduardo123", 3));
		users.add(new User("Mônica", "Mônica123", 2));
		users.add(new User("Cebolinha", "Cebolinha123", 1));

		login();

		exibirMenu();
	}

	public static void login() {
		Scanner sc = new Scanner(System.in);

		boolean find = false;
		while (!find) {
			System.out.println("Digite seu nome: ");
			String nome = sc.nextLine();

			System.out.println("Digite sua senha: ");
			String senha = sc.nextLine();


			for (User usuario : users) {
				if ((usuario.getNome().equals(nome)) && (usuario.getSenha().equals(senha))) {
					find = true;
				}

				if (find) {
					usuarioLogado = usuario;
					System.out.printf("Bem-vindo %s!\n", nome);
					break;
				}
			}

			if (!find) {
				System.out.println("\nUsuario não encontrado!");
			}
		}
	}

	public static void exibirMenu() {
		Scanner sc = new Scanner(System.in);
		int opcao;
		switch (usuarioLogado.getNivel()) {
			case 1:
				opcao = -1;
				while (opcao != 0) {
					System.out.print("""
							1 - Visualizar Informações de Estufas
							2 - Atualizar Dados do Plantio
							0 - Sair
							Digite sua escolha:\s""");
					opcao = sc.nextInt();
					sc.nextLine();

					if (opcao == 1) {
						exibirDadosEstufas();
					} else if (opcao == 2) {
						System.out.print("\nDigite id do plantio que você deseja alterar: ");
						// Tratar exceptions
						atualizarDadosPlantio(sc, sc.nextInt());
					} else if (opcao == 0) {
						System.out.println("Saindo...");
					} else {
						System.out.println("Escolha inválida! Digite novamente.");
					}
				}
				break;

			case 2:
				opcao = -1;
				while (opcao != 0) {
					System.out.print("""
							1 - Visualizar Informações de Estufas
							2 - Atualizar Dados do Plantio
							3 - Criar Relatório de Atividades dos Cultivadores
							4 - Visualizar Dados Equipamentos
							0 - Sair
							Digite sua escolha:\s""");
					opcao = sc.nextInt();
					sc.nextLine();

					if (opcao == 1) {
						exibirDadosEstufas();
					} else if (opcao == 2) {
						System.out.print("\nDigite id do plantio que você deseja alterar: ");
						// Tratar exceptions
						atualizarDadosPlantio(sc, sc.nextInt());
					} else if (opcao == 3) {

					} else if (opcao == 4) {
						exibirDadosEquipamentos();
					} else if (opcao == 0) {
						System.out.println("Saindo...");
					} else {
						System.out.println("Escolha inválida! Digite novamente.");
					}
				}
				break;

			case 3:
				opcao = -1;
				while (opcao != 0) {
					System.out.print("""
							1 - Visualizar Informações de Estufas
							2 - Atualizar Dados do Plantio
							3 - Visualizar Dados Equipamentos
							4 - Cadastrar Estufa
							5 - Cadastrar Aluno
							0 - Sair
							Digite sua escolha:\s""");
					opcao = sc.nextInt();
					sc.nextLine();

					if (opcao == 1) {
						exibirDadosEstufas();
					} else if (opcao == 2) {
						System.out.print("\nDigite id do plantio que você deseja alterar: ");
						// Tratar exceptions
						atualizarDadosPlantio(sc, sc.nextInt());
					} else if (opcao == 3) {
						exibirDadosEquipamentos();
					} else if (opcao == 4) {
						Professor.cadastraEstufa(sc);
					} else if (opcao == 5) {
						Professor.cadastrarAluno(sc);
					} else if (opcao == 0) {
						System.out.println("Saindo...");
					} else {
						System.out.println("Escolha inválida! Digite novamente.");
					}
				}
				break;
		}
	}

	public static void exibirDadosEstufas() {
		if (estufas.isEmpty()) {
			System.out.println("Nenhuma estufa cadastrada.");
		} else {
			System.out.println("Dados das Estufas:");
			for (Estufa estufa : estufas) {
				System.out.println(estufa.toString());
			}
		}
	}

	public static void exibirDadosAlunos() {
		if (users.isEmpty()) {
			System.out.println("Nenhum aluno cadastrado.");
		} else {
			System.out.println("Dados dos Alunos:");
			for (User user : users) {
				if (user instanceof AlunoCultivador) {
					AlunoCultivador aluno = (AlunoCultivador) user;
					System.out.println("Nome: " + aluno.getNome() + " | ID: " + aluno.getId() + " | Tipo: Cultivador");
				} else if (user instanceof AlunoSupervisor) {
					AlunoSupervisor aluno = (AlunoSupervisor) user;
					System.out.println("Nome: " + aluno.getNome() + " | ID: " + aluno.getId() + "| Tipo: Supervisor");
				}
			}
		}
	}

	public static void exibirDadosEquipamentos() {
		System.out.println("\nSensores: ");
		for (Estufa estufa : estufas) {
			for (Sensor sensor : estufa.getListaSensores()) {
				System.out.println("     " + sensor.toString());
			}
		}
	}

	public static void atualizarDadosPlantio(Scanner sc, int idPlantio) {
		int opcaoAttDados;
		while (true) {
			System.out.print("""
				Quais dados você quer atualizar?
				1 - Adicionar substância
				2 - Alterar nome da espécie cultivada
				3 - Definir data de fim do plantio (data de hoje)
				Digite sua escolha:\s""");
			opcaoAttDados = sc.nextInt();
			sc.nextLine();

			if (opcaoAttDados > 0 && opcaoAttDados < 4) {
				break;
			} else {
				System.out.println("Inválido!");
			}
		}

		for (Estufa estufa : estufas) {
			if (estufa.getPlantio().getIdPlantio() == idPlantio) {
				switch (opcaoAttDados) {
					case 1:
						System.out.print("Digite o nome da substância: ");
						estufa.getPlantio().setSubstancias(sc.nextLine());
						break;

					case 2:
						System.out.print("Digite o nome da espécie: ");
						estufa.getPlantio().setNomeEspecie(sc.nextLine());
						break;

					case 3:
						estufa.getPlantio().setFim();
						System.out.println("Fim definido: " + estufa.getPlantio().getFim());
						break;
				}
				break;
			}
			System.out.println("\nPlantio não encontrado!");
		}
	}
}