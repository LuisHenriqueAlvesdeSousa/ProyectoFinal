package Excepciones.Java;

/**
 *
 * @author Luis H. Alves
 */
public class limiteCaracteres extends Exception{
    String mensaje = "Limite de caraacteres de la BD superado.";

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
    
}
