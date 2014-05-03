package propLlibreria;
import java.util.*;

public class Area {
	private final int ID;
	private String nomArea;
	
	//pre:
	//post: es crea una Area amb nom "nomArea"
	public Area (String nomArea){
		this.nomArea = nomArea;
		ID = BD.novaArea(this);
	}
	//pre:
	//post: retorna nom de l'area
	public String getNomArea() {
		return this.nomArea;
	}
	
	//pre:
	//post: el nom de l'area ara es nomArea
	public String setNomArea(nomArea) {
		this.nomArea = nomArea;
	}
	
	public int getID() {
		return ID;
	}
	
	public void afegirSeccio(Seccio novaSeccio) {
		BD.afegirSeccioArea(ID, novaSeccio.getID());
	}
	
	public void esborrarSeccio(Seccio badSeccio) {
		BD.esborrarSeccioArea(ID, badSeccio.getID());
	}
}
