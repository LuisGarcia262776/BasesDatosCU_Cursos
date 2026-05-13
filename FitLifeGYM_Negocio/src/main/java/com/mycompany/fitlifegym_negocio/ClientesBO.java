/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.fitlifegym_negocio;

import Adapter.DtosAEntidadesAdapter;
import com.mycompany.fitlifegym_DAO.IClientesDAO;
import com.mycompany.fitlifegym_PersistenciaException.PersistenciaException;
import com.mycompany.fitlifegym_dtos.NuevoClienteDTO;
import com.mycompany.fitlifegym_persistencia.entidades.Cliente;
import com.mycompany.fitlifegym_persistencia_Fachada.IPersistenciaFachada;
import java.util.List;

/**
 *
 * @author Luis
 */
public class ClientesBO implements IClientesBO {
    
    private final IClientesDAO clientesDAO;

    public ClientesBO(IPersistenciaFachada fachada) {
        this.clientesDAO = fachada.obtenerClienteDAO();
    }

    @Override
    public Cliente registrarCliente(NuevoClienteDTO clienteDTO) throws NegocioException {
        Cliente cliente = DtosAEntidadesAdapter.adaptarClienteDTO(clienteDTO);
        try {
            return clientesDAO.registrarCliente(cliente);
        } catch (PersistenciaException ex) {
            throw new NegocioException("Error al registrar el cliente", ex);
        }
    }

    @Override
    public Cliente buscarClientePorId(String id) throws NegocioException {
        if (id == null || id.trim().isEmpty()) {
            throw new NegocioException("Se debe de colocar un ID.");
        }
        try {
            return clientesDAO.consultarClientePorId(id);
        } catch (PersistenciaException ex) {
            throw new NegocioException("Error al consultar el cliente", ex);
        }
    }

    @Override
    public List<Cliente> consultarClientes() throws NegocioException {
        try {
            return clientesDAO.consultarClientes();
        } catch (PersistenciaException ex) {
            throw new NegocioException("Error al consultar los clientes", ex);
        }
    }
    
}
