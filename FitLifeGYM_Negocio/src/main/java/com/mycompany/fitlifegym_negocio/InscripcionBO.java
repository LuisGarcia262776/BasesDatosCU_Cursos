/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.fitlifegym_negocio;

import Adapter.DtosAEntidadesAdapter;
import com.mycompany.fitlifegym_PersistenciaException.PersistenciaException;
import com.mycompany.fitlifegym_dtos.InscripcionDTO;
import com.mycompany.fitlifegym_persistencia.entidades.Horario;
import com.mycompany.fitlifegym_persistencia.entidades.Inscripcion;
import com.mycompany.fitlifegym_persistencia_Fachada.IPersistenciaFachada;
import com.mycompany.fitlifegym_persistencia_Fachada.PersistenciaFachada;
import java.util.List;

/**
 *
 * @author PC GAMER MASTER RACE
 */
public class InscripcionBO implements IInscripcionBO{
    
    private final IPersistenciaFachada fachada;

    public InscripcionBO() {
        this.fachada = new PersistenciaFachada();
    }

    @Override
    public List<InscripcionDTO> obtenerTodas() throws NegocioException {
        try {
            List<Inscripcion> inscripciones = fachada.obtenerInscripcionDAO().obtenerTodas();

            return DtosAEntidadesAdapter.adaptarListaInscripciones(inscripciones);
        } catch (PersistenciaException ex) {
            throw new NegocioException("Error al obtener inscripciones.",ex);
        }
    }

    @Override
    public InscripcionDTO obtenerPorId(String idInscripcion) throws NegocioException {
        try {
            if (idInscripcion == null || idInscripcion.isBlank()) {
                throw new NegocioException("El idInscripcion es obligatorio");
            }

            Inscripcion inscripcion =fachada.obtenerInscripcionDAO().obtenerPorId(idInscripcion);

            return DtosAEntidadesAdapter.adaptarInscripcion(inscripcion);
        } catch (PersistenciaException ex) {
            throw new NegocioException("Error al obtener inscripción.",ex);
        }
    }

    @Override
    public InscripcionDTO guardar(InscripcionDTO inscripcionDTO) throws NegocioException {
        try {
            validarInscripcion(inscripcionDTO);

            Horario horario = fachada.obtenerHorarioDAO().obtenerPorId(inscripcionDTO.getIdHorario());
            if (horario == null) {
                throw new NegocioException("El horario no existe");
            }

            if (horario.getCupoActual() >= horario.getCupoMax()) {
                throw new NegocioException("El horario ya no tiene cupo");
            }

            Inscripcion inscripcion = DtosAEntidadesAdapter.adaptarInscripcionDTO(inscripcionDTO);

            Inscripcion guardada = fachada.obtenerInscripcionDAO().guardar(inscripcion);

            return DtosAEntidadesAdapter.adaptarInscripcion(guardada);
        } catch (PersistenciaException ex) {
            throw new NegocioException("Error al guardar inscripción.",ex);
        }
    }

    @Override
    public InscripcionDTO actualizar(InscripcionDTO inscripcionDTO) throws NegocioException {
        try {
            validarInscripcion(inscripcionDTO);

            Inscripcion inscripcion = DtosAEntidadesAdapter.adaptarInscripcionDTO(inscripcionDTO);

            Inscripcion actualizada = fachada.obtenerInscripcionDAO().actualizar(inscripcion);

            return DtosAEntidadesAdapter.adaptarInscripcion(actualizada);
        } catch (PersistenciaException ex) {
            throw new NegocioException("Error al actualizar inscripción.",ex);
        }
    }

    @Override
    public Integer contarTotales() throws NegocioException {
        try {
            return fachada.obtenerInscripcionDAO().contarTotales();
        } catch (PersistenciaException ex) {
            throw new NegocioException("Error al contar inscripciones.",ex);
        }
    }

    @Override
    public Integer contarPorHorario(String idHorario) throws NegocioException {
        try {
            if (idHorario == null || idHorario.isBlank()) {
                throw new NegocioException("El idHorario es obligatorio");
            }

            return fachada.obtenerInscripcionDAO().contarPorHorario(idHorario);
        } catch (PersistenciaException ex) {
            throw new NegocioException("Error al contar inscripciones.",ex);
        }
    }

    @Override
    public List<InscripcionDTO> obtenerActivasPorHorario(String idHorario) throws NegocioException {
        try {
            if (idHorario == null || idHorario.isBlank()) {
                throw new NegocioException("El idHorario es obligatorio");
            }

            List<Inscripcion> inscripciones = fachada.obtenerInscripcionDAO().obtenerActivasPorHorario(idHorario);

            return DtosAEntidadesAdapter.adaptarListaInscripciones(inscripciones);
        } catch (PersistenciaException ex) {
            throw new NegocioException("Error al obtener inscripciones.",ex);
        }
    }

    @Override
    public List<InscripcionDTO> obtenerPorCliente(String idCliente) throws NegocioException {
        try {
            if (idCliente == null || idCliente.isBlank()) {
                throw new NegocioException("El idCliente es obligatorio");
            }

            List<Inscripcion> inscripciones = fachada.obtenerInscripcionDAO().obtenerPorCliente(idCliente);

            return DtosAEntidadesAdapter.adaptarListaInscripciones(inscripciones);
        } catch (PersistenciaException ex) {
            throw new NegocioException("Error al obtener inscripciones.",ex);
        }
    }
    
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
    
}
