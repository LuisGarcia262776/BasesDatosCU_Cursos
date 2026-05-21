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
 * Clase que implementa la funcionalidad relacionada con el registro
 * de nuevos usuarios y validación de métodos de pago dentro del sistema.
 * 
 * @author Luis
 */
public class FuncionalidadRegistroUsuario implements IFuncionalidadRegistrarUsuario {
    /**
     * BO encargado de la gestión de clientes.
     */
    private final IClientesBO clientesBO;

    /**
     * Constructor que inicializa las dependencias necesarias
     * para la funcionalidad.
     */
    public FuncionalidadRegistroUsuario() {
        this.clientesBO = new ClientesBO();
    }

    /**
     * Registra un nuevo usuario en el sistema.
     * 
     * @param clienteDTO DTO con la información del cliente.
     * @throws NegocioException Si los datos son inválidos o ocurre un error.
     */
    @Override
    public void registrarUsuario(NuevoClienteDTO clienteDTO) throws NegocioException {
        validarDatosUsuario(clienteDTO);
        
        clientesBO.registrarCliente(clienteDTO);    
    }

    /**
     * Obtiene todos los clientes registrados.
     * 
     * @return Lista de clientes registrados.
     * @throws NegocioException Si ocurre un error durante la consulta.
     */
    @Override
    public List<NuevoClienteDTO> obtenerTodas() throws NegocioException {
        return clientesBO.obtenerTodas();
    }

    /**
     * Valida los datos de un usuario antes de registrarlo.
     * 
     * @param clienteDTO DTO con la información del cliente.
     * @throws NegocioException Si algún dato es inválido.
     */
    @Override
    public void validarDatosUsuario(NuevoClienteDTO clienteDTO) throws NegocioException {
        if(clienteDTO == null){
            throw new NegocioException("El cliente no puede ser Nulo");
        }
        
        if (clienteDTO.getNombre() == null || clienteDTO.getNombre().isBlank()) {
            throw new NegocioException("El nombre es obligatorio");
        }
        
        if (!clienteDTO.getNombre().matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+$")) {
            throw new NegocioException("El nombre solo puede contener letras.");
        }

        if (clienteDTO.getApellidos() == null || clienteDTO.getApellidos().isBlank()) {
            throw new NegocioException("Los apellidos son obligatorios");
        }
        
        if(!clienteDTO.getApellidos().matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+$")){
            throw new NegocioException("El Apellido solo puede contener letras.");
        }

        if (clienteDTO.getCorreo() == null || clienteDTO.getCorreo().isBlank()) {
            throw new NegocioException("El correo es obligatorio");
        }

        if (!clienteDTO.getCorreo().contains("@")) {
            throw new NegocioException("Correo inválido");
        }
        
        if (!clienteDTO.getCorreo().matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$")) {
            throw new NegocioException("Correo inválido.");
        }

        if (clienteDTO.getTelefono() == null || clienteDTO.getTelefono().isBlank()) {
            throw new NegocioException("El teléfono es obligatorio");
        }

        if (clienteDTO.getContrasenia() == null || clienteDTO.getContrasenia().isBlank()) {
            throw new NegocioException("La contraseña es obligatoria");
        }
        
        if (!clienteDTO.getContrasenia().matches("^[a-zA-Z0-9]+$")) {
            throw new NegocioException("La contraseña solo puede contener letras y números.");
        }

        if (clienteDTO.getPin() == null || clienteDTO.getPin().isBlank()) {
            throw new NegocioException("El PIN es obligatorio");
        }
        
        if (!clienteDTO.getPin().matches("^\\d{4}$")) {
            throw new NegocioException("El PIN debe tener 4 dígitos.");
        }
    }

    /**
     * Valida los datos de una tarjeta bancaria.
     * 
     * @param cvv CVV de la tarjeta.
     * @param numeroTarjeta Número de la tarjeta.
     * @param fechaVencimiento Fecha de vencimiento.
     * @param nombreTitular Nombre del titular de la tarjeta.
     * @throws NegocioException Si algún dato es inválido.
     */
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

    /**
     * Valida las credenciales de una cuenta PayPal.
     * 
     * @param correo Correo asociado a la cuenta PayPal.
     * @param contrasenia Contraseña de la cuenta PayPal.
     * @throws NegocioException Si los datos son inválidos.
     */
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

    