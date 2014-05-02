package propLlibreria;

public class Tematica {
	private final int ID;
	private String nomTematica;
	
	//pre:
	//post: crea nova tematica amb nom de tematica igual a "nomTematica"
	public Tematica (String nomTematica) {
		this.nomTematica = nomTematica;
		this.ID = CtrlBD.obtenirUltimaIDTematica();
	}
	
	//pre:
	//post: crea tematica a partir de BD amb nom de tematica igual a "nomTematica"
	public Tematica (int ID, String nomTematica) {
		this.nomTematica = nomTematica;
		this.ID = ID;
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
