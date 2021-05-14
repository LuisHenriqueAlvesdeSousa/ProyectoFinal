package BD;

import UML.Jefe;
import UML.Persona;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Luis H. Alves
 */
public class tablaJefes {
    private static Connection con;
    
    public static void crearJefe(Jefe j) throws Exception{
        BaseDatos.conectar();
        con = BaseDatos.getCon();
        
        tablaPersonas.crearPersona(j);
        Persona personaActual = tablaPersonas.PersonaByDni(j);
        int id = personaActual.getIdPersona();
        String plantilla = "INSERT INTO JEFES (IDPERSONA) VALUES (?);";
        PreparedStatement ps = con.prepareStatement(plantilla);
        ps.setInt(1, id);
        
        int n = ps.executeUpdate();
        
        if(n != 1)
            throw new Exception("Se ha insertado más de un Jefe.");
        
        System.out.println("Jefe insertado con exito.");
        
        BaseDatos.desconectar();
    }
    
    public static void modJefe(Jefe j) throws Exception{
        tablaPersonas.modPersona(j);
    }
    
    public static void eliminarJefe(Jefe j) throws Exception{
        BaseDatos.conectar();
        con = BaseDatos.getCon();
        
        String plantilla = "DELETE FROM JEFES WHERE IDPERSONA = ?;";
        PreparedStatement ps = con.prepareStatement(plantilla);
        ps.setInt(1, j.getIdPersona());
        
        int n = ps.executeUpdate();
        
        if(n != 1)
            throw new Exception("Se ha eliminado más de un Jefe.");
        
        tablaPersonas.eliminarPersona(j);
        
        System.out.println("Se ha eliminado el Jefe con exito.");
        BaseDatos.desconectar();
    }
    
    public static ArrayList<Jefe> allJefe(Jefe j) throws Exception{
        BaseDatos.conectar();
        con = BaseDatos.getCon();
        
        String plantilla = "SELECT * FROM JEFES;";
        PreparedStatement ps = con.prepareStatement(plantilla);
        
        ResultSet resultado = ps.executeQuery();
        
        Jefe jefeActual = new Jefe();
        ArrayList<Jefe> listaJefes = new ArrayList();
        
        if(resultado == null){
            listaJefes = null;
            System.out.println("No se ha encontrado Jefes en la BD.");
        }
        else{
            while(resultado.next()){
                jefeActual.setIdPersona(resultado.getInt("IDPERSONA"));
                listaJefes.add(jefeActual);
            }
            System.out.println("Todos los jefes selecionados con exito.");
        }
        
        BaseDatos.desconectar();
        return listaJefes;
    }
}
