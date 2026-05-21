/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.fitlifegym_cu_cursos;

import com.mycompany.fitlifegym_dtos.CursoDTO;
import com.mycompany.fitlifegym_dtos.DatosReporteDTO;
import com.mycompany.fitlifegym_dtos.HorarioDTO;
import com.mycompany.fitlifegym_dtos.InscripcionDTO;
import com.mycompany.fitlifegym_dtos.ReporteDTO;
import com.mycompany.fitlifegym_negocio.NegocioException;
import java.util.List;

/**
 * Interfaz que define las operaciones relacionadas con la gestión
 * de cursos, horarios, inscripciones y reportes dentro del sistema.
 * 
 * @author PC GAMER MASTER RACE
 */
public interface ICU_Cursos {
    // CURSOS
    /**
     * Obtiene todos los cursos registrados.
     * 
     * @return Lista de cursos.
     * @throws NegocioException Si ocurre un error durante la consulta.
     */
    public List<CursoDTO> listarCursos() throws NegocioException;

    /**
     * Agrega un nuevo curso al sistema.
     * 
     * @param cursoDTO DTO con la información del curso.
     * @return CursoDTO del curso agregado.
     * @throws NegocioException Si ocurre un error durante el registro.
     */
    public CursoDTO agregarCurso(CursoDTO cursoDTO) throws NegocioException;

    /**
     * Edita la información de un curso existente.
     * 
     * @param cursoDTO DTO con la información actualizada del curso.
     * @return CursoDTO del curso editado.
     * @throws NegocioException Si ocurre un error durante la edición.
     */
    public CursoDTO editarCurso(CursoDTO cursoDTO) throws NegocioException;

    /**
     * Elimina un curso del sistema.
     * 
     * @param idCurso ID del curso a eliminar.
     * @return true si el curso fue eliminado correctamente.
     * @throws NegocioException Si ocurre un error durante la eliminación.
     */
    public boolean eliminarCurso(String idCurso) throws NegocioException;

    // HORARIOS
    
    /**
     * Obtiene todos los horarios asociados a un curso.
     * 
     * @param idCurso ID del curso.
     * @return Lista de horarios del curso.
     * @throws NegocioException Si ocurre un error durante la consulta.
     */
    public List<HorarioDTO> listarHorariosPorCurso(String idCurso) throws NegocioException;

    /**
     * Agrega un nuevo horario a un curso.
     * 
     * @param horarioDTO DTO con la información del horario.
     * @return HorarioDTO del horario agregado.
     * @throws NegocioException Si ocurre un error durante el registro.
     */
    public HorarioDTO agregarHorario(HorarioDTO horarioDTO) throws NegocioException;

    /**
     * Edita un horario existente.
     * 
     * @param horarioDTO DTO con la información actualizada del horario.
     * @return HorarioDTO del horario editado.
     * @throws NegocioException Si ocurre un error durante la edición.
     */
    public HorarioDTO editarHorario(HorarioDTO horarioDTO) throws NegocioException;

    /**
     * Elimina un horario del sistema.
     * 
     * @param idHorario ID del horario a eliminar.
     * @return true si el horario fue eliminado correctamente.
     * @throws NegocioException Si ocurre un error durante la eliminación.
     */
    public boolean eliminarHorario(String idHorario) throws NegocioException;

    // INSCRIPCIONES
    
    /**
     * Obtiene todas las inscripciones registradas.
     * 
     * @return Lista de inscripciones.
     * @throws NegocioException Si ocurre un error durante la consulta.
     */
    public List<InscripcionDTO> listarInscripciones() throws NegocioException;

    /**
     * Registra una nueva inscripción en un curso.
     * 
     * @param inscripcionDTO DTO con la información de la inscripción.
     * @return InscripcionDTO de la inscripción registrada.
     * @throws NegocioException Si ocurre un error durante el registro.
     */
    public InscripcionDTO agregarInscripcion(InscripcionDTO inscripcionDTO) throws NegocioException;

    // REPORTES
    
    /**
     * Genera un reporte con base en los datos proporcionados.
     * 
     * @param datosReporteDTO DTO con los filtros y datos del reporte.
     * @return ReporteDTO generado.
     * @throws NegocioException Si ocurre un error durante la generación del reporte.
     */
    public ReporteDTO generarReporte(DatosReporteDTO datosReporteDTO) throws NegocioException;
    
}