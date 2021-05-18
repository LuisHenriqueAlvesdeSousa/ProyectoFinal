package UML;

import java.time.LocalTime;


public class Partido {
    private int idPartido;
    private Jornada jornada;
    private LocalTime hora;

    public Partido(Jornada jornada, LocalTime hora) {
        this.jornada = jornada;
        this.hora = hora;
    }

    public Partido() {
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

    
    
    
}
