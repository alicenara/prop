package propLlibreria.Interficie;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.io.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Ruben
 */


public class VistaConsultes extends javax.swing.JPanel {
    /**
     * Creates new form VistaConsultes
     */
    @SuppressWarnings("FieldMayBeFinal")
    boolean tipusLlibre = false;
    boolean seleccioAutomatica = false;
    boolean tipusOrdenacio = false;
    String funcionsSeleccioItem;
    String SeleccioItem;
    String contingutIntrValors;
    public VistaConsultes() {
        initComponents();
        resetFields();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Fons = new javax.swing.JPanel();
        Seleccio = new javax.swing.JComboBox();
        MostraResult = new javax.swing.JScrollPane();
        funcionsSeleccio = new javax.swing.JComboBox();
        OKButton = new javax.swing.JButton();
        IntroduccioDades = new javax.swing.JTextField();
        EnrereButton = new javax.swing.JButton();

        Fons.setBackground(new java.awt.Color(204, 204, 255));
        Fons.setFont(new java.awt.Font("Arial Unicode MS", 0, 11)); // NOI18N

        Seleccio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SeleccioActionPerformed(evt);
            }
        });

        MostraResult.setAutoscrolls(true);

        funcionsSeleccio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                funcionsSeleccioActionPerformed(evt);
            }
        });

        OKButton.setText("OK");
        OKButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OKButtonActionPerformed(evt);
            }
        });

        IntroduccioDades.setForeground(new java.awt.Color(153, 153, 153));
        IntroduccioDades.setEnabled(false);
        IntroduccioDades.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                IntroduccioDadesFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                IntroduccioDadesFocusLost(evt);
            }
        });
        IntroduccioDades.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                IntroduccioDadesKeyPressed(evt);
            }
        });

        EnrereButton.setText("Enrere");
        EnrereButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EnrereButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout FonsLayout = new javax.swing.GroupLayout(Fons);
        Fons.setLayout(FonsLayout);
        FonsLayout.setHorizontalGroup(
            FonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FonsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(EnrereButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(FonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(funcionsSeleccio, 0, 147, Short.MAX_VALUE)
                    .addComponent(Seleccio, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(IntroduccioDades, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(OKButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FonsLayout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addComponent(MostraResult, javax.swing.GroupLayout.PREFERRED_SIZE, 476, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );
        FonsLayout.setVerticalGroup(
            FonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FonsLayout.createSequentialGroup()
                .addGroup(FonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(FonsLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(FonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(IntroduccioDades, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(OKButton)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FonsLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(FonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(EnrereButton)
                            .addComponent(Seleccio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(funcionsSeleccio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(MostraResult, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Fons, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Fons, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    
    //Set Valors Inicials
    private void resetFields() {
        Seleccio.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecciona...", "Area", "Seccio", "Tematica", "Llibre", "Estanteria" }));
        funcionsSeleccio.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Tipus consulta..." }));
        MostraResult.setViewportView(new JViewport());
        IntroduccioDades.setEnabled(false);
        IntroduccioDades.setText("");
    }
    
    //Get valors del ComboBoxes
    private void getComboBoxItems() {
        SeleccioItem = (String) Seleccio.getModel()
                .getSelectedItem();
        funcionsSeleccioItem = (String) funcionsSeleccio.getModel()
                .getSelectedItem(); 
    }
    
    private void EnrereButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EnrereButtonActionPerformed
        resetFields();
        VistaPrincipal v = (VistaPrincipal)SwingUtilities.getWindowAncestor(this);
        v.ferVisiblePrincipal();
    }//GEN-LAST:event_EnrereButtonActionPerformed

    private void IntroduccioDadesKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_IntroduccioDadesKeyPressed
        int keyCode = evt.getKeyCode();
        String enter = KeyEvent.getKeyText(10);
        if (java.awt.event.KeyEvent.getKeyText(keyCode).equals(enter)){
            Consulta();
        }
    }//GEN-LAST:event_IntroduccioDadesKeyPressed

    
    private void IntroduccioDadesFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_IntroduccioDadesFocusLost
        if(IntroduccioDades.getText().trim().equals("")) {
            establirValorsIntroduccioDades();
            seleccioAutomatica = false;
        }
    }//GEN-LAST:event_IntroduccioDadesFocusLost

    private void IntroduccioDadesFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_IntroduccioDadesFocusGained
        contingutIntrValors = IntroduccioDades.getText();
        String paraules[] = contingutIntrValors.split(" ");
        if(!seleccioAutomatica && paraules.length > 0 && paraules[0].equals("Introdueix")){
            IntroduccioDades.setText("");
            IntroduccioDades.setForeground(new java.awt.Color(0,0,0));
        }
    }//GEN-LAST:event_IntroduccioDadesFocusGained

    private void OKButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OKButtonActionPerformed
        contingutIntrValors = IntroduccioDades.getText();
        Consulta();
    }//GEN-LAST:event_OKButtonActionPerformed
    
    //Set valors de JTextField IntroduccioDades
    private void establirValorsIntroduccioDadesLlibre() {
        try {
            switch(funcionsSeleccioItem) {
                case "Consulta per títol":
                    IntroduccioDades.setText("Introdueix titol");
                    break;
                case "Consulta per autor":
                    IntroduccioDades.setText("Introdueix autor");
                    break;
                case "Consulta per tematica principal":
                    IntroduccioDades.setText("Introdueix nom tematica");
                    break;
                case "Consulta per isbn":
                    IntroduccioDades.setText("Introdueix isbn");
                    break;
                case "Consulta per editorial":
                    IntroduccioDades.setText("Introdueix nom editorial");
                    break;
                case "Consulta per any":
                    IntroduccioDades.setText("Introdueix any");
                    break;
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    private void establirValorsIntroduccioDades() {
        try {
            getComboBoxItems();
            switch (SeleccioItem) {
                case "Area": 
                    IntroduccioDades.setText("Introdueix nom area");
                    break;
                case "Seccio":
                    IntroduccioDades.setText("Introdueix nom seccio");
                    break;
                case "Tematica":
                    IntroduccioDades.setText("Introdueix nom tematica");
                    break;
                case "Llibre":
                    establirValorsIntroduccioDadesLlibre();
                    break;
                case "Estanteria":
                    IntroduccioDades.setText("Introdueix coordeandes");
                    break;
            }
            IntroduccioDades.setForeground(new java.awt.Color(153, 153, 153));
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    private void funcionsSeleccioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_funcionsSeleccioActionPerformed
        getComboBoxItems();
        try {
            String funcs[] = funcionsSeleccioItem.split(" ");
            if (SeleccioItem == null || (funcionsSeleccioItem == null) || funcs[0].equals("Selecciona...") || funcs[0].equals("Tipus") ||
                    funcs[0].equals("Totes") || funcs[0].equals("Tots") || funcionsSeleccioItem.equals("Consulta ordenacio")){
                    seleccioAutomatica = false;
                    IntroduccioDades.setEnabled(false);
                    IntroduccioDades.setText("");
            }
            else {
                IntroduccioDades.setEnabled(true);
                if (!seleccioAutomatica)establirValorsIntroduccioDades();
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_funcionsSeleccioActionPerformed

    //Set funcionsSeleccio Items en base a Item Seleccio
    
    private void restablirOpcions() {
        funcionsSeleccio.setModel(new javax.swing.DefaultComboBoxModel(new String[] {"Tipus consulta..."}));
    }
    private void opcionsArea() {
        funcionsSeleccio.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Tipus consulta...", "Totes arees", "Seccions d'area",
                                                                                        "Tematiques d'area", "Llibres d'area"}));
    }
    private void opcionsSeccio() {
        funcionsSeleccio.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Tipus consulta...", "Totes seccions",
                                                                                        "Tematiques seccio", "Llibres seccio" }));
    }
    private void opcionsTematica() {
        funcionsSeleccio.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Tipus consulta...", "Totes tematiques", "Llibres tematiques" }));
    }
    private void opcionsLlibre() {
        funcionsSeleccio.setModel(new javax.swing.DefaultComboBoxModel(new String[] {"Tipus consulta..." , "Tots els llibres", "Consulta per títol",
                                                                                        "Consulta per autor", "Consulta per isbn","Consulta per any",
                                                                                        "Consulta per editorial","Consulta ordenacio"}));
    }
    private void opcionsEstanteria() {
        funcionsSeleccio.setModel(new javax.swing.DefaultComboBoxModel(new String[] {"Tipus consulta...", "Totes estanteries", "Llibres estanteria"}));
    }
    
    private void setOpcionsSeleccio(String Seleccio) {
        try {
            switch(Seleccio) {
                    case "Selecciona...":
                    restablirOpcions();
                    break;
                    case "Area":
                    opcionsArea();
                    break;
                    case "Seccio":
                    opcionsSeccio();
                    break;
                    case "Tematica":
                    opcionsTematica();
                    break;
                    case "Llibre":
                    opcionsLlibre();
                    break;
                    case "Estanteria":
                    opcionsEstanteria();
                    break;
            }
            funcionsSeleccio.setSelectedIndex(0);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    private void SeleccioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SeleccioActionPerformed
        try {
            getComboBoxItems();
            seleccioAutomatica = false;
            setOpcionsSeleccio(SeleccioItem);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_SeleccioActionPerformed

    //Set de taules de VistaConsultes
    private PropTableModel setModelTable(ArrayList<String> columns, ArrayList<ArrayList<String> > rows) {
        PropTableModel myData = new PropTableModel();
        myData.setColumnsValues(columns);
        myData.setRowsValues(rows);
        return myData;
    }
    
    private JTable setTaula(PropTableModel myData) {
        JTable taula = new JTable((TableModel) myData);
        RowSorter<TableModel> sorter = new TableRowSorter<TableModel>(myData);
        taula.setRowSorter(sorter);
        addActionToTaula(taula);
        return taula;
    }
    
    
    //Ventana emergent amb dades ampliades del llibre
    private void setVistaDadesLlibre(String isbn){
        VistaDadesLlibre dadesLlibre = new VistaDadesLlibre((String) isbn);
        JFrame frameDadesLlibre = new JFrame();
        frameDadesLlibre.setIconImage(Toolkit.getDefaultToolkit().getImage("resources/bookIcon.png"));
        frameDadesLlibre.setSize(new Dimension(600,400));
        frameDadesLlibre.setLocation(20, 20);
        frameDadesLlibre.setResizable(false);
        frameDadesLlibre.add(dadesLlibre);
        frameDadesLlibre.setVisible(true);
    }
    
    private void setMouseEventVistaDadesLlibre(MouseEvent e) {
        if (e.getClickCount() == 2) {
            JViewport viewport = MostraResult.getViewport(); 
            JTable taulaLlibres = (JTable)viewport.getView();
            String isbn = (String)taulaLlibres.getValueAt(taulaLlibres.getSelectedRow(),0);
            setVistaDadesLlibre(isbn);
        }
    }
    private void setMouseEventVistaDadesLlibreOrdenacio(MouseEvent e) {
        if (e.getClickCount() == 2) {
            JViewport viewport = MostraResult.getViewport(); 
            JTable taulaLlibres = (JTable)viewport.getView();
            String isbn = (String)taulaLlibres.getValueAt(taulaLlibres.getSelectedRow(),1);
            setVistaDadesLlibre(isbn);
        }
    }
    
    //Seleccio automatica del Item a consultar a les taules que no son de llibre
    private void setMouseEventVistaDades(MouseEvent e) {
        if (e.getClickCount() == 2) {
            JViewport viewport = MostraResult.getViewport(); 
            JTable taulaLlibres = (JTable)viewport.getView();
            Integer rowSelected = taulaLlibres.getSelectedRow();
            Integer columnSelected = taulaLlibres.getSelectedColumn();
            String Item = (String) taulaLlibres.getValueAt(rowSelected,columnSelected);
            String colVal = (String)taulaLlibres.getColumnName(columnSelected);
            Seleccio.setSelectedItem(colVal);
            funcionsSeleccio.setSelectedIndex(2);
            IntroduccioDades.setText(Item);
            IntroduccioDades.setForeground(new java.awt.Color(0,0,0));
            seleccioAutomatica  = true;
        }
    }
    
    //Assignacio de mouse listener a la taula per parametre. Associem de manera
    //diferent si la taula es de llibres o de atributs
    private void addActionToTaula(JTable taula) {
        if (tipusLlibre) {
            if (tipusOrdenacio){
                taula.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        setMouseEventVistaDadesLlibreOrdenacio(e);
                    }
                });
            }
            else {
                taula.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        setMouseEventVistaDadesLlibre(e);
                    }
                });
            }
        }
        else {
            taula.addKeyListener(new java.awt.event.KeyAdapter() {
                public void keyPressed(java.awt.event.KeyEvent evt) {
                    contingutIntrValors = IntroduccioDades.getText();
                    IntroduccioDadesKeyPressed(evt);
                }
            });
            taula.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    setMouseEventVistaDades(e);
                }
            });
        }
    }
    
    //CONSULTA
    
    private PropTableModel valorsModelArea() {
        try {
            ArrayList<String> columns = new ArrayList<String>();
            ArrayList<ArrayList<String> > rows = new ArrayList<ArrayList<String> >();
            switch(funcionsSeleccioItem) {
                case "Totes arees":
                    columns.add("Area");
                    rows = CtrlInterficie.seleccionaAllArees();
                    break;
                case "Seccions d'area":
                    columns.add("Seccio");
                    columns.add("Area");
                    rows = CtrlInterficie.consultarSeccionsArea(contingutIntrValors);    
                    break;
                case "Tematiques d'area":
                    columns.add("Tematica");
                    columns.add("Seccio");
                    columns.add("Area");
                    rows = CtrlInterficie.consultarTematiquesArea(contingutIntrValors);
                    break;
                case "Llibres d'area":
                    columns = valorsHeaderLlibre();
                    rows = CtrlInterficie.consultarLlibresArea(contingutIntrValors);
                    valorsReduitsLlibres(rows);
                    tipusLlibre = true;
                    break;
            }
            PropTableModel myData  = setModelTable(columns,rows);
            return myData;
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No existeix cap area amb nom " + contingutIntrValors,"Info",JOptionPane.INFORMATION_MESSAGE);
            return null;
        }
    }
    
    private void consultaArea() {
        try {
            PropTableModel myData = valorsModelArea();
            if (myData != null) {
                JTable taulaArees = setTaula(myData);
                if (tipusLlibre) tipusLlibre = false;
                MostraResult.setViewportView(taulaArees);
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    private PropTableModel valorsModelSeccio() {
        try {
            ArrayList<String> columns = new ArrayList<String>();
            ArrayList<ArrayList<String> > rows = new ArrayList<ArrayList<String> >();
            switch(funcionsSeleccioItem) {
                case "Totes seccions":
                    columns.add("Seccio");
                    columns.add("Area");
                    rows = CtrlInterficie.seleccionaAllSeccions();
                    break;
                case "Tematiques seccio" :
                    columns.add("Tematica");
                    columns.add("Seccio");
                    columns.add("Area");
                    rows = CtrlInterficie.consultarTematiquesSeccio(contingutIntrValors);
                    break;
                case "Llibres seccio" :
                    columns = valorsHeaderLlibre();
                    rows = CtrlInterficie.consultarLlibresSeccio(contingutIntrValors);
                    valorsReduitsLlibres(rows);
                    tipusLlibre = true;
                    break; 
            }
            PropTableModel myData = setModelTable(columns,rows);
            return myData;
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No existeix cap seccio amb nom" + contingutIntrValors,"Info",JOptionPane.INFORMATION_MESSAGE);
            return null;
        }
    }
    
    private void consultaSeccio() {
      try {
            PropTableModel myData = valorsModelSeccio();
            if (myData != null) {
                JTable taulaSeccions = setTaula(myData);
                if (tipusLlibre)tipusLlibre = false;
                MostraResult.setViewportView(taulaSeccions);
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        } 
    }
    
    private PropTableModel valorsModelTematica() {
        try {
            ArrayList<String> columns = new ArrayList<String>();
            ArrayList<ArrayList<String> > rows = new ArrayList<ArrayList<String> >();
            switch(funcionsSeleccioItem) {
                case "Totes tematiques":
                    columns.add("Tematica");
                    columns.add("Seccio");
                    columns.add("Area");
                    rows = CtrlInterficie.seleccionaAllTematiques();
                    break;
                case "Llibres tematiques":
                    columns = valorsHeaderLlibre();
                    rows = CtrlInterficie.consultarLlibresTematica(contingutIntrValors);
                    valorsReduitsLlibres(rows);
                    tipusLlibre = true;
                    break;
            }
            PropTableModel myData = setModelTable(columns,rows);
            return myData;
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No existeix cap tematica amb nom " + contingutIntrValors,"Info",JOptionPane.INFORMATION_MESSAGE);
            return null;
        }
    }
        
    private void consultaTematica() {
        try {
            PropTableModel myData = valorsModelTematica();
            if (myData != null) {
                JTable taulaTematiques = setTaula(myData);
                if (tipusLlibre) tipusLlibre = false;
                MostraResult.setViewportView(taulaTematiques);
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    
    private ArrayList<String> valorsHeaderLlibre() {
        ArrayList<String> columns = new ArrayList<String>();
        columns.add("ISBN");
        columns.add("Titol");
        columns.add("Autor");
        columns.add("Any");
        columns.add("Tematica");
        return columns;
    }
    
    private void valorsReduitsLlibres(ArrayList<ArrayList<String> > rows) {
        for(int i = 0; i < rows.size(); ++i) {
            rows.get(i).remove(5);
            rows.get(i).remove(3);
        }
    }
    
    private PropTableModel valorsModelLlibre(boolean inException) {
        try {
            ArrayList<String> columns = valorsHeaderLlibre();
            ArrayList<ArrayList<String> > rows = new ArrayList<ArrayList<String> >();
            if (!inException) {
                switch(funcionsSeleccioItem) {
                    case "Tots els llibres":
                        rows = CtrlInterficie.seleccionaAllLlibres();
                        break;
                    case "Consulta per títol":
                        rows = CtrlInterficie.consultaLlibresTitol(contingutIntrValors);
                        break;
                    case "Consulta per autor":
                        rows = CtrlInterficie.consultaLlibresAutor(contingutIntrValors);
                        break;
                    case "Consulta per isbn":
                        rows = CtrlInterficie.consultaLlibresPerISBN(contingutIntrValors);
                        break;
                    case "Consulta per any":
                        rows = CtrlInterficie.consultaLlibresAny(Integer.parseInt(contingutIntrValors));
                        break;
                    case "Consulta per editorial":
                        rows = CtrlInterficie.consultaLlibresEditorial(contingutIntrValors);
                        break;
                    case "Consulta ordenacio":
                        columns.remove(0);
                        columns.add(0,"Estanteria");
                        columns.add(1,"ISBN");
                        rows = CtrlInterficie.consultarOrdenacioBiblioTotal();
                        for (int i = 0; i < rows.size(); ++i) {
                            String estanteria = rows.get(i).get(7);
                            rows.get(i).remove(7);
                            rows.get(i).remove(5);
                            rows.get(i).remove(3);
                            rows.get(i).add(0,estanteria);
                        }
                        tipusOrdenacio = true;
                        break;
                }
            }
            if (!tipusOrdenacio) valorsReduitsLlibres(rows);
            PropTableModel myData = setModelTable(columns,rows);
            return myData;
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return valorsModelLlibre(true);
        }
    }
    
    private void consultaLlibre() {
        try {
            PropTableModel myData = valorsModelLlibre(false);
            tipusLlibre = true;
            final JTable taulaLlibres = setTaula(myData);
            tipusLlibre = false;
            if (tipusOrdenacio)tipusOrdenacio = false;
            MostraResult.setViewportView(taulaLlibres);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    private PropTableModel valorsModelEstanteria() {
        try {
            ArrayList<String> columns = new ArrayList<String>();
            ArrayList<ArrayList<String> > rows = new ArrayList<ArrayList<String> >();
            switch(funcionsSeleccioItem) {
                case "Totes estanteries":
                    columns.add("Coordenada X");
                    columns.add("Coordenada Y");
                    columns.add("Num Files");
                    columns.add("Llargada");
                    rows = CtrlInterficie.seleccionaAllEstanteries();
                    break;
                case "Llibres estanteria":
                    String coordenades[] = IntroduccioDades.getText().split(",");
                    if (coordenades.length != 2) throw new Exception("Valors introduits incorrectament");
                    int x = Integer.parseInt(coordenades[0]);
                    int y = Integer.parseInt(coordenades[1]);
                    rows = CtrlInterficie.consultarLlibresEstanteria(x,y);
                    columns = valorsHeaderLlibre();
                    break;
            }
            PropTableModel myData = setModelTable(columns,rows);
            return myData;
        }
        catch (Exception e) {
            String missatge;
            if (e.getMessage().equals("Valors introduits incorrectament")) missatge = "Recorda que el model per consultar dades es el següent: x,y";
            else missatge = "No existeix cap estanteria amb aquestes coordenades";
            JOptionPane.showMessageDialog(null, missatge,"Info",JOptionPane.INFORMATION_MESSAGE);
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    private void consultaEstanteria() {
        try {
            PropTableModel myData = valorsModelEstanteria();
            JTable taulaEstanteries = setTaula(myData);
            MostraResult.setViewportView(taulaEstanteries);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    private boolean haIntroduitDades() {
        String s[] = contingutIntrValors.split(" ");
        return !s[0].equals("Introdueix");
    }
    
    private void Consulta() {
        try {
            getComboBoxItems();
            if (haIntroduitDades()) {
                switch (SeleccioItem) {
                    case "Area":
                    consultaArea();
                    break;
                    case "Seccio":
                    consultaSeccio();
                    break;
                    case "Tematica":
                    consultaTematica();
                    break;
                    case "Llibre":
                    consultaLlibre();
                    break;
                    case "Estanteria":
                    consultaEstanteria();
                    break;
                }
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton EnrereButton;
    private javax.swing.JPanel Fons;
    private javax.swing.JTextField IntroduccioDades;
    private javax.swing.JScrollPane MostraResult;
    private javax.swing.JButton OKButton;
    private javax.swing.JComboBox Seleccio;
    private javax.swing.JComboBox funcionsSeleccio;
    // End of variables declaration//GEN-END:variables
}
