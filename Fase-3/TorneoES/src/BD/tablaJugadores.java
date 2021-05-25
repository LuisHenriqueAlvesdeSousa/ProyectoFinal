package BD;
import java.sql.*;
import UML.Jugador;
import UML.Persona;
import java.util.ArrayList;

public class tablaJugadores {
    private static Connection con;
    
    public static void crearJugador (Jugador jugador) throws Exception{
        BaseDatos.conectar();
        con = BaseDatos.getCon();
        
        tablaPersonas.crearPersona(jugador);
        Persona personaActual = tablaPersonas.PersonaByDni(jugador);
        int id = personaActual.getIdPersona();
        String plantilla = "INSERT INTO JUGADORES (IDPERSONA) VALUES (?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(plantilla);
        ps.setInt(1, jugador.getIdPersona());
        ps.setString(2, jugador.getNickname());
        ps.setString(3, jugador.getRol());
        ps.setInt(4, jugador.getEquipo().getIdEquipo());
        
        int n = ps.executeUpdate();
        
        if(n != 1)
            throw new Exception("Se ha insertado más de un jugador");
        
        System.out.println("Jugador insertado con éxito");
         BaseDatos.desconectar(); 
    }
    
    public static void modNickJugador (Jugador jugador) throws Exception{
        BaseDatos.conectar();
        con = BaseDatos.getCon();
        
        String plantilla = "UPDATE JUGADORES SET NICKNAME=? WHERE IDPERSONA=?";
        PreparedStatement ps = con.prepareStatement(plantilla);
        ps.setString(1, jugador.getNickname());
        ps.setInt(2, jugador.getIdPersona());
        
        int n = ps.executeUpdate();
        
        if (n!=1)
            throw new Exception ("Se ha modificado más de un jugador");
        
        System.out.println("Jugador modificado con éxito");
        
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
            throw new Exception("Error, se ha eliminado más de un jugador");
            
        System.out.println("Jugador eliminado con exito");
        BaseDatos.desconectar();
    }
    
    public static Jugador consultaByIdPersona (Jugador jugador) throws Exception{
        BaseDatos.conectar();
        con = BaseDatos.getCon();
        
        String plantilla = "SELECT  P.IDPERSONA,"
                                + " P.DNI,"
                                + " P.NOMBRE,"
                                + " P.APELLIDO,"
                                + " P.FECHA_NACIMIENTO,"
                                + " P.SUELDO,"
                                + " P.TELEFONO,"
                                + " P.FECHA_CONTRATO,"
                                + " P.FECHA_FIN_CONTRATO,"
                                + " P.NACIONALIDAD,"
                                + " J.NICKNAME,"
                                + " J.ROL,"
                                + " J.IDEQUIPO"
                            + "FROM PERSONAS P, JUGADOR J"
                            + "WHERE P.IDPERSONA = T.IDPERSONA";
        PreparedStatement ps = con.prepareStatement(plantilla);
        ps.setInt(1, jugador.getIdPersona());
        
        ResultSet resultado = ps.executeQuery();
        
        Jugador jugadorActual = new Jugador();
        jugadorActual.setIdPersona(resultado.getInt("P.IDPERSONA"));
        jugadorActual.setDni(resultado.getString("P.DNI"));
        jugadorActual.setNombre(resultado.getString("P.NOMBRE"));
        jugadorActual.setApellido(resultado.getString("P.APELLIDO"));
        jugadorActual.setFechaNacimiento(
                        resultado.getDate("P.FECHA_NACIMIENTO").toLocalDate());
        jugadorActual.setSueldo(resultado.getDouble("P.SUELDO"));
        jugadorActual.setTelefono(resultado.getString("P.TELEFONO"));
        jugadorActual.setFechaContrato(
                        resultado.getDate("P.FECHA_CONTRATO").toLocalDate());
        jugadorActual.setFechaFinContrato(
                        resultado.getDate("P.FECHA_FIN_CONTRATO").toLocalDate());
        jugadorActual.setNacionalidad(
                        resultado.getString("P.NACIONALIDAD"));
        
        jugadorActual.setNickname(resultado.getString("J.NICKNAME"));
        jugadorActual.setRol(resultado.getString("J.ROL"));
        jugadorActual.setEquipo(tablaEquipos.equipoByIdEquipo(resultado.getString("J.IDEQUIPO")));
        
        BaseDatos.desconectar();
        return jugadorActual;
    }
        
    public static ArrayList<Jugador> allJugador (Jugador jugador) throws Exception{
        BaseDatos.conectar();
        con = BaseDatos.getCon();
        
        String plantilla = "SELECT  P.IDPERSONA,"
                                + " P.DNI,"
                                + " P.NOMBRE,"
                                + " P.APELLIDO,"
                                + " P.FECHA_NACIMIENTO,"
                                + " P.SUELDO,"
                                + " P.TELEFONO,"
                                + " P.FECHA_CONTRATO,"
                                + " P.FECHA_FIN_CONTRATO,"
                                + " P.NACIONALIDAD,"
                                + " J.NICKNAME,"
                                + " J.ROL,"
                                + " J.IDEQUIPO"
                            + "FROM PERSONAS P, JUGADOR J"
                            + "WHERE P.IDPERSONA = T.IDPERSONA";
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
                jugadorActual.setIdPersona(resultado.getInt("P.IDPERSONA"));
                jugadorActual.setDni(resultado.getString("P.DNI"));
                jugadorActual.setNombre(resultado.getString("P.NOMBRE"));
                jugadorActual.setApellido(resultado.getString("P.APELLIDO"));
                jugadorActual.setFechaNacimiento(
                                resultado.getDate("P.FECHA_NACIMIENTO").toLocalDate());
                jugadorActual.setSueldo(resultado.getDouble("P.SUELDO"));
                jugadorActual.setTelefono(resultado.getString("P.TELEFONO"));
                jugadorActual.setFechaContrato(
                                resultado.getDate("P.FECHA_CONTRATO").toLocalDate());
                jugadorActual.setFechaFinContrato(
                                resultado.getDate("P.FECHA_FIN_CONTRATO").toLocalDate());
                jugadorActual.setNacionalidad(
                                resultado.getString("P.NACIONALIDAD"));

                jugadorActual.setNickname(resultado.getString("J.NICKNAME"));
                jugadorActual.setRol(resultado.getString("J.ROL"));
                jugadorActual.setEquipo(tablaEquipos.equipoByIdEquipo(resultado.getString("J.IDEQUIPO")));
            }
            System.out.println("Todos los jugadores seleccionados con éxito");
        }
        BaseDatos.desconectar();
        return listaJugadores;
    }
}
