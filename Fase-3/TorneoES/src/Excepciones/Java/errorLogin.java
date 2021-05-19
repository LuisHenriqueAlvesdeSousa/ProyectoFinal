package Excepciones.Java;

/**
 *
 * @author Luis H. Alves
 */
//Si da error la contraseña o el usuario en el login
public class errorLogin extends Exception{
    String mensaje = "Usuario y/o contraseña incorrecto.";

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
    
}
