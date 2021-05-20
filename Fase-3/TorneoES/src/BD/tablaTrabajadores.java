package BD;

import UML.Equipo;
import UML.Persona;
import UML.Trabajador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Luis H. Alves
 */
public class tablaTrabajadores {
    private static Connection con;
    
    public static void crearTrabajador(Trabajador t) throws Exception{
        BaseDatos.conectar();
        con = BaseDatos.getCon();
        
        tablaPersonas.crearPersona(t);
        Persona personaActual = tablaPersonas.PersonaByDni(t);
        int id = personaActual.getIdPersona();
        String plantilla = "INSERT INTO TRABAJADOR(IDPERSONA, OFICIO, IDEQUIPO) "
                          + "VALUES (?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(plantilla);
        ps.setInt(1, t.getIdPersona());
        ps.setString(2, t.getOficio());
        ps.setInt(3, t.getEquipo().getIdEquipo());
        
        int n = ps.executeUpdate();
        
        if(n != 1)
            throw new Exception("Se ha insertado más de un Trabajador.");
        
        System.out.println("Trabajador insertado con exito.");
        
        BaseDatos.desconectar();
    }
    
    public static void modTrabajador(Trabajador t) throws Exception{
        BaseDatos.conectar();
        con = BaseDatos.getCon();
        
        String plantilla = "UPDATE TRABAJADOR SET"
                                                + " IDPERSONA = ?,"
                                                + " OFICIO = ?,"
                                                + " IDEQUIPO = ? "
                          + "WHERE IDPERSONA = ?";
        PreparedStatement ps = con.prepareStatement(plantilla);
        ps.setInt(1, t.getIdPersona());
        ps.setString(2, t.getOficio());
        ps.setInt(3, t.getEquipo().getIdEquipo());
        
        int n = ps.executeUpdate();
        tablaPersonas.modPersona(t);
        
        if(n != 1)
            throw new Exception("Se ha actualizado más de un Trabajador.");
        
        System.out.println("Trabajador actualizado con exito.");
        
        BaseDatos.desconectar();
    }
    
    public static void eliminarTrabajador(Trabajador t) throws Exception{
        BaseDatos.conectar();
        con = BaseDatos.getCon();
        
        String plantilla = "DELETE FROM TRABAJADORES WHERE IDPERSONA = ?";
        PreparedStatement ps = con.prepareStatement(plantilla);
        ps.setInt(1, t.getIdPersona());
        
        int n = ps.executeUpdate();
        tablaPersonas.eliminarPersona(t);
        
        if(n != 1)
            throw new Exception("Se ha eliminado más de un Trabajador.");
        
        System.out.println("Se ha eliminado el Trabajador con exito.");
        BaseDatos.desconectar();
    }
    
    public static ArrayList<Trabajador> allTrabajador(Trabajador t) throws Exception{
        BaseDatos.conectar();
        con = BaseDatos.getCon();
        
        String plantilla = "SELECT  P.IDPERSONA,"
                                + " P.DNI,"
                                + " P.NOMBRE,"
                                + " P.APELLIDO,"
                                + " P.FECHANACIMIENTO,"
                                + " P.SUELDO,"
                                + " P.TELEFONO,"
                                + " P.FECHACONTRATO,"
                                + " P.FECHAFINCONTRATO,"
                                + " P.NACIONALIDAD,"
                                + " T.OFICIO,"
                                + " T.IDEQUIPO"
                            + "FROM PERSONAS P, TRABAJADORES T"
                            + "WHERE P.IDPERSONA = T.IDPERSONA";
        PreparedStatement ps = con.prepareStatement(plantilla);
        
        ResultSet resultado = ps.executeQuery();
        
        Trabajador trabajadorActual = new Trabajador();
        ArrayList<Trabajador> listaTrabajadores = new ArrayList();
        
        if(resultado == null){
            listaTrabajadores = null;
            System.out.println("No se ha encontrado Trabajadores en la BD.");
        }
        else{
            while(resultado.next()){
                trabajadorActual.setIdPersona(resultado.getInt("P.IDPERSONA"));
                trabajadorActual.setDni(resultado.getString("P.DNI"));
                trabajadorActual.setNombre(resultado.getString("P.NOMBRE"));
                trabajadorActual.setApellido(resultado.getString("P.APELLIDO"));
                trabajadorActual.setFechaNacimiento(
                        resultado.getDate("P.FECHANACIMIENTO").toLocalDate());
                trabajadorActual.setSueldo(resultado.getDouble("P.SUELDO"));
                trabajadorActual.setTelefono(resultado.getString("P.TELEFONO"));
                trabajadorActual.setFechaContrato(
                        resultado.getDate("P.FECHACONTRATO").toLocalDate());
                trabajadorActual.setFechaFinContrato(
                        resultado.getDate("P.FECHAFINCONTRATO").toLocalDate());
                trabajadorActual.setNacionalidad(
                        resultado.getString("P.NACIONALIDAD"));
                trabajadorActual.setOficio(resultado.getString("T.OFICIO"));
                Equipo equipoActual = tablaEquipos.equipoByIdEquipo(
                                        resultado.getString("T.IDEQUIPO"));
                trabajadorActual.setEquipo(equipoActual);
            }
            System.out.println("Todos los Trabajadores selecionados con exito.");
        }
        
        BaseDatos.desconectar();
        return listaTrabajadores;
    }
    
    public static Trabajador TrabajadorByDni(Persona p) throws Exception{
        BaseDatos.conectar();
        con = BaseDatos.getCon();
        
        String plantilla = "SELECT  P.IDPERSONA,"
                                + " P.DNI,"
                                + " P.NOMBRE,"
                                + " P.APELLIDO,"
                                + " P.FECHANACIMIENTO,"
                                + " P.SUELDO,"
                                + " P.TELEFONO,"
                                + " P.FECHACONTRATO,"
                                + " P.FECHAFINCONTRATO,"
                                + " P.NACIONALIDAD,"
                                + " T.OFICIO,"
                                + " T.IDEQUIPO"
                            + "FROM PERSONAS P, TRABAJADORES T"
                            + "WHERE P.IDPERSONA = T.IDPERSONA"
                            + "AND P.DNI = ?";
        PreparedStatement ps = con.prepareStatement(plantilla);
        ps.setString(1, p.getDni());
        
        ResultSet resultado = ps.executeQuery();
        
        Trabajador trabajadorActual = new Trabajador();
        
        if(resultado == null){
            trabajadorActual = null;
            System.out.println("Trabajador no encontrado.");
        }
        else{
            resultado.next();
            trabajadorActual.setIdPersona(resultado.getInt("P.IDPERSONA"));
            trabajadorActual.setDni(resultado.getString("P.DNI"));
            trabajadorActual.setNombre(resultado.getString("P.NOMBRE"));
            trabajadorActual.setApellido(resultado.getString("P.APELLIDO"));
            trabajadorActual.setFechaNacimiento(
                        resultado.getDate("P.FECHANACIMIENTO").toLocalDate());
            trabajadorActual.setSueldo(resultado.getDouble("P.SUELDO"));
            trabajadorActual.setTelefono(resultado.getString("P.TELEFONO"));
            trabajadorActual.setFechaContrato(
                        resultado.getDate("P.FECHACONTRATO").toLocalDate());
            trabajadorActual.setFechaFinContrato(
                        resultado.getDate("P.FECHAFINCONTRATO").toLocalDate());
            trabajadorActual.setNacionalidad(
                        resultado.getString("P.NACIONALIDAD"));
            trabajadorActual.setOficio(resultado.getString("T.OFICIO"));
                Equipo equipoActual = tablaEquipos.equipoByIdEquipo(
                                        resultado.getString("T.IDEQUIPO"));
            trabajadorActual.setEquipo(equipoActual);   
            System.out.println("Trabajador encontrado con exito.");
        }
        
        BaseDatos.desconectar();
        return trabajadorActual;
    }
    
    public static Trabajador trabajadorByIdTrabajador(String idTrabajador) throws Exception{
        BaseDatos.conectar();
        con = BaseDatos.getCon();
        
        String plantilla = "SELECT  P.IDPERSONA,"
                                + " P.DNI,"
                                + " P.NOMBRE,"
                                + " P.APELLIDO,"
                                + " P.FECHANACIMIENTO,"
                                + " P.SUELDO,"
                                + " P.TELEFONO,"
                                + " P.FECHACONTRATO,"
                                + " P.FECHAFINCONTRATO,"
                                + " P.NACIONALIDAD,"
                                + " T.OFICIO,"
                                + " T.IDEQUIPO"
                            + "FROM PERSONAS P, TRABAJADORES T"
                            + "WHERE P.IDPERSONA = T.IDPERSONA"
                            + "AND P.IDPERSONA = ?";
        PreparedStatement ps = con.prepareStatement(plantilla);
        ps.setString(1, idTrabajador);
        
        ResultSet resultado = ps.executeQuery();
        
        Trabajador trabajadorActual = new Trabajador();
        
        if(resultado == null){
            trabajadorActual = null;
            System.out.println("Trabajador no encontrado.");
        }
        else{
            resultado.next();
            trabajadorActual.setIdPersona(resultado.getInt("P.IDPERSONA"));
            trabajadorActual.setDni(resultado.getString("P.DNI"));
            trabajadorActual.setNombre(resultado.getString("P.NOMBRE"));
            trabajadorActual.setApellido(resultado.getString("P.APELLIDO"));
            trabajadorActual.setFechaNacimiento(
                        resultado.getDate("P.FECHANACIMIENTO").toLocalDate());
            trabajadorActual.setSueldo(resultado.getDouble("P.SUELDO"));
            trabajadorActual.setTelefono(resultado.getString("P.TELEFONO"));
            trabajadorActual.setFechaContrato(
                        resultado.getDate("P.FECHACONTRATO").toLocalDate());
            trabajadorActual.setFechaFinContrato(
                        resultado.getDate("P.FECHAFINCONTRATO").toLocalDate());
            trabajadorActual.setNacionalidad(
                        resultado.getString("P.NACIONALIDAD"));
            trabajadorActual.setOficio(resultado.getString("T.OFICIO"));
                Equipo equipoActual = tablaEquipos.equipoByIdEquipo(
                                        resultado.getString("T.IDEQUIPO"));
            trabajadorActual.setEquipo(equipoActual);   
            System.out.println("Trabajador encontrado con exito.");
        }
        
        BaseDatos.desconectar();
        return trabajadorActual;
    }
    
    public static Persona TrabajadorByIdTrabajador(Persona p) throws Exception{
        BaseDatos.conectar();
        con = BaseDatos.getCon();
        
        String plantilla = "SELECT  P.IDPERSONA,"
                                + " P.DNI,"
                                + " P.NOMBRE,"
                                + " P.APELLIDO,"
                                + " P.FECHANACIMIENTO,"
                                + " P.SUELDO,"
                                + " P.TELEFONO,"
                                + " P.FECHACONTRATO,"
                                + " P.FECHAFINCONTRATO,"
                                + " P.NACIONALIDAD,"
                                + " T.OFICIO,"
                                + " T.IDEQUIPO"
                            + "FROM PERSONAS P, TRABAJADORES T"
                            + "WHERE P.IDPERSONA = T.IDPERSONA"
                            + "AND P.IDPERSONA = ?";
        PreparedStatement ps = con.prepareStatement(plantilla);
        ps.setInt(1, p.getIdPersona());
        
        ResultSet resultado = ps.executeQuery();
        
        Trabajador trabajadorActual = new Trabajador();
        
        if(resultado == null){
            trabajadorActual = null;
            System.out.println("Trabajador no encontrado.");
        }
        else{
            resultado.next();
            trabajadorActual.setIdPersona(resultado.getInt("P.IDPERSONA"));
            trabajadorActual.setDni(resultado.getString("P.DNI"));
            trabajadorActual.setNombre(resultado.getString("P.NOMBRE"));
            trabajadorActual.setApellido(resultado.getString("P.APELLIDO"));
            trabajadorActual.setFechaNacimiento(
                        resultado.getDate("P.FECHANACIMIENTO").toLocalDate());
            trabajadorActual.setSueldo(resultado.getDouble("P.SUELDO"));
            trabajadorActual.setTelefono(resultado.getString("P.TELEFONO"));
            trabajadorActual.setFechaContrato(
                        resultado.getDate("P.FECHACONTRATO").toLocalDate());
            trabajadorActual.setFechaFinContrato(
                        resultado.getDate("P.FECHAFINCONTRATO").toLocalDate());
            trabajadorActual.setNacionalidad(
                        resultado.getString("P.NACIONALIDAD"));
            trabajadorActual.setOficio(resultado.getString("T.OFICIO"));
                Equipo equipoActual = tablaEquipos.equipoByIdEquipo(
                                        resultado.getString("T.IDEQUIPO"));
            trabajadorActual.setEquipo(equipoActual);   
            System.out.println("Trabajador encontrado con exito.");
        }
        
        BaseDatos.desconectar();
        return trabajadorActual;
    }
}