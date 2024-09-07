package system;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class Estufa {
    private static final AtomicInteger contador = new AtomicInteger(0);
    private int idEstufa;
    private ArrayList <Sensor> listaSensores = new ArrayList<>();
    private Plantio plantio;

    public Estufa(){
        this.idEstufa = contador.incrementAndGet();
        listaSensores.add(new SensorTemperatura());
        listaSensores.add(new SensorUmidadeSolo());
        listaSensores.add(new SensorUmidadeAr());
    }

    public double calculaFator() {
        return 0;
    }

    public void controlaIrrigadores(){

    }

    public int getIdEstufa() {
        return idEstufa;
    }

    @Override
    public String toString() {
        return "Estufa: " + this.idEstufa;
    }
}
