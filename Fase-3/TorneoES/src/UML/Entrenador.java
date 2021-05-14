package UML;

import java.time.LocalDate;

/**
 *
 * @author Luis H. Alves
 */
public class Entrenador extends Persona{

    public Entrenador() {
    }

    public Entrenador(int idPersona, String dni, String nombre, String apellido, LocalDate fechaNacimiento, double sueldo, String telefono, LocalDate fechaContrato, LocalDate fechaFinContrato, String nacionalidad) {
        super(idPersona, dni, nombre, apellido, fechaNacimiento, sueldo, telefono, fechaContrato, fechaFinContrato, nacionalidad);
    }
    
    
}
