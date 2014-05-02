package propLlibreria;
import java.util.ArrayList;

public class Classificacio {
	private String temPrincipal;
	private ArrayList<String> temSecundaries;
	
	//pre:
	//post: el resultat es una classificacio del llibre l amb tematica principal temPrincipal
	public Classificacio (Tematica temPrincipal) {
		this.temPrincipal = temPrincipal;
		temSecundaries = new ArrayList<Tematica>();
	}
	
	//pre:	el par�metre impl�cit no cont� novaTematica
	//post: el par�metre impl�cit afegeix una tematica secundaria
	public void afegirTematica(Tematica novaTematica) {
		temSecundaries.add(novaTematica);
	}
	
	public void setTemPrincipal(Tematica temPrincipal) {
		this.temPrincipal = temPrincipal;
	}
	//pre:
	//post: retorna la tematica principal del par�metre impl�cit
	public Tematica getTemPrincipal() {
		return temPrincipal;
	}
	//pre:
	//post: retorna numero de tematiques secund�ries del par�metre impl�cit
	public int getNumTemSecundaries() {
		return temSecundaries.size();
	}
	
	//pre: 0 <= index <= num tematiques secundaries
	//post: retorna tematica secund�ria a la posici� index
	public Tematica getTematicaIesima(int index) {
		return temSecundaries.get(index);
	}
}
