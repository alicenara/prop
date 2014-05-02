package propLlibreria;
import java.util.*;

public class Tematica {
	private final int ID;
	private String nomTematica;
	
	//pre:
	//post: crea nova tematica amb nom de tem�tica igual a "nomTematica"
	public Tematica (String nomTematica) {
		this.nomTematica = nomTematica;
		ID = BD.novaTematica(this);
	}
	
	//pre:
	//post:retorna nom de la tem�tica
	public String getNomTematica() {
			return this.nomTematica;
	} 
	
	public int getID() {
		return ID;
	}	
}
