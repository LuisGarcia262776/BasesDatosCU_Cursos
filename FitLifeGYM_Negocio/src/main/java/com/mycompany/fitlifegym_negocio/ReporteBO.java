/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.fitlifegym_negocio;

import Adapter.DtosAEntidadesAdapter;
import com.mycompany.fitlifegym_PersistenciaException.PersistenciaException;
import com.mycompany.fitlifegym_dtos.CursoDTO;
import com.mycompany.fitlifegym_dtos.DatosReporteDTO;
import com.mycompany.fitlifegym_dtos.HorarioDTO;
import com.mycompany.fitlifegym_dtos.ReporteDTO;
import com.mycompany.fitlifegym_persistencia.entidades.Curso;
import com.mycompany.fitlifegym_persistencia.entidades.Horario;
import com.mycompany.fitlifegym_persistencia_Fachada.IPersistenciaFachada;
import com.mycompany.fitlifegym_persistencia_Fachada.PersistenciaFachada;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author PC GAMER MASTER RACE
 */
public class ReporteBO implements IReporteBO {
    
    private final IPersistenciaFachada fachada;

    public ReporteBO() {
        this.fachada = new PersistenciaFachada();
    }

    @Override
    public DatosReporteDTO obtenerDatosReporte(DatosReporteDTO datosReporteDTO) throws NegocioException {
        if (!validarFiltros(datosReporteDTO)) {
            throw new NegocioException("Filtros inválidos");
        }

        return datosReporteDTO;
    }

    @Override
    public ReporteDTO generarReporte(DatosReporteDTO datosReporteDTO) throws NegocioException {
        try {
            if (!validarFiltros(datosReporteDTO)) {
                throw new NegocioException("Filtros inválidos");
            }

            List<Curso> cursosEntidad = fachada.obtenerCursoDAO().obtenerTodos();
            List<CursoDTO> cursosDTO = new ArrayList<>();
            List<HorarioDTO> horariosDTO = new ArrayList<>();

            for (Curso curso : cursosEntidad) {
                // Filtrar por idCurso 
                if (datosReporteDTO.getCurso() != null && !datosReporteDTO.getCurso().isBlank() && !curso.getIdCurso().equals(datosReporteDTO.getCurso())) {
                    continue;
                }
                List<Horario> horariosEntidad = fachada.obtenerHorarioDAO().obtenerPorCurso(curso.getIdCurso());
                for (Horario horario : horariosEntidad) {
                    // Filtrar por cantidadMin
                    if (datosReporteDTO.getCantidadMin() > 0 && horario.getCupoActual() < datosReporteDTO.getCantidadMin()) {
                        continue;
                    }

                    // Si pasa los filtros lo agrega 
                    CursoDTO cursoDTO = DtosAEntidadesAdapter.adaptarCurso(curso);
                    HorarioDTO horarioDTO = DtosAEntidadesAdapter.adaptarHorario(horario);
                    cursosDTO.add(cursoDTO);
                    horariosDTO.add(horarioDTO);
                }
            }
            return new ReporteDTO(new Date(), cursosDTO, horariosDTO);

        } catch (PersistenciaException ex) {
            throw new NegocioException("Error al generar reporte.", ex);
        }
    }

    @Override
    public boolean validarFiltros(DatosReporteDTO datosReporteDTO) throws NegocioException {
        if (datosReporteDTO == null) {
            return false;
        }

        if (datosReporteDTO.getFechaInicio() == null) {
            return false;
        }

        if (datosReporteDTO.getFechaFin() == null) {
            return false;
        }

        if (datosReporteDTO.getFechaInicio().after(datosReporteDTO.getFechaFin())) {
            return false;
        }

        return true;
    }
    
}
