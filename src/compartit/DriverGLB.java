package compartit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Driver per provar GLB
 * @author Joan Vilatimó Quilez
 */
public class DriverGLB {
    /**
     * 
     * @param args the command line arguments
     * @throws java.io.IOException
    */
    public static void main(String[] args) throws IOException {
        String linia;
        String[] paraules;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Driver Gilmore-Lawler Bound");
        System.out.println("Introdueix el numero de planetes:");
        linia = reader.readLine();
        paraules = linia.split(" ");
        int n = Integer.parseInt(paraules[0]);
        double[][] dist2 = new double[n][n];
        System.out.println("Introdueix la matriu de distancies:");
        for (int i = 0; i < n; ++i) {
            linia = reader.readLine();
            paraules = linia.split(" ");
            for (int j = 0; j < n; ++j) {
                dist2[i][j] = Double.parseDouble(paraules[j]);
            }
        }
        double[][] afin2 = new double[n][n];
        System.out.println("Introdueix la matriu d'afinitats:");
        for (int i = 0; i < n; ++i) {
            linia = reader.readLine();
            paraules = linia.split(" ");
            for (int j = 0; j < n; ++j) {
                afin2[i][j] = Double.parseDouble(paraules[j]);
            }
        }
        
        //algortime
        double fita = GLB.calcularFita(afin2, dist2);
        //imprimir fita
        System.out.println("Fita="+fita);
    }
}
