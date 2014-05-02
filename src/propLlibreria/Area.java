package propLlibreria;
import java.util.*;

public class Area {
	private final int ID;
	private String nomArea;
	
	//pre:
	//post: es crea una àrea amb nom "nomArea"
	public Area (String nomArea){
		this.nomArea = nomArea;
	}
	//pre:
	//post: retorna nom de l'area
	public String getNomArea() {
		return this.nomArea;
	}
	
	public void afegirSeccio(Seccio novaSeccio) {
		BD.afegirSeccioAArea(novaSeccio.getID());
	}
}
