package UML;

import java.time.LocalDate;

/**
 *
 * @author Luis H. Alves
 */
public class Jefe extends Persona{

    public Jefe() {
    }

    public Jefe(int idPersona, String dni, String nombre, String apellido, LocalDate fechaNacimiento, double sueldo, String telefono, LocalDate fechaContrato, LocalDate fechaFinContrato, String nacionalidad) {
        super(idPersona, dni, nombre, apellido, fechaNacimiento, sueldo, telefono, fechaContrato, fechaFinContrato, nacionalidad);
    }
    
    
}
