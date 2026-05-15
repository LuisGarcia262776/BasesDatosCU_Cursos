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
 *
 * @author PC GAMER MASTER RACE
 */
public interface ICU_Cursos {

    // CURSOS
    public List<CursoDTO> listarCursos() throws NegocioException;

    public CursoDTO agregarCurso(CursoDTO cursoDTO) throws NegocioException;

    public CursoDTO editarCurso(CursoDTO cursoDTO) throws NegocioException;

    public boolean eliminarCurso(String idCurso) throws NegocioException;

    // HORARIOS
    public List<HorarioDTO> listarHorariosPorCurso(String idCurso) throws NegocioException;

    public HorarioDTO agregarHorario(HorarioDTO horarioDTO) throws NegocioException;

    public HorarioDTO editarHorario(HorarioDTO horarioDTO) throws NegocioException;

    public boolean eliminarHorario(String idHorario) throws NegocioException;

    // INSCRIPCIONES
    public List<InscripcionDTO> listarInscripciones() throws NegocioException;

    public InscripcionDTO agregarInscripcion(InscripcionDTO inscripcionDTO) throws NegocioException;

    // REPORTES
    public ReporteDTO generarReporte(DatosReporteDTO datosReporteDTO) throws NegocioException;
    
}
