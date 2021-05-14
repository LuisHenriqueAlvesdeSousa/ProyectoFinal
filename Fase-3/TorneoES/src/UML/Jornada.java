package UML;

import java.time.LocalDate;
import java.util.ArrayList;


public class Jornada {
    private int idJornada;
    private LocalDate fecha;
    private int idTorneo;
    ArrayList<Partido> partidos;

    public Jornada(LocalDate fecha) {
        partidos = new ArrayList();
        this.fecha = fecha;
    }

    public Jornada() {
    }
    
    public void addPartido(Partido p){
        this.partidos.add(p);
    }
    
    public void setPartidos(ArrayList<Partido> p){
        this.partidos = p;
    }

    public int getIdJornada() {
        return idJornada;
    }

    public void setIdJornada(int idJornada) {
        this.idJornada = idJornada;
    }

    public int getIdTorneo() {
        return idTorneo;
    }

    public void setIdTorneo(int idTorneo) {
        this.idTorneo = idTorneo;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
    
    
}
