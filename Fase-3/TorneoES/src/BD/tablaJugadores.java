package BD;
import java.sql.*;
import UML.Jugador;
import BD.BaseDatos;

public class tablaJugadores {
    private static Connection con;
    
    public static void crearJugador (Jugador jugador) throws Exception{
        BaseDatos.conectar();
        con = BaseDatos.getCon();
        
        tablaPersonas.crearPersona(Jugador jugador);
        int id = tablaPersonas.PersonaByDni(String dni);
        String plantilla = "INSERT INTO JUGADORES (IDPERSONA) VALUES (?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(plantilla);
        ps.setInt(1, id);
        
        int n = ps.executeUpdate();
        
        if(n != 1)
            throw new Exception("Se ha insertado más de un jugador");
        
        System.out.println("Jugador insertado con éxito");
         BaseDatos.desconectar(); 
    }
    
    public static void modJugador (Jugador jugador) throws Exception{
        BaseDatos.conectar();
        con = BaseDatos.getCon();
        
        tablaPersonas.modPersona(Jugador jugador);
        BaseDatos.desconectar();
    }
    
    public static void eliminarJugador(Jugador jugador) throws Exception{
        BaseDatos.conectar();
        con = BaseDatos.getCon();
        
        String plantilla = "DELETE FROM JUGADORES WHERE IDPERSONA=?;";
        PreparedStatement ps = con.prepareStatement(plantilla);
        ps.setInt(1, jugador.getIdPersona());
        
        int n = ps.executeUpdate();
        
        if (n!=1)
            throw new Exception("Error");
            
        System.out.println("Jugador eliminado con exito");
        BaseDatos.desconectar();
    }
    
        public static void consultaIDJugador (Jugador jugador) throws Exception{
        BaseDatos.conectar();
        con = BaseDatos.getCon();
        
        String plantilla = "SELECT * FROM PERFILES WHERE IDPERSONA=?;";
        PreparedStatement ps = con.prepareStatement(plantilla);
        ps.setInt(1, jugador.getIdPersona);
        
        BaseDatos.desconectar();
    
    public static void allJugador (Jugador jugador) throws Exception{
        BaseDatos.conectar();
        con = BaseDatos.getCon();
        
        String plantilla = "SELECT * FROM JUGADORES;";
        
        BaseDatos.desconectar();
    }
}
