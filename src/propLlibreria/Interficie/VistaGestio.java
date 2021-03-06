/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package propLlibreria.Interficie;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 *
 * @author towerthousand
 */
public class VistaGestio extends javax.swing.JPanel {
    
    private final VistaGestioAfegirEstanteria vAfegirEstanteria;
    private final VistaGestioAfegirArea vAfegirArea;
    private final VistaGestioEliminar vEliminar;
    private final VistaGestioAfegirSeccio vAfegirSeccio;
    private final VistaGestioAfegirTematica vAfegirTematica;
    private final VistaGestioAfegirLlibre vAfegirLlibre;
    private final VistaGestioModificarArea vModArea;
    private final VistaGestioModificarSeccio vModSeccio;
    private final VistaGestioModificarTematica vModTematica;
    private final VistaGestioModificarLlibre vModLlibre;
    private final VistaGestioModificarEstanteria vModEstanteria;
    private javax.swing.JPanel active;
    
    /**
     * Creates new form VistaGestio
     */
    public VistaGestio() {
        initComponents();
        vEliminar = new VistaGestioEliminar();
        vAfegirEstanteria = new VistaGestioAfegirEstanteria();
        vAfegirArea = new VistaGestioAfegirArea();
        vAfegirSeccio = new VistaGestioAfegirSeccio();
        vAfegirTematica = new VistaGestioAfegirTematica();
        vAfegirLlibre = new VistaGestioAfegirLlibre();
        vModArea = new VistaGestioModificarArea();
        vModSeccio = new VistaGestioModificarSeccio();
        vModTematica = new VistaGestioModificarTematica();
        vModLlibre = new VistaGestioModificarLlibre();
        vModEstanteria = new VistaGestioModificarEstanteria();
        active = null;
    }
    
    private void setVistaParcial(javax.swing.JPanel vista) {
        vAfegirEstanteria.resetFields();
        vAfegirArea.resetFields();
        vAfegirLlibre.resetFields();
        vAfegirSeccio.resetFields();
        vAfegirTematica.resetFields();
        vEliminar.resetFields();
        vModArea.resetFields();
        vModSeccio.resetFields();
        vModTematica.resetFields();
        vModLlibre.resetFields();
        vModEstanteria.resetFields();
        if(active != null) {active.setVisible(false); active = null;}
        if(vista == null) return;
        active = vista;
        active.setVisible(true);
        javax.swing.GroupLayout layeredLayout = new javax.swing.GroupLayout(layered);
        layered.setLayout(layeredLayout);
        layeredLayout.setHorizontalGroup(
            layeredLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(active, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layeredLayout.setVerticalGroup(
            layeredLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(active, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layered.setLayer(active, javax.swing.JLayeredPane.DEFAULT_LAYER);
    }

    private void redisplay() {
        String selectedObject = (String) listObjects.getModel().getSelectedItem();
        String selectedAction = (String) listAccions.getModel().getSelectedItem();
        if(selectedAction.equals("Selecciona...") || selectedObject.equals("Selecciona...")) setVistaParcial(null);
        if(selectedAction.equals("Eliminar")) {
            vEliminar.setObjectType(selectedObject);
            setVistaParcial(vEliminar);
        }
        switch(selectedObject){
            case "Àrea": {
                switch(selectedAction) {
                    case "Crear":
                        setVistaParcial(vAfegirArea);
                        break;
                    case "Modificar":
                        setVistaParcial(vModArea);
                        break;
                }
                break;
            }
            case "Secció": {
                switch(selectedAction) {
                    case "Crear":
                        setVistaParcial(vAfegirSeccio);
                        break;
                    case "Modificar":
                        setVistaParcial(vModSeccio);
                        break;
                }
                break;
            }
            case "Temàtica": {
                switch(selectedAction) {
                    case "Crear":
                        setVistaParcial(vAfegirTematica);
                        break;
                    case "Modificar":
                        setVistaParcial(vModTematica);
                        break;
                }
                break;
            }
            case "Estanteria": {
                switch(selectedAction) {
                    case "Crear":
                        setVistaParcial(vAfegirEstanteria);
                        break;
                    case "Modificar":
                        setVistaParcial(vModEstanteria);
                        break;
                }
                break;
            }
            case "Llibre": {
                switch(selectedAction) {
                    case "Crear":
                        setVistaParcial(vAfegirLlibre);
                        break;
                    case "Modificar":
                        setVistaParcial(vModLlibre);
                        break;
                }
                break;
            }
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

        listObjects = new javax.swing.JComboBox();
        listAccions = new javax.swing.JComboBox();
        layered = new javax.swing.JLayeredPane();
        botoEnrere = new javax.swing.JButton();

        setBackground(new java.awt.Color(212, 220, 245));
        setMaximumSize(new java.awt.Dimension(500, 500));
        setMinimumSize(new java.awt.Dimension(500, 500));
        setPreferredSize(new java.awt.Dimension(500, 500));

        listObjects.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecciona...", "Àrea", "Secció", "Temàtica", "Estanteria", "Llibre" }));
        listObjects.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listObjectsActionPerformed(evt);
            }
        });

        listAccions.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecciona...", "Crear", "Modificar", "Eliminar" }));
        listAccions.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listAccionsActionPerformed(evt);
            }
        });

        layered.setMaximumSize(new java.awt.Dimension(476, 405));
        layered.setMinimumSize(new java.awt.Dimension(476, 405));
        layered.setName(""); // NOI18N

        javax.swing.GroupLayout layeredLayout = new javax.swing.GroupLayout(layered);
        layered.setLayout(layeredLayout);
        layeredLayout.setHorizontalGroup(
            layeredLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 476, Short.MAX_VALUE)
        );
        layeredLayout.setVerticalGroup(
            layeredLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 405, Short.MAX_VALUE)
        );

        botoEnrere.setText("Enrere");
        botoEnrere.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botoEnrereActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botoEnrere)
                .addGap(32, 32, 32)
                .addComponent(listObjects, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(listAccions, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(122, 122, 122))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(layered, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(listObjects, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(listAccions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(botoEnrere)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(layered, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void listObjectsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listObjectsActionPerformed
        redisplay();
    }//GEN-LAST:event_listObjectsActionPerformed

    private void listAccionsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listAccionsActionPerformed
        redisplay();
    }//GEN-LAST:event_listAccionsActionPerformed

    private void botoEnrereActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botoEnrereActionPerformed
        VistaPrincipal v = (VistaPrincipal)SwingUtilities.getWindowAncestor(this);
        v.ferVisiblePrincipal();
    }//GEN-LAST:event_botoEnrereActionPerformed
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botoEnrere;
    private javax.swing.JLayeredPane layered;
    private javax.swing.JComboBox listAccions;
    private javax.swing.JComboBox listObjects;
    // End of variables declaration//GEN-END:variables

}