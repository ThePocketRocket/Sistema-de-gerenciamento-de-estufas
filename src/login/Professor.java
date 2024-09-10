package login;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import exceptions.AguaInsuficiente;
import main.Menu;
import system.Estufa;

public class Professor extends User {
    public Professor(String nome, String senha, int nivel) {
        super(nome, senha, nivel);
    }

    public static void cadastrarAluno(Scanner sc) {
		// esse Try-chatch
		// Possui o mesmo problema do primeiro, e encerra o metodo de cadastrar aluno
		try {
			System.out.print("Digite o nome do aluno: ");
			String nome = sc.nextLine();

			System.out.print("Digite a senha: ");
			String senha = sc.nextLine();

			int nivel;
			while (true) {
				System.out.print("Digite 1 para cadastrar um aluno cultivador ou 2 para cadastrar um aluno supervisor: ");
				nivel = sc.nextInt();
				sc.nextLine();

				if (nivel == 1 || nivel == 2) {
					break;
				} else {
					System.out.println("Inválido!");
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
		} catch (InputMismatchException e) {
			System.out.println("Erro: Entrada invalida");
			sc.nextLine();
		} catch (Exception p) {
			System.out.println("Erro inesperado");

		}
	}
    
    public static void cadastraEstufa(Scanner sc) throws AguaInsuficiente {
		System.out.print("Digite o nome da planta que vai ser cultivada na estufa: ");
		String nomePlanta = sc.nextLine();
		Estufa estufa = new Estufa(nomePlanta);
		Menu.estufas.add(estufa);
		System.out.println("\nEstufa cadastrada: " + estufa.getIdEstufa());
    }

    public static void colocarCultivadorPlantio(ArrayList<User> user1, ArrayList<Estufa> estufa1) {
    	System.out.println();
    	for (User a: user1) {
    		if(a.getNivel()==1) {
    			System.out.println("Alunos Cultivadores:\n"+
    		"Nome: "+ a.getNome()+ 
    		"\nID: "+ a.getId());
    		}
    		
    	}
    }
}

