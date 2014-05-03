package propLlibreria;
import java.util.*;

public class Biblioteca {
    
	//Constructora
    public Biblioteca() {
    	BD.init();
    }
    
    //Metodes
    //pre:
    //post: Llibres classificats segons l'afinitat entre ells i el nombre d'estanteries disponibles a la Biblioteca
	public void reordenacioBiblioteca() {
        //Utilitzar classe Solucio
    }
	
	//pre: No existeix una Area, tal que el seu nom sigui nomArea
    //post: S'ha creat una nova Area amb nom = nomArea
	public int afegirArea(String nomArea) {
		Area novaArea = new Area(nomArea);
		return novaArea.getID();
	}
	
	//pre: Existeix una Area tal que el seu Identificador = ID
    //post: L'Area amb identificador ID te nom nomA
	public void modificarNomArea(int ID, String nomA) {
		Area modArea = BD.getArea(ID);
		modArea.setNomArea(nomA);
	}
	
	//pre: Existeix una Area tal que el seu Identificador = IDA i una Seccio tal que el seu identificador es IDS i no esta continguda en l'Area
    //post: L'Area amb identificador IDA conte la Seccio amb identificador IDS 
	public void afegirSeccioArea(int IDA, int IDS) {
		Area modArea = BD.getArea(IDA);
		Seccio afSeccio = BD.getSeccio(IDS);
		modArea.afegirSeccio(afSeccio);
	}
	
	//pre: Existeix una Area tal que el seu Identificador = IDA i una Seccio tal que el seu identificador es IDS i esta continguda en l'Area
    //post: L'Area amb identificador IDA no conte la Seccio amb identificador IDS 
	public void esborrarSeccioArea(int IDA, int IDS) {
		Area modArea = BD.getArea(IDA);
		Seccio esbSeccio = BD.getSeccio(IDS);
		modArea.esborrarSeccio(esbSeccio);
	}
	
	//pre: Existeix una Area tal que el seu Identificador = ID
    //post: L'Area amb identificador = ID ha estat eliminada
	public void eliminarArea(int ID) {
		BD.esborrarArea(ID);
	}
	
	//pre: No existeix una Seccio, tal que el seu nom sigui nomSeccio
    //post: S'ha creat una nova Seccio amb nom = nomSeccio
	public int afegirSeccio(String nomSeccio) {
		Seccio novaSeccio = new Seccio(nomSeccio);
		return novaSeccio.getID();
	}
	
	//pre: Existeix una Seccio tal que el seu Identificador = ID
    //post: La Seccio amb identificador ID te nom nomS
	public void modificarNomSeccio(int ID, String nomS) {
		Seccio modSeccio = BD.getSeccio(ID);
		modSeccio.setNomSeccio(nomS);
	}
	
	//pre: Existeix una Seccio tal que el seu Identificador = IDS i una Tematica tal que el seu identificador es IDT i no esta continguda en la Seccio
    //post: La Seccio amb identificador IDS conte la Tematica amb identificador IDT 
	public void afegirTematicaSeccio(int IDS, int IDT) {
		Seccio modSeccio = BD.getSeccio(IDS);
		Tematica afTematica = BD.getTematica(IDT);
		modSeccio.afegirTematica(afTematica);
	}
	
	//pre: Existeix una Seccio tal que el seu Identificador = IDS i una Tematica tal que el seu identificador es IDT i esta continguda en la Seccio
    //post: La Seccio amb identificador IDS no conte la Tematica amb identificador IDT
	public void esborrarTematicaSeccio(int IDS, int IDT) {
		Seccio modSeccio = BD.getSeccio(IDS);
		Tematica esbTematica = BD.getTematica(IDT);
		modSeccio.esborrarTematica(esbTematica);
	}
	
	//pre: Existeix una Seccio tal que el seu Identificador = ID
    //post: La Seccio amb identificador = ID ha estat eliminada
	public void eliminarSeccio(int ID) {
		BD.esborrarSeccio(ID);
	}
	
	//pre: No existeix una Tematica, tal que el seu nom sigui nomTematica
    //post: S'ha creat una nova Tematica amb nom = nomTematica
	public int afegirTematica(String nomTematica) {
		Tematica novaTematica = new Tematica(nomTematica);
		return novaTematica.getID();
	}
	
	//pre: Existeix una Tematica tal que el seu Identificador = ID
    //post: La Tematica amb identificador ID te nom nomT
	public void modificarNomTematica(int ID, String nomT) {
		Tematica modTematica = BD.getTematica(ID);
		modTematica.setNomTematica(nomT);
	}
	
	//pre: Existeix una Tematica tal que el seu Identificador = IDT i un Llibre tal que el seu identificador es IDL i no esta contingut en la Tematica
    //post: La Tematica amb identificador IDT conte el Llibre amb identificador IDL 
	public void afegirLlibreTematica(int IDT, int IDL) {
		Tematica modTematica = BD.getTematica(IDT);
		Llibre afLlibre = BD.getLlibre(IDL);
		modTematica.afegirLlibre(afLlibre);
	}
	
	//pre: Existeix una Tematica tal que el seu Identificador = IDT i un Llibre tal que el seu identificador es IDL i esta contingut en la Tematica
    //post: La Tematica amb identificador IDT no conte el Llibre amb identificador IDL 
	public void esborrarLlibreTematica(int IDT, int IDL) {
		Tematica modTematica = BD.getTematica(IDT);
		Llibre esbLlibre = BD.getLlibre(IDL);
		modTematica.esborrarLlibre(esbLlibre);
	}
	
	//pre: Existeix una Tematica tal que el seu Identificador = ID
    //post: La Tematica amb identificador = ID ha estat eliminada
	public void eliminarTematica(int ID) {
		BD.esborrarTematica(ID);
	}
	
	//pre: Existeix una Tematica tal que Tematica = tPrincipal i no existeix un Llibre, tal que isbn = isbn, titol = titol, autor = autor, editorial = editorial, any = any i edicio = edicio
    //post: S'ha creat una nou Llibre amb isbn = isbn, titol = titol, autor = autor, editorial = editorial, any = any i edicio = edicio
	public void afegirLlibre(String isbn, String titol, String autor, String editorial, int any, int edicio, Tematica tPrincipal) {
		
	}
	
	//pre: Existeix un Llibre tal que el seu Identificador = IDL i una Tematica tal que el seu identificador es IDT i no esta continguda en les Tematiques Secundaries del Llibre
	//post: El Llibre amb identificador IDL conte en les seves Tematiques Secundaries la Tematica amb identificador IDT
	public void afergirTSecundaries(int IDL, int IDT) {
		
	}
	
	//pre: Existeix un Llibre tal que el seu Identificador = ID
    //post: El Llibre amb identificador ID te isbn = isbnmod
	public void modificarIsbnLlibre(int ID, String isbnmod) {
		
	}
	
	//pre: Existeix un Llibre tal que el seu Identificador = ID
    //post: El Llibre amb identificador ID te titol = titolmod
	public void modificarTitolLlibre(int ID, String titolmod) {
		
	}
	
	//pre: Existeix un Llibre tal que el seu Identificador = ID
    //post: El Llibre amb identificador ID te autor = autormod
	public void modificarAutorLlibre(int ID, String autormod) {
		
	}
	
	//pre: Existeix un Llibre tal que el seu Identificador = ID
    //post: El Llibre amb identificador ID te editorial = editorialmod
	public void modificarEditorialLlibre(int ID, String editorialmod) {
		
	}
	
	//pre: Existeix un Llibre tal que el seu Identificador = ID
    //post: El Llibre amb identificador ID te any = anymod
	public void modificarAnyLlibre(int ID, int anymod) {
		
	}
	
	//pre: Existeix un Llibre tal que el seu Identificador = ID
    //post: El Llibre amb identificador ID te edicio = ediciomod
	public void modificarEdicioLlibre(int ID, int ediciomod) {
		
	}
	
	//pre: Existeix un Llibre tal que el seu Identificador = ID i existeix una Tematica tal que Tematica = tPrincipalmod
    //post: El Llibre amb identificador ID te temPrincipal = codi identificador de tPrincipalmod
	public void modificarTPrincipalLlibre(int ID, Tematica tPrincipalmod) {
		
	}
	
	//pre: Existeix un Llibre tal que el seu Identificador = ID
    //post: El Llibre amb identificador = ID ha estat eliminat
	public void eliminarLlibre(int ID) {
		
	}
    
	//pre: No existeix una Estanteria, tal que la seva posicio sigui posX = posX i posY = PosY
    //post: S'ha creat una nova Estanteria amb nunmFiles = numFiles, llargada = llargda, posX = posX i posY = posY
	public void afegirEstanteria(int numFiles, int llargada, int posX, int posY) {
		
	}
	
	//pre: Existeix una Estanteria tal que el seu Identificador = ID
    //post: La Estanteria amb identificador ID te numFiles = numFilesmod
	public void modificarNumFilesEstanteria(int ID, int numFilesmod) {
		
	}
	
	//pre: Existeix una Estanteria tal que el seu Identificador = ID
    //post: La Estanteria amb identificador ID te llargada = llargadamod
	public void modificarLlargadaEstanteria(int ID, int llargadamod) {
		
	}
	
	//pre: Existeix una Estanteria tal que el seu Identificador = IDE i un Llibre tal que el seu identificador es IDL i no esta contingut en la Estanteria
    //post: La Estanteria amb identificador IDE conte el Llibre amb identificador IDL 
	public void afegirLlibreEstanteria(int IDE, int IDL) {
		
	}
	
	//pre: Existeix una Estanteria tal que el seu Identificador = IDE i un Llibre tal que el seu identificador es IDL i esta contingut en la Estanteria
    //post: La Estanteria amb identificador IDE no conte el Llibre amb identificador IDL 
	public void esborrarLlibreEstanteria(int IDE, int IDL) {
		
	}
	
	//pre: Existeix una Estanteria tal que el seu Identificador = ID
    //post: La Estanteria amb identificador = ID ha estat eliminada
	public void eliminarEstanteria(int ID) {
		
	}
    
    //Consultores
	
	public ArrayList<Llibre> consultarLlibresArea(int IDA) {
		
	}
	
	public Area consultarAtributsArea(int IDA) {
		
	}
	
	public ArrayList<Llibre> consultarLlibresSeccio(int IDS) {
		
	}
	
	public Seccio consultarAtributsSeccio(int IDS) {
		
	}
	
	public ArrayList<Llibre> consultarLlibresTematica(int IDT) {
		
	}
	
	public Tematica consultarAtributsTematica(int IDT) {
		
	}
	
	public ArrayList<Llibre> consultarLlibresEstanteria(int IDE) {
		
	}
	
	public Estanteria consultarAtributsEstanteria(int IDE) {
		
	}
	
	public Llibre consultarAtributsLlibre(int IDL) {
		
	}
	
	public ArrayList<Llibre> consultarOrdreActual() {
	
    }
	
}