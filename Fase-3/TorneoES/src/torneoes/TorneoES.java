package torneoes;

import BD.procesosXML;
import BD.tablaEquipos;
import BD.tablaJornadas;
import BD.tablaPartidos;
import BD.tablaPartidosJugados;
import BD.tablaPerfiles;
import static BD.tablaPerfiles.*;
import BD.tablaTorneos;
import UML.Entrenador;
import UML.Equipo;
import UML.Jefe;
import UML.Jornada;
import UML.Partido;
import UML.PartidoJugado;
import UML.Perfil;
import UML.Preparador;
import UML.Torneo;
import Views.Equipo.vModEquipo;
import Views.Perfil.vModPerfil;
import Views.vLogin;
import Views.vMainAdmin;
import Views.vMainUser;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;

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
    
    public static void abrirVModPerfil(Perfil p) throws Exception{
        vModPerfil mp = new vModPerfil(p);
        mp.setVisible(true);
    }
    
    public static void abrirVModEquipo(Equipo e) throws Exception{
        vModEquipo me = new vModEquipo(e);
        me.setVisible(true);
    }
    
    public static Equipo obtenerEquipo(String id) throws Exception{
        return tablaEquipos.equipoByIdEquipo(id);
    }
    
    public static Perfil obtenerPerfil(String id) throws Exception{
        return tablaPerfiles.PerfilByIdPerfil(id);
    }
    
    public static void modificarEquipo(String idEquipo, String nombre, String pais) throws Exception{
        Equipo e = new Equipo(Integer.parseInt(idEquipo), nombre, pais);
        
        tablaEquipos.modNombreEquipo(e);
        tablaEquipos.modPaisEquipo(e);
    }
    
    public static void modificarPerfil(String idPerfil, String usuario, String pass) throws Exception{
        Perfil p = new Perfil();
        p.setIdPerfil(Integer.parseInt(idPerfil));
        p.setUsuario(usuario);
        p.setPasswd(pass);
        
        tablaPerfiles.modPassPerfil(p);
        tablaPerfiles.modUsuarioPerfil(p);
    }
    
    public static void guardarEquipo (String nombre, String pais, String idPreparador, String idJefe, String idEntrenador) throws Exception{
        Equipo equipoActual = new Equipo();
        equipoActual.setNombre(nombre);
        equipoActual.setPais(pais);
        Preparador p = new Preparador();
        p.setIdPersona(Integer.parseInt(idPreparador));
        equipoActual.setPreparador(p);
        Jefe j = new Jefe();
        j.setIdPersona(Integer.parseInt(idJefe));
        equipoActual.setJefe(j);
        Entrenador e = new Entrenador();
        e.setIdPersona(Integer.parseInt(idEntrenador));
        
        tablaEquipos.crearEquipo(equipoActual);
    }
    
    public static void guardarPerfil (String usuario, String pass, String privilegio) throws Exception{
        Perfil p = new Perfil();
        p.setUsuario(usuario);
        p.setPasswd(pass);
        if(privilegio.matches("ADMIN")){
            p.setPrivilegiosAdmin();
        }
        else{
            p.setPrivilegiosUser();
        }
        
        tablaPerfiles.crearPerfil(p);
    }
    
    public static void randomJornada(String idJornada) throws Exception{
        ArrayList<Partido> listaPartidos = tablaPartidos.partidosByIdJornada(Integer.parseInt(idJornada));
            
            for(int y = 0; y < listaPartidos.size(); y++){
                ArrayList<PartidoJugado> listaPartidosJugados = tablaPartidosJugados.allPartidosJugadosByIdPartido(listaPartidos.get(y).getIdPartido());
                
                for(int z = 0; z < listaPartidosJugados.size(); z++){
                    if(listaPartidosJugados.get(z).getPuntuacion() == 0){
                        listaPartidosJugados.get(z).setPuntuacion((int) Math.random()* 1000);
                        tablaPartidosJugados.modPartidoJugado(listaPartidosJugados.get(z));
                    }
                }
            }
        procesosXML.actualizarClasificacionGeneral();
        procesosXML.actualizarTodasJornadas();
        procesosXML.actualizarUltimaJornada();
    }
    
    public static void randomTorneo(String idTorneo) throws Exception{
        ArrayList<Jornada> listaJornadas = tablaJornadas.allJornadasByIdTorneo(idTorneo);
        for(int x = 0; x < listaJornadas.size(); x++){
            ArrayList<Partido> listaPartidos = tablaPartidos.partidosByIdJornada(listaJornadas.get(x).getIdJornada());
            
            for(int y = 0; y < listaPartidos.size(); y++){
                ArrayList<PartidoJugado> listaPartidosJugados = tablaPartidosJugados.allPartidosJugadosByIdPartido(listaPartidos.get(y).getIdPartido());
                
                for(int z = 0; z < listaPartidosJugados.size(); z++){
                    if(listaPartidosJugados.get(z).getPuntuacion() == 0){
                        listaPartidosJugados.get(z).setPuntuacion((int) Math.random()* 1000);
                        tablaPartidosJugados.modPartidoJugado(listaPartidosJugados.get(z));
                    }
                }
            }
            procesosXML.actualizarClasificacionGeneral();
            procesosXML.actualizarTodasJornadas();
            procesosXML.actualizarUltimaJornada();
        }
    }
}
