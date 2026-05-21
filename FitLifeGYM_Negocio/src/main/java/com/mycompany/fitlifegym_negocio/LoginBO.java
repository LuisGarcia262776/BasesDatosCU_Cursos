/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.fitlifegym_negocio;

import Adapter.DtosAEntidadesAdapter;
import com.mycompany.fitlifegym_PersistenciaException.PersistenciaException;
import com.mycompany.fitlifegym_dtos.ClienteLogueadoDTO;
import com.mycompany.fitlifegym_dtos.LoginDTO;
import com.mycompany.fitlifegym_persistencia.entidades.Cliente;
import com.mycompany.fitlifegym_persistencia_Fachada.IPersistenciaFachada;
import com.mycompany.fitlifegym_persistencia_Fachada.PersistenciaFachada;
import java.util.List;


/**
 * Clase de negocio encargada de gestionar
 * el inicio de sesión de clientes dentro del sistema.
 * 
 * Permite validar las credenciales de acceso
 * mediante la consulta de clientes registrados
 * en la capa de persistencia.
 * 
 * @author PC GAMER MASTER RACE
 */
public class LoginBO implements ILoginBO {
    /**
     * Fachada utilizada para acceder a la capa de persistencia.
     */
    private final IPersistenciaFachada fachada;

    /**
     * Constructor que inicializa la fachada
     * de persistencia.
     */
    public LoginBO() {
        this.fachada = new PersistenciaFachada();
    }

    /**
     * Valida las credenciales de un cliente
     * e inicia sesión dentro del sistema.
     * 
     * @param login DTO con las credenciales del cliente.
     * @return DTO con la información del cliente autenticado.
     * @throws NegocioException Se lanza cuando las credenciales
     * son incorrectas o ocurre un error en persistencia.
     */
    @Override
    public ClienteLogueadoDTO iniciarSesion(LoginDTO login) throws NegocioException {
        try {
            List<Cliente> clientes = fachada.obtenerClienteDAO().consultarClientes();

            for (Cliente cliente : clientes) {
                
                boolean pinCorrecto = cliente.getPin().equals(login.getPin());

                boolean contraseniaCorrecta = cliente.getContrasenia().equals(login.getContrasenia());

                if (pinCorrecto && contraseniaCorrecta) {
                    return DtosAEntidadesAdapter.adaptarClienteLogueado(cliente);
                }
            }
            
            throw new NegocioException("PIN o contraseña incorrectos.");
            
        } catch (PersistenciaException ex) {
            throw new NegocioException("Error al iniciar sesión.", ex );
        }
    }
        
}
        

    

