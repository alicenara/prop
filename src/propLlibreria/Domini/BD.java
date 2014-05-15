package propLlibreria.Domini;
import java.util.*;

public class BD {
	private static Hashtable<Integer, Area> area = new Hashtable<Integer, Area>();
	private static Hashtable<Integer, Bibliotecari> bcari = new Hashtable<Integer, Bibliotecari>();
	private static Hashtable<Integer, Estanteria> est = new Hashtable<Integer, Estanteria>();
	private static Hashtable<Integer, Llibre> llibre = new Hashtable<Integer, Llibre>();
	private static Hashtable<Integer, Seccio> sec = new Hashtable<Integer, Seccio>();
	private static Hashtable<Integer, Tematica> tem = new Hashtable<Integer, Tematica>();
	private static int ida = 0;
	private static int idb = 0;
	private static int ide = 0;
	private static int idl = 0;
	private static int ids = 0;
	private static int idt = 0;
	
	public static void omplirBD(){
           
            // AREA           
                
		ArrayList<String[]> arees = CtrlBD.obtenirTotesArees();
		for (int i=0; i<arees.size();i++){
			Area aux;
			String[] prop=arees.get(i);
                        if(!prop.equals("")){
                            aux = new Area(Integer.parseInt(prop[0]),prop[1]);
                            area.put(aux.getID(),aux);
                            if(ida<Integer.parseInt(prop[0]))
                                ida=Integer.parseInt(prop[0]);
                        }
		}	
	
            // BIBLIOTECARI
                
                ArrayList<String[]> persones = CtrlBD.obtenirTotsBcaris();
                for (int i=0; i<persones.size();i++){
			Bibliotecari aux;
			String[] prop=persones.get(i);
                        if(!prop.equals("")){
                            aux = new Bibliotecari(Integer.parseInt(prop[0]), prop[1]);
                            bcari.put(aux.getID(),aux);
                            if(idb<Integer.parseInt(prop[0]))
                                idb=Integer.parseInt(prop[0]);
                        }
		}
            
            // ESTANTERIA
                
                ArrayList<String[]> estant = CtrlBD.obtenirTotesEstanteries();
		estant = CtrlBD.obtenirTotesEstanteries();
                for (int i=0; i<estant.size();i++){
			Estanteria aux;
			String[] prop=estant.get(i);
                        if(!prop.equals("")){
                            ArrayList<Integer> llibres = new ArrayList<Integer>();
                            for (int j=5; j<prop.length; j++){
                                    llibres.add(Integer.parseInt(prop[j]));
                            }
                            aux = new Estanteria(Integer.parseInt(prop[0]),Integer.parseInt(prop[1]),Integer.parseInt(prop[2]),Integer.parseInt(prop[3]),Integer.parseInt(prop[4]),llibres);
                            est.put(aux.getID(),aux);
                            if(ide<Integer.parseInt(prop[0]))
                                ide=Integer.parseInt(prop[0]);
                        }
		}
                
            // LLIBRE
                
                ArrayList<String[]> llibres = CtrlBD.obtenirTotsLlibres();
                for (int i=0; i<llibres.size();i++){
			Llibre aux;
			String[] prop=llibres.get(i);
                        if(!prop.equals("")){
                            ArrayList<Integer> temSecun = new ArrayList<Integer>();
                            for (int j=8; j<prop.length; j++){
                                    temSecun.add(Integer.parseInt(prop[j]));
                            }
                            aux = new Llibre(Integer.parseInt(prop[0]),prop[1],prop[2],prop[3],prop[4],Integer.parseInt(prop[5]),Integer.parseInt(prop[6]),Integer.parseInt(prop[7]),temSecun);
                            llibre.put(aux.getID(),aux);
                            if(idl<Integer.parseInt(prop[0]))
                                idl=Integer.parseInt(prop[0]);
                        }
                }
                
            // SECCIO
                
                ArrayList<String[]> seccio = CtrlBD.obtenirTotesSec();
                for (int i=0; i<seccio.size();i++){
			Seccio aux;
			String[] prop=seccio.get(i);
                        if(!prop.equals("")){
                            aux = new Seccio(Integer.parseInt(prop[0]),prop[1],Integer.parseInt(prop[2]));
                            sec.put(aux.getID(),aux);
                            if(ids<Integer.parseInt(prop[0]))
                                ids=Integer.parseInt(prop[0]);
                        }
		}
                
            // TEMATICA
                
                ArrayList<String[]> tema = CtrlBD.obtenirTotesTem();
                for (int i=0; i<tema.size();i++){
			Tematica aux;
			String[] prop=tema.get(i);
                        if(!prop.equals("")){
                            ArrayList<Integer> llib = new ArrayList<Integer>();
                            for (int j=3; j<prop.length; j++){
                                    llib.add(Integer.parseInt(prop[j]));
                            }
                            aux = new Tematica(Integer.parseInt(prop[0]),prop[1],Integer.parseInt(prop[2]),llib);
                            tem.put(aux.getID(),aux);
                            if(idt<Integer.parseInt(prop[0]))
                                idt=Integer.parseInt(prop[0]);
                        }
			
		}
        }
	
	public static void desarBD(){
            
            // AREA            
                Iterator<Integer> ia = area.keySet().iterator();
		Integer key = 0;
		ArrayList<String[]> a = new ArrayList<String[]>();
		while(ia.hasNext()){
                    key = ia.next();
                    String[] aux = {Integer.toString(area.get(key).getID()),area.get(key).getNomArea()};
                    a.add(aux);
		}
                CtrlBD.desarTotesArees(a);
                
            // BIBLIOTECARI
                Iterator<Integer> ib = bcari.keySet().iterator();
		key = 0;
                ArrayList<String[]> b = new ArrayList<String[]>();
		while(ib.hasNext()){
                    key = ib.next();
                    String[] aux = {Integer.toString(bcari.get(key).getID()),bcari.get(key).getContrasenya()};
                    b.add(aux);
		}                
		CtrlBD.desarTotsBibliotecaris(b);
                
            // ESTANTERIA
                Iterator<Integer> ic = est.keySet().iterator();
		key = 0;
                ArrayList<String[]> e = new ArrayList<String[]>();
		while(ic.hasNext()){
                        key = ic.next();
			ArrayList<String> aux = new ArrayList<String>();
			aux.add(Integer.toString(est.get(key).getID()));
			aux.add(Integer.toString(est.get(key).getNumFiles()));
			aux.add(Integer.toString(est.get(key).getLlargada()));
			aux.add(Integer.toString(est.get(key).getPosX()));
			aux.add(Integer.toString(est.get(key).getPosY()));
			
			ArrayList<Llibre> llibreAux = est.get(key).getLlibres();
			for(int j=0; j<llibreAux.size();j++){
				aux.add(Integer.toString(llibreAux.get(j).getID()));
			}
			String[] result= aux.toArray(new String[aux.size()]);
			e.add(result);
		}
		CtrlBD.desarTotesEstanteries(e);
                
            // LLIBRE
                Iterator<Integer> id = llibre.keySet().iterator();
		key = 0;
                ArrayList<String[]> l = new ArrayList<String[]>();
		while(id.hasNext()){
                        key = id.next();			
			ArrayList<String> aux = new ArrayList<String>();
			aux.add(Integer.toString(llibre.get(key).getID()));
			aux.add(llibre.get(key).getIsbn());
			aux.add(llibre.get(key).getTitol());
			aux.add(llibre.get(key).getAutor());
			aux.add(llibre.get(key).getEditorial());
			aux.add(Integer.toString(llibre.get(key).getAny()));
			aux.add(Integer.toString(llibre.get(key).getEdicio()));
                        Tematica t=llibre.get(key).getTemPrincipal();
			aux.add(Integer.toString(t.getID()));
			
			ArrayList<Tematica> temAux = llibre.get(key).getTematiquesSecundaries();
			for(int j=0; j<temAux.size();j++){
				aux.add(Integer.toString(temAux.get(j).getID()));
			}
			
			String[] result= aux.toArray(new String[aux.size()]);			
			l.add(result);
		}
		CtrlBD.desarTotsLlibres(l);
                
            //SECCIO 
                Iterator<Integer> ie = sec.keySet().iterator();
		key = 0;
                ArrayList<String[]> s = new ArrayList<String[]>();
		while(ie.hasNext()){
                        key = ie.next();
			String[] aux = {Integer.toString(sec.get(key).getID()),sec.get(key).getNomSeccio(),Integer.toString(sec.get(key).getIDAreaSeccio())};
			s.add(aux);
		}
		CtrlBD.desarTotesSeccions(s);
                
            // TEMATICA
                Iterator<Integer> it = tem.keySet().iterator();
		key = 0;
                ArrayList<String[]> t = new ArrayList<String[]>();
		while(it.hasNext()){
                        key = it.next();			
			ArrayList<String> aux = new ArrayList<String>();
			aux.add(Integer.toString(tem.get(key).getID()));
			aux.add(tem.get(key).getNomTematica());
			aux.add(Integer.toString(tem.get(key).getIDSeccio()));
			
			ArrayList<Llibre> temAux = tem.get(key).getLlibres();
			for(int j=0; j<temAux.size();j++){
				aux.add(Integer.toString(temAux.get(j).getID()));
			}			
			String[] result= aux.toArray(new String[aux.size()]);		
			t.add(result);
		}
		CtrlBD.desarTotesTematiques(t);
	}
	
	//Ultima ID Entitats
	
	public static int ultimaIDArea(){
		++ida;
		return ida;
	}
	public static int ultimaIDEstanteria(){
		++ide;
		return ide;
	}
	public static int ultimaIDLlibre(){
		++idl;
		return idl;
	}
	public static int ultimaIDSeccio(){
		++ids;
		return ids;
	}
	public static int ultimaIDTematica(){
		++idt;
		return idt;
	}
	
	public static int ultimaIDBibliotecari(){
		++idb;
		return idb;
	}
	
	//Get Entitats per Atribut
	
	public static Area getArea(int ID){
		return area.get(ID);
	}
	
	public static Estanteria getEstanteria(int ID){
		return est.get(ID);
	}
	
	public static Llibre getLlibre(int ID){
		return llibre.get(ID);
	}
	
	public static Seccio getSeccio(int ID){
		return sec.get(ID);
	}
	
	public static Tematica getTematica(int ID){
		return tem.get(ID);
	}
	
	public static Bibliotecari getBibliotecari(int ID){
		return bcari.get(ID);
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
	
	public static Llibre getLlibreT(String titol){
		Iterator<Integer> iterador = llibre.keySet().iterator();
		Integer key = 0;
		boolean trobat = false;
		while(iterador.hasNext() && !trobat){
		  key = iterador.next();
		  if (llibre.get(key).getTitol().equals(titol)) trobat = true;
		}
		if (trobat) return llibre.get(key);
		else return null;
	}
	
	public static Llibre getLlibrePerISBN(String isbn){
		Iterator<Integer> iterador = llibre.keySet().iterator();
		Integer key = 0;
		boolean trobat = false;
		while(iterador.hasNext() && !trobat){
		  key = iterador.next();
		  if (llibre.get(key).getIsbn().equals(isbn)) trobat = true;
		}
		if (trobat) return llibre.get(key);
		else return null;
	}
	
	public static ArrayList<Llibre> getLlibresAutor(String autor) {
		ArrayList<Llibre> llibresAutor = new ArrayList<Llibre>();
		Iterator<Integer> iterador = llibre.keySet().iterator();
		Integer key = 0;
		while(iterador.hasNext()){
		  key = iterador.next();
		  if (llibre.get(key).getAutor().equals(autor)) llibresAutor.add(llibre.get(key));;
		}
		return llibresAutor;
	}
	
	public static ArrayList<Llibre> getLlibresAny(int any) {
		ArrayList<Llibre> llibresAny = new ArrayList<Llibre>();
		Iterator<Integer> iterador = llibre.keySet().iterator();
		Integer key = 0;
		while(iterador.hasNext()){
		  key = iterador.next();
		  if (llibre.get(key).getAny() == any) llibresAny.add(llibre.get(key));;
		}
		return llibresAny;
	}
	
	public static ArrayList<Llibre> getLlibresEditorial(String editorial) {
		ArrayList<Llibre> llibresEditorial = new ArrayList<Llibre>();
		Iterator<Integer> iterador = llibre.keySet().iterator();
		Integer key = 0;
		while(iterador.hasNext()){
		  key = iterador.next();
		  if (llibre.get(key).getEditorial().equals(editorial)) llibresEditorial.add(llibre.get(key));;
		}
		return llibresEditorial;
	}
	
	//Afegir i eliminar classes
	
	public static void afegirArea(Area a){
		area.put(a.getID(), a);
	}
	
	public static void esborrarArea(Area a){
		esborrarAreaID(a.getID());
	}
	
	public static void afegirBibliotecari(Bibliotecari b){
		bcari.put(b.getID(), b);
	}
	
	public static void esborrarBibliotecari(Bibliotecari b){
		esborrarBibliotecariID(b.getID());
	}
	
	public static void afegirEstanteria(Estanteria e){
		est.put(e.getID(), e);
	}
	
	public static void esborrarEstanteria(Estanteria e){
		esborrarEstanteriaID(e.getID());
	}
	
	public static void afegirLlibre(Llibre l){
		llibre.put(l.getID(), l);
	}
	
	public static void esborrarLlibre(Llibre l){
		esborrarLlibreID(l.getID());
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
	
	//Esborrar per ID
	
	public static void esborrarAreaID(int ID){
		area.remove((Object)new Integer(ID));
	}
	
	public static void esborrarBibliotecariID(int ID){
		bcari.remove((Object)new Integer(ID));
	}
	
	public static void esborrarEstanteriaID(int ID){
		est.remove((Object)new Integer(ID));
	}
	
	
	public static void esborrarLlibreID(int ID){
		llibre.remove((Object)new Integer(ID));
	}
	
	
	public static void esborrarSeccioID(int ID){
		sec.remove((Object)new Integer(ID));
	}

	public static void esborrarTematicaID(int ID){
		tem.remove((Object)new Integer(ID));
	}

	
	//Consultores
	
	public static ArrayList<Tematica> tematiquesSeccio(int IDS) {
		ArrayList<Tematica> tematiquesS = new ArrayList<Tematica>();
		Iterator<Integer> iterador = tem.keySet().iterator();
		Integer key = 0;
		while(iterador.hasNext()){
		  key = iterador.next();
		  if (tem.get(key).getIDSeccio() == IDS) tematiquesS.add(tem.get(key));
		}
		return tematiquesS;
	}
	
	public static ArrayList<Seccio> seccionsArea(int IDA) {
		ArrayList<Seccio> seccionsA = new ArrayList<Seccio>();
		Iterator<Integer> iterador = sec.keySet().iterator();
		Integer key = 0;
		while(iterador.hasNext()){
		  key = iterador.next();
		  if (sec.get(key).getIDAreaSeccio() == IDA) seccionsA.add(sec.get(key));
		}
		return seccionsA;
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
	
	public static ArrayList<Bibliotecari> getAllBibliotecaris() {
		ArrayList<Bibliotecari> allBibliotecaris = new ArrayList<Bibliotecari>();
		Iterator<Integer> iterador = bcari.keySet().iterator();
		Integer key = 0;
		while(iterador.hasNext()){
		  key = iterador.next();
		  allBibliotecaris.add(bcari.get(key));
		}
		return allBibliotecaris;
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
	
	public static boolean existeixBibliotecari(int ID){
		return bcari.containsKey(ID);
	}
	
	public static boolean existeixEstanteria(int ID){
		return est.containsKey(ID);
	}
	
	public static boolean existeixSeccio(int ID){
		return sec.containsKey(ID);
	}
	
	public static boolean existeixTematica(int ID){
		return tem.containsKey(ID);
	}
	
	public static boolean existeixLlibre(int ID){
		return llibre.containsKey(ID);
	}
	
}
