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
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {        
        javax.swing.SwingUtilities.invokeLater (
            new Runnable() {
                public void run() {
                    CtrlInterficie ctrlInterficie = new CtrlInterficie();
                    ctrlInterficie.inicialitzarInterficies();
                }
            }
        );
    }
    
}
