package propLlibreria;
import java.util.*;

public class Bibliotecari {
    
    // All "Bibliotecari"'s attributes
	
    private String contrasenya;

    //Default constructor
    
    public Bibliotecari() {
    }
    
    //All atributtes constructor
	
    public Bibliotecari(String contrasenya) {
		setContrasenya(contrasenya);
	}
    
    //Methods
    
	public void setContrasenya(String contrasenya) {
		this.contrasenya = contrasenya;
	}

	public void restablirContrasenya(String contrasenyaAnterior, String contrasenyaNova) {
        if (this.contrasenya == contrasenyaAnterior)
		setContrasenya(contrasenyaNova);
	}
    
    public Biblioteca gestionaBiblioteca(String nomBiblioteca, String contrasenya) {
        Biblioteca Biblio;
        if (contrasenya == this.contrasenya) Biblio = new Biblioteca(nomBiblioteca);
        return Biblio;
    }

}