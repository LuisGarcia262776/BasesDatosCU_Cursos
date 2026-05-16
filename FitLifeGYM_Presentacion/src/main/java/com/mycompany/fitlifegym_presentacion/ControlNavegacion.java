/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.fitlifegym_presentacion;

import com.mycompany.fitlifegym_dtos.ClienteLogueadoDTO;
import com.mycompany.fitlifegym_dtos.EstadoDTO;
import com.mycompany.fitlifegym_dtos.LoginDTO;
import com.mycompany.fitlifegym_dtos.NuevaMembresiaCompradaDTO;
import com.mycompany.fitlifegym_dtos.NuevaMembresiaDTO;
import com.mycompany.fitlifegym_dtos.NuevoClienteDTO;
import com.mycompany.fitlifegym_dtos.RenovarMembresiaDTO;
import com.mycompany.fitlifegym_dtos.TipoMembresiaDTO;
import com.mycompany.fitlifegym_negocio.NegocioException;
import com.mycompany.funcionalidadcomprarmembresiausuarionoregistrado.FuncionalidadRegistroUsuario;
import com.mycompany.funcionalidadcomprarmembresiausuarionoregistrado.IFuncionalidadRegistrarUsuario;
import com.mycompany.funcionalidadiniciarsesionrenovarmembresia.FuncionalidadIniciarSesionRenovarMembresia;
import com.mycompany.funcionalidadiniciarsesionrenovarmembresia.IFuncionalidadIniciarSesionRenovarMembresia;
import java.time.LocalDate;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.JFrame;

/**
 *
 * @author Diego
 */
public class ControlNavegacion {

    private JFrame frameActual;
    private ClienteLogueadoDTO clienteActual;

    private final IFuncionalidadRegistrarUsuario funcionalidadRegistro;

    private final IFuncionalidadIniciarSesionRenovarMembresia funcionalidadSesion;

    public ControlNavegacion() {
        this.funcionalidadRegistro = new FuncionalidadRegistroUsuario();
        this.funcionalidadSesion = new FuncionalidadIniciarSesionRenovarMembresia();
    }

    private void mostrarPantalla(JFrame nuevoFrame) {
        if (this.frameActual != null) {
            this.frameActual.dispose();
        }
        this.frameActual = nuevoFrame;
        this.frameActual.setResizable(false);
        this.frameActual.setVisible(true);
    }

    private void mostrarDialogo(JDialog nuevoDialogo) {
        nuevoDialogo.setResizable(false);   
        nuevoDialogo.setLocationRelativeTo(this.frameActual);
        nuevoDialogo.setVisible(true);
    }

    // NAVEGACION
    public void navegarMenuPrincipal() {
        mostrarPantalla(new MainFitLifeFORM(this));
    }

    public void navegarBeneficios(NuevoClienteDTO cliente) {
        mostrarPantalla(new BeneficiosFORM(this,cliente));
    }

    public void navegarBienvenida(ClienteLogueadoDTO cliente) {
        mostrarPantalla(new BienvenidaFORM(this,cliente));
    }

    public void navegarMetodosPago(TipoMembresiaDTO membresia, NuevoClienteDTO cliente) {
        mostrarPantalla(new SuscribirseFORM(this,membresia,cliente));
    }

    // DIALOGS
    public void navegarRegistrarse() {
        mostrarDialogo(new RegistrarseFORM(this.frameActual,true,this));
    }

    public void navegarIniciarSesion() {
        mostrarDialogo(new IniciarSesionFORM(this.frameActual,true,this));
    }

    public void navegarTransferenciaMetodo(TipoMembresiaDTO membresia, NuevoClienteDTO cliente) {
        mostrarDialogo(new TransferenciaFORM(this.frameActual,true,this,membresia,cliente));
    }

    public void navegarTarjetaMetodo(TipoMembresiaDTO membresia, NuevoClienteDTO cliente) {
        mostrarDialogo(new TarjetaFORM(this.frameActual,true,this,membresia,cliente));
    }

    public void navegarIniciarSesionPaypal(TipoMembresiaDTO membresia, NuevoClienteDTO cliente) {
        mostrarDialogo(new IniciarSesionPaypalFORM(this.frameActual,true,this,membresia,cliente));
    }

    // MEMBRESIAS
    public TipoMembresiaDTO seleccionarMembresia(String tipo) {
        switch (tipo) {
            case "ORO":
                return TipoMembresiaDTO.ORO;
            case "PLATA":
                return TipoMembresiaDTO.PLATA;

            default:
                return TipoMembresiaDTO.BRONCE;
        }
    }

    public NuevoClienteDTO asignarMembresiaCliente(NuevoClienteDTO cliente, TipoMembresiaDTO membresia) throws NegocioException {
        NuevaMembresiaDTO membresiaDTO = funcionalidadSesion.buscarMembresiaPorTipo(membresia);
        
        LocalDate hoy = LocalDate.now();

        NuevaMembresiaCompradaDTO membresiaCompradaDTO = new NuevaMembresiaCompradaDTO(membresiaDTO,hoy,hoy.plusMonths(1),membresiaDTO.getPrecio(),EstadoDTO.ACTIVO);

        return new NuevoClienteDTO(cliente.getNombre(),cliente.getApellidos(),cliente.getCorreo(),cliente.getTelefono(),cliente.getContrasenia(),cliente.getFechaNacimiento(),cliente.getPin(),membresiaCompradaDTO);
    }

    // CLIENTES
    public void registrarCliente(NuevoClienteDTO clienteDTO) throws NegocioException {
        funcionalidadRegistro.validarDatosUsuario(clienteDTO);
    }

    public List<NuevoClienteDTO> consultarClientes() throws NegocioException {
        return funcionalidadRegistro.obtenerTodas();
    }

    // PAGOS
    public void procesarPagoTarjeta(NuevoClienteDTO cliente, String numeroTarjeta, String cvv, String fechaVencimiento, String nombreTitular) throws NegocioException {
        funcionalidadRegistro.validarTarjeta(cvv,numeroTarjeta,fechaVencimiento,nombreTitular);
        registrarNuevoCliente(cliente);
    }

    public void procesarPagoPaypal(NuevoClienteDTO cliente, String correo, String contrasenia) throws NegocioException {
        funcionalidadRegistro.validarPaypal(correo,contrasenia);
        registrarNuevoCliente(cliente);
    }

    public void procesarPagoTransferencia(NuevoClienteDTO cliente) throws NegocioException {
        registrarNuevoCliente(cliente);
    }

    private void registrarNuevoCliente(NuevoClienteDTO cliente) throws NegocioException {
        if (cliente == null) {
            throw new NegocioException("No hay datos del cliente.");
        }

        if (cliente.getMembresiaComprada() == null) {
            throw new NegocioException("No se seleccionó membresía.");
        }

        funcionalidadRegistro.registrarUsuario(cliente);
    }

    // LOGIN
    public ClienteLogueadoDTO iniciarSesion(String pin, String contrasenia) throws NegocioException {
        LoginDTO loginDTO = new LoginDTO(pin,contrasenia);
        this.clienteActual =funcionalidadSesion.iniciarSesion(loginDTO);
        return this.clienteActual;
    }

    public ClienteLogueadoDTO getClienteActual() {
        return clienteActual;
    }
    
    // MEMBRESIAS
    public List<NuevaMembresiaDTO> consultarMembresias() throws NegocioException {
        return funcionalidadSesion.consultarMembresias();
    }

    public NuevaMembresiaDTO buscarMembresiaPorTipo(TipoMembresiaDTO tipo) throws NegocioException {
        return funcionalidadSesion.buscarMembresiaPorTipo(tipo);
    }

    // RENOVACION
    public void renovarMembresia(TipoMembresiaDTO tipoDTO) throws NegocioException {
        if (this.clienteActual == null) {
            throw new NegocioException("No hay cliente logueado.");
        }

        RenovarMembresiaDTO dto = new RenovarMembresiaDTO(clienteActual.getIdCliente(),tipoDTO);
        funcionalidadSesion.renovarMembresia(dto);
    }

}
