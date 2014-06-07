/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package propLlibreria.Interficie;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author towerthousand
 */
public class VistaGestioModificarTematica extends javax.swing.JPanel {

    /**
     * Creates new form VistaGestióAfegirEstanteria
     */
    public VistaGestioModificarTematica() {
        initComponents();
    }
    
    public void resetFields() {
        inputNom.setText("");
        ArrayList<ArrayList<String> > arees = CtrlInterficie.seleccionaAllTematiques();
        String[] model = new String[arees.size()];
        for(int i = 0; i < arees.size(); ++i)
            model[i] = arees.get(i).get(0);
        comboArea.setModel(new javax.swing.DefaultComboBoxModel(model));
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
        labelArea = new javax.swing.JLabel();
        comboArea = new javax.swing.JComboBox();

        setMaximumSize(new java.awt.Dimension(476, 405));
        setMinimumSize(new java.awt.Dimension(476, 405));
        setPreferredSize(new java.awt.Dimension(476, 405));

        botoAfegir.setText("Desar");
        botoAfegir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botoAfegirActionPerformed(evt);
            }
        });

        labelNom.setText("Nom");

        labelArea.setText("Temàtica");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(115, 115, 115)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelNom)
                    .addComponent(labelArea))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(comboArea, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(botoAfegir, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(inputNom, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(153, 153, 153))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelArea)
                    .addComponent(comboArea, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNom)
                    .addComponent(inputNom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(botoAfegir)
                .addContainerGap(288, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void botoAfegirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botoAfegirActionPerformed
        String nom = inputNom.getText();
        if(nom == null || nom.equals("")) {
            JOptionPane.showMessageDialog(null, "No hi pot haver una temàtica sense nom","Error",JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {
            CtrlInterficie.modificarNomTematica((String) comboArea.getModel().getSelectedItem(), nom);
        }
        catch(Exception exc) {
            JOptionPane.showMessageDialog(null, "Ja existeix una temàtica amb aquest nom.\nCodi d'error: " + exc.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
            return;
        }
        JOptionPane.showMessageDialog(null, "Modificat correctament","Info",JOptionPane.INFORMATION_MESSAGE);
        resetFields();
    }//GEN-LAST:event_botoAfegirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton botoAfegir;
    private javax.swing.JComboBox comboArea;
    private javax.swing.JTextField inputNom;
    private javax.swing.JLabel labelArea;
    private javax.swing.JLabel labelNom;
    // End of variables declaration//GEN-END:variables
}
