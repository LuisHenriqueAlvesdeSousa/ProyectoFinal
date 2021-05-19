package Excepciones.Java;

public class jugadorRegistrado extends Exception{
    String mensaje = "Ya hay un jugador registrado en la base de datos con ese nombre.";

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
