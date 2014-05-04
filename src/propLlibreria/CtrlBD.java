package propLlibreria;
import java.util.*;

public class CtrlBD {
	private static final int LLIBRE = 0;
	private static final int TEMATICA = 1;
	private static final int AREA = 2;
	private static final int BIBLIOTECARI = 3;
	private static final int ESTANTERIA = 4;
	private static final int SECCIO = 5;
	
	/*
	//CLASSE LLIBRE 
	
	public static int obtenirUltimaIDLlibre(){
		GestioDades g = new GestioDades();
		return g.llegirUltimaId(LLIBRE)+1;
	}
	
	public static Tematica obtenirTemPrinLlibre(int id){
		GestioDades g = new GestioDades();
		String[] l = g.llegirObjecte(id,LLIBRE);
		Tematica tem=null;
		if(l != null){
			String[] t = g.llegirObjecte(Integer.parseInt(l[0]),TEMATICA);
			if (t != null)	tem= new Tematica(Integer.parseInt(t[0]),t[1],Integer.parseInt(t[2]));
		}
		return tem;
	}
	
	
	//CLASSE TEMATICA
	
	public static int obtenirUltimaIDTematica(){
		GestioDades g = new GestioDades();
		return g.llegirUltimaId(TEMATICA)+1;
	}
	
	public static Tematica obtenirTematica(int id){
		GestioDades g = new GestioDades();
		String[] t = g.llegirObjecte(id,TEMATICA);
		Tematica tem=null;
		if(t != null) tem= new Tematica(Integer.parseInt(t[0]),t[1],Integer.parseInt(t[2]));
		return tem;
	}
*/
	//CLASSE BD
	
	public static ArrayList<Area> obtenirTotesArees(){
		GestioDades g = new GestioDades();
		ArrayList<String[]> arees= g.llegirTotsObjectes(AREA);
		ArrayList<Area> a = new ArrayList<Area>();
		for (int i=0; i<arees.size();i++){
			Area aux;
			String[] prop=arees.get(i);
			aux = new Area(Integer.parseInt(prop[0]),prop[1]);
			a.add(aux);
		}
		return a;
	}	
	public static ArrayList<Bibliotecari> obtenirTotsBcaris(){
		GestioDades g = new GestioDades();
		ArrayList<String[]> persones= g.llegirTotsObjectes(BIBLIOTECARI);
		ArrayList<Bibliotecari> b = new ArrayList<Bibliotecari>();
		for (int i=0; i<persones.size();i++){
			Bibliotecari aux;
			String[] prop=persones.get(i);
			aux = new Bibliotecari(prop[0]);
			b.add(aux);
		}
		return b;
	}
	public static ArrayList<Estanteria> obtenirTotesEstanteries(){
		GestioDades g = new GestioDades();
		ArrayList<String[]> est= g.llegirTotsObjectes(ESTANTERIA);
		ArrayList<Estanteria> e = new ArrayList<Estanteria>();
		for (int i=0; i<est.size();i++){
			Estanteria aux;
			String[] prop=est.get(i);
			aux = new Estanteria(Integer.parseInt(prop[0]),Integer.parseInt(prop[1]),Integer.parseInt(prop[2]),Integer.parseInt(prop[3]),Integer.parseInt(prop[4]));
			e.add(aux);
		}
		return e;
	}
	public static ArrayList<Llibre> obtenirTotsLlibres(){
		GestioDades g = new GestioDades();
		ArrayList<String[]> llibres= g.llegirTotsObjectes(LLIBRE);
		ArrayList<Llibre> l = new ArrayList<Llibre>();
		for (int i=0; i<llibres.size();i++){
			Llibre aux;
			String[] prop=llibres.get(i);
			aux = new Llibre(Integer.parseInt(prop[0]),prop[1],prop[2],prop[3],prop[4],Integer.parseInt(prop[5]),Integer.parseInt(prop[6]),Integer.parseInt(prop[7]));
			l.add(aux);
		}
		return l;
	}
	
	public static ArrayList<Seccio> obtenirTotesSec(){
		GestioDades g = new GestioDades();
		ArrayList<String[]> sec= g.llegirTotsObjectes(SECCIO);
		ArrayList<Seccio> s = new ArrayList<Seccio>();
		for (int i=0; i<sec.size();i++){
			Seccio aux;
			String[] prop=sec.get(i);
			aux = new Seccio(Integer.parseInt(prop[0]),prop[1],Integer.parseInt(prop[2]));
			s.add(aux);
		}
		return s;
	}
	
	public static ArrayList<Tematica> obtenirTotesTem(){
		GestioDades g = new GestioDades();
		ArrayList<String[]> tem= g.llegirTotsObjectes(TEMATICA);
		ArrayList<Tematica> t = new ArrayList<Tematica>();
		for (int i=0; i<tem.size();i++){
			Tematica aux;
			String[] prop=tem.get(i);
			aux = new Tematica(Integer.parseInt(prop[0]),prop[1],Integer.parseInt(prop[2]));
			t.add(aux);
		}
		return t;
	}
}
