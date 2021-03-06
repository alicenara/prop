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
public class VistaGestioAfegirSeccio extends javax.swing.JPanel {

    /**
     * Creates new form VistaGestióAfegirEstanteria
     */
    public VistaGestioAfegirSeccio() {
        initComponents();
    }

    public void resetFields() {
        inputNom.setText("");
        ArrayList<ArrayList<String> > arees = CtrlInterficie.seleccionaAllArees();
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

        labelArea.setText("Àrea");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(144, 144, 144)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelNom)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(inputNom, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelArea, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(botoAfegir, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboArea, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(151, 151, 151))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNom)
                    .addComponent(inputNom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelArea)
                    .addComponent(comboArea, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(botoAfegir)
                .addContainerGap(278, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void botoAfegirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botoAfegirActionPerformed
        String nom = inputNom.getText();
        String nomArea = (String) comboArea.getModel().getSelectedItem();
        if(nom == null || nomArea == null || nom.equals("") || nomArea.equals("")) {
            JOptionPane.showMessageDialog(null, "No es pot afegir una secció sense nom","Error",JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {
            CtrlInterficie.crearSeccio(nom, nomArea);
        }
        catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);  
                return;
        }
        JOptionPane.showMessageDialog(null, "Afegit correctament","Info",JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_botoAfegirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton botoAfegir;
    private javax.swing.JComboBox comboArea;
    private javax.swing.JTextField inputNom;
    private javax.swing.JLabel labelArea;
    private javax.swing.JLabel labelNom;
    // End of variables declaration//GEN-END:variables
}
