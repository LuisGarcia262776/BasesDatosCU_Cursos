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
import java.util.LinkedList;
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
//
//    @BeforeEach()
//    public void init() {
//        this.horarioDAO = new HorarioDAO();
//    }
//
//    @Test
//    public void testGuardarHorarioFuncionaOk() {
//
//        List<HorarioDiaSemana> dias = new LinkedList<>();
//        dias.add(HorarioDiaSemana.LUNES);
//        dias.add(HorarioDiaSemana.MIERCOLES);
//
//        Horario horario = new Horario(
//                "682a74a3c1f1f33f54bcb111",
//                dias,
//                LocalTime.of(8, 0),
//                LocalTime.of(10, 0),
//                20,
//                0
//        );
//
//        assertDoesNotThrow(() -> {
//
//            Horario horarioGuardado = horarioDAO.guardar(horario);
//
//            assertNotNull(horarioGuardado.getIdHorario());
//        });
//    }
//
//    @Test
//    public void testObtenerHorarioPorIdFuncionaOk() {
//
//        List<HorarioDiaSemana> dias = new LinkedList<>();
//        dias.add(HorarioDiaSemana.MARTES);
//
//        Horario horario = new Horario(
//                "682a74a3c1f1f33f54bcb111",
//                dias,
//                LocalTime.of(7, 0),
//                LocalTime.of(9, 0),
//                15,
//                0
//        );
//
//        assertDoesNotThrow(() -> {
//
//            Horario horarioGuardado = horarioDAO.guardar(horario);
//
//            Horario horarioEncontrado = horarioDAO.obtenerPorId(horarioGuardado.getIdHorario());
//
//            assertNotNull(horarioEncontrado);
//
//            assertEquals(horarioGuardado.getIdHorario(), horarioEncontrado.getIdHorario());
//        });
//    }
//
//    @Test
//    public void testObtenerTodosFuncionaOk() {
//
//        assertDoesNotThrow(() -> {
//
//            List<Horario> horarios = horarioDAO.obtenerTodos();
//
//            assertNotNull(horarios);
//        });
//    }
//
//    @Test
//    public void testActualizarHorarioFuncionaOk() {
//
//        List<HorarioDiaSemana> dias = new LinkedList<>();
//        dias.add(HorarioDiaSemana.JUEVES);
//
//        Horario horario = new Horario(
//                "682a74a3c1f1f33f54bcb111",
//                dias,
//                LocalTime.of(6, 0),
//                LocalTime.of(8, 0),
//                10,
//                0
//        );
//
//        assertDoesNotThrow(() -> {
//
//            Horario horarioGuardado = horarioDAO.guardar(horario);
//
//            horarioGuardado.setCupoMax(30);
//
//            Horario horarioActualizado = horarioDAO.actualizar(horarioGuardado);
//
//            assertNotNull(horarioActualizado);
//
//            assertEquals(30, horarioActualizado.getCupoMax());
//        });
//    }
//
//    @Test
//    public void testEliminarHorarioFuncionaOk() {
//
//        List<HorarioDiaSemana> dias = new LinkedList<>();
//        dias.add(HorarioDiaSemana.VIERNES);
//
//        Horario horario = new Horario(
//                "682a74a3c1f1f33f54bcb111",
//                dias,
//                LocalTime.of(5, 0),
//                LocalTime.of(7, 0),
//                12,
//                0
//        );
//
//        assertDoesNotThrow(() -> {
//
//            Horario horarioGuardado = horarioDAO.guardar(horario);
//
//            boolean eliminado = horarioDAO.eliminar(horarioGuardado.getIdHorario());
//
//            assertTrue(eliminado);
//        });
//    }
    
    
}
