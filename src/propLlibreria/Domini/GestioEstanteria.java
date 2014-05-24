/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package propLlibreria.Domini;

import java.util.*;

/**
 *
 * @author sergibdn94
 */
public class GestioEstanteria {
    private static HashMap<Integer, Estanteria> est = new HashMap<Integer, Estanteria>();
    private static int ide = 0;
    
    public static int ultimaIDEstanteria(){
            ++ide;
            return ide;
    }
    
    public static Estanteria getEstanteria(int ID){
            return est.get(ID);
    }
    
    public static void afegirEstanteria(Estanteria e){
            est.put(e.getID(), e);
    }

    public static void esborrarEstanteria(Estanteria e){
            esborrarEstanteriaID(e.getID());
    }
    
    public static void esborrarEstanteriaID(int ID){
            est.remove(ID);
    }
    
    public static ArrayList <Estanteria> getAllEstanteries() {
            ArrayList<Estanteria> allEstanteries = new ArrayList<Estanteria>();
            Iterator<Integer> iterador = est.keySet().iterator();
            Integer key = 0;
            while(iterador.hasNext()){
              key = iterador.next();
              allEstanteries.add(est.get(key));
            }
            return allEstanteries;
    }
    
    public static boolean existeixEstanteria(int ID){
            return est.containsKey(ID);
    }

}
