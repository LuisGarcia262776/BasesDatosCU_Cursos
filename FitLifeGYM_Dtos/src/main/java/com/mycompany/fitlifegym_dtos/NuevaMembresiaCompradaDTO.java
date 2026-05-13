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
public class NuevaMembresiaCompradaDTO {
    private String idMembresiaComprada;
    private NuevaMembresiaDTO membresia;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private Double precioPagado;
    private EstadoDTO estado;

    public NuevaMembresiaCompradaDTO(String idMembresiaComprada, NuevaMembresiaDTO membresia, LocalDate fechaInicio, LocalDate fechaFin, Double precioPagado, EstadoDTO estado) {
        this.idMembresiaComprada = idMembresiaComprada;
        this.membresia = membresia;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.precioPagado = precioPagado;
        this.estado = estado;
    }

    public NuevaMembresiaCompradaDTO(NuevaMembresiaDTO membresia, LocalDate fechaInicio, LocalDate fechaFin, Double precioPagado, EstadoDTO estado) {
        this.membresia = membresia;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.precioPagado = precioPagado;
        this.estado = estado;
    }

    public String getIdMembresiaComprada() {
        return idMembresiaComprada;
    }

    public NuevaMembresiaDTO getMembresia() {
        return membresia;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public Double getPrecioPagado() {
        return precioPagado;
    }

    public EstadoDTO getEstado() {
        return estado;
    }
    
    
    
}
