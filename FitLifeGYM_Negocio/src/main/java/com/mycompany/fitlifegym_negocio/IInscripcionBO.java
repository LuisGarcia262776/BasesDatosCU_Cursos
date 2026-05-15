/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.fitlifegym_negocio;

import com.mycompany.fitlifegym_dtos.InscripcionDTO;
import java.util.List;

/**
 *
 * @author PC GAMER MASTER RACE
 */
public interface IInscripcionBO {
    
    public List<InscripcionDTO> obtenerTodas() throws NegocioException;

    public InscripcionDTO obtenerPorId(String idInscripcion) throws NegocioException;

    public InscripcionDTO guardar(InscripcionDTO inscripcionDTO) throws NegocioException;

    public InscripcionDTO actualizar(InscripcionDTO inscripcionDTO) throws NegocioException;

    public Integer contarTotales() throws NegocioException;

    public Integer contarPorHorario(String idHorario) throws NegocioException;

    public List<InscripcionDTO> obtenerActivasPorHorario(String idHorario) throws NegocioException;

    public List<InscripcionDTO> obtenerPorCliente(String idCliente) throws NegocioException;
    
}
