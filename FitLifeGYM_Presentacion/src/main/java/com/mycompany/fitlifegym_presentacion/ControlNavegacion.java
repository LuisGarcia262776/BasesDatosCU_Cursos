/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.fitlifegym_presentacion;

import com.mycompany.fitlifegym_cu_cursos.CU_Cursos;
import com.mycompany.fitlifegym_cu_cursos.ICU_Cursos;
import com.mycompany.fitlifegym_dtos.ClienteLogueadoDTO;
import com.mycompany.fitlifegym_dtos.CursoDTO;
import com.mycompany.fitlifegym_dtos.DatosReporteDTO;
import com.mycompany.fitlifegym_dtos.EstadoDTO;
import com.mycompany.fitlifegym_dtos.HorarioDTO;
import com.mycompany.fitlifegym_dtos.InscripcionDTO;
import com.mycompany.fitlifegym_dtos.LoginDTO;
import com.mycompany.fitlifegym_dtos.NuevaMembresiaCompradaDTO;
import com.mycompany.fitlifegym_dtos.NuevaMembresiaDTO;
import com.mycompany.fitlifegym_dtos.NuevoClienteDTO;
import com.mycompany.fitlifegym_dtos.RenovarMembresiaDTO;
import com.mycompany.fitlifegym_dtos.ReporteDTO;
import com.mycompany.fitlifegym_dtos.TipoMembresiaDTO;
import com.mycompany.fitlifegym_negocio.NegocioException;
import com.mycompany.funcionalidadcomprarmembresiausuarionoregistrado.FuncionalidadRegistroUsuario;
import com.mycompany.funcionalidadcomprarmembresiausuarionoregistrado.IFuncionalidadRegistrarUsuario;
import com.mycompany.funcionalidadiniciarsesionrenovarmembresia.FuncionalidadIniciarSesionRenovarMembresia;
import com.mycompany.funcionalidadiniciarsesionrenovarmembresia.IFuncionalidadIniciarSesionRenovarMembresia;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Diego
 */
public class ControlNavegacion {
    
    private JFrame frameActual;
    private ClienteLogueadoDTO clienteActual;
    private boolean esAdministrador = false;

    // Subsistemas
    private final IFuncionalidadRegistrarUsuario funcionalidadRegistro;
    private final IFuncionalidadIniciarSesionRenovarMembresia funcionalidadSesion;
    private final ICU_Cursos cuCursos;

    public ControlNavegacion() {
        this.funcionalidadRegistro = new FuncionalidadRegistroUsuario();
        this.funcionalidadSesion   = new FuncionalidadIniciarSesionRenovarMembresia();
        this.cuCursos = new CU_Cursos();
    }

    // Cierra el frame anterior y abre el nuevo 
    private void mostrarPantalla(JFrame nuevoFrame) {
        if (this.frameActual != null) {
            this.frameActual.dispose();
        }
        this.frameActual = nuevoFrame;
        this.frameActual.setResizable(false);
        this.frameActual.setVisible(true);
    }

    // NAVEGACIÓN — CU Base
    public void navegarMenuPrincipal() {
        mostrarPantalla(new MainFitLifeFORM(this));
    }

    public void navegarIniciarSesion() {
        mostrarPantalla(new IniciarSesionFORM(this));
    }

    public void navegarRegistrarse() {
        mostrarPantalla(new RegistrarseFORM(this));
    }

    public void navegarBienvenida(ClienteLogueadoDTO cliente) {
        mostrarPantalla(new BienvenidaFORM(this, cliente));
    }

    public void navegarBeneficios(NuevoClienteDTO cliente) {
        mostrarPantalla(new BeneficiosFORM(this, cliente));
    }

    public void navegarMetodosPago(TipoMembresiaDTO membresia, NuevoClienteDTO cliente) {
        mostrarPantalla(new SuscribirseFORM(this, membresia, cliente));
    }

    public void navegarTarjetaMetodo(TipoMembresiaDTO membresia, NuevoClienteDTO cliente) {
        mostrarPantalla(new TarjetaFORM(this, membresia, cliente));
    }

    public void navegarIniciarSesionPaypal(TipoMembresiaDTO membresia, NuevoClienteDTO cliente) {
        mostrarPantalla(new IniciarSesionPaypalFORM(this, membresia, cliente));
    }

    public void navegarTransferenciaMetodo(TipoMembresiaDTO membresia, NuevoClienteDTO cliente) {
        mostrarPantalla(new TransferenciaFORM(this, membresia, cliente));
    }
    
    public void navegarCursosCliente(){
        mostrarPantalla(new CursosClienteFORM(this));
    }
    
    public void navegarInscripcionCurso(CursoDTO curso) {
        mostrarPantalla(new InscripcionCursoFORM(this, curso));
    }
    
    public void navegarYaInscrito(CursoDTO curso, HorarioDTO horario) {
        mostrarPantalla(new YaEstasInscritoFORM(this, curso, horario));
    }
    
    public void navegarVerMiscursos(){
        mostrarPantalla(new MisCursosFORM(this));
    }
    
    public void navegarNoHayHorariosDisponible(CursoDTO curso){
        mostrarPantalla(new NoHayHorariosDisponiblesFORM(this, curso));
    }


    // NAVEGACION — Admin
    public void navegarMenuAdmin() {
        mostrarPantalla(new MenuCursosAdminFORM(this));
    }

    public void navegarGestionCursos() {
        mostrarPantalla(new GestionDeCursosFORM(this));
    }

    public void navegarAgregarCurso() {
        mostrarPantalla(new AgregarCursoFORM(this));
    }
    
    public void navegarEditarCurso(CursoDTO cursoDTO) {
        mostrarPantalla(new EditarCursosFORM(this, cursoDTO));
}

    public void navegarGestionHorarios(CursoDTO curso) {
        mostrarPantalla(new GestionHorariosFORM(this));
    }

    public void navegarAgregarHorario(CursoDTO curso) {
        mostrarPantalla(new AgregarHorarioFORM(this, curso));
    }

    public void navegarEditarHorario(HorarioDTO horario, CursoDTO curso) {
        mostrarPantalla(new EditarHorarioFORM(this, curso));
    }

    public void navegarVerHorario(HorarioDTO horario) {
        String mensaje = "Días: " + horario.getDias() + "\nInicio: " + horario.getHoraInicio() + "\nFin: " + horario.getHoraFin() + "\nCupo: " + horario.getCupoActual() + "/" + horario.getCupoMax();
        mostrarExito(mensaje);
    }

    public void navegarReportes() {
        mostrarPantalla(new GenerarReportesCursosFORM(this));
    }
    
    public void navegarConfirmacionCurso(CursoDTO curso) {
        mostrarPantalla(new ConfirmacionCursoFORM(this, curso));
    }

    public void navegarExitoCurso(CursoDTO curso) {
        mostrarPantalla(new ExitoCursoFORM(this, curso));
    }
    
    public void navegarConfirmacionHorario(HorarioDTO horario) {
        mostrarPantalla(new ConfirmacionHorarioFORM(this, horario));
    }

    public void navegarExitoHorario() {
        mostrarPantalla(new ExitoHorarioFORM(this));
    }
    
    public void navegarNoEliminarHorario() {
        mostrarPantalla(new NoEliminarHorarioInscripcionesActivasFORM(this));
    }

    // SESION
    public ClienteLogueadoDTO iniciarSesion(String pin, String contrasenia) throws NegocioException {
        this.esAdministrador = false;
        LoginDTO loginDTO = new LoginDTO(pin, contrasenia);
        this.clienteActual = funcionalidadSesion.iniciarSesion(loginDTO);
        return this.clienteActual;
    }

    public void iniciarSesionAdministrador(String pin, String contrasenia) throws NegocioException {
        funcionalidadSesion.iniciarSesionAdmin(pin, contrasenia);
        this.esAdministrador = true;
        navegarMenuAdmin();
    }

    public void cerrarSesion() {
        this.clienteActual = null;
        this.esAdministrador = false;
        navegarMenuPrincipal();
    }

    public boolean esAdministrador() {
        return esAdministrador;
    }

    public ClienteLogueadoDTO getClienteActual() {
        return clienteActual;
    }

    public JFrame getFrameActual() {
        return frameActual;
    }

    // MEMBRESIAS
    public TipoMembresiaDTO seleccionarMembresia(String tipo) {
        switch (tipo) {
            case "ORO": return TipoMembresiaDTO.ORO;
            case "PLATA": return TipoMembresiaDTO.PLATA;
            default: return TipoMembresiaDTO.BRONCE;
        }
    }

    public NuevoClienteDTO asignarMembresiaCliente(NuevoClienteDTO cliente, TipoMembresiaDTO membresia) throws NegocioException {
        NuevaMembresiaDTO membresiaDTO = funcionalidadSesion.buscarMembresiaPorTipo(membresia);
        LocalDate hoy = LocalDate.now();
        NuevaMembresiaCompradaDTO comprada = new NuevaMembresiaCompradaDTO(membresiaDTO, hoy, hoy.plusMonths(1), membresiaDTO.getPrecio(), EstadoDTO.ACTIVO);
        return new NuevoClienteDTO(cliente.getNombre(), cliente.getApellidos(), cliente.getCorreo(), cliente.getTelefono(), cliente.getContrasenia(), cliente.getFechaNacimiento(), cliente.getPin(), comprada);
    }

    public List<NuevaMembresiaDTO> consultarMembresias() throws NegocioException {
        return funcionalidadSesion.consultarMembresias();
    }

    public NuevaMembresiaDTO buscarMembresiaPorTipo(TipoMembresiaDTO tipo) throws NegocioException {
        return funcionalidadSesion.buscarMembresiaPorTipo(tipo);
    }

    public void renovarMembresia(TipoMembresiaDTO tipoDTO) throws NegocioException {
        if (this.clienteActual == null) {
            throw new NegocioException("No hay cliente logueado.");
        }
        RenovarMembresiaDTO dto = new RenovarMembresiaDTO(clienteActual.getIdCliente(), tipoDTO);
        funcionalidadSesion.renovarMembresia(dto);
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
        funcionalidadRegistro.validarTarjeta(cvv, numeroTarjeta, fechaVencimiento, nombreTitular);
        registrarNuevoCliente(cliente);
    }

    public void procesarPagoPaypal(NuevoClienteDTO cliente, String correo, String contrasenia) throws NegocioException {
        funcionalidadRegistro.validarPaypal(correo, contrasenia);
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

    // CURSOS
    public List<CursoDTO> obtenerCursos() {
        try {
            return cuCursos.listarCursos();
        } catch (NegocioException ex) {
            mostrarError(ex.getMessage());
            return new ArrayList<>();
        }
    }

    public CursoDTO agregarCurso(CursoDTO cursoDTO) {
        try {
            return cuCursos.agregarCurso(cursoDTO);
        } catch (NegocioException ex) {
            mostrarError(ex.getMessage());
            return null;
        }
    }

    public CursoDTO editarCurso(CursoDTO cursoDTO) {
        try {
            return cuCursos.editarCurso(cursoDTO);
        } catch (NegocioException ex) {
            mostrarError(ex.getMessage());
            return null;
        }
    }

    public boolean eliminarCurso(String idCurso) {
        try {
            return cuCursos.eliminarCurso(idCurso);
        } catch (NegocioException ex) {
            mostrarError(ex.getMessage());
            return false;
        }
    }

    // HORARIOS
    public List<HorarioDTO> obtenerHorariosPorCurso(String idCurso) {
        try {
            return cuCursos.listarHorariosPorCurso(idCurso);
        } catch (NegocioException ex) {
            mostrarError(ex.getMessage());
            return new ArrayList<>();
        }
    }

    public HorarioDTO agregarHorario(HorarioDTO horarioDTO) {
        try {
            return cuCursos.agregarHorario(horarioDTO);
        } catch (NegocioException ex) {
            mostrarError(ex.getMessage());
            return null;
        }
    }

    public HorarioDTO editarHorario(HorarioDTO horarioDTO) {
        try {
            return cuCursos.editarHorario(horarioDTO);
        } catch (NegocioException ex) {
            mostrarError(ex.getMessage());
            return null;
        }
    }

    public boolean eliminarHorario(String idHorario) {
        try {
            return cuCursos.eliminarHorario(idHorario);
        } catch (NegocioException ex) {
            mostrarError(ex.getMessage());
            return false;
        }
    }

    // INSCRIPCIONES
    public List<InscripcionDTO> obtenerInscripciones() {
        try {
            return cuCursos.listarInscripciones();
        } catch (NegocioException ex) {
            mostrarError(ex.getMessage());
            return new ArrayList<>();
        }
    }

    public InscripcionDTO agregarInscripcion(InscripcionDTO inscripcionDTO) {
        try {
            return cuCursos.agregarInscripcion(inscripcionDTO);
        } catch (NegocioException ex) {
            mostrarError(ex.getMessage());
            return null;
        }
    }

    // REPORTES
    public ReporteDTO generarReporte(DatosReporteDTO filtros) {
        try {
            return cuCursos.generarReporte(filtros);
        } catch (NegocioException ex) {
            mostrarError(ex.getMessage());
            return null;
        }
    }
    
    public void validarCliente(NuevoClienteDTO clienteDTO) throws NegocioException {
        funcionalidadRegistro.validarDatosUsuario(clienteDTO);
    }

    // MENSAJES
    public void mostrarError(String mensaje) {
        JOptionPane.showMessageDialog(frameActual, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }

    public void mostrarExito(String mensaje) {
        JOptionPane.showMessageDialog(frameActual, mensaje, "Éxito", JOptionPane.INFORMATION_MESSAGE);
    }

    public boolean mostrarConfirmacion(String mensaje) {
        return JOptionPane.showConfirmDialog(frameActual, mensaje, "Confirmar", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;
    }
    

}
