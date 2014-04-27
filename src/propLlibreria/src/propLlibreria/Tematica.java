package propLlibreria;
import java.util.*;

public class Tematica {
	
	private Vector<Llibre> llibres;
	private String nom_tematica;
	
	public Tematica (String nom_tematica) {
		llibres = new Vector<Llibre>();
		this.nom_tematica = nom_tematica;
	}

	public void afegirLlibres(int codi_llibre,String titol,String autor,String editorial,int any,int edicio,int gruix,int estanteria_pos) {
		llibres[n].addElement(new Llibre(codi_llibre,titol,autor,editorial,any,edicio,gruix,estanteria_pos));
	}
	public void esborrarLlibres() {
		
	}
	public Llibre consultarLlibres(int codi_llibre) {
		int n = llibres.size();
		for (int i = 0; i < n; i++) {
			if (llibres[i].getNomLlibre == codi_llibre)
		}
	}
	public Estanteria consultarEstanteries() {
		
	}

}
