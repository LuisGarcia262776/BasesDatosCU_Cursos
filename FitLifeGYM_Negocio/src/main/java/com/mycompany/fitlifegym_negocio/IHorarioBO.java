/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.fitlifegym_negocio;

import com.mycompany.fitlifegym_dtos.HorarioDTO;
import java.util.List;

/**
 *
 * @author PC GAMER MASTER RACE
 */
public interface IHorarioBO {
    
    public List<HorarioDTO> obtenerPorCurso(String idCurso) throws NegocioException;

    public List<HorarioDTO> obtenerTodos() throws NegocioException;

    public HorarioDTO obtenerPorId(String idHorario) throws NegocioException;

    public HorarioDTO guardar(HorarioDTO horarioDTO) throws NegocioException;

    public HorarioDTO actualizar(HorarioDTO horarioDTO) throws NegocioException;

    public boolean eliminar(String idHorario) throws NegocioException;
    
}
