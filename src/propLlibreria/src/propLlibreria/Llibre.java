package propLlibreria;
import java.util.*;

public class Llibre {
	
	//Ennumeration for "llibre"
	enum TGruix {PRIM, NORMAL, GRUIXUT}
	
	//All "Llibre"'s attributes
	
	private int codiLlibre;
	private String isbn;
	private String titol;
	private String autor;
	private String editorial;
	private int any;
	private int edicio;
	private TGruix gruix;
	private int estanteriaPos;
	private ArrayList<Tematica> temSecundaries = new ArrayList<Tematica>();
	
	//Default constructor
	
	public Llibre(){
	}
	
	//All attributes constructor
	
	public Llibre (int codiLlibre, String isbn, String titol, String autor, String editorial, int any, int edicio, int gruix, int estanteriaPos, ArrayList<Tematica> temSecundaries){
		//TODO increment ID automatic
		this.codiLlibre=codiLlibre;
		this.isbn = isbn;
		this.titol=titol;
		this.autor=autor;
		this.editorial=editorial;
		this.any=any;
		this.edicio=edicio;
		this.gruix=assignarGruix(gruix);
		this.estanteriaPos=estanteriaPos;
		this.temSecundaries=temSecundaries;
	}
	
	//Constructor without "temSecundaries" attribute
	
	public Llibre (int codiLlibre, String isbn, String titol, String autor, String editorial, int any, int edicio, int gruix, int estanteriaPos){
		//TODO increment ID automatic
		this.codiLlibre=codiLlibre;
		this.isbn = isbn;
		this.titol=titol;
		this.autor=autor;
		this.editorial=editorial;
		this.any=any;
		this.edicio=edicio;
		this.gruix=assignarGruix(gruix);
		this.estanteriaPos=estanteriaPos;
	}
	
	//Constructor without "estanteriaPos" and "temSecundaries" attributes ("estanteriaPos" set to -1)
	
	public Llibre (int codiLlibre, String isbn, String titol, String autor, String editorial, int any, int edicio, int gruix){
		//TODO increment ID automatic
		this.codiLlibre=codiLlibre;
		this.isbn = isbn;
		this.titol=titol;
		this.autor=autor;
		this.editorial=editorial;
		this.any=any;
		this.edicio=edicio;
		this.gruix=assignarGruix(gruix);
		this.estanteriaPos=-1;
	}
	
	//All getters and setters
	
	public int getcodiLlibre() {
		return codiLlibre;
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
	public TGruix getGruix() {
		return gruix;
	}
	public void setGruix(TGruix gruix) {
		this.gruix = gruix;
	}
	public int getEstanteriaPos() {
		return estanteriaPos;
	}
	public void setEstanteriaPos(int estanteriaPos) {
		this.estanteriaPos = estanteriaPos;
	}
	public ArrayList<Tematica> getTemSecundaries() {
		return temSecundaries;
	}
	public void setTemSecundaries(ArrayList<Tematica> temSecundaries) {
		this.temSecundaries = temSecundaries;
	}
	
	//Methods to add and delete "temSecundaries"
	
	public void afegirTemSecundaries(Tematica temSecundaria) {
		this.temSecundaries.add(temSecundaria);
	}
	
	public void eliminarTemSecundaries(Tematica temSecundaria) {
		temSecundaries.remove(temSecundaria);
	}
	
	private TGruix assignarGruix(int gruix){
		switch(gruix){
		case 1:
			return TGruix.PRIM;
		case 2:
			return TGruix.NORMAL;
		default:
			return TGruix.GRUIXUT;
		}
	}
}
