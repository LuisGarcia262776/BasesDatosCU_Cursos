/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.fitlifegym_negocio;

import Adapter.DtosAEntidadesAdapter;
import com.mycompany.fitlifegym_PersistenciaException.PersistenciaException;
import com.mycompany.fitlifegym_dtos.NuevoClienteDTO;
import com.mycompany.fitlifegym_persistencia.entidades.Cliente;
import com.mycompany.fitlifegym_persistencia_Fachada.IPersistenciaFachada;
import com.mycompany.fitlifegym_persistencia_Fachada.PersistenciaFachada;
import java.util.List;

/**
 * Clase de negocio encargada de gestionar
 * las operaciones relacionadas con los clientes.
 * 
 * Permite registrar, consultar y obtener clientes
 * mediante el acceso a la capa de persistencia.
 * 
 * @author Luis
 */
public class ClientesBO implements IClientesBO {
    /**
     * Fachada utilizada para acceder a la capa de persistencia.
     */
    private final IPersistenciaFachada fachada;
    
    /**
     * Constructor que inicializa la fachada
     * de persistencia.
     */
    public ClientesBO(){
        this.fachada = new PersistenciaFachada();
    }

    /**
     * Registra un nuevo cliente dentro del sistema.
     * 
     * @param clienteDTO DTO con la información del cliente.
     * @return DTO del cliente registrado.
     * @throws NegocioException Se lanza cuando ocurre
     * un error durante el registro.
     */
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

    /**
     * Busca un cliente mediante su ID.
     * 
     * @param id ID del cliente.
     * @return DTO con la información del cliente encontrado.
     * @throws NegocioException Se lanza cuando ocurre
     * un error al consultar el cliente.
     */
    @Override
    public NuevoClienteDTO buscarClientePorId(String id) throws NegocioException {
        try {
            Cliente cliente = fachada.obtenerClienteDAO().consultarClientePorId(id);

            return DtosAEntidadesAdapter.adaptarCliente(cliente);
            
        } catch (PersistenciaException ex) {
            throw new NegocioException("Error al consultar cliente.", ex);
        }
    }

    /**
     * Obtiene la lista de todos los clientes registrados.
     * 
     * @return Lista de clientes.
     * @throws NegocioException Se lanza cuando ocurre
     * un error al consultar los clientes.
     */
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
