/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.fitlifegym_DAO;

import com.mycompany.fitlifegym_persistencia.entidades.Cliente;
import com.mycompany.fitlifegym_persistencia.entidades.TipoMembresia;
import java.time.LocalDate;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

/**
 *
 * @author PC GAMER MASTER RACE
 */
public class ClienteDAOTest {
    
    private ClienteDAO clienteDAO;

    @BeforeEach()
    public void init() {
        this.clienteDAO = new ClienteDAO();
    }

    @Test
    public void testRegistrarClienteFuncionaOk() {

        Cliente cliente = new Cliente(
                "Luis",
                "Garcia",
                "luis@mail.com",
                "6441234567",
                "1234",
                LocalDate.of(2004, 5, 20),
                "9999"
        );

        assertDoesNotThrow(() -> {

            Cliente clienteGuardado = clienteDAO.registrarCliente(cliente);

            assertNotNull(clienteGuardado.getIdCliente());
        });
    }

    @Test
    public void testConsultarClientePorIdFuncionaOk() {

        Cliente cliente = new Cliente(
                "Ana",
                "Lopez",
                "ana@mail.com",
                "6449876543",
                "1234",
                LocalDate.of(2000, 1, 10),
                "1111"
        );

        assertDoesNotThrow(() -> {

            Cliente clienteGuardado = clienteDAO.registrarCliente(cliente);

            Cliente clienteEncontrado = clienteDAO.consultarClientePorId(clienteGuardado.getIdCliente());

            assertNotNull(clienteEncontrado);

            assertEquals(clienteGuardado.getIdCliente(), clienteEncontrado.getIdCliente());
        });
    }

    @Test
    public void testConsultarClientesFuncionaOk() {

        assertDoesNotThrow(() -> {

            List<Cliente> clientes = clienteDAO.consultarClientes();

            assertNotNull(clientes);
        });
    }

    @Test
    public void testBuscarPorPinFuncionaOk() {

        Cliente cliente = new Cliente(
                "Carlos",
                "Perez",
                "carlos@mail.com",
                "6441112233",
                "1234",
                LocalDate.of(1999, 8, 15),
                "5555"
        );

        assertDoesNotThrow(() -> {

            clienteDAO.registrarCliente(cliente);

            Cliente clienteEncontrado = clienteDAO.buscarPorPin("5555");

            assertNotNull(clienteEncontrado);

            assertEquals("5555",clienteEncontrado.getPin());
        });
    }

    @Test
    public void testActualizarMembresiaFuncionaOk() {

        Cliente cliente = new Cliente(
                "Mario",
                "Torres",
                "mario@mail.com",
                "6442223344",
                "1234",
                LocalDate.of(1998, 3, 5),
                "7777"
        );

        assertDoesNotThrow(() -> {

            Cliente clienteGuardado = clienteDAO.registrarCliente(cliente);

            Cliente clienteActualizado = clienteDAO.actualizarMembresia(clienteGuardado.getIdCliente(), TipoMembresia.ORO);

            assertNotNull(clienteActualizado);

            assertEquals(TipoMembresia.ORO, clienteActualizado.getMembresiaComprada().getMembresia().getTipoMembresia());
        });
    }

    
    
}
