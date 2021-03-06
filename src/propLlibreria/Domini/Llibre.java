package propLlibreria.Domini;
import compartit.*;
import java.util.*;

public class Llibre extends Objecte {
	//All "Llibre"'s attributes
	private String isbn;
	private String titol;
	private String autor;
	private String editorial;
	private int any;
	private int edicio;
	private int temPrincipal;
	private ArrayList<Integer> temSecundaries;
	
	//All attributes constructor
	public Llibre (String isbn, String titol, String autor, String editorial, int any, int edicio, int IDTp){
		super(GestioLlibre.ultimaIDLlibre());
		this.isbn = isbn;
		this.titol=titol;
		this.autor=autor;
		this.editorial=editorial;
		this.any=any;
		this.edicio=edicio;
                temSecundaries = new ArrayList<Integer>();
		GestioLlibre.afegirLlibre(this);
                Tematica tp = GestioArea.getTematica(IDTp);
		tp.afegirLlibre(this);
	}
	
	public Llibre (int ID, String isbn, String titol, String autor, String editorial, int any, int edicio, int tPrincipal, ArrayList<Integer> tS){
		super(ID);
		this.isbn = isbn;
		this.titol=titol;
		this.autor=autor;
		this.editorial=editorial;
		this.any=any;
		this.edicio=edicio;
		this.temPrincipal = tPrincipal;
		temSecundaries = tS;
	}

	//All getters and setters
	public int getID() {
		return super.getID();
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
	
	public void setTemPrincipal(int temPrincipal) {
		this.temPrincipal = temPrincipal;
	}
	//pre:
	//post: retorna la tematica principal del parametre implicit
	public int getTemPrincipal() {
		return temPrincipal;
	}
	
	//pre:	el parametre implicit no conte novaTematica
	//post: el parametre implicit afegeix una tematica secundaria
	public void afegirTematicaSecundaria(Tematica novaTematica) {
		temSecundaries.add(novaTematica.getID());
	}
	
	public void eliminarTematicaSecundaria(int IDT) {
		temSecundaries.remove(new Integer(IDT));
	}
	
	//pre:
	//post: retorna numero de tematiques secundaries del parametre implicit
	public int getNumTemSecundaries() {
		return temSecundaries.size();
	}
	
	public ArrayList<Tematica> getTematiquesSecundaries() {
		ArrayList<Tematica> tSec = new ArrayList<Tematica>();
		for (int i = 0; i < temSecundaries.size(); ++i) {
			tSec.add(GestioArea.getTematica(temSecundaries.get(i)));
		}
		return tSec;
	}	
}
