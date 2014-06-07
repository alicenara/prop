package propLlibreria.Interficie;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JViewport;
import javax.swing.SwingUtilities;
import javax.swing.table.TableModel;

public class VistaOrdenat extends javax.swing.JPanel {

    ArrayList<ArrayList<String> > est = new ArrayList<ArrayList<String> >();
    boolean parcial=false;
    
    public VistaOrdenat(ArrayList<ArrayList<String> > e) {
        initComponents();
        if (e==null) parcial=false;
        else {
            est=e;
            parcial=true; 
        }
        mostrarLlibresEstanteries();  
    }
    private void mostrarLlibresEstanteries(){
        try {
            PropTableModel myData = new PropTableModel();
            ArrayList<String> columns = new ArrayList<String>();
            ArrayList<ArrayList<String> > result = new ArrayList<ArrayList<String> >();
            ArrayList<ArrayList<String> > rows = new ArrayList<ArrayList<String> >();            
            columns.add("Estanteria");
            columns.add("ISBN");
            columns.add("Títol");
            columns.add("Autor");
            columns.add("Any");
            if(parcial) result = CtrlInterficie.consultarOrdenacioBiblioParcial(est);
            else result = CtrlInterficie.consultarOrdenacioBiblioTotal();
            for (int i=0; i<result.size();i++){
                ArrayList<String> row= new ArrayList<String>();
                row.add(result.get(i).get(result.get(i).size()-1));
                row.add(result.get(i).get(0));
                row.add(result.get(i).get(1));
                row.add(result.get(i).get(2));
                row.add(result.get(i).get(4));
                
                rows.add(row);
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
    
   
    private void print(String ruta) {
        Document document = new Document(PageSize.A4);
        
        try {
            PdfWriter.getInstance(document,
                new FileOutputStream(ruta));
            
            Font titolPrin = new Font(Font.FontFamily.HELVETICA, 25, Font.BOLD | Font.UNDERLINE);
            Font headerstable = new Font(Font.FontFamily.HELVETICA, 13, Font.BOLD);
            Font cells = new Font(Font.FontFamily.HELVETICA, 11);            
            
            document.open();
            
            //Title
            Paragraph p = new Paragraph("Llista de llibres ordenats", titolPrin);
            p.setSpacingAfter(50);
            p.setAlignment(Element.ALIGN_CENTER);
            document.add(p);

            PdfPTable table = new PdfPTable(5); // 5 columns.
            float[] columnWidths = {2f, 2f, 2f, 2f, 1f};
            table.setWidths(columnWidths);
            
            //Table headers
            PdfPCell estant = new PdfPCell(new Paragraph("Estanteria",headerstable));
            PdfPCell isbn = new PdfPCell(new Paragraph("ISBN",headerstable));
            PdfPCell titol = new PdfPCell(new Paragraph("Títol",headerstable));
            PdfPCell autor = new PdfPCell(new Paragraph("Autor",headerstable));
            PdfPCell any = new PdfPCell(new Paragraph("Any",headerstable));
            
            //Formatting cells
            estant.setPadding(5);
            isbn.setPadding(5);
            titol.setPadding(5);
            autor.setPadding(5);
            any.setPadding(5);
            
            estant.setBorderWidth(3f);
            estant.setBorderColor(BaseColor.BLACK);
            isbn.setBorderWidth(3f);
            isbn.setBorderColor(BaseColor.BLACK);
            titol.setBorderWidth(3f);
            titol.setBorderColor(BaseColor.BLACK);
            autor.setBorderWidth(3f);
            autor.setBorderColor(BaseColor.BLACK);
            any.setBorderWidth(3f);
            any.setBorderColor(BaseColor.BLACK);
            
            //Add to table
            table.addCell(estant);
            table.addCell(isbn);
            table.addCell(titol);
            table.addCell(autor);
            table.addCell(any);            
           
            ArrayList<ArrayList<String> >  result = null;
            if(parcial) result = CtrlInterficie.consultarOrdenacioBiblioParcial(est);
            else result = CtrlInterficie.consultarOrdenacioBiblioTotal();
            
            for (int i=0; i<result.size();i++){
                ArrayList<String> row= new ArrayList<String>();
                //Content
                PdfPCell est1 = new PdfPCell(new Paragraph(result.get(i).get(result.get(i).size()-1),cells));
                PdfPCell isbn2 = new PdfPCell(new Paragraph(result.get(i).get(0),cells));
                PdfPCell titol3 = new PdfPCell(new Paragraph(result.get(i).get(1),cells));
                PdfPCell autor4 = new PdfPCell(new Paragraph(result.get(i).get(2),cells));
                PdfPCell any5 = new PdfPCell(new Paragraph(result.get(i).get(4),cells));
                
                //Formatting 
                est1.setPadding(5);
                isbn2.setPadding(5);
                titol3.setPadding(5);
                autor4.setPadding(5);
                any5.setPadding(5);
            
                //Add to table
                table.addCell(est1);
                table.addCell(isbn2);
                table.addCell(titol3);
                table.addCell(autor4);
                table.addCell(any5);
            }            
            document.add(table);

            document.close();         
        } catch (Exception e) {
          System.err.println(e.getMessage());
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

        setBackground(new java.awt.Color(212, 220, 245));

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
                        .addGap(2, 2, 2)
                        .addComponent(bPDF)
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(bSortir, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(bPDF, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void bSortirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSortirActionPerformed
        JFrame v = (JFrame)SwingUtilities.getWindowAncestor(this);
        v.dispose();
    }//GEN-LAST:event_bSortirActionPerformed

    private void bPDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bPDFActionPerformed
        java.util.Date date= new java.util.Date();
        String temps = new SimpleDateFormat("ddMMyykkmmss").format(date);
        JFileChooser fc = new JFileChooser();
        fc.setSelectedFile(new File("OrdenacióLlibres"+temps+".pdf"));
        int okCancel = fc.showSaveDialog(null);
        if(okCancel==0){
            String ruta=fc.getSelectedFile().toString();
            String comprovacio = ruta.substring(ruta.length()-4);
            System.out.println(comprovacio);
            if (!comprovacio.toLowerCase().equals(".pdf")){
                ruta+=".pdf";
            }
            print(ruta);
        }        
    }//GEN-LAST:event_bPDFActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane TaulaOrdenada;
    private javax.swing.JButton bPDF;
    private javax.swing.JButton bSortir;
    private javax.swing.JTable taulaResult;
    // End of variables declaration//GEN-END:variables
}
