/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.fitlifegym_negocio;

import com.mycompany.fitlifegym_dtos.CursoDTO;
import java.util.List;

/**
 *
 * @author PC GAMER MASTER RACE
 */
public interface ICursoBO {
    
    public abstract List<CursoDTO> obtenerTodos() throws NegocioException;

    public abstract CursoDTO obtenerPorId(String idCurso) throws NegocioException;

    public abstract CursoDTO guardar(CursoDTO cursoDTO) throws NegocioException;

    public abstract CursoDTO actualizar(CursoDTO cursoDTO) throws NegocioException;

    public abstract boolean eliminar(String idCurso) throws NegocioException;
    
}
