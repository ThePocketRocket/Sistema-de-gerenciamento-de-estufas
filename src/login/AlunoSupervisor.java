package login;
import system.Plantio;
public class AlunoSupervisor extends User {
	


    public AlunoSupervisor(String nome, String senha, int nivel) {

        super(nome, senha, nivel);
    }

    public String gerarRelatorioPlantio(Plantio p1) {
    	   System.out.println("O ID do Plantio é: " + p1.getIdPlantio() + "/n" + "O plantio é: " +
                   p1.getNomeEspecie() + "/n" + "As substâncias são: " + p1.getSubstancias() + "/n"
                   + "Inicio do plantio:" + p1.getInicio() + "/n" + " Data para colheita: " + p1.getFim());

    	
        // irei adicionar a geração do relatórioS
        return "Relatório de Plantio Gerado.";
    }

    public String gerarRelatorioAluno() {

        return "Relatório de Aluno Gerado.";
    }

}


