/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package com.mycompany.fitlifegym_persistencia.entidades;

/**
 * Enumeración que representa
 * el estado de una inscripción
 * dentro del sistema.
 * 
 * Define los posibles estados
 * en los que puede encontrarse
 * una inscripción.
 * 
 * @author PC GAMER MASTER RACE
 */
public enum EstadoInscripcion {
    /**
     * Indica que la inscripción
     * se encuentra activa.
     */
    ACTIVO,
    
    /**
     * Indica que la inscripción
     * fue cancelada.
     */
    CANCELADA,
    
    /**
     * Indica que el cliente
     * ya se encuentra inscrito.
     */
    YA_INSCRITO,
    
    /**
     * Indica que el cliente
     * no se encuentra inscrito.
     */
    NO_INSCRITO
}
