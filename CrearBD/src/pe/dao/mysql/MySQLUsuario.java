/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.dao.mysql;

import com.mysql.jdbc.MySQLConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pe.dao.interfaces.usuariosDAO;
import pe.excepciones.ExcepcionGeneral;
import pe.modelos.usuarios;

/**
 *
 * @author Canchito
 */
public class MySQLUsuario implements usuariosDAO{
    
    private final String INSERTAR = "INSERT INTO usuarios(usuario,clave,correo) VALUES"
            + "(?,md5(?),?)";
    
    private final String MODIFICAR = "UPDATE usuarios SET usuario = ?, clave = md5(?), correo = ? WHERE id_usuario=?";
    
    private final String ELIMINAR = "DELETE FROM usuarios WHERE id_usuario=?";
    
    private final String OBTENERID = "SELECT id_usuario, usuario, clave, correo FROM usuarios WHERE "
            + "id_usuario = ?";
    
    private final String OBTENER = "SELECT id_usuario, usuario, clave, correo FROM usuarios";
    
    private Connection conexion;
    private PreparedStatement sentencia;
    private ResultSet resultados;
    
    
    @Override
    public void insertar(usuarios o) throws ExcepcionGeneral {
        try {
            conexion = new MySQLConexion().conectar();
            sentencia = conexion.prepareStatement(INSERTAR);
            sentencia.setString(1, o.getUsuario());
            sentencia.setString(2, o.getClave());
            sentencia.setString(3, o.getCorreo());
            //sentencia tipo update
            //execute update = insert, update, delete
            //execute query = select
            
            int r = sentencia.executeUpdate();
            if(r == 0){
                throw new ExcepcionGeneral("No se inserto el registro");
            }
            /*resultados = sentencia.getGeneratedKeys();
            if(resultados.next()){
                o.setId_usuario(resultados.getInt(1));
            }*/
        } catch (SQLException sqle) {
            throw new ExcepcionGeneral(sqle.getMessage());
        }
    }

    @Override
    public void modificar(usuarios o) {
        try {
            conexion = new MySQLConexion().conectar();
            sentencia = conexion.prepareStatement(MODIFICAR);
            sentencia.setString(1, o.getUsuario());
            sentencia.setString(2, o.getClave());
            sentencia.setString(3, o.getCorreo());
            sentencia.setInt(4, o.getId_usuario());
            int r = sentencia.executeUpdate();
            if (r==0) {
                throw new ExcepcionGeneral("No se modifico el registro");
            }
        } catch (SQLException sqle) {
            throw new ExcepcionGeneral(sqle.getMessage());
        }
        finally{
            cerrarConexiones();
        }
    }

    @Override
    public void eliminar(usuarios o) {
        try {
            conexion = new MySQLConexion().conectar();
            sentencia = conexion.prepareStatement(ELIMINAR);
            sentencia.setInt(1, o.getId_usuario());
            int r = sentencia.executeUpdate();
            if (r==0) {
                throw new ExcepcionGeneral("No se ELIMINO el registro");
            }
        } catch (SQLException sqle) {
            throw new ExcepcionGeneral(sqle.getMessage());
        }
        finally{
            cerrarConexiones();
        }
    }

    @Override
    public usuarios obtenerPorId(Integer k) {
        usuarios usuario = null;
        try {
            conexion = new MySQLConexion().conectar();
            sentencia = conexion.prepareStatement(OBTENERID);
            sentencia.setInt(1, k);
            resultados = sentencia.executeQuery();
            if(resultados.next()){
                usuario = new usuarios();
                usuario.setId_usuario(resultados.getInt("id_usuario"));
                usuario.setUsuario(resultados.getString("usuario"));
                usuario.setClave(resultados.getString("clave"));
                usuario.setCorreo(resultados.getString("correo"));
            }
        } catch (SQLException sqle) {
            throw new ExcepcionGeneral(sqle.getMessage());
        }
        finally{
            cerrarConexiones();
        }
        return usuario;
    }

    @Override
    public List<usuarios> listar() {
        List<usuarios> listado = new ArrayList<>();
        
        try {
            conexion = new MySQLConexion().conectar();
            sentencia = conexion.prepareStatement(OBTENER);
            resultados = sentencia.executeQuery();
            
            while(resultados.next()){
                usuarios usuario = new usuarios();
                usuario.setId_usuario(resultados.getInt("id_usuario"));
                usuario.setUsuario(resultados.getString("usuario"));
                usuario.setClave(resultados.getString("clave"));
                usuario.setCorreo(resultados.getString("correo"));
                listado.add(usuario);
                
            }
        } catch (SQLException sqle) {
            throw new ExcepcionGeneral(sqle.getMessage());
        }
        finally{
            cerrarConexiones();
        }
        return listado;
        
    }
    
    private void cerrarConexiones(){
        try {
            if (resultados != null) {
                resultados.close();
            }
            if (sentencia != null) {
                sentencia.close();
            }
            if (conexion != null) {
                conexion.close();
            }
        } catch (SQLException sqle) {
            
        }
    }
}
