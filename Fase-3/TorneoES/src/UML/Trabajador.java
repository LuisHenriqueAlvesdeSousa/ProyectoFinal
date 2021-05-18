package UML;

import java.time.LocalDate;

/**
 *
 * @author Luis H. Alves
 */
public class Trabajador extends Persona{
    private String oficio;
    private Equipo equipo;

    public Trabajador() {
    }

    public Trabajador(String oficio, Equipo equipo, int idPersona, String dni, String nombre, String apellido, LocalDate fechaNacimiento, double sueldo, String telefono, LocalDate fechaContrato, LocalDate fechaFinContrato, String nacionalidad) {
        super(idPersona, dni, nombre, apellido, fechaNacimiento, sueldo, telefono, fechaContrato, fechaFinContrato, nacionalidad);
        this.oficio = oficio;
        this.equipo = equipo;
    }

    public String getOficio() {
        return oficio;
    }

    public void setOficio(String oficio) {
        this.oficio = oficio;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }
    
    
}
