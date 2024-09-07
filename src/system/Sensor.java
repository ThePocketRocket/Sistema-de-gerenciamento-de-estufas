package system;

import java.util.concurrent.atomic.AtomicInteger;

public class Sensor {
	private static final AtomicInteger contador = new AtomicInteger(1000);
	private int numSerie;

	public Sensor() {
		this.numSerie = contador.incrementAndGet();
	}

	public int getNumSerie() {
		return numSerie;
	}
}
