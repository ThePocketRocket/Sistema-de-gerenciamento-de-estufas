package login;

import java.util.InputMismatchException;
import java.util.Scanner;
import main.Menu;
import system.Estufa;

public class Professor extends User {
    public Professor(String nome, String senha, int nivel) {
        super(nome, senha, nivel);
    }

    public void cadastrarAluno(Scanner sc) {
		// esse Try-chatch
		// Possui o mesmo problema do primeiro, e encerra o metodo de cadastrar aluno
		try {
			System.out.print("Digite o nome do aluno: ");
			String nome = sc.nextLine();

			System.out.print("Digite a senha: ");
			String senha = sc.nextLine();

			System.out.print("Digite 1 para cadastrar um aluno cultivador ou 2 para cadastrar um aluno supervisor: ");
			int nivel = sc.nextInt();
			sc.nextLine();

			while ((nivel != 1) && (nivel != 2)) {
				System.out.println("Nível inválido. Por favor, escolha 1 ou 2.");
				System.out.println();

				System.out.println("Digite uma opcao valida: 1 para cultivador ou 2 para supervisor");
				nivel = sc.nextInt();
			}
			if (nivel == 1) {
				AlunoCultivador aluno1 = new AlunoCultivador(nome, senha, nivel);
				Menu.users.add(aluno1);
				System.out.println("Aluno cultivador cadastrado com sucesso!");
			} else if (nivel == 2) {
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
    
    public void cadastraEstufa() {
    Estufa estufa = new Estufa("tomate");
    System.out.println("Estufa cadastrada: " + estufa.getIdEstufa());
    }
}

