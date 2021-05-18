package UML;

public class Equipo {
    private int idEquipo;
    private String nombre;
    private String pais;
    private Jefe jefe;
    private Preparador preparador;
    private Entrenador entrenador;

    
    
    public Equipo() {
    }
    
    public Equipo(int idEquipo, String nombre, String pais) {
        this.idEquipo = idEquipo;
        this.nombre = nombre;
        this.pais = pais;
    }

    public int getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(int idEquipo) {
        this.idEquipo = idEquipo;
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

    public Jefe getJefe() {
        return jefe;
    }

    public void setJefe(Jefe jefe) {
        this.jefe = jefe;
    }

    public Preparador getPreparador() {
        return preparador;
    }

    public void setPreparador(Preparador preparador) {
        this.preparador = preparador;
    }

    public Entrenador getEntrenador() {
        return entrenador;
    }

    public void setEntrenador(Entrenador entrenador) {
        this.entrenador = entrenador;
    }

   
    
}
