package system;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class Estufa {
    private static final AtomicInteger contador = new AtomicInteger(0);
    private final int idEstufa;
    private ArrayList <Sensor> listaSensores = new ArrayList<>();
    private Plantio plantio;
    private ArrayList <Irrigador> irrigadores = new ArrayList<>();
    private double fatorControle;

    public Estufa(String nomeSubPlantio){
        this.idEstufa = contador.incrementAndGet();

        this.plantio = new Plantio(nomeSubPlantio);

        this.listaSensores.add(new SensorTemperatura());
        this.listaSensores.add(new SensorUmidadeSolo());
        this.listaSensores.add(new SensorUmidadeAr());

        for (int i = 0; i < 5; i++) {
            this.irrigadores.add(new Irrigador());
        }

        calculaFator();
        controlaIrrigadores();
    }

    public int getIdEstufa() {
        return idEstufa;
    }

    public double getFatorControle() {
        calculaFator();
        return fatorControle;
    }

    public Plantio getPlantio() {
        return plantio;
    }

    public ArrayList<Irrigador> getIrrigadores() {
        return irrigadores;
    }

    public ArrayList<Sensor> getListaSensores() {
        return listaSensores;
    }

    public void calculaFator() {
        double normTemp = ((SensorTemperatura) listaSensores.get(0)).getTemperatura();
        double normUmiSolo = ((SensorUmidadeSolo) listaSensores.get(1)).getUmiSolo();
        double normUmiAr = ((SensorUmidadeAr) listaSensores.get(2)).getUmiAr();

        normTemp = (normTemp - 10) / 30;
        normUmiSolo = (5 - normUmiSolo) / 5;
        normUmiAr = (100 - normUmiAr) / 100;

        this.fatorControle = (normTemp + normUmiSolo + normUmiAr) / 3;
    }

    public void controlaIrrigadores(){
        if (this.fatorControle >= 0.7) {
            for (Irrigador irrigador: irrigadores) {
                irrigador.setTempo(30);
                irrigador.setVazao(5);
                irrigador.ligar();
                CaixaAgua.usarAgua(irrigador.getVazao() * irrigador.getTempo());
            }
        } else if (this.fatorControle >= 0.5) {
            for (Irrigador irrigador: irrigadores) {
                irrigador.setTempo(15);
                irrigador.setVazao(3);
                irrigador.ligar();
                CaixaAgua.usarAgua(irrigador.getVazao() * irrigador.getTempo());
            }
        }
    }

    // Corrigir implementação
    @Override
    public String toString() {
        return "Estufa: " + this.idEstufa +
                "\nPlantio: " + plantio.getIdPlantio() +
                "\nIrrigadores: " + irrigadores.toString() +
                "\nSensores: " +
                "\n     " + listaSensores.get(0).toString() +
                "\n     " + listaSensores.get(1).toString() +
                "\n     " + listaSensores.get(2).toString();
    }
}
