/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.fitlifegym_presentacion;

import com.mycompany.fitlifegym_dtos.CursoDTO;
import com.mycompany.fitlifegym_presentacion.guardarImagen.GurdadorImagenCarpeta;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.List;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 * Formulario encargado
 * de gestionar los cursos
 * registrados del sistema.
 * 
 * Permite visualizar,
 * editar, eliminar
 * y acceder a los horarios
 * de cada curso.
 * 
 * @author PC GAMER MASTER RACE
 */
public class GestionDeCursosFORM extends javax.swing.JFrame {
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(GestionDeCursosFORM.class.getName());

    private final ControlNavegacion control;

    /**
    * Constructor del formulario
    * de gestión de cursos.
    * 
    * Inicializa los componentes,
    * configura el panel
    * y carga los cursos
    * registrados.
    * 
    * @param control Controlador
    * de navegación del sistema.
    */
    public GestionDeCursosFORM(ControlNavegacion control) {
        this.control = control;
        initComponents();
        JPanel.remove(jSeparator3);
        JPanel.setLayout(new BoxLayout(JPanel, BoxLayout.Y_AXIS));
        JPanel.setBackground(new Color(18, 18, 18));
        cargarCursos();
    }

    // CARGA DINAMICA
    /**
    * Carga dinámicamente
    * todos los cursos
    * registrados del sistema.
    * 
    * Si no existen cursos,
    * muestra un mensaje
    * informativo.
    */
    public void cargarCursos() {
        JPanel.removeAll();
        List<CursoDTO> cursos = control.obtenerCursos();
        if (cursos == null || cursos.isEmpty()) {
            JLabel lblVacio = new JLabel("No hay cursos registrados.");
            lblVacio.setForeground(Color.LIGHT_GRAY);
            lblVacio.setFont(new Font("Segoe UI", Font.ITALIC, 14));
            lblVacio.setAlignmentX(Component.LEFT_ALIGNMENT);
            JPanel.add(lblVacio);
        } else {
            for (CursoDTO curso : cursos) {
                JPanel fila = crearFilaCurso(curso);
                fila.setAlignmentX(Component.LEFT_ALIGNMENT);
                JPanel.add(fila);
                JPanel.add(Box.createVerticalStrut(6));
            }
        }
        JPanel.revalidate();
        JPanel.repaint();
    }

    /**
    * Crea una fila visual
    * para representar
    * un curso.
    * 
    * Incluye imagen,
    * nombre y botones
    * de acciones.
    * 
    * @param curso Curso
    * a representar.
    * @return Panel visual
    * del curso.
    */
    private JPanel crearFilaCurso(CursoDTO curso) {
        JPanel fila = new JPanel(new BorderLayout(10, 0));
        fila.setBackground(new Color(18, 18, 18));
        fila.setMaximumSize(new Dimension(Integer.MAX_VALUE, 82));
        fila.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(225, 6, 0)));

        // ── Imagen ────────────────────────────────────────────────────────
        JLabel lblImagen = new JLabel();
        lblImagen.setPreferredSize(new Dimension(82, 72));
        lblImagen.setMinimumSize(new Dimension(82, 72));
        lblImagen.setBackground(new Color(40, 40, 40));
        lblImagen.setOpaque(true);
        lblImagen.setHorizontalAlignment(SwingConstants.CENTER);

        if (curso.getImagen() != null && curso.getImagen().getRuta() != null && !curso.getImagen().getRuta().isEmpty()) {
            ImageIcon icon = GurdadorImagenCarpeta.cargarImagen(curso.getImagen().getRuta(), 82, 72);
            if (icon != null) {
                lblImagen.setIcon(icon);
            } else {
                lblImagen.setText("img");
                lblImagen.setForeground(Color.GRAY);
            }
        } else {
            lblImagen.setText("img");
            lblImagen.setForeground(Color.GRAY);
        }

        // Nombre
        JLabel lblNombre = new JLabel(curso.getNombre() != null ? curso.getNombre().toUpperCase(): "SIN NOMBRE");
        lblNombre.setForeground(new Color(242, 242, 242));
        lblNombre.setFont(new Font("Segoe UI", Font.BOLD, 13));
        
        JPanel panelIzq = new JPanel(new BorderLayout());
        panelIzq.setBackground(new Color(18, 18, 18));
        panelIzq.add(lblImagen, BorderLayout.CENTER);
        panelIzq.add(lblNombre, BorderLayout.SOUTH);
        panelIzq.setPreferredSize(new Dimension(130, 82));

        // Botones
        JButton btnEditar = crearBoton("Editar");
        JButton btnEliminar = crearBoton("Eliminar");
        JButton btnVer = crearBoton("Ver");

        btnEditar.addActionListener(e -> {
            control.navegarEditarCurso(curso);
            cargarCursos();
        });
        btnEliminar.addActionListener(e -> {
            if (control.mostrarConfirmacion("¿Eliminar el curso \"" + curso.getNombre() + "\"?")) {
                control.eliminarCurso(curso.getIdCurso());
                cargarCursos();
            }
        });
        btnVer.addActionListener(e -> control.navegarGestionHorarios(curso));

        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.RIGHT, 8, 22));
        panelBotones.setBackground(new Color(18, 18, 18));
        panelBotones.add(btnEditar);
        panelBotones.add(btnEliminar);
        panelBotones.add(btnVer);

        fila.add(panelIzq, BorderLayout.WEST);
        fila.add(panelBotones, BorderLayout.CENTER);
        return fila;
    }

    /**
    * Crea un botón
    * personalizado
    * para las acciones
    * del formulario.
    * 
    * @param texto Texto
    * del botón.
    * @return Botón configurado.
    */
    private JButton crearBoton(String texto) {
        JButton btn = new JButton(texto);
        btn.setBackground(new Color(225, 6, 0));
        btn.setForeground(Color.WHITE);
        btn.setFont(new Font("Segoe UI", Font.BOLD, 13));
        btn.setFocusPainted(false);
        btn.setBorderPainted(false);
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn.setPreferredSize(new Dimension(100, 32));
        return btn;
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        lblGestionDeCursos = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        JscrollPane = new javax.swing.JScrollPane();
        JPanel = new javax.swing.JPanel();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        btnAgregarCurso = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();

        jSeparator1.setBackground(new java.awt.Color(225, 6, 0));
        jSeparator1.setForeground(new java.awt.Color(225, 6, 0));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(18, 18, 18));

        jPanel1.setBackground(new java.awt.Color(18, 18, 18));

        lblGestionDeCursos.setFont(new java.awt.Font("Segoe UI", 1, 65)); // NOI18N
        lblGestionDeCursos.setForeground(new java.awt.Color(242, 242, 242));
        lblGestionDeCursos.setText("GESTION DE CURSOS");

        jSeparator2.setBackground(new java.awt.Color(225, 6, 0));
        jSeparator2.setForeground(new java.awt.Color(225, 6, 0));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(242, 242, 242));
        jLabel1.setText("Cursos Registrados:");

        JscrollPane.setBackground(new java.awt.Color(18, 18, 18));
        JscrollPane.setBorder(null);

        JPanel.setBackground(new java.awt.Color(18, 18, 18));
        JPanel.setLayout(new javax.swing.BoxLayout(JPanel, javax.swing.BoxLayout.LINE_AXIS));
        JPanel.add(jSeparator4);
        JPanel.add(jSeparator3);

        JscrollPane.setViewportView(JPanel);

        btnAgregarCurso.setBackground(new java.awt.Color(245, 0, 0));
        btnAgregarCurso.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnAgregarCurso.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregarCurso.setText("+ AgregarCurso");
        btnAgregarCurso.addActionListener(this::btnAgregarCursoActionPerformed);

        btnVolver.setBackground(new java.awt.Color(245, 0, 0));
        btnVolver.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnVolver.setForeground(new java.awt.Color(255, 255, 255));
        btnVolver.setText("Volver");
        btnVolver.addActionListener(this::btnVolverActionPerformed);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator2, javax.swing.GroupLayout.DEFAULT_SIZE, 1195, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(249, 249, 249)
                                .addComponent(lblGestionDeCursos))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JscrollPane)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnAgregarCurso)
                                .addGap(360, 360, 360)
                                .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblGestionDeCursos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(JscrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 617, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregarCurso)
                    .addComponent(btnVolver))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
    * Evento ejecutado
    * al presionar el botón
    * agregar curso.
    * 
    * Navega al formulario
    * de registro de cursos.
    * 
    * @param evt Evento generado
    * por el botón agregar curso.
    */
    private void btnAgregarCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarCursoActionPerformed
        control.navegarAgregarCurso();
    }//GEN-LAST:event_btnAgregarCursoActionPerformed

    /**
    * Evento ejecutado
    * al presionar el botón volver.
    * 
    * Regresa al menú
    * principal del administrador.
    * 
    * @param evt Evento generado
    * por el botón volver.
    */
    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
       control.navegarMenuAdmin();
    }//GEN-LAST:event_btnVolverActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel JPanel;
    private javax.swing.JScrollPane JscrollPane;
    private javax.swing.JButton btnAgregarCurso;
    private javax.swing.JButton btnVolver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JLabel lblGestionDeCursos;
    // End of variables declaration//GEN-END:variables
}
