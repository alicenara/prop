package propLlibreria;
import java.util.Vector;

public class Seccio {
	private String nom_seccio;
	private Vector<Tematica> tematiques;
	
	public Seccio (String nom_seccio) {
		this.nom_seccio = nom_seccio;
	}
	public String getNomSeccio() {
		return this.nom_seccio;
	}
	public void afegirTematica(String nom_tematica) {
		this.tematiques.addElement(new Tematica(nom_tematica));
	}
	public void esborrarTematica() {
		
	}
}
