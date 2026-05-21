/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.fitlifegym_dtos;

import java.time.LocalDate;

/**
 * DTO que representa una membresía comprada
 * por un cliente dentro del sistema.
 * 
 * Contiene la información relacionada con la membresía,
 * fechas de vigencia, precio pagado y estado actual.
 * 
 * @author PC GAMER MASTER RACE
 */
public class NuevaMembresiaCompradaDTO {
    /**
     * ID único de la membresía comprada.
     */
    private String idMembresiaComprada;
    
    /**
     * Información de la membresía adquirida.
     */
    private NuevaMembresiaDTO membresia;
    
    /**
     * Fecha de inicio de la membresía.
     */
    private LocalDate fechaInicio;
    
    /**
     * Fecha de finalización de la membresía.
     */
    private LocalDate fechaFin;
    
    /**
     * Precio pagado por la membresía.
     */
    private Double precioPagado;
    
    /**
     * Estado actual de la membresía.
     */
    private EstadoDTO estado;

    /**
     * Constructor que inicializa todos los datos
     * de la membresía comprada.
     * 
     * @param idMembresiaComprada ID de la membresía comprada.
     * @param membresia Información de la membresía.
     * @param fechaInicio Fecha de inicio.
     * @param fechaFin Fecha de finalización.
     * @param precioPagado Precio pagado.
     * @param estado Estado de la membresía.
     */
    public NuevaMembresiaCompradaDTO(String idMembresiaComprada, NuevaMembresiaDTO membresia, LocalDate fechaInicio, LocalDate fechaFin, Double precioPagado, EstadoDTO estado) {
        this.idMembresiaComprada = idMembresiaComprada;
        this.membresia = membresia;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.precioPagado = precioPagado;
        this.estado = estado;
    }

    /**
     * Constructor para registrar una nueva membresía comprada.
     * 
     * @param membresia Información de la membresía.
     * @param fechaInicio Fecha de inicio.
     * @param fechaFin Fecha de finalización.
     * @param precioPagado Precio pagado.
     * @param estado Estado de la membresía.
     */
    public NuevaMembresiaCompradaDTO(NuevaMembresiaDTO membresia, LocalDate fechaInicio, LocalDate fechaFin, Double precioPagado, EstadoDTO estado) {
        this.membresia = membresia;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.precioPagado = precioPagado;
        this.estado = estado;
    }

    /**
     * Obtiene el ID de la membresía comprada.
     * 
     * @return ID de la membresía comprada.
     */
    public String getIdMembresiaComprada() {
        return idMembresiaComprada;
    }

    /**
     * Obtiene la información de la membresía.
     * 
     * @return Membresía adquirida.
     */
    public NuevaMembresiaDTO getMembresia() {
        return membresia;
    }

    /**
     * Obtiene la fecha de inicio de la membresía.
     * 
     * @return Fecha de inicio.
     */
    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    /**
     * Obtiene la fecha de finalización de la membresía.
     * 
     * @return Fecha de finalización.
     */
    public LocalDate getFechaFin() {
        return fechaFin;
    }

    /**
     * Obtiene el precio pagado por la membresía.
     * 
     * @return Precio pagado.
     */
    public Double getPrecioPagado() {
        return precioPagado;
    }

    /**
     * Obtiene el estado actual de la membresía.
     * 
     * @return Estado de la membresía.
     */
    public EstadoDTO getEstado() {
        return estado;
    }
    
}
