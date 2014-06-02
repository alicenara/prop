package propLlibreria.Domini;
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
		this.ID = GestioArea.ultimaIDTematica();
		GestioArea.afegirTematica(this);
                Seccio s = GestioArea.getSeccio(IDSeccio);
                s.afegirTematica(this);
	}
	
	//pre:
	//post: crea tematica a partir de BD amb nom de tematica igual a "nomTematica"
	public Tematica (int ID, String nomTematica, int IDSeccio, ArrayList<Integer> llT) {
		this.nomTematica = nomTematica;
		this.IDSeccio = IDSeccio;
		llibresTematica = llT;
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
	
        public void setIDSeccioTematica(int nouIDSeccio) {
		this.IDSeccio = nouIDSeccio;
	}
	
	public int getIDSeccioTematica() {
		return IDSeccio;
	}
	

	public void afegirLlibre(Llibre nouLlibre) {
		nouLlibre.setTemPrincipal(ID);
		llibresTematica.add(nouLlibre.getID());
	}
	
	public ArrayList<Llibre> getLlibres() {
		ArrayList<Llibre> llibres = new ArrayList<Llibre>(); 
		for (int i = 0; i < llibresTematica.size(); ++i) {
			llibres.add(GestioLlibre.getLlibre(llibresTematica.get(i)));
		}
		return llibres;
	}
	
	public void esborrarLlibre(int IDL) {
		llibresTematica.remove(new Integer(IDL));
                GestioLlibre.esborrarLlibreID(IDL);
	}
		
}
