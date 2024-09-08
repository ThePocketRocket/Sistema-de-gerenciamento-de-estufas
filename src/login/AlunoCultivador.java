package login;

public class AlunoCultivador extends User {
    private int idPlantio;

    public AlunoCultivador(String nome, String senha, int id, int nivel, int idPlantio) {
        super(nome, senha, id, nivel);
        this.idPlantio = idPlantio;
    }

    public int getIdPlantio() {
        return idPlantio;
    }

    public void setIdPlantio(int idPlantio) {
        this.idPlantio = idPlantio;
    }
}