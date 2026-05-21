/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.fitlifegym_dtos;

/**
 * DTO que representa la información necesaria
 * para renovar la membresía de un cliente.
 * 
 * Contiene el ID del cliente y el nuevo tipo
 * de membresía seleccionado.
 * 
 * @author PC GAMER MASTER RACE
 */
public class RenovarMembresiaDTO {
    /**
     * ID del cliente que renovará su membresía.
     */
    private final String idCliente;
    
    /**
     * Nuevo tipo de membresía seleccionado.
     */
    private final TipoMembresiaDTO tipoMembresia;

    /**
     * Constructor que inicializa los datos
     * necesarios para renovar una membresía.
     * 
     * @param idCliente ID del cliente.
     * @param tipoMembresia Tipo de membresía seleccionada.
     */
    public RenovarMembresiaDTO(String idCliente, TipoMembresiaDTO tipoMembresia) {
        this.idCliente = idCliente;
        this.tipoMembresia = tipoMembresia;
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
     * Obtiene el tipo de membresía seleccionado.
     * 
     * @return Tipo de membresía.
     */
    public TipoMembresiaDTO getTipoMembresia() {
        return tipoMembresia;
    }
    
}
