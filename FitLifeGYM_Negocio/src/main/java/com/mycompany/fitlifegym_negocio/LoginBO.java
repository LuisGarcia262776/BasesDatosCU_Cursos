/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.fitlifegym_negocio;

import Adapter.DtosAEntidadesAdapter;
import com.mycompany.fitlifegym_DAO.IClientesDAO;
import com.mycompany.fitlifegym_PersistenciaException.PersistenciaException;
import com.mycompany.fitlifegym_dtos.ClienteLogueadoDTO;
import com.mycompany.fitlifegym_dtos.EstadoDTO;
import com.mycompany.fitlifegym_dtos.LoginDTO;
import com.mycompany.fitlifegym_dtos.TipoMembresiaDTO;
import com.mycompany.fitlifegym_persistencia.entidades.Cliente;
import com.mycompany.fitlifegym_persistencia.entidades.TipoMembresia;
import com.mycompany.fitlifegym_persistencia_Fachada.IPersistenciaFachada;

/**
 *
 * @author PC GAMER MASTER RACE
 */
public class LoginBO implements ILoginBO {
    private final IClientesDAO clientesDAO;

    public LoginBO(IPersistenciaFachada fachada) {
        this.clientesDAO = fachada.obtenerClienteDAO();
    }

    @Override
    public ClienteLogueadoDTO iniciarSesion(LoginDTO login) throws NegocioException {
        try {
            Cliente cliente = clientesDAO.buscarPorPin(login.getPin());

            if (cliente == null) {
                return null;
            }

            String nombreCompleto = cliente.getNombre() + " " + cliente.getApellidos();
            TipoMembresiaDTO tipoDTO = null;
            EstadoDTO estadoDTO = EstadoDTO.INACTIVO;

            if (cliente.getMembresiaComprada() != null) {
                estadoDTO = DtosAEntidadesAdapter.adaptarEstadoDTO(cliente.getMembresiaComprada().getEstado());
                if (cliente.getMembresiaComprada().getMembresia() != null) {
                    TipoMembresia tipo = cliente.getMembresiaComprada().getMembresia().getTipoMembresia();
                    if (tipo != null) {
                        tipoDTO = DtosAEntidadesAdapter.adaptarTipoMembresiaDTO(tipo);
                    }
                }
            }

            return new ClienteLogueadoDTO(cliente.getIdCliente(), nombreCompleto, tipoDTO, estadoDTO);
        } catch (PersistenciaException ex) {
            throw new NegocioException("Error al iniciar sesion", ex);
        }
    }
}
