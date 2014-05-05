package propLlibreria;
import java.util.*;

public class Bibliotecari {
    
    // All "Bibliotecari"'s attributes
	
    private String contrasenya;
 
    //All atributtes constructor
	
    public Bibliotecari(String contrasenya) {
		setContrasenya(contrasenya);
	}
    
    //Methods
    
	public void setContrasenya(String contrasenya) {
		this.contrasenya = contrasenya;
	}
	
	//Consultores
	public boolean logIn(String contrasenya) {
		if (contrasenya == this.contrasenya) return true;
		else return false;
	}

	public void restablirContrasenya(String contrasenyaAnterior, String contrasenyaNova) {
        if (this.contrasenya == contrasenyaAnterior)
		setContrasenya(contrasenyaNova);
	}
    
   /* public Biblioteca gestionaBiblioteca(String contrasenya) {
        if (contrasenya != this.contrasenya) return null;
        if (biblioteca == null) {
        	biblioteca = new Biblioteca();
        	BD.afegirBibliotecari(this);
        }
        return biblioteca;
    }*/

}