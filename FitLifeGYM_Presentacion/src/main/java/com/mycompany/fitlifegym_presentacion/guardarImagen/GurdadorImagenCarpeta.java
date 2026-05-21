/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.fitlifegym_presentacion.guardarImagen;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import javax.swing.ImageIcon;

/**
 * Clase utilitaria encargada
 * de guardar y cargar imágenes
 * utilizadas en los cursos del sistema.
 * 
 * Permite almacenar imágenes
 * dentro de la carpeta local
 * del proyecto y recuperarlas
 * para mostrarlas en la interfaz.
 * 
 * @author PC GAMER MASTER RACE
 */
public class GurdadorImagenCarpeta {
    /**
     * Nombre de la carpeta
     * donde se almacenan
     * las imágenes de cursos.
     */
    private static final String CARPETA = "imagenesCursos";

    /**
     * Obtiene la ruta absoluta
     * de la carpeta de imágenes
     * dentro del proyecto.
     * 
     * @return Ruta absoluta
     * de la carpeta de imágenes.
     */
    private static String obtenerRutaCarpeta() {
        String dir = System.getProperty("user.dir");
        if (dir.contains("FitLifeGYM_Presentacion")) {
            dir = dir.substring(0, dir.lastIndexOf("FitLifeGYM_Presentacion"));
        } else {
            dir = dir + File.separator;
        }
        return dir + CARPETA;
    }

    /**
     * Guarda una imagen
     * dentro de la carpeta
     * imagenesCursos.
     * 
     * Genera un nombre único
     * utilizando el tiempo actual
     * para evitar duplicados.
     * 
     * @param archivo Archivo de imagen
     * a guardar.
     * @return Ruta completa
     * de la imagen guardada.
     * @throws IOException Si ocurre
     * un error durante la copia.
     */
    public static String guardarImagen(File archivo) throws IOException {
        File carpeta = new File(obtenerRutaCarpeta());
        if (!carpeta.exists()) {
            carpeta.mkdirs();
        }
        String nombre = System.currentTimeMillis() + "_" + archivo.getName();
        Path destino = Paths.get(carpeta.getAbsolutePath(), nombre);
        Files.copy(archivo.toPath(), destino, StandardCopyOption.REPLACE_EXISTING);
        return destino.toString();
    }

    /**
     * Carga una imagen
     * desde una URL,
     * ruta absoluta
     * o desde la carpeta
     * imagenesCursos.
     * 
     * La imagen es escalada
     * al tamaño especificado.
     * 
     * @param ruta Ruta o URL
     * de la imagen.
     * @param ancho Ancho deseado
     * de la imagen.
     * @param alto Alto deseado
     * de la imagen.
     * @return ImageIcon de la imagen
     * cargada y escalada,
     * o null si no se encuentra.
     */
    public static ImageIcon cargarImagen(String ruta, int ancho, int alto) {
        try {
            if (ruta == null || ruta.isBlank()) {
                return null;
            }
            ImageIcon icon;
            if (ruta.startsWith("http://") || ruta.startsWith("https://")) {
                icon = new ImageIcon(new java.net.URL(ruta));
            } else {
                File archivo = new File(ruta);
                if (!archivo.exists()) {
                    // Si no existe con la ruta completa, busca solo por nombre
                    String nombre = archivo.getName();
                    archivo = new File(obtenerRutaCarpeta() + File.separator + nombre);
                }
                if (!archivo.exists()) {
                    return null;
                }
                icon = new ImageIcon(archivo.getAbsolutePath());
            }
            Image scaled = icon.getImage().getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);
            return new ImageIcon(scaled);
        } catch (Exception e) {
            return null;
        }
    }
    
}
