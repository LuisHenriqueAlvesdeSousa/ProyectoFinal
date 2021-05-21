package BD;
import java.sql.*;
import UML.Equipo;
import java.util.ArrayList;

public class tablaEquipos {
    private static Connection con;
    
    public static void crearEquipo (Equipo equipo) throws Exception{
        BaseDatos.conectar();
        con = BaseDatos.getCon();
        
        
        String plantilla = "INSERT INTO EQUIPOS VALUES (?,?,?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(plantilla);
        ps.setInt(1, equipo.getIdEquipo());
        ps.setString(2, equipo.getNombre());
        ps.setString(3, equipo.getPais());
        ps.setInt(4, equipo.getJefe().getIdPersona());
        ps.setInt(5, equipo.getPreparador().getIdPersona());
        ps.setInt(6, equipo.getEntrenador().getIdPersona());
        
        int n = ps.executeUpdate();
        ps.close();
        if (n!=1)
            throw new Exception("Se ha introducido más de un equipo");
        
        System.out.println("Equipo insertado con éxito");
        BaseDatos.desconectar();
    }
    
    public static Equipo equipoByIdEquipo (String idEquipo) throws Exception{
        BaseDatos.conectar();
        con = BaseDatos.getCon();
        
        String plantilla = "SELECT * FROM EQUIPOS WHERE IDEQUIPO=?";
        PreparedStatement ps = con.prepareStatement(plantilla);
        ps.setString(1, idEquipo);
        
        ResultSet resultado = ps.executeQuery();
        
        Equipo equipoActual = new Equipo();
        equipoActual.setIdEquipo(resultado.getInt("IDEQUIPO"));
        equipoActual.setNombre(resultado.getString("NOMBRE"));
        equipoActual.setPais(resultado.getString("PAIS"));
        equipoActual.setJefe(tablaJefes.JefeByIdJefe(resultado.getInt("IDJEFE")));
        equipoActual.setPreparador(tablaPreparadores.preparadorByIdPreparador(resultado.getString("IDPREPARADOR")));
        equipoActual.setEntrenador(tablaEntrenadores.entrenadorByIdEntrenador(resultado.getString("IDENTRENADOR")));
        
        BaseDatos.desconectar();
        return equipoActual;
    }
    
    public static Equipo equipoByIdEquipo (Equipo equipo) throws Exception{
        BaseDatos.conectar();
        con = BaseDatos.getCon();
        
        String plantilla = "SELECT * FROM EQUIPOS WHERE IDEQUIPO=?";
        PreparedStatement ps = con.prepareStatement(plantilla);
        ps.setInt(1, equipo.getIdEquipo());
        
        ResultSet resultado = ps.executeQuery();
        
        Equipo equipoActual = new Equipo();
        equipoActual.setIdEquipo(resultado.getInt("IDEQUIPO"));
        equipoActual.setNombre(resultado.getString("NOMBRE"));
        equipoActual.setPais(resultado.getString("PAIS"));
        equipoActual.setJefe(tablaJefes.JefeByIdJefe(resultado.getInt("IDJEFE")));
        equipoActual.setPreparador(tablaPreparadores.preparadorByIdPreparador(resultado.getString("IDPREPARADOR")));
        equipoActual.setEntrenador(tablaEntrenadores.entrenadorByIdEntrenador(resultado.getString("IDENTRENADOR")));
        
        BaseDatos.desconectar();
        return equipoActual;
    }
    
    public static ArrayList<Equipo> allEquipos (Equipo equipo) throws Exception{
        BaseDatos.conectar();
        con = BaseDatos.getCon();
        
        String plantilla = "SELECT * FROM EQUIPOS";
        PreparedStatement ps = con.prepareStatement(plantilla);
        ResultSet resultado = ps.executeQuery();
        
        Equipo equipoActual = new Equipo();
        ArrayList<Equipo> listaEquipos = new ArrayList();
        
        if (resultado == null){
            listaEquipos = null;
            System.out.println("No se han encontrado equipos en la BD");
        }
        else{
            while(resultado.next()){
                equipoActual.setIdEquipo(resultado.getInt("IDEQUIPO"));
                equipoActual.setNombre(resultado.getString("NOMBRE"));
                equipoActual.setPais(resultado.getString("PAIS"));
                equipoActual.setJefe(tablaJefes.JefeByIdJefe(resultado.getInt("IDJEFE")));
                equipoActual.setPreparador(tablaPreparadores.preparadorByIdPreparador(resultado.getString("IDPREPARADOR")));
                equipoActual.setEntrenador(tablaEntrenadores.entrenadorByIdEntrenador(resultado.getString("IDENTRENADOR")));
            }
        }
        
        BaseDatos.desconectar();
        return listaEquipos;
    }
    
    public static void eliminarEquipo (Equipo equipo) throws Exception{
        BaseDatos.conectar();
        con = BaseDatos.getCon();
        
        String plantilla = "DELETE FROM EQUIPOS WHERE IDEQUIPO=?";
        PreparedStatement ps = con.prepareStatement(plantilla);
        ps.setInt(1, equipo.getIdEquipo());
        
        int n = ps.executeUpdate();
        ps.close();
        if (n!=1)
            throw new Exception ("Se ha eliminado más de un equipo");
        
        System.out.println("Equipo eliminado con éxito");
        BaseDatos.desconectar();
    }
    
    public static void modNombreEquipo (Equipo equipo) throws Exception{
        BaseDatos.conectar();
        con = BaseDatos.getCon();
        
        String plantilla = "UPDATE EQUIPOS SET NOMBRE=? WHERE IDEQUIPO=?";
        PreparedStatement ps = con.prepareStatement(plantilla);
        ps.setString(1, equipo.getNombre());
        ps.setInt(2, equipo.getIdEquipo());
        
        int n = ps.executeUpdate();
        
        if (n!=1)
            throw new Exception ("Se ha modificado más de un equipo");
        
        System.out.println("Equipo modificado con éxito");
        
        BaseDatos.desconectar();
    }
    
    public static void modPaisEquipo (Equipo equipo) throws Exception{
        BaseDatos.conectar();
        con = BaseDatos.getCon();
        
        String plantilla = "UPDATE EQUIPOS SET PAIS=? WHERE IDEQUIPO=?";
        PreparedStatement ps = con.prepareStatement(plantilla);
        ps.setString(1, equipo.getPais());
        ps.setInt(2, equipo.getIdEquipo());
        
        int n = ps.executeUpdate();
        
        if (n!=1)
            throw new Exception ("Se ha modificado más de un equipo");
        
        System.out.println("Equipo modificado con éxito");
        
        BaseDatos.desconectar();
    }
}
