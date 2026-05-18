/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.fitlifegym_DAO;

import com.mycompany.fitlifegym_PersistenciaException.PersistenciaException;
import com.mycompany.fitlifegym_persistencia.entidades.Curso;
import com.mycompany.fitlifegym_persistencia.entidades.DisponibilidadCurso;
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
//        Curso curso = new Curso(
//                "Yoga",
//                "yoga.jpg",
//                "Curso de yoga para principiantes",
//                10,
//                DisponibilidadCurso.DISPONIBLE
//        );
//
//        assertDoesNotThrow(() -> {
//            Curso cursoGuardado = cursoDAO.guardar(curso);
//            assertNotNull(cursoGuardado.getIdCurso());
//        });
//    }
//
//    @Test
//    public void testActualizarCursoFuncionaOk() {
//        Curso curso = new Curso(
//                "Spinning",
//                "spinning.jpg",
//                "Curso de spinning",
//                15,
//                DisponibilidadCurso.DISPONIBLE
//        );
//
//        assertDoesNotThrow(() -> {
//            Curso cursoGuardado = cursoDAO.guardar(curso);
//            cursoGuardado.setNombre("Spinning Avanzado");
//            cursoGuardado.setDescripcion("Curso actualizado");
//            Curso cursoActualizado = cursoDAO.actualizar(cursoGuardado);
//            
//            assertNotNull(cursoActualizado);
//            assertEquals(cursoGuardado.getNombre(),cursoActualizado.getNombre());
//
//            assertEquals(cursoGuardado.getDescripcion(), cursoActualizado.getDescripcion());
//        });
//    }
//
//    @Test
//    public void testEliminarCursoFuncionaOk() {
//        Curso curso = new Curso(
//                "Crossfit",
//                "crossfit.jpg",
//                "Curso de crossfit",
//                20,
//                DisponibilidadCurso.DISPONIBLE
//        );
//
//        assertDoesNotThrow(() -> {
//            Curso cursoGuardado = cursoDAO.guardar(curso);
//
//            boolean eliminado = cursoDAO.eliminar(cursoGuardado.getIdCurso());
//
//            assertTrue(eliminado);
//            Curso cursoEliminado = cursoDAO.obtenerPorId(cursoGuardado.getIdCurso());
//            assertNull(cursoEliminado);
//        });
//    }
//
//    @Test
//    public void testBuscarCursoPorIdFuncionaOk() {
//
//        Curso curso = new Curso(
//                "Pilates",
//                "pilates.jpg",
//                "Curso de pilates",
//                12,
//                DisponibilidadCurso.DISPONIBLE
//        );
//
//        assertDoesNotThrow(() -> {
//            Curso cursoGuardado = cursoDAO.guardar(curso);
//            Curso cursoEncontrado = cursoDAO.obtenerPorId(cursoGuardado.getIdCurso());
//
//            assertNotNull(cursoEncontrado.getIdCurso());
//            assertEquals(cursoGuardado.getIdCurso(),cursoEncontrado.getIdCurso());
//        });
//    }
//
//    @Test
//    public void testBuscarTodosLosCursosFuncionaOk() {
//        assertDoesNotThrow(() -> {
//            List<Curso> cursosEncontrados = cursoDAO.obtenerTodos();
//            assertNotNull(cursosEncontrados);
//        });
//    }
    
}
