package propLlibreria;

public class Seccio {
	private String nomSeccio;
	private final int ID;
	private int IDArea;
	
	//pre:
	//post: crea una seccio amb nom "nomSeccio"
	public Seccio (String nomSeccio, int IDArea) {
		this.nomSeccio = nomSeccio;
		this.IDArea = IDArea;
		this.ID = BD.ultimaIDSeccio();
		BD.afegirSeccio(this);
	}
	
	//pre:
	//post: crea una seccio amb nom "nomSeccio"
	public Seccio (int ID, String nomSeccio, int IDArea) {
		this.nomSeccio = nomSeccio;
		this.IDArea = IDArea;
		this.ID = ID;
	}
	
	public Seccio (){
		ID = -1;
	}
	
	//pre:
	//post: retorna el id de seccio del parametre implicit
	public int getID(){
		return this.ID;
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
	
	public void setIDAreaSeccio(int IDArea) {
		this.IDArea = IDArea;
	}
	
	public int getIDAreaSeccio() {
		return this.IDArea;
	}
	
	//pre:	el parametre implicit no conte una tematica amb nom "nomTematica"
	//post: afegeix una tematica al parametre implicit
	public void afegirTematica(Tematica novaTematica) {
		novaTematica.setIDSeccio(ID);
	}
	
}
