package propLlibreria;
import java.util.*;

public class Seccio {
	private String nomSeccio;
	private final int ID;
	private String nomArea;
	
	//pre:
	//post: crea una seccio amb nom "nomSeccio"
	public Seccio (String nomSeccio, String nomArea) {
		this.nomSeccio = nomSeccio;
		this.nomArea = nomArea;
		ID = BD.novaSeccio(this);
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
	
	public void setNomAreaSeccio(String nomArea) {
		this.nomArea = nomArea;
	}
	
	public String getNomAreaSeccio() {
		return this.nomSeccio;
	}
	
	//pre:	el parametre implicit no conte una tematica amb nom "nomTematica"
	//post: afegeix una tematica al parametre implicit
	public void afegirTematica(Tematica novaTematica) {
		novaTematica.setNomSeccioTematica(nomSeccio);
	}
	
}
