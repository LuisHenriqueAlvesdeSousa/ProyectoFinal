package UML;

public class PartidoJugado {
    private Partido partido;
    private Equipo equipo;
    private int puntuacion;

    public PartidoJugado(Partido partido, Equipo equipo, int puntuacion) {
        this.partido = partido;
        this.equipo = equipo;
        this.puntuacion = puntuacion;
    }

    public PartidoJugado() {
    }

    public Partido getPartido() {
        return partido;
    }

    public void setPartido(Partido partido) {
        this.partido = partido;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    
    
}