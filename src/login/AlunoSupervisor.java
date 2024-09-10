package login;

public class AlunoSupervisor extends User {
    public AlunoSupervisor(String nome, String senha, int nivel) {

        super(nome, senha, nivel);
    }

    public String gerarRelatorioPlantio() {
        // irei adicionar a geração do relatórioS
        return "Relatório de Plantio Gerado.";
    }

    public String gerarRelatorioAluno() {

        return "Relatório de Aluno Gerado.";
    }
}


