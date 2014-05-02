package propLlibreria;
import java.util.ArrayList;

public class Classificacio {
	private Tematica temPrincipal;
	private ArrayList<Tematica> temSecundaries;
	
	//pre:
	//post: el resultat es una classificacio del llibre l amb tematica principal temPrincipal
	public Classificacio (Tematica temPrincipal) {
		this.temPrincipal = temPrincipal;
		temSecundaries = new ArrayList<Tematica>();
	}
	
	//pre:	el paràmetre implícit no conté novaTematica
	//post: el paràmetre implícit afegeix una tematica secundaria
	public void afegirTematica(Tematica novaTematica) {
		temSecundaries.add(novaTematica);
	}
	
	public void setTemPrincipal(Tematica temPrincipal) {
		this.temPrincipal = temPrincipal;
	}
	//pre:
	//post: retorna la tematica principal del paràmetre implícit
	public Tematica getTemPrincipal() {
		return temPrincipal;
	}
	//pre:
	//post: retorna numero de tematiques secundàries del paràmetre implícit
	public int getNumTemSecundaries() {
		return temSecundaries.size();
	}
	
	//pre: 0 <= index <= num tematiques secundaries
	//post: retorna tematica secundària a la posició index
	public Tematica getTematicaIesima(int index) {
		return temSecundaries.get(index);
	}
}
