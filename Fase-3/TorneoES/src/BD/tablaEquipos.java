package BD;
import java.sql.*;
import UML.Equipo;
<<<<<<< HEAD
import java.util.ArrayList;
=======
>>>>>>> lineaRober
import BD.BaseDatos;

public class tablaEquipos {
    private static Connection con;
<<<<<<< HEAD
    
    public static void crearEquipo (Equipo equipo) throws Exception{
        BaseDatos.conectar();
        con = BaseDatos.getCon();
        
        
        String plantilla = "INSERT INTO EQUIPOS VALUES (?,?,?,?,?,?);";
        PreparedStatement ps = con.prepareStatement(plantilla);
        ps.setInt(1, equipo.getIdEquipo());
        ps.setString(2, equipo.getNombre());
        ps.setString(3, equipo.getPais());
        ps.setString(4, equipo.getIdJefe());
        ps.setString(5, equipo.IdPreparador());
        ps.setString(6, equipo.idEntrenador());
        
        int n = ps.executeUpdate();
        ps.close();
        if (n!=1)
            throw new Exception("Se ha introducido más de un equipo");
        
        System.out.println("Equipo insertado con éxito");
        BaseDatos.desconectar();
    }
    
    public static void consultaByIdEquipo (Equipo equipo) throws Exception{
        BaseDatos.conectar();
        con = BaseDatos.getCon();
        
        String plantilla = "SELECT * FROM EQUIPOS WHERE IDEQUIPO=?;";
        PreparedStatement ps = con.prepareStatement(plantilla);
        ps.setInt(1, equipo.getIdEquipo);
        
        BaseDatos.desconectar();
    }
    
    public static ArrayList<Equipo> allEquipo (Equipo equipo) throws Exception{
        BaseDatos.conectar();
        con = BaseDatos.getCon();
        
        String plantilla = "SELECT * FROM EQUIPOS;";
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
            }
        }
        BaseDatos.desconectar();
        return listaEquipos;
    }
    
    public static void eliminarEquipo (Equipo equipo) throws Exception{
        BaseDatos.conectar();
        con = BaseDatos.getCon();
        
        String plantilla = "DELETE FROM EQUIPOS WHERE IDEQUIPO=?;";
        PreparedStatement ps = con.prepareStatement(plantilla);
        ps.setInt(1, equipo.getIdEquipo());
        
        int n = ps.executeUpdate();
        ps.close();
        if (n!=1);
        
        System.out.println("Equipo eliminado con éxito");
        BaseDatos.desconectar();
    }
    
    public static void modEquipo (Equipo equipo) throws Exception{
        BaseDatos.conectar();
        con = BaseDatos.getCon();
        
        BaseDatos.desconectar();
    }
=======
>>>>>>> lineaRober
    
    public static void crearEquipo (Equipo equipo) throws Exception{
        BaseDatos.conectar();
        con = BaseDatos.getCon();
        
        
        String plantilla = "INSERT INTO EQUIPOS VALUES (?,?,?,?,?,?);";
        PreparedStatement ps = con.prepareStatement(plantilla);
        ps.setInt(1, equipo.getIdEquipo());
        ps.setString(2, equipo.getNombre());
        ps.setString(3, equipo.getPais());
        ps.setString(4, equipo.getIdJefe());
        ps.setString(5, equipo.IdPreparador());
        ps.setString(6, equipo.idEntrenador());
        
        int n = ps.executeUpdate();
        ps.close();
        if (n!=1)
            throw new Exception("Se ha introducido más de un equipo");
        
        System.out.println("Equipo insertado con éxito");
        BaseDatos.desconectar();
    }
    
    public static void consultaIDEquipo (Equipo equipo) throws Exception{
        BaseDatos.conectar();
        con = BaseDatos.getCon();
        
        String plantilla = "SELECT * FROM EQUIPOS WHERE IDEQUIPO=?;";
        PreparedStatement ps = con.prepareStatement(plantilla);
        ps.setInt(1, equipo.getIdEquipo);
        
        BaseDatos.desconectar();
    }
    
    public static void eliminarEquipo (Equipo equipo) throws Exception{
        BaseDatos.conectar();
        con = BaseDatos.getCon();
        
        String plantilla = "DELETE FROM EQUIPOS WHERE IDEQUIPO=?;";
        PreparedStatement ps = con.prepareStatement(plantilla);
        ps.setInt(1, equipo.getIdEquipo());
        
        int n = ps.executeUpdate();
        ps.close();
        if (n!=1);
        
        System.out.println("Equipo eliminado con éxito");
        BaseDatos.desconectar();
    }
    
    public static void modEquipo (Equipo equipo) throws Exception{
        BaseDatos.conectar();
        con = BaseDatos.getCon();
        
        BaseDatos.desconectar();
    }
}
