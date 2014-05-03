package propLlibreria;
import java.util.*;

public class Area {
	private final int ID;
	private String nomArea;
	
	//pre:
	//post: es crea una Area amb nom "nomArea"
	public Area (String nomArea){
		this.nomArea = nomArea;
		ID = BD.ultimaIDArea();
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
	}
	
}
