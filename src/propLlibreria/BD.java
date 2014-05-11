package propLlibreria;
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
		area = CtrlBD.obtenirTotesArees();
		bcari = CtrlBD.obtenirTotsBcaris();
		est = CtrlBD.obtenirTotesEstanteries();
		llibre = CtrlBD.obtenirTotsLlibres();
		sec = CtrlBD.obtenirTotesSec();
		tem = CtrlBD.obtenirTotesTem();
	}
	
	public static void desarBD(){
		CtrlBD.desarTotesArees(area);
		CtrlBD.desarTotsBibliotecaris(bcari);
		CtrlBD.desarTotesEstanteries(est);
		CtrlBD.desarTotsLlibres(llibre);
		CtrlBD.desarTotesSeccions(sec);
		CtrlBD.desarTotesTematiques(tem);
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
		area.remove(a.getID());
	}
	
	public static void afegirBibliotecari(Bibliotecari b){
		bcari.put(b.getID(), b);
	}
	
	public static void esborrarBibliotecari(Bibliotecari b){
		bcari.remove(b.getID());
	}
	
	public static void afegirEstanteria(Estanteria e){
		est.put(e.getID(), e);
	}
	
	public static void esborrarEstanteria(Estanteria e){
		est.remove(e.getID());
	}
	
	public static void afegirLlibre(Llibre l){
		llibre.put(l.getID(), l);
	}
	
	public static void esborrarLlibre(Llibre l){
		llibre.remove(l.getID());
	}
	
	public static void afegirSeccio(Seccio s){
		sec.put(s.getID(), s);
	}
	
	public static void esborrarSeccio(Seccio s){
		sec.remove(s.getID());
	}
	
	public static void afegirTematica(Tematica t){
		tem.put(t.getID(), t);
	}
	
	public static void esborrarTematica(Tematica t){
		tem.remove(t.getID());
	}
	
	//Esborrar per ID
	
	public static void esborrarAreaID(int ID){
		area.remove(ID);
	}
	
	public static void esborrarEstanteriaID(int ID){
		est.remove(ID);
	}
	
	
	public static void esborrarLlibreID(int ID){
		llibre.remove(ID);
	}
	
	
	public static void esborrarSeccioID(int ID){
		sec.remove(ID);
	}

	public static void esborrarTematicaID(int ID){
		tem.remove(ID);
	}

	
	//Consultores
	
	public static ArrayList<Llibre> llibresTematica(Tematica t) {
		ArrayList<Llibre> llibresT = t.getLlibres();
		return llibresT;
	}
	
	public static ArrayList<Tematica> tematiquesSeccio(int IDS) {
		//TODO
		ArrayList<Tematica> tematiquesS = new ArrayList<Tematica>();
		for (int i = 0; i < tem.size(); ++i) {
			if (tem.get(i).getIDSeccio() == IDS) tematiquesS.add(tem.get(i));
		}
		return tematiquesS;
	}
	
	public static ArrayList<Seccio> seccionsArea(int IDA) {
		ArrayList<Seccio> seccionsA = new ArrayList<Seccio>();
		for (int i = 0; i < sec.size(); ++i) {
			if (sec.get(i).getIDAreaSeccio() == IDA) seccionsA.add(sec.get(i));
		}
		return seccionsA;
	}
	
	public static ArrayList<Llibre> getAllLlibres() {
		return llibre;
	}
	
	public static ArrayList <Estanteria> getAllEstanteries() {
		return est;
	}
	
	public static ArrayList<Area> getAllArees() {
		return area;
	}
	
	public static ArrayList<Bibliotecari> getAllBibliotecaris() {
		return bcari;
	}
	
	public static ArrayList<Seccio> getAllSeccions() {
		return sec;
	}
	
	public static ArrayList<Tematica> getAllTematiques() {
		return tem;
	}
	
}
