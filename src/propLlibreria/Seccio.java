package propLlibreria;
import java.util.ArrayList;

public class Seccio {
	private String nomSeccio;
	private final int ID;
	
	//pre:
	//post: crea una seccio amb nom "nomSeccio"
	public Seccio (String nomSeccio) {
		this.nomSeccio = nomSeccio;
		ID = BD.novaSecio(this);
	}
	
	//pre:
	//post: parametre implicit passa a tenir com a nom de secció "nomSeccio"
	public void setNomSeccio(String nomSeccio) {
		this.nomSeccio = nomSeccio;
	}
	//pre:
	//post: retorna el nom de secció del parametre implicit
	public String getNomSeccio() {
		return this.nomSeccio;
	}
	
	//pre:	el parametre implicit no conte una tematica amb nom "nomTematica"
	//post: afegeix una tematica al parametre implicit
	public void afegirTematica(String nomTematica) {
		BD.getTematicaPerSeccio(nomTematica);
	}
	
}
