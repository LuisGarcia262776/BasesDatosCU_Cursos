/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.fitlifegym_dtos;

import java.time.LocalDate;

/**
 *
 * @author PC GAMER MASTER RACE
 */
public class NuevaMembresiaDTO {
    private String idMembresia;
    private TipoMembresiaDTO tipoMembresia;
    private Double precio;
    private LocalDate vigencia;

    public NuevaMembresiaDTO(String idMembresia, TipoMembresiaDTO tipoMembresia, Double precio, LocalDate vigencia) {
        this.idMembresia = idMembresia;
        this.tipoMembresia = tipoMembresia;
        this.precio = precio;
        this.vigencia = vigencia;
    }

    public NuevaMembresiaDTO(TipoMembresiaDTO tipoMembresia, Double precio, LocalDate vigencia) {
        this.tipoMembresia = tipoMembresia;
        this.precio = precio;
        this.vigencia = vigencia;
    }

    public String getIdMembresia() {
        return idMembresia;
    }

    public TipoMembresiaDTO getTipoMembresia() {
        return tipoMembresia;
    }

    public Double getPrecio() {
        return precio;
    }

    public LocalDate getVigencia() {
        return vigencia;
    }
    
    
    
}
