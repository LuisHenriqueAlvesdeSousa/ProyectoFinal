/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package torneoes;

import BD.BaseDatos;

/**
 *
 * @author 1GDAW04
 */
public class TorneoES {


    public static void main(String[] args) {
        try{
            BaseDatos.conectar();
        }
        catch(Exception e){
            System.out.println("Error");
        }
        
    }
    
}
