package UML;

/**
 * Clase que representa el resultado de un equipo en un partido
 * @author Equipo2
 * @version 1.0
 */

public class PartidoJugado {
    /**
     * Partido al que pertenece el resultado    
    */
    private Partido partido;
    /**
     * El equipo implicado
     */
    private Equipo equipo;
    /**
     * Puntuacion del encuentro conseguida por el equipo
     */
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