/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package com.mycompany.fitlifegym_dtos;

/**
 * Enum que representa los posibles estados de disponibilidad
 * de un curso dentro del sistema.
 * 
 * @author PC GAMER MASTER RACE
 */
public enum DisponibilidadCursoDTO {
    /**
     * El curso se encuentra disponible para inscripciones.
     */
    DISPONIBLE,
    
    /**
     * El curso no se encuentra disponible.
     */
    NO_DISPONIBLE,
    
    /**
     * El curso no cuenta con horarios registrados.
     */
    SIN_HORARIOS
}
