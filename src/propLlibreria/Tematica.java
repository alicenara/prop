package propLlibreria;
import java.util.*;

public class Tematica {
	private final int ID;
	private String nomTematica;
	
	//pre:
	//post: crea nova tematica amb nom de tematica igual a "nomTematica"
	public Tematica (String nomTematica) {
		this.nomTematica = nomTematica;
		ID = BD.novaTematica(this);
	}
	
	//pre:
	//post:retorna nom de la tematica
	public String getNomTematica() {
			return this.nomTematica;
	}
	
	//pre:
	//post:
	public void setNomTematica (String nouNomTematica) {
		this.nomTematica = nouNomTematica;
	}
	
	public int getID() {
		return ID;
	}	
}
