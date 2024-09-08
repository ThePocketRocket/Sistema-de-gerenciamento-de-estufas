package login;

import system.Estufa;

public class Professor {
    private Cadastro cadastro;

    public Professor(Cadastro cadastro) {
        this.cadastro = cadastro;
    }

    public void cadastraAluno(String nome, String senha, int id, int nivel, int idPlantio) {
        AlunoCultivador aluno = new AlunoCultivador(nome, senha, id, nivel, idPlantio);
        if (cadastro.validaCadastro(aluno)) {
            System.out.println("Aluno cadastrado com sucesso.");
        } else {
            System.out.println("Erro: aluno já cadastrado.");
        }
    }

    // Cadastro de uma nova estufa
    //public void cadastraEstufa(String nomeEstufa, int idEstufa, int idPlantio) {
    //Estufa estufa = new Estufa(nomeEstufa, idEstufa, idPlantio);
    //System.out.println("Estufa cadastrada: " + estufa.getNomeEstufa());
    //}
}

