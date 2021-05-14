package UML;

import java.time.LocalTime;


class Partido {
    private int idPartido;
    private LocalTime hora;

    
    public Partido(LocalTime hora) {
        this.hora = hora;
    }

    public int getIdPartido() {
        return idPartido;
    }
    
    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    
    
}
