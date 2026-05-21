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
import java.awt.Dimension;
import java.awt.Font;
import java.util.List;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author PC GAMER MASTER RACE
 */
public class MisCursosFORM extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(MisCursosFORM.class.getName());
    private final ControlNavegacion control;

    public MisCursosFORM(ControlNavegacion control) {
        this.control = control;
        initComponents();
        this.setLocationRelativeTo(null);
        cargarMisCursos();
    }

    // Carga los cursos del cliente logueado
    private void cargarMisCursos() {
        jPanel2.removeAll();
        jPanel2.setLayout(new BoxLayout(jPanel2, BoxLayout.Y_AXIS));
        jPanel2.setBackground(new Color(18, 18, 18));

        String idCliente = control.getClienteActual().getIdCliente();
        List<InscripcionDTO> inscripciones = control.obtenerInscripciones();

        if (inscripciones == null || inscripciones.isEmpty()) {
            JLabel lbl = new JLabel("No estás inscrito a ningún curso.");
            lbl.setForeground(Color.LIGHT_GRAY);
            lbl.setFont(new Font("Segoe UI", Font.ITALIC, 16));
            lbl.setAlignmentX(Component.LEFT_ALIGNMENT);
            jPanel2.add(lbl);
        } else {
            boolean hayAlguno = false;
            for (InscripcionDTO ins : inscripciones) {
                if (!ins.getIdCliente().equals(idCliente)) {
                    continue;
                }
                hayAlguno = true;

                // Buscar horario y curso
                HorarioDTO horario = buscarHorario(ins.getIdHorario());
                CursoDTO curso = null;
                if (horario != null) {
                    curso = buscarCurso(horario.getIdCurso());
                }

                jPanel2.add(crearTarjetaInscripcion(curso, horario));
                jPanel2.add(Box.createVerticalStrut(8));
            }

            if (!hayAlguno) {
                JLabel lbl = new JLabel("No estás inscrito a ningún curso.");
                lbl.setForeground(Color.LIGHT_GRAY);
                lbl.setAlignmentX(Component.LEFT_ALIGNMENT);
                jPanel2.add(lbl);
            }
        }

        jPanel2.revalidate();
        jPanel2.repaint();
    }

    private HorarioDTO buscarHorario(String idHorario) {
        List<CursoDTO> cursos = control.obtenerCursos();
        if (cursos == null) return null;
        for (CursoDTO c : cursos) {
            List<HorarioDTO> horarios = control.obtenerHorariosPorCurso(c.getIdCurso());
            if (horarios != null) {
                for (HorarioDTO h : horarios) {
                    if (h.getIdHorario().equals(idHorario)) {
                        return h;
                    }
                }
            }
        }
        return null;
    }

    private CursoDTO buscarCurso(String idCurso) {
        List<CursoDTO> cursos = control.obtenerCursos();
        if (cursos == null) return null;
        for (CursoDTO c : cursos) {
            if (c.getIdCurso().equals(idCurso)) {
                return c;
            }
        }
        return null;
    }

    private JPanel crearTarjetaInscripcion(CursoDTO curso, HorarioDTO horario) {
        JPanel card = new JPanel(new BorderLayout(15, 0));
        card.setBackground(new Color(30, 30, 30));
        card.setMaximumSize(new Dimension(Integer.MAX_VALUE, 120));
        card.setBorder(javax.swing.BorderFactory.createMatteBorder(
                0, 0, 2, 0, new Color(225, 6, 0)));

        // Imagen
        JLabel lblImagen = new JLabel();
        lblImagen.setPreferredSize(new Dimension(100, 80));
        lblImagen.setHorizontalAlignment(SwingConstants.CENTER);
        lblImagen.setBackground(new Color(40, 40, 40));
        lblImagen.setOpaque(true);

        if (curso != null && curso.getImagen() != null && curso.getImagen().getRuta() != null && !curso.getImagen().getRuta().isEmpty()) {
            ImageIcon icon = GurdadorImagenCarpeta.cargarImagen(curso.getImagen().getRuta(), 100, 80);
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

        // Info
        JPanel panelInfo = new JPanel();
        panelInfo.setLayout(new BoxLayout(panelInfo, BoxLayout.Y_AXIS));
        panelInfo.setBackground(new Color(30, 30, 30));

        String nombreCurso = curso != null ? curso.getNombre().toUpperCase() : "SIN NOMBRE";
        JLabel lblNombre = new JLabel(nombreCurso);
        lblNombre.setForeground(Color.WHITE);
        lblNombre.setFont(new Font("Segoe UI", Font.BOLD, 18));

        String dias = "";
        String hora = "--:-- - --:--";
        if (horario != null) {
            if (horario.getDias() != null) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < horario.getDias().size(); i++) {
                    String d = horario.getDias().get(i).toString();
                    sb.append(d.length() >= 2 ? d.substring(0, 2) : d);
                    if (i < horario.getDias().size() - 1) sb.append(" - ");
                }
                dias = sb.toString();
            }
            if (horario.getHoraInicio() != null && horario.getHoraFin() != null) {
                hora = horario.getHoraInicio() + " - " + horario.getHoraFin();
            }
        }

        JLabel lblDias = new JLabel(dias);
        lblDias.setForeground(Color.LIGHT_GRAY);
        lblDias.setFont(new Font("Segoe UI", Font.PLAIN, 14));

        JLabel lblHora = new JLabel(hora);
        lblHora.setForeground(new Color(225, 6, 0));
        lblHora.setFont(new Font("Segoe UI", Font.BOLD, 14));

        panelInfo.add(Box.createVerticalStrut(15));
        panelInfo.add(lblNombre);
        panelInfo.add(Box.createVerticalStrut(5));
        panelInfo.add(lblDias);
        panelInfo.add(Box.createVerticalStrut(3));
        panelInfo.add(lblHora);

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

        jPanel1 = new javax.swing.JPanel();
        jSeparator2 = new javax.swing.JSeparator();
        lblMisCursos = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        btnVolver = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(18, 18, 18));
        jPanel1.setForeground(new java.awt.Color(242, 242, 242));

        jSeparator2.setBackground(new java.awt.Color(225, 6, 0));
        jSeparator2.setForeground(new java.awt.Color(225, 6, 0));

        lblMisCursos.setFont(new java.awt.Font("Segoe UI", 1, 60)); // NOI18N
        lblMisCursos.setForeground(new java.awt.Color(242, 242, 242));
        lblMisCursos.setText("MIS CURSOS");

        jPanel2.setBackground(new java.awt.Color(18, 18, 18));
        jPanel2.setForeground(new java.awt.Color(242, 242, 242));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1133, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 697, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(jPanel2);

        btnVolver.setBackground(new java.awt.Color(255, 0, 0));
        btnVolver.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnVolver.setForeground(new java.awt.Color(255, 255, 255));
        btnVolver.setText("Volver");
        btnVolver.addActionListener(this::btnVolverActionPerformed);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(lblMisCursos)
                        .addGap(370, 370, 370))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(lblMisCursos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnVolver)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        control.navegarBienvenida(control.getClienteActual());
    }//GEN-LAST:event_btnVolverActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnVolver;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblMisCursos;
    // End of variables declaration//GEN-END:variables
}
