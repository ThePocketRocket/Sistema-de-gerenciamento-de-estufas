package login;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class User {
    private ArrayList<User> users = new ArrayList<>();
    private String nome;
    private String senha;
    private static final AtomicInteger contador = new AtomicInteger(0);
    private int id;
    private int nivel;

    public User(String nome, String senha, int nivel) {
        this.nome = nome;
        this.senha = senha;
        this.id = contador.incrementAndGet();
        this.nivel = nivel;
    }
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getId() {
        return id;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

}
