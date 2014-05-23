package propLlibreria.Domini;

import java.util.*;

public class Area {
	private final int ID;
	private String nomArea;
        private ArrayList<Integer> seccionsArea;
	
	//pre:
	//post: es crea una Area amb nom "nomArea"
	public Area (String nomArea){
		this.nomArea = nomArea;
		ID = BD.ultimaIDArea();
		BD.afegirArea(this);
	}
	
	//pre:
	//post: es crea una Area amb nom "nomArea"
	public Area (int ID, String nomArea){
		this.nomArea = nomArea;
		this.ID = ID;
	}
	
	//pre:
	//post: retorna nom de l'area
	public String getNomArea() {
		return this.nomArea;
	}
	
	//pre:
	//post: el nom de l'area ara es nomArea
	public void setNomArea(String nomArea) {
		this.nomArea = nomArea;
	}
	
	public int getID() {
		return ID;
	}
        
        public void afegirSeccio(Seccio novaSeccio) {
		novaSeccio.setIDAreaSeccio(ID);
		seccionsArea.add(novaSeccio.getID());
	}
	
	public ArrayList<Seccio> getSeccions() {
		ArrayList<Seccio> seccions = new ArrayList<Seccio>(); 
		for (int i = 0; i < seccionsArea.size(); ++i) {
			seccions.add(GestioArea.getSeccio(seccionsArea.get(i)));
		}
		return seccions;
	}
	
	public void esborrarSeccio(int IDS) {
		seccionsArea.remove((Object)new Integer(IDS));
	}
	
}
