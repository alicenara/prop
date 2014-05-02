package propLlibreria;
import java.util.*;

import propLlibreria.Llibre.TGruix;

public class Tematica {
	
	private ArrayList<Llibre> llibres;
	private String nomTematica;
	private Estanteria estanteria;
	
	//pre:
	//post: si el paràmetre implícit conté el llibre amb codi "codiLlibre",
	//retorna la posició on es troba de la colecció de llibres. En cas contrari, retorna -1
	private int getPosLlibre(int codiLlibre) {
		int n = llibres.size();
		for (int i = 0; i < n; i++) {
			if (llibres.get(i).getcodiLlibre() == codiLlibre) return i;
		}
		return -1;
	}
	
	//pre:
	//post: crea nova tematica amb nom de temàtica igual a "nomTematica"
	public Tematica (String nomTematica) {
		llibres = new ArrayList<Llibre>();
		this.nomTematica = nomTematica;
	}
	
	//pre:
	//post: el paràmetre implícit es eliminat
	public void esborrarTematica() {
		Runtime garbage = Runtime.getRuntime();
	    garbage.gc();
	}
	
	//pre:
	//post: el paràmetre implícit es assignat a una estanteria
	public void setEstanteria(Estanteria estanteria) {
		this.estanteria = estanteria;
	}
	
	//pre:
	//post:retorna nom de la temàtica
	public String getNomTematica() {
			return this.nomTematica;
	}
	
	//pre:
	//post: numero de llibres que conté la temàtica
	public int getNumLlibres() {
		return llibres.size();
	}
	
	//pre: i <= numero de llibres que conte una temàtica
	//post: retorna llibre a posició i-ésima
	public Llibre getLlibreIesim(int index) {
		return llibres.get(index);
	}
	
	//pre:
	//post: retorna la estanteria on esta posicionat el paràmetre implícit
	public Estanteria getEstanteria() {
		return this.estanteria;
	}
	
	//pre: no existeix cap llibre dins de la temàtica amb codi igual a codiLlibre
	//post: 
	public void afegirLlibres(int codiLlibre, String isbn, String titol, String autor, String editorial, int any, int edicio, TGruix gruix, int estanteriaPos) {
		llibres.add(new Llibre(codiLlibre,isbn,titol,autor,editorial,any,edicio,gruix,estanteriaPos));
	}
	
	//pre:
	//post: si tematica conte un llibre amb codi "codiLlibre" el deixa de tenir
	public void esborrarLlibres(int codiLlibre) {
		int pos = getPosLlibre(codiLlibre);
		if (pos != -1) llibres.remove(pos);
	}
	
	//pre:
	//post:Si existeix un llibre amb codi igual a codiLlibre retorna un element de la classe Llibre. En cas contrari retorna NULL
	public Llibre consultarLlibres(int codiLlibre) {
		int pos = getPosLlibre(codiLlibre);
		if (pos != -1) return llibres.get(pos);
		return null;
	}
}
