/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views.Equipo;

import Excepciones.Java.campoVacio;
import Excepciones.Java.formatoNoValido;
import javax.swing.JOptionPane;

/**
 *
 * @author 1GDAW04
 */
public class vCrearEquipo extends javax.swing.JFrame {

    /**
     * Creates new form vCrearEquipo
     */
    public vCrearEquipo() {
        initComponents();
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
        panelFormulario = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        tfPais = new org.edisoncor.gui.textField.TextFieldRound();
        jLabel4 = new javax.swing.JLabel();
        tfIdJefe = new org.edisoncor.gui.textField.TextFieldRound();
        jLabel5 = new javax.swing.JLabel();
        tfIdPreparador = new org.edisoncor.gui.textField.TextFieldRound();
        jLabel6 = new javax.swing.JLabel();
        tfIdEntrenador = new org.edisoncor.gui.textField.TextFieldRound();
        tfNombre = new org.edisoncor.gui.textField.TextFieldRound();
        jLabel2 = new javax.swing.JLabel();
        bGuardar = new org.edisoncor.gui.button.ButtonAction();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        labelRect2.setBackground(new java.awt.Color(255, 153, 0));
        labelRect2.setText("Formulario nuevo Equipo");
        labelRect2.setColorDeBorde(new java.awt.Color(255, 153, 51));

        panelGeneral.setColorPrimario(new java.awt.Color(255, 255, 255));
        panelGeneral.setColorSecundario(new java.awt.Color(255, 178, 97));

        panelContenedor.setOpaque(false);

        panelFormulario.setOpaque(false);
        panelFormulario.setLayout(new java.awt.GridLayout(5, 4, 30, 25));

        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Pais");
        panelFormulario.add(jLabel3);

        tfPais.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tfPais.setCaretColor(new java.awt.Color(255, 204, 102));
        tfPais.setDisabledTextColor(new java.awt.Color(255, 204, 153));
        tfPais.setSelectionColor(new java.awt.Color(255, 153, 102));
        panelFormulario.add(tfPais);

        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("ID Jefe");
        panelFormulario.add(jLabel4);

        tfIdJefe.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tfIdJefe.setCaretColor(new java.awt.Color(255, 204, 102));
        tfIdJefe.setDisabledTextColor(new java.awt.Color(255, 204, 153));
        tfIdJefe.setSelectionColor(new java.awt.Color(255, 153, 102));
        panelFormulario.add(tfIdJefe);

        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("ID Preparador");
        panelFormulario.add(jLabel5);

        tfIdPreparador.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tfIdPreparador.setCaretColor(new java.awt.Color(255, 204, 102));
        tfIdPreparador.setDisabledTextColor(new java.awt.Color(255, 204, 153));
        tfIdPreparador.setSelectionColor(new java.awt.Color(255, 153, 102));
        panelFormulario.add(tfIdPreparador);

        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("ID Entrenador");
        panelFormulario.add(jLabel6);

        tfIdEntrenador.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tfIdEntrenador.setCaretColor(new java.awt.Color(255, 204, 102));
        tfIdEntrenador.setDisabledTextColor(new java.awt.Color(255, 204, 153));
        tfIdEntrenador.setSelectionColor(new java.awt.Color(255, 153, 102));
        panelFormulario.add(tfIdEntrenador);

        tfNombre.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tfNombre.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        tfNombre.setCaretColor(new java.awt.Color(255, 204, 102));
        tfNombre.setDisabledTextColor(new java.awt.Color(255, 204, 153));
        tfNombre.setSelectionColor(new java.awt.Color(255, 153, 102));

        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Nombre");

        javax.swing.GroupLayout panelContenedorLayout = new javax.swing.GroupLayout(panelContenedor);
        panelContenedor.setLayout(panelContenedorLayout);
        panelContenedorLayout.setHorizontalGroup(
            panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelContenedorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panelFormulario, javax.swing.GroupLayout.PREFERRED_SIZE, 424, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelContenedorLayout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(103, Short.MAX_VALUE))
        );
        panelContenedorLayout.setVerticalGroup(
            panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelContenedorLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addComponent(panelFormulario, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(96, Short.MAX_VALUE))
        );

        bGuardar.setText("Añadir");
        bGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bGuardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelGeneralLayout = new javax.swing.GroupLayout(panelGeneral);
        panelGeneral.setLayout(panelGeneralLayout);
        panelGeneralLayout.setHorizontalGroup(
            panelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGeneralLayout.createSequentialGroup()
                .addGap(160, 160, 160)
                .addComponent(panelContenedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(205, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelGeneralLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(117, 117, 117))
        );
        panelGeneralLayout.setVerticalGroup(
            panelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGeneralLayout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(panelContenedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(bGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(85, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelGeneral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(labelRect2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(labelRect2, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(panelGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bGuardarActionPerformed
    try{
        validaciones();
        torneoes.TorneoES.guardarEquipo(tfNombre.getText(), tfPais.getText(), tfIdPreparador.getText(), tfIdJefe.getText(), tfIdEntrenador.getText());
        torneoes.TorneoES.abrirVMainAdmin();
        dispose();
    }
    catch(Exception e){
        JOptionPane.showMessageDialog(null, "Error: " + e.getClass() +  " , " + e.getMessage());
    }
    }                                        
    public void validaciones() throws Exception{
        validarNombre();
        validarPais();
        validarPreparador();
        validarJefe();
        validarEntrenador();
    }
    
    public void validarNombre() throws Exception{
        if(tfNombre.getText().isEmpty())
            throw new campoVacio();
        
        if(!tfNombre.getText().matches("[a-z A-Z 0-9]{4,}"))
            throw new formatoNoValido();
    }
    
    public void validarPais() throws Exception{
        if(tfPais.getText().isEmpty())
            throw new campoVacio();
        
        if(!tfPais.getText().matches("[a-z A-Z 0-9]{4,}"))
            throw new formatoNoValido();
    }
    
    public void validarPreparador() throws Exception{
        if(tfIdPreparador.getText().isEmpty())
            throw new campoVacio();
        
        if(tfIdPreparador.getText().length() > 4)
            throw new formatoNoValido();
        
        Integer.parseInt(tfIdPreparador.getText());
    }
    
    public void validarJefe() throws Exception{
        if(tfIdJefe.getText().isEmpty())
            throw new campoVacio();
        
        if(tfIdJefe.getText().length() > 4)
            throw new formatoNoValido();
        
        Integer.parseInt(tfIdJefe.getText());
    }
    
    public void validarEntrenador() throws Exception{
        if(tfIdEntrenador.getText().isEmpty())
            throw new campoVacio();
        
        if(tfIdEntrenador.getText().length() > 4)
            throw new formatoNoValido();
        
        Integer.parseInt(tfIdEntrenador.getText());
    }//GEN-LAST:event_bGuardarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.edisoncor.gui.button.ButtonAction bGuardar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private org.edisoncor.gui.label.LabelRect labelRect2;
    private javax.swing.JPanel panelContenedor;
    private javax.swing.JPanel panelFormulario;
    private org.edisoncor.gui.panel.Panel panelGeneral;
    private org.edisoncor.gui.textField.TextFieldRound tfIdEntrenador;
    private org.edisoncor.gui.textField.TextFieldRound tfIdJefe;
    private org.edisoncor.gui.textField.TextFieldRound tfIdPreparador;
    private org.edisoncor.gui.textField.TextFieldRound tfNombre;
    private org.edisoncor.gui.textField.TextFieldRound tfPais;
    // End of variables declaration//GEN-END:variables
}
