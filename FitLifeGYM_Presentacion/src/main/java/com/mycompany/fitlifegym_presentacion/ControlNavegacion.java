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
 * Clase encargada
 * de controlar la navegación
 * entre las pantallas del sistema.
 * 
 * Centraliza el acceso
 * a los casos de uso,
 * formularios y funcionalidades
 * principales de la aplicación.
 * 
 * @author Luis
 */
public class ControlNavegacion {
    
    private JFrame frameActual;
    private ClienteLogueadoDTO clienteActual;
    private boolean esAdministrador = false;

    // Subsistemas
    private final IFuncionalidadRegistrarUsuario funcionalidadRegistro;
    private final IFuncionalidadIniciarSesionRenovarMembresia funcionalidadSesion;
    private final ICU_Cursos cuCursos;

    /**
    * Constructor del controlador
    * de navegación.
    * 
    * Inicializa los subsistemas
    * y funcionalidades principales
    * del sistema.
    */
    public ControlNavegacion() {
        this.funcionalidadRegistro = new FuncionalidadRegistroUsuario();
        this.funcionalidadSesion   = new FuncionalidadIniciarSesionRenovarMembresia();
        this.cuCursos = new CU_Cursos();
    }

    /**
    * Cierra la ventana actual
    * y muestra una nueva pantalla.
    * 
    * @param nuevoFrame Nueva ventana
    * a mostrar.
    */
    private void mostrarPantalla(JFrame nuevoFrame) {
        if (this.frameActual != null) {
            this.frameActual.dispose();
        }
        this.frameActual = nuevoFrame;
        this.frameActual.setResizable(false);
        this.frameActual.setVisible(true);
    }

    /**
    * Navega al menú principal
    * del sistema.
    */
    public void navegarMenuPrincipal() {
        mostrarPantalla(new MainFitLifeFORM(this));
    }

    /**
    * Navega a la pantalla
    * de inicio de sesión.
    */
    public void navegarIniciarSesion() {
        mostrarPantalla(new IniciarSesionFORM(this));
    }

    /**
    * Navega a la pantalla
    * de registro de usuarios.
    */
    public void navegarRegistrarse() {
        mostrarPantalla(new RegistrarseFORM(this));
    }

    /**
    * Navega a la pantalla
    * de bienvenida del cliente.
    * 
    * @param cliente Cliente logueado.
    */
    public void navegarBienvenida(ClienteLogueadoDTO cliente) {
        mostrarPantalla(new BienvenidaFORM(this, cliente));
    }

    /**
    * Navega a la pantalla
    * de beneficios.
    * 
    * @param cliente Cliente
    * registrado.
    */
    public void navegarBeneficios(NuevoClienteDTO cliente) {
        mostrarPantalla(new BeneficiosFORM(this, cliente));
    }

    /**
    * Navega a la pantalla
    * de métodos de pago.
    * 
    * @param membresia Membresía seleccionada.
    * @param cliente Cliente registrado.
    */
    public void navegarMetodosPago(TipoMembresiaDTO membresia, NuevoClienteDTO cliente) {
        mostrarPantalla(new SuscribirseFORM(this, membresia, cliente));
    }

    /**
    * Navega al método
    * de pago con tarjeta.
    * 
    * @param membresia Membresía seleccionada.
    * @param cliente Cliente registrado.
    */
    public void navegarTarjetaMetodo(TipoMembresiaDTO membresia, NuevoClienteDTO cliente) {
        mostrarPantalla(new TarjetaFORM(this, membresia, cliente));
    }

    /**
    * Navega al inicio
    * de sesión de PayPal.
    * 
    * @param membresia Membresía seleccionada.
    * @param cliente Cliente registrado.
    */
    public void navegarIniciarSesionPaypal(TipoMembresiaDTO membresia, NuevoClienteDTO cliente) {
        mostrarPantalla(new IniciarSesionPaypalFORM(this, membresia, cliente));
    }

    /**
    * Navega al método
    * de transferencia bancaria.
    * 
    * @param membresia Membresía seleccionada.
    * @param cliente Cliente registrado.
    */
    public void navegarTransferenciaMetodo(TipoMembresiaDTO membresia, NuevoClienteDTO cliente) {
        mostrarPantalla(new TransferenciaFORM(this, membresia, cliente));
    }
    
    /**
    * Navega a la pantalla
    * de cursos del cliente.
    */
    public void navegarCursosCliente(){
        mostrarPantalla(new CursosClienteFORM(this));
    }
    
    /**
    * Navega a la pantalla
    * de inscripción a cursos.
    * 
    * @param curso Curso seleccionado.
    */
    public void navegarInscripcionCurso(CursoDTO curso) {
        mostrarPantalla(new InscripcionCursoFORM(this, curso));
    }
    
    /**
    * Navega a la pantalla
    * de ya inscrito.
    * 
    * @param curso Curso seleccionado.
    * @param horario Horario relacionado.
    */
    public void navegarYaInscrito(CursoDTO curso, HorarioDTO horario) {
        mostrarPantalla(new YaEstasInscritoFORM(this, curso, horario));
    }
    
    /**
    * Navega a la pantalla
    * de mis cursos.
    */
    public void navegarVerMiscursos(){
        mostrarPantalla(new MisCursosFORM(this));
    }
    
    /**
    * Navega a la pantalla
    * de horarios no disponibles.
    * 
    * @param curso Curso seleccionado.
    */
    public void navegarNoHayHorariosDisponible(CursoDTO curso){
        mostrarPantalla(new NoHayHorariosDisponiblesFORM(this, curso));
    }


    // NAVEGACION — Admin
    /**
    * Navega al menú
    * del administrador.
    */
    public void navegarMenuAdmin() {
        mostrarPantalla(new MenuCursosAdminFORM(this));
    }

    /**
    * Navega a la gestión
    * de cursos.
    */
    public void navegarGestionCursos() {
        mostrarPantalla(new GestionDeCursosFORM(this));
    }

    /**
    * Navega al formulario
    * de agregar cursos.
    */
    public void navegarAgregarCurso() {
        mostrarPantalla(new AgregarCursoFORM(this));
    }
    
    /**
    * Navega al formulario
    * de edición de cursos.
    * 
    * @param cursoDTO Curso a editar.
    */
    public void navegarEditarCurso(CursoDTO cursoDTO) {
        mostrarPantalla(new EditarCursosFORM(this, cursoDTO));
}

    /**
    * Navega a la gestión
    * de horarios.
    * 
    * @param curso Curso seleccionado.
    */
    public void navegarGestionHorarios(CursoDTO curso) {
        mostrarPantalla(new GestionHorariosFORM(this));
    }

    /**
    * Navega al formulario
    * de agregar horarios.
    * 
    * @param curso Curso seleccionado.
    */
    public void navegarAgregarHorario(CursoDTO curso) {
        mostrarPantalla(new AgregarHorarioFORM(this, curso));
    }

    /**
    * Navega al formulario
    * de edición de horarios.
    * 
    * @param horario Horario a editar.
    * @param curso Curso relacionado.
    */
    public void navegarEditarHorario(HorarioDTO horario, CursoDTO curso) {
        mostrarPantalla(new EditarHorarioFORM(this, curso));
    }

    /**
    * Muestra la información
    * de un horario.
    * 
    * @param horario Horario seleccionado.
    */
    public void navegarVerHorario(HorarioDTO horario) {
        String mensaje = "Días: " + horario.getDias() + "\nInicio: " + horario.getHoraInicio() + "\nFin: " + horario.getHoraFin() + "\nCupo: " + horario.getCupoActual() + "/" + horario.getCupoMax();
        mostrarExito(mensaje);
    }

    /**
    * Navega a la pantalla
    * de reportes.
    */
    public void navegarReportes() {
        mostrarPantalla(new GenerarReportesCursosFORM(this));
    }
    
    /**
    * Navega a la pantalla
    * de confirmación de curso.
    * 
    * @param curso Curso a confirmar.
    */
    public void navegarConfirmacionCurso(CursoDTO curso) {
        mostrarPantalla(new ConfirmacionCursoFORM(this, curso));
    }

    /**
    * Navega a la pantalla
    * de éxito de curso.
    * 
    * @param curso Curso guardado.
    */
    public void navegarExitoCurso(CursoDTO curso) {
        mostrarPantalla(new ExitoCursoFORM(this, curso));
    }
    
    /**
    * Navega a la pantalla
    * de confirmación de horario.
    * 
    * @param horario Horario a confirmar.
    */
    public void navegarConfirmacionHorario(HorarioDTO horario) {
        mostrarPantalla(new ConfirmacionHorarioFORM(this, horario));
    }

    /**
    * Navega a la pantalla
    * de éxito de horario.
    */
    public void navegarExitoHorario() {
        mostrarPantalla(new ExitoHorarioFORM(this));
    }
    
    /**
    * Navega a la pantalla
    * que impide eliminar horarios
    * con inscripciones activas.
    */
    public void navegarNoEliminarHorario() {
        mostrarPantalla(new NoEliminarHorarioInscripcionesActivasFORM(this));
    }

    // SESION
    /**
    * Inicia sesión
    * de un cliente.
    * 
    * Valida las credenciales
    * y almacena el cliente
    * actualmente logueado.
    * 
    * @param pin PIN del cliente.
    * @param contrasenia Contraseña
    * del cliente.
    * @return Cliente logueado.
    * @throws NegocioException
    * Si las credenciales son inválidas.
    */
    public ClienteLogueadoDTO iniciarSesion(String pin, String contrasenia) throws NegocioException {
        this.esAdministrador = false;
        LoginDTO loginDTO = new LoginDTO(pin, contrasenia);
        this.clienteActual = funcionalidadSesion.iniciarSesion(loginDTO);
        return this.clienteActual;
    }

    /**
    * Inicia sesión
    * de un administrador.
    * 
    * Valida las credenciales
    * del administrador
    * y navega al menú admin.
    * 
    * @param pin PIN del administrador.
    * @param contrasenia Contraseña
    * del administrador.
    * @throws NegocioException
    * Si las credenciales son inválidas.
    */
    public void iniciarSesionAdministrador(String pin, String contrasenia) throws NegocioException {
        funcionalidadSesion.iniciarSesionAdmin(pin, contrasenia);
        this.esAdministrador = true;
        navegarMenuAdmin();
    }

    /**
    * Cierra la sesión actual.
    * 
    * Limpia la información
    * del usuario logueado
    * y regresa al menú principal.
    */
    public void cerrarSesion() {
        this.clienteActual = null;
        this.esAdministrador = false;
        navegarMenuPrincipal();
    }

    /**
    * Verifica si el usuario actual
    * es administrador.
    * 
    * @return true si es administrador,
    * false en caso contrario.
    */
    public boolean esAdministrador() {
        return esAdministrador;
    }

    /**
    * Obtiene el cliente
    * actualmente logueado.
    * 
    * @return Cliente logueado.
    */
    public ClienteLogueadoDTO getClienteActual() {
        return clienteActual;
    }

    /**
    * Obtiene la ventana
    * actualmente mostrada.
    * 
    * @return Frame actual.
    */
    public JFrame getFrameActual() {
        return frameActual;
    }

    // MEMBRESIAS
    /**
    * Selecciona un tipo
    * de membresía.
    * 
    * @param tipo Nombre
    * de la membresía.
    * @return Tipo de membresía
    * correspondiente.
    */
    public TipoMembresiaDTO seleccionarMembresia(String tipo) {
        switch (tipo) {
            case "ORO": return TipoMembresiaDTO.ORO;
            case "PLATA": return TipoMembresiaDTO.PLATA;
            default: return TipoMembresiaDTO.BRONCE;
        }
    }

    /**
    * Asigna una membresía
    * a un cliente.
    * 
    * Genera la membresía comprada
    * y actualiza los datos
    * del cliente.
    * 
    * @param cliente Cliente registrado.
    * @param membresia Membresía seleccionada.
    * @return Cliente actualizado
    * con membresía.
    * @throws NegocioException
    * Si ocurre un error.
    */
    public NuevoClienteDTO asignarMembresiaCliente(NuevoClienteDTO cliente, TipoMembresiaDTO membresia) throws NegocioException {
        NuevaMembresiaDTO membresiaDTO = funcionalidadSesion.buscarMembresiaPorTipo(membresia);
        LocalDate hoy = LocalDate.now();
        NuevaMembresiaCompradaDTO comprada = new NuevaMembresiaCompradaDTO(membresiaDTO, hoy, hoy.plusMonths(1), membresiaDTO.getPrecio(), EstadoDTO.ACTIVO);
        return new NuevoClienteDTO(cliente.getNombre(), cliente.getApellidos(), cliente.getCorreo(), cliente.getTelefono(), cliente.getContrasenia(), cliente.getFechaNacimiento(), cliente.getPin(), comprada);
    }

    /**
    * Consulta todas
    * las membresías disponibles.
    * 
    * @return Lista de membresías.
    * @throws NegocioException
    * Si ocurre un error.
    */
    public List<NuevaMembresiaDTO> consultarMembresias() throws NegocioException {
        return funcionalidadSesion.consultarMembresias();
    }

    /**
    * Busca una membresía
    * por su tipo.
    * 
    * @param tipo Tipo de membresía.
    * @return Membresía encontrada.
    * @throws NegocioException
    * Si no se encuentra.
    */
    public NuevaMembresiaDTO buscarMembresiaPorTipo(TipoMembresiaDTO tipo) throws NegocioException {
        return funcionalidadSesion.buscarMembresiaPorTipo(tipo);
    }

    /**
    * Renueva la membresía
    * del cliente actual.
    * 
    * @param tipoDTO Nuevo tipo
    * de membresía.
    * @throws NegocioException
    * Si no existe cliente logueado.
    */
    public void renovarMembresia(TipoMembresiaDTO tipoDTO) throws NegocioException {
        if (this.clienteActual == null) {
            throw new NegocioException("No hay cliente logueado.");
        }
        RenovarMembresiaDTO dto = new RenovarMembresiaDTO(clienteActual.getIdCliente(), tipoDTO);
        funcionalidadSesion.renovarMembresia(dto);
    }

    // CLIENTES
    /**
    * Valida los datos
    * de un cliente.
    * 
    * @param clienteDTO Cliente
    * a validar.
    * @throws NegocioException
    * Si los datos son inválidos.
    */
    public void registrarCliente(NuevoClienteDTO clienteDTO) throws NegocioException {
        funcionalidadRegistro.validarDatosUsuario(clienteDTO);
    }

    /**
    * Consulta todos
    * los clientes registrados.
    * 
    * @return Lista de clientes.
    * @throws NegocioException
    * Si ocurre un error.
    */
    public List<NuevoClienteDTO> consultarClientes() throws NegocioException {
        return funcionalidadRegistro.obtenerTodas();
    }

    // PAGOS
    /**
    * Procesa un pago
    * mediante tarjeta.
    * 
    * Valida los datos
    * y registra al cliente.
    * 
    * @param cliente Cliente registrado.
    * @param numeroTarjeta Número de tarjeta.
    * @param cvv Código CVV.
    * @param fechaVencimiento Fecha de vencimiento.
    * @param nombreTitular Nombre del titular.
    * @throws NegocioException
    * Si los datos son inválidos.
    */
    public void procesarPagoTarjeta(NuevoClienteDTO cliente, String numeroTarjeta, String cvv, String fechaVencimiento, String nombreTitular) throws NegocioException {
        funcionalidadRegistro.validarTarjeta(cvv, numeroTarjeta, fechaVencimiento, nombreTitular);
        registrarNuevoCliente(cliente);
    }

    /**
    * Procesa un pago
    * mediante PayPal.
    * 
    * @param cliente Cliente registrado.
    * @param correo Correo de PayPal.
    * @param contrasenia Contraseña
    * de PayPal.
    * @throws NegocioException
    * Si ocurre un error.
    */
    public void procesarPagoPaypal(NuevoClienteDTO cliente, String correo, String contrasenia) throws NegocioException {
        funcionalidadRegistro.validarPaypal(correo, contrasenia);
        registrarNuevoCliente(cliente);
    }

    /**
    * Procesa un pago
    * mediante transferencia.
    * 
    * @param cliente Cliente registrado.
    * @throws NegocioException
    * Si ocurre un error.
    */
    public void procesarPagoTransferencia(NuevoClienteDTO cliente) throws NegocioException {
        registrarNuevoCliente(cliente);
    }

    /**
    * Registra un nuevo cliente
    * dentro del sistema.
    * 
    * @param cliente Cliente
    * a registrar.
    * @throws NegocioException
    * Si faltan datos.
    */
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
    /**
    * Obtiene todos
    * los cursos disponibles.
    * 
    * @return Lista de cursos.
    */
    public List<CursoDTO> obtenerCursos() {
        try {
            return cuCursos.listarCursos();
        } catch (NegocioException ex) {
            mostrarError(ex.getMessage());
            return new ArrayList<>();
        }
    }

    /**
    * Agrega un nuevo curso.
    * 
    * @param cursoDTO Curso
    * a registrar.
    * @return Curso guardado.
    */
    public CursoDTO agregarCurso(CursoDTO cursoDTO) {
        try {
            return cuCursos.agregarCurso(cursoDTO);
        } catch (NegocioException ex) {
            mostrarError(ex.getMessage());
            return null;
        }
    }

    /**
    * Edita un curso existente.
    * 
    * @param cursoDTO Curso
    * a editar.
    * @return Curso actualizado.
    */
    public CursoDTO editarCurso(CursoDTO cursoDTO) {
        try {
            return cuCursos.editarCurso(cursoDTO);
        } catch (NegocioException ex) {
            mostrarError(ex.getMessage());
            return null;
        }
    }

    /**
    * Elimina un curso.
    * 
    * @param idCurso ID del curso.
    * @return true si fue eliminado.
    */
    public boolean eliminarCurso(String idCurso) {
        try {
            return cuCursos.eliminarCurso(idCurso);
        } catch (NegocioException ex) {
            mostrarError(ex.getMessage());
            return false;
        }
    }

    // HORARIOS
    /**
    * Obtiene los horarios
    * de un curso.
    * 
    * @param idCurso ID del curso.
    * @return Lista de horarios.
    */
    public List<HorarioDTO> obtenerHorariosPorCurso(String idCurso) {
        try {
            return cuCursos.listarHorariosPorCurso(idCurso);
        } catch (NegocioException ex) {
            mostrarError(ex.getMessage());
            return new ArrayList<>();
        }
    }

    /**
    * Agrega un nuevo horario.
    * 
    * @param horarioDTO Horario
    * a registrar.
    * @return Horario guardado.
    */
    public HorarioDTO agregarHorario(HorarioDTO horarioDTO) {
        try {
            return cuCursos.agregarHorario(horarioDTO);
        } catch (NegocioException ex) {
            mostrarError(ex.getMessage());
            return null;
        }
    }

    /**
    * Edita un horario existente.
    * 
    * @param horarioDTO Horario
    * a editar.
    * @return Horario actualizado.
    */
    public HorarioDTO editarHorario(HorarioDTO horarioDTO) {
        try {
            return cuCursos.editarHorario(horarioDTO);
        } catch (NegocioException ex) {
            mostrarError(ex.getMessage());
            return null;
        }
    }

    /**
    * Elimina un horario.
    * 
    * @param idHorario ID del horario.
    * @return true si fue eliminado.
    */
    public boolean eliminarHorario(String idHorario) {
        try {
            return cuCursos.eliminarHorario(idHorario);
        } catch (NegocioException ex) {
            mostrarError(ex.getMessage());
            return false;
        }
    }

    // INSCRIPCIONES
    /**
    * Obtiene todas
    * las inscripciones.
    * 
    * @return Lista de inscripciones.
    */
    public List<InscripcionDTO> obtenerInscripciones() {
        try {
            return cuCursos.listarInscripciones();
        } catch (NegocioException ex) {
            mostrarError(ex.getMessage());
            return new ArrayList<>();
        }
    }

    /**
    * Agrega una inscripción.
    * 
    * @param inscripcionDTO Inscripción
    * a registrar.
    * @return Inscripción guardada.
    */
    public InscripcionDTO agregarInscripcion(InscripcionDTO inscripcionDTO) {
        try {
            return cuCursos.agregarInscripcion(inscripcionDTO);
        } catch (NegocioException ex) {
            mostrarError(ex.getMessage());
            return null;
        }
    }

    // REPORTES
    /**
    * Genera un reporte
    * de cursos.
    * 
    * @param filtros Filtros
    * del reporte.
    * @return Reporte generado.
    */
    public ReporteDTO generarReporte(DatosReporteDTO filtros) {
        try {
            return cuCursos.generarReporte(filtros);
        } catch (NegocioException ex) {
            mostrarError(ex.getMessage());
            return null;
        }
    }
    
    /**
    * Valida los datos
    * de un cliente.
    * 
    * @param clienteDTO Cliente
    * a validar.
    * @throws NegocioException
    * Si los datos son inválidos.
    */
    public void validarCliente(NuevoClienteDTO clienteDTO) throws NegocioException {
        funcionalidadRegistro.validarDatosUsuario(clienteDTO);
    }

    // MENSAJES
    /**
    * Muestra un mensaje
    * de error.
    * 
    * @param mensaje Mensaje
    * a mostrar.
    */
    public void mostrarError(String mensaje) {
        JOptionPane.showMessageDialog(frameActual, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }

    /**
    * Muestra un mensaje
    * de éxito.
    * 
    * @param mensaje Mensaje
    * a mostrar.
    */
    public void mostrarExito(String mensaje) {
        JOptionPane.showMessageDialog(frameActual, mensaje, "Éxito", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
    * Muestra un cuadro
    * de confirmación.
    * 
    * @param mensaje Mensaje
    * de confirmación.
    * @return true si el usuario
    * confirma la acción.
    */
    public boolean mostrarConfirmacion(String mensaje) {
        return JOptionPane.showConfirmDialog(frameActual, mensaje, "Confirmar", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;
    }
    

}
