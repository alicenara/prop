package propLlibreria;

public class Tematica {
	
	private Llibre[] llibres;
	private String nom_tematica;
	
	public Tematica (String nom_tematica) {
		llibres = new Llibre[1];
		this.nom_tematica = nom_tematica;
	}

	public void afegirLlibres(int codi_llibre,String titol,String autor,String editorial,int any,int edicio,int gruix,int estanteria_pos) {
		int n = llibres.length;
		llibres[n] = new Llibre(codi_llibre,titol,autor,editorial,any,edicio,gruix,estanteria_pos);
	}
	public void esborrarLlibres() {
		
	}
	public Llibre consultarLlibres(int codi_llibre) {
		int n = llibres.length;
		for (int i = 0; i < n; i++) {
			if (llibres[i].codi_llibre == codi_llibre)
		}
	}
	public Estanteria consultarEstanteries() {
		
	}

}
