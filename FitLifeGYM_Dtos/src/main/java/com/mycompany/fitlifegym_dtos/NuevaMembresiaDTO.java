/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.fitlifegym_dtos;

import java.time.LocalDate;

/**
 * DTO que representa una membresía disponible
 * dentro del sistema.
 * 
 * Contiene la información relacionada con el tipo
 * de membresía, precio y vigencia.
 * 
 * @author PC GAMER MASTER RACE
 */
public class NuevaMembresiaDTO {
    /**
     * ID único de la membresía.
     */
    private String idMembresia;
    
    /**
     * Tipo de membresía.
     */
    private TipoMembresiaDTO tipoMembresia;
    
    /**
     * Precio de la membresía.
     */
    private Double precio;
    
    /**
     * Fecha de vigencia de la membresía.
     */
    private LocalDate vigencia;

    /**
     * Constructor que inicializa todos los datos
     * de la membresía.
     * 
     * @param idMembresia ID de la membresía.
     * @param tipoMembresia Tipo de membresía.
     * @param precio Precio de la membresía.
     * @param vigencia Fecha de vigencia.
     */
    public NuevaMembresiaDTO(String idMembresia, TipoMembresiaDTO tipoMembresia, Double precio, LocalDate vigencia) {
        this.idMembresia = idMembresia;
        this.tipoMembresia = tipoMembresia;
        this.precio = precio;
        this.vigencia = vigencia;
    }

    /**
     * Constructor para registrar una nueva membresía.
     * 
     * @param tipoMembresia Tipo de membresía.
     * @param precio Precio de la membresía.
     * @param vigencia Fecha de vigencia.
     */
    public NuevaMembresiaDTO(TipoMembresiaDTO tipoMembresia, Double precio, LocalDate vigencia) {
        this.tipoMembresia = tipoMembresia;
        this.precio = precio;
        this.vigencia = vigencia;
    }

    /**
     * Obtiene el ID de la membresía.
     * 
     * @return ID de la membresía.
     */
    public String getIdMembresia() {
        return idMembresia;
    }

    /**
     * Obtiene el tipo de membresía.
     * 
     * @return Tipo de membresía.
     */
    public TipoMembresiaDTO getTipoMembresia() {
        return tipoMembresia;
    }

    /**
     * Obtiene el precio de la membresía.
     * 
     * @return Precio de la membresía.
     */
    public Double getPrecio() {
        return precio;
    }

    /**
     * Obtiene la fecha de vigencia de la membresía.
     * 
     * @return Fecha de vigencia.
     */
    public LocalDate getVigencia() {
        return vigencia;
    }
    
}
