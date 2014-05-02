package propLlibreria;
import java.util.*;

public class Area {
	private String nomArea;
	private ArrayList<Seccio> seccions;
	
	//pre:
	//post: si existeix al paràmetre implicit una seccio amb nom "seccio" retorna 0 <= i < n,
	//sent n el numero de seccions. En cas contrari retorna -1
	private int getPosSeccio(String seccio) {
		int n = seccions.size();
		for (int i = 0; i < n; i++) {
			if (seccions.get(i).getNomSeccio() == seccio) return i;
		}
		return -1;
	}
	
	//pre:
	//post: es crea una àrea amb nom "nomArea"
	public Area (String nomArea){
		this.nomArea = nomArea;
		this.seccions = new ArrayList<Seccio>();
	}
	//pre:
	//post: retorna nom de l'area
	public String getNomArea() {
		return this.nomArea;
	}
	
	public void afegirSeccio(String nom_seccio) {
		Seccio nova_seccio = new Seccio(nom_seccio);
		seccions.add(nova_seccio);
	}
	
	//pre:
	//post: elimina seccio de l'àrea amb nom "seccio"
	public void esborrarSeccio(String seccio) {
		int pos = getPosSeccio(seccio);
		if (pos != -1) seccions.remove(pos);
	}
	
	public void esborrarArea() {
		Runtime garbage = Runtime.getRuntime();
	    garbage.gc();
	}
	
	//pre:
	//post: retorna el numero de seccions dins d'una area
	public int getNumSeccions() {
		return this.seccions.size();
	}
	
	//pre:
	//post:retorna la seccio contiguda a àrea amb nom de seccio "seccio". En cas contrari retorna null.
	public Seccio getSeccio(String seccio) {
		int n = seccions.size();
		for (int i = 0; i <n ; i++) {
			if (seccions.get(i).getNomSeccio() == seccio) return seccions.get(i);
		}
		return null;
	}
}
