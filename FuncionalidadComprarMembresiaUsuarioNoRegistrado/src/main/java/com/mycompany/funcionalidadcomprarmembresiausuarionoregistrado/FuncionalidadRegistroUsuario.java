/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.funcionalidadcomprarmembresiausuarionoregistrado;

import com.mycompany.fitlifegym_dtos.NuevoClienteDTO;
import com.mycompany.fitlifegym_negocio.ClientesBO;
import com.mycompany.fitlifegym_negocio.IClientesBO;
import com.mycompany.fitlifegym_negocio.NegocioException;
import java.util.List;

/**
 *
 * @author Luis
 */
public class FuncionalidadRegistroUsuario implements IFuncionalidadRegistrarUsuario {
    
    private final IClientesBO clientesBO;

    public FuncionalidadRegistroUsuario() {
        this.clientesBO = new ClientesBO();
    }

    @Override
    public void registrarUsuario(NuevoClienteDTO clienteDTO) throws NegocioException {
        validarDatosUsuario(clienteDTO);
        
        clientesBO.registrarCliente(clienteDTO);    
    }

    @Override
    public List<NuevoClienteDTO> obtenerTodas() throws NegocioException {
        return clientesBO.obtenerTodas();
    }

    @Override
    public void validarDatosUsuario(NuevoClienteDTO clienteDTO) throws NegocioException {
        if(clienteDTO == null){
            throw new NegocioException("El cliente no puede ser Nulo");
        }
        
        if (clienteDTO.getNombre() == null || clienteDTO.getNombre().isBlank()) {
            throw new NegocioException("El nombre es obligatorio");
        }

        if (clienteDTO.getApellidos() == null || clienteDTO.getApellidos().isBlank()) {
            throw new NegocioException("Los apellidos son obligatorios");
        }

        if (clienteDTO.getCorreo() == null || clienteDTO.getCorreo().isBlank()) {
            throw new NegocioException("El correo es obligatorio");
        }

        if (!clienteDTO.getCorreo().contains("@")) {
            throw new NegocioException("Correo inválido");
        }

        if (clienteDTO.getTelefono() == null || clienteDTO.getTelefono().isBlank()) {
            throw new NegocioException("El teléfono es obligatorio");
        }

        if (clienteDTO.getContrasenia() == null || clienteDTO.getContrasenia().isBlank()) {
            throw new NegocioException("La contraseña es obligatoria");
        }

        if (clienteDTO.getPin() == null || clienteDTO.getPin().isBlank()) {
            throw new NegocioException("El PIN es obligatorio");
        }
    }

    @Override
    public void validarTarjeta(String cvv, String numeroTarjeta, String fechaVencimiento, String nombreTitular) throws NegocioException {
        if (cvv == null || cvv.isBlank()) {
            throw new NegocioException("El CVV es obligatorio");
        }

        if (cvv.length() != 3) {
            throw new NegocioException("CVV inválido");
        }

        if (numeroTarjeta == null || numeroTarjeta.isBlank()) {
            throw new NegocioException("El número de tarjeta es obligatorio");
        }

        if (numeroTarjeta.length() != 16) {
            throw new NegocioException("Número de tarjeta inválido");
        }

        if (fechaVencimiento == null || fechaVencimiento.isBlank()) {
            throw new NegocioException("La fecha de vencimiento es obligatoria");
        }

        if (nombreTitular == null || nombreTitular.isBlank()) {
            throw new NegocioException("El nombre del titular es obligatorio");
        }
    }

    @Override
    public void validarPaypal(String correo, String contrasenia) throws NegocioException {
        if (correo == null || correo.isBlank()) {
            throw new NegocioException("El correo es obligatorio");
        }

        if (!correo.contains("@")) {
            throw new NegocioException("Correo inválido");
        }

        if (contrasenia == null || contrasenia.isBlank()) {

            throw new NegocioException("La contraseña es obligatoria");
        }
    }
    
}

    