/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.fitlifegym_dtos;

import java.util.Date;

/**
 *
 * @author PC GAMER MASTER RACE
 */
public class DatosReporteDTO {
    private Date fechaInicio;
    private Date fechaFin;
    private Integer cantidadMin;
    private HorarioDiaSemanaDTO dias;
    private String Idcurso;

    public DatosReporteDTO() {
    }

    public DatosReporteDTO(Date fechaInicio, Date fechaFin, Integer cantidadMin, HorarioDiaSemanaDTO dias, String Idcurso) {
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.cantidadMin = cantidadMin;
        this.dias = dias;
        this.Idcurso = Idcurso;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public Integer getCantidadMin() {
        return cantidadMin;
    }

    public HorarioDiaSemanaDTO getDias() {
        return dias;
    }

    public String getCurso() {
        return Idcurso;
    }
    
}
