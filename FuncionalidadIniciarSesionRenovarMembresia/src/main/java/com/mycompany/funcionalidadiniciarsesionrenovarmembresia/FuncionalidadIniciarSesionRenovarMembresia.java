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
 *
 * @author PC GAMER MASTER RACE
 */
public class FuncionalidadIniciarSesionRenovarMembresia implements IFuncionalidadIniciarSesionRenovarMembresia {
    private final ILoginBO loginBO;

    private final IMembresiaBO membresiaBO;

    private final IRenovarMembresiaBO renovarMembresiaBO;
    
    private final IAdministradorBO adminBO;

    public FuncionalidadIniciarSesionRenovarMembresia() {
        this.loginBO = new LoginBO();
        this.membresiaBO = new MembresiaBO();
        this.renovarMembresiaBO = new RenovarMembresiaBO();
        this.adminBO = new AdministradorBO();
    }

    @Override
    public ClienteLogueadoDTO iniciarSesion(LoginDTO login) throws NegocioException {
        if (login == null) {
            throw new NegocioException("Los datos no pueden ser null.");
        }
        validarPin(login.getPin());
        validarContrasenia(login.getContrasenia());
        return loginBO.iniciarSesion(login);
    }

    @Override
    public List<NuevaMembresiaDTO> consultarMembresias() throws NegocioException {
        List<NuevaMembresiaDTO> membresias = membresiaBO.obtenerTodas();

        if (membresias == null || membresias.isEmpty()) {
            throw new NegocioException("No hay membresías disponibles.");
        }
        return membresias;
    }

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

    @Override
    public NuevaMembresiaDTO buscarMembresiaPorTipo(TipoMembresiaDTO tipo)throws NegocioException {
        if (tipo == null) {
            throw new NegocioException("El tipo no puede ser null.");
        }
        List<NuevaMembresiaDTO> membresias =membresiaBO.obtenerTodas();
        for (NuevaMembresiaDTO membresia: membresias) {
            if (membresia.getTipoMembresia()== tipo) {
                return membresia;
            }
        }
        throw new NegocioException("No se encontró la membresía.");
    }

    @Override
    public AdministradorLogueadoDTO iniciarSesionAdmin(String pin, String contrasenia) throws NegocioException {
        validarPin(pin);
        validarContrasenia(contrasenia);
        return adminBO.iniciarSesion(pin, contrasenia);
        
    }
    
    private void validarPin(String pin) throws NegocioException {
        if (pin == null || pin.isBlank()) {
            throw new NegocioException("El PIN es obligatorio.");
        }
        if (!pin.matches("[0-9]+")) {
            throw new NegocioException("El PIN solo puede contener números.");
        }
    }

    private void validarContrasenia(String contrasenia) throws NegocioException {
        if (contrasenia == null || contrasenia.isBlank()) {
            throw new NegocioException("La contraseña es obligatoria.");
        }
        if (!contrasenia.matches("[a-zA-Z0-9]+")) {
            throw new NegocioException("La contraseña solo puede contener letras y números.");
        }
    }

    
    
    
    
    
    
}
