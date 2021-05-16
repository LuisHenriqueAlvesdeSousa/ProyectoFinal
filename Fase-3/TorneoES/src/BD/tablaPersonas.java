package BD;

import UML.Persona;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
<<<<<<< HEAD
=======
import java.time.LocalDate;
>>>>>>> lineaRober
import java.util.ArrayList;

/**
 *
 * @author Luis H. Alves
 */
public class tablaPersonas {
    private static Connection con;
    
    public static void crearPersona(Persona p) throws Exception{
        BaseDatos.conectar();
        con = BaseDatos.getCon();
        
        String plantilla = "INSERT INTO PERSONAS("
                                                + " DNI,"
                                                + " NOMBRE,"
                                                + " APELLIDO,"
                                                + " FECHANACIMIENTO,"
                                                + " SUELDO,"
                                                + " TELEFONO,"
                                                + " FECHACONTRATO,"
                                                + " NACIONALIDAD) "
                          + "VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
        PreparedStatement ps = con.prepareStatement(plantilla);
        ps.setString(1, p.getDni());
        ps.setString(2, p.getNombre());
        ps.setString(3, p.getApellido());
        ps.setDate(4, java.sql.Date.valueOf(p.getFechaNacimiento()));
        ps.setDouble(5, p.getSueldo());
        ps.setString(6, p.getTelefono());
        ps.setDate(7, java.sql.Date.valueOf(p.getFechaContrato()));
        ps.setString(8, p.getNacionalidad());
        
        int n = ps.executeUpdate();
        
        if(n != 1)
            throw new Exception("Se ha insertado más de una Persona.");
        
<<<<<<< HEAD
        System.out.println("Persona insertada con exito.");
=======
        System.out.println("Persona insertado con exito.");
>>>>>>> lineaRober
        
        BaseDatos.desconectar();
    }
    
    public static void modPersona(Persona p) throws Exception{
        BaseDatos.conectar();
        con = BaseDatos.getCon();
        
        String plantilla = "UPDATE PERSONAS SET"
                                                + " DNI = ?,"
                                                + " NOMBRE = ?,"
                                                + " APELLIDO = ?,"
                                                + " FECHANACIMIENTO = ?,"
                                                + " SUELDO = ?,"
                                                + " TELEFONO = ?,"
                                                + " FECHACONTRATO = ?,"
                                                + " NACIONALIDAD = ?"
                          + "WHERE IDPERSONA = ?;";
        PreparedStatement ps = con.prepareStatement(plantilla);
        ps.setString(1, p.getDni());
        ps.setString(2, p.getNombre());
        ps.setString(3, p.getApellido());
        ps.setDate(4, java.sql.Date.valueOf(p.getFechaNacimiento()));
        ps.setDouble(5, p.getSueldo());
        ps.setString(6, p.getTelefono());
        ps.setDate(7, java.sql.Date.valueOf(p.getFechaContrato()));
        ps.setString(8, p.getNacionalidad());
        ps.setInt(9, p.getIdPersona());
        
        int n = ps.executeUpdate();
        
        if(n != 1)
            throw new Exception("Se ha actualizado más de una Persona.");
        
        System.out.println("Persona actualizada con exito.");
        
        BaseDatos.desconectar();
    }
    
    public static void eliminarPersona(Persona p) throws Exception{
        BaseDatos.conectar();
        con = BaseDatos.getCon();
        
        String plantilla = "DELETE FROM PERSONAS WHERE IDPERSONA = ?;";
        PreparedStatement ps = con.prepareStatement(plantilla);
        ps.setInt(1, p.getIdPersona());
        
        int n = ps.executeUpdate();
        
        if(n != 1)
            throw new Exception("Se ha eliminado más de una Persona.");
        
        System.out.println("Se ha eliminado la Persona con exito.");
        BaseDatos.desconectar();
    }
    
    public static ArrayList<Persona> allPersona(Persona p) throws Exception{
        BaseDatos.conectar();
        con = BaseDatos.getCon();
        
        String plantilla = "SELECT * FROM PERSONAS;";
        PreparedStatement ps = con.prepareStatement(plantilla);
        
        ResultSet resultado = ps.executeQuery();
        
        Persona personaActual = new Persona();
        ArrayList<Persona> listaPersonas = new ArrayList();
        
        if(resultado == null){
            listaPersonas = null;
            System.out.println("No se ha encontrado Personas en la BD.");
        }
        else{
            while(resultado.next()){
                personaActual.setIdPersona(resultado.getInt("IDPERSONA"));
                personaActual.setDni(resultado.getString("DNI"));
                personaActual.setNombre(resultado.getString("NOMBRE"));
                personaActual.setApellido(resultado.getString("APELLIDO"));
                personaActual.setFechaNacimiento(
                        resultado.getDate("FECHANACIMIENTO").toLocalDate());
                personaActual.setSueldo(resultado.getDouble("SUELDO"));
                personaActual.setTelefono(resultado.getString("TELEFONO"));
                personaActual.setFechaContrato(
                        resultado.getDate("FECHACONTRATO").toLocalDate());
                personaActual.setFechaFinContrato(
                        resultado.getDate("FECHAFINCONTRATO").toLocalDate());
                personaActual.setNacionalidad(
                        resultado.getString("NACIONALIDAD"));
                listaPersonas.add(personaActual);
            }
<<<<<<< HEAD
            System.out.println("Todos loas Personas selecionados con exito.");
=======
            System.out.println("Todos los jefes selecionados con exito.");
>>>>>>> lineaRober
        }
        
        BaseDatos.desconectar();
        return listaPersonas;
    }
    
    public static Persona PersonaByDni(Persona p) throws Exception{
        BaseDatos.conectar();
        con = BaseDatos.getCon();
        
        String plantilla = "SELECT * FROM PERSONAS WHERE DNI = ?;";
        PreparedStatement ps = con.prepareStatement(plantilla);
        ps.setString(1, p.getDni());
        
        ResultSet resultado = ps.executeQuery();
        
        Persona personaActual = new Persona();
        
        if(resultado == null){
            personaActual = null;
<<<<<<< HEAD
            System.out.println("Persona no encontrada.");
=======
>>>>>>> lineaRober
        }
        else{
            resultado.next();
            personaActual.setIdPersona(resultado.getInt("IDPERSONA"));
<<<<<<< HEAD
            personaActual.setDni(resultado.getString("DNI"));
            personaActual.setNombre(resultado.getString("NOMBRE"));
            personaActual.setApellido(resultado.getString("APELLIDO"));
            personaActual.setFechaNacimiento(
                        resultado.getDate("FECHANACIMIENTO").toLocalDate());
            personaActual.setSueldo(resultado.getDouble("SUELDO"));
            personaActual.setTelefono(resultado.getString("TELEFONO"));
            personaActual.setFechaContrato(
                        resultado.getDate("FECHACONTRATO").toLocalDate());
            personaActual.setFechaFinContrato(
                        resultado.getDate("FECHAFINCONTRATO").toLocalDate());
            personaActual.setNacionalidad(
                        resultado.getString("NACIONALIDAD"));
                
            System.out.println("Persona encontrada con exito.");
=======
                personaActual.setDni(resultado.getString("DNI"));
                personaActual.setNombre(resultado.getString("NOMBRE"));
                personaActual.setApellido(resultado.getString("APELLIDO"));
                personaActual.setFechaNacimiento(
                        resultado.getDate("FECHANACIMIENTO").toLocalDate());
                personaActual.setSueldo(resultado.getDouble("SUELDO"));
                personaActual.setTelefono(resultado.getString("TELEFONO"));
                personaActual.setFechaContrato(
                        resultado.getDate("FECHACONTRATO").toLocalDate());
                personaActual.setFechaFinContrato(
                        resultado.getDate("FECHAFINCONTRATO").toLocalDate());
                personaActual.setNacionalidad(
                        resultado.getString("NACIONALIDAD"));
>>>>>>> lineaRober
        }
        
        BaseDatos.desconectar();
        return personaActual;
    }
    
    public static Persona PersonaById(Persona p) throws Exception{
        BaseDatos.conectar();
        con = BaseDatos.getCon();
        
        String plantilla = "SELECT * FROM PERSONAS WHERE IDPERSONA = ?;";
        PreparedStatement ps = con.prepareStatement(plantilla);
        ps.setInt(1, p.getIdPersona());
        
        ResultSet resultado = ps.executeQuery();
        
        Persona personaActual = new Persona();
        
        if(resultado == null){
            personaActual = null;
<<<<<<< HEAD
            System.out.println("Persona no encontrada.");
=======
>>>>>>> lineaRober
        }
        else{
            resultado.next();
            personaActual.setIdPersona(resultado.getInt("IDPERSONA"));
<<<<<<< HEAD
            personaActual.setDni(resultado.getString("DNI"));
            personaActual.setNombre(resultado.getString("NOMBRE"));
            personaActual.setApellido(resultado.getString("APELLIDO"));
            personaActual.setFechaNacimiento(
                        resultado.getDate("FECHANACIMIENTO").toLocalDate());
            personaActual.setSueldo(resultado.getDouble("SUELDO"));
            personaActual.setTelefono(resultado.getString("TELEFONO"));
            personaActual.setFechaContrato(
                        resultado.getDate("FECHACONTRATO").toLocalDate());
            personaActual.setFechaFinContrato(
                        resultado.getDate("FECHAFINCONTRATO").toLocalDate());
            personaActual.setNacionalidad(
                        resultado.getString("NACIONALIDAD"));
            
            System.out.println("Persona encontrada con exito.");
=======
                personaActual.setDni(resultado.getString("DNI"));
                personaActual.setNombre(resultado.getString("NOMBRE"));
                personaActual.setApellido(resultado.getString("APELLIDO"));
                personaActual.setFechaNacimiento(
                        resultado.getDate("FECHANACIMIENTO").toLocalDate());
                personaActual.setSueldo(resultado.getDouble("SUELDO"));
                personaActual.setTelefono(resultado.getString("TELEFONO"));
                personaActual.setFechaContrato(
                        resultado.getDate("FECHACONTRATO").toLocalDate());
                personaActual.setFechaFinContrato(
                        resultado.getDate("FECHAFINCONTRATO").toLocalDate());
                personaActual.setNacionalidad(
                        resultado.getString("NACIONALIDAD"));
>>>>>>> lineaRober
        }
        
        BaseDatos.desconectar();
        return personaActual;
    }
}
