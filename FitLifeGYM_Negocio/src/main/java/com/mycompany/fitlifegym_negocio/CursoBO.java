/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.fitlifegym_negocio;

import Adapter.DtosAEntidadesAdapter;
import com.mycompany.fitlifegym_PersistenciaException.PersistenciaException;
import com.mycompany.fitlifegym_dtos.CursoDTO;
import com.mycompany.fitlifegym_persistencia.entidades.Curso;
import com.mycompany.fitlifegym_persistencia_Fachada.IPersistenciaFachada;
import com.mycompany.fitlifegym_persistencia_Fachada.PersistenciaFachada;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author PC GAMER MASTER RACE
 */
public class CursoBO implements ICursoBO{
    
    private final IPersistenciaFachada fachada;

    public CursoBO() {
        this.fachada = new PersistenciaFachada();
    }

    @Override
    public List<CursoDTO> obtenerTodos() throws NegocioException {
        try {
            List<Curso> cursos = fachada.obtenerCursoDAO().obtenerTodos();
            List<CursoDTO> cursosDTO = new LinkedList<>();

            for (Curso curso : cursos) {
                CursoDTO dto = DtosAEntidadesAdapter.adaptarCurso(curso);
                cursosDTO.add(dto);
            }

            return cursosDTO;
        } catch (PersistenciaException ex) {
            throw new NegocioException("Error al obtener cursos.",ex);
        }
    }

    @Override
    public CursoDTO obtenerPorId(String idCurso) throws NegocioException {
        try {
            if (idCurso == null || idCurso.isBlank()) {
                throw new NegocioException("El id del curso es obligatorio");
            }

            Curso curso = fachada.obtenerCursoDAO().obtenerPorId(idCurso);

            return DtosAEntidadesAdapter.adaptarCurso(curso);
        } catch (PersistenciaException ex) {
            throw new NegocioException("Error al obtener curso.", ex);
        }
    }

    @Override
    public CursoDTO guardar(CursoDTO cursoDTO) throws NegocioException {
        try {
            validarCurso(cursoDTO);

            Curso curso = DtosAEntidadesAdapter.adaptarCursoDTO(cursoDTO);

            Curso cursoGuardado = fachada.obtenerCursoDAO().guardar(curso);

            return DtosAEntidadesAdapter.adaptarCurso(cursoGuardado);

        } catch (PersistenciaException ex) {
            throw new NegocioException("Error al guardar curso.",ex);
        }
    }

    @Override
    public CursoDTO actualizar(CursoDTO cursoDTO) throws NegocioException {
        try {
            validarCurso(cursoDTO);

            Curso curso = DtosAEntidadesAdapter.adaptarCursoDTO(cursoDTO);

            Curso cursoActualizado = fachada.obtenerCursoDAO().actualizar(curso);

            return DtosAEntidadesAdapter.adaptarCurso(cursoActualizado);

        } catch (PersistenciaException ex) {
            throw new NegocioException("Error al actualizar curso.",ex);
        }
    }

    @Override
    public boolean eliminar(String idCurso) throws NegocioException {
        try {
            if (idCurso == null || idCurso.isBlank()) {
                throw new NegocioException("El id es obligatorio");
            }

            return fachada.obtenerCursoDAO().eliminar(idCurso);

        } catch (PersistenciaException ex) {
            throw new NegocioException("Error al eliminar curso.",ex);
        }
    }
    
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
    
    
    
    
}
