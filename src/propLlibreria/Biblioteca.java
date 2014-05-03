package propLlibreria;
import java.util.*;

public class Biblioteca {
    //constructor with "Biblioteca"'s name
    
    public Biblioteca() {
    	BD.init();
    }
    
    //Methods
    //pre:
    //post: Llibres classificats segons l'afinitat entre ells i el nombre d'estanteries disponibles a la Biblioteca
	public void reordenacioBiblioteca() {
        //Utilitzar classe Solucio
    }
    //pre:
    //post: retorna l'ordre de classificacio dels llibres de la Biblioteca
--->public matriu consultarOrdreActual() {
        //Descobrir com declarar matriu
    }
	
	//pre: No existeix una Area, tal que el seu nom sigui nomArea
    //post: S'ha creat una nova Area amb nom = nomArea
	public void afegirArea(String nomArea) {
		
	}
	
	//pre: Existeix una Area tal que el seu Identificador = ID
    //post: L'Area amb identificador ID te nom nomA
	public void modificarNomArea(int ID, String nomA) {
		
	}
	
	//pre: Existeix una Area tal que el seu Identificador = IDA i una Seccio tal que el seu identificador es IDS i no esta continguda en l'Area
    //post: L'Area amb identificador IDA conte la Seccio amb identificador IDS 
	public void afegirSeccioArea(int IDA, int IDS) {
		
	}
	
	//pre: Existeix una Area tal que el seu Identificador = IDA i una Seccio tal que el seu identificador es IDS i esta continguda en l'Area
    //post: L'Area amb identificador IDA no conte la Seccio amb identificador IDS 
	public void esborrarSeccioArea(int IDA, int IDS) {
		
	}
	
	//pre: Existeix una Area tal que el seu Identificador = ID
    //post: L'Area amb identificador = ID ha estat eliminada
	public void eliminarArea(int ID) {
		
	}
	
	//pre: No existeix una Seccio, tal que el seu nom sigui nomSeccio
    //post: S'ha creat una nova Seccio amb nom = nomSeccio
	public void afegirSeccio(String nomSeccio) {
		
	}
	
	//pre: Existeix una Seccio tal que el seu Identificador = ID
    //post: La Seccio amb identificador ID te nom nomS
	public void modificarNomSeccio(int ID, String nomS) {
		
	}
	
	//pre: Existeix una Seccio tal que el seu Identificador = IDS i una Tematica tal que el seu identificador es IDT i no esta continguda en la Seccio
    //post: La Seccio amb identificador IDS conte la Tematica amb identificador IDT 
	public void afegirTematicaSeccio(int IDS, int IDT) {
		
	}
	
	//pre: Existeix una Seccio tal que el seu Identificador = IDS i una Tematica tal que el seu identificador es IDT i esta continguda en la Seccio
    //post: La Seccio amb identificador IDS no conte la Tematica amb identificador IDT
	public void esborrarTematicaSeccio(int IDS, int IDT) {
		
	}
	
	//pre: Existeix una Seccio tal que el seu Identificador = ID
    //post: La Seccio amb identificador = ID ha estat eliminada
	public void eliminarSeccio(int ID) {
		
	}
	
	//pre: No existeix una Tematica, tal que el seu nom sigui nomTematica
    //post: S'ha creat una nova Tematica amb nom = nomTematica
	public void afegirTematica(String nomTematica) {
		
	}
	
	//pre: Existeix una Tematica tal que el seu Identificador = ID
    //post: La Tematica amb identificador ID te nom nomT
	public void modificarNomTematica(int ID, String nomT) {
		
	}
	
	//pre: Existeix una Tematica tal que el seu Identificador = IDT i un Llibre tal que el seu identificador es IDL i no esta contingut en la Tematica
    //post: La Tematica amb identificador IDT conte el Llibre amb identificador IDL 
	public void afegirLlibreTematica(int IDT, int IDL) {
		
	}
	
	//pre: Existeix una Tematica tal que el seu Identificador = IDT i un Llibre tal que el seu identificador es IDL i esta contingut en la Tematica
    //post: La Tematica amb identificador IDT no conte el Llibre amb identificador IDL 
	public void esborrarLlibreTematica(int IDT, int IDL) {
		
	}
	
	//pre: Existeix una Tematica tal que el seu Identificador = ID
    //post: La Tematica amb identificador = ID ha estat eliminada
	public void eliminarTematica(int ID) {
		
	}
    
    public void afegirEstanteria() {
        
    }
    
    public void esborrarEstanteria() {
        
    }
}