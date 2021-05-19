package torneoes;

import static BD.tablaPerfiles.*;
import UML.Perfil;
import Views.vLogin;
import Views.vMainAdmin;
import Views.vMainUser;
import java.awt.Dimension;
import java.awt.Toolkit;

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
    public static Perfil perfilActual;
    
    public static void main(String[] args) {
        try{
            getDimension();
            abrirVLogin();
        }
        catch(Exception e){
            System.out.println("Error:" + e.getMessage() + e.getClass());
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
    
    public static void abrirVentanaAllJefe(){
        Views.Jefe.vAllJefe ventana = new vAllJefe();
        ventana.setVisible(true);
    }

    public static void abrirVentanaModTorneo(){
        Views.Torneo.vModTorneo ventana = new vModTorneo();
        ventana.setVisible(true);
    }
    
    public static void abrirVentanaAllTorneo(){
        Views.Torneo.vAllTorneo ventana = new vAllTorneo();
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
    
    public static void llenarComboBoxTorneos(org.edisoncor.gui.comboBox.ComboBoxRect comboBox ) throws Exception{
        ArrayList<Torneo> torneos = BD.tablaTorneos.allTorneos();
        for(Torneo torneo : torneos){
            comboBox.addItem(torneo.getIdTorneo() + ": " + torneo.getJornadas().get(0).getFecha().toString());
        }
        
    }
    
    public static boolean validarUsuario(String user, String pass) throws Exception{
        Perfil p = new Perfil();
        p.setUsuario(user);
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
