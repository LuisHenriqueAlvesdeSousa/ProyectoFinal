package UML;

public class Equipo {
    private int idEquipo;
    private String nombre;
    private String pais;

    public Equipo(int idEquipo, String nombre, String pais) {
        this.idEquipo = idEquipo;
        this.nombre = nombre;
        this.pais = pais;
    }

    public int getIdEquipo() {
        return idEquipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
    
    
}
