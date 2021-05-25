/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import UML.Equipo;
import UML.Jugador;
import UML.Perfil;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * Ventana que sirve como pasarela de preseleccion a otras ventanas o a la 
 * eliminacion de entidades
 * @author Equipo2
 * @version 1.0
 */
public class vSelector extends javax.swing.JDialog {
    /**
     * Ventana a la que se le redirigira despues de la selecion del objeto 
     * mediante combobox
     */
    String ventana;
    
    public vSelector(java.awt.Frame parent, boolean modal, String titulo, String label, String ventana) {
        super(parent, modal);
        this.ventana = ventana;
        try {
            initComponents();
            personalizarVentana(titulo, label);
            this.setLocationRelativeTo(null);
            this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); 
            Dimension d1 = new Dimension(450,200);
            Dimension d2 = new Dimension(350,100);
            this.setSize(d1);

            panelGeneral.setSize(d1);
            panelGeneral.setPreferredSize(d1);
            panelContenedor.setPreferredSize(d2);
            panelContenedor.setSize(d2);
            panelGeneral.setColorPrimario(Color.white);
            panelGeneral.setColorSecundario(Color.orange);
            panelGeneral.setLayout(null);
            panelContenedor.setLocation(((d1.width)/2)-(panelContenedor.getWidth()/2), (d1.height/2)-(panelContenedor.getHeight()/2));
            switch(ventana){
                case "modjefe":
                    torneoes.TorneoES.llenarComboBoxJefes(cbSeleccion);
                    break;
                case "borrarjefe":
                    torneoes.TorneoES.llenarComboBoxJefes(cbSeleccion);
                    break;
                case "borrartorneo":
                    torneoes.TorneoES.llenarComboBoxTorneos(cbSeleccion);
                    break;
                case "borrarperfil":
                    torneoes.TorneoES.llenarComboBoxPerfiles(cbSeleccion);
                    break;
                case "modperfil":
                    torneoes.TorneoES.llenarComboBoxPerfiles(cbSeleccion);
                    break;
                case "borrarequipo":
                    torneoes.TorneoES.llenarComboBoxEquipos(cbSeleccion);
                    break;
                case "modequipo":
                    torneoes.TorneoES.llenarComboBoxEquipos(cbSeleccion);
                    break;
                case "borrarjugador":
                    torneoes.TorneoES.llenarComboBoxJugadores(cbSeleccion);
                    break;
                case "modjugador":
                    torneoes.TorneoES.llenarComboBoxJugadores(cbSeleccion);
                    break;
                    
            }
        }catch(java.lang.NullPointerException ex){
            JOptionPane.showMessageDialog(this, "Ha ocurido un error relacionado con la base de datos");           
            this.dispose();
        }catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Ha ocurido un error inesperado: " + ex.getMessage() + ex.getClass());
            this.dispose();
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
        lTitulo = new org.edisoncor.gui.label.LabelRect();
        panelContenedor = new javax.swing.JPanel();
        bAceptar = new org.edisoncor.gui.button.ButtonAction();
        lSelector = new javax.swing.JLabel();
        cbSeleccion = new org.edisoncor.gui.comboBox.ComboBoxRect();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMaximumSize(null);
        setMinimumSize(null);
        setModal(true);
        setResizable(false);

        panelGeneral.setColorPrimario(new java.awt.Color(255, 255, 255));
        panelGeneral.setColorSecundario(new java.awt.Color(255, 153, 0));

        lTitulo.setBackground(new java.awt.Color(255, 153, 0));
        lTitulo.setText("Formulario nuevo jefe");
        lTitulo.setColorDeBorde(new java.awt.Color(255, 153, 51));
        lTitulo.setMaximumSize(new java.awt.Dimension(350, 17));
        lTitulo.setMinimumSize(new java.awt.Dimension(350, 17));

        panelContenedor.setOpaque(false);

        bAceptar.setText("Aceptar");
        bAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAceptarActionPerformed(evt);
            }
        });

        lSelector.setText("LabelManipulable");

        javax.swing.GroupLayout panelContenedorLayout = new javax.swing.GroupLayout(panelContenedor);
        panelContenedor.setLayout(panelContenedorLayout);
        panelContenedorLayout.setHorizontalGroup(
            panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelContenedorLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(lSelector)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbSeleccion, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(84, Short.MAX_VALUE))
        );
        panelContenedorLayout.setVerticalGroup(
            panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelContenedorLayout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbSeleccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lSelector))
                .addGap(29, 29, 29)
                .addComponent(bAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        javax.swing.GroupLayout panelGeneralLayout = new javax.swing.GroupLayout(panelGeneral);
        panelGeneral.setLayout(panelGeneralLayout);
        panelGeneralLayout.setHorizontalGroup(
            panelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 432, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(panelGeneralLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelContenedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelGeneralLayout.setVerticalGroup(
            panelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelGeneralLayout.createSequentialGroup()
                .addComponent(lTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addComponent(panelContenedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelGeneral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAceptarActionPerformed
        try {
            String seleccionado = String.valueOf(cbSeleccion.getSelectedItem());
            if(seleccionado!="null"){
                int id = Integer.parseInt(seleccionado.substring(0, seleccionado.indexOf(":")));
                switch(ventana){
                    case "modjefe":
                        torneoes.TorneoES.abrirVentanaModJefe(id);
                        break;
                    case "borrarjefe":
                        BD.tablaJefes.eliminarJefe(id);
                        JOptionPane.showMessageDialog(null, "Se ha eliminado el jefe seleccionado");
                    case "borrartorneo":
                        BD.tablaTorneos.eliminarTorneo(id);
                        JOptionPane.showMessageDialog(null, "Se ha eliminado el torneo seleccionado");
                    case "modequipo":
                        Equipo equipoActual = torneoes.TorneoES.obtenerEquipo(String.valueOf(id));
                        torneoes.TorneoES.abrirVModEquipo(equipoActual);
                        break;
                    case "borrarequipo":
                        BD.tablaEquipos.eliminarEquipo(String.valueOf(id));
                        JOptionPane.showMessageDialog(null, "Se ha borrado el equipo seleccionado");
                    case "modperfil":
                        Perfil perfilActual = torneoes.TorneoES.obtenerPerfil(String.valueOf(id));
                        torneoes.TorneoES.abrirVModPerfil(perfilActual);
                        break;
                    case "borrarperfil":
                        BD.tablaPerfiles.eliminarPerfil(String.valueOf(id));
                        JOptionPane.showMessageDialog(null, "Se ha borrado el perfil seleccionado");
                        break;
                    case "borrarjugador":
                        BD.tablaJugadores.eliminarJugador(id);
                        JOptionPane.showMessageDialog(null, "Se ha borrado el jugador seleccionado");
                        break;
                    case "modjugador":
                        Jugador jugadorActual = BD.tablaJugadores.consultaByIdPersona(id);
                        torneoes.TorneoES.abrirVModJugador(jugadorActual);
                        JOptionPane.showMessageDialog(null, "Se ha modificado el jugador seleccionado");
                        break;
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "Problemas con la BD");       
                this.dispose();        
            }
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error: " + ex.getMessage());
        }
        
    }//GEN-LAST:event_bAceptarActionPerformed

    
    
    public void personalizarVentana(String titulo, String label){
        lTitulo.setText(titulo);
        lSelector.setText(label);
    }
    


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.edisoncor.gui.button.ButtonAction bAceptar;
    private org.edisoncor.gui.comboBox.ComboBoxRect cbSeleccion;
    private javax.swing.JLabel lSelector;
    private org.edisoncor.gui.label.LabelRect lTitulo;
    private javax.swing.JPanel panelContenedor;
    private org.edisoncor.gui.panel.Panel panelGeneral;
    // End of variables declaration//GEN-END:variables
}

