/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.fitlifegym_presentacion;

import com.mycompany.fitlifegym_dtos.CursoDTO;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.util.List;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author PC GAMER MASTER RACE
 */
public class GestionDeCursosFORM extends javax.swing.JFrame {
    private static final java.util.logging.Logger logger =
            java.util.logging.Logger.getLogger(GestionDeCursosFORM.class.getName());

    private final ControlNavegacion control;

    public GestionDeCursosFORM(ControlNavegacion control) {
        this.control = control;
        initComponents();

        // ← Quitar el separador que el arrastrador metió dentro del JPanel
        JPanel.remove(jSeparator3);

        // ← Forzar Y_AXIS para que las filas vayan hacia abajo
        JPanel.setLayout(new BoxLayout(JPanel, BoxLayout.Y_AXIS));
        JPanel.setBackground(new Color(18, 18, 18));

        cargarCursos();
    }

    // ══════════════════════════════════════════════════════
    // CARGA DINÁMICA
    // ══════════════════════════════════════════════════════

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

    private JPanel crearFilaCurso(CursoDTO curso) {
        JPanel fila = new JPanel(new BorderLayout(10, 0));
        fila.setBackground(new Color(18, 18, 18));
        fila.setMaximumSize(new Dimension(Integer.MAX_VALUE, 82));
        fila.setBorder(javax.swing.BorderFactory.createMatteBorder(
                0, 0, 1, 0, new Color(225, 6, 0)));

        // ── Imagen ────────────────────────────────────────
        JLabel lblImagen = new JLabel();
        lblImagen.setPreferredSize(new Dimension(82, 72));
        lblImagen.setMinimumSize(new Dimension(82, 72));
        lblImagen.setBackground(new Color(40, 40, 40));
        lblImagen.setOpaque(true);
        lblImagen.setHorizontalAlignment(SwingConstants.CENTER);

        if (curso.getImagen() != null && curso.getImagen().getRuta() != null && !curso.getImagen().getRuta().isEmpty()) {
            try {
                String ruta = curso.getImagen().getRuta();
                ImageIcon icon;

                // ← Detecta si es URL o ruta local
                if (ruta.startsWith("http://") || ruta.startsWith("https://")) {
                    icon = new ImageIcon(new java.net.URL(ruta));
                } else {
                    icon = new ImageIcon(ruta);
                }

                Image scaled = icon.getImage()
                        .getScaledInstance(82, 72, Image.SCALE_SMOOTH);
                lblImagen.setIcon(new ImageIcon(scaled));
            } catch (Exception e) {
                lblImagen.setText("img");
                lblImagen.setForeground(Color.GRAY);
            }
        } else {
            lblImagen.setText("img");
            lblImagen.setForeground(Color.GRAY);
        }

        // ── Nombre ────────────────────────────────────────
        JLabel lblNombre = new JLabel(
                curso.getNombre() != null
                        ? curso.getNombre().toUpperCase()
                        : "SIN NOMBRE");
        lblNombre.setForeground(new Color(242, 242, 242));
        lblNombre.setFont(new Font("Segoe UI", Font.BOLD, 13));

        JPanel panelIzq = new JPanel(new BorderLayout());
        panelIzq.setBackground(new Color(18, 18, 18));
        panelIzq.add(lblImagen, BorderLayout.CENTER);
        panelIzq.add(lblNombre, BorderLayout.SOUTH);
        panelIzq.setPreferredSize(new Dimension(130, 82));

        // ── Botones ───────────────────────────────────────
        JButton btnEditar   = crearBoton("Editar");
        JButton btnEliminar = crearBoton("Eliminar");
        JButton btnVer      = crearBoton("Ver");

        btnEditar.addActionListener(e -> {
            control.navegarEditarCurso(curso);
            cargarCursos();
        });
        btnEliminar.addActionListener(e -> {
            if (control.mostrarConfirmacion(
                    "¿Eliminar el curso \"" + curso.getNombre() + "\"?")) {
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

        fila.add(panelIzq,     BorderLayout.WEST);
        fila.add(panelBotones, BorderLayout.CENTER);
        return fila;
    }

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

    // ══════════════════════════════════════════════════════
    // initComponents — UN SOLO (el del arrastrador)
    // ══════════════════════════════════════════════════════
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        lblGestionDeCursos = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        JscrollPane = new javax.swing.JScrollPane();
        JPanel = new javax.swing.JPanel();
        jSeparator3 = new javax.swing.JSeparator();
        btnAgregarCurso = new javax.swing.JButton();

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
        JPanel.add(jSeparator3);

        JscrollPane.setViewportView(JPanel);

        btnAgregarCurso.setBackground(new java.awt.Color(245, 0, 0));
        btnAgregarCurso.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnAgregarCurso.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregarCurso.setText("+ AgregarCurso");
        btnAgregarCurso.addActionListener(this::btnAgregarCursoActionPerformed);

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
                        .addComponent(JscrollPane)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(505, 505, 505)
                .addComponent(btnAgregarCurso)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(btnAgregarCurso)
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

    private void btnAgregarCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarCursoActionPerformed
        AgregarCursoFORM frame = new AgregarCursoFORM(control);
        frame.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnAgregarCursoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel JPanel;
    private javax.swing.JScrollPane JscrollPane;
    private javax.swing.JButton btnAgregarCurso;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel lblGestionDeCursos;
    // End of variables declaration//GEN-END:variables
}
