package main;

import java.util.ArrayList;
import java.util.Scanner;

import login.*;

//Apenas para testar o cadastro
//sera reformulado
public class Menu {

	public static ArrayList<AlunoCultivador> alunoCultivador = new ArrayList<>();

//Apenas para testes

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// Cadastrar alunos
		System.out.println("Menu\n" + "Digite o numero correspondente a opcao que deseja realizar\n"
				+ "1 - cadastrar um novo aluno\n" + "2 - ver dados");
		int opt = sc.nextInt();

		sc.nextLine();
		
		if (opt == 1) {
			cadastrarAluno(sc);
		}

	}

	public static void cadastrarAluno(Scanner sc) {
		System.out.println("Digite o nome do aluno:");
		String nome = sc.nextLine();


		System.out.println("Digite a senha");
		String senha = sc.nextLine();

		
		System.out.println("ID");
		int id = sc.nextInt();

		
		System.out.println("Nivel");
		int nivel = sc.nextInt();

		
		int idPl = 1;

		if (nivel == 1) {
			AlunoCultivador aluno = new AlunoCultivador(nome, senha, id, nivel, idPl);

			alunoCultivador.add(aluno);

			System.out.println("cadastrado");

		}

		for (AlunoCultivador a : alunoCultivador) {
			System.out.println("nome: " + a.getNome() + " ID: " + a.getId());
		}

	}
	
}
