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
	//post: par�metre impl�cit passa a tenir com a nom de secci� "nomSeccio"
	public void setNomSeccio(String nomSeccio) {
		this.nomSeccio = nomSeccio;
	}
	//pre:
	//post: retorna el nom de secci� del par�metre impl�cit
	public String getNomSeccio() {
		return this.nomSeccio;
	}
	
	//pre:	el par�metre impl�cit no cont� una tem�tica amb nom "nomTematica"
	//post: afegeix una tem�tica al par�metre impl�cit
	public void afegirTematica(String nomTematica) {
		BD.getTematicaPerSeccio();
	}
	
}
