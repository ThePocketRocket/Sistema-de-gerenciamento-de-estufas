package login;

import main.Menu;

import java.util.InputMismatchException;
import java.util.Scanner;

import exceptions.inputVazioException;

public class AlunoSupervisor extends User {
	public AlunoSupervisor(String nome, String senha, int nivel) {
		super(nome, senha, nivel);
	}

	public static void gerarRelatorioAluno(Scanner sc) {

		System.out.print("Digite o título do relatório: ");
		
			String titulo = sc.nextLine();
			System.out.print("Digite a descrição do relatório: ");
			String descricao = sc.nextLine();

			String nome = "Não encontrado";
			
			
			boolean idfind = false;
			while(!idfind) {
				try {
			System.out.print("Digite o ID do Aluno: ");
			int idAluno = sc.nextInt();
				sc.nextLine();
				
			
			for (User aluno : Menu.users) {
				if (aluno.getId() == idAluno) {
					nome = aluno.getNome();
					idfind = true;
					break;
				}
			}
			}catch(InputMismatchException e) {
				System.out.println("Erro: id invalido, coloque um id valido");
				sc.nextLine();
			}
				}
		
			System.out.printf("""
					Aluno: %s
					Título: %s
					Descrição: %s
					""", nome, titulo, descricao);
				
		}
}