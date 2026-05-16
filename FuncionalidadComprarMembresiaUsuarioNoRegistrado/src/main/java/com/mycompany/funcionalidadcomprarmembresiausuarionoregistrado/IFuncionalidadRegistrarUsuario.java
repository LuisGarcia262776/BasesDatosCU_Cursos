/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.funcionalidadcomprarmembresiausuarionoregistrado;

import com.mycompany.fitlifegym_dtos.NuevoClienteDTO;
import com.mycompany.fitlifegym_negocio.NegocioException;
import java.util.List;


/**
 *
 * @author Diego
 */
public interface IFuncionalidadRegistrarUsuario {
    public abstract void registrarUsuario(NuevoClienteDTO clienteDTO) throws NegocioException;

    public abstract List<NuevoClienteDTO> obtenerTodas() throws NegocioException;

    public abstract void validarDatosUsuario(NuevoClienteDTO clienteDTO) throws NegocioException;

    public abstract void validarTarjeta(String cvv, String numeroTarjeta, String fechaVencimiento, String nombreTitular) throws NegocioException;

    public abstract void validarPaypal(String correo, String contrasenia) throws NegocioException;
}

