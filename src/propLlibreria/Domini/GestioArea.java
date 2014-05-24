package propLlibreria.Domini;

import java.util.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sergibdn94
 */
public class GestioArea {
    private static HashMap<Integer, Area> area = new HashMap<Integer, Area>();
    private static HashMap<Integer, Seccio> sec = new HashMap<Integer, Seccio>();
    private static HashMap<Integer, Tematica> tem = new HashMap<Integer, Tematica>();
    
    private static int ida = 0;
    private static int ids = 0;
    private static int idt = 0;
 
    public static int ultimaIDArea(){
            ++ida;
            return ida;
    }
    
    public static int ultimaIDSeccio(){
            ++ids;
            return ids;
    }
    
    public static int ultimaIDTematica(){
            ++idt;
            return idt;
    }
    
    public static Area getArea(int ID){
            return area.get(ID);
    }
    
    public static Seccio getSeccio(int ID){
            return sec.get(ID);
    }

    public static Tematica getTematica(int ID){
            return tem.get(ID);
    }
    
    public static Area getAreaN(String nomA){
            Iterator<Integer> iterador = area.keySet().iterator();
            Integer key = 0;
            boolean trobat = false;
            while(iterador.hasNext() && !trobat){
              key = iterador.next();
              if (area.get(key).getNomArea().equals(nomA)) trobat = true;
            }
            if (trobat) return area.get(key);
            else return null;
    }
    
    public static Seccio getSeccioN(String nomS){
            Iterator<Integer> iterador = sec.keySet().iterator();
            Integer key = 0;
            boolean trobat = false;
            while(iterador.hasNext() && !trobat){
              key = iterador.next();
              if (sec.get(key).getNomSeccio().equals(nomS)) trobat = true;
            }
            if (trobat) return sec.get(key);
            else return null;
    }
    
    public static Tematica getTematicaN(String nomT){
            Iterator<Integer> iterador = tem.keySet().iterator();
            Integer key = 0;
            boolean trobat = false;
            while(iterador.hasNext() && !trobat){
              key = iterador.next();
              if (tem.get(key).getNomTematica().equals(nomT)) trobat = true;
            }
            if (trobat) return tem.get(key);
            else return null;
    }
    
    public static void afegirArea(Area a){
            area.put(a.getID(), a);
    }
	
    public static void esborrarArea(Area a){
            esborrarAreaID(a.getID());
    }
    
    public static void afegirSeccio(Seccio s){	  	
            sec.put(s.getID(), s);
    }	  	
	
    public static void esborrarSeccio(Seccio s){
            esborrarSeccioID(s.getID());
    }
	  	
    public static void afegirTematica(Tematica t){
            tem.put(t.getID(), t);
    }
  
    public static void esborrarTematica(Tematica t){
            esborrarTematicaID(t.getID());  	
    }
    
    public static void esborrarAreaID(int ID){
            area.remove(ID);
    }
    
    public static void esborrarSeccioID(int ID){
            sec.remove(ID);
    }

    public static void esborrarTematicaID(int ID){
            tem.remove(ID);
    }
    
    public static ArrayList<Area> getAllArees() {
            ArrayList<Area> allArees = new ArrayList<Area>();
            Iterator<Integer> iterador = area.keySet().iterator();
            Integer key = 0;
            while(iterador.hasNext()){
              key = iterador.next();
              allArees.add(area.get(key));
            }
            return allArees;
    }
    
    public static ArrayList<Seccio> getAllSeccions() {
            ArrayList<Seccio> allSeccions = new ArrayList<Seccio>();
            Iterator<Integer> iterador = sec.keySet().iterator();
            Integer key = 0;
            while(iterador.hasNext()){
              key = iterador.next();
              allSeccions.add(sec.get(key));
            }
            return allSeccions;
    }

    public static ArrayList<Tematica> getAllTematiques() {
            ArrayList<Tematica> allTematiques = new ArrayList<Tematica>();
            Iterator<Integer> iterador = tem.keySet().iterator();
            Integer key = 0;
            while(iterador.hasNext()){
              key = iterador.next();
              allTematiques.add(tem.get(key));
            }
            return allTematiques;
    }
    
    public static boolean existeixArea(int ID){
            return area.containsKey(ID);
    }
        
    public static boolean existeixSeccio(int ID){
            return sec.containsKey(ID);
    }

    public static boolean existeixTematica(int ID){
            return tem.containsKey(ID);
    }    
    
}
