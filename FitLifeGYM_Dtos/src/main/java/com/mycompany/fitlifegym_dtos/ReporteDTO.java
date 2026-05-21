/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.fitlifegym_dtos;

import java.util.Date;
import java.util.List;

/**
 * DTO que representa un reporte generado
 * dentro del sistema.
 * 
 * Contiene la fecha de generación y la información
 * de cursos y horarios incluidos en el reporte.
 * 
 * @author PC GAMER MASTER RACE
 */
public class ReporteDTO {
    /**
     * Fecha en la que se generó el reporte.
     */
    private Date fechaGeneracion;
    
    /**
     * Lista de cursos incluidos en el reporte.
     */
    private List<CursoDTO> cursos;
    
    /**
     * Lista de horarios incluidos en el reporte.
     */
    private List<HorarioDTO> horarios;

    /**
     * Constructor vacío.
     */
    public ReporteDTO() {
    }

    /**
     * Constructor que inicializa todos los datos
     * del reporte.
     * 
     * @param fechaGeneracion Fecha de generación del reporte.
     * @param cursos Lista de cursos incluidos.
     * @param horarios Lista de horarios incluidos.
     */
    public ReporteDTO(Date fechaGeneracion, List<CursoDTO> cursos, List<HorarioDTO> horarios) {
        this.fechaGeneracion = fechaGeneracion;
        this.cursos = cursos;
        this.horarios = horarios;
    }

    /**
     * Obtiene la fecha de generación del reporte.
     * 
     * @return Fecha de generación.
     */
    public Date getFechaGeneracion() {
        return fechaGeneracion;
    }

    /**
     * Obtiene la lista de cursos incluidos en el reporte.
     * 
     * @return Lista de cursos.
     */
    public List<CursoDTO> getCursos() {
        return cursos;
    }

    /**
     * Obtiene la lista de horarios incluidos en el reporte.
     * 
     * @return Lista de horarios.
     */
    public List<HorarioDTO> getHorarios() {
        return horarios;
    }
    
}
