package propLlibreria;

public class Seccio {
	
	private Tematica[] tematiques;
	private String nom_seccio;
	
	public Seccio (String nom_seccio) {
		this.nom_seccio = nom_seccio;
	}
	
	public Tematica afegirTematica(String nom_tematica) {
		int n = tematiques.length();
		this.tematiques[n] = new Tematica(nom_tematica);
		
	}
	public Tematica esborrarTematica() {
		
	}

}
