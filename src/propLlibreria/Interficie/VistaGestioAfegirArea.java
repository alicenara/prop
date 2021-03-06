/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package propLlibreria.Interficie;

import javax.swing.JOptionPane;

/**
 *
 * @author towerthousand
 */
public class VistaGestioAfegirArea extends javax.swing.JPanel {

    /**
     * Creates new form VistaGestióAfegirEstanteria
     */
    public VistaGestioAfegirArea() {
        initComponents();
    }
    
    public void resetFields() {
        inputNom.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        botoAfegir = new javax.swing.JToggleButton();
        labelNom = new javax.swing.JLabel();
        inputNom = new javax.swing.JTextField();

        setBackground(new java.awt.Color(212, 220, 245));
        setMaximumSize(new java.awt.Dimension(476, 405));
        setMinimumSize(new java.awt.Dimension(476, 405));
        setPreferredSize(new java.awt.Dimension(476, 405));

        botoAfegir.setText("Crear");
        botoAfegir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botoAfegirActionPerformed(evt);
            }
        });

        labelNom.setText("Nom");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(141, 141, 141)
                .addComponent(labelNom)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botoAfegir, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputNom, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(154, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNom)
                    .addComponent(inputNom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(botoAfegir)
                .addContainerGap(315, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void botoAfegirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botoAfegirActionPerformed
        String nom = inputNom.getText();
        if(nom == null || nom.equals("")) {
            JOptionPane.showMessageDialog(null, "No es pot afegir un àrea sense nom","Error",JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {
            CtrlInterficie.crearArea(nom);
        }
        catch(Exception exc) {
            JOptionPane.showMessageDialog(null, "Ja existeix un àrea amb aquest nom.\nCodi d'error: " + exc.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
            return;
        }
        JOptionPane.showMessageDialog(null, "Afegit correctament","Info",JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_botoAfegirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton botoAfegir;
    private javax.swing.JTextField inputNom;
    private javax.swing.JLabel labelNom;
    // End of variables declaration//GEN-END:variables
}
