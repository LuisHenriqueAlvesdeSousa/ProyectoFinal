package BD;

import UML.Jornada;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
/**
 *
 * @author ROber
 */
public class tablaJornadas {
    private static Connection con;

    public static void crearJornada(Jornada j) throws Exception{
        BaseDatos.conectar();
        con = BaseDatos.getCon();
        
        PreparedStatement ps = con.prepareStatement("INSERT INTO JORNADAS (FECHA, IDTORNEO) VALUES (?, ?);");
        Date fecha = Date.valueOf(j.getFecha());
        ps.setDate(1, fecha);
        ps.setInt(1, j.getTorneo().getIdTorneo());
        
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
    
    public static Jornada jornadaByIdJornada(String idJornada) throws Exception{
        BaseDatos.conectar();
        con = BaseDatos.getCon();
        
        PreparedStatement ps = con.prepareStatement("SELECT * FROM JORNADAS WHERE UPPER(IDJORNADA)=UPPER(?);");
        ps.setString(1, idJornada);

        ResultSet resultado = ps.executeQuery();
        
       

        Jornada j = new Jornada();
        j.setIdJornada(resultado.getInt("IDJORNADA"));
        LocalDate fecha = resultado.getDate("FECHA").toLocalDate();
        j.setFecha(fecha);
        j.setTorneo(tablaTorneos.torneoByIdTorneo(resultado.getInt("IDTORNEO")));
                
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
            j.setTorneo(tablaTorneos.torneoByIdTorneo(resultado.getInt("IDTORNEO")));
        }
        
        BaseDatos.desconectar();
        
        if(!jornadas.isEmpty()){
            return jornadas;
        }
        else{
            return null;
        } 
    }
}
