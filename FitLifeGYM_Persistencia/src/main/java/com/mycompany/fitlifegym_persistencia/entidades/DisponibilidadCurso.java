/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package com.mycompany.fitlifegym_persistencia.entidades;

/**
 * Enumeración que representa
 * la disponibilidad de un curso
 * dentro del sistema.
 * 
 * Define los posibles estados
 * en los que puede encontrarse
 * un curso.
 * 
 * @author PC GAMER MASTER RACE
 */
public enum DisponibilidadCurso {
    /**
     * Indica que el curso
     * se encuentra disponible.
     */
    DISPONIBLE,
    
    /**
     * Indica que el curso
     * no se encuentra disponible.
     */
    NO_DISPONIBLE,
    
    /**
     * Indica que el curso
     * no cuenta con horarios asignados.
     */
    SIN_HORARIOS
}
