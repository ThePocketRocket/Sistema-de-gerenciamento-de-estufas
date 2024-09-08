package login;

public class AlunoSupervisor extends User {

    public AlunoSupervisor(String nome, String senha, int id, int nivel) {
        super(nome, senha, id, nivel);
    }

    public String gerarRelatorioPlantio() {
        // irei adicionar a geração do relatório
        return "Relatório de Plantio Gerado.";
    }

    public String gerarRelatorioAluno() {

        return "Relatório de Aluno Gerado.";
    }

}


