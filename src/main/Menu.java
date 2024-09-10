package main;

import java.util.ArrayList;
import java.util.Scanner;
import login.*;
import system.*;

public class Menu {

	public static ArrayList<User> users = new ArrayList<>();
	public static ArrayList<Estufa> estufas = new ArrayList<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean continuar = true;

		while (continuar) {
			exibirMenu();

			int opcao = sc.nextInt();
			sc.nextLine();

			switch (opcao) {
				case 1:
					cadastrarAluno(sc);
					break;
				case 2:
					exibirDados();
					break;
				case 3:
					cadastrarEstufa();
					break;
				case 4:
					exibirDadosEstufas();
					break;
				case 0:
					continuar = false;
					System.out.println("Encerrando o programa.");
					break;
				default:
					System.out.println("Opção inválida.");
			}
		}

		sc.close();
	}

	public static void exibirMenu() {
		System.out.println("\nMENU");
		System.out.println("Selecione a opção desejada:");
		System.out.println("1 - Cadastrar um novo aluno");
		System.out.println("2 - Ver dados dos alunos");
		System.out.println("3 - Cadastrar Estufa");
		System.out.println("4 - Ver dados das estufas cadastradas");
		System.out.println("0 - Sair");
		System.out.print("Digite sua escolha: ");
	}

	public static void cadastrarAluno(Scanner sc) {
		System.out.print("Digite o nome do aluno: ");
		String nome = sc.nextLine();

		System.out.print("Digite a senha: ");
		String senha = sc.nextLine();

		System.out.print("Digite 1 para cadastrar um aluno cultivador ou 2 para cadastrar um aluno supervisor: ");
		int nivel = sc.nextInt();
		sc.nextLine();

		int idPl = 1;

		if (nivel == 1) {
			AlunoCultivador aluno1 = new AlunoCultivador(nome, senha, nivel, idPl);
			users.add(aluno1);
			System.out.println("Aluno cultivador cadastrado com sucesso!");
		} else if (nivel == 2) {
			AlunoSupervisor aluno2 = new AlunoSupervisor(nome, senha, nivel);
			users.add(aluno2);
			System.out.println("Aluno supervisor cadastrado com sucesso!");
		} else {
			System.out.println("Nível inválido. Por favor, escolha 1 ou 2.");
		}
	}

	public static void cadastrarEstufa() {
		Estufa estufa = new Estufa("tomate");
		estufas.add(estufa);
		System.out.println("Id da estufa: " + estufa.getIdEstufa());
	}

	public static void exibirDadosEstufas() {
		if (estufas.isEmpty()) {
			System.out.println("Nenhuma estufa cadastrada.");
		} else {
			System.out.println("Dados das Estufas:");
			for (Estufa estufa : estufas) {
				System.out.println("Id da Estufa: " + estufa.getIdEstufa());
				System.out.println("Plantio:" + estufa.getPlantio());
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
					System.out.println("Nome: " + aluno.getNome() + " | Tipo: Supervisor");
				}
			}
		}
	}
}