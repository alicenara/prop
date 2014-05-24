package propLlibreria.Persistencia;
import java.util.*;

public class GestioPersistencia {
	private static final int LLIBRE = 0;
	private static final int TEMATICA = 1;
	private static final int AREA = 2;
	private static final int BIBLIOTECARI = 3;
	private static final int ESTANTERIA = 4;
	private static final int SECCIO = 5;
	

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
	
	public static boolean desarTotesArees(ArrayList<String[]> a){
		GestioDades g = new GestioDades();
		return g.escriureTotsObjectes(a,AREA);	
	}
	
	public static boolean desarTotsBibliotecaris(ArrayList<String[]> b){
		GestioDades g = new GestioDades();
		return g.escriureTotsObjectes(b,BIBLIOTECARI);	
	}
	
	public static boolean desarTotesEstanteries(ArrayList<String[]> e){
		GestioDades g = new GestioDades();
		return g.escriureTotsObjectes(e,ESTANTERIA);	
	}
	
	public static boolean desarTotsLlibres(ArrayList<String[]> l){
		GestioDades g = new GestioDades();
		return g.escriureTotsObjectes(l,LLIBRE);	
	}
	
	public static boolean desarTotesSeccions(ArrayList<String[]> s){		
		GestioDades g = new GestioDades();
		return g.escriureTotsObjectes(s,SECCIO);	
	}
	
	public static boolean desarTotesTematiques(ArrayList<String[]> t){		
		GestioDades g = new GestioDades();
		return g.escriureTotsObjectes(t,TEMATICA);	
	}
}