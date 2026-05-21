/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.fitlifegym_negocio;

import com.mycompany.fitlifegym_dtos.RenovarMembresiaDTO;

/**
 * Interfaz que define las operaciones de negocio
 * relacionadas con la renovación de membresías
 * dentro del sistema.
 * 
 * Permite validar y realizar la renovación
 * de membresías de clientes.
 * 
 * @author PC GAMER MASTER RACE
 */
public interface IRenovarMembresiaBO {
    /**
     * Realiza la renovación de una membresía
     * para un cliente.
     * 
     * @param dto DTO con la información necesaria
     * para renovar la membresía.
     * @throws NegocioException Se lanza cuando
     * los datos son inválidos o ocurre un error
     * de negocio.
     */
    public abstract void renovarMembresia(RenovarMembresiaDTO dto)throws NegocioException;
}
