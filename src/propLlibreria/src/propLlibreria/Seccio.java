package propLlibreria;
import java.util.ArrayList;

public class Seccio {
	private String nomSeccio;
	private ArrayList<Tematica> tematiques;
	
	//pre:
	//post: si exiteix una tematica amb nom "nomTematica" retorna 0 <= i < n,
	//sent n el numero de tematiques. En cas contrari retorna -1
	private int getPosTematica(String nomTematica) {
		int n = tematiques.size();
		for (int i = 0; i < n; i++) {
			if (tematiques.get(i).getNomTematica() == nomTematica) return i;
		}
		return -1;
	}
	
	//pre:
	//post: crea una seccio amb nom "nomSeccio"
	public Seccio (String nomSeccio) {
		this.nomSeccio = nomSeccio;
	}
	
	//pre:
	//post: el par�metre impl�cit es eliminat
	public void esborrarSeccio() {
		Runtime garbage = Runtime.getRuntime();
	    garbage.gc();
	}
	
	//pre:
	//post: par�metre impl�cit passa a tenir com a nom de secci� "nomSeccio"
	public void setNomSeccio(String nomSeccio) {
		this.nomSeccio = nomSeccio;
	}
	//pre:
	//post: retorna el nom de secci� del par�metre impl�cit
	public String getNomSeccio() {
		return this.nomSeccio;
	}
	
	//pre:	el par�metre impl�cit no cont� una tem�tica amb nom "nomTematica"
	//post: afegeix una tem�tica al par�metre impl�cit
	public void afegirTematica(String nomTematica) {
		this.tematiques.add(new Tematica(nomTematica));
	}
	
	//pre:
	//post: el par�metre impl�cit veu reduit el numero de tematiques en un
	public void esborrarTematica(String nomTematica) {
		int pos = getPosTematica(nomTematica);
		if (pos != -1) tematiques.remove(pos);
	}
}
