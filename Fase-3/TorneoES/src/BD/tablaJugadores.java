package BD;
import java.sql.*;
import UML.Jugador;
import BD.BaseDatos;
import UML.Partido;
import UML.Persona;
import java.util.ArrayList;

public class tablaJugadores {
    private static Connection con;
    
    public static void crearJugador (Jugador jugador) throws Exception{
        BaseDatos.conectar();
        con = BaseDatos.getCon();
        
        tablaPersonas.crearPersona(jugador);
        String plantilla = "INSERT INTO JUGADORES (IDPERSONA) VALUES (?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(plantilla);
        ps.setInt(1, jugador.getIdPersona());
        
        int n = ps.executeUpdate();
        
        if(n != 1)
            throw new Exception("Se ha insertado más de un jugador");
        
        System.out.println("Jugador insertado con éxito");
         BaseDatos.desconectar(); 
    }
    
    public static void modJugador (Jugador jugador) throws Exception{
        BaseDatos.conectar();
        con = BaseDatos.getCon();
        
        tablaPersonas.modPersona(jugador);
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
    
        public static Jugador consultaIDJugador (Jugador jugador) throws Exception{
        BaseDatos.conectar();
        con = BaseDatos.getCon();
        
        String plantilla = "SELECT * FROM JUGADORES WHERE IDPERSONA=?;";
        PreparedStatement ps = con.prepareStatement(plantilla);
        ps.setInt(1, jugador.getIdPersona());
        
        ResultSet resultado = ps.executeQuery();
        
        BaseDatos.desconectar();
        
        Persona p = new Persona();
        p.setIdPersona(jugador.getIdPersona());
        p = tablaPersonas.PersonaById(p);
        if(p != null){
            Jugador jugador = new Jugador(p.getIdPersona(), p.getDni(), p.getNombre(), p.getApellido(), p.getFechaNacimiento(), p.getSueldo(), p.getTelefono(), p.getFechaContrato(), p.getFechaFinContrato(), p.getNacionalidad(),
                                resultado.getString("NICKNAME"), resultado.getString("ROL"), tablaEquipos.consultaIDEquipo(equipo)resultado);
            return entrenador;
        }
        else{
            return null;  
        }
        
        }
        
        
        public static ArrayList<Jugador> allJugadores() throws Exception{
        BaseDatos.conectar();
        con = BaseDatos.getCon();
        
        PreparedStatement ps = con.prepareStatement("SELECT * FROM JUGADORES;");
        
        ResultSet resultado = ps.executeQuery();

        ArrayList<Jugador> jugadores= new ArrayList();
        while(resultado.next()){
            Jugador j = new Jugador();
            j.setIdPersona(resultado.getInt("IDPERSONA"));
            j = tablaJugadores.consultaIDJugador(j);
            
            jugadores.add(j);
        }
        BaseDatos.desconectar();
        
        
    }
}
