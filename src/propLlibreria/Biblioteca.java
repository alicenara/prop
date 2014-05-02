package propLlibreria;
import java.util.*;

public class Biblioteca {
	
    //All "Biblioteca"'s attributes
    
	private String nomBiblioteca;
    
    //Default constructor
    
	public Biblioteca() {
	}
    
    //constructor with "Biblioteca"'s name
    
    public Biblioteca(String nomBiblioteca) {
        setNomBiblioteca(nomBiblioteca);
    }

    //Methods
    
    public void setNomBiblioteca(String nomBiblioteca) {
        this.nomBiblioteca = nomBiblioteca;
    }
    
    public void setEstanteries(ArrayList<Estanteria> estanteries) {
        BD.setEstanteries(estanteries);
    }
    
    public ArrayList<Estanteries> getEstanteries() {
        return estanteries;
    }
    
	public double calcularAfinitatLlibres(Llibre a, Llibre b) {
    //Classe calcularAfinitat NO aqui
    }
    

	public void ordenarLlibres() {
	//Utilitzar classe Solució
    }

	public matriu consultarOrdreActual() {
    //Descobrir com declarar matriu
    }

	public void afegirEstanteria(Estanteria novaEstanteria) {
        estanteries.add(novaEstanteria);
	}

	public void esborrarEstanteria(Estanteria badEstanteria) {
		estanteries.remove(badEstanteria);
	}
}