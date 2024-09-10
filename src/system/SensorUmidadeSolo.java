package system;

import java.util.Random;

public class SensorUmidadeSolo extends Sensor {
    private double umiSolo;

    public SensorUmidadeSolo() {
        super();
        this.umiSolo = new Random().nextDouble(0, 5);
    }

    public double getUmiSolo() {
        return umiSolo;
    }

    @Override
    public String toString() {
        return "N�mero de s�rie: " + super.getNumSerie() +
                "\n		Tens�o (Umidade solo): " + String.format("%.2f", this.umiSolo) + "V";
    }
}
