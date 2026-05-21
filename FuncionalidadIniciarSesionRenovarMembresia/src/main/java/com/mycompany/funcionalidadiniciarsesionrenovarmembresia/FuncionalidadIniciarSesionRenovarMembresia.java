/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.funcionalidadiniciarsesionrenovarmembresia;

import com.mycompany.fitlifegym_dtos.AdministradorLogueadoDTO;
import com.mycompany.fitlifegym_dtos.ClienteLogueadoDTO;
import com.mycompany.fitlifegym_dtos.LoginDTO;
import com.mycompany.fitlifegym_dtos.NuevaMembresiaDTO;
import com.mycompany.fitlifegym_dtos.RenovarMembresiaDTO;
import com.mycompany.fitlifegym_dtos.TipoMembresiaDTO;
import com.mycompany.fitlifegym_negocio.AdministradorBO;
import com.mycompany.fitlifegym_negocio.IAdministradorBO;
import com.mycompany.fitlifegym_negocio.ILoginBO;
import com.mycompany.fitlifegym_negocio.IMembresiaBO;
import com.mycompany.fitlifegym_negocio.IRenovarMembresiaBO;
import com.mycompany.fitlifegym_negocio.LoginBO;
import com.mycompany.fitlifegym_negocio.MembresiaBO;
import com.mycompany.fitlifegym_negocio.NegocioException;
import com.mycompany.fitlifegym_negocio.RenovarMembresiaBO;
import java.util.List;

/**
 * Clase que implementa la funcionalidad relacionada con el inicio de sesión
 * de clientes y administradores, así como la consulta y renovación
 * de membresías dentro del sistema.
 * 
 * @author PC GAMER MASTER RACE
 */
public class FuncionalidadIniciarSesionRenovarMembresia implements IFuncionalidadIniciarSesionRenovarMembresia {
    /**
     * BO encargado del inicio de sesión de clientes.
     */
    private final ILoginBO loginBO;

    /**
     * BO encargado de la gestión de membresías.
     */
    private final IMembresiaBO membresiaBO;

    /**
     * BO encargado de renovar membresías.
     */
    private final IRenovarMembresiaBO renovarMembresiaBO;
    
    /**
     * BO encargado del inicio de sesión de administradores.
     */
    private final IAdministradorBO adminBO;

    /**
     * Constructor que inicializa las dependencias necesarias
     * para la funcionalidad.
     */
    public FuncionalidadIniciarSesionRenovarMembresia() {
        this.loginBO = new LoginBO();
        this.membresiaBO = new MembresiaBO();
        this.renovarMembresiaBO = new RenovarMembresiaBO();
        this.adminBO = new AdministradorBO();
    }

    /**
     * Inicia sesión de un cliente validando sus credenciales.
     * 
     * @param login DTO con los datos de inicio de sesión.
     * @return ClienteLogueadoDTO con la información del cliente autenticado.
     * @throws NegocioException Si los datos son inválidos o ocurre un error.
     */
    @Override
    public ClienteLogueadoDTO iniciarSesion(LoginDTO login) throws NegocioException {
        if (login == null) {
            throw new NegocioException("Los datos no pueden ser null.");
        }
        
        validarPin(login.getPin());
        validarContrasenia(login.getContrasenia());
        
        return loginBO.iniciarSesion(login);
    }

    /**
     * Consulta todas las membresías disponibles.
     * 
     * @return Lista de membresías disponibles.
     * @throws NegocioException Si no existen membresías o ocurre un error.
     */
    @Override
    public List<NuevaMembresiaDTO> consultarMembresias() throws NegocioException {
        List<NuevaMembresiaDTO> membresias = membresiaBO.obtenerTodas();

        if (membresias == null || membresias.isEmpty()) {
            throw new NegocioException("No hay membresías disponibles.");
        }
        
        return membresias;
    }

    /**
     * Renueva la membresía de un cliente.
     * 
     * @param dto DTO con la información necesaria para renovar la membresía.
     * @throws NegocioException Si los datos son inválidos o ocurre un error.
     */
    @Override
    public void renovarMembresia(RenovarMembresiaDTO dto) throws NegocioException {
        if (dto == null) {
            throw new NegocioException("Los datos no pueden ser null.");
        }

        if (dto.getIdCliente() == null || dto.getIdCliente().isBlank()) {

            throw new NegocioException("El idCliente es obligatorio.");
        }
        
        if (dto.getTipoMembresia() == null) {
            throw new NegocioException("Debe seleccionar una membresía.");
        }
        
        renovarMembresiaBO.renovarMembresia(dto);
    }

    /**
     * Busca una membresía según su tipo.
     * 
     * @param tipo Tipo de membresía a buscar.
     * @return NuevaMembresiaDTO correspondiente al tipo solicitado.
     * @throws NegocioException Si el tipo es inválido o no se encuentra la membresía.
     */
    @Override
    public NuevaMembresiaDTO buscarMembresiaPorTipo(TipoMembresiaDTO tipo)throws NegocioException {
        if (tipo == null) {
            throw new NegocioException("El tipo no puede ser null.");
        }
        
        List<NuevaMembresiaDTO> membresias = membresiaBO.obtenerTodas();
        
        for (NuevaMembresiaDTO membresia: membresias) {
            if (membresia.getTipoMembresia() == tipo) {
                return membresia;
            }
        }
        
        throw new NegocioException("No se encontró la membresía.");
    }

    /**
     * Inicia sesión de un administrador validando sus credenciales.
     * 
     * @param pin PIN del administrador.
     * @param contrasenia Contraseña del administrador.
     * @return AdministradorLogueadoDTO con la información del administrador autenticado.
     * @throws NegocioException Si las credenciales son inválidas o ocurre un error.
     */
    @Override
    public AdministradorLogueadoDTO iniciarSesionAdmin(String pin, String contrasenia) throws NegocioException {
        validarPin(pin);
        validarContrasenia(contrasenia);
        
        return adminBO.iniciarSesion(pin, contrasenia);
    }
    
    /**
     * Valida que el PIN sea válido.
     * 
     * @param pin PIN a validar.
     * @throws NegocioException Si el PIN es inválido.
     */
    private void validarPin(String pin) throws NegocioException {
        if (pin == null || pin.isBlank()) {
            throw new NegocioException("El PIN es obligatorio.");
        }
        
        if (!pin.matches("[0-9]+")) {
            throw new NegocioException("El PIN solo puede contener números.");
        }
    }

    /**
     * Valida que la contraseña sea válida.
     * 
     * @param contrasenia Contraseña a validar.
     * @throws NegocioException Si la contraseña es inválida.
     */
    private void validarContrasenia(String contrasenia) throws NegocioException {
        if (contrasenia == null || contrasenia.isBlank()) {
            throw new NegocioException("La contraseña es obligatoria.");
        }
        
        if (!contrasenia.matches("[a-zA-Z0-9]+")) {
            throw new NegocioException("La contraseña solo puede contener letras y números.");
        }
    }
    
}
