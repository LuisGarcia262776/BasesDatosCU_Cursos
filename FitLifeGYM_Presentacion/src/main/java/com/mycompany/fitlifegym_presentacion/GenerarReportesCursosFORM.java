/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.fitlifegym_presentacion;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.mycompany.fitlifegym_dtos.CursoDTO;
import com.mycompany.fitlifegym_dtos.DatosReporteDTO;
import com.mycompany.fitlifegym_dtos.HorarioDTO;
import com.mycompany.fitlifegym_dtos.ReporteDTO;
import java.awt.Color;
import java.io.File;
import java.io.FileOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author PC GAMER MASTER RACE
 */
public class GenerarReportesCursosFORM extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(GenerarReportesCursosFORM.class.getName());
    private final ControlNavegacion control;

    // Constructor
    public GenerarReportesCursosFORM(ControlNavegacion control) {
        this.control = control;
        initComponents();
        this.setLocationRelativeTo(null);
        configurarTabla();
        cargarCursos();
    }

    // Helper Font AWT
    private java.awt.Font awtFont(String nombre, int estilo, int tamaño) {
        return new java.awt.Font(nombre, estilo, tamaño);
    }

    private void configurarTabla() {
        jTable1.setRowHeight(30);
        jTable1.setFont(awtFont("Segoe UI", java.awt.Font.PLAIN, 14));
        jTable1.getTableHeader().setFont(awtFont("Segoe UI", java.awt.Font.BOLD, 14));
        jTable1.getTableHeader().setBackground(new java.awt.Color(61, 173, 255));
        jTable1.getTableHeader().setForeground(java.awt.Color.WHITE);
        jTable1.setSelectionBackground(new java.awt.Color(255, 255, 255));
        jTable1.setGridColor(new java.awt.Color(70, 70, 70));
    }

    // Carga cursos en el combo
    private void cargarCursos() {
        cmbCurso.removeAllItems();
        cmbCurso.addItem("TODOS");

        List<CursoDTO> cursos = control.obtenerCursos();
        if (cursos != null) {
            for (CursoDTO curso : cursos) {
                cmbCurso.addItem(curso.getNombre().toUpperCase());
            }
        }
    }

    // Llena la tabla con resultados
    private void llenarTabla(ReporteDTO reporte, SimpleDateFormat sdf) {
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
        modelo.setRowCount(0);

        // Curso seleccionado en el combo 
        String cursoSeleccionado = "TODOS";
        if (cmbCurso.getSelectedItem() != null) {
            cursoSeleccionado = cmbCurso.getSelectedItem().toString();
        }

        List<HorarioDTO> horarios = reporte.getHorarios();
        List<CursoDTO> cursos = reporte.getCursos();

        for (int i = 0; i < horarios.size(); i++) {
            HorarioDTO horario = horarios.get(i);

            // Nombre del curso 
            String nombreCurso = "";
            if (cursos != null && i < cursos.size()) {
                if (cursos.get(i).getNombre() != null) {
                    nombreCurso = cursos.get(i).getNombre().toUpperCase();
                }
            }

            // Filtrar por curso si no es TODOS 
            boolean esTodos = cursoSeleccionado.equals("TODOS");
            boolean coincideCurso = nombreCurso.equalsIgnoreCase(cursoSeleccionado);
            if (!esTodos && !coincideCurso) {
                continue;
            }

            // Hora inicio 
            String horaInicio = "--:--";
            if (horario.getHoraInicio() != null) {
                horaInicio = horario.getHoraInicio().toString();
            }

            // Hora fin 
            String horaFin = "--:--";
            if (horario.getHoraFin() != null) {
                horaFin = horario.getHoraFin().toString();
            }

            String horarioStr = horaInicio + " - " + horaFin;

            // Dias abreviados 
            String diasStr = "";
            if (horario.getDias() != null && !horario.getDias().isEmpty()) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < horario.getDias().size(); j++) {
                    String dia = horario.getDias().get(j).toString();
                    sb.append(dia.length() >= 2 ? dia.substring(0, 2) : dia);
                    if (j < horario.getDias().size() - 1) {
                        sb.append(" - ");
                    }
                }
                diasStr = sb.toString();
            }

            // Cupo actual
            String cantidad = "0";
            if (horario.getCupoActual() != null) {
                cantidad = String.valueOf(horario.getCupoActual());
            }

            // Fecha de hoy 
            String fecha = sdf.format(new Date());

            modelo.addRow(new Object[]{
                nombreCurso,
                horarioStr,
                diasStr,
                cantidad,
                fecha
            });
        }
    }

    // Limpia la tabla
    private void limpiarTabla() {
        ((DefaultTableModel) jTable1.getModel()).setRowCount(0);
    }

    // Exportar PDF 
    private void exportarPDF(String ruta) throws Exception {
        Document documento = new Document(PageSize.A4.rotate());
        PdfWriter.getInstance(documento, new FileOutputStream(ruta));
        documento.open();

        // Fuentes iText
        Font fuenteTitulo = new Font(Font.FontFamily.HELVETICA, 18, Font.BOLD, BaseColor.BLACK);

        Font fuenteSubtitulo = new Font(Font.FontFamily.HELVETICA, 11, NORMAL, BaseColor.BLACK);

        Font fuenteHeader = new Font(Font.FontFamily.HELVETICA, 11, Font.BOLD, BaseColor.BLACK);

        Font fuenteCelda = new Font(Font.FontFamily.HELVETICA, 10, Font.NORMAL, BaseColor.BLACK);

        // Titulo 
        Paragraph titulo = new Paragraph("REPORTE DE CURSOS - FIT LIFE GYM\n", fuenteTitulo);
        titulo.setAlignment(Element.ALIGN_CENTER);
        documento.add(titulo);

        // Subtitulo con filtros
        String subtituloTexto = "Período: " + txtFechaInicio.getText() + " al " + txtFechaFin.getText() + "   |   Cantidad mínima: " + txtCantidadMin.getText()
            + "   |   Curso: " + cmbCurso.getSelectedItem() + "\nGenerado: " + new SimpleDateFormat("dd/MM/yyyy HH:mm").format(new Date());

        Paragraph subtitulo = new Paragraph(subtituloTexto, fuenteSubtitulo);
        subtitulo.setAlignment(Element.ALIGN_CENTER);
        subtitulo.setSpacingAfter(16);
        documento.add(subtitulo);

        // Tabla 
        PdfPTable tabla = new PdfPTable(5);
        tabla.setWidthPercentage(100);
        tabla.setWidths(new float[]{2f, 2.5f, 3f, 1.5f, 2f});

        // Headers rojos ─
        String[] headers = {"CURSO", "HORARIO", "DÍAS", "CANTIDAD", "FECHA"};
        BaseColor rojoGym = new BaseColor(255, 255, 255);

        for (String header : headers) {
            PdfPCell celda = new PdfPCell(new Phrase(header, fuenteHeader));
            celda.setBackgroundColor(rojoGym);
            celda.setHorizontalAlignment(Element.ALIGN_CENTER);
            celda.setVerticalAlignment(Element.ALIGN_MIDDLE);
            celda.setPadding(8);
            tabla.addCell(celda);
        }

        // Filas alternadas blanco/gris 
        BaseColor grisClaro = new BaseColor(240, 240, 240);
        BaseColor blanco = BaseColor.WHITE;

        for (int i = 0; i < jTable1.getRowCount(); i++) {
            BaseColor colorFila = (i % 2 == 0) ? blanco : grisClaro;
            for (int j = 0; j < 5; j++) {
                String valor = jTable1.getValueAt(i, j) != null ? jTable1.getValueAt(i, j).toString() : "";
                PdfPCell celda = new PdfPCell(new Phrase(valor, fuenteCelda));
                celda.setBackgroundColor(colorFila);
                celda.setHorizontalAlignment(Element.ALIGN_CENTER);
                celda.setVerticalAlignment(Element.ALIGN_MIDDLE);
                celda.setPadding(7);
                tabla.addCell(celda);
            }
        }

        documento.add(tabla);

        // Pie de pagina
        Paragraph pie = new Paragraph("\nTotal de registros: " + jTable1.getRowCount(), fuenteSubtitulo);
        pie.setAlignment(Element.ALIGN_RIGHT);
        documento.add(pie);

        documento.close();
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
        jSeparator1 = new javax.swing.JSeparator();
        lblGenerarReportesCursos = new javax.swing.JLabel();
        lblFechaInicio = new javax.swing.JLabel();
        txtFechaInicio = new javax.swing.JTextField();
        lblFechaFin = new javax.swing.JLabel();
        txtFechaFin = new javax.swing.JTextField();
        lblCantidadMin = new javax.swing.JLabel();
        txtCantidadMin = new javax.swing.JTextField();
        lblCurso = new javax.swing.JLabel();
        cmbCurso = new javax.swing.JComboBox<>();
        btnBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnExportarPDF = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlNegro.setBackground(new java.awt.Color(18, 18, 18));

        jSeparator1.setBackground(new java.awt.Color(225, 6, 0));
        jSeparator1.setForeground(new java.awt.Color(225, 6, 0));

        lblGenerarReportesCursos.setFont(new java.awt.Font("Segoe UI", 1, 60)); // NOI18N
        lblGenerarReportesCursos.setForeground(new java.awt.Color(242, 242, 242));
        lblGenerarReportesCursos.setText("GENERAR REPORTE CURSOS");

        lblFechaInicio.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblFechaInicio.setForeground(new java.awt.Color(242, 242, 242));
        lblFechaInicio.setText("Fecha Inicio:");

        txtFechaInicio.setBackground(new java.awt.Color(99, 99, 99));
        txtFechaInicio.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        txtFechaInicio.setForeground(new java.awt.Color(255, 255, 255));
        txtFechaInicio.addActionListener(this::txtFechaInicioActionPerformed);

        lblFechaFin.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblFechaFin.setForeground(new java.awt.Color(242, 242, 242));
        lblFechaFin.setText("Fecha Fin:");

        txtFechaFin.setBackground(new java.awt.Color(99, 99, 99));
        txtFechaFin.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        txtFechaFin.setForeground(new java.awt.Color(242, 242, 242));
        txtFechaFin.addActionListener(this::txtFechaFinActionPerformed);

        lblCantidadMin.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblCantidadMin.setForeground(new java.awt.Color(242, 242, 242));
        lblCantidadMin.setText("Cantidad Min:");

        txtCantidadMin.setBackground(new java.awt.Color(99, 99, 99));
        txtCantidadMin.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        txtCantidadMin.setForeground(new java.awt.Color(242, 242, 242));
        txtCantidadMin.addActionListener(this::txtCantidadMinActionPerformed);

        lblCurso.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblCurso.setForeground(new java.awt.Color(242, 242, 242));
        lblCurso.setText("Curso:");

        cmbCurso.setBackground(new java.awt.Color(99, 99, 99));
        cmbCurso.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        cmbCurso.setForeground(new java.awt.Color(242, 242, 242));
        cmbCurso.addActionListener(this::cmbCursoActionPerformed);

        btnBuscar.setBackground(new java.awt.Color(61, 173, 255));
        btnBuscar.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnBuscar.setForeground(new java.awt.Color(255, 255, 255));
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(this::btnBuscarActionPerformed);

        jTable1.setBackground(new java.awt.Color(99, 99, 99));
        jTable1.setForeground(new java.awt.Color(255, 255, 255));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Curso", "Horario", "Dias", "Cantidad", "Fecha"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        btnExportarPDF.setBackground(new java.awt.Color(255, 0, 0));
        btnExportarPDF.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnExportarPDF.setForeground(new java.awt.Color(255, 255, 255));
        btnExportarPDF.setText("Exportar PDF");
        btnExportarPDF.addActionListener(this::btnExportarPDFActionPerformed);

        btnVolver.setBackground(new java.awt.Color(255, 0, 0));
        btnVolver.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnVolver.setForeground(new java.awt.Color(255, 255, 255));
        btnVolver.setText("Volver");
        btnVolver.addActionListener(this::btnVolverActionPerformed);

        javax.swing.GroupLayout pnlNegroLayout = new javax.swing.GroupLayout(pnlNegro);
        pnlNegro.setLayout(pnlNegroLayout);
        pnlNegroLayout.setHorizontalGroup(
            pnlNegroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1392, Short.MAX_VALUE)
            .addGroup(pnlNegroLayout.createSequentialGroup()
                .addGroup(pnlNegroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlNegroLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnExportarPDF)
                        .addGap(449, 449, 449)
                        .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlNegroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(pnlNegroLayout.createSequentialGroup()
                            .addGap(226, 226, 226)
                            .addComponent(lblGenerarReportesCursos))
                        .addGroup(pnlNegroLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(lblFechaInicio)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(lblFechaFin)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtFechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(lblCantidadMin)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtCantidadMin, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(lblCurso)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(cmbCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(pnlNegroLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jScrollPane1))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlNegroLayout.setVerticalGroup(
            pnlNegroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNegroLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblGenerarReportesCursos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlNegroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFechaInicio)
                    .addComponent(txtFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblFechaFin)
                    .addComponent(txtFechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCantidadMin)
                    .addComponent(txtCantidadMin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCurso)
                    .addComponent(cmbCurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 750, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlNegroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnExportarPDF)
                    .addComponent(btnVolver))
                .addContainerGap())
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

    private void txtFechaInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechaInicioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaInicioActionPerformed

    private void txtFechaFinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechaFinActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaFinActionPerformed

    private void txtCantidadMinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCantidadMinActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCantidadMinActionPerformed

    private void cmbCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCursoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbCursoActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        if (txtFechaInicio.getText().trim().isEmpty() || txtFechaFin.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Las fechas son obligatorias. Formato: dd/MM/yyyy", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            sdf.setLenient(false);

            Date fechaInicio = sdf.parse(txtFechaInicio.getText().trim());
            Date fechaFin = sdf.parse(txtFechaFin.getText().trim());

            if (fechaInicio.after(fechaFin)) {
                JOptionPane.showMessageDialog(this, "La fecha inicio no puede ser mayor a la fecha fin.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Integer cantidadMin = null;
            if (!txtCantidadMin.getText().trim().isEmpty()) {
                cantidadMin = Integer.parseInt(txtCantidadMin.getText().trim());
            }

            // Obtener id del curso seleccionado
            String idCursoFiltro = null;
            String cursoSeleccionado = cmbCurso.getSelectedItem().toString();
            if (!cursoSeleccionado.equals("TODOS")) {
                List<CursoDTO> cursos = control.obtenerCursos();
                for (CursoDTO c : cursos) {
                    if (c.getNombre().equalsIgnoreCase(cursoSeleccionado)) {
                        idCursoFiltro = c.getIdCurso();
                        break;
                    }
                }
            }

            // Cupo minimo
            int cupoMinimo = 0;
            if (!txtCantidadMin.getText().trim().isEmpty()) {
                cupoMinimo = Integer.parseInt(txtCantidadMin.getText().trim());
            }

            DatosReporteDTO filtros = new DatosReporteDTO(fechaInicio, fechaFin, cupoMinimo, null, idCursoFiltro);

            ReporteDTO reporte = control.generarReporte(filtros);

            if (reporte == null || reporte.getHorarios() == null || reporte.getHorarios().isEmpty()) {
                limpiarTabla();
                JOptionPane.showMessageDialog(this, "No se encontraron resultados con esos filtros.", "Sin resultados", JOptionPane.INFORMATION_MESSAGE);
                return;
            }

            llenarTabla(reporte, sdf);

        } catch (ParseException e) {
            JOptionPane.showMessageDialog(this, "Formato de fecha inválido. Usa dd/MM/yyyy (ej. 01/04/2026)", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "La cantidad mínima debe ser un número entero.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnExportarPDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportarPDFActionPerformed
        if (jTable1.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "No hay datos para exportar. Haz una búsqueda primero.", "Sin datos", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // El usuario elige dónde guardar
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Guardar Reporte PDF");
        fileChooser.setFileFilter(new FileNameExtensionFilter("PDF", "pdf"));
        fileChooser.setSelectedFile(new File("reporte_cursos.pdf"));

        int resultado = fileChooser.showSaveDialog(this);

        if (resultado != JFileChooser.APPROVE_OPTION) {
            return; // cancelo
        }

        String ruta = fileChooser.getSelectedFile().getAbsolutePath();

        // Asegurar que termine en .pdf
        if (!ruta.toLowerCase().endsWith(".pdf")) {
            ruta += ".pdf";
        }

        try {
            exportarPDF(ruta);
            JOptionPane.showMessageDialog(this, "PDF exportado correctamente en:\n" + ruta, "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al exportar PDF: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnExportarPDFActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        control.navegarMenuAdmin();
    }//GEN-LAST:event_btnVolverActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnExportarPDF;
    private javax.swing.JButton btnVolver;
    private javax.swing.JComboBox<String> cmbCurso;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblCantidadMin;
    private javax.swing.JLabel lblCurso;
    private javax.swing.JLabel lblFechaFin;
    private javax.swing.JLabel lblFechaInicio;
    private javax.swing.JLabel lblGenerarReportesCursos;
    private javax.swing.JPanel pnlNegro;
    private javax.swing.JTextField txtCantidadMin;
    private javax.swing.JTextField txtFechaFin;
    private javax.swing.JTextField txtFechaInicio;
    // End of variables declaration//GEN-END:variables
}
