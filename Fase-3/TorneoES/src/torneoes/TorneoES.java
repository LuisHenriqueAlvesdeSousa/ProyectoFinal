package torneoes;

import BD.BaseDatos;
import UML.Perfil;
import java.sql.*;

import Views.vLogin;
import java.awt.Dimension;
import java.awt.Toolkit;


/**
 *
 * @author Grupo 2 
 */
public class TorneoES {

    public static int screenHeight;
    public static int screenWidth;
    
    public static void main(String[] args) {
        try{
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); 
            screenHeight = screenSize.height;
            screenWidth = screenSize.width;
            
            vLogin l = new vLogin();
            l.setVisible(true);

        }
        catch(Exception e){
            System.out.println("Error");
        }
    }
    
    public static boolean validarUsuario(String user, String pass) throws Exception{
        Perfil p = new Perfil();
        p.setUsuario(user);
    }
    
}
