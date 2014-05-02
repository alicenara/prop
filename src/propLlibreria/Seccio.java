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
	//post: paràmetre implícit passa a tenir com a nom de secció "nomSeccio"
	public void setNomSeccio(String nomSeccio) {
		this.nomSeccio = nomSeccio;
	}
	//pre:
	//post: retorna el nom de secció del paràmetre implícit
	public String getNomSeccio() {
		return this.nomSeccio;
	}
	
	//pre:	el paràmetre implícit no conté una temàtica amb nom "nomTematica"
	//post: afegeix una temàtica al paràmetre implícit
	public void afegirTematica(String nomTematica) {
		BD.getTematicaPerSeccio();
	}
	
}
