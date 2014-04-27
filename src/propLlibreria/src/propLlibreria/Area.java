package propLlibreria;
import java.util.*;

public class Area {
	private String nom_area;
	private Vector<Seccio> seccions;
	
	public Area (String nom_area){
		this.nom_area = nom_area;
		this.seccions = new Vector<Seccio>();
	}
	public String getNomArea() {
		return this.nom_area;
	}
	
	public void afegirSeccio(String nom_seccio) {
		Seccio nova_seccio = new Seccio(nom_seccio);
		seccions.addElement(nova_seccio);
	}
	public void esborrarSeccio(String seccio) {
		int p = getPosSeccio(seccio);
		seccions.remove(p);
	}
	private int getPosSeccio(String seccio) {
		int n = seccions.size();
		for (int i = 0; i < n; i++) {
			if (seccio[i].getNomSeccio() = seccio) return i;
		}
	}
}
