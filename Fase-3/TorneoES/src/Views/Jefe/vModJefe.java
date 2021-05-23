/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views.Jefe;

import UML.Jefe;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author 1GDAW04
 */
public class vModJefe extends javax.swing.JFrame {

    String dni;
    String nombre;
    String apellido;
    LocalDate fechaNacimiento;
    String sueldo;
    String telefono;
    LocalDate fechaContrato;
    LocalDate fechaFinContrato;
    String nacionalidad;
    
    
    public vModJefe(int idPersona) {
        try {
            initComponents();
            
            
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
            panelContenedor.setLocation(((d1.width-100)/2)-(panelContenedor.getWidth()/2), (d1.height/2)-(panelContenedor.getHeight()/2));
            
            colocarDatos(BD.tablaJefes.JefeByIdJefe(idPersona));
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Ha ocurido un error inesperado: " + ex.getMessage());
        }
        
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
        tfDni = new org.edisoncor.gui.textField.TextFieldRound();
        jLabel2 = new javax.swing.JLabel();
        tfNombre = new org.edisoncor.gui.textField.TextFieldRound();
        jLabel3 = new javax.swing.JLabel();
        tfApellido = new org.edisoncor.gui.textField.TextFieldRound();
        jLabel4 = new javax.swing.JLabel();
        dpFechaNacimiento = new com.github.lgooddatepicker.components.DatePicker();
        jLabel5 = new javax.swing.JLabel();
        tfSueldo = new org.edisoncor.gui.textField.TextFieldRound();
        jLabel6 = new javax.swing.JLabel();
        tfTelefono = new org.edisoncor.gui.textField.TextFieldRound();
        jLabel7 = new javax.swing.JLabel();
        dpFechaContrato = new com.github.lgooddatepicker.components.DatePicker();
        jLabel8 = new javax.swing.JLabel();
        dpFechaFinContrato = new com.github.lgooddatepicker.components.DatePicker();
        jLabel9 = new javax.swing.JLabel();
        tfNacionalidad = new org.edisoncor.gui.textField.TextFieldRound();
        bGuardar = new org.edisoncor.gui.button.ButtonAction();
        labelRect2 = new org.edisoncor.gui.label.LabelRect();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelGeneral.setColorPrimario(new java.awt.Color(255, 255, 255));
        panelGeneral.setColorSecundario(new java.awt.Color(255, 178, 97));

        panelContenedor.setMaximumSize(new java.awt.Dimension(400, 400));
        panelContenedor.setOpaque(false);

        panelFormulario.setOpaque(false);
        panelFormulario.setLayout(new java.awt.GridLayout(5, 4, 30, 25));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("DNI:");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        panelFormulario.add(jLabel1);

        tfDni.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        tfDni.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tfDni.setCaretColor(new java.awt.Color(255, 204, 102));
        tfDni.setDisabledTextColor(new java.awt.Color(255, 204, 153));
        tfDni.setSelectionColor(new java.awt.Color(255, 153, 102));
        panelFormulario.add(tfDni);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Nombre:");
        panelFormulario.add(jLabel2);

        tfNombre.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tfNombre.setCaretColor(new java.awt.Color(255, 204, 102));
        tfNombre.setDisabledTextColor(new java.awt.Color(255, 204, 153));
        tfNombre.setSelectionColor(new java.awt.Color(255, 153, 102));
        panelFormulario.add(tfNombre);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Apellido:");
        panelFormulario.add(jLabel3);

        tfApellido.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tfApellido.setCaretColor(new java.awt.Color(255, 204, 102));
        tfApellido.setDisabledTextColor(new java.awt.Color(255, 204, 153));
        tfApellido.setSelectionColor(new java.awt.Color(255, 153, 102));
        panelFormulario.add(tfApellido);

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Fecha Nacimiento:");
        panelFormulario.add(jLabel4);
        panelFormulario.add(dpFechaNacimiento);

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Sueldo:");
        panelFormulario.add(jLabel5);

        tfSueldo.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tfSueldo.setCaretColor(new java.awt.Color(255, 204, 102));
        tfSueldo.setDisabledTextColor(new java.awt.Color(255, 204, 153));
        tfSueldo.setSelectionColor(new java.awt.Color(255, 153, 102));
        panelFormulario.add(tfSueldo);

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Telefono");
        panelFormulario.add(jLabel6);

        tfTelefono.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tfTelefono.setCaretColor(new java.awt.Color(255, 204, 102));
        tfTelefono.setDisabledTextColor(new java.awt.Color(255, 204, 153));
        tfTelefono.setSelectionColor(new java.awt.Color(255, 153, 102));
        panelFormulario.add(tfTelefono);

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Fecha Contrato:");
        panelFormulario.add(jLabel7);
        panelFormulario.add(dpFechaContrato);

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Fecha Fin Contrato:");
        panelFormulario.add(jLabel8);
        panelFormulario.add(dpFechaFinContrato);

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Nacionalidad:");
        panelFormulario.add(jLabel9);

        tfNacionalidad.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tfNacionalidad.setCaretColor(new java.awt.Color(255, 204, 102));
        tfNacionalidad.setDisabledTextColor(new java.awt.Color(255, 204, 153));
        tfNacionalidad.setSelectionColor(new java.awt.Color(255, 153, 102));
        panelFormulario.add(tfNacionalidad);

        bGuardar.setText("Guardar");
        bGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bGuardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelContenedorLayout = new javax.swing.GroupLayout(panelContenedor);
        panelContenedor.setLayout(panelContenedorLayout);
        panelContenedorLayout.setHorizontalGroup(
            panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelContenedorLayout.createSequentialGroup()
                .addComponent(panelFormulario, javax.swing.GroupLayout.PREFERRED_SIZE, 871, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelContenedorLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(330, 330, 330))
        );
        panelContenedorLayout.setVerticalGroup(
            panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelContenedorLayout.createSequentialGroup()
                .addComponent(panelFormulario, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66)
                .addComponent(bGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(254, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelGeneralLayout = new javax.swing.GroupLayout(panelGeneral);
        panelGeneral.setLayout(panelGeneralLayout);
        panelGeneralLayout.setHorizontalGroup(
            panelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelContenedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        panelGeneralLayout.setVerticalGroup(
            panelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelContenedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        labelRect2.setText("Formulario editar datos jefe");
        labelRect2.setBackground(new java.awt.Color(255, 153, 0));
        labelRect2.setColorDeBorde(new java.awt.Color(255, 153, 51));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelRect2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelGeneral, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(labelRect2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panelGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bGuardarActionPerformed
        dni = tfDni.getText();
        nombre = tfNombre.getText();
        apellido = tfApellido.getText();
        fechaNacimiento = dpFechaNacimiento.getDate();
        sueldo = tfSueldo.getText();
        telefono = tfTelefono.getText();
        fechaContrato = dpFechaContrato.getDate();
        fechaFinContrato = dpFechaFinContrato.getDate();
        nacionalidad = tfNacionalidad.getText();
        if(validarDatos()){
            try {
                torneoes.TorneoES.insertarJefe(dni, nombre, apellido, fechaNacimiento, Double.parseDouble(sueldo), telefono, fechaContrato, fechaFinContrato, nacionalidad);
                System.out.println("Se ha insertado el jefe en la BD.");
            } catch (Exception ex) {
                System.out.println("Ha habido un problema al insertar el jefe en la BD.");
                System.out.println(ex.getMessage() +ex.getClass());
            }
        }
    }//GEN-LAST:event_bGuardarActionPerformed

    public boolean validarDatos(){        
        try{
            if(dni.matches("[0-9]{8}[a-z A-Z]{1}")){
                if(nombre.matches("[a-zA-Z]{3,}")){
                    if(apellido.matches("[a-zA-Z]{3,}")){
                        if(sueldo.matches("\\d{3,6}")){
                            if(telefono.matches("\\d{9}")){
                                if(fechaFinContrato.isAfter(fechaContrato)){
                                    if(!nacionalidad.isEmpty()){
                                        return true;
                                    }else{
                                        throw new Excepciones.Java.campoVacio("El campo nacionalidad no puede estar vacio");
                                    }
                                }else{
                                throw new Exception("La fecha fin contrato no puede ser anterior a la fecha de inicio del contrato");
                            }
                            }else{
                                throw new Excepciones.Java.formatoNoValido("El campo telefono no tiene el formato correcto");
                            }
                        }else{
                            throw new Excepciones.Java.formatoNoValido("El campo sueldo solo admite digitos con un minimo de 3 y maximo de 6 digitos");
                        }
                    }else{
                        throw new Excepciones.Java.formatoNoValido("El campo apellido ha de tener mas de 3 caracteres");
                    }
                }else{
                    throw new Excepciones.Java.formatoNoValido("El campo nombre ha de tener mas de 3 caracteres");
                }
            }else{
                throw new Excepciones.Java.formatoNoValido("El campo DNI no tiene el formato correcto");
            }
        }
        catch(Exception ex){
                JOptionPane.showMessageDialog(this, ex.getMessage());
                return false;
        }
    }
    
    public void colocarDatos(Jefe j){
        tfDni.setText(j.getDni());
        tfNombre.setText(j.getNombre());
        tfApellido.setText(j.getApellido());
        dpFechaNacimiento.setDate(j.getFechaNacimiento());
        tfSueldo.setText(String.valueOf(j.getSueldo()));
        tfTelefono.setText(j.getTelefono());
        dpFechaContrato.setDate(j.getFechaContrato());
        dpFechaFinContrato.setDate(j.getFechaFinContrato());
        tfNacionalidad.setText(j.getNacionalidad());
    }
    
    
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.edisoncor.gui.button.ButtonAction bGuardar;
    private com.github.lgooddatepicker.components.DatePicker dpFechaContrato;
    private com.github.lgooddatepicker.components.DatePicker dpFechaFinContrato;
    private com.github.lgooddatepicker.components.DatePicker dpFechaNacimiento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private org.edisoncor.gui.label.LabelRect labelRect2;
    private javax.swing.JPanel panelContenedor;
    private javax.swing.JPanel panelFormulario;
    private org.edisoncor.gui.panel.Panel panelGeneral;
    private org.edisoncor.gui.textField.TextFieldRound tfApellido;
    private org.edisoncor.gui.textField.TextFieldRound tfDni;
    private org.edisoncor.gui.textField.TextFieldRound tfNacionalidad;
    private org.edisoncor.gui.textField.TextFieldRound tfNombre;
    private org.edisoncor.gui.textField.TextFieldRound tfSueldo;
    private org.edisoncor.gui.textField.TextFieldRound tfTelefono;
    // End of variables declaration//GEN-END:variables
}
