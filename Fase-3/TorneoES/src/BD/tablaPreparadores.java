/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BD;

import UML.Persona;
import UML.Preparador;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author 1GDAW04
 */
public class tablaPreparadores {
    private static Connection con;

    public tablaPreparadores(Connection con) {
        this.con = con;
    }
    
    public static void crearPreparador(Preparador e) throws Exception{
        BaseDatos.conectar();
        con = BaseDatos.getCon();
        
        tablaPersonas.crearPersona(e);
        PreparedStatement ps = con.prepareStatement("INSERT INTO PREPARADORES (IDPERSONA) VALUES (?);");
        ps.setInt(1, e.getIdPersona());

        
        ps.executeUpdate();  
        
        BaseDatos.desconectar();
        
    }
    
    public static void modPreparador(Preparador e)  throws Exception{
        tablaPersonas.modPersona(e);
    }
    
    public static void eliminarPreparador(Preparador e)  throws Exception{
        BaseDatos.conectar();
        con = BaseDatos.getCon();
        
        PreparedStatement ps = con.prepareStatement("DELETE FROM PREPARADORES WHERE IDPERSONA=?;");
        ps.setInt(1, e.getIdPersona());


        int n = ps.executeUpdate();  
        
        if( n > 1)
            throw new Exception("Se ha eliminado mas de un resultado de partido");
        
        BaseDatos.desconectar();
        
        tablaPersonas.eliminarPersona(e);
        
        System.out.println("Se ha eliminado un entrenador");
    }
    
    public static Preparador entrenadorById(Preparador e) throws Exception{
        Persona p = new Persona();
        p.setIdPersona(e.getIdPersona());
        p = tablaPersonas.PersonaById(p);
        if(p != null){
            Preparador entrenador = new Preparador(p.getIdPersona(), p.getDni(), p.getNombre(), p.getApellido(), p.getFechaNacimiento(), p.getSueldo(), p.getTelefono(), p.getFechaContrato(), p.getFechaFinContrato(), p.getNacionalidad() );
            return entrenador;
        }
        else{
            return null;  
        }
    }
    
    public static ArrayList<Preparador> allPreparadores() throws Exception{
        BaseDatos.conectar();
        con = BaseDatos.getCon();
        
        PreparedStatement ps = con.prepareStatement("SELECT * FROM PREPARADORES;");

        ResultSet resultado = ps.executeQuery();

        ArrayList<Preparador> preparadores = new ArrayList();
        
        while(resultado.next()){
            Preparador e = new Preparador();
            e.setIdPersona(resultado.getInt("IDPERSONA"));
            e = tablaPreparadores.entrenadorById(e);
            preparadores.add(e);
        }
        if(preparadores.isEmpty())
            return null;
        
        BaseDatos.desconectar();

        
        return preparadores;
    }
}
