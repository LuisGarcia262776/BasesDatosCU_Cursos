/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.fitlifegym_negocio;

import Adapter.DtosAEntidadesAdapter;
import com.mycompany.fitlifegym_PersistenciaException.PersistenciaException;
import com.mycompany.fitlifegym_dtos.ClienteLogueadoDTO;
import com.mycompany.fitlifegym_dtos.NuevoClienteDTO;
import com.mycompany.fitlifegym_persistencia.entidades.Cliente;

import com.mycompany.fitlifegym_persistencia_Fachada.IPersistenciaFachada;
import com.mycompany.fitlifegym_persistencia_Fachada.PersistenciaFachada;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Luis
 */
public class ClientesBO implements IClientesBO {
    
    private final IPersistenciaFachada fachada;
    
    public ClientesBO(){
            this.fachada = new PersistenciaFachada();
    }

    @Override
    public NuevoClienteDTO registrarCliente(NuevoClienteDTO clienteDTO) throws NegocioException {
        try {
            Cliente cliente = DtosAEntidadesAdapter.adaptarClienteDTO(clienteDTO);

            Cliente guardado = fachada.obtenerClienteDAO().registrarCliente(cliente);

            return DtosAEntidadesAdapter.adaptarCliente(guardado);
        } catch (PersistenciaException ex) {
            throw new NegocioException("Error al registrar cliente.", ex);
        }
    }

    @Override
    public NuevoClienteDTO buscarClientePorId(String id) throws NegocioException {
        try {
            Cliente cliente = fachada.obtenerClienteDAO().consultarClientePorId(id);

            return DtosAEntidadesAdapter.adaptarCliente(cliente);
        } catch (PersistenciaException ex) {
            throw new NegocioException("Error al consultar cliente.", ex);
        }
        
    }

    @Override
    public List<NuevoClienteDTO> obtenerTodas() throws NegocioException {
        try {
            List<Cliente> clientes = fachada.obtenerClienteDAO().consultarClientes();
            
            return DtosAEntidadesAdapter.adaptarListaClientes(clientes);
        } catch (PersistenciaException ex) {
            throw new NegocioException("Error al consultar clientes.", ex);
        }
        
        
    }
    
    
    
}
