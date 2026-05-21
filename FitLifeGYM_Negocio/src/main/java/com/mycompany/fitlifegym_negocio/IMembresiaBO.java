/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.fitlifegym_negocio;

import com.mycompany.fitlifegym_dtos.NuevaMembresiaDTO;
import com.mycompany.fitlifegym_dtos.TipoMembresiaDTO;
import java.util.List;

/**
 * Interfaz que define las operaciones de negocio
 * relacionadas con las membresías del sistema.
 * 
 * Permite consultar y buscar membresías
 * disponibles según su tipo.
 * 
 * @author Diego
 */
public interface IMembresiaBO {

    /**
     * Obtiene todas las membresías disponibles
     * dentro del sistema.
     * 
     * @return Lista de membresías disponibles.
     * @throws NegocioException Se lanza cuando ocurre
     * un error al consultar las membresías.
     */
    public abstract List<NuevaMembresiaDTO> obtenerTodas() throws NegocioException;

    /**
     * Busca una membresía mediante su tipo.
     * 
     * @param tipo Tipo de membresía a buscar.
     * @return DTO con la información de la membresía encontrada.
     * @throws NegocioException Se lanza cuando no se encuentra
     * la membresía o ocurre un error de negocio.
     */
    public abstract NuevaMembresiaDTO buscarPorTipo(TipoMembresiaDTO tipo) throws NegocioException;
}
