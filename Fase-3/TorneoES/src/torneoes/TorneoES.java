package torneoes;

import BD.BaseDatos;
<<<<<<< Updated upstream
import java.sql.*;
=======
import Views.vLogin;
>>>>>>> Stashed changes

/**
 *
 * @author Grupo 2 
 */
public class TorneoES {


    public static void main(String[] args) {
        try{
<<<<<<< Updated upstream
            BaseDatos.conectar();
            	            
            
=======
            vLogin l = new vLogin();
            l.setVisible(true);
>>>>>>> Stashed changes
        }
        catch(Exception e){
            System.out.println("Error");
        }
        
    }
    
}
