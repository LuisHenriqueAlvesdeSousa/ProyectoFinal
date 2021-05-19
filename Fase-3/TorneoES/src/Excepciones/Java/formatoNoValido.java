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
public class formatoNoValido extends Exception{

    public formatoNoValido(String message) {
        super(message);
    }

    public formatoNoValido() {
        super("El fomato no es valido.");
    }
    
    

   
}
