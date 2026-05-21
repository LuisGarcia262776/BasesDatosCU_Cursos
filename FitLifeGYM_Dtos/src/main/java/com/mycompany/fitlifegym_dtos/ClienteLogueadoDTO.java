/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.fitlifegym_dtos;

/**
 * DTO que representa la información de un cliente autenticado
 * dentro del sistema.
 * 
 * Contiene los datos principales del cliente después
 * de iniciar sesión correctamente.
 * 
 * @author PC GAMER MASTER RACE
 */
public class ClienteLogueadoDTO {
    /**
     * ID único del cliente.
     */
    private final String idCliente;
    
    /**
     * Nombre completo del cliente.
     */
    private final String nombreCompleto;
    
    /**
     * Tipo de membresía activa del cliente.
     */
    private final TipoMembresiaDTO membresiaActiva;
    
    /**
     * Estado actual de la membresía del cliente.
     */
    private final EstadoDTO estadoMembresia;

    /**
     * Constructor que inicializa los datos del cliente autenticado.
     * 
     * @param idCliente ID del cliente.
     * @param nombreCompleto Nombre completo del cliente.
     * @param membresiaActiva Membresía activa del cliente.
     * @param estadoMembresia Estado de la membresía.
     */
    public ClienteLogueadoDTO(String idCliente, String nombreCompleto, TipoMembresiaDTO membresiaActiva, EstadoDTO estadoMembresia) {
        this.idCliente = idCliente;
        this.nombreCompleto = nombreCompleto;
        this.membresiaActiva = membresiaActiva;
        this.estadoMembresia = estadoMembresia;
    }

    /**
     * Obtiene el ID del cliente.
     * 
     * @return ID del cliente.
     */
    public String getIdCliente() {
        return idCliente;
    }

    /**
     * Obtiene el nombre completo del cliente.
     * 
     * @return Nombre completo del cliente.
     */
    public String getNombreCompleto() {
        return nombreCompleto;
    }

    /**
     * Obtiene la membresía activa del cliente.
     * 
     * @return Membresía activa.
     */
    public TipoMembresiaDTO getMembresiaActiva() {
        return membresiaActiva;
    }

    /**
     * Obtiene el estado actual de la membresía.
     * 
     * @return Estado de la membresía.
     */
    public EstadoDTO getEstadoMembresia() {
        return estadoMembresia;
    }
    
}
