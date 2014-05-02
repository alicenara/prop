package propLlibreria;
import java.util.*;

public class Llibre {
	//All "Llibre"'s attributes
	
	private final int ID;
	private String isbn;
	private String titol;
	private String autor;
	private String editorial;
	private int any;
	private int edicio;
	private Classificacio classificacio;
	
	//All attributes constructor
	public Llibre (String isbn, String titol, String autor, String editorial, int any, int edicio, int gruix, int estanteriaPos, ArrayList<Tematica> temSecundaries){
		//TODO increment ID automatic
		this.isbn = isbn;
		this.titol=titol;
		this.autor=autor;
		this.editorial=editorial;
		this.any=any;
		this.edicio=edicio;
		this.ID = BD.nouLlibre(this);
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
	public Classificacio getClassificacio() {
		return this.classificacio;
	}
}
