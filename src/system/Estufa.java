package system;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class Estufa {
    private static final AtomicInteger contador = new AtomicInteger(0);
    private int idEstufa;
    private ArrayList <Sensor> listaSensores = new ArrayList<>();
    private Plantio plantio;
    private double fatorControle;

    public Estufa(){
        this.idEstufa = contador.incrementAndGet();
        listaSensores.add(new SensorTemperatura());
        listaSensores.add(new SensorUmidadeSolo());
        listaSensores.add(new SensorUmidadeAr());
    }

    public int getIdEstufa() {
        return idEstufa;
    }

    public double getFatorControle() {
        calculaFator();
        return fatorControle;
    }

    public void calculaFator() {
        double normTemp = ((SensorTemperatura) listaSensores.get(0)).getTemperatura();
        double normUmiSolo = ((SensorUmidadeSolo) listaSensores.get(2)).getUmiSolo();
        double normUmiAr = ((SensorUmidadeAr) listaSensores.get(1)).getUmiAr();

        normTemp = (normTemp - 10) / 30;
        normUmiSolo = (5 - normUmiSolo) / 5;
        normUmiAr = (100 - normUmiAr) / 100;

        this.fatorControle = (normTemp + normUmiSolo + normUmiAr) / 3;
    }

    public void controlaIrrigadores(){

    }

    @Override
    public String toString() {
        return "Estufa: " + this.idEstufa;
    }
}
