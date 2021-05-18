
package BD;

import UML.Entrenador;
import UML.Persona;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class tablaEntrenadores {
    private static Connection con;

    public tablaEntrenadores(Connection con) {
        this.con = con;
    }
    
    public static void crearEntrenador(Entrenador e) throws Exception{
        BaseDatos.conectar();
        con = BaseDatos.getCon();
        
        tablaPersonas.crearPersona(e);
        PreparedStatement ps = con.prepareStatement("INSERT INTO ENTRENADORES (IDPERSONA) VALUES (?);");
        ps.setInt(1, e.getIdPersona());

        
        ps.executeUpdate();  
        
        BaseDatos.desconectar();
        
    }
    
    public static void modEntrenador(Entrenador e)  throws Exception{
        tablaPersonas.modPersona(e);
    }
    
    public static void eliminarEntrenador(Entrenador e)  throws Exception{
        BaseDatos.conectar();
        con = BaseDatos.getCon();
        
        PreparedStatement ps = con.prepareStatement("DELETE FROM ENTRENADORES WHERE IDPERSONA=?;");
        ps.setInt(1, e.getIdPersona());


        int n = ps.executeUpdate();  
        
        if( n > 1)
            throw new Exception("Se ha eliminado mas de un entrenador de partido");
        
        BaseDatos.desconectar();
        
        tablaPersonas.eliminarPersona(e);
        
        System.out.println("Se ha eliminado un entrenador");
    }
    
    public static Entrenador entrenadorByIdEntrenador(String idEntrenador) throws Exception{
        Persona p = new Persona();
        p.setIdPersona(Integer.parseInt(idEntrenador));
        p = tablaPersonas.PersonaByIdPersona(p);
        if(p != null){
            Entrenador entrenador = new Entrenador(p.getIdPersona(), p.getDni(), p.getNombre(), p.getApellido(), p.getFechaNacimiento(), p.getSueldo(), p.getTelefono(), p.getFechaContrato(), p.getFechaFinContrato(), p.getNacionalidad() );
            return entrenador;
        }
        else{
            return null;  
        }
    }
    
    public static Entrenador entrenadorByIdEntrenador(Entrenador e) throws Exception{
        Persona p = new Persona();
        p.setIdPersona(e.getIdPersona());
        p = tablaPersonas.PersonaByIdPersona(p);
        if(p != null){
            Entrenador entrenador = new Entrenador(p.getIdPersona(), p.getDni(), p.getNombre(), p.getApellido(), p.getFechaNacimiento(), p.getSueldo(), p.getTelefono(), p.getFechaContrato(), p.getFechaFinContrato(), p.getNacionalidad() );
            return entrenador;
        }
        else{
            return null;  
        }
    }
    
    public static ArrayList<Entrenador> allEntrenadores() throws Exception{
        BaseDatos.conectar();
        con = BaseDatos.getCon();
        
        PreparedStatement ps = con.prepareStatement("SELECT * FROM ENTRENADORES;");

        ResultSet resultado = ps.executeQuery();

        ArrayList<Entrenador> entrenadores = new ArrayList();
        
        while(resultado.next()){
            Entrenador e = new Entrenador();
            e.setIdPersona(resultado.getInt("IDPERSONA"));
            e = tablaEntrenadores.entrenadorByIdEntrenador(e);
            entrenadores.add(e);
        }
        if(entrenadores.isEmpty())
            return null;
        
        BaseDatos.desconectar();

        
        return entrenadores;
    }
    
    
}
