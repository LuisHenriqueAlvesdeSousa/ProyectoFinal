/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BD;

import java.sql.*;
/**
 *
 * @author 1GDAW04
 */
public class BaseDatos {
    
    private static Connection con;
    
    public static void BaseDatos() {
    
}
    
    public static void conectar(){
        try{
            Class.forName("oracle.jdbc.OracleDriver");
            
            String bd = "ORCL";
            String url = "jdbc:oracle:thin:@SrvOracle:1521:orcl";
            String login = "eqdaw02";
            String password = "eqdaw02";
            con = DriverManager.getConnection(url,login,password);
            
            if (con == null){
                throw new Exception("Problemas con la conexión");
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }        
    }
    
    public static void desconectar(){
        try{
            con.close();
        }
        catch(Exception e){
            System.out.println("Problemas cerrando la conexión");
        }
    }
    
    public static Connection getCon(){
        return con;
    }
}
