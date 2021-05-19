package Excepciones.Java;

public class usuarioRegistrado extends Exception{
    String mensaje = "Ya hay un usuario registrado en la BD.";

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
