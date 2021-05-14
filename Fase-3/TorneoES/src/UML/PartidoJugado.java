package UML;

public class PartidoJugado {
    private int idPartido;
    private Equipo equipo;
    private int puntuacion;

    public PartidoJugado(int idPartido, Equipo equipo, int puntuacion) {
        this.idPartido = idPartido;
        this.equipo = equipo;
        this.puntuacion = puntuacion;
    }

    public PartidoJugado() {
    }

    public void setIdPartido(int idPartido) {
        this.idPartido = idPartido;
    }
    
    public int getIdPartido() {
        return idPartido;
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