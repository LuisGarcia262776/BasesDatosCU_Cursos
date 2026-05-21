/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.fitlifegym_presentacion;

import com.mycompany.fitlifegym_dtos.CursoDTO;
import com.mycompany.fitlifegym_presentacion.guardarImagen.GurdadorImagenCarpeta;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 * Formulario encargado
 * de mostrar los cursos
 * disponibles para el cliente.
 * 
 * Permite visualizar la información
 * de los cursos y realizar
 * inscripciones.
 * 
 * @author PC GAMER MASTER RACE
 */
public class CursosClienteFORM extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(CursosClienteFORM.class.getName());
    private final ControlNavegacion control;
    

    /**
    * Constructor del formulario
    * de cursos del cliente.
    * 
    * Inicializa los componentes
    * y carga los cursos
    * disponibles del sistema.
    * 
    * @param control Controlador
    * de navegación del sistema.
    */
    public CursosClienteFORM(ControlNavegacion control) {
        this.control = control;
        initComponents();
        jPanel1.setLayout(new BoxLayout(jPanel1, BoxLayout.Y_AXIS));
        jPanel1.setBackground(new Color(18,18,18));

        cargarCursos();
    }
    
    /**
    * Carga todos los cursos
    * disponibles dentro
    * del panel principal.
    * 
    * Si no existen cursos,
    * muestra un mensaje
    * informativo.
    */
    private void cargarCursos() {
        jPanel1.removeAll();

        List<CursoDTO> cursos =control.obtenerCursos();

        if (cursos == null || cursos.isEmpty()) {
            JLabel lblVacio = new JLabel("No hay cursos disponibles.");
            lblVacio.setForeground(Color.LIGHT_GRAY);
            jPanel1.add(lblVacio);
        } else {
            for (CursoDTO curso : cursos) {
                JPanel tarjeta = crearTarjetaCurso(curso);
                jPanel1.add(tarjeta);
            }
        }
        jPanel1.revalidate();
        jPanel1.repaint();
    }
    
    /**
    * Crea una tarjeta visual
    * para mostrar la información
    * de un curso.
    * 
    * Incluye imagen,
    * descripción y botón
    * de inscripción.
    * 
    * @param curso Curso
    * a mostrar.
    * @return Panel con la tarjeta
    * del curso.
    */
    private JPanel crearTarjetaCurso(CursoDTO curso) {
        JPanel card = new JPanel();
        card.setBackground(new Color(30,30,30));
        card.setMaximumSize(new Dimension(Integer.MAX_VALUE,170));
        card.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0,new Color(225,6,0)));

        card.setLayout(new BorderLayout(15,10));

        // ── Imagen ────────────────────────────────────────────────────────
        JLabel lblImagen = new JLabel();
        lblImagen.setPreferredSize(new Dimension(180, 150));
        lblImagen.setHorizontalAlignment(SwingConstants.CENTER);

        if (curso.getImagen() != null && curso.getImagen().getRuta() != null && !curso.getImagen().getRuta().isEmpty()) {
            ImageIcon icon = GurdadorImagenCarpeta.cargarImagen(curso.getImagen().getRuta(), 180, 150);
            if (icon != null) {
                lblImagen.setIcon(icon);
            } else {
                lblImagen.setText("Sin imagen");
                lblImagen.setForeground(Color.GRAY);
            }
        } else {
            lblImagen.setText("Sin imagen");
            lblImagen.setForeground(Color.GRAY);
        }

        // INFO
        JPanel panelInfo = new JPanel();
        panelInfo.setBackground(new Color(30,30,30));
        panelInfo.setLayout(new BoxLayout(panelInfo, BoxLayout.Y_AXIS));

        JLabel lblNombre = new JLabel(curso.getNombre());

        lblNombre.setForeground(Color.WHITE);
        lblNombre.setFont(new Font("Segoe UI", Font.BOLD, 24));

        JLabel lblDescripcion = new JLabel("<html>" + curso.getDescripcion() + "</html>");
        lblDescripcion.setForeground(Color.LIGHT_GRAY);

        JButton btnInscribirse = new JButton("Inscribirse");
        btnInscribirse.setBackground(new Color(225,6,0));
        btnInscribirse.setForeground(Color.WHITE);

        btnInscribirse.addActionListener(e -> {
            control.navegarInscripcionCurso(curso);
        });

        panelInfo.add(lblNombre);
        panelInfo.add(Box.createVerticalStrut(10));
        panelInfo.add(lblDescripcion);
        panelInfo.add(Box.createVerticalStrut(15));
        panelInfo.add(btnInscribirse);

        card.add(lblImagen, BorderLayout.WEST);
        card.add(panelInfo, BorderLayout.CENTER);

        return card;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlNegro = new javax.swing.JPanel();
        jSeparator2 = new javax.swing.JSeparator();
        lblCursos = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlNegro.setBackground(new java.awt.Color(18, 18, 18));

        jSeparator2.setBackground(new java.awt.Color(225, 6, 0));
        jSeparator2.setForeground(new java.awt.Color(225, 6, 0));

        lblCursos.setFont(new java.awt.Font("Segoe UI", 1, 60)); // NOI18N
        lblCursos.setForeground(new java.awt.Color(242, 242, 242));
        lblCursos.setText("CURSOS");

        jPanel1.setBackground(new java.awt.Color(18, 18, 18));
        jPanel1.setForeground(new java.awt.Color(242, 242, 242));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1053, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 745, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(jPanel1);

        jButton1.setBackground(new java.awt.Color(255, 0, 0));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Volver");
        jButton1.addActionListener(this::jButton1ActionPerformed);

        javax.swing.GroupLayout pnlNegroLayout = new javax.swing.GroupLayout(pnlNegro);
        pnlNegro.setLayout(pnlNegroLayout);
        pnlNegroLayout.setHorizontalGroup(
            pnlNegroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(pnlNegroLayout.createSequentialGroup()
                .addGroup(pnlNegroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlNegroLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1045, Short.MAX_VALUE))
                    .addGroup(pnlNegroLayout.createSequentialGroup()
                        .addGroup(pnlNegroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlNegroLayout.createSequentialGroup()
                                .addGap(397, 397, 397)
                                .addComponent(lblCursos))
                            .addGroup(pnlNegroLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnlNegroLayout.setVerticalGroup(
            pnlNegroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNegroLayout.createSequentialGroup()
                .addComponent(lblCursos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 727, Short.MAX_VALUE)
                .addGap(26, 26, 26)
                .addComponent(jButton1)
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlNegro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlNegro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
    * Evento ejecutado
    * al presionar el botón volver.
    * 
    * Regresa a la pantalla
    * de bienvenida del cliente.
    * 
    * @param evt Evento generado
    * por el botón volver.
    */
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        control.navegarBienvenida(control.getClienteActual());
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblCursos;
    private javax.swing.JPanel pnlNegro;
    // End of variables declaration//GEN-END:variables
}
