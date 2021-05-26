package UML;

import java.time.LocalDate;

/**
 *
 * @author Luis H. Alves
 */
public class Jugador extends Persona{
    private String nickname;
    private String rol;
    private Equipo equipo;

    public Jugador() {
    }

    public Jugador(String nickname, String rol, Equipo equipo, int idPersona, String dni, String nombre, String apellido, LocalDate fechaNacimiento, double sueldo, String telefono, LocalDate fechaContrato, LocalDate fechaFinContrato, String nacionalidad) {
        super(idPersona, dni, nombre, apellido, fechaNacimiento, sueldo, telefono, fechaContrato, fechaFinContrato, nacionalidad);
        this.nickname = nickname;
        this.rol = rol;
        this.equipo = equipo;
    }
    
    public Jugador(String nickname, String rol, Equipo equipo, String dni, String nombre, String apellido, LocalDate fechaNacimiento, double sueldo, String telefono, LocalDate fechaContrato, LocalDate fechaFinContrato, String nacionalidad) {
        super(dni, nombre, apellido, fechaNacimiento, sueldo, telefono, fechaContrato, fechaFinContrato, nacionalidad);
        this.nickname = nickname;
        this.rol = rol;
        this.equipo = equipo;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }
    
    
}
