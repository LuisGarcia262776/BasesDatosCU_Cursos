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
import com.mycompany.fitlifegym_persistencia.entidades.Curso;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 *
 * Clase DAO encargada de gestionar
 * las operaciones de persistencia
 * relacionadas con los cursos.
 * 
 * Permite registrar, consultar,
 * actualizar y eliminar cursos
 * dentro de la base de datos MongoDB.
 * 
 * @author PC GAMER MASTER RACE
 */
public class CursoDAO implements ICursoDAO {
    /**
     * Logger utilizado para registrar
     * eventos y errores del DAO.
     */
    private static final Logger LOGGER = Logger.getLogger(CursoDAO.class.getName());
    
    /**
     * Nombre de la colección
     * de cursos en MongoDB.
     */
    private static final String NOMBRE_COLECCION = "cursos";
    
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
     * Obtiene la colección de cursos.
     * 
     * @param baseDatos Base de datos utilizada.
     * @return Colección de cursos.
     */
    private MongoCollection<Curso> obtenerColeccion(MongoDatabase baseDatos) {
        MongoCollection<Curso> coleccionTrabajadores = baseDatos.getCollection(NOMBRE_COLECCION, Curso.class);
        return coleccionTrabajadores;
    }

    /**
     * Obtiene todos los cursos registrados.
     * 
     * @return Lista de cursos.
     * @throws PersistenciaException Se lanza cuando ocurre
     * un error durante la consulta.
     */
    @Override
    public List<Curso> obtenerTodos() throws PersistenciaException {
        try (MongoClient cliente = ManejadorConexiones.crearConexion()) {

            MongoDatabase empresaBD = this.obtenerBaseDatos(cliente);

            MongoCollection<Curso> coleccion = this.obtenerColeccion(empresaBD);

            List<Curso> cursos = new LinkedList<>();

            coleccion.find().into(cursos);

            return cursos;

        } catch (MongoException ex) {
            LOGGER.severe(ex.getMessage());
            throw new PersistenciaException("No se pudieron consultar los cursos");
        }
        
    }

    /**
     * Obtiene un curso mediante su ID.
     * 
     * @param idCurso ID del curso.
     * @return Curso encontrado o null
     * si no existe.
     * @throws PersistenciaException Se lanza cuando ocurre
     * un error durante la consulta.
     */
    @Override
    public Curso obtenerPorId(String idCurso) throws PersistenciaException {
        try (MongoClient cliente = ManejadorConexiones.crearConexion()) {

            MongoDatabase empresaBD = this.obtenerBaseDatos(cliente);

            MongoCollection<Curso> coleccion = this.obtenerColeccion(empresaBD);

            Document filtro = new Document("_id", new ObjectId(idCurso));

            Curso curso = coleccion.find(filtro).first();

            return curso;
            
        } catch (MongoException ex) {
            LOGGER.severe(ex.getMessage());
            throw new PersistenciaException("No se pudo consultar el curso: " + idCurso);
        }
    }

    /**
     * Guarda un nuevo curso
     * dentro de la base de datos.
     * 
     * @param curso Curso a guardar.
     * @return Curso guardado.
     * @throws PersistenciaException Se lanza cuando ocurre
     * un error durante el guardado.
     */
    @Override
    public Curso guardar(Curso curso) throws PersistenciaException {
        try (MongoClient cliente = ManejadorConexiones.crearConexion()) {
            
            MongoDatabase empresaBD = this.obtenerBaseDatos(cliente);
            
            MongoCollection<Curso> coleccion = this.obtenerColeccion(empresaBD);
            
            InsertOneResult resultado = coleccion.insertOne(curso);
            
            if (!resultado.wasAcknowledged()) {
                throw new PersistenciaException("No se pudo guardar el curso");
            }
            
            return curso;
            
        } catch (MongoException ex) {
            LOGGER.severe(ex.getMessage());
            throw new PersistenciaException("No se pudo guardar el curso");
        }

    }

    /**
     * Actualiza la información
     * de un curso existente.
     * 
     * @param curso Curso con información actualizada.
     * @return Curso actualizado.
     * @throws PersistenciaException Se lanza cuando ocurre
     * un error durante la actualización.
     */
    @Override
    public Curso actualizar(Curso curso) throws PersistenciaException {
        try (MongoClient cliente = ManejadorConexiones.crearConexion()) {

            MongoDatabase empresaBD = this.obtenerBaseDatos(cliente);

            MongoCollection<Curso> coleccion = this.obtenerColeccion(empresaBD);

            Document filtro = new Document("_id", new ObjectId(curso.getIdCurso()));

            UpdateResult resultado = coleccion.replaceOne(filtro, curso);

            if (resultado.getModifiedCount() == 0) {
                throw new PersistenciaException("No se pudo actualizar el curso");
            }

            return curso;

        } catch(MongoException ex) {
            LOGGER.severe(ex.getMessage());
            throw new PersistenciaException("No se pudo actualizar el curso");
        }
    }

    /**
     * Elimina un curso mediante su ID.
     * 
     * @param idCurso ID del curso.
     * @return true si el curso fue eliminado correctamente.
     * @throws PersistenciaException Se lanza cuando ocurre
     * un error durante la eliminación.
     */
    @Override
    public boolean eliminar(String idCurso) throws PersistenciaException {
        try (MongoClient cliente = ManejadorConexiones.crearConexion()) {

            MongoDatabase empresaBD = this.obtenerBaseDatos(cliente);

            MongoCollection<Curso> coleccion = this.obtenerColeccion(empresaBD);

            Document filtro = new Document("_id",new ObjectId(idCurso));

            DeleteResult resultado = coleccion.deleteOne(filtro);

            return resultado.getDeletedCount() > 0;

        } catch (MongoException ex) {
            LOGGER.severe(ex.getMessage());
            throw new PersistenciaException("No se pudo eliminar el curso");
        }
    }
    
}
