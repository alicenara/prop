/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package propLlibreria.Interficie;

/**
 *
 * @author Alice
 */
public class VistaMentreOrdena extends javax.swing.JPanel {

    /**
     * Creates new form VistaMentreOrdena
     */
    public VistaMentreOrdena() {
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

        pbOrdenant = new javax.swing.JProgressBar();
        labKeepCalm = new javax.swing.JLabel();
        bSortir = new javax.swing.JButton();

        labKeepCalm.setFont(new java.awt.Font("Arial Unicode MS", 0, 13)); // NOI18N
        labKeepCalm.setText("Ordenant. Esperi si us plau.");

        bSortir.setFont(new java.awt.Font("Arial Unicode MS", 0, 13)); // NOI18N
        bSortir.setText("Sortir");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(bSortir, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(labKeepCalm)
                        .addComponent(pbOrdenant, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(66, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addComponent(labKeepCalm)
                .addGap(36, 36, 36)
                .addComponent(pbOrdenant, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                .addComponent(bSortir)
                .addGap(46, 46, 46))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bSortir;
    private javax.swing.JLabel labKeepCalm;
    private javax.swing.JProgressBar pbOrdenant;
    // End of variables declaration//GEN-END:variables
}
