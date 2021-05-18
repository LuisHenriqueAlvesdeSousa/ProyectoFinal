/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Excepciones.Java;

/**
 *
 * @author 1gdaw06
 */
public class jugadorNoEncontrado extends Exception{
    String mensaje = "No se ha encontrado ningun jugador con esos datos.";

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
