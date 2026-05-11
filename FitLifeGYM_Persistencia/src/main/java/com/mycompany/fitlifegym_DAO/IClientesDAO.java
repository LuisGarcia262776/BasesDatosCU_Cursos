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
 *
 * @author PC GAMER MASTER RACE
 */
public interface IClientesDAO {
    public abstract Cliente registrarCliente(Cliente cliente) throws PersistenciaException;

    public abstract Cliente consultarClientePorId(String id) throws PersistenciaException;

    public abstract List<Cliente> consultarClientes() throws PersistenciaException;

    public abstract Cliente buscarPorPin(String pin) throws PersistenciaException;

    public abstract Cliente actualizarMembresia(String idCliente, TipoMembresia nuevaMembresia) throws PersistenciaException;
    
}
