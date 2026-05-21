/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.funcionalidadiniciarsesionrenovarmembresia;

import com.mycompany.fitlifegym_dtos.AdministradorLogueadoDTO;
import com.mycompany.fitlifegym_dtos.ClienteLogueadoDTO;
import com.mycompany.fitlifegym_dtos.LoginDTO;
import com.mycompany.fitlifegym_dtos.NuevaMembresiaDTO;
import com.mycompany.fitlifegym_dtos.RenovarMembresiaDTO;
import com.mycompany.fitlifegym_dtos.TipoMembresiaDTO;
import com.mycompany.fitlifegym_negocio.NegocioException;
import java.util.List;


/**
 * Interfaz que define las operaciones relacionadas con el inicio de sesión
 * y renovación de membresías dentro del sistema.
 * 
 * @author PC GAMER MASTER RACE
 */
public interface IFuncionalidadIniciarSesionRenovarMembresia {
    
    /**
     * Inicia sesión de un cliente utilizando sus credenciales.
     * 
     * @param login DTO con los datos de inicio de sesión.
     * @return ClienteLogueadoDTO con la información del cliente autenticado.
     * @throws NegocioException Si ocurre un error durante el inicio de sesión.
     */
    public abstract ClienteLogueadoDTO iniciarSesion(LoginDTO login) throws NegocioException;
    
    /**
     * Inicia sesión de un administrador utilizando su PIN y contraseña.
     * 
     * @param pin PIN del administrador.
     * @param contrasenia Contraseña del administrador.
     * @return AdministradorLogueadoDTO con la información del administrador autenticado.
     * @throws NegocioException Si ocurre un error durante el inicio de sesión.
     */
    public abstract AdministradorLogueadoDTO iniciarSesionAdmin(String pin, String contrasenia)throws NegocioException;

    /**
     * Consulta todas las membresías disponibles en el sistema.
     * 
     * @return Lista de membresías disponibles.
     * @throws NegocioException Si ocurre un error durante la consulta.
     */
    public abstract List<NuevaMembresiaDTO> consultarMembresias() throws NegocioException;

    /**
     * Renueva la membresía de un cliente.
     * 
     * @param dto DTO con la información necesaria para renovar la membresía.
     * @throws NegocioException Si ocurre un error durante la renovación.
     */
    public abstract void renovarMembresia(RenovarMembresiaDTO dto) throws NegocioException;

    /**
     * Busca una membresía según su tipo.
     * 
     * @param tipo Tipo de membresía a buscar.
     * @return NuevaMembresiaDTO correspondiente al tipo solicitado.
     * @throws NegocioException Si ocurre un error durante la búsqueda.
     */
    public abstract NuevaMembresiaDTO buscarMembresiaPorTipo(TipoMembresiaDTO tipo) throws NegocioException;
}
