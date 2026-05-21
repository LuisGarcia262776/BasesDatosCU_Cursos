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
 *
 * @author PC GAMER MASTER RACE
 */
public class GurdadorImagenCarpeta {
    private static final String CARPETA = "imagenesCursos";

    // Ruta absoluta a imagenesCursos en el repositorio
    private static String obtenerRutaCarpeta() {
        String dir = System.getProperty("user.dir");
        if (dir.contains("FitLifeGYM_Presentacion")) {
            dir = dir.substring(0, dir.lastIndexOf("FitLifeGYM_Presentacion"));
        } else {
            dir = dir + File.separator;
        }
        return dir + CARPETA;
    }

    // Copia el archivo a imagenesCursos y devuelve la ruta
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

    // Carga imagen desde URL, ruta absoluta o imagenesCursos 
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
