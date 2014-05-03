package propLlibreria;
import java.util.*;

public class Tematica {
	private final int ID;
	private String nomTematica;
	private int IDSeccio;
	
	//pre:
	//post: crea tematica a partir de BD amb nom de tematica igual a "nomTematica"
	public Tematica (String nomTematica, int IDSeccio) {
		this.nomTematica = nomTematica;
		this.IDSeccio = IDSeccio;
		this.ID = BD.ultimaIDTematica();
	}
	
	//pre:
	//post: crea tematica a partir de BD amb nom de tematica igual a "nomTematica"
	public Tematica (int ID, String nomTematica, int IDSeccio) {
		this.nomTematica = nomTematica;
		this.IDSeccio = IDSeccio;
		this.ID = ID;
	}
	
	//pre:
	//post:retorna nom de la tematica
	public String getNomTematica() {
			return this.nomTematica;
	}
	
	public int getNomSeccioTematica() {
		return this.IDSeccio;
}
	
	//pre:
	//post:
	public void setNomTematica(String nouNomTematica) {
		this.nomTematica = nouNomTematica;
	}
	
	public void setIDSeccioTematica(int nouIDSeccio) {
		this.IDSeccio = nouIDSeccio;
	}
	
	public int getID() {
		return ID;
	}
	
	public void afegirLlibre(Llibre nouLlibre) {
		nouLlibre.setTematicaPrincipal(this);
	}
		
}
