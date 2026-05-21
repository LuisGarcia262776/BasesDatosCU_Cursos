/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.fitlifegym_DAO;

import com.mongodb.MongoException;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.InsertOneResult;
import com.mongodb.client.result.UpdateResult;
import com.mycompany.fitlifegym_Manejador_Conexiones.ManejadorConexiones;
import static com.mycompany.fitlifegym_Manejador_Conexiones.ManejadorConexiones.obtenerCodecs;
import com.mycompany.fitlifegym_PersistenciaException.PersistenciaException;
import com.mycompany.fitlifegym_persistencia.entidades.EstadoInscripcion;
import com.mycompany.fitlifegym_persistencia.entidades.Inscripcion;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 *
 * Clase DAO encargada de gestionar
 * las operaciones de persistencia
 * relacionadas con las inscripciones.
 * 
 * Permite registrar, consultar,
 * actualizar y contar inscripciones
 * dentro de la base de datos MongoDB.
 * 
 * @author PC GAMER MASTER RACE
 */
public class InscripcionDAO implements IInscripcionDAO {
    /**
     * Logger utilizado para registrar
     * eventos y errores del DAO.
     */
    private static final Logger LOGGER = Logger.getLogger(InscripcionDAO.class.getName());
    
    /**
     * Nombre de la colección
     * de inscripciones en MongoDB.
     */
    private static final String NOMBRE_COLECCION = "inscripciones";

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
     * Obtiene la colección de inscripciones.
     * 
     * @param baseDatos Base de datos utilizada.
     * @return Colección de inscripciones.
     */
    private MongoCollection<Inscripcion> obtenerColeccion(MongoDatabase baseDatos) {
        MongoCollection<Inscripcion> coleccion = baseDatos.getCollection(NOMBRE_COLECCION, Inscripcion.class);
        return coleccion;
    }
    
    /**
     * Obtiene todas las inscripciones registradas.
     * 
     * @return Lista de inscripciones.
     * @throws PersistenciaException Se lanza cuando ocurre
     * un error durante la consulta.
     */
    @Override
    public List<Inscripcion> obtenerTodas() throws PersistenciaException {
        try (MongoClient cliente = ManejadorConexiones.crearConexion()) {

            MongoDatabase empresaBD = this.obtenerBaseDatos(cliente);

            MongoCollection<Inscripcion> coleccion = this.obtenerColeccion(empresaBD);

            List<Inscripcion> inscripciones = new LinkedList<>();

            coleccion.find().into(inscripciones);

            return inscripciones;
            
        }catch (MongoException ex) {
            LOGGER.severe(ex.getMessage());
            throw new PersistenciaException("No se pudieron consultar las inscripciones");
        }
    }

    /**
     * Obtiene una inscripción mediante su ID.
     * 
     * @param idInscripcion ID de la inscripción.
     * @return Inscripción encontrada o null
     * si no existe.
     * @throws PersistenciaException Se lanza cuando ocurre
     * un error durante la consulta.
     */
    @Override
    public Inscripcion obtenerPorId(String idInscripcion) throws PersistenciaException {
        try (MongoClient cliente = ManejadorConexiones.crearConexion()) {

            MongoDatabase empresaBD = this.obtenerBaseDatos(cliente);

            MongoCollection<Inscripcion> coleccion = this.obtenerColeccion(empresaBD);

            Document filtro = new Document("_id", new ObjectId(idInscripcion));

            Inscripcion inscripcion = coleccion.find(filtro).first();

            return inscripcion;
            
        }catch (MongoException ex) {
            LOGGER.severe(ex.getMessage());
            throw new PersistenciaException("No se pudo consultar la inscripción: " + idInscripcion);
        }
    }

    /**
     * Guarda una nueva inscripción
     * dentro de la base de datos.
     * 
     * @param inscripcion Inscripción a guardar.
     * @return Inscripción guardada.
     * @throws PersistenciaException Se lanza cuando ocurre
     * un error durante el guardado.
     */
    @Override
    public Inscripcion guardar(Inscripcion inscripcion) throws PersistenciaException {
        try (MongoClient cliente = ManejadorConexiones.crearConexion()) {

            MongoDatabase empresaBD = this.obtenerBaseDatos(cliente);

            MongoCollection<Inscripcion> coleccion = this.obtenerColeccion(empresaBD);

            InsertOneResult resultado = coleccion.insertOne(inscripcion);
            
            if (!resultado.wasAcknowledged()) {
                throw new PersistenciaException("No se pudo guardar la inscripción");
            }

            return inscripcion;
            
        }catch (MongoException ex) {
            LOGGER.severe(ex.getMessage());
            throw new PersistenciaException("No se pudo guardar la inscripción");
        }
    }

    /**
     * Actualiza la información
     * de una inscripción existente.
     * 
     * @param inscripcion Inscripción con información actualizada.
     * @return Inscripción actualizada.
     * @throws PersistenciaException Se lanza cuando ocurre
     * un error durante la actualización.
     */
    @Override
    public Inscripcion actualizar(Inscripcion inscripcion) throws PersistenciaException {
        try (MongoClient cliente = ManejadorConexiones.crearConexion()) {

            MongoDatabase empresaBD = this.obtenerBaseDatos(cliente);

            MongoCollection<Inscripcion> coleccion = this.obtenerColeccion(empresaBD);

            Document filtro = new Document("_id", new ObjectId(inscripcion.getIdInscripcion()));

            UpdateResult resultado = coleccion.replaceOne(filtro, inscripcion);

            if (resultado.getModifiedCount() == 0) {
                throw new PersistenciaException("No se pudo actualizar la inscripción");
            }

            return inscripcion;
            
        }catch (MongoException ex) {
            LOGGER.severe(ex.getMessage());
            throw new PersistenciaException("No se pudo actualizar la inscripción");
        }
    }

    /**
     * Cuenta el total de inscripciones registradas.
     * 
     * @return Total de inscripciones.
     * @throws PersistenciaException Se lanza cuando ocurre
     * un error durante el conteo.
     */
    @Override
    public Integer contarTotales() throws PersistenciaException {
        try (MongoClient cliente = ManejadorConexiones.crearConexion()) {

            MongoDatabase empresaBD = this.obtenerBaseDatos(cliente);

            MongoCollection<Inscripcion> coleccion = this.obtenerColeccion(empresaBD);

            return (int) coleccion.countDocuments();
            
        }catch (MongoException ex) {
            LOGGER.severe(ex.getMessage());
            throw new PersistenciaException("No se pudieron contar las inscripciones");
        }
    }

    /**
     * Cuenta las inscripciones activas
     * asociadas a un horario.
     * 
     * @param idHorario ID del horario.
     * @return Total de inscripciones activas.
     * @throws PersistenciaException Se lanza cuando ocurre
     * un error durante el conteo.
     */
    @Override
    public Integer contarPorHorario(String idHorario) throws PersistenciaException {
        try (MongoClient cliente = ManejadorConexiones.crearConexion()) {

            MongoDatabase empresaBD = this.obtenerBaseDatos(cliente);

            MongoCollection<Inscripcion> coleccion = this.obtenerColeccion(empresaBD);

            Document filtro = new Document().append("idHorario", new ObjectId(idHorario)).append("estado", EstadoInscripcion.ACTIVO.name());

            return (int) coleccion.countDocuments(filtro);
            
        }catch (MongoException ex) {
            LOGGER.severe(ex.getMessage());
            throw new PersistenciaException("No se pudieron contar las inscripciones por horario");
        }
    }

    /**
     * Obtiene las inscripciones activas
     * de un horario específico.
     * 
     * @param idHorario ID del horario.
     * @return Lista de inscripciones activas.
     * @throws PersistenciaException Se lanza cuando ocurre
     * un error durante la consulta.
     */
    @Override
    public List<Inscripcion> obtenerActivasPorHorario(String idHorario) throws PersistenciaException {
        try (MongoClient cliente = ManejadorConexiones.crearConexion()) {

            MongoDatabase empresaBD = this.obtenerBaseDatos(cliente);

            MongoCollection<Inscripcion> coleccion = this.obtenerColeccion(empresaBD);

            Document filtro = new Document()
                    .append("idHorario", new ObjectId(idHorario))
                    .append("estado", EstadoInscripcion.ACTIVO.name());

            List<Inscripcion> inscripciones = new LinkedList<>();

            coleccion.find(filtro).into(inscripciones);

            return inscripciones;
            
        }catch (MongoException ex) {
            LOGGER.severe(ex.getMessage());
            throw new PersistenciaException("No se pudieron consultar las inscripciones activas");
        }
    }

    /**
     * Obtiene todas las inscripciones
     * asociadas a un cliente.
     * 
     * @param idCliente ID del cliente.
     * @return Lista de inscripciones del cliente.
     * @throws PersistenciaException Se lanza cuando ocurre
     * un error durante la consulta.
     */
    @Override
    public List<Inscripcion> obtenerPorCliente(String idCliente) throws PersistenciaException {
        try (MongoClient cliente = ManejadorConexiones.crearConexion()) {

            MongoDatabase empresaBD = this.obtenerBaseDatos(cliente);

            MongoCollection<Inscripcion> coleccion = this.obtenerColeccion(empresaBD);

            Document filtro = new Document("idCliente", new ObjectId(idCliente));

            List<Inscripcion> inscripciones = new LinkedList<>();

            coleccion.find(filtro).into(inscripciones);

            return inscripciones;
            
        }catch (MongoException ex) {
            LOGGER.severe(ex.getMessage());
            throw new PersistenciaException("No se pudieron consultar las inscripciones del cliente");
        }
    }
    
    
}
