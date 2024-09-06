package system;

public class SensorTemperatura extends ISensores {
double temperatura;
	public SensorTemperatura(int id, int numSerie, double temperatura) {
		super(id, numSerie);
		this.temperatura = temperatura;
	}
	public double getTemperatura() {
		return temperatura;
	}
	public void setTemperatura(double temperatura) {
		this.temperatura = temperatura;
	};
	

}
