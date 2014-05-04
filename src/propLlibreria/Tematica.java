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
	
	//pre:
	//post:
	public void setNomTematica(String nouNomTematica) {
		this.nomTematica = nouNomTematica;
	}
	
	public void setIDSeccioTematica(int nouIDSeccio) {
		this.IDSeccio = nouIDSeccio;
	}
	
	public void getIDSeccioTematica() {
		return IDSeccio;
	}
	
	public int getID() {
		return ID;
	}
	
	public void afegirLlibre(Llibre nouLlibre) {
		nouLlibre.setTematicaPrincipal(this);
		llibresTematica.add(nouLlibre.getID());
	}
	
	public ArrayList<Llibre> getLlibres() {
		ArrayList<Llibre> Llibres; 
		for (int i = 0; i < llibresTematica.size(); ++i) {
			Llibres.add(BD.getLlibre(llibresTematica.get(i));
		}
		return Llibres;
	}
	
	public void esborrarLlibre(int IDL) {
		llibresTematica.remove((Object)new Integer(IDL));
	}
		
}
