package system;

import java.util.Random;

public class SensorTemperatura extends Sensor {
	private double temperatura;

	// Construtores
	public SensorTemperatura() {
		super();
		this.temperatura = new Random().nextDouble(10, 31);
	}

	// Métodos
	public double getTemperatura() {
		return temperatura;
	}
}
