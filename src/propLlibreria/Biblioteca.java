package propLlibreria;
import java.util.*;

public class Biblioteca {
    //constructor with "Biblioteca"'s name
    
    public Biblioteca() {
    	BD.init();
    }

    //Methods
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