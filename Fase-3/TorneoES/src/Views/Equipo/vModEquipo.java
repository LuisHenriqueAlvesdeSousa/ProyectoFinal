/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views.Equipo;

import Excepciones.Java.campoVacio;
import Excepciones.Java.formatoNoValido;
import UML.Equipo;
import javax.swing.JOptionPane;

/**
 *
 * @author 1GDAW04
 */
public class vModEquipo extends javax.swing.JFrame {

    /**
     * Creates new form vModEquipo
     */
    public vModEquipo(Equipo e) throws Exception{
        initComponents();
        Equipo equipoActual = e;
        tfIdEquipo.setText(String.valueOf(equipoActual.getIdEquipo()));
        tfNombre.setText(equipoActual.getNombre());
        tfPais.setText(equipoActual.getPais());
        tfIdJefe.setText(String.valueOf(equipoActual.getJefe().getIdPersona()));
        tfIdPreparador.setText(String.valueOf(equipoActual.getPreparador().getIdPersona()));
        tfIdEntrenador.setText(String.valueOf(equipoActual.getEntrenador().getIdPersona()));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Actualizar = new org.edisoncor.gui.panel.Panel();
        panelContenedor = new javax.swing.JPanel();
        panelContenedor1 = new javax.swing.JPanel();
        panelFormulario = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tfIdEquipo = new org.edisoncor.gui.textField.TextFieldRound();
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
        bActualizar = new org.edisoncor.gui.button.ButtonAction();
        labelRect2 = new org.edisoncor.gui.label.LabelRect();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Actualizar.setColorPrimario(new java.awt.Color(255, 255, 255));
        Actualizar.setColorSecundario(new java.awt.Color(255, 178, 97));

        panelContenedor.setOpaque(false);

        panelContenedor1.setOpaque(false);

        panelFormulario.setOpaque(false);
        panelFormulario.setLayout(new java.awt.GridLayout(5, 4, 30, 25));

        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("ID Equipo");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        panelFormulario.add(jLabel1);

        tfIdEquipo.setEditable(false);
        tfIdEquipo.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tfIdEquipo.setCaretColor(new java.awt.Color(255, 204, 102));
        tfIdEquipo.setDisabledTextColor(new java.awt.Color(255, 204, 153));
        tfIdEquipo.setSelectionColor(new java.awt.Color(255, 153, 102));
        panelFormulario.add(tfIdEquipo);

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

        tfIdJefe.setEditable(false);
        tfIdJefe.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tfIdJefe.setCaretColor(new java.awt.Color(255, 204, 102));
        tfIdJefe.setDisabledTextColor(new java.awt.Color(255, 204, 153));
        tfIdJefe.setSelectionColor(new java.awt.Color(255, 153, 102));
        panelFormulario.add(tfIdJefe);

        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("ID Preparador");
        panelFormulario.add(jLabel5);

        tfIdPreparador.setEditable(false);
        tfIdPreparador.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tfIdPreparador.setCaretColor(new java.awt.Color(255, 204, 102));
        tfIdPreparador.setDisabledTextColor(new java.awt.Color(255, 204, 153));
        tfIdPreparador.setSelectionColor(new java.awt.Color(255, 153, 102));
        panelFormulario.add(tfIdPreparador);

        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("ID Entrenador");
        panelFormulario.add(jLabel6);

        tfIdEntrenador.setEditable(false);
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

        javax.swing.GroupLayout panelContenedor1Layout = new javax.swing.GroupLayout(panelContenedor1);
        panelContenedor1.setLayout(panelContenedor1Layout);
        panelContenedor1Layout.setHorizontalGroup(
            panelContenedor1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelContenedor1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelContenedor1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelContenedor1Layout.createSequentialGroup()
                        .addComponent(panelFormulario, javax.swing.GroupLayout.PREFERRED_SIZE, 424, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelContenedor1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(97, 97, 97))))
        );
        panelContenedor1Layout.setVerticalGroup(
            panelContenedor1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelContenedor1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(panelContenedor1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addComponent(panelFormulario, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(96, Short.MAX_VALUE))
        );

        bActualizar.setText("Actualizar");
        bActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bActualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelContenedorLayout = new javax.swing.GroupLayout(panelContenedor);
        panelContenedor.setLayout(panelContenedorLayout);
        panelContenedorLayout.setHorizontalGroup(
            panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelContenedorLayout.createSequentialGroup()
                .addGap(131, 131, 131)
                .addComponent(panelContenedor1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(132, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelContenedorLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelContenedorLayout.setVerticalGroup(
            panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelContenedorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelContenedor1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout ActualizarLayout = new javax.swing.GroupLayout(Actualizar);
        Actualizar.setLayout(ActualizarLayout);
        ActualizarLayout.setHorizontalGroup(
            ActualizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ActualizarLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(panelContenedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );
        ActualizarLayout.setVerticalGroup(
            ActualizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ActualizarLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panelContenedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41))
        );

        labelRect2.setBackground(new java.awt.Color(255, 153, 0));
        labelRect2.setText("Modficar Equipo");
        labelRect2.setColorDeBorde(new java.awt.Color(255, 153, 51));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelRect2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 922, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(Actualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(labelRect2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 499, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGap(0, 31, Short.MAX_VALUE)
                    .addComponent(Actualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 497, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bActualizarActionPerformed
        try{
            validaciones();
            torneoes.TorneoES.modificarEquipo(tfIdEquipo.getText(), tfNombre.getText(), tfPais.getText());
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
        if(tfNombre.getText().isEmpty())
            throw new campoVacio();
        
        if(!tfNombre.getText().matches("[a-z A-Z 0-9]{4,}"))
            throw new formatoNoValido();
    }
    
    private void validarPais() throws Exception{
        if(tfPais.getText().isEmpty())
            throw new campoVacio();
        
        if(!tfPais.getText().matches("[a-z A-Z 0-9]{4,}"))
            throw new formatoNoValido();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.edisoncor.gui.panel.Panel Actualizar;
    private org.edisoncor.gui.button.ButtonAction bActualizar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private org.edisoncor.gui.label.LabelRect labelRect2;
    private javax.swing.JPanel panelContenedor;
    private javax.swing.JPanel panelContenedor1;
    private javax.swing.JPanel panelFormulario;
    private org.edisoncor.gui.textField.TextFieldRound tfIdEntrenador;
    private org.edisoncor.gui.textField.TextFieldRound tfIdEquipo;
    private org.edisoncor.gui.textField.TextFieldRound tfIdJefe;
    private org.edisoncor.gui.textField.TextFieldRound tfIdPreparador;
    private org.edisoncor.gui.textField.TextFieldRound tfNombre;
    private org.edisoncor.gui.textField.TextFieldRound tfPais;
    // End of variables declaration//GEN-END:variables
}
