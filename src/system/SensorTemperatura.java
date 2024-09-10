package system;

import java.util.Random;

public class SensorTemperatura extends Sensor {
	private double temperatura;

	public SensorTemperatura() {
		super();
		this.temperatura = new Random().nextDouble(10, 41);
	}

	public double getTemperatura() {
		return temperatura;
	}

	@Override
	public String toString() {
		return "Número de série: " + super.getNumSerie() +
				"\n		Temperatura: " + String.format("%.2f", this.temperatura) + "ºC";
	}
}
