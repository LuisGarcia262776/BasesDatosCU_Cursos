/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.fitlifegym_negocio;

import com.mycompany.fitlifegym_dtos.NuevoClienteDTO;
import java.util.List;

/**
 * Interfaz que define las operaciones de negocio
 * relacionadas con los clientes del sistema.
 * 
 * Permite registrar, consultar y obtener
 * información de clientes.
 * 
 * @author Luis
 */
public interface IClientesBO {
    /**
     * Registra un nuevo cliente dentro del sistema.
     * 
     * @param clienteDTO DTO con la información del cliente.
     * @return DTO del cliente registrado.
     * @throws NegocioException Se lanza cuando ocurre
     * un error durante el registro.
     */
    public abstract NuevoClienteDTO registrarCliente(NuevoClienteDTO clienteDTO) throws NegocioException;

    /**
     * Busca un cliente mediante su ID.
     * 
     * @param id ID del cliente.
     * @return DTO con la información del cliente encontrado.
     * @throws NegocioException Se lanza cuando ocurre
     * un error durante la consulta.
     */
    public abstract NuevoClienteDTO buscarClientePorId(String id) throws NegocioException;

    /**
     * Obtiene todos los clientes registrados
     * dentro del sistema.
     * 
     * @return Lista de clientes.
     * @throws NegocioException Se lanza cuando ocurre
     * un error al consultar los clientes.
     */
    public abstract List<NuevoClienteDTO> obtenerTodas() throws NegocioException;
}
