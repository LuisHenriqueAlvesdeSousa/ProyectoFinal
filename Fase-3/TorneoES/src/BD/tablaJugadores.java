package BD;
import java.sql.*;
import UML.Jugador;
<<<<<<< HEAD
import UML.Persona;
import BD.BaseDatos;
import java.util.ArrayList;
=======
import BD.BaseDatos;
>>>>>>> lineaRober

public class tablaJugadores {
    private static Connection con;
    
    public static void crearJugador (Jugador jugador) throws Exception{
        BaseDatos.conectar();
        con = BaseDatos.getCon();
        
<<<<<<< HEAD
        tablaPersonas.crearPersona(jugador);
        Persona personaActual = tablaPersonas.PersonaByDni(jugador);
        int id = personaActual.getIdPersona();
        String plantilla = "INSERT INTO JUGADORES (IDPERSONA) VALUES (?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(plantilla);
        ps.setInt(1, id);
        ps.setString(2, Nickname);
        ps.setString(3, Rol);
        ps.setString(4, Equipo);
=======
        tablaPersonas.crearPersona(Jugador jugador);
        int id = tablaPersonas.PersonaByDni(String dni);
        String plantilla = "INSERT INTO JUGADORES (IDPERSONA) VALUES (?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(plantilla);
        ps.setInt(1, id);
>>>>>>> lineaRober
        
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
<<<<<<< HEAD
            throw new Exception("Error, se ha eliminado más de un jugador");
=======
            throw new Exception("Error");
>>>>>>> lineaRober
            
        System.out.println("Jugador eliminado con exito");
        BaseDatos.desconectar();
    }
    
<<<<<<< HEAD
    public static void consultaByIdPersona (Jugador jugador) throws Exception{
=======
        public static void consultaIDJugador (Jugador jugador) throws Exception{
>>>>>>> lineaRober
        BaseDatos.conectar();
        con = BaseDatos.getCon();
        
        String plantilla = "SELECT * FROM PERFILES WHERE IDPERSONA=?;";
        PreparedStatement ps = con.prepareStatement(plantilla);
        ps.setInt(1, jugador.getIdPersona);
        
        BaseDatos.desconectar();
<<<<<<< HEAD
    }
        
    public static ArrayList<Jugador> allJugador (Jugador jugador) throws Exception{
=======
    
    public static void allJugador (Jugador jugador) throws Exception{
>>>>>>> lineaRober
        BaseDatos.conectar();
        con = BaseDatos.getCon();
        
        String plantilla = "SELECT * FROM JUGADORES;";
<<<<<<< HEAD
        PreparedStatement ps = con.prepareStatement(plantilla);
        ResultSet resultado = ps.executeQuery();
        
        Jugador jugadorActual = new Jugador();
        ArrayList<Jugador> listaJugadores = new ArrayList();
        
        if(resultado == null){
            listaJugadores = null;
            System.out.println("No se han encontrado jugadores en la BD");
        }
        else{
            while(resultado.next()){
                jugadorActual.setIdPersona(resultado.getInt("IDPERSONA"));
                jugadorActual.setDni(resultado.getString("DNI"));
                jugadorActual.setNombre(resultado.getString("NOMBRE"));
                jugadorActual.setApellido(resultado.getString("APELLIDO"));
                jugadorActual.setFechaNacimiento(resultado.getDate("FECHANACIMIENTO").toLocalDate());
                jugadorActual.setSueldo(resultado.getDouble("SUELDO"));
                jugadorActual.setTelefono(resultado.getString("TELEFONO"));
                jugadorActual.setFechaContrato(resultado.getDate("FECHACONTRATO").toLocalDate());
                jugadorActual.setFechaFinContrato(resultado.getDate("FECHAFINCONTRATO").toLocalDate());
                jugadorActual.setNacionalidad(resultado.getString("NACIONALIDAD"));
                jugadorActual.setNickname(resultado.getString("NICKNAME"));
                jugadorActual.setRol(resultado.getString("ROL"));
                jugadorActual.setEquipo(resultado.getInt("IDEQUIPO"));
            }
            System.out.println("Todos los jugadores seleccionados con éxito");
        }
        BaseDatos.desconectar();
        return listaJugadores;
=======
        
        BaseDatos.desconectar();
>>>>>>> lineaRober
    }
}
