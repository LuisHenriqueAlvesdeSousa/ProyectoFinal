/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views.Jefe;

import UML.Jefe;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author 1GDAW04
 */
public class vAllJefe extends javax.swing.JFrame {

    private static ArrayList<Jefe> jefes;
    
    public vAllJefe() {
        initComponents();
        llenarTextArea();
        this.setLocationRelativeTo(null);
        this.setAlwaysOnTop(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); 
        Dimension d1 = new Dimension(1000,500);
        Dimension d2 = new Dimension(900,400);
        this.setSize(d1);

        panelGeneral.setSize(d1);
        panelGeneral.setPreferredSize(d1);
        panelContenedor.setPreferredSize(d2);
        panelContenedor.setSize(d2);
        panelGeneral.setColorPrimario(Color.white);
        panelGeneral.setColorSecundario(Color.orange);
        panelGeneral.setLayout(null);
        panelContenedor.setLocation(((d1.width)/2)-(panelContenedor.getWidth()/2), (d1.height/2)-(panelContenedor.getHeight()/2));
        //taDatosJefes.disable();
            
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelRect2 = new org.edisoncor.gui.label.LabelRect();
        panelGeneral = new org.edisoncor.gui.panel.Panel();
        panelContenedor = new javax.swing.JPanel();
        panelDatos = new javax.swing.JScrollPane();
        taDatosJefes = new javax.swing.JTextArea();
        bFiltrar = new org.edisoncor.gui.button.ButtonAction();
        bBuscar = new org.edisoncor.gui.button.ButtonAction();
        tfFiltro = new org.edisoncor.gui.textField.TextFieldRound();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1000, 500));
        setMinimumSize(new java.awt.Dimension(1000, 500));
        setResizable(false);

        labelRect2.setBackground(new java.awt.Color(255, 153, 0));
        labelRect2.setText("Ventana informacion jefes");
        labelRect2.setColorDeBorde(new java.awt.Color(255, 153, 51));

        panelGeneral.setColorPrimario(new java.awt.Color(255, 255, 255));
        panelGeneral.setColorSecundario(new java.awt.Color(255, 178, 97));

        panelContenedor.setMaximumSize(new java.awt.Dimension(400, 400));
        panelContenedor.setOpaque(false);

        taDatosJefes.setColumns(20);
        taDatosJefes.setRows(5);
        panelDatos.setViewportView(taDatosJefes);

        bFiltrar.setText("Filtrar");
        bFiltrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bFiltrarActionPerformed(evt);
            }
        });

        bBuscar.setText("Buscar");
        bBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bBuscarActionPerformed(evt);
            }
        });

        tfFiltro.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tfFiltro.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        tfFiltro.setCaretColor(new java.awt.Color(255, 204, 102));
        tfFiltro.setDisabledTextColor(new java.awt.Color(255, 204, 153));
        tfFiltro.setSelectionColor(new java.awt.Color(255, 153, 102));

        javax.swing.GroupLayout panelContenedorLayout = new javax.swing.GroupLayout(panelContenedor);
        panelContenedor.setLayout(panelContenedorLayout);
        panelContenedorLayout.setHorizontalGroup(
            panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelContenedorLayout.createSequentialGroup()
                .addGap(150, 150, 150)
                .addComponent(bFiltrar, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(tfFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(bBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(113, Short.MAX_VALUE))
            .addComponent(panelDatos)
        );
        panelContenedorLayout.setVerticalGroup(
            panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelContenedorLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(panelDatos, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bFiltrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(bBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tfFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        javax.swing.GroupLayout panelGeneralLayout = new javax.swing.GroupLayout(panelGeneral);
        panelGeneral.setLayout(panelGeneralLayout);
        panelGeneralLayout.setHorizontalGroup(
            panelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelGeneralLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panelContenedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );
        panelGeneralLayout.setVerticalGroup(
            panelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGeneralLayout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(panelContenedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(134, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelRect2, javax.swing.GroupLayout.DEFAULT_SIZE, 887, Short.MAX_VALUE)
            .addComponent(panelGeneral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(labelRect2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bFiltrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bFiltrarActionPerformed
        String filtro = tfFiltro.getText();
        if(!filtro.isEmpty()){
            String datosJefe = filtarDatos(filtro);
            if(datosJefe!=null){
                taDatosJefes.setText(datosJefe);
            }
            else{
                JOptionPane.showMessageDialog(this, "No se han encontrado jefes relacionados con el filtro introducido.");
            }
        }
        else{
            JOptionPane.showMessageDialog(this, "Introduce un filtro sobre el que buscar.");
        }
    }//GEN-LAST:event_bFiltrarActionPerformed

    private void bBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bBuscarActionPerformed
        llenarTextArea();
    }//GEN-LAST:event_bBuscarActionPerformed
    
    
    private void llenarTextArea(){
        try {
            jefes = BD.tablaJefes.allJefe();
            String datosJefes = "";
            for(Jefe jefe : jefes){
                datosJefes+=jefe.toString();
                datosJefes+="\n";
            }
            taDatosJefes.setText(datosJefes);
        }catch(java.lang.NullPointerException ex){
            JOptionPane.showMessageDialog(this, "Ha ocurido un error relacionado con la base de datos");           
            this.dispose();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error inseperado:" + ex.getMessage());
        }
    }
    
    private String filtarDatos(String cadena){
        String totalLineas = "";
            for(Jefe jefe : jefes){
                String linea=jefe.toString();
                if(linea.matches(".*" + cadena + ".*") || linea.matches(".*" + cadena.toUpperCase() + ".*")){
                    totalLineas += linea + "\n";
                }
            }
            if(totalLineas!=""){
                return totalLineas;
            }
            else{
                return null;
            }
    }
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
            java.util.logging.Logger.getLogger(vAllJefe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(vAllJefe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(vAllJefe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(vAllJefe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new vAllJefe().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.edisoncor.gui.button.ButtonAction bBuscar;
    private org.edisoncor.gui.button.ButtonAction bFiltrar;
    private org.edisoncor.gui.label.LabelRect labelRect2;
    private javax.swing.JPanel panelContenedor;
    private javax.swing.JScrollPane panelDatos;
    private org.edisoncor.gui.panel.Panel panelGeneral;
    private javax.swing.JTextArea taDatosJefes;
    private org.edisoncor.gui.textField.TextFieldRound tfFiltro;
    // End of variables declaration//GEN-END:variables
}
