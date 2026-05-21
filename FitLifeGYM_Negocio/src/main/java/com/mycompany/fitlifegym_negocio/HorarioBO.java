/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.fitlifegym_negocio;

import Adapter.DtosAEntidadesAdapter;
import com.mycompany.fitlifegym_PersistenciaException.PersistenciaException;
import com.mycompany.fitlifegym_dtos.HorarioDTO;
import com.mycompany.fitlifegym_persistencia.entidades.Horario;
import com.mycompany.fitlifegym_persistencia_Fachada.IPersistenciaFachada;
import com.mycompany.fitlifegym_persistencia_Fachada.PersistenciaFachada;
import java.util.List;

/**
 * Clase de negocio encargada de gestionar
 * las operaciones relacionadas con los horarios.
 * 
 * Permite registrar, actualizar, eliminar
 * y consultar horarios mediante la capa de persistencia.
 * 
 * @author PC GAMER MASTER RACE
 */
public class HorarioBO implements IHorarioBO{
    /**
     * Fachada utilizada para acceder a la capa de persistencia.
     */
    private final IPersistenciaFachada fachada;

    /**
     * Constructor que inicializa la fachada
     * de persistencia.
     */
    public HorarioBO() {
        this.fachada = new PersistenciaFachada();
    }

    /**
     * Obtiene todos los horarios asociados
     * a un curso específico.
     * 
     * @param idCurso ID del curso.
     * @return Lista de horarios del curso.
     * @throws NegocioException Se lanza cuando el ID
     * es inválido o ocurre un error en persistencia.
     */
    @Override
    public List<HorarioDTO> obtenerPorCurso(String idCurso) throws NegocioException {
        try {
            if (idCurso == null || idCurso.isBlank()) {
                throw new NegocioException("El idCurso es obligatorio");
            }

            List<Horario> horarios = fachada.obtenerHorarioDAO().obtenerPorCurso(idCurso);

            return DtosAEntidadesAdapter.adaptarListaHorarios(horarios);
            
        } catch (PersistenciaException ex) {
            throw new NegocioException("Error al obtener horarios.",ex);
        }
    }

    /**
     * Obtiene todos los horarios registrados.
     * 
     * @return Lista de horarios.
     * @throws NegocioException Se lanza cuando ocurre
     * un error al consultar horarios.
     */
    @Override
    public List<HorarioDTO> obtenerTodos() throws NegocioException {
        try {
            List<Horario> horarios = fachada.obtenerHorarioDAO().obtenerTodos();

            return DtosAEntidadesAdapter.adaptarListaHorarios(horarios);
            
        } catch (PersistenciaException ex) {
            throw new NegocioException("Error al obtener horarios.",ex);
        }
    }

    /**
     * Obtiene un horario mediante su ID.
     * 
     * @param idHorario ID del horario.
     * @return DTO con la información del horario.
     * @throws NegocioException Se lanza cuando el ID
     * es inválido o ocurre un error en persistencia.
     */
    @Override
    public HorarioDTO obtenerPorId(String idHorario) throws NegocioException {
        try {
            if (idHorario == null || idHorario.isBlank()) {
                throw new NegocioException("El idHorario es obligatorio");
            }

            Horario horario = fachada.obtenerHorarioDAO().obtenerPorId(idHorario);

            return DtosAEntidadesAdapter.adaptarHorario(horario);
            
        } catch (PersistenciaException ex) {
            throw new NegocioException("Error al obtener horario.",ex);
        }       
    }

    /**
     * Guarda un nuevo horario dentro del sistema.
     * 
     * @param horarioDTO DTO con la información del horario.
     * @return DTO del horario guardado.
     * @throws NegocioException Se lanza cuando los datos
     * son inválidos o ocurre un error en persistencia.
     */
    @Override
    public HorarioDTO guardar(HorarioDTO horarioDTO) throws NegocioException {
        try {
            validarHorario(horarioDTO);

            Horario horario = DtosAEntidadesAdapter.adaptarHorarioDTO(horarioDTO);

            Horario horarioGuardado = fachada.obtenerHorarioDAO().guardar(horario);

            return DtosAEntidadesAdapter.adaptarHorario(horarioGuardado);
            
        } catch (PersistenciaException ex) {
            throw new NegocioException("Error al guardar horario.",ex);
        }
    }

    /**
     * Actualiza la información de un horario existente.
     * 
     * @param horarioDTO DTO con la información actualizada.
     * @return DTO del horario actualizado.
     * @throws NegocioException Se lanza cuando los datos
     * son inválidos o ocurre un error en persistencia.
     */
    @Override
    public HorarioDTO actualizar(HorarioDTO horarioDTO) throws NegocioException {
        try {
            validarHorario(horarioDTO);

            Horario horario = DtosAEntidadesAdapter.adaptarHorarioDTO(horarioDTO);

            Horario horarioActualizado = fachada.obtenerHorarioDAO().actualizar(horario);

            return DtosAEntidadesAdapter.adaptarHorario(horarioActualizado);
            
        } catch (PersistenciaException ex) {
            throw new NegocioException("Error al actualizar horario.",ex);
        }
    }

    /**
     * Elimina un horario mediante su ID.
     * 
     * @param idHorario ID del horario.
     * @return true si el horario fue eliminado correctamente.
     * @throws NegocioException Se lanza cuando el ID
     * es inválido o ocurre un error en persistencia.
     */
    @Override
    public boolean eliminar(String idHorario) throws NegocioException {
        try {
            if (idHorario == null || idHorario.isBlank()) {
                throw new NegocioException("El idHorario es obligatorio");
            }

            return fachada.obtenerHorarioDAO().eliminar(idHorario);

        } catch (PersistenciaException ex) {
            throw new NegocioException("Error al eliminar horario.",ex);
        }
    }
    
    /**
     * Valida la información de un horario antes
     * de guardarlo o actualizarlo.
     * 
     * @param horarioDTO DTO del horario a validar.
     * @throws NegocioException Se lanza cuando
     * los datos del horario son inválidos.
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
    
}
