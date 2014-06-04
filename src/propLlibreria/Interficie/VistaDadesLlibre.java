package propLlibreria.Interficie;
import java.util.ArrayList;

public class VistaDadesLlibre extends javax.swing.JPanel {
    String isbn="";
    
    public VistaDadesLlibre(String isbn) {
        initComponents();
        this.isbn=isbn;
        carregarCamps();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labTitol = new javax.swing.JLabel();
        labISBN = new javax.swing.JLabel();
        labAutor = new javax.swing.JLabel();
        labEditorial = new javax.swing.JLabel();
        labAny = new javax.swing.JLabel();
        labTemPrin = new javax.swing.JLabel();
        labTemSec = new javax.swing.JLabel();
        ISBN = new javax.swing.JLabel();
        Titol = new javax.swing.JLabel();
        Autor = new javax.swing.JLabel();
        Editorial = new javax.swing.JLabel();
        Any = new javax.swing.JLabel();
        TemPrin = new javax.swing.JLabel();
        TemSec = new javax.swing.JLabel();
        labEstant = new javax.swing.JLabel();
        Estant = new javax.swing.JLabel();
        Imatge = new javax.swing.JLabel();
        Edicio = new javax.swing.JLabel();
        labEdicio = new javax.swing.JLabel();

        labTitol.setFont(new java.awt.Font("Arial Unicode MS", 1, 15)); // NOI18N
        labTitol.setText("Titol:");

        labISBN.setFont(new java.awt.Font("Arial Unicode MS", 1, 15)); // NOI18N
        labISBN.setText("ISBN:");

        labAutor.setFont(new java.awt.Font("Arial Unicode MS", 1, 15)); // NOI18N
        labAutor.setText("Autor:");

        labEditorial.setFont(new java.awt.Font("Arial Unicode MS", 1, 15)); // NOI18N
        labEditorial.setText("Editorial:");

        labAny.setFont(new java.awt.Font("Arial Unicode MS", 1, 15)); // NOI18N
        labAny.setText("Any:");

        labTemPrin.setFont(new java.awt.Font("Arial Unicode MS", 1, 15)); // NOI18N
        labTemPrin.setText("Temàtica principal:");

        labTemSec.setFont(new java.awt.Font("Arial Unicode MS", 1, 15)); // NOI18N
        labTemSec.setText("Tematiques secundàries:");

        ISBN.setFont(new java.awt.Font("Arial Unicode MS", 0, 13)); // NOI18N
        ISBN.setText("result");

        Titol.setFont(new java.awt.Font("Arial Unicode MS", 0, 13)); // NOI18N
        Titol.setText("result");

        Autor.setFont(new java.awt.Font("Arial Unicode MS", 0, 13)); // NOI18N
        Autor.setText("result");

        Editorial.setFont(new java.awt.Font("Arial Unicode MS", 0, 13)); // NOI18N
        Editorial.setText("result");

        Any.setFont(new java.awt.Font("Arial Unicode MS", 0, 13)); // NOI18N
        Any.setText("result");

        TemPrin.setFont(new java.awt.Font("Arial Unicode MS", 0, 13)); // NOI18N
        TemPrin.setText("result");

        TemSec.setFont(new java.awt.Font("Arial Unicode MS", 0, 13)); // NOI18N
        TemSec.setText("result");

        labEstant.setFont(new java.awt.Font("Arial Unicode MS", 1, 15)); // NOI18N
        labEstant.setText("Estanteria:");

        Estant.setFont(new java.awt.Font("Arial Unicode MS", 0, 13)); // NOI18N
        Estant.setText("result");

        Imatge.setIcon(new javax.swing.ImageIcon(getClass().getResource("/propLlibreria/Interficie/icons/llibrepetit.png"))); // NOI18N

        Edicio.setFont(new java.awt.Font("Arial Unicode MS", 0, 13)); // NOI18N
        Edicio.setText("result");

        labEdicio.setFont(new java.awt.Font("Arial Unicode MS", 1, 15)); // NOI18N
        labEdicio.setText("Edició:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(Imatge)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labEditorial)
                            .addComponent(labAutor))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Autor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Editorial, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labISBN)
                            .addComponent(labTitol))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(Titol, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(ISBN, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(labTemPrin)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(TemPrin, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(labEdicio)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(Edicio, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(labAny)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(Any, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(labTemSec)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(TemSec, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(labEstant)
                            .addGap(27, 27, 27)
                            .addComponent(Estant, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(114, 114, 114)
                        .addComponent(Imatge))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labISBN)
                            .addComponent(ISBN))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labTitol)
                            .addComponent(Titol))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labAutor)
                            .addComponent(Autor))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labEditorial)
                            .addComponent(Editorial))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labAny)
                            .addComponent(Any))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labEdicio)
                            .addComponent(Edicio))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labTemPrin)
                            .addComponent(TemPrin))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labTemSec)
                            .addComponent(TemSec, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Estant, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labEstant))))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        getAccessibleContext().setAccessibleName("Dades del llibre");
    }// </editor-fold>//GEN-END:initComponents

     private void carregarCamps(){
        ArrayList<ArrayList<String>> llibre = new ArrayList<ArrayList<String>>();
        llibre=CtrlInterficie.consultaLlibresPerISBN(isbn);
        ArrayList<String> llib=llibre.get(0);
        try{
            llibre=CtrlInterficie.consultaTematiquesSLlibre(llib.get(1), llib.get(2), Integer.parseInt(llib.get(4)));
        }catch(Exception e){
            System.out.println(e);
        }
        ArrayList<String> temS=llibre.get(0);
        ArrayList<String> est;
        try{
            llibre=CtrlInterficie.getEstanteriaLlibre(llib.get(1), llib.get(2), Integer.parseInt(llib.get(4)));
        }catch(Exception e){
            est = null;
        }
        est=llibre.get(0);
        ISBN.setText(llib.get(0));
        Titol.setText(llib.get(1));
        Autor.setText(llib.get(2));
        Editorial.setText(llib.get(3));
        Any.setText(llib.get(4));
        Edicio.setText(llib.get(5));
        TemPrin.setText(llib.get(6));
        String temSec="<html>";
        for(int i=0;i<temS.size();i++){
            temSec+=temS.get(i);
            if(i<temS.size()-1) temSec+=", ";         
        }
        temSec+="</html>";
        TemSec.setText(temSec);
        String estanteria="<html>";
        if(est!=null){
            estanteria+="Coordenades: "+est.get(0);
            estanteria+="<br> Fila: "+est.get(0);
            estanteria+="<br> Posició en la fila: "+est.get(0);
        }else{
            estanteria+="No està ordenat."
        }       
        estanteria+="</html>";
        Estant.setText(estanteria);
        
     }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Any;
    private javax.swing.JLabel Autor;
    private javax.swing.JLabel Edicio;
    private javax.swing.JLabel Editorial;
    private javax.swing.JLabel Estant;
    private javax.swing.JLabel ISBN;
    private javax.swing.JLabel Imatge;
    private javax.swing.JLabel TemPrin;
    private javax.swing.JLabel TemSec;
    private javax.swing.JLabel Titol;
    private javax.swing.JLabel labAny;
    private javax.swing.JLabel labAutor;
    private javax.swing.JLabel labEdicio;
    private javax.swing.JLabel labEditorial;
    private javax.swing.JLabel labEstant;
    private javax.swing.JLabel labISBN;
    private javax.swing.JLabel labTemPrin;
    private javax.swing.JLabel labTemSec;
    private javax.swing.JLabel labTitol;
    // End of variables declaration//GEN-END:variables
}
