/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package propLlibreria.Interficie;

/**
 *
 * @author towerthousand
 */
public final class VistaPrincipal extends javax.swing.JFrame {
    
    VistaConsultes vConsultes;
    VistaGestio vGestio;
    VistaMenuPrincipal vPrincipal;
    VistaOrdenacio vOrd;
    
    /**
     * Creates new form VistaPrincipal
     */
    public VistaPrincipal() { 
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VistaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        initComponents();
        vPrincipal = new VistaMenuPrincipal();
        vGestio = new VistaGestio();
        vConsultes = new VistaConsultes();
        vOrd = new VistaOrdenacio();
        this.ferVisiblePrincipal();
        java.awt.Dimension dim = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("PROP");
        setMaximumSize(new java.awt.Dimension(500, 500));
        setMinimumSize(new java.awt.Dimension(500, 500));
        setPreferredSize(new java.awt.Dimension(500, 500));
        setResizable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );

        getAccessibleContext().setAccessibleDescription("PROPSIDA");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
    public void ferVisible() {
        this.setVisible(true);
    } 

    void ferVisibleGestionar() {
        this.setContentPane(vGestio);
        vPrincipal.setVisible(false);
        vGestio.setVisible(true);
        vConsultes.setVisible(false);
        vOrd.setVisible(false);
    }

    void ferVisibleConsultar() {
        this.setContentPane(vConsultes);
        vPrincipal.setVisible(false);
        vGestio.setVisible(false);
        vConsultes.setVisible(true);
        vOrd.setVisible(false);
    }
    
    void ferVisiblePrincipal() {
        this.setContentPane(vPrincipal);
        vPrincipal.setVisible(true);
        vGestio.setVisible(false);
        vConsultes.setVisible(false);
        vOrd.setVisible(false);
    }
    void ferVisibleOrdenar() {
        this.setContentPane(vOrd);
        vOrd.reset();
        vPrincipal.setVisible(false);
        vGestio.setVisible(false);
        vConsultes.setVisible(false);
        vOrd.setVisible(true);
    }
}
