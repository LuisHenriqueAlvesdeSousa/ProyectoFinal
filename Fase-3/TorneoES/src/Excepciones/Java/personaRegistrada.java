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
public class personaRegistrada extends Exception{
    String mensaje = "La persona ya esta registrada en la BD.";

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
