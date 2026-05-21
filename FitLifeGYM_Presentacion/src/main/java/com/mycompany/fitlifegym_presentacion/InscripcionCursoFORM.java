/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.fitlifegym_presentacion;

import com.mycompany.fitlifegym_dtos.CursoDTO;
import com.mycompany.fitlifegym_dtos.HorarioDTO;
import com.mycompany.fitlifegym_dtos.InscripcionDTO;
import com.mycompany.fitlifegym_presentacion.guardarImagen.GurdadorImagenCarpeta;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 *
 * @author PC GAMER MASTER RACE
 */
public class InscripcionCursoFORM extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(InscripcionCursoFORM.class.getName());
    private final ControlNavegacion control;
    private final CursoDTO curso;

    public InscripcionCursoFORM(ControlNavegacion control, CursoDTO curso) {
        this.control = control;
        this.curso = curso;
        initComponents();
        txtCurso.setEditable(false);
        cargarCurso();
        cargarHorarios();
        
        // Verifica horarios después de que el frame este visible 
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                List<HorarioDTO> horarios = control.obtenerHorariosPorCurso(curso.getIdCurso());
                if (horarios == null || horarios.isEmpty()) {
                    control.navegarNoHayHorariosDisponible(curso);
                } else {
                    cargarHorarios();
                }
            }
        });
    }
    
    
    
    private void cargarCurso() {
        txtCurso.setText(curso.getNombre());

        if (curso.getImagen() != null && curso.getImagen().getRuta() != null && !curso.getImagen().getRuta().isEmpty()) {
            ImageIcon icon = GurdadorImagenCarpeta.cargarImagen(curso.getImagen().getRuta(), 227, 155);
            if (icon != null) {
                lblPreviwe.setIcon(icon);
            } else {
                lblPreviwe.setText("Sin imagen");
            }
        } else {
            lblPreviwe.setText("Sin imagen");
        }
    }
    
    private void cargarHorarios() {
        jPanel1.removeAll();
        jPanel1.setLayout(new GridLayout(0, 3, 16, 16));

        List<HorarioDTO> horarios = control.obtenerHorariosPorCurso(curso.getIdCurso());

        // Si no hay horarios
        if (horarios == null || horarios.isEmpty()) {
            control.navegarNoHayHorariosDisponible(curso);
            return;
        }

        for (HorarioDTO horario : horarios) {
            jPanel1.add(crearCardHorario(horario));
        }

        jPanel1.revalidate();
        jPanel1.repaint();
    }
    
    private JPanel crearCardHorario(HorarioDTO horario) {
        JPanel card = new JPanel();
        card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));
        card.setBackground(new Color(30,30,30));
        card.setBorder(BorderFactory.createLineBorder(new Color(225,6,0)));

        // DIAS
        String dias = "";
        if (horario.getDias() != null) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < horario.getDias().size(); i++) {
                String d = horario.getDias().get(i).toString();
                sb.append(d.substring(0,2));
                if (i < horario.getDias().size()-1) {
                    sb.append(" - ");
                }
            }
            dias = sb.toString();
        }

        JLabel lblDias = new JLabel(dias);

        lblDias.setForeground(Color.WHITE);
        lblDias.setFont(new Font("Segoe UI", Font.BOLD,18));
        lblDias.setAlignmentX(Component.CENTER_ALIGNMENT);

        // HORA
        JLabel lblHora = new JLabel(horario.getHoraInicio() + "-" + horario.getHoraFin());

        lblHora.setForeground(Color.WHITE);
        lblHora.setFont(new Font( "Segoe UI", Font.BOLD,16));
        lblHora.setAlignmentX(Component.CENTER_ALIGNMENT);

        // BOTON
        JButton btnSeleccionar = new JButton("Seleccionar");

        btnSeleccionar.setBackground(new Color(225,6,0));
        btnSeleccionar.setForeground(Color.WHITE);
        btnSeleccionar.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnSeleccionar.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                List<InscripcionDTO> inscripciones = control.obtenerInscripciones();
                boolean yaInscrito = false;

                if (inscripciones != null) {
                    for (InscripcionDTO ins : inscripciones) {
                        if (ins.getIdCliente().equals(control.getClienteActual().getIdCliente()) && ins.getIdHorario().equals(horario.getIdHorario())) {
                            yaInscrito = true;
                            break;
                        }
                    }
                }
                if (yaInscrito) {
                    control.navegarYaInscrito(curso, horario);
                    return;
                }
                InscripcionDTO dto = new InscripcionDTO(control.getClienteActual().getIdCliente(), horario.getIdHorario());
                InscripcionDTO guardada = control.agregarInscripcion(dto);

                if (guardada != null) {
                    control.mostrarExito("Inscripción realizada correctamente.");
                }

            } catch (Exception ex) {
                control.mostrarError(ex.getMessage());
            }
        }
    });

        card.add(Box.createVerticalStrut(20));
        card.add(lblDias);
        card.add(Box.createVerticalStrut(10));
        card.add(lblHora);
        card.add(Box.createVerticalStrut(25));
        card.add(btnSeleccionar);

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
        lblPreviwe = new javax.swing.JLabel();
        txtCurso = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        btnVolver = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlNegro.setBackground(new java.awt.Color(18, 18, 18));

        jSeparator2.setBackground(new java.awt.Color(225, 6, 0));
        jSeparator2.setForeground(new java.awt.Color(225, 6, 0));

        lblCursos.setFont(new java.awt.Font("Segoe UI", 1, 60)); // NOI18N
        lblCursos.setForeground(new java.awt.Color(242, 242, 242));
        lblCursos.setText("CURSOS");

        lblPreviwe.setBackground(new java.awt.Color(64, 64, 64));
        lblPreviwe.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPreviwe.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        lblPreviwe.setOpaque(true);
        lblPreviwe.setPreferredSize(new java.awt.Dimension(150, 130));

        txtCurso.setBackground(new java.awt.Color(64, 64, 64));
        txtCurso.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        txtCurso.setForeground(new java.awt.Color(255, 255, 255));
        txtCurso.addActionListener(this::txtCursoActionPerformed);

        jPanel1.setBackground(new java.awt.Color(18, 18, 18));
        jPanel1.setForeground(new java.awt.Color(242, 242, 242));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1076, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 663, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(jPanel1);

        btnVolver.setBackground(new java.awt.Color(255, 0, 0));
        btnVolver.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnVolver.setForeground(new java.awt.Color(255, 255, 255));
        btnVolver.setText("Volver");
        btnVolver.addActionListener(this::btnVolverActionPerformed);

        javax.swing.GroupLayout pnlNegroLayout = new javax.swing.GroupLayout(pnlNegro);
        pnlNegro.setLayout(pnlNegroLayout);
        pnlNegroLayout.setHorizontalGroup(
            pnlNegroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator2)
            .addGroup(pnlNegroLayout.createSequentialGroup()
                .addGroup(pnlNegroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlNegroLayout.createSequentialGroup()
                        .addGap(399, 399, 399)
                        .addComponent(lblCursos))
                    .addGroup(pnlNegroLayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(pnlNegroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1078, Short.MAX_VALUE)
                            .addGroup(pnlNegroLayout.createSequentialGroup()
                                .addGroup(pnlNegroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnlNegroLayout.createSequentialGroup()
                                        .addComponent(lblPreviwe, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(58, 58, 58)
                                        .addComponent(txtCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        pnlNegroLayout.setVerticalGroup(
            pnlNegroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNegroLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblCursos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlNegroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPreviwe, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnVolver)
                .addGap(13, 13, 13))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlNegro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlNegro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCursoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCursoActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        control.navegarBienvenida(control.getClienteActual());
    }//GEN-LAST:event_btnVolverActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnVolver;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblCursos;
    private javax.swing.JLabel lblPreviwe;
    private javax.swing.JPanel pnlNegro;
    private javax.swing.JTextField txtCurso;
    // End of variables declaration//GEN-END:variables
}
