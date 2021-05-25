package UML;

import java.util.ArrayList;

public class Torneo {
    private int idTorneo;
    private String estado; 
    ArrayList<Jornada> jornadas;
    
    

    public Torneo() {
        estado="ABIERTO";
        jornadas = new ArrayList();
    }

    public void setIdTorneo(int idTorneo) {
        this.idTorneo = idTorneo;
    }
    
    public int getIdTorneo() {
        return idTorneo;
    }

    
    public String getEstado() {
        return estado;
    }

    public void setEstadoAbierto() {
        this.estado = "ABIERTO";
    }
    
    public void setEstadoCerrado() {
        this.estado = "CERRADO";
    }

    public ArrayList<Jornada> getJornadas() {
        return jornadas;
    }

    public void addJornada( Jornada jornada) {
        this.jornadas.add(jornada);
    }

    @Override
    public String toString() {
        return "Torneo: " + idTorneo + " Estado:" + estado;
    }

    
        
}
