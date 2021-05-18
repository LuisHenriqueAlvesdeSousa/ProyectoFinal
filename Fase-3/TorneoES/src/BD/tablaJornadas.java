/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BD;

import UML.Jornada;
import UML.Partido;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
/**
 *
 * @author 1GDAW04
 */
public class tablaJornadas {
    private static Connection con;

    public tablaJornadas(Connection con) {
        this.con = con;
    }
    
    public static void crearJornada(Jornada j) throws Exception{
        BaseDatos.conectar();
        con = BaseDatos.getCon();
        
        PreparedStatement ps = con.prepareStatement("INSERT INTO JORNADAS (FECHA, IDTORNEO) VALUES (?, ?);");
        Date fecha = Date.valueOf(j.getFecha());
        ps.setDate(1, fecha);
        ps.setInt(1, j.getTorneo().getIdTorneo());
        ArrayList<Partido> partidos = j.getPartidos();
        for(Partido partido : partidos){
            tablaPartidos.crearPartido(partido);
        }
        
        ps.executeUpdate();  
        
        BaseDatos.desconectar();
        
    }
    
    public static void modFechaJornada(Jornada j)  throws Exception{
        BaseDatos.conectar();
        con = BaseDatos.getCon();
        
        PreparedStatement ps = con.prepareStatement("UPDATE JORNADAS SET FECHA=? WHERE IDJORNADA=?;");
        Date fecha = Date.valueOf(j.getFecha());
        ps.setDate(1, fecha);
        ps.setInt(2, j.getIdJornada());
        
        int n = ps.executeUpdate();
        
        BaseDatos.desconectar();
        
        if( n > 1)
            throw new Exception("Se ha modificado mas de una jornada");
    }
    
    public static void eliminarJornada(Jornada j)  throws Exception{
        BaseDatos.conectar();
        con = BaseDatos.getCon();
        
        PreparedStatement ps = con.prepareStatement("DELETE FROM JORNADAS WHERE IDJORNADA=?;");
        ps.setInt(1, j.getIdJornada());

        int n = ps.executeUpdate();  
        
        BaseDatos.desconectar();
        
        if( n > 1)
            throw new Exception("Se ha eliminado mas de una jornada");
    }
    
    public static Jornada jornadaById(String idJornada) throws Exception{
        BaseDatos.conectar();
        con = BaseDatos.getCon();
        
        PreparedStatement ps = con.prepareStatement("SELECT * FROM JORNADAS WHERE UPPER(IDJORNADA)=UPPER(?);");
        ps.setString(1, idJornada);

        ResultSet resultado = ps.executeQuery();
        
       

        Jornada j = new Jornada();
        j.setIdJornada(resultado.getInt("IDJORNADA"));
        LocalDate fecha = resultado.getDate("FECHA").toLocalDate();
        j.setFecha(fecha);
        j.setTorneo(tablaTorneos.torneoById(resultado.getInt("IDTORNEO")));
        j.setPartidos(tablaPartidos.partidosByIdJornada(resultado.getInt("IDJORNADA")));
                
        BaseDatos.desconectar();
                
        return j;  
    }
    
    public static ArrayList<Jornada> allJornadas() throws Exception{
        BaseDatos.conectar();
        con = BaseDatos.getCon();
        
        PreparedStatement ps = con.prepareStatement("SELECT * FROM JORNADAS;");


        ResultSet resultado = ps.executeQuery();

        ArrayList<Jornada> jornadas= new ArrayList();
        while(resultado.next()){
            Jornada j = new Jornada();
            j.setIdJornada(resultado.getInt("IDJORNADA"));
            LocalDate fecha = resultado.getDate("FECHA").toLocalDate();
            j.setFecha(fecha);
            j.setTorneo(tablaTorneos.torneoById(resultado.getInt("IDTORNEO")));
            j.setPartidos(tablaPartidos.partidosByIdJornada(resultado.getInt("IDJORNADA")));
                    
            BaseDatos.desconectar();
        }
        if(!jornadas.isEmpty()){
            return jornadas;
        }
        else{
            return null;
        } 
    }
}
