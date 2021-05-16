package BD;
import java.sql.*;
import UML.Perfil;
import BD.BaseDatos;
<<<<<<< HEAD
import java.util.ArrayList;
=======
>>>>>>> lineaRober

public class tablaPerfiles {
    private static Connection con;
    
    public static void crearPerfil (Perfil perfil) throws Exception{
        BaseDatos.conectar();
        con = BaseDatos.getCon();
        
        String plantilla = "INSERT INTO PERFILES VALUES (?,?,?,?);";
        PreparedStatement ps = con.prepareStatement(plantilla);
        ps.setInt(1, perfil.getIdPerfil());
        ps.setString(2, perfil.getUsuario());
        ps.setString(3, perfil.getPasswd());
        ps.setString(4, perfil.getPrivilegios());
        
        int n = ps.executeUpdate();
        ps.close();
        if (n!=1)
            throw new Exception ("Error. Se ha creado más de un perifl");
        
        System.out.println("Perfil creado con éxito");
        BaseDatos.desconectar();
    }
    
    public static void eliminarPerfil (Perfil perfil) throws Exception{
        BaseDatos.conectar();
        con = BaseDatos.getCon();
        
        String plantilla = "DELETE FROM EQUIPOS WHERE IDEQUIPO=?;";
        PreparedStatement ps = con.prepareStatement(plantilla);
        ps.setInt(1, perfil.getIdPerfil());
        
        int n = ps.executeUpdate();
        ps.close();
        
        System.out.println("Perfil eliminado correctamente");
        BaseDatos.desconectar();
    }
    
<<<<<<< HEAD
    public static void consultaByIdPerfil (Perfil perfil) throws Exception{
=======
    public static void consultaIDPerfil (Perfil perfil) throws Exception{
>>>>>>> lineaRober
        BaseDatos.conectar();
        con = BaseDatos.getCon();
        
        String plantilla = "SELECT * FROM PERFILES WHERE IDPERFIL=?;";
        PreparedStatement ps = con.prepareStatement(plantilla);
<<<<<<< HEAD
        ps.setInt(1, perfil.getIdPerfil());
        
        BaseDatos.desconectar();
    }
    
    public static ArrayList<Perfil> allPerfil (Perfil perfil) throws Exception{
        BaseDatos.conectar();
        con = BaseDatos.getCon();
        
        String plantilla = "SELECT * FROM PERFILES;";
        PreparedStatement ps = con.prepareStatement(plantilla);
        ResultSet resultado = ps.executeQuery();
        
        Perfil perfilActual = new Perfil();
        ArrayList<Perfil> listaPerfiles = new ArrayList();
        
        if(resultado == null){
            listaPerfiles = null;
            System.out.println("No hay perfiles creados en la BD");
        }
        else{
            while(resultado.next()){
                perfilActual.setIdPerfil(resultado.getInt("IDPERFIL"));
                perfilActual.setUsuario(resultado.getString("USUARIO"));
                perfilActual.setPasswd(resultado.getString("PASSWD"));
                //MIRAR PRIVILEGIOS
            }
        }
        
        BaseDatos.desconectar();
        return listaPerfiles;
=======
        ps.setInt(1, perfil.getIdPerfil);
        
        BaseDatos.desconectar();
>>>>>>> lineaRober
    }
    
    public static void modPerfil (Perfil perfil) throws Exception{
        BaseDatos.conectar();
        con = BaseDatos.getCon();
        
<<<<<<< HEAD
        String plantilla = "UPDATE PERFILES SET"
        
=======
>>>>>>> lineaRober
        BaseDatos.desconectar();
    }
}
