
package com.mycompany.fitlifegym_negocio;

/**
 * Excepción personalizada utilizada para representar
 * errores ocurridos en la capa de negocio del sistema.
 * 
 * Permite encapsular mensajes y causas relacionadas
 * con validaciones o fallos durante la ejecución
 * de operaciones de negocio.
 * 
 * @author Luis
 */
public class NegocioException extends Exception{
    /**
     * Constructor vacío de la excepción.
     */
    public NegocioException() {
    }

    /**
     * Constructor que recibe un mensaje descriptivo.
     * 
     * @param message Mensaje de error.
     */
    public NegocioException(String message) {
        super(message);
    }

    /**
     * Constructor que recibe un mensaje
     * y la causa original de la excepción.
     * 
     * @param message Mensaje de error.
     * @param cause Excepción causante.
     */
    public NegocioException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructor que recibe únicamente
     * la causa original de la excepción.
     * 
     * @param cause Excepción causante.
     */
    public NegocioException(Throwable cause) {
        super(cause);
    }

    /**
     * Constructor completo que permite configurar
     * la supresión y escritura del stack trace.
     * 
     * @param message Mensaje de error.
     * @param cause Excepción causante.
     * @param enableSuppression Indica si la supresión está habilitada.
     * @param writableStackTrace Indica si el stack trace es escribible.
     */
    public NegocioException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
}
