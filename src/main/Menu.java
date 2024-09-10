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

		int opcao = -1;
		
		while (opcao != 0) {
			exibirMenu();

			opcao = sc.nextInt();
			sc.nextLine();

			switch (opcao) {
				case 1:
					cadastrarAluno(sc);
					break;
				case 2:
					login(users);
					break;
				case 3:
					exibirDados();
					break;
				case 4:
					cadastrarEstufa();
					break;
				case 5:
					exibirDadosEstufas();
					break;
				case 6:
					System.out.println("Encerrando o programa.");
					break;
				default:
					System.out.println("Opção inválida.");
			}
		}

		sc.close();
	}

	public static void exibirMenu() {
		System.out.println("\nMENU\n");
		System.out.println("Selecione a opção desejada:");
		System.out.println("1 - Cadastrar um novo aluno");
		System.out.println("2 - Logar no sistema");
		System.out.println("3 - Ver dados dos alunos");
		System.out.println("4 - Cadastrar Estufa");
		System.out.println("5 - Ver dados das estufas cadastradas");
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

		while ((nivel != 1) && (nivel != 2)){
			System.out.println("Nível inválido. Por favor, escolha 1 ou 2.");
			System.out.println();
			
			System.out.println("Digite uma opcao valida: 1 para cultivador ou 2 para supervisor");
			nivel = sc.nextInt();
		}
		if (nivel == 1) {
			AlunoCultivador aluno1 = new AlunoCultivador(nome, senha, nivel);
			users.add(aluno1);
			System.out.println("Aluno cultivador cadastrado com sucesso!");
		} else if (nivel == 2) {
			AlunoSupervisor aluno2 = new AlunoSupervisor(nome, senha, nivel);
			users.add(aluno2);
			System.out.println("Aluno supervisor cadastrado com sucesso!");
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
					System.out.println("Nome: " + aluno.getNome() + " | ID: " + aluno.getId()+ "| Tipo: Supervisor");
				}
			}
		}
	}

	public static void login(ArrayList<User> users) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Digite seu nome: ");
		String nome = sc.nextLine();
		
		System.out.println("Digite sua senha: ");
		String senha = sc.nextLine();
		
		boolean find = false;
		
		for(User a: users) {
			if((a.getNome().equals(nome))&&(a.getSenha().equals(senha))) {
				System.out.println("Bem vindo(a): "+ a.getNome());
				
				find = true;
				break;
				
			}
		}
			if (!find){
				System.out.println("Usuario não encontrado!");
			}
		
	}
}