package login;

import system.Estufa;

public class Professor extends User {
    public Professor(String nome, String senha, int nivel) {
        super(nome, senha, nivel);
    }

    /*
    public void cadastraAluno(String nome, String senha, int nivel) {
        AlunoCultivador aluno = new AlunoCultivador(nome, senha, nivel);
        if (cadastro.validaCadastro(aluno)) {
            System.out.println("Aluno cadastrado com sucesso.");
        } else {
            System.out.println("Erro: aluno já cadastrado.");
        }
    }
     */

    public void cadastraEstufa() {
    Estufa estufa = new Estufa("tomate");
    System.out.println("Estufa cadastrada: " + estufa.getIdEstufa());
    }
}

