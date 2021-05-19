package UML;

public class Perfil {

    private int idPerfil;
    private String usuario;
    private String passwd;
    private String privilegios;

    public Perfil() {
    }
    
    public Perfil(int idPerfil, String usuario, String passwd, String privilegios) {
        this.idPerfil = idPerfil;
        this.usuario = usuario;
        this.passwd = passwd;
        this.privilegios = privilegios;
    }

    public int getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(int idPerfil) {
        this.idPerfil = idPerfil;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getPrivilegios() {
        return privilegios;
    }

    public void setPrivilegiosAdmin() {
        this.privilegios = "ADMIN";
    }
    
    public void setPrivilegiosUser(){
        this.privilegios = "USER";
    }
    
    
}
