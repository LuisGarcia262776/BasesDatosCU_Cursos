/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.fitlifegym_negocio;

import com.mycompany.fitlifegym_PersistenciaException.PersistenciaException;
import com.mycompany.fitlifegym_dtos.AdministradorLogueadoDTO;
import com.mycompany.fitlifegym_persistencia.entidades.Administrador;
import com.mycompany.fitlifegym_persistencia_Fachada.IPersistenciaFachada;
import com.mycompany.fitlifegym_persistencia_Fachada.PersistenciaFachada;

/**
 * Clase de negocio encargada de gestionar
 * las operaciones relacionadas con los administradores.
 * 
 * Permite validar el inicio de sesión de administradores
 * mediante el acceso a la capa de persistencia.
 * 
 * @author PC GAMER MASTER RACE
 */
public class AdministradorBO implements IAdministradorBO{
    /**
     * Fachada utilizada para acceder a la capa de persistencia.
     */
    private final IPersistenciaFachada fachada;

    /**
     * Constructor que inicializa la fachada
     * de persistencia.
     */
    public AdministradorBO() {
        this.fachada = new PersistenciaFachada();
    }

    /**
     * Valida las credenciales de un administrador
     * e inicia sesión en el sistema.
     * 
     * @param pin PIN del administrador.
     * @param contrasenia Contraseña del administrador.
     * @return DTO con la información del administrador autenticado.
     * @throws NegocioException Se lanza cuando las credenciales
     * son incorrectas o ocurre un error en persistencia.
     */
    @Override
    public AdministradorLogueadoDTO iniciarSesion(String pin, String contrasenia) throws NegocioException {
        try{
            Administrador admin = fachada.obtenerAdministradorDAO().buscarPorPinYContrasenia(pin, contrasenia);
            
            if(admin == null){
                throw new NegocioException("El Administrador no Puede ser Nulo");
            }
            
            return new AdministradorLogueadoDTO(admin.getPin(), admin.getPin());
            
        }catch(PersistenciaException ex){
            throw new NegocioException("Pin o contraseña incorrectos", ex);
        }
    }
    
}
