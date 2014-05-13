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
	
	public static ArrayList<String[]> obtenirTotesArees(){
		GestioDades g = new GestioDades();
		return g.llegirTotsObjectes(AREA);
        }
        
	public static ArrayList<String[]> obtenirTotsBcaris(){
		GestioDades g = new GestioDades();
		return g.llegirTotsObjectes(BIBLIOTECARI);		
	}
        
	public static ArrayList<String[]> obtenirTotesEstanteries(){
		GestioDades g = new GestioDades();
		return g.llegirTotsObjectes(ESTANTERIA);		
	}
        
	public static ArrayList<String[]> obtenirTotsLlibres(){
		GestioDades g = new GestioDades();
		return g.llegirTotsObjectes(LLIBRE);		
	}
	
	public static ArrayList<String[]> obtenirTotesSec(){
		GestioDades g = new GestioDades();
		return g.llegirTotsObjectes(SECCIO);		
	}
	
	public static ArrayList<String[]> obtenirTotesTem(){
		GestioDades g = new GestioDades();
		return g.llegirTotsObjectes(TEMATICA);		
	}
	
	public static boolean desarTotesArees(ArrayList<Area> arees){
		ArrayList<String[]> a = new ArrayList<String[]>();
		for(int i=0; i<arees.size();i++){
			String[] aux = {Integer.toString(arees.get(i).getID()),arees.get(i).getNomArea()};
			a.add(aux);
		}
		GestioDades g = new GestioDades();
		return g.escriureTotsObjectes(a,AREA);	
	}
	
	public static boolean desarTotsBibliotecaris(ArrayList<Bibliotecari> bcaris){
		ArrayList<String[]> b = new ArrayList<String[]>();
		for(int i=0; i<bcaris.size();i++){
			String[] aux = {Integer.toString(bcaris.get(i).getID()),bcaris.get(i).getContrasenya()};
			b.add(aux);
		}
		GestioDades g = new GestioDades();
		return g.escriureTotsObjectes(b,BIBLIOTECARI);	
	}
	
	public static boolean desarTotesEstanteries(ArrayList<Estanteria> est){
		ArrayList<String[]> e = new ArrayList<String[]>();
		for(int i=0; i<est.size();i++){
			ArrayList<String> aux = new ArrayList<String>();
			aux.add(Integer.toString(est.get(i).getID()));
			aux.add(Integer.toString(est.get(i).getNumFiles()));
			aux.add(Integer.toString(est.get(i).getLlargada()));
			aux.add(Integer.toString(est.get(i).getPosX()));
			aux.add(Integer.toString(est.get(i).getPosY()));
			
			ArrayList<Llibre> llibreAux = est.get(i).getLlibres();
			for(int j=0; j<llibreAux.size();j++){
				aux.add(Integer.toString(llibreAux.get(j).getID()));
			}
			String[] result=null;
			aux.toArray(result);
			e.add(result);
		}
		GestioDades g = new GestioDades();
		return g.escriureTotsObjectes(e,ESTANTERIA);	
	}
	
	public static boolean desarTotsLlibres(ArrayList<Llibre> llibres){
		ArrayList<String[]> l = new ArrayList<String[]>();
		for(int i=0; i<llibres.size();i++){			
			ArrayList<String> aux = new ArrayList<String>();
			aux.add(Integer.toString(llibres.get(i).getID()));
			aux.add(llibres.get(i).getIsbn());
			aux.add(llibres.get(i).getTitol());
			aux.add(llibres.get(i).getAutor());
			aux.add(llibres.get(i).getEditorial());
			aux.add(Integer.toString(llibres.get(i).getAny()));
			aux.add(Integer.toString(llibres.get(i).getEdicio()));
			aux.add(Integer.toString(llibres.get(i).getTemPrincipal().getID()));
			
			ArrayList<Tematica> temAux = llibres.get(i).getTematiquesSecundaries();
			for(int j=0; j<temAux.size();j++){
				aux.add(Integer.toString(temAux.get(j).getID()));
			}
			
			String[] result=null;
			aux.toArray(result);			
			l.add(result);
		}
		GestioDades g = new GestioDades();
		return g.escriureTotsObjectes(l,LLIBRE);	
	}
	
	public static boolean desarTotesSeccions(ArrayList<Seccio> sec){
		ArrayList<String[]> s = new ArrayList<String[]>();
		for(int i=0; i<sec.size();i++){
			String[] aux = {Integer.toString(sec.get(i).getID()),sec.get(i).getNomSeccio(),Integer.toString(sec.get(i).getIDAreaSeccio())};
			s.add(aux);
		}
		GestioDades g = new GestioDades();
		return g.escriureTotsObjectes(s,SECCIO);	
	}
	
	public static boolean desarTotesTematiques(ArrayList<Tematica> tem){
		ArrayList<String[]> t = new ArrayList<String[]>();
		for(int i=0; i<tem.size();i++){			
			ArrayList<String> aux = new ArrayList<String>();
			aux.add(Integer.toString(tem.get(i).getID()));
			aux.add(tem.get(i).getNomTematica());
			aux.add(Integer.toString(tem.get(i).getIDSeccio()));
			
			ArrayList<Llibre> temAux = tem.get(i).getLlibres();
			for(int j=0; j<temAux.size();j++){
				aux.add(Integer.toString(temAux.get(j).getID()));
			}			
			String[] result=null;
			aux.toArray(result);			
			t.add(result);
		}
		GestioDades g = new GestioDades();
		return g.escriureTotsObjectes(t,TEMATICA);	
	}
}
