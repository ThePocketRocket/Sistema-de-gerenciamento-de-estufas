package main;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import login.*;
import system.*;

public class Menu {

	public static ArrayList<User> users = new ArrayList<>();
	public static ArrayList<Estufa> estufas = new ArrayList<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//Try catch do menu
try {
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
				case 0:
					System.out.println("Saindo");
					break;
				default:
					System.out.println("Opção inválida.");
			}
		}//Nao consegui fazer com que se encaixasse no loop e voltasse a printar o menu
		}catch(InputMismatchException e){
			System.out.println("Dado inserido é invalido, Por favor insira um número");
			sc.nextLine();
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
		//esse Try-chatch
		//Possui o mesmo problema do primeiro, e encerra o metodo de cadastrar aluno
		try{
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
			users.add(aluno1);
			System.out.println("Aluno cultivador cadastrado com sucesso!");
		} else if (nivel == 2) {
			AlunoSupervisor aluno2 = new AlunoSupervisor(nome, senha, nivel);
			users.add(aluno2);
			System.out.println("Aluno supervisor cadastrado com sucesso!");
		}
		}catch(InputMismatchException e) {
			System.out.println("Erro: Entrada invalida");
			sc.nextLine();
		}
		catch(Exception p){
			System.out.println("Erro inesperado");
			
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
		}catch(Exception e) {
			System.out.println("Erro ao cadastrar estufa");
			
		}
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
					System.out.println("Nome: " + aluno.getNome() + " | ID: " + aluno.getId() + "| Tipo: Supervisor");
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

		for (User a : users) {
			if ((a.getNome().equals(nome)) && (a.getSenha().equals(senha))) {
				System.out.println("Bem vindo(a): " + a.getNome());

				find = true;
				break;

			}
		}
		if (!find) {
			System.out.println("Usuario não encontrado!");
		}

	}
}