/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package propLlibreria.Interficie;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.ListModel;

/**
 *
 * @author towerthousand
 */
public class VistaGestioAfegirLlibre extends javax.swing.JPanel {

    /**
     * Creates new form VistaGestióAfegirEstanteria
     */
    public VistaGestioAfegirLlibre() {
        initComponents();
    }

    public void resetFields() {
        inputISBN.setText("");
        ArrayList<ArrayList<String> > tematiques = CtrlInterficie.seleccionaAllTematiques();
        String[] model = new String[tematiques.size()];
        javax.swing.DefaultListModel m = new javax.swing.DefaultListModel();
        for(int i = 0; i < tematiques.size(); ++i) {
            model[i] = tematiques.get(i).get(0);
            m.addElement(tematiques.get(i).get(0));
        }
        comboTematicaPrincipal.setModel(new javax.swing.DefaultComboBoxModel(model));
        listSecundaries.setModel(m);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        inputAutor = new javax.swing.JTextField();
        labelAutor = new javax.swing.JLabel();
        inputTitol = new javax.swing.JTextField();
        labelTitol = new javax.swing.JLabel();
        labelEdicio = new javax.swing.JLabel();
        labelTematica = new javax.swing.JLabel();
        spinEdicio = new javax.swing.JSpinner();
        comboTematicaPrincipal = new javax.swing.JComboBox();
        labelAny = new javax.swing.JLabel();
        labelNom = new javax.swing.JLabel();
        inputISBN = new javax.swing.JTextField();
        labelEditorial = new javax.swing.JLabel();
        inputEditorial = new javax.swing.JTextField();
        spinAny = new javax.swing.JSpinner();
        botoAfegir = new javax.swing.JToggleButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        listSecundaries = new javax.swing.JList();
        labelSecundaries = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(476, 405));
        setMinimumSize(new java.awt.Dimension(476, 405));
        setPreferredSize(new java.awt.Dimension(476, 405));

        labelAutor.setText("Autor");

        labelTitol.setText("Títol");

        labelEdicio.setText("Edició");

        labelTematica.setText("Temàtica");

        spinEdicio.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1)));
        spinEdicio.setMaximumSize(new java.awt.Dimension(10, 33));
        spinEdicio.setMinimumSize(new java.awt.Dimension(10, 33));
        spinEdicio.setPreferredSize(new java.awt.Dimension(10, 33));

        labelAny.setText("Any");

        labelNom.setText("ISBN");

        labelEditorial.setText("Editorial");

        spinAny.setModel(new javax.swing.SpinnerNumberModel(2000, 0, 2015, 1));
        spinAny.setMaximumSize(new java.awt.Dimension(10, 33));
        spinAny.setMinimumSize(new java.awt.Dimension(10, 33));
        spinAny.setPreferredSize(new java.awt.Dimension(10, 33));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(labelTematica)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(comboTematicaPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(labelEdicio, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                            .addComponent(labelAny, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(spinAny, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(spinEdicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelEditorial, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelTitol, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelNom, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(inputISBN)
                            .addComponent(inputEditorial, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(inputAutor, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(inputTitol, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNom)
                    .addComponent(inputISBN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelTitol)
                    .addComponent(inputTitol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelAutor)
                    .addComponent(inputAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelEditorial)
                    .addComponent(inputEditorial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelEdicio)
                    .addComponent(spinEdicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelAny)
                    .addComponent(spinAny, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelTematica)
                    .addComponent(comboTematicaPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        botoAfegir.setText("Crear");
        botoAfegir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botoAfegirActionPerformed(evt);
            }
        });

        listSecundaries.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(listSecundaries);

        labelSecundaries.setText("Temàtiques secundàries");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botoAfegir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(labelSecundaries, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35))
                            .addComponent(jScrollPane1))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelSecundaries, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botoAfegir)
                .addContainerGap(87, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void botoAfegirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botoAfegirActionPerformed
        String autor = inputAutor.getText();
        String isbn = inputISBN.getText();                                          
        String editorial = inputEditorial.getText();                                     
        String titol = inputTitol.getText();                                            
        int any = (Integer) spinAny.getValue();                                         
        int edicio = (Integer) spinEdicio.getValue();          
        String tprincipal = (String) comboTematicaPrincipal.getModel().getSelectedItem();
        ListModel m = listSecundaries.getModel();
        ArrayList<String> sec = new ArrayList<String>();
        for(int i = 0; i < m.getSize(); ++i)
            if(listSecundaries.isSelectedIndex(i))
                sec.add((String)m.getElementAt(i));
        try {
            CtrlInterficie.crearLlibre(isbn, titol, autor, editorial, any, edicio, tprincipal);
            for(int i = 0; i < sec.size(); ++i) CtrlInterficie.afegirTSecundaria(titol, autor, any, sec.get(i));
        }
        catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al inserir.\nCodi d'error: " + e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);  
                return;
        }
        JOptionPane.showMessageDialog(null, "Afegit correctament","Info",JOptionPane.INFORMATION_MESSAGE);            
    }//GEN-LAST:event_botoAfegirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton botoAfegir;
    private javax.swing.JComboBox comboTematicaPrincipal;
    private javax.swing.JTextField inputAutor;
    private javax.swing.JTextField inputEditorial;
    private javax.swing.JTextField inputISBN;
    private javax.swing.JTextField inputTitol;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelAny;
    private javax.swing.JLabel labelAutor;
    private javax.swing.JLabel labelEdicio;
    private javax.swing.JLabel labelEditorial;
    private javax.swing.JLabel labelNom;
    private javax.swing.JLabel labelSecundaries;
    private javax.swing.JLabel labelTematica;
    private javax.swing.JLabel labelTitol;
    private javax.swing.JList listSecundaries;
    private javax.swing.JSpinner spinAny;
    private javax.swing.JSpinner spinEdicio;
    // End of variables declaration//GEN-END:variables
}
