package system;

public class CaixaAgua implements Notificacao{
	public static double agua = 2000;

	public double getAgua() {
		return agua;
	}

//metodo com prints provisorios
	public void encherCaixa(double agua) {
		CaixaAgua.agua += agua;
		if(CaixaAgua.agua >5000){
			CaixaAgua.agua = 5000;
			System.out.println("A caixa está cheia");
		}
		else {
			System.out.println("Enxendo...");
		}
	}

	public static void usarAgua(double agua) {
		if(CaixaAgua.agua > agua) {
			System.out.println("Foi usado; " + agua + "l da caixa principal ");
			CaixaAgua.agua -=agua;
	}
		else {
			System.out.println("Não há água suficiente.");
		}
	}
// Necessario repositorio de estufas
	@Override
	public void notificarTela() {
		if(agua <= 100) {
			System.out.println("O nivel de água está baixo.");
			// Desligar irrigadores a partir de um array de estufas.
		}
	}

	@Override
	public void notificarAdm() {

	}
}