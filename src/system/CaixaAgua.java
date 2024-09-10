package system;

public class CaixaAgua {
double agua = 5000;

public double getAgua() {
	return agua;
}

//metodo com prints provisorios
public void enxerCaixa(double agua) {
	this.agua += agua;
	if(this.agua >5000){
		this.agua=5000;
		System.out.println("A caixa está cheia");
	}
	else {
		System.out.println("Enxendo...");
	}
}

public void usarAgua(double agua) {
	if(this.agua>agua) {
		System.out.println("Foi usado; "+agua+"l da caixa principal ");
		this.agua -=agua;
}
	else {
		System.out.println("nao ha agua suficiente");
	}
}
//Necessario repositorio de estufas
public void notificarTela() {
	if(this.agua <= 100) {
		System.out.println("O nivel de agua esta pouco");
		
	}
}



}
