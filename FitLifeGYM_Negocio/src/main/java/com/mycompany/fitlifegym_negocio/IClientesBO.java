/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.fitlifegym_negocio;

import com.mycompany.fitlifegym_dtos.NuevoClienteDTO;
import java.util.List;

/**
 *
 * @author Luis
 */
public interface IClientesBO {

    public abstract NuevoClienteDTO registrarCliente(NuevoClienteDTO clienteDTO) throws NegocioException;

    public abstract NuevoClienteDTO buscarClientePorId(String id) throws NegocioException;

    public abstract List<NuevoClienteDTO> obtenerTodas() throws NegocioException;
}
