package propLlibreria;
import java.util.*;

public class Biblioteca {
    
	//Constructora
    public Biblioteca() {
    	BD.omplirBD();
    }
    
    //Metodes
    //pre:
    //post: Llibres classificats segons l'afinitat entre ells i el nombre d'estanteries disponibles a la Biblioteca
	public void reordenacioBiblioteca() {
        //Utilitzar classe Solucio, pendent de la compartida!
    }
	
	public void guardarSolucio() {
		BD.desarBD();
	}
	
	//pre: No existeix una Area, tal que el seu nom sigui nomArea
    //post: S'ha creat una nova Area amb nom = nomArea
	public int afegirArea(String nomArea) {
		Area novaArea = new Area(nomArea);
		BD.afegirArea(novaArea);
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
	public void modificarSeccioArea(int IDA, int IDS) {
		Area modArea = BD.getArea(IDA);
		Seccio afSeccio = BD.getSeccio(IDS);
		modArea.afegirSeccio(afSeccio);
	}
	
	//pre: Existeix una Area = esbArea
    //post: L'Area = esbArea ha estat eliminada
	public void eliminarArea(esbArea) {
		BD.esborrarArea(esbArea);
	}
	
	//pre: No existeix una Seccio, tal que el seu nom sigui nomSeccio
    //post: S'ha creat una nova Seccio amb nom = nomSeccio
	public int afegirSeccio(String nomSeccio) {
		Seccio novaSeccio = new Seccio(nomSeccio);
		bD.afegirSeccio(novaSeccio);
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
	public void modificarTematicaSeccio(int IDS, int IDT) {
		Seccio modSeccio = BD.getSeccio(IDS);
		Tematica afTematica = BD.getTematica(IDT);
		modSeccio.afegirTematica(afTematica);
	}
	
	//pre: Existeix una Seccio = esbSeccio
    //post: La Seccio = esbSeccio ha estat eliminada
	public void eliminarSeccio(Seccio esbSeccio) {
		BD.esborrarSeccio(esbSeccio);
	}
	
	//pre: No existeix una Tematica, tal que el seu nom sigui nomTematica
    //post: S'ha creat una nova Tematica amb nom = nomTematica
	public int afegirTematica(String nomTematica) {
		Tematica novaTematica = new Tematica(nomTematica);
		BD.afegirTematica(novaTematica);
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
	public void afegirLlibreTematica(int IDT, int IDL) {
		Tematica modTematica = BD.getTematica(IDT);
		modTematica.esborrarLlibre(IDL);
	}
	
	//pre: Existeix una Tematica = esbTematica
    //post: La Tematica = esbTematica ha estat eliminada
	public void eliminarTematica(Tematica esbTematica) {
		BD.esborrarTematica(esbTematica);
	}
	
	//pre: Existeix una Tematica tal que Tematica = tPrincipal i no existeix un Llibre, tal que isbn = isbn, titol = titol, autor = autor, editorial = editorial, any = any i edicio = edicio
    //post: S'ha creat una nou Llibre amb isbn = isbn, titol = titol, autor = autor, editorial = editorial, any = any i edicio = edicio
	public int afegirLlibre(String isbn, String titol, String autor, String editorial, int any, int edicio, Tematica tPrincipal) {
		Llibre nouLlibre = new Llibre(isbn, titol, autor, editorial, any, edicio, tPrincipal);
		BD.afegirLlibre(nouLlibre);
		return nouLlibre.getID();
	}
	
	//pre: Existeix un Llibre tal que el seu Identificador = IDL i una Tematica tal que el seu identificador es IDT i no esta continguda en les Tematiques Secundaries del Llibre
	//post: El Llibre amb identificador IDL conte en les seves Tematiques Secundaries la Tematica amb identificador IDT
	public void afegirTSecundaria(int IDL, int IDT) {
		Llibre modLlibre = BD.getLlibre(IDL);
		Tematica afTematica = BD.getTematica(IDT);
		modLlibre.afegirTematicaSecundaria(afTematica);
	}
	
	//pre: Existeix un Llibre tal que el seu Identificador = IDL i una Tematica tal que el seu identificador es IDT i esta continguda en les Tematiques Secundaries del Llibre
	//post: El Llibre amb identificador IDL no conte en les seves Tematiques Secundaries la Tematica amb identificador IDT
	public void esborrarTSecundaria(int IDL, int IDT) {
		Llibre modLlibre = BD.getLlibre(IDL);
		Tematica esbTematica = BD.getTematica(IDT);
		modLlibre.eliminarTematicaSecundaria(esbTematica);
	}
	
	//pre: Existeix un Llibre tal que el seu Identificador = ID
    //post: El Llibre amb identificador ID te isbn = modIsbn
	public void modificarIsbnLlibre(int ID, String modIsbn) {
		Llibre modLlibre = BD.getLlibre(ID);
		modLlibre.setIsbn(modIsbn);
	}
	
	//pre: Existeix un Llibre tal que el seu Identificador = ID
    //post: El Llibre amb identificador ID te titol = modTitol
	public void modificarTitolLlibre(int ID, String modTitol) {
		Llibre modLlibre = BD.getLlibre(ID);
		modLlibre.setTitol(modTitol);
	}
	
	//pre: Existeix un Llibre tal que el seu Identificador = ID
    //post: El Llibre amb identificador ID te autor = modAutor
	public void modificarAutorLlibre(int ID, String modAutor) {
		Llibre modLlibre = BD.getLlibre(ID);
		modLlibre.setAutor(modAutor);
	}
	
	//pre: Existeix un Llibre tal que el seu Identificador = ID
    //post: El Llibre amb identificador ID te editorial = modEditorial
	public void modificarEditorialLlibre(int ID, String modEditorial) {
		Llibre modLlibre = BD.getLlibre(ID);
		modLlibre.setEditorial(modEditorial);
	}
	
	//pre: Existeix un Llibre tal que el seu Identificador = ID
    //post: El Llibre amb identificador ID te any = modAny
	public void modificarAnyLlibre(int ID, int modAny) {
		Llibre modLlibre = BD.getLlibre(ID);
		modLlibre.setAny(modAny);
	}
	
	//pre: Existeix un Llibre tal que el seu Identificador = ID
    //post: El Llibre amb identificador ID te edicio = modEdicio
	public void modificarEdicioLlibre(int ID, int modEdicio) {
		Llibre modLlibre = BD.getLlibre(ID);
		modLlibre.setAny(modAny);
	}
	
	//pre: Existeix un Llibre tal que el seu Identificador = ID i existeix una Tematica tal que Tematica = tPrincipalmod
    //post: El Llibre amb identificador ID te temPrincipal = codi identificador de modTPrincipal
	public void modificarTPrincipalLlibre(int ID, Tematica modTPrincipal) {
		Llibre modLlibre = BD.getLlibre(ID);
		modLlibre.setTematicaPrincipal(modTPrincipal);
	}
	
	//pre: Existeix un Llibre = esbLlibre
    //post: El Llibre = esbLlibre ha estat eliminat
	public void eliminarLlibre(Llibre esbLlibre) {
		BD.esborrarLlibre(esbLlibre);
	}
    
	//pre: No existeix una Estanteria, tal que la seva posicio sigui posX = posX i posY = PosY
    //post: S'ha creat una nova Estanteria amb nunmFiles = numFiles, llargada = llargda, posX = posX i posY = posY
	public int afegirEstanteria(int numFiles, int llargada, int posX, int posY) {
		Estanteria novaEstanteria = new Estanteria(numFiles, llargada, posX, posY);
		BD.afegirEstanteria(novaEstanteria),
		return novaEstanteria.getID();
	}
	
	//pre: Existeix una Estanteria tal que el seu Identificador = ID
    //post: La Estanteria amb identificador ID te numFiles = modNumFiles
	public void modificarNumFilesEstanteria(int ID, int modNumFiles) {
		Estanteria modEstanteria = BD.getEstanteria(ID);
		modEstanteria.setNumFiles(modNumFiles);
	}
	
	//pre: Existeix una Estanteria tal que el seu Identificador = ID
    //post: La Estanteria amb identificador ID te llargada = modLlargada
	public void modificarLlargadaEstanteria(int ID, int modLlargada) {
		Estanteria modEstanteria = BD.getEstanteria(ID);
		modEstanteria.setLlargada(modLlargada);
	}
	
	//pre: Existeix una Estanteria tal que el seu Identificador = IDE i un Llibre tal que el seu identificador es IDL i no esta contingut en la Estanteria
    //post: La Estanteria amb identificador IDE conte el Llibre amb identificador IDL 
	public void afegirLlibreEstanteria(int IDE, int IDL) {
		Estanteria modEstanteria = BD.getEstanteria(IDE);
		modEstanteria.afegirLlibre(IDL);
	}
	
	//pre: Existeix una Estanteria tal que el seu Identificador = IDE i un Llibre tal que el seu identificador es IDL i esta contingut en la Estanteria
    //post: La Estanteria amb identificador IDE no conte el Llibre amb identificador IDL 
	public void esborrarLlibreEstanteria(int IDE, int IDL) {
		Estanteria modEstanteria = BD.getEstanteria(IDE);
		modEstanteria.esborrarLlibre(IDL);
	}
	
	//pre: Existeix una Estanteria tal que el seu Identificador = ID
    //post: La Estanteria amb identificador = ID ha estat eliminada
	public void eliminarEstanteria(Estanteria esbEstanteria) {
		BD.esborrarEstanteria(esbEstanteria);
	}
    
    //Consultores
	
	//pre: Existeix una area tal que el seu Identificador = IDA
	//post: Retorna els llibres continguts dins de l'area amb Identitificador IDA
	public ArrayList<Llibre> consultarLlibresArea(int IDA) {
		ArrayList<Llibre> llibresArea;
		ArrayList<Llibre> aux;
		ArrayList<Seccio> sA = BD.seccionsArea(IDA);
		for (int i = 0; i < sA.size(); ++i) {
			aux = consultarLlibresSeccio(sA.get(i).getID());
			for (int j = 0; j < aux.size(); ++j) {
				llibresArea.add(aux.get(j));
			}
		}
		return llibresArea;
	}
	
	//pre: Existeix una area tal que el seu Identificador = IDA
	//post: Retorna les seccions contingudes dins de l'area amb Identitificador IDA
	public ArrayList<Llibre> consultarSeccionsArea(int IDA) {
		ArrayList<Seccio> sA = BD.seccionsArea(IDA);
		return sA;
	}
	
	//pre: Existeix una area tal que el seu Identificador = IDA
	//post: Retorna les tematiques contingudes dins de l'area amb Identitificador IDA
	public ArrayList<Llibre> consultarTematiquesArea(int IDA) {
		ArrayList<Tematica> tA;
		ArrayList<Tematica> aux;
		ArrayList<Seccio> sA = BD.seccionsArea(IDA);
		for (int i = 0; i < sA.size(); ++i) {
			aux = BD.tematiquesSeccio(sA.get(i).getID());
			for (int j = 0; j < aux.size(); ++j) {
				tA.add(aux.get(j));
			}
		}
		return tA;
	}
	
	//pre: Existeix una seccio tal que el seu Identificador = IDS
	//post: Retorna els llibres contingut dins de la seccio amb Identitificador IDS
	public ArrayList<Llibre> consultarLlibresSeccio(int IDS) {
		ArrayList<Llibre> llibresSeccio;
		ArrayList<Llibre> aux;
		ArrayList<Tematica> tS = BD.tematiquesSeccio(IDS);
		for (int i = 0; i < tS.size(); ++i) {
			aux = BD.llibresTematica(tS.get(i));
			for (int j = 0; j < aux.size(); ++j) {
				llibresSeccio.add(aux.get(j));
			}
		}
		return llibresSeccio;
	}
	
	//pre: Existeix una seccio tal que el seu Identificador = IDS
	//post: Retorna les tematiques contingudes dins de la seccio amb Identitificador IDS
	public ArrayList<Tematica> consultarTematiquesSeccio(int IDS) {
		ArrayList<Tematica> tS = BD.tematiquesSeccio(IDS);
		return tS;
	}
	
	//pre: Existeix una tematica tal que el seu Identificador = IDT
	//post: Retorna els llibres continguts dins de la tematica amb Identitificador IDT
	public ArrayList<Llibre> consultarLlibresTematica(int IDT) {
		Tematica consTematica = BD.getTematica(IDT);
		return BD.llibresTematica(consTematica);
	}
	
	//pre: Existeix una Estanteria tal que el seu Identificador = IDE
	//post: Retorna els llibres continguts dins de la estanteria amb Identitificador IDE
	public ArrayList<Llibre> consultarLlibresEstanteria(int IDE) {
		Estanteria consEstanteria = BD.getEstanteria(IDE);
		return consEstanteria.getLlibres();
	}
	
}