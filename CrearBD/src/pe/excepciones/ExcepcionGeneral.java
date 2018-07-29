/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.excepciones;

/**
 *
 * @author Canchito
 */
public class ExcepcionGeneral extends RuntimeException {
    
    public ExcepcionGeneral(){
        this("ocurrio una excepcion");
    }
    
    public ExcepcionGeneral(String mensaje){
        super(mensaje);
    }
}
