/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.fitlifegym_DAO;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mycompany.fitlifegym_Manejador_Conexiones.ManejadorConexiones;
import static com.mycompany.fitlifegym_Manejador_Conexiones.ManejadorConexiones.obtenerCodecs;
import com.mycompany.fitlifegym_PersistenciaException.PersistenciaException;
import com.mycompany.fitlifegym_persistencia.entidades.Administrador;
import java.util.logging.Logger;
import org.bson.Document;

/**
 * Clase DAO encargada de gestionar
 * las operaciones de persistencia
 * relacionadas con los administradores.
 * 
 * Permite consultar administradores
 * dentro de la base de datos MongoDB.
 * 
 * @author PC GAMER MASTER RACE
 */
public class AdministradorDAO implements IAdministradorDAO {
    private static final Logger LOGGER = Logger.getLogger(AdministradorDAO.class.getName());
    
    private static final String NOMBRE_COLECCION = "administradores";

    /**
     * Obtiene la base de datos configurada
     * para el sistema.
     * 
     * @param cliente Cliente de MongoDB.
     * @return Base de datos utilizada por el sistema.
     */
    private MongoDatabase obtenerBaseDatos(MongoClient cliente) {
        MongoDatabase empresaBD = cliente.getDatabase(ManejadorConexiones.BASE_DATOS).withCodecRegistry(obtenerCodecs());
        return empresaBD;
    }

    /**
     * Obtiene la colección de administradores
     * de la base de datos.
     * 
     * @param baseDatos Base de datos utilizada.
     * @return Colección de administradores.
     */
    private MongoCollection<Administrador> obtenerColeccion(MongoDatabase baseDatos) {
        MongoCollection<Administrador> coleccion = baseDatos.getCollection(NOMBRE_COLECCION, Administrador.class);
        return coleccion;
    }

    /**
     * Busca un administrador mediante
     * su PIN y contraseña.
     * 
     * @param pin PIN del administrador.
     * @param contrasenia Contraseña del administrador.
     * @return Administrador encontrado o null
     * si no existe.
     * @throws PersistenciaException Se lanza cuando ocurre
     * un error durante la consulta.
     */
    @Override
    public Administrador buscarPorPinYContrasenia(String pin, String contrasenia) throws PersistenciaException {
        try(MongoClient cliente = ManejadorConexiones.crearConexion()){
            MongoDatabase empresaDB = this.obtenerBaseDatos(cliente);
            
            MongoCollection<Administrador> coleccion = this.obtenerColeccion(empresaDB);
            
            Document filtro = new Document("pin",pin).append("contrasenia", contrasenia);
            
            Administrador admin = coleccion.find(filtro).first();
            return admin;
        }
    }
        
    
}
