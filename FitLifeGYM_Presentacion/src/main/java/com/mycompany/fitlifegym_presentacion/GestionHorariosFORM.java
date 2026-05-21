/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.fitlifegym_presentacion;

import com.mycompany.fitlifegym_dtos.CursoDTO;
import com.mycompany.fitlifegym_dtos.HorarioDTO;
import com.mycompany.fitlifegym_dtos.InscripcionDTO;
import com.mycompany.fitlifegym_presentacion.guardarImagen.GurdadorImagenCarpeta;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
 *
 * @author PC GAMER MASTER RACE
 */
public class GestionHorariosFORM extends javax.swing.JFrame { 
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(GestionHorariosFORM.class.getName());
    private final ControlNavegacion control;

    public GestionHorariosFORM(ControlNavegacion control) {
        this.control = control;
        initComponents();
        jPanel1.setBackground(new Color(18, 18, 18));
        cargarCursos();
    }

    public GestionHorariosFORM() {
        initComponents();
        this.control = null;
    }

    // ── Carga cursos en grid ──────────────────────────────────────────────
    private void cargarCursos() {
        jPanel1.removeAll();
        jPanel1.setLayout(new java.awt.GridLayout(0, 3, 16, 16));
        jPanel1.setBackground(new Color(18, 18, 18));

        List<CursoDTO> cursos = control.obtenerCursos();

        if (cursos == null || cursos.isEmpty()) {
            JLabel lbl = new JLabel("No hay cursos registrados.");
            lbl.setForeground(Color.LIGHT_GRAY);
            lbl.setFont(new Font("Segoe UI", Font.ITALIC, 16));
            jPanel1.add(lbl);
        } else {
            for (CursoDTO curso : cursos) {
                jPanel1.add(crearCardCurso(curso));
            }
        }

        jPanel1.revalidate();
        jPanel1.repaint();
    }

    // Cuadro de cada curso
    private JPanel crearCardCurso(CursoDTO curso) {
        JPanel card = new JPanel();
        card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));
        card.setBackground(new Color(18, 18, 18));
        card.setBorder(BorderFactory.createLineBorder(new Color(225, 6, 0), 2));
        card.setPreferredSize(new Dimension(170, 230));

        // Imagen
        JLabel lblImagen = new JLabel();
        lblImagen.setPreferredSize(new Dimension(166, 130));
        lblImagen.setMinimumSize(new Dimension(166, 130));
        lblImagen.setMaximumSize(new Dimension(166, 130));
        lblImagen.setBackground(new Color(40, 40, 40));
        lblImagen.setOpaque(true);
        lblImagen.setHorizontalAlignment(SwingConstants.CENTER);
        lblImagen.setAlignmentX(Component.CENTER_ALIGNMENT);

        if (curso.getImagen() != null && curso.getImagen().getRuta() != null && !curso.getImagen().getRuta().isEmpty()) {
            ImageIcon icon = GurdadorImagenCarpeta.cargarImagen(curso.getImagen().getRuta(), 166, 130);
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
        String nombreCurso = "SIN NOMBRE";
        if (curso.getNombre() != null) {
            nombreCurso = curso.getNombre().toUpperCase();
        }

        JLabel lblNombre = new JLabel(nombreCurso);
        lblNombre.setForeground(new Color(242, 242, 242));
        lblNombre.setFont(new Font("Segoe UI", Font.BOLD, 13));
        lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
        lblNombre.setAlignmentX(Component.CENTER_ALIGNMENT);

        // ── Botón Seleccionar ─────────────────────────────────────────────
        JButton btnSeleccionar = crearBotonRojo("Seleccionar", 140);
        btnSeleccionar.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnSeleccionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirHorariosCurso(curso);
            }
        });

        JPanel panelBtn = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
        panelBtn.setBackground(new Color(18, 18, 18));
        panelBtn.setMaximumSize(new Dimension(166, 40));
        panelBtn.add(btnSeleccionar);

        card.add(lblImagen);
        card.add(Box.createVerticalStrut(6));
        card.add(lblNombre);
        card.add(Box.createVerticalStrut(6));
        card.add(panelBtn);

        return card;
    }

    // Horarios del curso seleccionado
    private void abrirHorariosCurso(CursoDTO curso) {
        lblSeleccionaUnCurso.setText("Horarios: " + curso.getNombre().toUpperCase());

        jPanel1.removeAll();
        jPanel1.setLayout(new BoxLayout(jPanel1, BoxLayout.Y_AXIS));
        jPanel1.setBackground(new Color(18, 18, 18));

        List<HorarioDTO> horarios = control.obtenerHorariosPorCurso(curso.getIdCurso());

        if (horarios == null || horarios.isEmpty()) {
            JLabel lbl = new JLabel("  No hay horarios para este curso.");
            lbl.setForeground(Color.LIGHT_GRAY);
            lbl.setFont(new Font("Segoe UI", Font.ITALIC, 15));
            lbl.setAlignmentX(Component.LEFT_ALIGNMENT);
            jPanel1.add(Box.createVerticalStrut(10));
            jPanel1.add(lbl);
        } else {
            jPanel1.add(Box.createVerticalStrut(10));
            for (HorarioDTO horario : horarios) {
                JPanel fila = crearFilaHorario(horario, curso);
                fila.setAlignmentX(Component.LEFT_ALIGNMENT);
                jPanel1.add(fila);
                jPanel1.add(Box.createVerticalStrut(8));
            }
        }

        // Boton Agregar Horario 
        JButton btnAgregar = crearBotonRojo("+ Agregar Horario", 200);
        btnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                control.navegarAgregarHorario(curso);
            }
        });

        // Boton Volver
        JButton btnVolver = crearBotonRojo("Volver", 130);
        btnVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lblSeleccionaUnCurso.setText("Selecciona un Curso:");
                cargarCursos();
            }
        });

        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.LEFT, 12, 8));
        panelBotones.setBackground(new Color(18, 18, 18));
        panelBotones.setMaximumSize(new Dimension(Integer.MAX_VALUE, 55));
        panelBotones.setAlignmentX(Component.LEFT_ALIGNMENT);
        panelBotones.add(btnAgregar);
        panelBotones.add(btnVolver);

        jPanel1.add(Box.createVerticalStrut(12));
        jPanel1.add(panelBotones);

        jPanel1.revalidate();
        jPanel1.repaint();
    }

    // Fila de cada horario
    private JPanel crearFilaHorario(HorarioDTO horario, CursoDTO curso) {
        JPanel fila = new JPanel(new BorderLayout(10, 0));
        fila.setBackground(new Color(50, 50, 50));
        fila.setMaximumSize(new Dimension(Integer.MAX_VALUE, 55));
        fila.setBorder(BorderFactory.createEmptyBorder(4, 12, 4, 12));

        // Dias abreviados
        String dias = "";
        if (horario.getDias() != null && !horario.getDias().isEmpty()) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < horario.getDias().size(); i++) {
                String d = horario.getDias().get(i).toString();
                sb.append(d.length() >= 2 ? d.substring(0, 2) : d);
                if (i < horario.getDias().size() - 1) {
                    sb.append("-");
                }
            }
            dias = sb.toString();
        }

        String inicio = "--:--";
        if (horario.getHoraInicio() != null) {
            inicio = horario.getHoraInicio().toString();
        }

        String fin = "--:--";
        if (horario.getHoraFin() != null) {
            fin = horario.getHoraFin().toString();
        }

        JLabel lblInfo = new JLabel(dias + "  " + inicio + " - " + fin);
        lblInfo.setForeground(new Color(242, 242, 242));
        lblInfo.setFont(new Font("Segoe UI", Font.BOLD, 14));

        // Botones
        JButton btnEditar = crearBotonRojo("Editar", 90);
        JButton btnEliminar = crearBotonRojo("Eliminar", 90);
        JButton btnVer = crearBotonRojo("Ver", 70);

        btnEditar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                control.navegarEditarHorario(horario, curso);
            }
        });

        btnEliminar.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (control.mostrarConfirmacion("¿Eliminar este horario?")) {
                // Verificar si tiene inscripciones activas
                List<InscripcionDTO> inscripciones = control.obtenerInscripciones();
                boolean tieneInscritos = false;
                if (inscripciones != null) {
                    for (InscripcionDTO ins : inscripciones) {
                        if (ins.getIdHorario().equals(horario.getIdHorario())) {
                            tieneInscritos = true;
                            break;
                        }
                    }
                }

                if (tieneInscritos) {
                    // Tiene inscritos no se puede eliminar
                    control.navegarNoEliminarHorario();
                    return;
                }

                // Sin inscritos, elimina normalmente
                control.eliminarHorario(horario.getIdHorario());
                abrirHorariosCurso(curso);
            }
        }
    });

        btnVer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                control.navegarVerHorario(horario);
            }
        });

        JPanel panelBtns = new JPanel(new FlowLayout(FlowLayout.RIGHT, 6, 8));
        panelBtns.setBackground(new Color(50, 50, 50));
        panelBtns.add(btnEditar);
        panelBtns.add(btnEliminar);
        panelBtns.add(btnVer);

        fila.add(lblInfo,   BorderLayout.CENTER);
        fila.add(panelBtns, BorderLayout.EAST);
        return fila;
    }

    // boton rojo 
    private JButton crearBotonRojo(String texto, int ancho) {
        JButton btn = new JButton(texto);
        btn.setBackground(new Color(225, 6, 0));
        btn.setForeground(Color.WHITE);
        btn.setFont(new Font("Segoe UI", Font.BOLD, 13));
        btn.setFocusPainted(false);
        btn.setBorderPainted(false);
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn.setPreferredSize(new Dimension(ancho, 32));
        return btn;
    }
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpnlNegro = new javax.swing.JPanel();
        lblGestionDeHorarios = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        lblSeleccionaUnCurso = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        btnVolver = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jpnlNegro.setBackground(new java.awt.Color(18, 18, 18));

        lblGestionDeHorarios.setFont(new java.awt.Font("Segoe UI", 1, 60)); // NOI18N
        lblGestionDeHorarios.setForeground(new java.awt.Color(242, 242, 242));
        lblGestionDeHorarios.setText("GESTION DE HORARIOS");

        jSeparator1.setBackground(new java.awt.Color(225, 6, 0));
        jSeparator1.setForeground(new java.awt.Color(225, 6, 0));

        lblSeleccionaUnCurso.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblSeleccionaUnCurso.setForeground(new java.awt.Color(242, 242, 242));
        lblSeleccionaUnCurso.setText("Selecciona un Curso:");

        jScrollPane1.setBackground(new java.awt.Color(18, 18, 18));
        jScrollPane1.setBorder(null);

        jPanel1.setBackground(new java.awt.Color(18, 18, 18));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.LINE_AXIS));
        jScrollPane1.setViewportView(jPanel1);

        btnVolver.setBackground(new java.awt.Color(255, 0, 0));
        btnVolver.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnVolver.setForeground(new java.awt.Color(255, 255, 255));
        btnVolver.setText("VOLVER");
        btnVolver.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnVolver.addActionListener(this::btnVolverActionPerformed);

        javax.swing.GroupLayout jpnlNegroLayout = new javax.swing.GroupLayout(jpnlNegro);
        jpnlNegro.setLayout(jpnlNegroLayout);
        jpnlNegroLayout.setHorizontalGroup(
            jpnlNegroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(jpnlNegroLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnlNegroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnlNegroLayout.createSequentialGroup()
                        .addGroup(jpnlNegroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(jpnlNegroLayout.createSequentialGroup()
                                .addComponent(lblSeleccionaUnCurso)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnlNegroLayout.createSequentialGroup()
                        .addGap(0, 263, Short.MAX_VALUE)
                        .addGroup(jpnlNegroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnlNegroLayout.createSequentialGroup()
                                .addComponent(lblGestionDeHorarios)
                                .addGap(244, 244, 244))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnlNegroLayout.createSequentialGroup()
                                .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())))))
        );
        jpnlNegroLayout.setVerticalGroup(
            jpnlNegroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnlNegroLayout.createSequentialGroup()
                .addComponent(lblGestionDeHorarios)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblSeleccionaUnCurso)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 633, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addComponent(btnVolver)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpnlNegro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jpnlNegro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        control.navegarMenuAdmin();
    }//GEN-LAST:event_btnVolverActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnVolver;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel jpnlNegro;
    private javax.swing.JLabel lblGestionDeHorarios;
    private javax.swing.JLabel lblSeleccionaUnCurso;
    // End of variables declaration//GEN-END:variables
}
