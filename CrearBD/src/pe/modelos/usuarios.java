/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.modelos;

/**
 *
 * @author Canchito
 */
public class usuarios {
    private int id_usuario;
    private String usuario;
    private String clave;
    private String correo;

    public usuarios() {
    }

    public usuarios(int id_usuario, String usuario, String clave, String correo) {
        this.id_usuario = id_usuario;
        this.usuario = usuario;
        this.clave = clave;
        this.correo = correo;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @Override
    public String toString() {
        return "usuarios{" + "id_usuario=" + id_usuario + ", usuario=" + usuario + ", clave=" + clave + ", correo=" + correo + '}';
    }
    
    
}
