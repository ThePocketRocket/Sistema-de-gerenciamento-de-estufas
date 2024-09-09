package system;

public class Irrigador extends Sensor {
	// Nao sei o calculo de vazao
	private double vazao;
	private double tempo;
	private boolean estado = false;

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

	public void ligar() {
		if (this.estado) {
			System.out.println("Já está ligado");
		} else{
			this.estado = true;
		}
	}

	public void desligar(boolean estado) {
		if (!this.estado) {
			System.out.println("Já está desligado");
		} else {
			this.estado = false;
		}
	}

	@Override
	public String toString() {
		return "Irrigador{" +
				"vazao=" + vazao +
				", tempo=" + tempo +
				", estado=" + estado +
				'}';
	}
}