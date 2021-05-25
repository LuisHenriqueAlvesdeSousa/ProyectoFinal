package BD;
import java.sql.*;
import UML.Perfil;
import BD.BaseDatos;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class tablaPerfiles {
    private static Connection con;
    
    public static void crearPerfil (Perfil perfil) throws Exception{
        BaseDatos.conectar();
        con = BaseDatos.getCon();
        
        String plantilla = "INSERT INTO PERFILES VALUES (?,?,?,?)";
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
    
    public static void eliminarPerfil (String id) throws Exception{
        BaseDatos.conectar();
        con = BaseDatos.getCon();
        
        String plantilla = "DELETE FROM EQUIPOS WHERE IDEQUIPO=?";
        PreparedStatement ps = con.prepareStatement(plantilla);
        ps.setString(1, id);
        
        int n = ps.executeUpdate();
        ps.close();
        
        System.out.println("Perfil eliminado correctamente");
        BaseDatos.desconectar();
    }
    
    public static void eliminarPerfil (Perfil perfil) throws Exception{
        BaseDatos.conectar();
        con = BaseDatos.getCon();
        
        String plantilla = "DELETE FROM EQUIPOS WHERE IDEQUIPO=?";
        PreparedStatement ps = con.prepareStatement(plantilla);
        ps.setInt(1, perfil.getIdPerfil());
        
        int n = ps.executeUpdate();
        ps.close();
        
        System.out.println("Perfil eliminado correctamente");
        BaseDatos.desconectar();
    }
    
    public static Perfil validarLogin (Perfil perfil) throws Exception{
        BaseDatos.conectar();
        con = BaseDatos.getCon();
        
        String plantilla = "SELECT * FROM PERFILES WHERE USER=? AND PASSWD=?";
        PreparedStatement ps = con.prepareStatement(plantilla);
        ps.setString(1, perfil.getUsuario());
        ps.setString(2, perfil.getPasswd());
        
        ResultSet resultado = ps.executeQuery();
        
        Perfil perfilActual = new Perfil();
        
        if(resultado == null){
            perfilActual = null;
        }
        else{
            perfilActual.setIdPerfil(resultado.getInt("IDPERFIL"));
            perfilActual.setUsuario(resultado.getString("USUARIO"));
            perfilActual.setPasswd(resultado.getString("PASSWD"));
            if(resultado.getString("PRIVILEGIO").equalsIgnoreCase("ADMIN")){
                perfilActual.setPrivilegiosAdmin();
            }
            else{
                perfilActual.setPrivilegiosUser();
            }
        }
        BaseDatos.desconectar();
        return perfilActual;
    }
    
    public static Perfil PerfilByIdPerfil (String id) throws Exception{
        BaseDatos.conectar();
        con = BaseDatos.getCon();
        
        String plantilla = "SELECT * FROM PERFILES WHERE IDPERFIL=?";
        PreparedStatement ps = con.prepareStatement(plantilla);
        ps.setString(1, id);
        
        ResultSet resultado = ps.executeQuery();
        if(resultado.next()){
            Perfil perfilActual = new Perfil();
            perfilActual.setIdPerfil(resultado.getInt("IDPERFIL"));
            perfilActual.setUsuario(resultado.getString("USUARIO"));
            perfilActual.setPasswd(resultado.getString("PASSWD"));
            if(resultado.getString("PRIVILEGIO").equalsIgnoreCase("ADMIN")){
                perfilActual.setPrivilegiosAdmin();
            }
            else{
                perfilActual.setPrivilegiosUser();
            }
            BaseDatos.desconectar();
            return perfilActual;
        }
        else{
            return null;
        }
        
    }
    
    public static Perfil PerfilByIdPerfil (Perfil perfil) throws Exception{
        BaseDatos.conectar();
        con = BaseDatos.getCon();
        
        String plantilla = "SELECT * FROM PERFILES WHERE IDPERFIL=?";
        PreparedStatement ps = con.prepareStatement(plantilla);
        ps.setInt(1, perfil.getIdPerfil());
        
        ResultSet resultado = ps.executeQuery();
         if(resultado.next()){
            Perfil perfilActual = new Perfil();
            perfilActual.setIdPerfil(resultado.getInt("IDPERFIL"));
            perfilActual.setUsuario(resultado.getString("USUARIO"));
            perfilActual.setPasswd(resultado.getString("PASSWD"));
            if(resultado.getString("PRIVILEGIO").equalsIgnoreCase("ADMIN")){
                perfilActual.setPrivilegiosAdmin();
            }
            else{
                perfilActual.setPrivilegiosUser();
            }
            BaseDatos.desconectar();
            return perfilActual;
        }
        else{
            BaseDatos.desconectar();
            return null;
        }
    }
    
    public static ArrayList<Perfil> allPerfil() throws Exception{
        BaseDatos.conectar();
        con = BaseDatos.getCon();
        
        String plantilla = "SELECT * FROM PERFILES";
        PreparedStatement ps = con.prepareStatement(plantilla);
        ResultSet resultado = ps.executeQuery();
        
        
        ArrayList<Perfil> listaPerfiles = new ArrayList();
        
        while(resultado.next()){
            Perfil perfilActual = new Perfil();
            perfilActual.setIdPerfil(resultado.getInt("IDPERFIL"));
            perfilActual.setUsuario(resultado.getString("USUARIO"));
            perfilActual.setPasswd(resultado.getString("PASSWD"));
            if(resultado.getString("PRIVILEGIO").equalsIgnoreCase("ADMIN")){
                perfilActual.setPrivilegiosAdmin();
            }
            else{
                perfilActual.setPrivilegiosUser();
            }
            listaPerfiles.add(perfilActual);
        }
        if(!listaPerfiles.isEmpty()){
            BaseDatos.desconectar();
            return listaPerfiles;
        }
        else{
            BaseDatos.desconectar();
            JOptionPane.showMessageDialog(null, "No hay perfiles creados en la BD");
            return null;
        }
        
        
        
    }
    
    public static void modUsuarioPerfil (Perfil perfil) throws Exception{
        BaseDatos.conectar();
        con = BaseDatos.getCon();
        
        String plantilla = "UPDATE PERFILES SET USUARIO=? WHERE IDPERFIL=?";
        PreparedStatement ps = con.prepareStatement(plantilla);
        ps.setString(1, perfil.getUsuario());
        ps.setInt(2, perfil.getIdPerfil());
        
        int n = ps.executeUpdate();
        
        if (n!=1)
            throw new Exception ("Se ha modificado más de un perfil");
        
        System.out.println("Perfil modificado con éxito");
        
        BaseDatos.desconectar();
    }
    
    public static void modPassPerfil (Perfil perfil) throws Exception{
        BaseDatos.conectar();
        con = BaseDatos.getCon();
        
        String plantilla = "UPDATE PERFILES SET PASSWD=? WHERE IDPERFIL=?";
        PreparedStatement ps = con.prepareStatement(plantilla);
        ps.setString(1, perfil.getPasswd());
        ps.setInt(2, perfil.getIdPerfil());
        
        int n = ps.executeUpdate();
        
        if (n!=1)
            throw new Exception ("Se ha modificado más de un perfil");
        
        System.out.println("Perfil modificado con éxito");
        
        BaseDatos.desconectar();
    }
    
    
}
