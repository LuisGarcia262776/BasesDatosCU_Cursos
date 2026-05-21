/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.fitlifegym_DAO;

import com.mycompany.fitlifegym_PersistenciaException.PersistenciaException;
import com.mycompany.fitlifegym_persistencia.entidades.Curso;
import com.mycompany.fitlifegym_persistencia.entidades.DisponibilidadCurso;
import com.mycompany.fitlifegym_persistencia.entidades.Imagen;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

/**
 *
 * @author PC GAMER MASTER RACE
 */
public class CursoDAOTest {
//    private CursoDAO cursoDAO;
//
//    @BeforeEach()
//    public void init() {
//        this.cursoDAO = new CursoDAO();
//    }
//
//    @Test
//    public void testGuardarCursoFuncionaOk() {
//
//        Curso curso = new Curso(
//                "Yoga",
//                new Imagen("yoga.jpg"),
//                "Curso de yoga",
//                5,
//                DisponibilidadCurso.DISPONIBLE
//        );
//
//        assertDoesNotThrow(() -> {
//
//            Curso cursoGuardado = cursoDAO.guardar(curso);
//
//            assertNotNull(cursoGuardado.getIdCurso());
//        });
//    }
//
//    @Test
//    public void testObtenerCursoPorIdFuncionaOk() {
//
//        Curso curso = new Curso(
//                "Spinning",
//                new Imagen("spinning.jpg"),
//                "Curso intenso",
//                10,
//                DisponibilidadCurso.DISPONIBLE
//        );
//
//        assertDoesNotThrow(() -> {
//
//            Curso cursoGuardado = cursoDAO.guardar(curso);
//
//            Curso cursoEncontrado = cursoDAO.obtenerPorId(cursoGuardado.getIdCurso());
//
//            assertNotNull(cursoEncontrado);
//
//            assertEquals(cursoGuardado.getIdCurso(), cursoEncontrado.getIdCurso());
//        });
//    }
//
//    @Test
//    public void testObtenerTodosFuncionaOk() {
//
//        assertDoesNotThrow(() -> {
//
//            List<Curso> cursos = cursoDAO.obtenerTodos();
//
//            assertNotNull(cursos);
//        });
//    }
//
//    @Test
//    public void testActualizarCursoFuncionaOk() {
//
//        Curso curso = new Curso(
//                "Box",
//                new Imagen("box.jpg"),
//                "Curso de box",
//                8,
//                DisponibilidadCurso.DISPONIBLE
//        );
//
//        assertDoesNotThrow(() -> {
//
//            Curso cursoGuardado = cursoDAO.guardar(curso);
//
//            cursoGuardado.setNombre("Box Actualizado");
//
//            Curso cursoActualizado = cursoDAO.actualizar(cursoGuardado);
//
//            assertNotNull(cursoActualizado);
//
//            assertEquals("Box Actualizado", cursoActualizado.getNombre());
//        });
//    }
//
//    @Test
//    public void testEliminarCursoFuncionaOk() {
//
//        Curso curso = new Curso(
//                "Pilates",
//                new Imagen("pilates.jpg"),
//                "Curso de pilates",
//                6,
//                DisponibilidadCurso.DISPONIBLE
//        );
//
//        assertDoesNotThrow(() -> {
//
//            Curso cursoGuardado = cursoDAO.guardar(curso);
//
//            boolean eliminado = cursoDAO.eliminar(cursoGuardado.getIdCurso());
//
//            assertTrue(eliminado);
//        });
//    }
    

    
}
