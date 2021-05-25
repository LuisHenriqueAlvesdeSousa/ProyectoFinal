package torneoes;

import BD.procesosXML;
import BD.tablaEquipos;
import BD.tablaJefes;
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
import UML.Jugador;
import UML.Partido;
import UML.PartidoJugado;
import UML.Perfil;
import UML.Preparador;
import UML.Torneo;
import Views.Equipo.vAllEquipo;
import Views.Equipo.vCrearEquipo;
import Views.Equipo.vModEquipo;
import Views.Jefe.*;
import Views.Jugador.vAllJugadores;
import Views.Jugador.vCrearJugador;
import Views.Jugador.vModJugador;
import Views.Perfil.vAllPerfil;
import Views.Perfil.vCrearPerfil;
import Views.Perfil.vModPerfil;
import Views.Torneo.*;
import Views.vLogin;
import Views.vMainAdmin;
import Views.vMainUser;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;


import Views.vLogin;
import Views.vSelector;
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
    public static Equipo equipoActual;
    
    public static void main(String[] args) {
        try{
            perfilActual = new Perfil();
            perfilActual.setIdPerfil(1);
            
            equipoActual = new Equipo();
            equipoActual.setIdEquipo(1);
            
            getDimension();
            //abrirVLogin();
            //abrirVAllEquipo();
            //abrirVCrearEquipo();
            //abrirVModEquipo(equipoActual);
            //abrirVAllPerfil();
            //abrirVCrearPerfil();
            //abrirVModPerfil(perfilActual);
            torneoes.TorneoES.abrirVMainAdmin();
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
    
    public static void abrirVLogin(){
        vLogin l = new vLogin();
        l.setVisible(true);
    }
    
    public static void abrirVAllJugador() throws Exception{
        vAllJugadores ae = new vAllJugadores();
        ae.setVisible(true);
    }
    
    public static void abrirVModJugador(int idJugador) throws Exception{
        vModJugador ae = new vModJugador(idJugador);
        ae.setVisible(true);
    }
    
    public static void abrirVCrearJugador() throws Exception{
        vCrearJugador ae = new vCrearJugador();
        ae.setVisible(true);
    }
    
    public static void abrirVAllEquipo() throws Exception{
        vAllEquipo ae = new vAllEquipo();
        ae.setVisible(true);
    }
    
    public static void abrirVCrearEquipo(){
        vCrearEquipo ce = new vCrearEquipo();
        ce.setVisible(true);
    }
    
    public static void abrirVModEquipo(Equipo e) throws Exception{
        vModEquipo me = new vModEquipo(e);
        me.setVisible(true);
    }
    
    public static void abrirVAllPerfil() throws Exception{
        vAllPerfil ap = new vAllPerfil();
        ap.setVisible(true);
    }
    
    public static void abrirVCrearPerfil(){
        vCrearPerfil cp = new vCrearPerfil();
        cp.setVisible(true);
    }
    
    public static void abrirVModPerfil(Perfil p) throws Exception{
        vModPerfil mp = new vModPerfil(p);
        mp.setVisible(true);
    }
    
    public static void abrirVAllJugadores(){
        vAllJugadores cp = new vAllJugadores();
        cp.setVisible(true);
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
    
    public static Equipo obtenerEquipo(String id) throws Exception{
        return tablaEquipos.equipoByIdEquipo(id);
    }
    
    public static Perfil obtenerPerfil(String id) throws Exception{
        return tablaPerfiles.PerfilByIdPerfil(id);
    }
    
    public static void modificarEquipo(String idEquipo, String nombre, String pais) throws Exception{
        Equipo e = new Equipo(Integer.parseInt(idEquipo), nombre, pais);
    }
    
    
    public static void insertarJefe(String dni, String nombre, String apellido, LocalDate fechaNacimiento, double sueldo, String telefono, LocalDate fechaContrato, LocalDate fechaFinContrato, String nacionalidad) throws Exception{
        Jefe jefeActual = new Jefe(dni, nombre, apellido, fechaNacimiento, sueldo, telefono, fechaContrato, fechaFinContrato, nacionalidad);
        BD.tablaJefes.crearJefe(jefeActual);
    }
    
    public static void modJefe(int idPersona, String dni, String nombre, String apellido, LocalDate fechaNacimiento, double sueldo, String telefono, LocalDate fechaContrato, LocalDate fechaFinContrato, String nacionalidad) throws Exception{
        Jefe jefeActual = new Jefe(idPersona, dni, nombre, apellido, fechaNacimiento, sueldo, telefono, fechaContrato, fechaFinContrato, nacionalidad);
        BD.tablaJefes.modJefe(jefeActual);
    }
    
    public static void insertarJugador(String dni, String nombre, String apellido, LocalDate fechaNacimiento, double sueldo, String telefono, LocalDate fechaContrato, LocalDate fechaFinContrato, String nacionalidad, String rol, String nickname, String idEquipo) throws Exception{
        Equipo e = BD.tablaEquipos.equipoByIdEquipo(idEquipo);
        Jugador jugador = new Jugador(rol, nickname, e, dni, nombre, apellido, fechaNacimiento, sueldo, telefono, fechaContrato, fechaFinContrato, nacionalidad);
        BD.tablaJugadores.crearJugador(jugador);
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
    
    public static void llenarComboBoxJugadores(org.edisoncor.gui.comboBox.ComboBoxRect comboBox ) throws Exception{
        ArrayList<Jugador> jugadores = BD.tablaJugadores.allJugador();
        for(Jugador jugador : jugadores){
            comboBox.addItem(jugador.getIdPersona() + ": " + jugador.getApellido());
        }
    }
    
    public static void llenarComboBoxEquipos(org.edisoncor.gui.comboBox.ComboBoxRect comboBox ) throws Exception{
        ArrayList<Equipo> equipos = BD.tablaEquipos.allEquipos();
        for(Equipo equipo : equipos){
            comboBox.addItem(equipo.getIdEquipo() + ": " + equipo.getNombre());
        }
    }
    
    public static void llenarComboBoxTorneos(org.edisoncor.gui.comboBox.ComboBoxRect comboBox ) throws Exception{
        ArrayList<Torneo> torneos = BD.tablaTorneos.allTorneos();
        for(Torneo torneo : torneos){
            comboBox.addItem(torneo.getIdTorneo() + ": " + torneo.getEstado());
        }
        
    }
    
    public static void llenarComboBoxPerfiles(org.edisoncor.gui.comboBox.ComboBoxRect comboBox ) throws Exception{
        ArrayList<Perfil> perfiles = BD.tablaPerfiles.allPerfil();
        for(Perfil perfil : perfiles){
            comboBox.addItem(perfil.getIdPerfil() + ": " + perfil.getUsuario());
        }
        
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
