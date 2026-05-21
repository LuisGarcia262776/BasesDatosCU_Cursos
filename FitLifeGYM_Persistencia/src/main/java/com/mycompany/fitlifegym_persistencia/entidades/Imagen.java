/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.fitlifegym_persistencia.entidades;

/**
 * Entidad que representa
 * una imagen dentro del sistema.
 * 
 * Contiene la ruta utilizada
 * para acceder a la imagen
 * asociada a otras entidades.
 * 
 * @author PC GAMER MASTER RACE
 */
public class Imagen {
    /**
     * Ruta de la imagen.
     */
    private String ruta;

    /**
     * Constructor vacío de la clase.
     */
    public Imagen() {
    }

    /**
     * Constructor que inicializa
     * la ruta de la imagen.
     * 
     * @param ruta Ruta de la imagen.
     */
    public Imagen(String ruta) {
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

    /**
     * Establece la ruta de la imagen.
     * 
     * @param ruta Nueva ruta de la imagen.
     */
    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    /**
     * Obtiene la representación
     * en texto de la imagen.
     * 
     * @return Ruta de la imagen.
     */
    @Override
    public String toString() {
        return ruta;
    }
    
}
