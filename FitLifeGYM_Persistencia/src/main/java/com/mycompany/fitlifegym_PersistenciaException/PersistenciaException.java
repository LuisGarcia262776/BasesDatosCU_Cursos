/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.fitlifegym_PersistenciaException;

/**
 * Excepción personalizada utilizada
 * para representar errores relacionados
 * con la capa de persistencia.
 * 
 * Permite manejar errores generados
 * durante operaciones con la base de datos.
 * 
 * @author PC GAMER MASTER RACE
 */
public class PersistenciaException extends Exception {

    /**
     * Constructor vacío de la excepción.
     */
    public PersistenciaException() {
    }

    /**
     * Constructor que recibe
     * un mensaje de error.
     * 
     * @param message Mensaje descriptivo del error.
     */
    public PersistenciaException(String message) {
        super(message);
    }

    /**
     * Constructor que recibe
     * un mensaje y la causa del error.
     * 
     * @param message Mensaje descriptivo del error.
     * @param cause Excepción que originó el error.
     */
    public PersistenciaException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructor que recibe
     * la causa del error.
     * 
     * @param cause Excepción que originó el error.
     */
    public PersistenciaException(Throwable cause) {
        super(cause);
    }

    /**
     * Constructor completo de la excepción.
     * 
     * @param message Mensaje descriptivo del error.
     * @param cause Excepción que originó el error.
     * @param enableSuppression Indica si la supresión está habilitada.
     * @param writableStackTrace Indica si el stack trace es modificable.
     */
    public PersistenciaException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
    
}
