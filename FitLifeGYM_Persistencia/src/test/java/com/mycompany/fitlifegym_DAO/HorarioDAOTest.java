/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.fitlifegym_DAO;

import com.mycompany.fitlifegym_persistencia.entidades.Curso;
import com.mycompany.fitlifegym_persistencia.entidades.DisponibilidadCurso;
import com.mycompany.fitlifegym_persistencia.entidades.Horario;
import com.mycompany.fitlifegym_persistencia.entidades.HorarioDiaSemana;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

/**
 *
 * @author PC GAMER MASTER RACE
 */
public class HorarioDAOTest {
    
//    private HorarioDAO horarioDAO;
//    private CursoDAO cursoDAO;
//
//    @BeforeEach()
//    public void init() {
//
//        this.horarioDAO = new HorarioDAO();
//        this.cursoDAO = new CursoDAO();
//    }
//
//    @Test
//    public void testGuardarHorarioFuncionaOk() {
//
//        Curso curso = new Curso(
//                "Yoga",
//                "yoga.jpg",
//                "Curso yoga",
//                10,
//                DisponibilidadCurso.DISPONIBLE
//        );
//
//        assertDoesNotThrow(() -> {
//
//            Curso cursoGuardado = cursoDAO.guardar(curso);
//
//            List<HorarioDiaSemana> dias = Arrays.asList(
//                    HorarioDiaSemana.LUNES,
//                    HorarioDiaSemana.MIERCOLES,
//                    HorarioDiaSemana.VIERNES
//            );
//
//            Horario horario = new Horario(
//                    cursoGuardado.getIdCurso(),
//                    dias,
//                    LocalTime.of(8, 0),
//                    LocalTime.of(10, 0),
//                    20,
//                    0
//            );
//
//            Horario horarioGuardado = horarioDAO.guardar(horario);
//
//            assertNotNull(horarioGuardado.getIdHorario());
//        });
//    }
//
//    @Test
//    public void testActualizarHorarioFuncionaOk() {
//
//        Curso curso = new Curso(
//                "Crossfit",
//                "crossfit.jpg",
//                "Curso",
//                10,
//                DisponibilidadCurso.DISPONIBLE
//        );
//
//        assertDoesNotThrow(() -> {
//
//            Curso cursoGuardado = cursoDAO.guardar(curso);
//
//            List<HorarioDiaSemana> dias = Arrays.asList(
//                    HorarioDiaSemana.MARTES,
//                    HorarioDiaSemana.JUEVES
//            );
//
//            Horario horario = new Horario(
//                    cursoGuardado.getIdCurso(),
//                    dias,
//                    LocalTime.of(7, 0),
//                    LocalTime.of(9, 0),
//                    20,
//                    0
//            );
//
//            Horario horarioGuardado = horarioDAO.guardar(horario);
//
//            horarioGuardado.setCupoMax(30);
//
//            Horario horarioActualizado = horarioDAO.actualizar(horarioGuardado);
//
//            assertEquals(30, horarioActualizado.getCupoMax());
//        });
//    }
//
//    @Test
//    public void testEliminarHorarioFuncionaOk() {
//
//        Curso curso = new Curso(
//                "Pilates",
//                "pilates.jpg",
//                "Curso",
//                10,
//                DisponibilidadCurso.DISPONIBLE
//        );
//
//        assertDoesNotThrow(() -> {
//
//            Curso cursoGuardado = cursoDAO.guardar(curso);
//
//            List<HorarioDiaSemana> dias = Arrays.asList(
//                    HorarioDiaSemana.LUNES,
//                    HorarioDiaSemana.MIERCOLES
//            );
//
//            Horario horario = new Horario(
//                    cursoGuardado.getIdCurso(),
//                    dias,
//                    LocalTime.of(6, 0),
//                    LocalTime.of(8, 0),
//                    20,
//                    0
//            );
//
//            Horario horarioGuardado = horarioDAO.guardar(horario);
//
//            boolean eliminado = horarioDAO.eliminar(horarioGuardado.getIdHorario());
//
//            assertTrue(eliminado);
//        });
//    }
//
//    @Test
//    public void testObtenerHorariosPorCursoFuncionaOk() {
//
//        assertDoesNotThrow(() -> {
//
//            List<Horario> horarios = horarioDAO.obtenerTodos();
//
//            assertNotNull(horarios);
//        });
//    }
    
}
