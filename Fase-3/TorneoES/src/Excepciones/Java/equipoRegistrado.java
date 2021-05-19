package Excepciones.Java;

public class equipoRegistrado extends Exception{
    String mensaje = "Ya hay un equipo registrado con el mismo nombre.";

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
