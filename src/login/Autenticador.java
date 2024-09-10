package login;

import java.util.ArrayList;

public class Autenticador {
       
	
public void Autenticar(ArrayList<User> users, String nome, String senha) {
	
	for(User a : users) {
		if(a.equals(nome) && (a.equals(senha))) {
			System.out.println("Entrando...");
		}
		else {
			System.out.println("Usuario não encontrado");
			break;
		}
	}
	
}
}