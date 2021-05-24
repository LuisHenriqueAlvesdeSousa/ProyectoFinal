package BD;

import java.sql.CallableStatement;
import java.sql.Connection;

/**
 *
 * @author Luis
 */
public class procesosXML {
    private static Connection con;
    
    public static void actualizarTodasJornadas() throws Exception{
        BaseDatos.conectar();
        con = BaseDatos.getCon();
        
        CallableStatement cs = con.prepareCall("TODAS_JORNADA");
        
        boolean realizado = cs.execute();
        
        if(!realizado)
            System.out.println("Error Actualizando XML de base de datos");
        
        BaseDatos.desconectar();
    }
    
    public static void actualizarUltimaJornada() throws Exception{
        BaseDatos.conectar();
        con = BaseDatos.getCon();
        
        CallableStatement cs = con.prepareCall("ULTI_JORNADA");
        
        boolean realizado = cs.execute();
        
        if(!realizado)
            System.out.println("Error Actualizando XML de base de datos");
        
        BaseDatos.desconectar();
    }
    
    public static void actualizarClasificacionGeneral() throws Exception{
        BaseDatos.conectar();
        con = BaseDatos.getCon();
        
        CallableStatement cs = con.prepareCall("CLASI_GENERAL");
        
        boolean realizado = cs.execute();
        
        if(!realizado)
            System.out.println("Error Actualizando XML de base de datos");
        
        BaseDatos.desconectar();
    }
}
