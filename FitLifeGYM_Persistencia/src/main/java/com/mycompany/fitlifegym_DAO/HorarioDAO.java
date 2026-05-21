/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.fitlifegym_DAO;

import com.mongodb.MongoException;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.InsertOneResult;
import com.mongodb.client.result.UpdateResult;
import com.mycompany.fitlifegym_Manejador_Conexiones.ManejadorConexiones;
import static com.mycompany.fitlifegym_Manejador_Conexiones.ManejadorConexiones.obtenerCodecs;
import com.mycompany.fitlifegym_PersistenciaException.PersistenciaException;
import com.mycompany.fitlifegym_persistencia.entidades.Horario;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 *
 * Clase DAO encargada de gestionar
 * las operaciones de persistencia
 * relacionadas con los horarios.
 * 
 * Permite registrar, consultar,
 * actualizar y eliminar horarios
 * dentro de la base de datos MongoDB.
 * 
 * @author PC GAMER MASTER RACE
 */

public class HorarioDAO implements IHorarioDAO {
    
    /**
     * Logger utilizado para registrar
     * eventos y errores del DAO.
     */
    private static final Logger LOGGER = Logger.getLogger(HorarioDAO.class.getName());
    
    /**
     * Nombre de la colección
     * de horarios en MongoDB.
     */
    private static final String NOMBRE_COLECCION = "horarios";

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
     * Obtiene la colección de horarios.
     * 
     * @param baseDatos Base de datos utilizada.
     * @return Colección de horarios.
     */
    private MongoCollection<Horario> obtenerColeccion(MongoDatabase baseDatos) {
        MongoCollection<Horario> coleccion = baseDatos.getCollection(NOMBRE_COLECCION, Horario.class);
        return coleccion;
    }

    /**
     * Obtiene todos los horarios
     * asociados a un curso.
     * 
     * @param idCurso ID del curso.
     * @return Lista de horarios del curso.
     * @throws PersistenciaException Se lanza cuando ocurre
     * un error durante la consulta.
     */
    @Override
    public List<Horario> obtenerPorCurso(String idCurso) throws PersistenciaException {
        try (MongoClient cliente = ManejadorConexiones.crearConexion()) {

            MongoDatabase empresaBD = this.obtenerBaseDatos(cliente);

            MongoCollection<Horario> coleccion = this.obtenerColeccion(empresaBD);

            Document filtro = new Document("idCurso", new ObjectId(idCurso));

            List<Horario> horarios = new LinkedList<>();

            coleccion.find(filtro).into(horarios);

            return horarios;
            
        }catch (MongoException ex) {
            LOGGER.severe(ex.getMessage());
            throw new PersistenciaException("No se pudieron consultar los horarios del curso: " + idCurso);
        }
    }

    /**
     * Obtiene todos los horarios registrados.
     * 
     * @return Lista de horarios.
     * @throws PersistenciaException Se lanza cuando ocurre
     * un error durante la consulta.
     */
    @Override
    public List<Horario> obtenerTodos() throws PersistenciaException {
        try (MongoClient cliente = ManejadorConexiones.crearConexion()) {

            MongoDatabase empresaBD = this.obtenerBaseDatos(cliente);

            MongoCollection<Horario> coleccion = this.obtenerColeccion(empresaBD);

            List<Horario> horarios = new LinkedList<>();

            coleccion.find().into(horarios);

            return horarios;
            
        }catch (MongoException ex) {
            LOGGER.severe(ex.getMessage());
            throw new PersistenciaException("No se pudieron consultar los horarios");
        }
    }

    /**
     * Obtiene un horario mediante su ID.
     * 
     * @param idHorario ID del horario.
     * @return Horario encontrado o null
     * si no existe.
     * @throws PersistenciaException Se lanza cuando ocurre
     * un error durante la consulta.
     */
    @Override
    public Horario obtenerPorId(String idHorario) throws PersistenciaException {
        try (MongoClient cliente = ManejadorConexiones.crearConexion()) {

            MongoDatabase empresaBD = this.obtenerBaseDatos(cliente);

            MongoCollection<Horario> coleccion = this.obtenerColeccion(empresaBD);

            Document filtro = new Document("_id", new ObjectId(idHorario));

            Horario horario = coleccion.find(filtro).first();

            return horario;
            
        }catch (MongoException ex) {
            LOGGER.severe(ex.getMessage());
            throw new PersistenciaException("No se pudo consultar el horario: " + idHorario);
        }
    }

    /**
     * Guarda un nuevo horario
     * dentro de la base de datos.
     * 
     * @param horario Horario a guardar.
     * @return Horario guardado.
     * @throws PersistenciaException Se lanza cuando ocurre
     * un error durante el guardado.
     */
    @Override
    public Horario guardar(Horario horario) throws PersistenciaException {
        try (MongoClient cliente = ManejadorConexiones.crearConexion()) {

            MongoDatabase empresaBD = this.obtenerBaseDatos(cliente);

            MongoCollection<Horario> coleccion = this.obtenerColeccion(empresaBD);

            InsertOneResult resultado = coleccion.insertOne(horario);
            
            if (!resultado.wasAcknowledged()) {
                throw new PersistenciaException("No se pudo guardar el horario");
            }

            return horario;
            
        }catch (MongoException ex) {
            LOGGER.severe(ex.getMessage());
            throw new PersistenciaException("No se pudo guardar el horario");
        }
    }

    /**
     * Actualiza la información
     * de un horario existente.
     * 
     * @param horario Horario con información actualizada.
     * @return Horario actualizado.
     * @throws PersistenciaException Se lanza cuando ocurre
     * un error durante la actualización.
     */
    @Override
    public Horario actualizar(Horario horario) throws PersistenciaException {
        try (MongoClient cliente = ManejadorConexiones.crearConexion()) {

            MongoDatabase empresaBD = this.obtenerBaseDatos(cliente);

            MongoCollection<Horario> coleccion = this.obtenerColeccion(empresaBD);

            Document filtro = new Document("_id", new ObjectId(horario.getIdHorario()));

            UpdateResult resultado = coleccion.replaceOne(filtro, horario);

            if (resultado.getModifiedCount() == 0) {
                throw new PersistenciaException("No se pudo actualizar el horario");
            }

            return horario;
            
        }catch (MongoException ex) {
            LOGGER.severe(ex.getMessage());
            throw new PersistenciaException("No se pudo actualizar el horario");
        }
    }

    /**
     * Elimina un horario mediante su ID.
     * 
     * @param idHorario ID del horario.
     * @return true si el horario fue eliminado correctamente.
     * @throws PersistenciaException Se lanza cuando ocurre
     * un error durante la eliminación.
     */
    @Override
    public boolean eliminar(String idHorario) throws PersistenciaException {
        try (MongoClient cliente = ManejadorConexiones.crearConexion()) {

            MongoDatabase empresaBD = this.obtenerBaseDatos(cliente);

            MongoCollection<Horario> coleccion = this.obtenerColeccion(empresaBD);

            Document filtro = new Document("_id", new ObjectId(idHorario));

            DeleteResult resultado = coleccion.deleteOne(filtro);

            return resultado.getDeletedCount() > 0;
            
        }catch (MongoException ex) {
            LOGGER.severe(ex.getMessage());
            throw new PersistenciaException("No se pudo eliminar el horario");
        }
    }
    
    
}
