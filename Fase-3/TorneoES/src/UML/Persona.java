package UML;

import java.time.LocalDate;

/**
 *
 * @author Luis H. Alves
 */
public class Persona {
    private int idPersona;
    private String dni;
    private String nombre;
    private String apellido;
    private LocalDate fechaNacimiento;
    private double sueldo;
    private String telefono;
    private LocalDate fechaContrato;
    private LocalDate fechaFinContrato;
    private String nacionalidad;

    public Persona() {
    }

    public Persona(int idPersona, String dni, String nombre, String apellido, LocalDate fechaNacimiento, double sueldo, String telefono, LocalDate fechaContrato, LocalDate fechaFinContrato, String nacionalidad) {
        this.idPersona = idPersona;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.sueldo = sueldo;
        this.telefono = telefono;
        this.fechaContrato = fechaContrato;
        this.fechaFinContrato = fechaFinContrato;
        this.nacionalidad = nacionalidad;
    }
    
    public Persona(String dni, String nombre, String apellido, LocalDate fechaNacimiento, double sueldo, String telefono, LocalDate fechaContrato, LocalDate fechaFinContrato, String nacionalidad) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.sueldo = sueldo;
        this.telefono = telefono;
        this.fechaContrato = fechaContrato;
        this.fechaFinContrato = fechaFinContrato;
        this.nacionalidad = nacionalidad;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public LocalDate getFechaContrato() {
        return fechaContrato;
    }

    public void setFechaContrato(LocalDate fechaContrato) {
        this.fechaContrato = fechaContrato;
    }

    public LocalDate getFechaFinContrato() {
        return fechaFinContrato;
    }

    public void setFechaFinContrato(LocalDate fechaFinContrato) {
        this.fechaFinContrato = fechaFinContrato;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }
    
    
}
