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
}
