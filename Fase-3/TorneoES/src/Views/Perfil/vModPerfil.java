/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views.Perfil;

import Excepciones.Java.campoVacio;
import Excepciones.Java.formatoNoValido;
import UML.Perfil;
import javax.swing.JOptionPane;

/**
 *
 * @author 1GDAW04
 */
public class vModPerfil extends javax.swing.JFrame {

    /**
     * Creates new form vModPerfil
     */
    public vModPerfil(Perfil p) throws Exception {
        initComponents();
        
        tfIdPerfil.setText(String.valueOf(p.getIdPerfil()));
        tfUsuario.setText(p.getUsuario());
        tfPass.setText(p.getPasswd());
        tfPrivilegio.setText(p.getPrivilegios());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelGeneral = new org.edisoncor.gui.panel.Panel();
        panelContenedor = new javax.swing.JPanel();
        panelFormulario = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tfIdPerfil = new org.edisoncor.gui.textField.TextFieldRound();
        jLabel2 = new javax.swing.JLabel();
        tfUsuario = new org.edisoncor.gui.textField.TextFieldRound();
        jLabel3 = new javax.swing.JLabel();
        tfPass = new org.edisoncor.gui.textField.TextFieldRound();
        jLabel5 = new javax.swing.JLabel();
        tfPrivilegio = new org.edisoncor.gui.textField.TextFieldRound();
        bActualizar = new org.edisoncor.gui.button.ButtonAction();
        labelRect2 = new org.edisoncor.gui.label.LabelRect();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        panelGeneral.setColorPrimario(new java.awt.Color(255, 255, 255));
        panelGeneral.setColorSecundario(new java.awt.Color(255, 178, 97));

        panelContenedor.setOpaque(false);

        panelFormulario.setOpaque(false);
        panelFormulario.setLayout(new java.awt.GridLayout(5, 4, 30, 25));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("ID Perfil");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        panelFormulario.add(jLabel1);

        tfIdPerfil.setEditable(false);
        tfIdPerfil.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tfIdPerfil.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        tfIdPerfil.setCaretColor(new java.awt.Color(255, 204, 102));
        tfIdPerfil.setDisabledTextColor(new java.awt.Color(255, 204, 153));
        tfIdPerfil.setSelectionColor(new java.awt.Color(255, 153, 102));
        panelFormulario.add(tfIdPerfil);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Usuario");
        panelFormulario.add(jLabel2);

        tfUsuario.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tfUsuario.setCaretColor(new java.awt.Color(255, 204, 102));
        tfUsuario.setDisabledTextColor(new java.awt.Color(255, 204, 153));
        tfUsuario.setSelectionColor(new java.awt.Color(255, 153, 102));
        panelFormulario.add(tfUsuario);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Contrase??a");
        panelFormulario.add(jLabel3);

        tfPass.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tfPass.setCaretColor(new java.awt.Color(255, 204, 102));
        tfPass.setDisabledTextColor(new java.awt.Color(255, 204, 153));
        tfPass.setSelectionColor(new java.awt.Color(255, 153, 102));
        panelFormulario.add(tfPass);

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Privilegio");
        panelFormulario.add(jLabel5);

        tfPrivilegio.setEditable(false);
        tfPrivilegio.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tfPrivilegio.setCaretColor(new java.awt.Color(255, 204, 102));
        tfPrivilegio.setDisabledTextColor(new java.awt.Color(255, 204, 153));
        tfPrivilegio.setSelectionColor(new java.awt.Color(255, 153, 102));
        panelFormulario.add(tfPrivilegio);

        javax.swing.GroupLayout panelContenedorLayout = new javax.swing.GroupLayout(panelContenedor);
        panelContenedor.setLayout(panelContenedorLayout);
        panelContenedorLayout.setHorizontalGroup(
            panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelContenedorLayout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addComponent(panelFormulario, javax.swing.GroupLayout.PREFERRED_SIZE, 575, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(194, Short.MAX_VALUE))
        );
        panelContenedorLayout.setVerticalGroup(
            panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelContenedorLayout.createSequentialGroup()
                .addGap(0, 24, Short.MAX_VALUE)
                .addComponent(panelFormulario, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        bActualizar.setText("Actualizar");
        bActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bActualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelGeneralLayout = new javax.swing.GroupLayout(panelGeneral);
        panelGeneral.setLayout(panelGeneralLayout);
        panelGeneralLayout.setHorizontalGroup(
            panelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGeneralLayout.createSequentialGroup()
                .addComponent(panelContenedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 65, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelGeneralLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(344, 344, 344))
        );
        panelGeneralLayout.setVerticalGroup(
            panelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGeneralLayout.createSequentialGroup()
                .addContainerGap(93, Short.MAX_VALUE)
                .addComponent(panelContenedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(bActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(102, 102, 102))
        );

        labelRect2.setBackground(new java.awt.Color(255, 153, 0));
        labelRect2.setText("Modificar Perfil");
        labelRect2.setColorDeBorde(new java.awt.Color(255, 153, 51));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelRect2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 922, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panelGeneral, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(labelRect2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 499, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGap(0, 27, Short.MAX_VALUE)
                    .addComponent(panelGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bActualizarActionPerformed
        try{
            validaciones();
            torneoes.TorneoES.modificarPerfil(tfIdPerfil.getText(), tfUsuario.getText(), tfPass.getText());
            torneoes.TorneoES.abrirVMainAdmin();
            dispose();
            
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error: " + e.getClass() + " , " + e.getMessage());
        }
    }//GEN-LAST:event_bActualizarActionPerformed
    private void validaciones() throws Exception{
        validarNombre();
        validarPais();
    }
    
    private void validarNombre() throws Exception{
        if(tfUsuario.getText().isEmpty())
            throw new campoVacio();
        
        if(!tfUsuario.getText().matches("[a-z A-Z 0-9]{4,}"))
            throw new formatoNoValido();
    }
    
    private void validarPais() throws Exception{
        if(tfPass.getText().isEmpty())
            throw new campoVacio();
        
        if(!tfPass.getText().matches("[a-z A-Z 0-9]{4,}"))
            throw new formatoNoValido();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.edisoncor.gui.button.ButtonAction bActualizar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private org.edisoncor.gui.label.LabelRect labelRect2;
    private javax.swing.JPanel panelContenedor;
    private javax.swing.JPanel panelFormulario;
    private org.edisoncor.gui.panel.Panel panelGeneral;
    private org.edisoncor.gui.textField.TextFieldRound tfIdPerfil;
    private org.edisoncor.gui.textField.TextFieldRound tfPass;
    private org.edisoncor.gui.textField.TextFieldRound tfPrivilegio;
    private org.edisoncor.gui.textField.TextFieldRound tfUsuario;
    // End of variables declaration//GEN-END:variables
}
