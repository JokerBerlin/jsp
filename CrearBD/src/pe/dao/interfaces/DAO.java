/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.dao.interfaces;

import java.util.List;

/**
 *
 * @author Canchito
 */
public interface DAO<llave, objeto> {
    
    public void insertar(objeto o);
    public void modificar(objeto o);
    public void eliminar(objeto o);
    public objeto obtenerPorId(llave k);
    public List<objeto> listar();
    
}
