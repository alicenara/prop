package propLlibreria;

public class Bibliotecari {
    
    // All "Bibliotecari"'s attributes
	
    private String contrasenya;
    private int ID;
 
    //All atributtes constructor
	
    public Bibliotecari(String contrasenya) {
		setContrasenya(contrasenya);
		this.ID = BD.ultimaIDBibliotecari();
		BD.afegirBibliotecari(this);
	}
    
    public Bibliotecari(int ID, String contrasenya) {
  		setContrasenya(contrasenya);
  		this.ID = ID;
  	}
    
    //Methods
    
	public int getID() {
		return ID;
	}	
    
	public String getContrasenya() {
		return this.contrasenya;
	}
	
	public void setContrasenya(String contrasenya) {
		this.contrasenya = contrasenya;
	}

	public boolean restablirContrasenya(String contrasenyaAnterior, String contrasenyaNova) {
        if (this.contrasenya == contrasenyaAnterior) {
		setContrasenya(contrasenyaNova);
		return true;
        }
        else return false;
	}

}