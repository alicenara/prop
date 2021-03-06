package propLlibreria.Domini;

import java.util.*;

public class GestioLlibre {
    private static HashMap<Integer, Llibre> llibre = new HashMap<Integer, Llibre>();
    private static int idl = 0;
    
    public static void setIdl(int id){
        idl=id;
    }
    public static int ultimaIDLlibre(){
            ++idl;
            return idl;
    }
    
    public static Llibre getLlibre(int ID){
            return llibre.get(ID);
    }
    
    public static ArrayList<Llibre> getLlibreTitol(String titol){
            ArrayList<Llibre> llibresTitol = new ArrayList<Llibre>();
            Iterator<Integer> iterador = llibre.keySet().iterator();
            Integer key = 0;
            while(iterador.hasNext()){
              key = iterador.next();
              if (llibre.get(key).getTitol().equals(titol)) llibresTitol.add(llibre.get(key));
            }
            return llibresTitol;
    }
	
    public static ArrayList<Llibre> getLlibreISBN(String isbn){
            ArrayList<Llibre> llibresIsbn = new ArrayList<Llibre>();
            Iterator<Integer> iterador = llibre.keySet().iterator();
            Integer key = 0;
            while(iterador.hasNext()){
              key = iterador.next();
              if (llibre.get(key).getIsbn().equals(isbn)) llibresIsbn.add(llibre.get(key));
            }
            return llibresIsbn;
    }

    public static ArrayList<Llibre> getLlibresAutor(String autor) {
            ArrayList<Llibre> llibresAutor = new ArrayList<Llibre>();
            Iterator<Integer> iterador = llibre.keySet().iterator();
            Integer key = 0;
            while(iterador.hasNext()){
              key = iterador.next();
              if (llibre.get(key).getAutor().equals(autor)) llibresAutor.add(llibre.get(key));
            }
            return llibresAutor;
    }

    public static ArrayList<Llibre> getLlibresAny(int any) {
            ArrayList<Llibre> llibresAny = new ArrayList<Llibre>();
            Iterator<Integer> iterador = llibre.keySet().iterator();
            Integer key = 0;
            while(iterador.hasNext()){
              key = iterador.next();
              if (llibre.get(key).getAny() == any) llibresAny.add(llibre.get(key));
            }
            return llibresAny;
    }

    public static ArrayList<Llibre> getLlibresEditorial(String editorial) {
            ArrayList<Llibre> llibresEditorial = new ArrayList<Llibre>();
            Iterator<Integer> iterador = llibre.keySet().iterator();
            Integer key = 0;
            while(iterador.hasNext()){
              key = iterador.next();
              if (llibre.get(key).getEditorial().equals(editorial)) llibresEditorial.add(llibre.get(key));
            }
            return llibresEditorial;
    }
    
     public static Llibre getLlibreTAA(String titol, String autor, int any) {
            Iterator<Integer> iterador = llibre.keySet().iterator();
            Integer key = 0;
            boolean trobat = false;
            while(iterador.hasNext() && !trobat){
              key = iterador.next();
              Llibre lli = llibre.get(key);
              if (lli.getTitol().equals(titol) && lli.getAutor().equals(autor) && lli.getAny() == any) trobat = true;
            }
            if (trobat) return llibre.get(key);
            else return null;
    }
    
    public static void afegirLlibre(Llibre l){
            llibre.put(l.getID(), l);
    }
	
    public static void esborrarLlibreID(int ID){
            llibre.remove(ID);
    }
    
    public static ArrayList<Llibre> getAllLlibres() {
            ArrayList<Llibre> allLlibres = new ArrayList<Llibre>();
            Iterator<Integer> iterador = llibre.keySet().iterator();
            Integer key = 0;
            while(iterador.hasNext()){
              key = iterador.next();
              allLlibres.add(llibre.get(key));
            }
            return allLlibres;
    }
    
    public static ArrayList<Tematica> getTematiquesSecundaries(int IDL) {
            Llibre l = getLlibre(IDL);
            return l.getTematiquesSecundaries();
    }
    
    public static boolean existeixLlibre(String titol, String autor, int any){
            Llibre l = getLlibreTAA(titol,autor,any);
            if(l == null) return false;
            return llibre.containsKey(l.getID());
    }
    
}
