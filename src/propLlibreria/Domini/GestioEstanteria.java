package propLlibreria.Domini;

import java.util.*;

public class GestioEstanteria {
    private static HashMap<Integer, Estanteria> est = new HashMap<Integer, Estanteria>();
    private static int ide = 0;
    
    public static void setIde(int id){
        ide=id;
    }
    
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

    public static void esborrarEstanteriaID(int ID){
            est.remove(ID);
    }
    
    public static Estanteria getEstanteriaCoord(int x, int y) {
            Iterator<Integer> iterador = est.keySet().iterator();
            Integer key = 0;
            boolean trobat = false;
            while(iterador.hasNext() && !trobat){
              key = iterador.next();
              if (est.get(key).getPosX() == x && est.get(key).getPosY() == y) trobat = true;
            }
            if (trobat) return est.get(key);
            else return null;
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
