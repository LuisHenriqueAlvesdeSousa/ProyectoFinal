package BD;

import UML.Persona;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
                                                + " FECHA_NACIMIENTO,"
                                                + " SUELDO,"
                                                + " TELEFONO,"
                                                + " FECHA_CONTRATO,"
                                                + " FECHA_FIN_CONTRATO,"
                                                + " NACIONALIDAD) "
                          + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(plantilla);
        ps.setString(1, p.getDni());
        ps.setString(2, p.getNombre());
        ps.setString(3, p.getApellido());
        ps.setDate(4, java.sql.Date.valueOf(p.getFechaNacimiento()));
        ps.setDouble(5, p.getSueldo());
        ps.setString(6, p.getTelefono());
        ps.setDate(7, java.sql.Date.valueOf(p.getFechaContrato()));
        ps.setDate(8, java.sql.Date.valueOf(p.getFechaFinContrato()));
        ps.setString(9, p.getNacionalidad());
        
        int n = ps.executeUpdate();
        
        if(n != 1)
            throw new Exception("Se ha insertado más de una Persona.");
        
        System.out.println("Persona insertado con exito.");   
        BaseDatos.desconectar();
    }
    
    public static void modPersona(Persona p) throws Exception{
        BaseDatos.conectar();
        con = BaseDatos.getCon();
        
        String plantilla = "UPDATE PERSONAS SET"
                                                + " DNI = ?,"
                                                + " NOMBRE = ?,"
                                                + " APELLIDO = ?,"
                                                + " FECHA_NACIMIENTO = ?,"
                                                + " SUELDO = ?,"
                                                + " TELEFONO = ?,"
                                                + " FECHA_CONTRATO = ?,"
                                                + " FECHA_FIN_CONTRATO = ?,"
                                                + " NACIONALIDAD = ?"
                          + "WHERE IDPERSONA = ?";
        PreparedStatement ps = con.prepareStatement(plantilla);
        ps.setString(1, p.getDni());
        ps.setString(2, p.getNombre());
        ps.setString(3, p.getApellido());
        ps.setDate(4, java.sql.Date.valueOf(p.getFechaNacimiento()));
        ps.setDouble(5, p.getSueldo());
        ps.setString(6, p.getTelefono());
        ps.setDate(7, java.sql.Date.valueOf(p.getFechaContrato()));
        ps.setDate(8, java.sql.Date.valueOf(p.getFechaFinContrato()));
        ps.setString(9, p.getNacionalidad());
        ps.setInt(10, p.getIdPersona());
        
        int n = ps.executeUpdate();
        
        if(n != 1)
            throw new Exception("Se ha actualizado más de una Persona.");
        
        System.out.println("Persona actualizada con exito.");
        
        BaseDatos.desconectar();
    }
    
    public static void eliminarPersona(Persona p) throws Exception{
        BaseDatos.conectar();
        con = BaseDatos.getCon();
        
        String plantilla = "DELETE FROM PERSONAS WHERE IDPERSONA = ?";
        PreparedStatement ps = con.prepareStatement(plantilla);
        ps.setInt(1, p.getIdPersona());
        
        int n = ps.executeUpdate();
        
        if(n != 1)
            throw new Exception("Se ha eliminado más de una Persona.");
        
        System.out.println("Se ha eliminado la Persona con exito.");
        BaseDatos.desconectar();
    }
    
    
    public static void eliminarPersona(int idpersona) throws Exception{
        BaseDatos.conectar();
        con = BaseDatos.getCon();
        
        String plantilla = "DELETE FROM PERSONAS WHERE IDPERSONA = ?";
        PreparedStatement ps = con.prepareStatement(plantilla);
        ps.setInt(1, idpersona);
        
        int n = ps.executeUpdate();
        
        if(n != 1)
            throw new Exception("Se ha eliminado más de una Persona.");
        
        System.out.println("Se ha eliminado la Persona con exito.");
        BaseDatos.desconectar();
    }
    
    public static ArrayList<Persona> allPersona() throws Exception{
        BaseDatos.conectar();
        con = BaseDatos.getCon();
        
        String plantilla = "SELECT * FROM PERSONAS";
        PreparedStatement ps = con.prepareStatement(plantilla);
        
        ResultSet resultado = ps.executeQuery();
        
       
        ArrayList<Persona> listaPersonas = new ArrayList();
        
        if(resultado == null){
            listaPersonas = null;
            System.out.println("No se ha encontrado Personas en la BD.");
        }
        else{
            while(resultado.next()){
                Persona personaActual = new Persona();
                personaActual.setIdPersona(resultado.getInt("IDPERSONA"));
                personaActual.setDni(resultado.getString("DNI"));
                personaActual.setNombre(resultado.getString("NOMBRE"));
                personaActual.setApellido(resultado.getString("APELLIDO"));
                personaActual.setFechaNacimiento(
                        resultado.getDate("FECHA_NACIMIENTO").toLocalDate());
                personaActual.setSueldo(resultado.getDouble("SUELDO"));
                personaActual.setTelefono(resultado.getString("TELEFONO"));
                personaActual.setFechaContrato(
                        resultado.getDate("FECHA_CONTRATO").toLocalDate());
                personaActual.setFechaFinContrato(
                        resultado.getDate("FECHA_FIN_CONTRATO").toLocalDate());
                personaActual.setNacionalidad(
                        resultado.getString("NACIONALIDAD"));
                listaPersonas.add(personaActual);
            }
            System.out.println("Todos loas Personas selecionados con exito.");
        }
        
        BaseDatos.desconectar();
        return listaPersonas;
    }
    
    public static Persona PersonaByDni(String dni) throws Exception{
        BaseDatos.conectar();
        con = BaseDatos.getCon();
        
        String plantilla = "SELECT * FROM PERSONAS WHERE DNI = ?";
        PreparedStatement ps = con.prepareStatement(plantilla);
        ps.setString(1, dni);
        
        ResultSet resultado = ps.executeQuery();
        
        Persona personaActual = new Persona();
        
        if(resultado == null){
            personaActual = null;
            System.out.println("Persona no encontrada.");
        }
        else{
            resultado.next();
            personaActual.setIdPersona(resultado.getInt("IDPERSONA"));
            personaActual.setDni(resultado.getString("DNI"));
            personaActual.setNombre(resultado.getString("NOMBRE"));
            personaActual.setApellido(resultado.getString("APELLIDO"));
            personaActual.setFechaNacimiento(
                        resultado.getDate("FECHA_NACIMIENTO").toLocalDate());
            personaActual.setSueldo(resultado.getDouble("SUELDO"));
            personaActual.setTelefono(resultado.getString("TELEFONO"));
            personaActual.setFechaContrato(
                        resultado.getDate("FECHA_CONTRATO").toLocalDate());
            personaActual.setFechaFinContrato(
                        resultado.getDate("FECHA_FIN_CONTRATO").toLocalDate());
            personaActual.setNacionalidad(
                        resultado.getString("NACIONALIDAD"));
                
            System.out.println("Persona encontrada con exito.");
        }
        
        BaseDatos.desconectar();
        return personaActual;
    }
    
    public static Persona PersonaByDni(Persona p) throws Exception{
        BaseDatos.conectar();
        con = BaseDatos.getCon();
        
        String plantilla = "SELECT * FROM PERSONAS WHERE DNI = ?";
        PreparedStatement ps = con.prepareStatement(plantilla);
        ps.setString(1, p.getDni());
        
        ResultSet resultado = ps.executeQuery();
        
        Persona personaActual = new Persona();
        
        if(resultado == null){
            personaActual = null;
            System.out.println("Persona no encontrada.");
        }
        else{
            resultado.next();
            personaActual.setIdPersona(resultado.getInt("IDPERSONA"));
            personaActual.setDni(resultado.getString("DNI"));
            personaActual.setNombre(resultado.getString("NOMBRE"));
            personaActual.setApellido(resultado.getString("APELLIDO"));
            personaActual.setFechaNacimiento(
                        resultado.getDate("FECHA_NACIMIENTO").toLocalDate());
            personaActual.setSueldo(resultado.getDouble("SUELDO"));
            personaActual.setTelefono(resultado.getString("TELEFONO"));
            personaActual.setFechaContrato(
                        resultado.getDate("FECHA_CONTRATO").toLocalDate());
            personaActual.setFechaFinContrato(
                        resultado.getDate("FECHA_FIN_CONTRATO").toLocalDate());
            personaActual.setNacionalidad(
                        resultado.getString("NACIONALIDAD"));
                
            System.out.println("Persona encontrada con exito.");
        }
        
        BaseDatos.desconectar();
        return personaActual;
    }
    
    public static Persona PersonaByIdPersona(Persona p) throws Exception{
        BaseDatos.conectar();
        con = BaseDatos.getCon();
        
        String plantilla = "SELECT * FROM PERSONAS WHERE IDPERSONA = ?";
        PreparedStatement ps = con.prepareStatement(plantilla);
        ps.setInt(1, p.getIdPersona());
        
        ResultSet resultado = ps.executeQuery();
        
        Persona personaActual = new Persona();
        
        if(resultado == null){
            personaActual = null;
            System.out.println("Persona no encontrada.");
        }
        else{
            resultado.next();
            personaActual.setIdPersona(resultado.getInt("IDPERSONA"));
            personaActual.setDni(resultado.getString("DNI"));
            personaActual.setNombre(resultado.getString("NOMBRE"));
            personaActual.setApellido(resultado.getString("APELLIDO"));
            personaActual.setFechaNacimiento(
                        resultado.getDate("FECHA_NACIMIENTO").toLocalDate());
            personaActual.setSueldo(resultado.getDouble("SUELDO"));
            personaActual.setTelefono(resultado.getString("TELEFONO"));
            personaActual.setFechaContrato(
                        resultado.getDate("FECHA_CONTRATO").toLocalDate());
            personaActual.setFechaFinContrato(
                        resultado.getDate("FECHA_FIN_CONTRATO").toLocalDate());
            personaActual.setNacionalidad(
                        resultado.getString("NACIONALIDAD"));
            
            System.out.println("Persona encontrada con exito.");
        }
        
        BaseDatos.desconectar();
        return personaActual;
    }
}
