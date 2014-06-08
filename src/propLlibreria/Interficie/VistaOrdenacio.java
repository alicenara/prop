package propLlibreria.Interficie;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JViewport;
import javax.swing.RowSorter;
import javax.swing.SwingUtilities;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;


public class VistaOrdenacio extends javax.swing.JPanel {
  
    private final VistaMentreOrdena vMentreOrdena;
    
    public VistaOrdenacio() {
        initComponents();
        labAvis.setVisible(false);
        vMentreOrdena = new VistaMentreOrdena();        
    }
    
    private void carregarTaulaEst(){
         try {
            PropTableModel myData = new PropTableModel();
            ArrayList<String> columns = new ArrayList<String>();
            ArrayList<ArrayList<String> > rows = new ArrayList<ArrayList<String> >();            
            columns.add("Coordenada X");
            columns.add("Coordenada Y");
            columns.add("Num de files");
            columns.add("Llargada");            
            rows = CtrlInterficie.seleccionaAllEstanteries();
            
            myData.setRowsValues(rows);
            myData.setColumnsValues(columns);
            TaulaEst = new JTable((TableModel) myData);
            TaulaEst.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed (MouseEvent e) {
                    comprovarBotons(e);
                }
            });
            RowSorter<TableModel> sorter = new TableRowSorter<TableModel>(myData);
            TaulaEst.setRowSorter(sorter);
            TaulaEstanteria.setViewportView(TaulaEst);           
            
        }catch (Exception e){
            System.out.println("Excepció!");
        }        
    }
    
    private void carregarTaulaLlib(){
         try {
            PropTableModel myData = new PropTableModel();
            ArrayList<String> columns = new ArrayList<String>();
            ArrayList<ArrayList<String> > rows = new ArrayList<ArrayList<String> >();            
            columns.add("ISBN");
            columns.add("Titol");
            columns.add("Autor");
            columns.add("Any");
            columns.add("Temàtica");
            rows = CtrlInterficie.seleccionaAllLlibres();
            for(int i = 0; i < rows.size(); ++i) {
                rows.get(i).remove(5);
                rows.get(i).remove(3);
            }            
              
            myData.setRowsValues(rows);
            myData.setColumnsValues(columns);
            TaulaLlib = new JTable((TableModel) myData);
            TaulaLlib.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed (MouseEvent e) {
                    setVistaDadesLlibre(e);
                    comprovarBotons(e);
                }
            });
            RowSorter<TableModel> sorter = new TableRowSorter<TableModel>(myData);
            TaulaLlib.setRowSorter(sorter);
            TaulaLlibre.setViewportView(TaulaLlib);
         }catch (Exception e){
            System.out.println("Excepció!");
        } 
    }
    
    private void comprovarBotons(MouseEvent e){
        if(TaulaEst.getSelectedRows().length!=0 && TaulaLlib.getSelectedRows().length!=0 ){
            bHeur.setEnabled(true);
            bBandB.setEnabled(true);
        }else{
            bHeur.setEnabled(false);
            bBandB.setEnabled(false);
        }
    }
    
    private void setVistaDadesLlibre(MouseEvent e) {
        if(TaulaLlib.getSelectedRows().length>=10) labAvis.setVisible(true);
        else labAvis.setVisible(false);
        if (e.getClickCount() == 2) {
            JViewport viewport = TaulaLlibre.getViewport(); 
            JTable taulaLlibres = (JTable)viewport.getView();
            Object isbn = taulaLlibres.getValueAt(taulaLlibres.getSelectedRows()[0],0);
            VistaDadesLlibre dadesLlibre = new VistaDadesLlibre((String) isbn);
            JFrame frameDadesLlibre = new JFrame();
            frameDadesLlibre.setSize(new Dimension(600,400));
            frameDadesLlibre.setLocation(20, 20);
            frameDadesLlibre.setIconImage(Toolkit.getDefaultToolkit().getImage("src/propLlibreria/Interficie/icons/bookIcon.png"));
            frameDadesLlibre.setResizable(false);
            frameDadesLlibre.add(dadesLlibre);
            frameDadesLlibre.setVisible(true);
        }
    }
    
    private void ocultarTot(){
        panPregunta.setVisible(false);
    }
    
    private void cridaVistaMentreOrdena() {
        ocultarTot();
        if(vMentreOrdena == null) return;
        vMentreOrdena.setVisible(true);
        javax.swing.GroupLayout layeredLayout = new javax.swing.GroupLayout(layered);
        layered.setLayout(layeredLayout);
        layeredLayout.setHorizontalGroup(
            layeredLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(vMentreOrdena, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layeredLayout.setVerticalGroup(
            layeredLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(vMentreOrdena, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layered.setLayer(vMentreOrdena, javax.swing.JLayeredPane.DEFAULT_LAYER);
    } 
    
    public void reset(){            
        bHeur.setEnabled(false);
        bBandB.setEnabled(false);
        carregarTaulaLlib();
        carregarTaulaEst();
        vMentreOrdena.setVisible(false);
        labAvis.setVisible(false);
        panPregunta.setVisible(true);
        javax.swing.GroupLayout layeredLayout = new javax.swing.GroupLayout(layered);
        layered.setLayout(layeredLayout);
        layeredLayout.setHorizontalGroup(
            layeredLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panPregunta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layeredLayout.setVerticalGroup(
            layeredLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panPregunta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layered.setLayer(panPregunta, javax.swing.JLayeredPane.DEFAULT_LAYER);
               
    }
    
    private ArrayList<ArrayList<String>> getEstanteries(){
        int[] selected = TaulaEst.getSelectedRows();
        ArrayList<ArrayList<String>> e = new ArrayList<ArrayList<String>>();
        boolean end = false;
        try{
            for(int i = 0; i < selected.length && !end; ++i) {
                ArrayList<String> est = new ArrayList<String>();
                String s = (String)TaulaEst.getValueAt(selected[i], 0);
                est.add(s);
                s = (String)TaulaEst.getValueAt(selected[i], 1);
                est.add(s);
                e.add(est);
            }
        }catch (Exception ex){
            //Cosa
        }
        return e;
    }
    
    private ArrayList<ArrayList<String>> getLlibres(){
        int[] selected = TaulaLlib.getSelectedRows();
        ArrayList<ArrayList<String>> l = new ArrayList<ArrayList<String>>();
        boolean end = false;
        try{
            for(int i = 0; i < selected.length && !end; ++i) {
                ArrayList<String> lib = new ArrayList<String>();
                String s = (String)TaulaLlib.getValueAt(selected[i], 1);
                lib.add(s);
                s = (String)TaulaLlib.getValueAt(selected[i], 2);
                lib.add(s);
                s = (String)TaulaLlib.getValueAt(selected[i], 3);
                lib.add(s);
                l.add(lib);
            }
        }catch (Exception ex){
            //Cosa
        }
        return l;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        layered = new javax.swing.JLayeredPane();
        panPregunta = new javax.swing.JPanel();
        labAvis = new javax.swing.JLabel();
        bHeur = new javax.swing.JButton();
        bBandB = new javax.swing.JButton();
        labInfo = new javax.swing.JLabel();
        TaulaEstanteria = new javax.swing.JScrollPane();
        TaulaEst = new javax.swing.JTable();
        TaulaLlibre = new javax.swing.JScrollPane();
        TaulaLlib = new javax.swing.JTable();
        labLlibre = new javax.swing.JLabel();
        labEstanteria = new javax.swing.JLabel();
        bCancelar = new javax.swing.JButton();

        setBackground(new java.awt.Color(212, 220, 245));

        panPregunta.setBackground(new java.awt.Color(212, 220, 245));

        labAvis.setFont(new java.awt.Font("Arial Unicode MS", 0, 13)); // NOI18N
        labAvis.setForeground(new java.awt.Color(255, 51, 51));
        labAvis.setText("<html>Compte! La quantitat de llibres és <b>molt gran per utilitzar un mètode exacte</b>. El temps d'espera de reordenació pot superar els 5 minuts.</html>");
        labAvis.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        bHeur.setFont(new java.awt.Font("Arial Unicode MS", 0, 13)); // NOI18N
        bHeur.setText("Mètode heurístic");
        bHeur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bHeurActionPerformed(evt);
            }
        });

        bBandB.setFont(new java.awt.Font("Arial Unicode MS", 0, 13)); // NOI18N
        bBandB.setText("Mètode exacte");
        bBandB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bBandBActionPerformed(evt);
            }
        });

        labInfo.setFont(new java.awt.Font("Arial Unicode MS", 0, 13)); // NOI18N
        labInfo.setText("Escull de quina forma vols ordenar:");

        TaulaEst.setModel(new javax.swing.table.DefaultTableModel(
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
        TaulaEstanteria.setViewportView(TaulaEst);

        TaulaLlib.setModel(new javax.swing.table.DefaultTableModel(
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
        TaulaLlibre.setViewportView(TaulaLlib);

        labLlibre.setFont(new java.awt.Font("Arial Unicode MS", 0, 12)); // NOI18N
        labLlibre.setText("Llibre:");

        labEstanteria.setFont(new java.awt.Font("Arial Unicode MS", 0, 12)); // NOI18N
        labEstanteria.setText("Estanteria:");

        bCancelar.setFont(new java.awt.Font("Arial Unicode MS", 0, 11)); // NOI18N
        bCancelar.setText("Cancel·lar");
        bCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panPreguntaLayout = new javax.swing.GroupLayout(panPregunta);
        panPregunta.setLayout(panPreguntaLayout);
        panPreguntaLayout.setHorizontalGroup(
            panPreguntaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panPreguntaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panPreguntaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panPreguntaLayout.createSequentialGroup()
                        .addGroup(panPreguntaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labLlibre)
                            .addComponent(labEstanteria))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(panPreguntaLayout.createSequentialGroup()
                        .addGroup(panPreguntaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labInfo)
                            .addGroup(panPreguntaLayout.createSequentialGroup()
                                .addComponent(bBandB, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(bHeur, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(bCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panPreguntaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(labAvis, javax.swing.GroupLayout.PREFERRED_SIZE, 425, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(TaulaEstanteria, javax.swing.GroupLayout.DEFAULT_SIZE, 468, Short.MAX_VALUE)
                                .addComponent(TaulaLlibre)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        panPreguntaLayout.setVerticalGroup(
            panPreguntaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panPreguntaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labEstanteria)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TaulaEstanteria, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labLlibre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TaulaLlibre, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(labAvis, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labInfo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panPreguntaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panPreguntaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(bHeur, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(bBandB, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layeredLayout = new javax.swing.GroupLayout(layered);
        layered.setLayout(layeredLayout);
        layeredLayout.setHorizontalGroup(
            layeredLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layeredLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panPregunta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );
        layeredLayout.setVerticalGroup(
            layeredLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layeredLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panPregunta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
        );
        layered.setLayer(panPregunta, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(layered, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(layered, javax.swing.GroupLayout.PREFERRED_SIZE, 494, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 11, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void bBandBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bBandBActionPerformed
        cridaVistaMentreOrdena();
        vMentreOrdena.ordenar(false, getEstanteries(), getLlibres());
    }//GEN-LAST:event_bBandBActionPerformed

    private void bHeurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bHeurActionPerformed
        // TODO add your handling code here:
        cridaVistaMentreOrdena();
        vMentreOrdena.ordenar(true, getEstanteries(), getLlibres());
    }//GEN-LAST:event_bHeurActionPerformed

    private void bCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCancelarActionPerformed
        VistaPrincipal v = (VistaPrincipal)SwingUtilities.getWindowAncestor(this);
        v.ferVisiblePrincipal();
    }//GEN-LAST:event_bCancelarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TaulaEst;
    private javax.swing.JScrollPane TaulaEstanteria;
    private javax.swing.JTable TaulaLlib;
    private javax.swing.JScrollPane TaulaLlibre;
    private javax.swing.JButton bBandB;
    private javax.swing.JButton bCancelar;
    private javax.swing.JButton bHeur;
    private javax.swing.JLabel labAvis;
    private javax.swing.JLabel labEstanteria;
    private javax.swing.JLabel labInfo;
    private javax.swing.JLabel labLlibre;
    private javax.swing.JLayeredPane layered;
    private javax.swing.JPanel panPregunta;
    // End of variables declaration//GEN-END:variables
}
