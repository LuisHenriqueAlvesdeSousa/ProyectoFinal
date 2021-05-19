package torneoes;

import BD.BaseDatos;
import UML.Jefe;
import UML.Perfil;
import Views.Jefe.vCrearJefe;
import java.sql.*;

import Views.vLogin;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.time.LocalDate;


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
            
            //vLogin l = new vLogin();
            //l.setVisible(true);
            Views.Jefe.vCrearJefe ventana = new vCrearJefe();
            ventana.setVisible(true);
            
        }
        catch(Exception e){
            System.out.println("Error");
        }
    }
    
    public static boolean validarUsuario(String user, String pass) throws Exception{
        Perfil p = new Perfil();
        p.setUsuario(user);
    }
    
    public static void insertarJefe(String dni, String nombre, String apellido, LocalDate fechaNacimiento, double sueldo, String telefono, LocalDate fechaContrato, LocalDate fechaFinContrato, String nacionalidad) throws Exception{
        Jefe jefeActual = new Jefe(dni, nombre, apellido, fechaNacimiento, sueldo, telefono, fechaContrato, fechaFinContrato, nacionalidad);
        BD.tablaJefes.crearJefe(jefeActual);
    }
    
}
