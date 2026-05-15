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
 *
 * @author PC GAMER MASTER RACE
 */
public class CU_Cursos implements ICU_Cursos {
    
    private final ICursoBO cursoNegocio;
    private final IHorarioBO horarioNegocio;
    private final IInscripcionBO inscripcionNegocio;
    private final IReporteBO reporteNegocio;

    public CU_Cursos() {
        this.cursoNegocio = new CursoBO();
        this.horarioNegocio = new HorarioBO();
        this.inscripcionNegocio = new InscripcionBO();
        this.reporteNegocio =new ReporteBO();
    }

    // CURSOS
    @Override
    public List<CursoDTO> listarCursos() throws NegocioException {
        return cursoNegocio.obtenerTodos();
    }

    @Override
    public CursoDTO agregarCurso(CursoDTO cursoDTO) throws NegocioException {
        validarCurso(cursoDTO);
        return cursoNegocio.guardar(cursoDTO);
    }

    @Override
    public CursoDTO editarCurso(CursoDTO cursoDTO) throws NegocioException {
        validarCurso(cursoDTO);
        return cursoNegocio.actualizar(cursoDTO);
    }

    @Override
    public boolean eliminarCurso(String idCurso) throws NegocioException {
        if (idCurso == null || idCurso.isBlank()) {
            throw new NegocioException("El idCurso es obligatorio");
        }
        return cursoNegocio.eliminar(idCurso);
    }
    
    // HORARIOS
    @Override
    public List<HorarioDTO> listarHorariosPorCurso(String idCurso) throws NegocioException {
        if (idCurso == null || idCurso.isBlank()) {
            throw new NegocioException("El idCurso es obligatorio");
        }

        return horarioNegocio.obtenerPorCurso(idCurso);
    }

    @Override
    public HorarioDTO agregarHorario(HorarioDTO horarioDTO) throws NegocioException {
        validarHorario(horarioDTO);

        return horarioNegocio.guardar(horarioDTO);
    }

    @Override
    public HorarioDTO editarHorario(HorarioDTO horarioDTO) throws NegocioException {
        validarHorario(horarioDTO);

        return horarioNegocio.actualizar(horarioDTO);
    }

    @Override
    public boolean eliminarHorario(String idHorario) throws NegocioException {
        if (idHorario == null || idHorario.isBlank()) {
            throw new NegocioException("El idHorario es obligatorio");
        }

        return horarioNegocio.eliminar(idHorario);
    }
    
    // INSCRIPCIONES
    @Override
    public List<InscripcionDTO> listarInscripciones() throws NegocioException {
        return inscripcionNegocio.obtenerTodas();
    }

    @Override
    public InscripcionDTO agregarInscripcion(InscripcionDTO inscripcionDTO) throws NegocioException {
        validarInscripcion(inscripcionDTO);

        return inscripcionNegocio.guardar(inscripcionDTO);
    }

    // REPORTES
    @Override
    public ReporteDTO generarReporte(DatosReporteDTO datosReporteDTO) throws NegocioException {
        validarReporte(datosReporteDTO);

        return reporteNegocio.generarReporte(datosReporteDTO);
    }

    // VALIDACIONES
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
