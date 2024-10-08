package login;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import exceptions.AguaInsuficiente;
import exceptions.inputVazioException;
import main.Menu;
import system.Estufa;
import system.Plantio;

public class Professor extends User {
	public Professor(String nome, String senha, int nivel) {
		super(nome, senha, nivel);
	}

	public static void cadastrarAluno(Scanner sc) {

		while (true) {
			try {
				System.out.print("Digite o nome do aluno: ");
				String nome = sc.nextLine();

				System.out.print("Digite a senha: ");
				String senha = sc.nextLine();

				if(nome == null || nome.trim().isEmpty() || senha == null || senha.trim().isEmpty()){
					throw new inputVazioException("Nome ou senha nao podem ser vazio(s)");
				}
				
				int nivel;
				while (true) {
					try {

						System.out.print(
								"Digite 1 para cadastrar um aluno cultivador ou 2 para cadastrar um aluno supervisor: ");
						nivel = sc.nextInt();
						sc.nextLine();

						if (nivel == 1 || nivel == 2) {
							break;
						} else {
							System.out.println("Inválido!");
						}
					} catch (InputMismatchException e) {
						System.out.println("Erro: Entrada inválida, digite um número.");
						sc.nextLine();
					}
				}

				if (nivel == 1) {
					AlunoCultivador aluno1 = new AlunoCultivador(nome, senha, nivel);
					Menu.users.add(aluno1);
					System.out.println("Aluno cultivador cadastrado com sucesso!");
				} else {
					AlunoSupervisor aluno2 = new AlunoSupervisor(nome, senha, nivel);
					Menu.users.add(aluno2);
					System.out.println("Aluno supervisor cadastrado com sucesso!");
				}
				break;
			}catch(inputVazioException e) {
				System.out.println("erro: "+ e.getMessage());
			}
			
			catch (Exception p) {
				System.out.println("Erro generico");

			}
		}
	}

	public static void cadastraEstufa(Scanner sc) throws AguaInsuficiente {
		while(true) {
		System.out.print("Digite o nome da planta que vai ser cultivada na estufa: ");
		String nomePlanta = sc.nextLine();
		if(nomePlanta.trim().isEmpty()) {
			System.out.println("Por favor, Digite um nome da planta que será plantada:");
			continue;
		}
		
		Estufa estufa = new Estufa(nomePlanta);
		Menu.estufas.add(estufa);
		System.out.println("\nEstufa cadastrada: " + estufa.getIdEstufa());
		break;
	}
	}

	public static void colocarCultivadorPlantio(int idAluno, int idPlantio) {
		for (Estufa estufa : Menu.estufas) {
			if (estufa.getPlantio().getIdPlantio() == idPlantio) {
				for (User aluno : Menu.users) {
					if ((aluno instanceof AlunoCultivador) && aluno.getId() == idAluno) {
						((AlunoCultivador) aluno).setIdPlantio(idPlantio);
						System.out.println(aluno.getNome() + "cadastrado no plantio " + estufa.getPlantio().getIdPlantio());
					}
				}
			}
		}
	}
}
