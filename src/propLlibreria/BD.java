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
		return area.get(area.size()-1).getID();
	}
	public static int ultimaIDEstanteria(){
		return est.get(est.size()-1).getID();
	}
	public static int ultimaIDLlibre(){
		return llibre.get(llibre.size()-1).getID();
	}
	public static int ultimaIDSeccio(){
		return sec.get(sec.size()-1).getID();
	}
	public static int ultimaIDTematica(){
		return tem.get(tem.size()-1).getID();
	}
	
	//Get Entitats per ID
	
	public static Area getArea(int ID){
		int i=0;
		while (i<area.size() && area.get(i).getID()!=ID) i++;
		if(i==area.size()) return null;
		else return area.get(i);
	}
	public static Estanteria getEstanteria(int ID){
		int i=0;
		while (i<est.size() && est.get(i).getID()!=ID) i++;
		if(i==est.size()) return null;
		else return est.get(i);
	}
	public static Llibre getLlibre(int ID){
		int i=0;
		while (i<llibre.size() && llibre.get(i).getID()!=ID) i++;
		if(i==llibre.size()) return null;
		else return llibre.get(i);
	}
	public static Seccio getSeccio(int ID){
		int i=0;
		while (i<sec.size() && sec.get(i).getID()!=ID) i++;
		if(i==sec.size()) return null;
		else return sec.get(i);
	}
	public static Tematica getTematica(int ID){
		int i=0;
		while (i<tem.size() && tem.get(i).getID()!=ID) i++;
		if(i==tem.size()) return null;
		else return tem.get(i);
	}
	
	//Afegir i eliminar classes
	
	public static void afegirArea(Area a){
		area.add(a);
	}
	
	public static void esborrarArea(Area a){
		area.remove(a);
	}
	
	public static void afegirBilbiotecari(Bibliotecari b){
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
}
