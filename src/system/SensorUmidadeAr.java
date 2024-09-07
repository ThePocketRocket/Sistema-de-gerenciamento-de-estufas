package system;

import java.util.Random;

public class SensorUmidadeAr extends Sensor{
    private double umiAr;

    public SensorUmidadeAr() {
        super();
        this.umiAr = new Random().nextDouble(0, 100);
    }

    public double getUmiSolo() {
        return umiAr;
    }
}
