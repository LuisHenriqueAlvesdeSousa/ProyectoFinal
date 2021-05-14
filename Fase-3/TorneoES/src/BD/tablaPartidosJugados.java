/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BD;

import UML.PartidoJugado;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author 1GDAW04
 */
public class tablaPartidosJugados {
    private static Connection con;

    public tablaPartidosJugados(Connection con) {
        this.con = con;
    }
    
    public static void crearPartidoJugado(PartidoJugado p) throws Exception{
        PreparedStatement ps = con.prepareStatement("INSERT INTO PARTIDOS_JUGADOS (IDEQUIPO, IDPARTIDO, PUNTUACION) "
                + "VALUES (?, ?, ?);");
        ps.setInt(1, p.getEquipo().getIdEquipo());
        ps.setInt(2, p.getIdPartido());
        ps.setInt(3, p.getPuntuacion());
        
        ps.executeUpdate();  
        
    }
    
    public static void modPartidoJugado(PartidoJugado p)  throws Exception{
        PreparedStatement ps = con.prepareStatement("UPDATE PARTIDOS_JUGADOS SET PUNTUACION=?"
                                                    + " WHERE IDPARTIDO=? AND IDEQUIPO=?;");
        ps.setInt(1, p.getPuntuacion());
        ps.setInt(2, p.getIdPartido());
        ps.setInt(3, p.getEquipo().getIdEquipo());

        int n = ps.executeUpdate();
        
        if( n > 1)
            throw new Exception("Se ha modificado mas de un resultado de partido");
    }
    
    public static void eliminarPartidoJugado(PartidoJugado p)  throws Exception{
        PreparedStatement ps = con.prepareStatement("DELETE FROM PARTIDOS_JUGADOS WHERE IDPARTIDO=? AND "
                                                    + "IDEQUIPO=?;");
        ps.setInt(1, p.getIdPartido());
        ps.setInt(1, p.getEquipo().getIdEquipo());

        int n = ps.executeUpdate();  
        
        if( n > 1)
            throw new Exception("Se ha eliminado mas de un resultado de partido");
    }
    
    public static PartidoJugado partidoJugadoById(int idPartido, int idEquipo) throws Exception{
        PreparedStatement ps = con.prepareStatement("SELECT * FROM TORNEOS WHERE IDPARTIDO=? AND "
                                                    + "IDEQUIPO=?;");
        ps.setInt(1, idPartido);
        ps.setInt(1, idEquipo);

        ResultSet resultado = ps.executeQuery();

        PartidoJugado p = new PartidoJugado();
        p.setEquipo();//relacion equipos);
        p.setIdPartido(idPartido);
        p.setPuntuacion(resultado.getInt("PUNTUACION"));
        
        return p;
    }
}
