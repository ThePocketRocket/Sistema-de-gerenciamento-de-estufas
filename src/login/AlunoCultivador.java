package login;


public class AlunoCultivador extends User {
    private int idPlantio;

    public AlunoCultivador(String nome, String senha, int nivel) {

        super(nome, senha, nivel);
    }

    public int getIdPlantio() {
        return idPlantio;
    }

    public void setIdPlantio(int idPlantio) {
        this.idPlantio = idPlantio;
    }
}