package system;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicInteger;

public class Plantio {
    private static final AtomicInteger contador = new AtomicInteger(0);
    private int idPlantio;
    private ArrayList <String> substancias = new ArrayList<>();
    private String nomeEspecie;
    private String inicio, fim;

    public Plantio (String nomeEspecie) {
        this.idPlantio = contador.incrementAndGet();
        this.nomeEspecie = nomeEspecie;
        this.inicio = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
    }

    public void setNomeEspecie(String nomeEspecie) {
        this.nomeEspecie = nomeEspecie;
    }

    public void setInicio() {
        this.inicio = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
    }

    public void setFim() {
        this.fim = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
    }

    public void setSubstancias(String substancia) {
        substancias.add(substancia);
    }

    public int getIdPlantio() {
        return idPlantio;
    }

    public ArrayList<String> getSubstancias() {
        return (ArrayList<String>) Collections.unmodifiableList(new ArrayList<>(this.substancias));
    }

    public String getNomeEspecie() {
        return nomeEspecie;
    }

    public String getInicio() {
        return inicio;
    }

    public String getFim() {
        return fim;
    }
}
