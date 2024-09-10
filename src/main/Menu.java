package main;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import login.*;
import system.*;

public class Menu {

	public static ArrayList<User> users = new ArrayList<>();
	public static ArrayList<Estufa> estufas = new ArrayList<>();
	private static int nivel;
	private static int id;

	public static void main(String[] args) {
		users.add(new User("Eduardo", "Eduardo123", 3));
		users.add(new User("Mônica", "Mônica123", 2));
		users.add(new User("Cebolinha", "Cebolinha123", 1));

		login();
		exibirMenu();
	}

	public static void login() {
		Scanner sc = new Scanner(System.in);

		System.out.println("Digite seu nome: ");
		String nome = sc.nextLine();

		System.out.println("Digite sua senha: ");
		String senha = sc.nextLine();

		boolean find = false;

		for (User usuario : users) {
			if ((usuario.getNome().equals(nome)) && (usuario.getSenha().equals(senha))) {
				find = true;
			}

			if (find) {
				nivel = usuario.getNivel();
				System.out.printf("Bem-vindo %s!\n", nome);
				id = usuario.getId();
				break;
			}
		}

		if (!find) {
			System.out.println("Usuario não encontrado!");
		}
	}

	public static void exibirMenu() {
		Scanner sc = new Scanner(System.in);
		int opcao;
		switch (nivel) {
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
					// Atualizar dados
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
					// Atualizar dados
				} else if (opcao == 3) {
					// Criar relatórios
				} else if (opcao == 4) {
					// Visualizar Sensores
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
						3 - Criar Relatório de Atividades dos Cultivadores
						4 - Visualizar Dados Equipamentos
						5 - Cadastrar Estufa
						6 - Cadastrar Aluno
						0 - Sair
						Digite sua escolha:\s""");
				opcao = sc.nextInt();
				sc.nextLine();

				if (opcao == 1) {
					exibirDadosEstufas();
				} else if (opcao == 2) {
					// Atualizar dados
				} else if (opcao == 3) {
					// Criar relatórios
				} else if (opcao == 4) {
					// Visualizar Sensores
				} else if (opcao == 5) {
					// Cadastrar Estufas
				} else if (opcao == 6) {
					for(User usuario: users) {
						if(usuario.getId()==id) {
							Professor professor = (Professor) usuario;
							professor.cadastrarAluno(sc);
							break;
						}
					}
				} else if (opcao == 0) {
					System.out.println("Saindo...");
				} else {
					System.out.println("Escolha inválida! Digite novamente.");
				}
			}
			break;
		}
	}

	

	public static void cadastrarEstufa() {
		Scanner sc = new Scanner(System.in);
		try {
			System.out.println("Digite o tipo de plantação: ");
			String plantacao = sc.nextLine();
			Estufa estufa = new Estufa(plantacao);
			estufas.add(estufa);
			System.out.println("Id da estufa: " + estufa.getIdEstufa());
		} catch (Exception e) {
			System.out.println("Erro ao cadastrar estufa");

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

	public static void exibirDados() {
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
}