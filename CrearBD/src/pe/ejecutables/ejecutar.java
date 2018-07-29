/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.ejecutables;

import java.util.List;
import pe.dao.mysql.MySQLUsuario;
import pe.excepciones.ExcepcionGeneral;
import pe.modelos.usuarios;

/**
 *
 * @author Canchito
 */
public class ejecutar {
    
    public static void main(String[] args) {
        usuarios user = new usuarios();
        //user.setId_usuario(4);
        user.setUsuario("edigital2");
        user.setClave("789");
        user.setCorreo("kenny.flores.27@gmail.com");
        
        MySQLUsuario mysqluser = new MySQLUsuario();
        try {
            
            //List<usuarios> listar = mysqluser.listar();
            mysqluser.insertar(user);
            System.out.println("Usuario insertdado con Id" + user.getId_usuario());
            //System.out.println(usuario);
            //for (usuarios u: listar) {
            //    System.out.println(u);
            //}
        } catch (ExcepcionGeneral e) {
            System.out.println(e.getMessage());
        }
        
    }
    
}
