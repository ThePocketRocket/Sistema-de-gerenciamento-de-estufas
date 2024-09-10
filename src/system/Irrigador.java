package system;

import java.util.concurrent.atomic.AtomicInteger;

public class Irrigador extends Sensor {
	// Nao sei o calculo de vazao
	private double vazao;
	private double tempo;
	private boolean estado = false;
	private static final AtomicInteger contador = new AtomicInteger(1000);
	private int numSerie;

	public Irrigador () {
		this.numSerie = contador.incrementAndGet();
	}

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
		return "\n		Irrigador " + numSerie +
				"\n		Vazão=" + vazao +
				"\n		Tempo=" + tempo +
				"\n		Estado=" + estado;
	}
}