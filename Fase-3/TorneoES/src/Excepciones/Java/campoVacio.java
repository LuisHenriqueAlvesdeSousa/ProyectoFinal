/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Excepciones.Java;

/**
 *
 * @author 1GDAW04
 */

//Crear switch con todos los atributos
public class campoVacio extends Exception{

     public campoVacio(String message) {
        super(message);
    }

    public campoVacio() {
        super("No se permite dejar los campos vacios.");
    }
    


    
}
