/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.fitlifegym_negocio;

import com.mycompany.fitlifegym_dtos.DatosReporteDTO;
import com.mycompany.fitlifegym_dtos.ReporteDTO;

/**
 *
 * @author PC GAMER MASTER RACE
 */
public interface IReporteBO {
    
    public DatosReporteDTO obtenerDatosReporte(DatosReporteDTO datosReporteDTO) throws NegocioException;

    public ReporteDTO generarReporte(DatosReporteDTO datosReporteDTO) throws NegocioException;

    public boolean validarFiltros(DatosReporteDTO datosReporteDTO) throws NegocioException;
    
}
