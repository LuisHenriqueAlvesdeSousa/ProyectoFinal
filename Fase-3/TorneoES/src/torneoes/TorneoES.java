package torneoes;

import static BD.tablaPerfiles.*;
import UML.Perfil;
import Views.vLogin;
import Views.vMainAdmin;
import Views.vMainUser;
import java.awt.Dimension;
import java.awt.Toolkit;


/**
 *
 * @author Grupo 2 
 */
public class TorneoES {

    public static int screenHeight;
    public static int screenWidth;
    public static Perfil perfilActual;
    
    public static void main(String[] args) {
        try{
            getDimension();
            abrirVLogin();
        }
        catch(Exception e){
            System.out.println("Error");
        }
    }
    
    public static void getDimension() throws Exception{
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); 
        screenHeight = screenSize.height;
        screenWidth = screenSize.width;
    }
    
    public static void abrirVLogin() throws Exception{
        vLogin l = new vLogin();
        l.setVisible(true);
    }
    
    public static boolean validarUsuario(String user, String pass) throws Exception{
        Perfil p = new Perfil();
        p.setUsuario(user);
        p.setPasswd(pass);
        Perfil perfilActual = validarLogin(p);
        if(perfilActual == null){
            return false;
        }
        return true;
    }
    
    public static String obtenerPrivilegio() throws Exception{
        return perfilActual.getPrivilegios();
    }
    
    public static void abrirVMainAdmin() throws Exception{
        vMainAdmin ma = new vMainAdmin();
        ma.setVisible(true);
    }
    
    public static void abrirVMainUser() throws Exception{
        vMainUser mu = new vMainUser();
        mu.setVisible(true);
    }
}
