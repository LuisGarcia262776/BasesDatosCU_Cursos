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
 *
 * @author PC GAMER MASTER RACE
 */
public class HorarioBO implements IHorarioBO{
    
    private final IPersistenciaFachada fachada;

    public HorarioBO() {
        this.fachada = new PersistenciaFachada();
    }

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

    @Override
    public List<HorarioDTO> obtenerTodos() throws NegocioException {
        try {
            List<Horario> horarios = fachada.obtenerHorarioDAO().obtenerTodos();

            return DtosAEntidadesAdapter.adaptarListaHorarios(horarios);
        } catch (PersistenciaException ex) {
            throw new NegocioException("Error al obtener horarios.",ex);
        }
    }

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
