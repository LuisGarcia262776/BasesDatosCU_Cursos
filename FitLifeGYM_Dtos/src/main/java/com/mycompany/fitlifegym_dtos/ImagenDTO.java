/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.fitlifegym_dtos;

/**
 * DTO que representa una imagen dentro del sistema.
 * 
 * Contiene la ruta de acceso de la imagen asociada
 * a diferentes entidades como cursos.
 * 
 * @author PC GAMER MASTER RACE
 */
public class ImagenDTO {
    /**
     * Ruta de acceso de la imagen.
     */
    private final String ruta;

    /**
     * Constructor que inicializa la ruta de la imagen.
     * 
     * @param ruta Ruta de acceso de la imagen.
     */
    public ImagenDTO(String ruta) {
        this.ruta = ruta;
    }

    /**
     * Obtiene la ruta de la imagen.
     * 
     * @return Ruta de la imagen.
     */
    public String getRuta() {
        return ruta;
    }
    
}
