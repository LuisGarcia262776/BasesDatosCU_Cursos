/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.fitlifegym_dtos;

import java.util.Date;
import java.util.List;

/**
 *
 * @author PC GAMER MASTER RACE
 */
public class ReporteDTO {
    
    private Date fechaGeneracion;
    private List<CursoDTO> cursos;
    private List<HorarioDTO> horarios;

    public ReporteDTO() {
    }

    public ReporteDTO(Date fechaGeneracion, List<CursoDTO> cursos, List<HorarioDTO> horarios) {
        this.fechaGeneracion = fechaGeneracion;
        this.cursos = cursos;
        this.horarios = horarios;
    }

    public Date getFechaGeneracion() {
        return fechaGeneracion;
    }

    public List<CursoDTO> getCursos() {
        return cursos;
    }

    public List<HorarioDTO> getHorarios() {
        return horarios;
    }
    
    
    
}
