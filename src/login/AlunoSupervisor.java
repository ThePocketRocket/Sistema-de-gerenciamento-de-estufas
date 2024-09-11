package login;
import main.Menu;

import java.util.Scanner;

public class AlunoSupervisor extends User {
    public AlunoSupervisor(String nome, String senha, int nivel) {
        super(nome, senha, nivel);
    }

    public static void gerarRelatorioAluno(Scanner sc) {
        System.out.print("Digite o título do relatório: ");
        String titulo = sc.nextLine();
        System.out.print("Digite a descrição do relatório: ");
        String descricao = sc.nextLine();

        System.out.print("Digite o ID do Aluno: ");
        int idAluno = sc.nextInt();

        String nome = "Não encontrado";
        for (User aluno : Menu.users) {
            if (aluno.getId() == idAluno) {
                nome = aluno.getNome();
                break;
            }
        }
        System.out.printf("""
                Aluno: %s
                Título: %s
                Descrição: %s
                """, nome, titulo, descricao);
    }
}


