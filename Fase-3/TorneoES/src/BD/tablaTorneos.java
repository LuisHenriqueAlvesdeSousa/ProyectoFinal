
package BD;

import UML.Torneo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class tablaTorneos {
    private static Connection con;

    public tablaTorneos(Connection con) {
        this.con = con;
    }
    
    public static void crearTorneo(Torneo t) throws Exception{
        PreparedStatement ps = con.prepareStatement("INSERT INTO TORNEOS (ESTADO) VALUES (?);");
        ps.setString(1, t.getEstado());

        ps.executeUpdate();  
        
    }
    
    public static void modTorneo(Torneo t)  throws Exception{
        PreparedStatement ps = con.prepareStatement("UPDATE TORNEOS SET ESTADO=? WHERE IDTORNEO=?;");
        ps.setString(1, t.getEstado());
        ps.setInt(2, t.getIdTorneo());

        int n = ps.executeUpdate();
        
        if( n > 1)
            throw new Exception("Se ha modificado mas de un torneo");
    }
    
    public static void eliminarTorneo(Torneo t)  throws Exception{
        PreparedStatement ps = con.prepareStatement("DELETE FROM TORNEOS WHERE IDTORNEO=?;");
        ps.setInt(1, t.getIdTorneo());

        int n = ps.executeUpdate();  
        
        if( n > 1)
            throw new Exception("Se ha eliminado mas de un torneo");
    }
    
    public static Torneo torneoById(int idTorneo) throws Exception{
        PreparedStatement ps = con.prepareStatement("SELECT * FROM TORNEOS WHERE UPPER(IDTORNEO)=UPPER(?);");
        ps.setInt(1, idTorneo);

        ResultSet resultado = ps.executeQuery();

        Torneo t = new Torneo();
        t.setIdTorneo(resultado.getInt("IDTORNEO"));
        if(resultado.getString("ESTADO").equalsIgnoreCase("ABIERTO")){
            t.setEstadoAbierto();
        }
        else{
            t.setEstadoCerrado();
        }
        return t;  
    }
    
    public static ArrayList<Torneo> allTorneos() throws Exception{
        PreparedStatement ps = con.prepareStatement("SELECT * FROM TORNEOS;");

        ResultSet resultado = ps.executeQuery();

        ArrayList<Torneo> torneos = new ArrayList();
        
        while(resultado.next()){
            Torneo t = new Torneo();
            t.setIdTorneo(resultado.getInt("IDTORNEO"));
            if(resultado.getString("ESTADO").equalsIgnoreCase("ABIERTO")){
                t.setEstadoAbierto();
            }
            else{
                t.setEstadoCerrado();
            }
            torneos.add(t);
        }
        if(torneos.isEmpty())
            return null;
        
        return torneos;
    }
    
    public static boolean existeTorneo(int idTorneo) throws Exception{
        PreparedStatement ps = con.prepareStatement("SELECT 'X' FROM TORNEOS WHERE UPPER(IDTORNEO)=UPPER(?);");
        ps.setInt(1, idTorneo);

        ResultSet resultado = ps.executeQuery();

        boolean existe = false;
        if(resultado.next())
            existe = true;

        return existe;
        
    }
}
