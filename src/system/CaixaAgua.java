package system;

import main.Menu;

public class CaixaAgua implements Notificacao{
	public static double agua = 2000;

	public double getAgua() {
		return agua;
	}

//metodo com prints provisorios
	public void encherCaixa(double agua) {
		CaixaAgua.agua += agua;
		if(CaixaAgua.agua > 2000){
			CaixaAgua.agua = 2000;
			System.out.println("A caixa est� cheia");
		}
		else {
			System.out.println("Enxendo...");
		}
	}

	public static void usarAgua(double agua) {
		if(CaixaAgua.agua > agua) {
			System.out.println("Foi usado: " + agua + "l da caixa principal ");
			CaixaAgua.agua -=agua;
	}
		else {
			desligarIrrigadores();
		}
	}

	public static void desligarIrrigadores() {
		for (Estufa estufa: Menu.estufas) {
			for (Irrigador irrigador: estufa.getIrrigadores()) {
				irrigador.setTempo(0);
				irrigador.setVazao(0);
				irrigador.desligar();
			}
		}
	}
// Necessario repositorio de estufas
	@Override
	public void notificarTela() {
		if(agua <= 100) {
			System.out.println("O nivel de �gua est� baixo.");
			desligarIrrigadores();
		}
	}

	@Override
	public void notificarAdm() {
		
	}
}