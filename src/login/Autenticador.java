package login;

public class Autenticador extends User {
    public Autenticador(String nome, String senha, int id, int nivel) {
        super(nome, senha, id, nivel);
    }

    public boolean validaDados(String nome, String senha){
        return this.nome.equals(nome) && this.senha.equals(senha);

    }
}

