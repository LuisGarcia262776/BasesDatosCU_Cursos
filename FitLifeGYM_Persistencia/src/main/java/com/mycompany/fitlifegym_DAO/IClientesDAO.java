/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.fitlifegym_DAO;

import com.mycompany.fitlifegym_PersistenciaException.PersistenciaException;
import com.mycompany.fitlifegym_persistencia.entidades.Cliente;
import com.mycompany.fitlifegym_persistencia.entidades.TipoMembresia;
import java.util.List;

/**
 * Interfaz que define las operaciones
 * de persistencia relacionadas con
 * los clientes.
 * 
 * Permite registrar, consultar
 * y actualizar clientes dentro
 * de la base de datos.
 * 
 * @author PC GAMER MASTER RACE
 */
public interface IClientesDAO {
    /**
     * Registra un nuevo cliente
     * dentro de la base de datos.
     * 
     * @param cliente Cliente a registrar.
     * @return Cliente registrado.
     * @throws PersistenciaException Se lanza cuando ocurre
     * un error durante el registro.
     */
    public abstract Cliente registrarCliente(Cliente cliente) throws PersistenciaException;

    /**
     * Consulta un cliente mediante su ID.
     * 
     * @param id ID del cliente.
     * @return Cliente encontrado o null
     * si no existe.
     * @throws PersistenciaException Se lanza cuando ocurre
     * un error durante la consulta.
     */
    public abstract Cliente consultarClientePorId(String id) throws PersistenciaException;

    /**
     * Consulta todos los clientes registrados.
     * 
     * @return Lista de clientes.
     * @throws PersistenciaException Se lanza cuando ocurre
     * un error durante la consulta.
     */
    public abstract List<Cliente> consultarClientes() throws PersistenciaException;

    /**
     * Busca un cliente mediante su PIN.
     * 
     * @param pin PIN del cliente.
     * @return Cliente encontrado o null
     * si no existe.
     * @throws PersistenciaException Se lanza cuando ocurre
     * un error durante la consulta.
     */
    public abstract Cliente buscarPorPin(String pin) throws PersistenciaException;

    /**
     * Actualiza la membresía de un cliente.
     * 
     * @param idCliente ID del cliente.
     * @param nuevaMembresia Nueva membresía del cliente.
     * @return Cliente actualizado.
     * @throws PersistenciaException Se lanza cuando ocurre
     * un error durante la actualización.
     */
    public abstract Cliente actualizarMembresia(String idCliente, TipoMembresia nuevaMembresia) throws PersistenciaException;
    
}
