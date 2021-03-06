package BD;

import UML.PartidoJugado;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Rober
 */
public class tablaPartidosJugados {
    private static Connection con;

    public tablaPartidosJugados(Connection con) {
        this.con = con;
    }
    
    public static void crearPartidoJugado(PartidoJugado p) throws Exception{
        BaseDatos.conectar();
        con = BaseDatos.getCon();
        
        PreparedStatement ps = con.prepareStatement("INSERT INTO PARTIDOS_JUGADOS (IDEQUIPO, IDPARTIDO, PUNTUACION) "
                + "VALUES (?, ?, ?)");
        ps.setInt(1, p.getEquipo().getIdEquipo());
        ps.setInt(2, p.getPartido().getIdPartido());
        ps.setInt(3, p.getPuntuacion());
        
        ps.executeUpdate();  
        
        BaseDatos.desconectar();        
    }
    
    public static void modPartidoJugado(PartidoJugado p)  throws Exception{
        BaseDatos.conectar();
        con = BaseDatos.getCon();
        
        PreparedStatement ps = con.prepareStatement("UPDATE PARTIDOS_JUGADOS SET PUNTUACION=?"
                                                    + " WHERE IDPARTIDO=? AND IDEQUIPO=?");
        ps.setInt(1, p.getPuntuacion());
        ps.setInt(2, p.getPartido().getIdPartido());
        ps.setInt(3, p.getEquipo().getIdEquipo());

        int n = ps.executeUpdate();
        
        BaseDatos.desconectar();
        
        if( n > 1)
            throw new Exception("Se ha modificado mas de un resultado de partido");
    }
    
    public static void eliminarPartidoJugado(PartidoJugado p)  throws Exception{
        BaseDatos.conectar();
        con = BaseDatos.getCon();
        
        PreparedStatement ps = con.prepareStatement("DELETE FROM PARTIDOS_JUGADOS WHERE IDPARTIDO=? AND "
                                                    + "IDEQUIPO=?");
        ps.setInt(1, p.getPartido().getIdPartido());
        ps.setInt(2, p.getEquipo().getIdEquipo());

        int n = ps.executeUpdate();  
        
        BaseDatos.desconectar();
        
        if( n > 1)
            throw new Exception("Se ha eliminado mas de un resultado de partido");
    }
    
    public static PartidoJugado partidoJugadoById(int idPartido, int idEquipo) throws Exception{
        BaseDatos.conectar();
        con = BaseDatos.getCon();
        
        PreparedStatement ps = con.prepareStatement("SELECT * FROM TORNEOS WHERE IDPARTIDO=? AND "
                                                    + "IDEQUIPO=?");
        ps.setInt(1, idPartido);
        ps.setInt(2, idEquipo);

        ResultSet resultado = ps.executeQuery();

        PartidoJugado p = new PartidoJugado();
        p.setEquipo(tablaEquipos.equipoByIdEquipo(resultado.getString("IDEQUIPO")));
        p.setPartido(tablaPartidos.partidoById(resultado.getInt("IDPARTIDO")));
        p.setPuntuacion(resultado.getInt("PUNTUACION"));
        
        BaseDatos.desconectar();
        
        return p;
    }
    
    public static ArrayList<PartidoJugado> allPartidosJugados() throws Exception{
        BaseDatos.conectar();
        con = BaseDatos.getCon();
        
        PreparedStatement ps = con.prepareStatement("SELECT IDEQUIPO, IDPARTIDO, NVL(PUNTUACION, 0) FROM PARTIDOS_JUGADOS");
        

        ResultSet resultado = ps.executeQuery();
        
        ArrayList<PartidoJugado> partidos = new ArrayList(); 
        while(resultado.next()){
            PartidoJugado p = new PartidoJugado();
            p.setEquipo(tablaEquipos.equipoByIdEquipo(resultado.getString("IDEQUIPO")));
            p.setPartido(tablaPartidos.partidoById(resultado.getInt("IDPARTIDO")));
            p.setPuntuacion(resultado.getInt("PUNTUACION"));
            partidos.add(p);
        }
        
        BaseDatos.desconectar();
        
        return partidos;
    }
    
    public static ArrayList<PartidoJugado> allPartidosJugadosByIdPartido(int idPartido) throws Exception{
        BaseDatos.conectar();
        con = BaseDatos.getCon();
         
        PreparedStatement ps = con.prepareStatement("SELECT IDEQUIPO, IDPARTIDO, NVL(PUNTUACION, 0) FROM PARTIDOS_JUGADOS WHERE IDPARTIDO = ?");
        ps.setInt(1, idPartido);

        ResultSet resultado = ps.executeQuery();
        
        ArrayList<PartidoJugado> partidos = new ArrayList(); 
        while(resultado.next()){
            PartidoJugado p = new PartidoJugado();
            p.setEquipo(tablaEquipos.equipoByIdEquipo(resultado.getString("IDEQUIPO")));
            p.setPartido(tablaPartidos.partidoById(resultado.getInt("IDPARTIDO")));
            p.setPuntuacion(resultado.getInt("PUNTUACION"));
            partidos.add(p);
        }
        
        BaseDatos.desconectar();
        
        return partidos;
    }
    
    public static String top3() throws Exception{
        BaseDatos.conectar();
        con = BaseDatos.getCon();
        
        CallableStatement cs = con.prepareCall("TOP_3_EQUIPOS");
        
        ResultSet resultado = cs.executeQuery();
        
        String top = ""; 
        while(resultado.next()){
            top += tablaEquipos.equipoByIdEquipo(resultado.getString("IDEQUIPO")).getNombre() + " : " + resultado.getString("PUNTUACION") + "\n";
        }
        
        BaseDatos.desconectar();
        
        return top;
    }
}
