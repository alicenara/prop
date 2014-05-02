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
	//post: el paràmetre implícit es eliminat
	public void esborrarSeccio() {
		Runtime garbage = Runtime.getRuntime();
	    garbage.gc();
	}
	
	//pre:
	//post: paràmetre implícit passa a tenir com a nom de secció "nomSeccio"
	public void setNomSeccio(String nomSeccio) {
		this.nomSeccio = nomSeccio;
	}
	//pre:
	//post: retorna el nom de secció del paràmetre implícit
	public String getNomSeccio() {
		return this.nomSeccio;
	}
	
	//pre:	el paràmetre implícit no conté una temàtica amb nom "nomTematica"
	//post: afegeix una temàtica al paràmetre implícit
	public void afegirTematica(String nomTematica) {
		this.tematiques.add(new Tematica(nomTematica));
	}
	
	//pre:
	//post: el paràmetre implícit veu reduit el numero de tematiques en un
	public void esborrarTematica(String nomTematica) {
		int pos = getPosTematica(nomTematica);
		if (pos != -1) tematiques.remove(pos);
	}
}
