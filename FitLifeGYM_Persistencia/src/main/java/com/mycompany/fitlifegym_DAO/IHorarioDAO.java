/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.fitlifegym_DAO;

import com.mycompany.fitlifegym_PersistenciaException.PersistenciaException;
import com.mycompany.fitlifegym_persistencia.entidades.Horario;
import java.util.List;

/**
 *
 * @author PC GAMER MASTER RACE
 */
public interface IHorarioDAO {
    public abstract List<Horario> obtenerPorCurso(String idCurso) throws PersistenciaException;

    public abstract List<Horario> obtenerTodos() throws PersistenciaException;

    public abstract Horario obtenerPorId(String idHorario) throws PersistenciaException;

    public abstract Horario guardar(Horario horario) throws PersistenciaException;

    public abstract Horario actualizar(Horario horario) throws PersistenciaException;

    public abstract boolean eliminar(String idHorario) throws PersistenciaException;
    
}
