/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Todo;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

/**
 *clase para definir la interfaz grafica.
 * @author ACR
 */
public class GraficaUI extends javax.swing.JFrame {
    Graficador plot;
    Ordenador valores;
    /**
     * Creates new form GraficaUI
     * @throws java.io.IOException
     */
    public GraficaUI() throws IOException {
        initComponents();
        plot = new Graficador(espacio);
        valores = new Ordenador();
    }

    public static void scalaImagen(javax.swing.JLabel label)
    {
        if(label.getIcon()==null) return; //no hacer nada si no hay imagen
        javax.swing.Icon i = label.getIcon();
        ImageIcon icon = (ImageIcon) i;
        java.awt.Image image = icon.getImage().getScaledInstance(label.getWidth(), 
             label.getHeight(), java.awt.Image.SCALE_SMOOTH);
        label.setIcon(new javax.swing.ImageIcon(image));
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        paraGrafica = new javax.swing.JFrame();
        espacio = new javax.swing.JPanel();
        fondo2 = new javax.swing.JLabel();
        titulo = new javax.swing.JLabel();
        JRBquicksort = new javax.swing.JRadioButton();
        JRBmergesort = new javax.swing.JRadioButton();
        JRBsort = new javax.swing.JRadioButton();
        JRBparallelsort = new javax.swing.JRadioButton();
        regenerarB = new javax.swing.JButton();
        graficarB = new javax.swing.JButton();
        fondo = new javax.swing.JLabel();

        paraGrafica.setPreferredSize(new java.awt.Dimension(800, 510));
        paraGrafica.setSize(new java.awt.Dimension(800, 510));

        espacio.setLayout(new javax.swing.BoxLayout(espacio, javax.swing.BoxLayout.LINE_AXIS));

        fondo2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/fondoLindo.png"))); // NOI18N
        fondo2.setText("jLabel2");

        javax.swing.GroupLayout paraGraficaLayout = new javax.swing.GroupLayout(paraGrafica.getContentPane());
        paraGrafica.getContentPane().setLayout(paraGraficaLayout);
        paraGraficaLayout.setHorizontalGroup(
            paraGraficaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paraGraficaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(espacio, javax.swing.GroupLayout.DEFAULT_SIZE, 774, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(paraGraficaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(fondo2, javax.swing.GroupLayout.DEFAULT_SIZE, 786, Short.MAX_VALUE))
        );
        paraGraficaLayout.setVerticalGroup(
            paraGraficaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paraGraficaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(espacio, javax.swing.GroupLayout.DEFAULT_SIZE, 482, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(paraGraficaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paraGraficaLayout.createSequentialGroup()
                    .addContainerGap(9, Short.MAX_VALUE)
                    .addComponent(fondo2, javax.swing.GroupLayout.PREFERRED_SIZE, 476, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(9, Short.MAX_VALUE)))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setForeground(new java.awt.Color(204, 204, 204));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        titulo.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
        titulo.setText("Analisis De Ordenamientos");
        getContentPane().add(titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 180, 30));

        JRBquicksort.setText("Resultados QuickSort");
        getContentPane().add(JRBquicksort, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, -1, -1));

        JRBmergesort.setText("Resultados MergeSort");
        getContentPane().add(JRBmergesort, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, -1, -1));

        JRBsort.setText("Resultados Sort");
        getContentPane().add(JRBsort, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, -1, -1));

        JRBparallelsort.setText("Resultados ParallelSort");
        JRBparallelsort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JRBparallelsortActionPerformed(evt);
            }
        });
        getContentPane().add(JRBparallelsort, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, -1, -1));

        regenerarB.setText("Regenerar Valores");
        regenerarB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regenerarBActionPerformed(evt);
            }
        });
        getContentPane().add(regenerarB, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 140, -1));

        graficarB.setText("Graficar Resultados");
        graficarB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                graficarBActionPerformed(evt);
            }
        });
        getContentPane().add(graficarB, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 140, -1));

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/fondoLindo.png"))); // NOI18N
        fondo.setText("jLabel1");
        getContentPane().add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 260));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JRBparallelsortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JRBparallelsortActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JRBparallelsortActionPerformed

    private void regenerarBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regenerarBActionPerformed
        try {
            valores.realizarExperimentos();
        } catch (IOException ex) {
            Logger.getLogger(GraficaUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_regenerarBActionPerformed

    private void graficarBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_graficarBActionPerformed
        plot.limpiar();
            try {
                if(JRBquicksort.isSelected()) plot.agregarResultadosQuickSort();
                if(JRBmergesort.isSelected()) plot.agregarResultadosMergeSort();
                if(JRBsort.isSelected()) plot.agregarResultadosSort();
                if(JRBparallelsort.isSelected()) plot.agregarResultadosParallelSort();
            } catch (IOException ex) {
                Logger.getLogger(GraficaUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        plot.graficar();
        paraGrafica.setVisible(true);
    }//GEN-LAST:event_graficarBActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GraficaUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GraficaUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GraficaUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GraficaUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            try {
                new GraficaUI().setVisible(true);
            } catch (IOException ex) {
                Logger.getLogger(GraficaUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton JRBmergesort;
    private javax.swing.JRadioButton JRBparallelsort;
    private javax.swing.JRadioButton JRBquicksort;
    private javax.swing.JRadioButton JRBsort;
    private javax.swing.JPanel espacio;
    private javax.swing.JLabel fondo;
    private javax.swing.JLabel fondo2;
    private javax.swing.JButton graficarB;
    private javax.swing.JFrame paraGrafica;
    private javax.swing.JButton regenerarB;
    private javax.swing.JLabel titulo;
    // End of variables declaration//GEN-END:variables
}
