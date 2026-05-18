/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.fitlifegym_DAO;

import com.mycompany.fitlifegym_persistencia.entidades.Cliente;
import com.mycompany.fitlifegym_persistencia.entidades.Curso;
import com.mycompany.fitlifegym_persistencia.entidades.DisponibilidadCurso;
import com.mycompany.fitlifegym_persistencia.entidades.EstadoInscripcion;
import com.mycompany.fitlifegym_persistencia.entidades.Horario;
import com.mycompany.fitlifegym_persistencia.entidades.HorarioDiaSemana;
import com.mycompany.fitlifegym_persistencia.entidades.Inscripcion;
import java.time.LocalDate;
import java.time.LocalDateTime;
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
public class InscripcionDAOTest {
    
//    private InscripcionDAO inscripcionDAO;
//    private ClienteDAO clienteDAO;
//    private HorarioDAO horarioDAO;
//    private CursoDAO cursoDAO;
//
//    @BeforeEach()
//    public void init() {
//
//        this.inscripcionDAO = new InscripcionDAO();
//        this.clienteDAO = new ClienteDAO();
//        this.horarioDAO = new HorarioDAO();
//        this.cursoDAO = new CursoDAO();
//    }
//
//    @Test
//    public void testGuardarInscripcionFuncionaOk() {
//
//        assertDoesNotThrow(() -> {
//
//            Cliente cliente = new Cliente(
//                    "Luis",
//                    "Garcia",
//                    "luis@mail.com",
//                    "6441234567",
//                    "1234",
//                    LocalDate.of(2004, 5, 20),
//                    "9999"
//            );
//
//            Cliente clienteGuardado = clienteDAO.registrarCliente(cliente);
//
//            Curso curso = new Curso(
//                    "Yoga",
//                    "yoga.jpg",
//                    "Curso",
//                    10,
//                    DisponibilidadCurso.DISPONIBLE
//            );
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
//            Inscripcion inscripcion = new Inscripcion(
//                            clienteGuardado.getIdCliente(),
//                            horarioGuardado.getIdHorario(),
//                            LocalDateTime.now(),
//                            EstadoInscripcion.ACTIVA
//                    );
//
//            Inscripcion guardada = inscripcionDAO.guardar(inscripcion);
//
//            assertNotNull(guardada.getIdInscripcion());
//        });
//    }
//
//    @Test
//    public void testObtenerTodasLasInscripcionesFuncionaOk() {
//
//        assertDoesNotThrow(() -> {
//
//            List<Inscripcion> inscripciones = inscripcionDAO.obtenerTodas();
//
//            assertNotNull(inscripciones);
//        });
//    }
//
//    @Test
//    public void testContarInscripcionesFuncionaOk() {
//
//        assertDoesNotThrow(() -> {
//
//            Integer total = inscripcionDAO.contarTotales();
//
//            assertNotNull(total);
//
//            assertTrue(total >= 0);
//        });
//    }
    
}
