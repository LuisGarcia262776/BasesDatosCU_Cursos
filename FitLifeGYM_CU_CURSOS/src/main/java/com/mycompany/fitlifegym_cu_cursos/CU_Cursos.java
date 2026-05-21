/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.fitlifegym_cu_cursos;

import com.mycompany.fitlifegym_dtos.CursoDTO;
import com.mycompany.fitlifegym_dtos.DatosReporteDTO;
import com.mycompany.fitlifegym_dtos.HorarioDTO;
import com.mycompany.fitlifegym_dtos.InscripcionDTO;
import com.mycompany.fitlifegym_dtos.ReporteDTO;
import com.mycompany.fitlifegym_negocio.CursoBO;
import com.mycompany.fitlifegym_negocio.HorarioBO;
import com.mycompany.fitlifegym_negocio.ICursoBO;
import com.mycompany.fitlifegym_negocio.IHorarioBO;
import com.mycompany.fitlifegym_negocio.IInscripcionBO;
import com.mycompany.fitlifegym_negocio.IReporteBO;
import com.mycompany.fitlifegym_negocio.InscripcionBO;
import com.mycompany.fitlifegym_negocio.NegocioException;
import com.mycompany.fitlifegym_negocio.ReporteBO;
import java.util.List;

/**
 * Clase que implementa el caso de uso relacionado con la gestión
 * de cursos, horarios, inscripciones y reportes dentro del sistema.
 * 
 * Se encarga de validar la información antes de delegar las operaciones
 * a la capa de negocio correspondiente.
 * 
 * @author PC GAMER MASTER RACE
 */
public class CU_Cursos implements ICU_Cursos {
    /**
     * BO encargado de la gestión de cursos.
     */
    private final ICursoBO cursoNegocio;
    
    /**
     * BO encargado de la gestión de horarios.
     */
    private final IHorarioBO horarioNegocio;
    
    /**
     * BO encargado de la gestión de inscripciones.
     */
    private final IInscripcionBO inscripcionNegocio;
    
    /**
     * BO encargado de la generación de reportes.
     */
    private final IReporteBO reporteNegocio;

    /**
     * Constructor que inicializa las dependencias necesarias
     * para el caso de uso.
     */
    public CU_Cursos() {
        this.cursoNegocio = new CursoBO();
        this.horarioNegocio = new HorarioBO();
        this.inscripcionNegocio = new InscripcionBO();
        this.reporteNegocio =new ReporteBO();
    }

    // CURSOS
    
    /**
     * Obtiene todos los cursos registrados.
     * 
     * @return Lista de cursos.
     * @throws NegocioException Si ocurre un error durante la consulta.
     */
    @Override
    public List<CursoDTO> listarCursos() throws NegocioException {
        return cursoNegocio.obtenerTodos();
    }

    /**
     * Agrega un nuevo curso al sistema.
     * 
     * @param cursoDTO DTO con la información del curso.
     * @return CursoDTO del curso agregado.
     * @throws NegocioException Si ocurre un error durante el registro.
     */
    @Override
    public CursoDTO agregarCurso(CursoDTO cursoDTO) throws NegocioException {
        validarCurso(cursoDTO);
        return cursoNegocio.guardar(cursoDTO);
    }

    /**
     * Edita la información de un curso existente.
     * 
     * @param cursoDTO DTO con la información actualizada del curso.
     * @return CursoDTO del curso editado.
     * @throws NegocioException Si ocurre un error durante la edición.
     */
    @Override
    public CursoDTO editarCurso(CursoDTO cursoDTO) throws NegocioException {
        validarCurso(cursoDTO);
        return cursoNegocio.actualizar(cursoDTO);
    }

    /**
     * Elimina un curso del sistema.
     * 
     * @param idCurso ID del curso a eliminar.
     * @return true si el curso fue eliminado correctamente.
     * @throws NegocioException Si ocurre un error durante la eliminación.
     */
    @Override
    public boolean eliminarCurso(String idCurso) throws NegocioException {
        if (idCurso == null || idCurso.isBlank()) {
            throw new NegocioException("El idCurso es obligatorio");
        }
        
        return cursoNegocio.eliminar(idCurso);
    }
    
    // HORARIOS
    
    /**
     * Obtiene los horarios asociados a un curso.
     * 
     * @param idCurso ID del curso.
     * @return Lista de horarios del curso.
     * @throws NegocioException Si ocurre un error durante la consulta.
     */
    @Override
    public List<HorarioDTO> listarHorariosPorCurso(String idCurso) throws NegocioException {
        if (idCurso == null || idCurso.isBlank()) {
            throw new NegocioException("El idCurso es obligatorio");
        }

        return horarioNegocio.obtenerPorCurso(idCurso);
    }

    /**
     * Agrega un nuevo horario al sistema.
     * 
     * @param horarioDTO DTO con la información del horario.
     * @return HorarioDTO del horario agregado.
     * @throws NegocioException Si ocurre un error durante el registro.
     */
    @Override
    public HorarioDTO agregarHorario(HorarioDTO horarioDTO) throws NegocioException {
        validarHorario(horarioDTO);

        return horarioNegocio.guardar(horarioDTO);
    }

    /**
     * Edita un horario existente.
     * 
     * @param horarioDTO DTO con la información actualizada del horario.
     * @return HorarioDTO del horario editado.
     * @throws NegocioException Si ocurre un error durante la edición.
     */
    @Override
    public HorarioDTO editarHorario(HorarioDTO horarioDTO) throws NegocioException {
        validarHorario(horarioDTO);

        return horarioNegocio.actualizar(horarioDTO);
    }

    /**
     * Elimina un horario del sistema.
     * 
     * @param idHorario ID del horario a eliminar.
     * @return true si el horario fue eliminado correctamente.
     * @throws NegocioException Si ocurre un error durante la eliminación.
     */
    @Override
    public boolean eliminarHorario(String idHorario) throws NegocioException {
        if (idHorario == null || idHorario.isBlank()) {
            throw new NegocioException("El idHorario es obligatorio");
        }

        return horarioNegocio.eliminar(idHorario);
    }
    
    // INSCRIPCIONES
    
    /**
     * Obtiene todas las inscripciones registradas.
     * 
     * @return Lista de inscripciones.
     * @throws NegocioException Si ocurre un error durante la consulta.
     */
    @Override
    public List<InscripcionDTO> listarInscripciones() throws NegocioException {
        return inscripcionNegocio.obtenerTodas();
    }

    /**
     * Registra una nueva inscripción en un curso.
     * 
     * @param inscripcionDTO DTO con la información de la inscripción.
     * @return InscripcionDTO registrada.
     * @throws NegocioException Si ocurre un error durante el registro.
     */
    @Override
    public InscripcionDTO agregarInscripcion(InscripcionDTO inscripcionDTO) throws NegocioException {
        validarInscripcion(inscripcionDTO);

        return inscripcionNegocio.guardar(inscripcionDTO);
    }

    // REPORTES
    
    /**
     * Genera un reporte utilizando los filtros proporcionados.
     * 
     * @param datosReporteDTO DTO con la información del reporte.
     * @return ReporteDTO generado.
     * @throws NegocioException Si ocurre un error durante la generación.
     */
    @Override
    public ReporteDTO generarReporte(DatosReporteDTO datosReporteDTO) throws NegocioException {
        validarReporte(datosReporteDTO);

        return reporteNegocio.generarReporte(datosReporteDTO);
    }

    // VALIDACIONES
    
    /**
     * Valida la información de un curso.
     * 
     * @param cursoDTO DTO del curso a validar.
     * @throws NegocioException Si los datos son inválidos.
     */
    private void validarCurso(CursoDTO cursoDTO) throws NegocioException {
        if (cursoDTO == null) {
            throw new NegocioException("El curso no puede ser null");
        }

        if (cursoDTO.getNombre() == null || cursoDTO.getNombre().isBlank()) {
            throw new NegocioException("El nombre es obligatorio");
        }

        if (cursoDTO.getDescripcion() == null || cursoDTO.getDescripcion().isBlank()) {
            throw new NegocioException("La descripción es obligatoria");
        }

        if (cursoDTO.getCupoMinimo() <= 0) {
            throw new NegocioException("El cupo mínimo debe ser mayor a 0");
        }     
    }

    /**
     * Valida la información de un horario.
     * 
     * @param horarioDTO DTO del horario a validar.
     * @throws NegocioException Si los datos son inválidos.
     */
    private void validarHorario(HorarioDTO horarioDTO) throws NegocioException {
        if (horarioDTO == null) {
            throw new NegocioException("El horario no puede ser null");
        }

        if (horarioDTO.getIdCurso() == null|| horarioDTO.getIdCurso().isBlank()) {
            throw new NegocioException("El idCurso es obligatorio");
        }

        if (horarioDTO.getHoraInicio() == null) {
            throw new NegocioException("La hora inicio es obligatoria");
        }

        if (horarioDTO.getHoraFin() == null) {
            throw new NegocioException("La hora fin es obligatoria");
        }

        if (horarioDTO.getHoraInicio().isAfter(horarioDTO.getHoraFin())) {
            throw new NegocioException("Hora inicio inválida");
        }

        if (horarioDTO.getCupoMax() <= 0) {
            throw new NegocioException("El cupo máximo debe ser mayor a 0");
        }
    }

    /**
     * Valida la información de una inscripción.
     * 
     * @param inscripcionDTO DTO de la inscripción a validar.
     * @throws NegocioException Si los datos son inválidos.
     */
    private void validarInscripcion(InscripcionDTO inscripcionDTO) throws NegocioException {
        if (inscripcionDTO == null) {
            throw new NegocioException("La inscripción no puede ser null");
        }

        if (inscripcionDTO.getIdCliente() == null || inscripcionDTO.getIdCliente().isBlank()) {
            throw new NegocioException("El idCliente es obligatorio");
        }

        if (inscripcionDTO.getIdHorario() == null || inscripcionDTO.getIdHorario().isBlank()) {
            throw new NegocioException("El idHorario es obligatorio");
        }

        if (inscripcionDTO.getFechaRegistro() == null) {
            throw new NegocioException("La fechaRegistro es obligatoria");
        }
    }

    /**
     * Valida los datos necesarios para generar un reporte.
     * 
     * @param datosReporteDTO DTO con los filtros del reporte.
     * @throws NegocioException Si los datos son inválidos.
     */
    private void validarReporte(DatosReporteDTO datosReporteDTO) throws NegocioException {
        if (datosReporteDTO == null) {
            throw new NegocioException("Los filtros son obligatorios");
        }

        if (datosReporteDTO.getFechaInicio() == null) {
            throw new NegocioException("La fecha inicio es obligatoria");
        }

        if (datosReporteDTO.getFechaFin() == null) {
            throw new NegocioException("La fecha fin es obligatoria");
        }

        if (datosReporteDTO.getFechaInicio().after(datosReporteDTO.getFechaFin())) {
            throw new NegocioException("La fecha inicio no puede ser mayor");
        }
    }
    
}
