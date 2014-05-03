package propLlibreria;
import java.util.*;

public class Tematica {
	private final int ID;
	private String nomTematica;
	private String nomSeccio;
	
	//pre:
	//post: crea nova tematica amb nom de tematica igual a "nomTematica"
	public Tematica (String nomTematica, String nomSeccio) {
		this.nomTematica = nomTematica;
		this.nomSeccio = nomSeccio;
		this.ID = CtrlBD.obtenirUltimaIDTematica();
	}
	
	//pre:
	//post: crea tematica a partir de BD amb nom de tematica igual a "nomTematica"
	public Tematica (String nomTematica, String nomSeccio) {
		this.nomTematica = nomTematica;
		this.nomSeccio = nomSeccio;
		ID = BD.novaTematica(this);
	}
	
	//pre:
	//post:retorna nom de la tematica
	public String getNomTematica() {
			return this.nomTematica;
	}
	
	public String getNomSeccioTematica() {
		return this.nomSeccio;
}
	
	//pre:
	//post:
	public void setNomTematica(String nouNomTematica) {
		this.nomTematica = nouNomTematica;
	}
	
	public void setNomSeccioTematica(String nouNomSeccio) {
		this.nomSeccio = nouNomSeccio;
	}
	
	public int getID() {
		return ID;
	}
	
	public void afegirLlibre(Llibre nouLlibre) {
		nouLlibre.setTematicaPrincipal(this);
	}
		
}
