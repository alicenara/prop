package propLlibreria;
import java.util.*;

public class Area {
	private Seccio[] seccions;
	private String nom_area;
	
	public Area (String nom_area){
		this.seccions = new Seccio[];
		this.nom_area = nom_area;
	}
	
	public void afegirSeccio(String nom_seccio) {
		int num_seccions = seccions.length;
		nova_seccio = new Seccio(nom_seccio);
		seccions[num_seccions] = nom_seccio;
	}
	public void esborrarSeccio(String seccio) {
		int p = getPosSeccio(seccio);
		System.arraycopy(seccions,p+1,seccions,p,seccions.length-p-1);
		seccions[seccions.length()-1]= 0;
	}
	private int getPosSeccio(String seccio) {
		for (int i = 0; i < n; i++) {
			if (seccio[i].nom_seccio = seccio) return i;
		}
	}
}
