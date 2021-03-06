package propLlibreria.Interficie;

import javax.swing.SwingUtilities;
import propLlibreria.Domini.CtrlDominiInterficie;

public class VistaMenuPrincipal extends javax.swing.JPanel {

    public VistaMenuPrincipal() {
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

        botoGestionar = new javax.swing.JButton();
        botoDesarSortir = new javax.swing.JButton();
        botoConsultar = new javax.swing.JButton();
        labSelecciona = new javax.swing.JLabel();
        bOrdena = new javax.swing.JButton();

        setBackground(new java.awt.Color(212, 220, 245));
        setMinimumSize(new java.awt.Dimension(500, 500));
        setPreferredSize(new java.awt.Dimension(500, 500));

        botoGestionar.setText("Gestionar");
        botoGestionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botoGestionarActionPerformed(evt);
            }
        });

        botoDesarSortir.setText("Desar canvis i sortir");
        botoDesarSortir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botoDesarSortirActionPerformed(evt);
            }
        });

        botoConsultar.setText("Consultar");
        botoConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botoConsultarActionPerformed(evt);
            }
        });

        labSelecciona.setBackground(new java.awt.Color(212, 220, 245));
        labSelecciona.setText("Selecciona la operació a realitzar:");
        labSelecciona.setOpaque(true);

        bOrdena.setText("Ordenar");
        bOrdena.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bOrdenaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(119, 119, 119)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labSelecciona, javax.swing.GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE)
                    .addComponent(botoConsultar, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bOrdena, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botoGestionar, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(botoDesarSortir, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(120, 120, 120))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(labSelecciona)
                .addGap(36, 36, 36)
                .addComponent(botoGestionar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bOrdena)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(botoConsultar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(botoDesarSortir)
                .addContainerGap(225, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void botoGestionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botoGestionarActionPerformed
        VistaPrincipal v = (VistaPrincipal)SwingUtilities.getWindowAncestor(this);
        v.ferVisibleGestionar();
    }//GEN-LAST:event_botoGestionarActionPerformed

    private void botoConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botoConsultarActionPerformed
        VistaPrincipal v = (VistaPrincipal)SwingUtilities.getWindowAncestor(this);
        v.ferVisibleConsultar();
    }//GEN-LAST:event_botoConsultarActionPerformed

    private void botoDesarSortirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botoDesarSortirActionPerformed
        CtrlDominiInterficie.guardarSolucio();
        VistaPrincipal v = (VistaPrincipal)SwingUtilities.getWindowAncestor(this);
        v.dispose();
    }//GEN-LAST:event_botoDesarSortirActionPerformed

    private void bOrdenaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bOrdenaActionPerformed
        VistaPrincipal v = (VistaPrincipal)SwingUtilities.getWindowAncestor(this);
        v.ferVisibleOrdenar();
    }//GEN-LAST:event_bOrdenaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bOrdena;
    private javax.swing.JButton botoConsultar;
    private javax.swing.JButton botoDesarSortir;
    private javax.swing.JButton botoGestionar;
    private javax.swing.JLabel labSelecciona;
    // End of variables declaration//GEN-END:variables
}
