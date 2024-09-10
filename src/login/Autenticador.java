package login;


import java.util.ArrayList;

public class Autenticador {
       //Por a classe 'Menu' ser estatica e possuir metodo de fazer a autenticacao nela mesma
	//Torna essa uma classe inutil, caso nao achem maneiras de utiliza-la, podem apaga-la
	
public void Autenticar(ArrayList<User> users, String nome, String senha) {
	
	for(User a : users) {
		if(a.equals(nome) && (a.equals(senha))) {
			System.out.println("Entrando...");
		}
		else {
			System.out.println("Usuario n�o encontrado");
			break;
		}
	}}}