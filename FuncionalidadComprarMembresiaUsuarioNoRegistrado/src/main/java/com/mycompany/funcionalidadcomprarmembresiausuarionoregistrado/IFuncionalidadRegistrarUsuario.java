/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.funcionalidadcomprarmembresiausuarionoregistrado;

import com.mycompany.fitlifegym_dtos.NuevoClienteDTO;
import com.mycompany.fitlifegym_negocio.NegocioException;
import java.util.List;


/**
 * Interfaz que define las operaciones relacionadas con el registro
 * de usuarios y validación de métodos de pago dentro del sistema.
 * 
 * @author Pc Gamer Master Race
 */
public interface IFuncionalidadRegistrarUsuario {
    /**
     * Registra un nuevo usuario en el sistema.
     * 
     * @param clienteDTO DTO con la información del cliente a registrar.
     * @throws NegocioException Si ocurre un error durante el registro.
     */
    public abstract void registrarUsuario(NuevoClienteDTO clienteDTO) throws NegocioException;

    /**
     * Obtiene todos los clientes registrados en el sistema.
     * 
     * @return Lista de clientes registrados.
     * @throws NegocioException Si ocurre un error durante la consulta.
     */
    public abstract List<NuevoClienteDTO> obtenerTodas() throws NegocioException;

    /**
     * Valida los datos de un usuario antes de registrarlo.
     * 
     * @param clienteDTO DTO con los datos del cliente a validar.
     * @throws NegocioException Si algún dato es inválido.
     */
    public abstract void validarDatosUsuario(NuevoClienteDTO clienteDTO) throws NegocioException;

    /**
     * Valida los datos de una tarjeta bancaria.
     * 
     * @param cvv CVV de la tarjeta.
     * @param numeroTarjeta Número de tarjeta.
     * @param fechaVencimiento Fecha de vencimiento de la tarjeta.
     * @param nombreTitular Nombre del titular de la tarjeta.
     * @throws NegocioException Si algún dato es inválido.
     */
    public abstract void validarTarjeta(String cvv, String numeroTarjeta, String fechaVencimiento, String nombreTitular) throws NegocioException;

    /**
     * Valida las credenciales de PayPal.
     * 
     * @param correo Correo asociado a la cuenta PayPal.
     * @param contrasenia Contraseña de la cuenta PayPal.
     * @throws NegocioException Si los datos son inválidos.
     */
    public abstract void validarPaypal(String correo, String contrasenia) throws NegocioException;
}

