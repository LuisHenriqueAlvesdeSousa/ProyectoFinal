package torneoes;

import BD.BaseDatos;
import BD.tablaJefes;
import UML.Jefe;
import UML.Perfil;
import UML.Persona;
import Views.*;
import Views.Jefe.*;
import java.sql.*;

import Views.vLogin;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.time.LocalDate;
import java.util.ArrayList;


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
            vMainAdmin v = new vMainAdmin();
            v.setVisible(true);

            vModJefe v1 = new vModJefe(23);
            v1.setVisible(true);
        }
        catch(Exception e){
            System.out.println("Error:" + e.getMessage() + e.getClass());
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
    
    public static void abrirVentanaCrearJefe(){
        Views.Jefe.vCrearJefe ventana = new vCrearJefe();
        ventana.setVisible(true);
    }
    
    public static void abrirVentanaModJefe(int idPersona){
        Views.Jefe.vModJefe ventana = new vModJefe(idPersona);
        ventana.setVisible(true);
    }
    
    public static void abrirVentanaSeleccion(String titulo, String seleccion, String ventana){ //ventana es la ventana a la que se envia
        Views.vSelector vSeleccion = new vSelector(null, true, titulo, seleccion, ventana);
        vSeleccion.setVisible(true);
    }
    
    public static void llenarComboBoxJefes(org.edisoncor.gui.comboBox.ComboBoxRect comboBox ) throws Exception{
        ArrayList<Jefe> jefes = tablaJefes.allJefe();
        for(Jefe jefe : jefes){
            comboBox.addItem(jefe.getIdPersona() + ": " + jefe.getApellido());
        }
        
    }
    
}
