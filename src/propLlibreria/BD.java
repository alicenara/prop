package propLlibreria;
import java.util.*;

public class BD {
	private static ArrayList<Area> area;
	private static ArrayList<Bibliotecari> bcari;
	private static ArrayList<Estanteria> est;
	private static ArrayList<Llibre> llibre;
	private static ArrayList<Seccio> sec;
	private static ArrayList<Tematica> tem;
	
	public static void omplirBD(){
		area=CtrlBD.obtenirTotesArees();
		bcari=CtrlBD.obtenirTotsBcaris();
		est=CtrlBD.obtenirTotesEstanteries();
		llibre=CtrlBD.obtenirTotsLlibres();
		sec=CtrlBD.obtenirTotesSec();
		tem=CtrlBD.obtenirTotesTem();
	}
	
	public static void desarBD(){
		//TODO
	}
	
	//Ultima ID Entitats
	
	public static int ultimaIDArea(){
		if (area.size() == 0) return 0;
		return area.get(area.size()-1).getID()+1;
	}
	public static int ultimaIDEstanteria(){
		if (est.size() == 0) return 0;
		return est.get(est.size()-1).getID()+1;
	}
	public static int ultimaIDLlibre(){
		if (llibre.size() == 0) return 0;
		return llibre.get(llibre.size()-1).getID()+1;
	}
	public static int ultimaIDSeccio(){
		if (sec.size() == 0) return 0;
		return sec.get(sec.size()-1).getID()+1;
	}
	public static int ultimaIDTematica(){
		if (tem.size() == 0) return 0;
		return tem.get(tem.size()-1).getID()+1;
	}
	
	//Get Entitats per ID
	
	public static Area getArea(int ID){
		int a = 0;
		int b = area.size();
		int i = b/2;
		while (i<area.size() && area.get(i).getID()!=ID) {
			if (area.get(i).getID() < ID) a = i;
			else b = i;
			i = (b-a)/2 + a;
		}
		if(i==area.size()) return null;
		else return area.get(i);
	}
	public static Estanteria getEstanteria(int ID){
		int a = 0;
		int b = est.size();
		int i = b/2;
		while (i<est.size() && est.get(i).getID()!=ID) {
			if (est.get(i).getID() < ID) a = i;
			else b = i;
			i = (b-a)/2 + a;
		}
		if(i==est.size()) return null;
		else return est.get(i);
	}
	public static Llibre getLlibre(int ID){
		int a = 0;
		int b = llibre.size();
		int i = b/2;
		while (i<llibre.size() && llibre.get(i).getID()!=ID) {
			if (llibre.get(i).getID() < ID) a = i;
			else b = i;
			i = (b-a)/2 + a;
		}
		if(i==llibre.size()) return null;
		else return llibre.get(i);
	}
	public static Seccio getSeccio(int ID){
		int a = 0;
		int b = sec.size();
		int i = b/2;
		while (i<sec.size() && sec.get(i).getID()!=ID) {
			if (sec.get(i).getID() < ID) a = i;
			else b = i;
			i = (b-a)/2 + a;
		}
		if(i==sec.size()) return null;
		else return sec.get(i);
	}
	public static Tematica getTematica(int ID){
		int a = 0;
		int b = sec.size();
		int i = b/2;
		while (i<tem.size() && tem.get(i).getID()!=ID) {
			if (tem.get(i).getID() < ID) a = i;
			else b = i;
			i = (b-a)/2 + a;
		}
		if(i==tem.size()) return null;
		else return tem.get(i);
	}
	
	//Get Entitats per nom
	
	public static Area getAreaN(String nomA){
		int i=0;
		while (i<area.size() && area.get(i).getNomArea()!=nomA) i++;
		if(i==area.size()) return null;
		else return area.get(i);
	}
	
	public static Seccio getSeccioN(String nomS){
		int i=0;
		while (i<sec.size() && sec.get(i).getNomSeccio()!=nomS) i++;
		if(i==sec.size()) return null;
		else return sec.get(i);
	}
	public static Tematica getTematicaN(String nomT){
		int i=0;
		while (i<tem.size() && tem.get(i).getNomTematica()!=nomT) i++;
		if(i==tem.size()) return null;
		else return tem.get(i);
	}
	
	public static Llibre getLlibreT(String titol){
		int i=0;
		while (i<llibre.size() && llibre.get(i).getTitol()!= titol) i++;
		if(i==llibre.size()) return null;
		else return llibre.get(i);
	}
	
	public static Llibre consultaLlibrePerISBN(String isbn){
		int i=0;
		while (i<llibre.size() && llibre.get(i).getIsbn()!= isbn) i++;
		if(i==llibre.size()) return null;
		else return llibre.get(i);
	}
	
	public static ArrayList<Llibre> consultaLlibresAutor(String autor) {
		ArrayList<Llibre> llibresAutor;
		for (int i = 0; i < llibre.size(); i++) {
		if (llibre.get(i).getAutor() == autor) llibresAutor.add(llibre.get(i));
		}
		return llibresAutor;
	}
	
	public static ArrayList<Llibre> consultaLlibresAny(int any) {
		ArrayList<Llibre> llibresAny;
		for (int i = 0; i < llibre.size(); i++) {
		if (llibre.get(i).getAny() == any) llibresAny.add(llibre.get(i));
		}
		return llibresAny;
	}
	
	public static ArrayList<Llibre> consultaLlibresEditorial(String editorial) {
		ArrayList<Llibre> llibresEditorial;
		for (int i = 0; i < llibre.size(); i++) {
		if (llibre.get(i).getEditorial() == editorial) llibresEditorial.add(llibre.get(i));
		}
		return llibresEditorial;
	}
	
	//Afegir i eliminar classes
	
	public static void afegirArea(Area a){
		area.add(a);
	}
	
	public static void esborrarArea(Area a){
		area.remove(a);
	}
	
	public static void afegirBibliotecari(Bibliotecari b){
		bcari.add(b);
	}
	
	public static void esborrarBibliotecari(Bibliotecari b){
		bcari.remove(b);
	}
	
	public static void afegirEstanteria(Estanteria e){
		est.add(e);
	}
	
	public static void esborrarEstanteria(Estanteria e){
		est.remove(e);
	}
	
	public static void afegirLlibre(Llibre l){
		llibre.add(l);
	}
	
	public static void esborrarLlibre(Llibre l){
		llibre.remove(l);
	}
	
	public static void afegirSeccio(Seccio s){
		sec.add(s);
	}
	
	public static void esborrarSeccio(Seccio s){
		sec.remove(s);
	}
	
	public static void afegirTematica(Tematica t){
		tem.add(t);
	}
	
	public static void esborrarTematica(Tematica t){
		tem.remove(t);
	}
	
	//Consultores
	
	public static ArrayList<Llibre> llibresTematica(Tematica t) {
		ArrayList<Llibre> llibresT = t.getLlibres();
		return llibresT;
	}
	
	public static ArrayList<Tematica> tematiquesSeccio(int IDS) {
		ArrayList<Tematica> tematiquesS;
		for (int i = 0; i < tem.size(); ++i) {
			if (tem.get(i).getIDSeccio() == IDS) tematiquesS.add(tem.get(i));
		}
		return tematiquesS;
	}
	
	public static ArrayList<Seccio> seccionsArea(int IDA) {
		ArrayList<Seccio> seccionsA;
		for (int i = 0; i < sec.size(); ++i) {
			if (sec.get(i).getIDAreaSeccio() == IDA) seccionsA.add(sec.get(i));
		}
		return seccionsA;
	}
	
}
