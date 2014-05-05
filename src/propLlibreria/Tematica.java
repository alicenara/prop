package propLlibreria;
import java.util.*;

public class Tematica {
	private final int ID;
	private String nomTematica;
	private int IDSeccio;
	private ArrayList<Integer> llibresTematica;
	
	//pre:
	//post: crea tematica a partir de BD amb nom de tematica igual a "nomTematica"
	public Tematica (String nomTematica, int IDSeccio) {
		this.nomTematica = nomTematica;
		this.IDSeccio = IDSeccio;
		this.ID = BD.ultimaIDTematica();
		BD.afegirTematica(this);
	}
	
	//pre:
	//post: crea tematica a partir de BD amb nom de tematica igual a "nomTematica"
	public Tematica (int ID, String nomTematica, int IDSeccio) {
		this.nomTematica = nomTematica;
		this.IDSeccio = IDSeccio;
		this.ID = ID;
	}
	
		public int getID() {
		return ID;
	}	
	
	//pre:
	//post:retorna nom de la tematica
	public String getNomTematica() {
			return this.nomTematica;
	}
	
	//pre:
	//post:
	public void setNomTematica(String nouNomTematica) {
		this.nomTematica = nouNomTematica;
	}
	
	public void setIDSeccio(int nouIDSeccio) {
		this.IDSeccio = nouIDSeccio;
	}
	
	public int getIDSeccio() {
		return IDSeccio;
	}
	

	public void afegirLlibre(Llibre nouLlibre) {
		nouLlibre.setTemPrincipal(ID);
		llibresTematica.add(nouLlibre.getID());
	}
	
	public ArrayList<Llibre> getLlibres() {
		ArrayList<Llibre> llibres = new ArrayList<Llibre>(); 
		for (int i = 0; i < llibresTematica.size(); ++i) {
			llibres.add(BD.getLlibre(llibresTematica.get(i)));
		}
		return llibres;
	}
	
	public void esborrarLlibre(int IDL) {
		llibresTematica.remove((Object)new Integer(IDL));
	}
		
}
