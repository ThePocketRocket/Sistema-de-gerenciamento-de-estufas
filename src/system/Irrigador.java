package system;

public class Irrigador extends Sensor {
	// Nao sei o calculo de vazao
	double vazao;
	double tempo;
	boolean estado = false;

	public double getVazao() {
		return vazao;
	}

// Definir a vazao de agua
	public void setVazao(double vazao) {
		this.vazao = vazao;
	}

	public double getTempo() {
		return tempo;
	}

// Definir a quantidade de tempo em que o irrigador estara ligado
	public void setTempo(double tempo) {
		this.tempo = tempo;
	}

	public boolean isEstado() {
		return estado;
	}
//
	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	
	// respectivamente ligar e desligar os irrigadores
	// Nao sei se sera usada essa implementacao 
	// Estejam livres para apagar esta area abaixo
	public void ligar(boolean estado) {
		if (this.estado == false) {
			this.estado = true;
			System.out.println("O irrigador foi ligado");
		} else {
			System.out.println("O irrigador ja esta ligado");
		}
		;
	}

	public void desligar(boolean estado) {
		if (this.estado == false) {
			System.out.println("O irrigador ja esta desligado");
		} else {
			this.estado = false;
			System.out.println("O irrigador foi desligado");
		}
	}
}