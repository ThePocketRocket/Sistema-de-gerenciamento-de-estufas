package login;

import system.Estufa;

public class Professor {
    private Cadastro cadastro;

    public Professor(Cadastro cadastro) {
        this.cadastro = cadastro;
    }

    public void cadastraAluno(String nome, String senha, int nivel, int idPlantio) {
        AlunoCultivador aluno = new AlunoCultivador(nome, senha, nivel, idPlantio);
        if (cadastro.validaCadastro(aluno)) {
            System.out.println("Aluno cadastrado com sucesso.");
        } else {
            System.out.println("Erro: aluno já cadastrado.");
        }
    }

    public void cadastraEstufa() {
    Estufa estufa = new Estufa("tomate");
    System.out.println("Estufa cadastrada: " + estufa.getIdEstufa());
    }
}

