package UML;

import java.time.LocalTime;


public class Partido {
    private int idPartido;
    private LocalTime hora;
    private Jornada jornada;


    public Partido() {
    }

    public Partido(LocalTime hora, Jornada jornada) {
        this.hora = hora;
        this.jornada = jornada;
    }

    public int getIdPartido() {
        return idPartido;
    }

    public void setIdPartido(int idPartido) {
        this.idPartido = idPartido;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public Jornada getJornada() {
        return jornada;
    }

    public void setJornada(Jornada jornada) {
        this.jornada = jornada;
    }

    
    
   
    public Partido(LocalTime hora, Jornada jornada) {
        this.hora = hora;
        this.jornada = jornada;
    }
}
