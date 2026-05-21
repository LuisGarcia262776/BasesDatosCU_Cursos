/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.fitlifegym_negocio;

import com.mycompany.fitlifegym_dtos.ClienteLogueadoDTO;
import com.mycompany.fitlifegym_dtos.LoginDTO;

/**
 * Interfaz que define las operaciones de negocio
 * relacionadas con el inicio de sesión de clientes.
 * 
 * Permite validar las credenciales de acceso
 * al sistema.
 * 
 * @author PC GAMER MASTER RACE
 */
public interface ILoginBO {
     /**
     * Valida las credenciales de un cliente
     * e inicia sesión dentro del sistema.
     * 
     * @param login DTO con las credenciales del cliente.
     * @return DTO con la información del cliente autenticado.
     * @throws NegocioException Se lanza cuando las credenciales
     * son inválidas o ocurre un error de negocio.
     */
    public abstract ClienteLogueadoDTO iniciarSesion(LoginDTO login) throws NegocioException;
}
