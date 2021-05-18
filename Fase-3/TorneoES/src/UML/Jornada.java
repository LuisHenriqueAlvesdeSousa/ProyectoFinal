package UML;

import java.time.LocalDate;
import java.util.ArrayList;


public class Jornada {
    private int idJornada;
    private LocalDate fecha;
    private Torneo torneo;
    ArrayList<Partido> partidos;

    public Jornada(LocalDate fecha, Torneo torneo) {
        this.fecha = fecha;
        this.torneo = torneo;
    }

    public Jornada() {
    }
    
    public void addPartido(Partido p){
        this.partidos.add(p);
    }
    
    public void setPartidos(ArrayList<Partido> p){
        this.partidos = p;
    }
    
    public ArrayList<Partido> getPartidos(){
        return this.partidos;
    }

    public int getIdJornada() {
        return idJornada;
    }

    public void setIdJornada(int idJornada) {
        this.idJornada = idJornada;
    }

    public Torneo getTorneo() {
        return torneo;
    }

    public void setTorneo(Torneo torneo) {
        this.torneo = torneo;
    }

    

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
    
    
}
