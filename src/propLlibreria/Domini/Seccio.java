package propLlibreria.Domini;

import java.util.*;

public class Seccio {
	private String nomSeccio;
	private final int ID;
	private int IDArea;
        private ArrayList<Integer> tematiquesSeccio;
	
	//pre:
	//post: crea una seccio amb nom "nomSeccio"
	public Seccio (String nomSeccio, int IDArea) {
		this.nomSeccio = nomSeccio;
		this.IDArea = IDArea;
		this.ID = GestioArea.ultimaIDSeccio();
		GestioArea.afegirSeccio(this);
	}
	
	//pre:
	//post: crea una seccio amb nom "nomSeccio"
	public Seccio (int ID, String nomSeccio, int IDArea, ArrayList<Integer> tS) {
		this.nomSeccio = nomSeccio;
		this.IDArea = IDArea;
		this.ID = ID;
                tematiquesSeccio = tS;
	}
	
	//pre:
	//post: retorna el id de seccio del parametre implicit
	public int getID(){
		return this.ID;
	}
	
	//pre:
	//post: parametre implicit passa a tenir com a nom de seccio "nomSeccio"
	public void setNomSeccio(String nomSeccio) {
		this.nomSeccio = nomSeccio;
	}
	//pre:
	//post: retorna el nom de seccio del parametre implicit
	public String getNomSeccio() {
		return this.nomSeccio;
	}
	
	public void setIDAreaSeccio(int IDArea) {
		this.IDArea = IDArea;
	}
	
	public int getIDAreaSeccio() {
		return this.IDArea;
	}
	
	public void afegirTematica(Tematica novaTematica) {
		novaTematica.setIDSeccio(ID);
		tematiquesSeccio.add(novaTematica.getID());
	}
	
	public ArrayList<Tematica> getTematiques() {
		ArrayList<Tematica> tematiques = new ArrayList<Tematica>(); 
		for (int i = 0; i < tematiquesSeccio.size(); ++i) {
			tematiques.add(GestioArea.getTematica(tematiquesSeccio.get(i)));
		}
		return tematiques;
	}
	
	public void esborrarTematica(int IDT) {
		tematiquesSeccio.remove(new Integer(IDT));
	}
	
}
