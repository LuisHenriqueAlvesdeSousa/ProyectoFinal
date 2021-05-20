package BD;

import UML.Partido;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Luis H. Alves
 */
public class tablaPartidos {
    private static Connection con;

    public static void crearPartido(Partido p) throws Exception{
        BaseDatos.conectar();
        con = BaseDatos.getCon();
        
        PreparedStatement ps = con.prepareStatement("INSERT INTO PARTIDOS (HORA, IDJO0RNADA) VALUES (?, ?, ?)");
        ps.setTime(1, java.sql.Time.valueOf(p.getHora()));
        ps.setInt(2, p.getJornada().getIdJornada());
    
        int n = ps.executeUpdate();
        
        if(n != 1)
            throw new Exception("Se ha insertado más de un Partido.");
        
        System.out.println("Partido insertado con exito.");
        
        BaseDatos.desconectar();
        
    }
    
    public static void modHoraPartiddo(Partido p) throws Exception{
        BaseDatos.conectar();
        con = BaseDatos.getCon();
        
        PreparedStatement ps = con.prepareStatement("UPDATE PARTIDOS SET HORA = ? WHERE IDPARTIDO = ?");
        ps.setTime(1, java.sql.Time.valueOf(p.getHora()));
        ps.setInt(2, p.getIdPartido());

        int n = ps.executeUpdate();
        
        BaseDatos.desconectar();
        
        if( n > 1)
            throw new Exception("Se ha modificado mas de un Partido.");
    }
    
    public static void eliminarPartido(Partido p)  throws Exception{
        BaseDatos.conectar();
        con = BaseDatos.getCon();
        
        PreparedStatement ps = con.prepareStatement("DELETE FROM PARTIDOS WHERE IDPARTIDO = ?");
        ps.setInt(1, p.getIdPartido());

        int n = ps.executeUpdate();  
        
        BaseDatos.desconectar();
        
        if( n > 1)
            throw new Exception("Se ha eliminado mas de una Partido");
    }
    
    
    public static Partido partidoById(int idPartido) throws Exception{
        BaseDatos.conectar();
        con = BaseDatos.getCon();
        
        PreparedStatement ps = con.prepareStatement("SELECT * FROM PARTIDOS WHERE IDPARTIDO = ?");
        ps.setInt(1, idPartido);

        ResultSet resultado = ps.executeQuery();
        
        Partido p = new Partido();
        p.setIdPartido(resultado.getInt("IDPARTIDO"));
        p.setHora(resultado.getTime("HORA").toLocalTime());
        p.setJornada(tablaJornadas.jornadaByIdJornada(resultado.getString("IDJORNADA")));

        BaseDatos.desconectar();
        return p;  
    }
    
    
    public static ArrayList<Partido> allPartidos() throws Exception{
        BaseDatos.conectar();
        con = BaseDatos.getCon();
        
        PreparedStatement ps = con.prepareStatement("SELECT * FROM PARTIDOS");


        ResultSet resultado = ps.executeQuery();

        ArrayList<Partido> listaPartidos= new ArrayList();
        while(resultado.next()){
            Partido p = new Partido();
            p.setIdPartido(resultado.getInt("IDPARTIDO"));
            p.setHora(resultado.getTime("HORA").toLocalTime());
            p.setJornada(tablaJornadas.jornadaByIdJornada(resultado.getString("IDJORNADA")));
            
            listaPartidos.add(p);
        }
        
        BaseDatos.desconectar();
        if(!listaPartidos.isEmpty()){
            return listaPartidos;
        }
        else{
            return null;
        }
    }
    
    
    public static ArrayList<Partido> partidosByIdJornada(int idJornada) throws Exception{
        BaseDatos.conectar();
        con = BaseDatos.getCon();
        
        PreparedStatement ps = con.prepareStatement("SELECT * FROM PARTIDOS WHERE IDPARTIDO = ?");
        ps.setInt(1, idJornada);

        ResultSet resultado = ps.executeQuery();

        ArrayList<Partido> listaPartidos= new ArrayList();
        while(resultado.next()){
            Partido p = new Partido();
            p.setIdPartido(resultado.getInt("IDPARTIDO"));
            p.setHora(resultado.getTime("HORA").toLocalTime());
            p.setJornada(tablaJornadas.jornadaByIdJornada(resultado.getString("IDJORNADA")));
            
            listaPartidos.add(p);
        }
        
        BaseDatos.desconectar();
        
        if(listaPartidos.isEmpty()){
           return null;
        }
        
        return listaPartidos;
    }
}




