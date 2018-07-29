/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.dao.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Canchito
 */
public class MySQLConexion {
    
    Connection conectar() throws SQLException{
        Connection conexion = null;
        String url = "jdbc:mysql://localhost/dbcrear";
        //cuando nos obliga en java poner en un try catch se llama una exepcion verificada
        try {
            conexion = DriverManager.getConnection(url, "root", "");
        } catch (SQLException sqle) {
            throw sqle;
        }
        
        return  conexion;
    }
    
    
}
