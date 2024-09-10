package system;

import java.util.Random;

public class SensorUmidadeAr extends Sensor{
    private double umiAr;

    public SensorUmidadeAr() {
        super();
        this.umiAr = new Random().nextDouble(0, 100);
    }

    public double getUmiAr() {
        return umiAr;
    }

    @Override
    public String toString() {
        return "Número de série: " + super.getNumSerie() +
                "\n		Umidade do Ar: " + String.format("%.2f", this.umiAr) + "%";
    }
}
