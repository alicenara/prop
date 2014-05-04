package propLlibreria;
package compartit;
import java.util.*;

public class Llibre extends Object {
	//All "Llibre"'s attributes

	private final int ID;
	private String isbn;
	private String titol;
	private String autor;
	private String editorial;
	private int any;
	private int edicio;
	private int temPrincipal;
	private ArrayList<Integer> temSecundaries;

	//All attributes constructor
	public Llibre (String isbn, String titol, String autor, String editorial, int any, int edicio, Tematica tPrincipal){
		//TODO increment ID automatic
		this.isbn = isbn;
		this.titol=titol;
		this.autor=autor;
		this.editorial=editorial;
		this.any=any;
		this.edicio=edicio;
		this.temPrincipal = tPrincipal.getID();
		this.ID = BD.ultimaIDLlibre();
	}
	
	public Llibre (int ID, String isbn, String titol, String autor, String editorial, int any, int edicio, int tPrincipal){
		//TODO increment ID automatic
		this.isbn = isbn;
		this.titol=titol;
		this.autor=autor;
		this.editorial=editorial;
		this.any=any;
		this.edicio=edicio;
		this.temPrincipal = tPrincipal;
		this.ID = ID;
	}

	//All getters and setters
	public int getID() {
		return ID;
	}	
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getTitol() {
		return titol;
	}
	public void setTitol(String titol) {
		this.titol = titol;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getEditorial() {
		return editorial;
	}
	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}
	public int getAny() {
		return any;
	}
	public void setAny(int any) {
		this.any = any;
	}
	public int getEdicio() {
		return edicio;
	}
	public void setEdicio(int edicio) {
		this.edicio = edicio;
	}

	//pre:	el parametre implicit no conte novaTematica
	//post: el parametre implicit afegeix una tematica secundaria
	public void afegirTematicaSecundaria(Tematica novaTematica) {
		temSecundaries.add(novaTematica.getID());
	}
	
	public void eliminarTematicaSecundaria(Tematica tem) {
		temSecundaries.remove((Object)new Integer(tem.getID()));;
	}
	
	public ArrayList<Integer> getTematiquesSecundaries() {
		return temSecundaries;
	}

	public void setTematicaPrincipal(Tematica temPrincipal) {
		this.temPrincipal = temPrincipal.getID();
	}
	//pre:
	//post: retorna la tematica principal del parametre implicit
	public Tematica getTematicaPrincipal() {
		return BD.getTematica(temPrincipal);
	}
	//pre:
	//post: retorna numero de tematiques secundaries del parametre implicit
	public int getNumTemSecundaries() {
		return temSecundaries.size();
	}

	//pre: 0 <= index <= num tematiques secundaries
	//post: retorna tematica secundaria a la posicio index
	public Tematica getTematicaIesima(int index) {
		return BD.getTematica(temSecundaries.get(index));
	}
}
