/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package propLlibreria.Interficie;

import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JViewport;
import javax.swing.table.TableModel;

/**
 *
 * @author Alice
 */
public class VistaOrdenat extends javax.swing.JPanel {

    /**
     * Creates new form VistaOrdenat
     */
    public VistaOrdenat() {
        initComponents();
        mostrarLlibresEstanteries();
    }
    
    private void mostrarLlibresEstanteries(){
        try {
            PropTableModel myData = new PropTableModel();
            ArrayList<String> columns = new ArrayList<String>();
            ArrayList<ArrayList<String> > est = new ArrayList<ArrayList<String> >();
            ArrayList<ArrayList<String> > rows = new ArrayList<ArrayList<String> >();            
            columns.add("Estanteria");
            columns.add("ISBN");
            columns.add("Títol");
            columns.add("Autor");
            columns.add("Any");
            est = CtrlInterficie.seleccionaAllEstanteries();
            for (int i=0; i<est.size();i++){
                ArrayList<String> estanteria=est.get(i);
                try{
                    ArrayList<ArrayList<String> > llibres = new ArrayList<ArrayList<String> >();
                    llibres = CtrlInterficie.consultarLlibresEstanteria(Integer.parseInt(estanteria.get(0)), Integer.parseInt(estanteria.get(1)));
                    for (int j=0; j<llibres.size(); j++){
                         ArrayList<String> row = new ArrayList<String>();
                         row.add(estanteria.get(0)+","+estanteria.get(1));
                         row.add(llibres.get(j).get(0));
                         row.add(llibres.get(j).get(1));
                         row.add(llibres.get(j).get(2));
                         row.add(llibres.get(j).get(4));

                         rows.add(row);                     
                    } 
                }catch (Exception e){
                    System.out.println("Excepció!");
                }            
            }            
                    
            myData.setRowsValues(rows);
            myData.setColumnsValues(columns);
            JTable taula = new JTable((TableModel) myData);
            taula.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    setVistaDadesLlibre(e);
                }
            });
            TaulaOrdenada.setViewportView(taula);
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
    private void setVistaDadesLlibre(MouseEvent e) {
        if (e.getClickCount() == 2) {
            JViewport viewport = TaulaOrdenada.getViewport(); 
            JTable taulaLlibres = (JTable)viewport.getView();
            Object isbn = taulaLlibres.getValueAt(taulaLlibres.getSelectedRow(),1);
            VistaDadesLlibre dadesLlibre = new VistaDadesLlibre((String) isbn);
            JFrame frameDadesLlibre = new JFrame();
            frameDadesLlibre.setSize(new Dimension(600,400));
            frameDadesLlibre.setResizable(false);
            frameDadesLlibre.add(dadesLlibre);
            frameDadesLlibre.setVisible(true);
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

        TaulaOrdenada = new javax.swing.JScrollPane();
        taulaResult = new javax.swing.JTable();
        bSortir = new javax.swing.JButton();
        bPDF = new javax.swing.JButton();

        taulaResult.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        TaulaOrdenada.setViewportView(taulaResult);

        bSortir.setText("Tancar");
        bSortir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSortirActionPerformed(evt);
            }
        });

        bPDF.setText("Exportar a pdf");
        bPDF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bPDFActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(TaulaOrdenada, javax.swing.GroupLayout.DEFAULT_SIZE, 555, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bPDF, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bSortir, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TaulaOrdenada, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bSortir, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(bPDF, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void bSortirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSortirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_bSortirActionPerformed

    private void bPDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bPDFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bPDFActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane TaulaOrdenada;
    private javax.swing.JButton bPDF;
    private javax.swing.JButton bSortir;
    private javax.swing.JTable taulaResult;
    // End of variables declaration//GEN-END:variables
}
