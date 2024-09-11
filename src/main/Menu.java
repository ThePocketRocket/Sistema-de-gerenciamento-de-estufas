package main;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import exceptions.AguaInsuficiente;
import exceptions.inputVazioException;
import login.*;
import system.*;

public class Menu {

	public static ArrayList<User> users = new ArrayList<>();
	public static ArrayList<Estufa> estufas = new ArrayList<>();
	private static User usuarioLogado;

	public static void main(String[] args) throws AguaInsuficiente {
		users.add(new Professor("Eduardo", "Eduardo123", 3));
		users.add(new AlunoSupervisor("Monica", "Monica123", 2));
		users.add(new AlunoCultivador("Cebolinha", "Cebolinha123", 1));

		login();

		exibirMenu();
	}

	public static void login() {
		Scanner sc = new Scanner(System.in);

		boolean find = false;
		while (!find) {
			try {
				System.out.print("""
						Faça seu login para continuar.
						Digite seu nome:\s""");
				String nome = sc.nextLine();

				System.out.print("Digite sua senha: ");
				String senha = sc.nextLine();

				if (nome.isEmpty() || senha.isEmpty()) {
					throw new inputVazioException("Nome e senha nao podem estar vazios");
				}

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
			}catch(inputVazioException e) {
				System.out.println("Erro: " + e.getMessage());
			}
			catch (Exception e) {
				System.out.println("Erro: gererico");
			}

		}
	}

	public static void exibirMenu() throws AguaInsuficiente {
		Scanner sc = new Scanner(System.in);
		int opcao;
		switch (usuarioLogado.getNivel()) {
			case 1:
				opcao = -1;
				while (opcao != 0) {
					try {
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

					}catch (InputMismatchException e) {
                        System.out.println("Erro: Entrada invalida, digite um numero.");
                        sc.nextLine();
					}catch (NoSuchElementException e) {
						System.out.println("Erro: Entrada vazia.");
						sc.nextLine();
					}
				}
				break;

			case 2:
				opcao = -1;
				while (opcao != 0) {
					try {
						System.out.print("""
								1 - Visualizar Informações de Estufas
								2 - Atualizar Dados do Plantio
								3 - Criar Relatório de Atividades dos Cultivadores
								4 - Visualizar Dados Equipamentos
								5 - Exibir alunos cadastrados
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
						} else if (opcao == 5) {
							exibirDadosAlunos();
						} else if (opcao == 0) {
							System.out.println("Saindo...");
						} else {
							System.out.println("Escolha invalida! Digite novamente.");
						}
					} catch (InputMismatchException e) {
						System.out.println("Erro: Entrada invalida, Digite um numero");
						sc.nextLine();
					} catch (NoSuchElementException e) {
						System.out.println("Erro: Entrada vazia.");
						sc.nextLine();
					}
				}
				break;

			case 3:
				opcao = -1;
				while (opcao != 0) {
					try {
						System.out.print("""
								1 - Visualizar Informações de Estufas
								2 - Atualizar Dados do Plantio
								3 - Visualizar Dados Equipamentos
								4 - Cadastrar Estufa
								5 - Cadastrar Aluno
								6 - Exibir alunos cadastrados
								7 - Designar aluno cultivador para plantio
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
						} else if (opcao == 6) {
							//Incompleto (Metodo esta no Professor)
							exibirDadosAlunos();
						}else if (opcao == 7) {
							while(true) {
								try {
									
							System.out.print("Digite o ID do Aluno: ");
							int idAluno = sc.nextInt();
							sc.nextLine();
							System.out.print("Digite o ID do Plantio: ");
							int idPlantio = sc.nextInt();
							sc.nextLine();
							Professor.colocarCultivadorPlantio(idAluno, idPlantio);
							}catch(InputMismatchException e) {
								System.out.println("Erro: Digite um numero!");
								sc.nextLine();
							}
							}
						} else if (opcao == 0) {
							System.out.println("Saindo...");
						} else {
							System.out.println("Escolha inválida! Digite novamente.");
						}
					}catch (InputMismatchException e) {
                        System.out.println("Erro: Entrada inválida, digite um numero.");
                        sc.nextLine();
					} catch (NoSuchElementException e) {
                        System.out.println("Erro: Entrada vazia.");
                        sc.nextLine();
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
			try {
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
			} catch (InputMismatchException e) {
				System.out.println("Erro: Entrada inválida, digite um número.");
				sc.nextLine();
			} catch (NoSuchElementException e) {
				System.out.println("Erro: Entrada vazia.");
				sc.nextLine();
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