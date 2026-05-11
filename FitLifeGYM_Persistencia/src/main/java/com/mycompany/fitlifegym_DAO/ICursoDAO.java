/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.fitlifegym_DAO;

import com.mycompany.fitlifegym_PersistenciaException.PersistenciaException;
import com.mycompany.fitlifegym_persistencia.entidades.Curso;
import java.util.List;

/**
 *
 * @author PC GAMER MASTER RACE
 */
public interface ICursoDAO {
    public abstract List<Curso> obtenerTodos() throws PersistenciaException;

    public abstract Curso obtenerPorId(String idCurso) throws PersistenciaException;

    public abstract Curso guardar(Curso curso) throws PersistenciaException;

    public abstract Curso actualizar(Curso curso) throws PersistenciaException;

    public abstract boolean eliminar(String idCurso) throws PersistenciaException;
    
}
