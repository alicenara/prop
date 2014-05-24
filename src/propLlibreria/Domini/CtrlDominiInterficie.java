package propLlibreria.Domini;
import compartit.*;
import java.util.*;

public class CtrlDominiInterficie {
    
	//Inicialització del programa
	//pre:
	//post: s'inicialitza la classe amb tots els vectors
	public static void iniBD() {
		CtrlDominiPersistencia.omplirBD();
	}
	
	//Abans d'acabar el programa
	//pre:
	//post: es desen les dades dels vectors
	public static void guardarSolucio() {
		CtrlDominiPersistencia.desarBD();
	}
	
	//Utilitzaci� de les classes compartides	
	//pre:
	//post: Llibres classificats segons l'afinitat entre ells i el nombre d'estanteries disponibles a la Biblioteca
	public static void reordenacioBiblioteca() throws Exception {
		ArrayList<Llibre> a = GestioLlibre.getAllLlibres();
		ArrayList<Estanteria> e = GestioEstanteria.getAllEstanteries();
		ArrayList<Lloc> b = new ArrayList<Lloc>(); 
		ArrayList<Integer> llocsEstanteries = new ArrayList<Integer>();
		for(int i = 0; i < e.size(); ++i) 
			for(int j = 0; j < e.get(i).getLlargada(); ++j) 
				for(int k = 0; k < e.get(i).getNumFiles(); ++k) {
					b.add(new Lloc(e.get(i).getPosX()+j,e.get(i).getPosY(),k*10));
					llocsEstanteries.add(e.get(i).getID());
				}
		if(a.size() != b.size()) {
			if(a.size()  > b.size() ) {
				System.out.println("Masses llibres per tants pocs llocs!");
				return;
			}
			while(a.size() != b.size()) {
				b.remove(b.size()-1);
			}
		}
		Llibre[] llibres = new Llibre[a.size()];
		Lloc[] llocs = new Lloc[b.size()];
		llibres = a.toArray(llibres);
		llocs = b.toArray(llocs);
		
		CalcularAfinitatsBiblio calcAfin = new CalcularAfinitatsBiblio();
		CalcularDistancies calcDist = new CalcularDistancies();
		TS solver = new TS(calcAfin, calcDist);
		Solucio solucio = new Solucio(solver, llibres, llocs);
		ArrayList<Estanteria> all = GestioEstanteria.getAllEstanteries();
		for(int i = 0; i < all.size(); ++i)
			all.get(i).buidarLlibres();
		for(int i = 0; i < llocsEstanteries.size(); ++i) {
			Estanteria est = GestioEstanteria.getEstanteria(llocsEstanteries.get(i));
			est.afegirLlibre(solucio.assignacions[i]);
		}
	}	
	
	//GESTIO AREA
	
	//pre: No existeix una Area, tal que el seu nom sigui nomArea
	//post: S'ha creat una nova Area amb nom = nomArea
	public static int afegirArea(String nomArea) {
		Area novaArea = new Area(nomArea);
		return novaArea.getID();
	}
	
	//pre: Existeix una Area tal que el seu Identificador = ID
	//post: L'Area amb identificador ID te nom nomA
	public static void modificarNomArea(int ID, String nomA) {
		Area modArea = GestioArea.getArea(ID);
		modArea.setNomArea(nomA);
	}
	
	//pre: Existeix una Area tal que el seu Identificador = IDA i una Seccio tal que el seu identificador es IDS i no esta continguda en l'Area
	//post: L'Area amb identificador IDA conte la Seccio amb identificador IDS 
	public static void modificarSeccioArea(int IDA, int IDS) {
		Area modArea = GestioArea.getArea(IDA);
		Seccio afSeccio = GestioArea.getSeccio(IDS);
		modArea.afegirSeccio(afSeccio);
	}
	
	//pre: Existeix una Area = esbArea
	//post: L'Area = esbArea ha estat eliminada
	public static void eliminarArea(Area esbArea) {
		GestioArea.esborrarArea(esbArea);
	}
	
	public static Area seleccionaAreaN(String nomA) {
		return GestioArea.getAreaN(nomA);
	}
	
	// GESTIO SECCIO
	
	//pre: No existeix una Seccio, tal que el seu nom sigui nomSeccio
	//post: S'ha creat una nova Seccio amb nom = nomSeccio
	public static int afegirSeccio(String nomSeccio, int IDArea) {
		Seccio novaSeccio = new Seccio(nomSeccio, IDArea);
		return novaSeccio.getID();
	}
	
	//pre: Existeix una Seccio tal que el seu Identificador = ID
	//post: La Seccio amb identificador ID te nom nomS
	public static void modificarNomSeccio(int ID, String nomS) {
		Seccio modSeccio = GestioArea.getSeccio(ID);
		modSeccio.setNomSeccio(nomS);
	}
	
	//pre: Existeix una Seccio tal que el seu Identificador = IDS i una Tematica tal que el seu identificador es IDT i no esta continguda en la Seccio
	//post: La Seccio amb identificador IDS conte la Tematica amb identificador IDT 
	public static void modificarTematicaSeccio(int IDS, int IDT) {
		Seccio modSeccio = GestioArea.getSeccio(IDS);
		Tematica afTematica = GestioArea.getTematica(IDT);
		modSeccio.afegirTematica(afTematica);
	}
	
	//pre: Existeix una Seccio = esbSeccio
	//post: La Seccio = esbSeccio ha estat eliminada
	public static void eliminarSeccio(Seccio esbSeccio) {
		GestioArea.esborrarSeccio(esbSeccio);
	}
	
	public static Seccio seleccionaSeccioN(String nomS) {
		return GestioArea.getSeccioN(nomS);
	}
	
	public static Seccio seleccionaSeccioID(int IDS) {
		return GestioArea.getSeccio(IDS);
	}
	
	//GESTIO TEMATICA
	
	//pre: No existeix una Tematica, tal que el seu nom sigui nomTematica
	//post: S'ha creat una nova Tematica amb nom = nomTematica
	public static int afegirTematica(String nomTematica, int IDSeccio) {
		Tematica novaTematica = new Tematica(nomTematica, IDSeccio);
		return novaTematica.getID();
	}
	
	//pre: Existeix una Tematica tal que el seu Identificador = ID
	//post: La Tematica amb identificador ID te nom nomT
	public static void modificarNomTematica(int ID, String nomT) {
		Tematica modTematica = GestioArea.getTematica(ID);
		modTematica.setNomTematica(nomT);
	}
	
	//pre: Existeix una Tematica tal que el seu Identificador = IDT i un Llibre tal que el seu identificador es IDL i no esta contingut en la Tematica
	//post: La Tematica amb identificador IDT conte el Llibre amb identificador IDL 
	public static void afegirLlibreTematica(int IDT, int IDL) {
		Tematica modTematica = GestioArea.getTematica(IDT);
		Llibre afLlibre = GestioLlibre.getLlibre(IDL);
		modTematica.afegirLlibre(afLlibre);
	}
	
	//pre: Existeix una Tematica tal que el seu Identificador = IDT i un Llibre tal que el seu identificador es IDL i esta contingut en la Tematica
	//post: La Tematica amb identificador IDT no conte el Llibre amb identificador IDL 
	public static void eliminarLlibreTematica(int IDT, int IDL) {
		Tematica modTematica = GestioArea.getTematica(IDT);
		modTematica.esborrarLlibre(IDL);
	}
	
	//pre: Existeix una Tematica = esbTematica
	//post: La Tematica = esbTematica ha estat eliminada
	public static void eliminarTematica(Tematica esbTematica) {
		GestioArea.esborrarTematica(esbTematica);
	}
	
	public static Tematica seleccionaTematicaN(String nomT) {
		return GestioArea.getTematicaN(nomT);
	}
	
	public static Tematica seleccionaTematicaID(int IDT) {
		return GestioArea.getTematica(IDT);
	}
	
	// GESTIO LLIBRE
	
	//pre: Existeix una Tematica tal que Tematica = tPrincipal i no existeix un Llibre, tal que isbn = isbn, titol = titol, autor = autor, editorial = editorial, any = any i edicio = edicio
	//post: S'ha creat una nou Llibre amb isbn = isbn, titol = titol, autor = autor, editorial = editorial, any = any i edicio = edicio
	public static int afegirLlibre(String isbn, String titol, String autor, String editorial, int any, int edicio, Tematica tPrincipal) {
		Llibre nouLlibre = new Llibre(isbn, titol, autor, editorial, any, edicio, tPrincipal);
		afegirLlibreTematica(tPrincipal.getID(),nouLlibre.getID());
		return nouLlibre.getID();
	}
	
	//pre: Existeix un Llibre tal que el seu Identificador = IDL i una Tematica tal que el seu identificador es IDT i no esta continguda en les Tematiques Secundaries del Llibre
	//post: El Llibre amb identificador IDL conte en les seves Tematiques Secundaries la Tematica amb identificador IDT
	public static void afegirTSecundaria(int IDL, int IDT) {
		Llibre modLlibre = GestioLlibre.getLlibre(IDL);
		Tematica afTematica = GestioArea.getTematica(IDT);
		modLlibre.afegirTematicaSecundaria(afTematica);
	}
	
	//pre: Existeix un Llibre tal que el seu Identificador = IDL i una Tematica tal que el seu identificador es IDT i esta continguda en les Tematiques Secundaries del Llibre
	//post: El Llibre amb identificador IDL no conte en les seves Tematiques Secundaries la Tematica amb identificador IDT
	public static void esborrarTSecundaria(int IDL, int IDT) {
		Llibre modLlibre = GestioLlibre.getLlibre(IDL);
		Tematica esbTematica = GestioArea.getTematica(IDT);
		modLlibre.eliminarTematicaSecundaria(esbTematica);
	}
	
	//pre: Existeix un Llibre tal que el seu Identificador = ID
	//post: El Llibre amb identificador ID te isbn = modIsbn
	public static void modificarIsbnLlibre(int ID, String modIsbn) {
		Llibre modLlibre = GestioLlibre.getLlibre(ID);
		modLlibre.setIsbn(modIsbn);
	}
	
	//pre: Existeix un Llibre tal que el seu Identificador = ID
	//post: El Llibre amb identificador ID te titol = modTitol
	public static void modificarTitolLlibre(int ID, String modTitol) {
		Llibre modLlibre = GestioLlibre.getLlibre(ID);
		modLlibre.setTitol(modTitol);
	}
	
	//pre: Existeix un Llibre tal que el seu Identificador = ID
	//post: El Llibre amb identificador ID te autor = modAutor
	public static void modificarAutorLlibre(int ID, String modAutor) {
		Llibre modLlibre = GestioLlibre.getLlibre(ID);
		modLlibre.setAutor(modAutor);
	}
	
	//pre: Existeix un Llibre tal que el seu Identificador = ID
	//post: El Llibre amb identificador ID te editorial = modEditorial
	public static void modificarEditorialLlibre(int ID, String modEditorial) {
		Llibre modLlibre = GestioLlibre.getLlibre(ID);
		modLlibre.setEditorial(modEditorial);
	}
	
	//pre: Existeix un Llibre tal que el seu Identificador = ID
	//post: El Llibre amb identificador ID te any = modAny
	public static void modificarAnyLlibre(int ID, int modAny) {
		Llibre modLlibre = GestioLlibre.getLlibre(ID);
		modLlibre.setAny(modAny);
	}
	
	//pre: Existeix un Llibre tal que el seu Identificador = ID
	//post: El Llibre amb identificador ID te edicio = modEdicio
	public static void modificarEdicioLlibre(int ID, int modEdicio) {
		Llibre modLlibre = GestioLlibre.getLlibre(ID);
		modLlibre.setEdicio(modEdicio);
	}
	
	//pre: Existeix un Llibre tal que el seu Identificador = ID i existeix una Tematica tal que Tematica = tPrincipalmod
	//post: El Llibre amb identificador ID te temPrincipal = codi identificador de modTPrincipal
	public static void modificarTPrincipalLlibre(int ID, Tematica modTPrincipal) {
		Llibre modLlibre = GestioLlibre.getLlibre(ID);
		modLlibre.setTemPrincipal(modTPrincipal.getID());
	}
	
	//pre: Existeix un Llibre = esbLlibre
	//post: El Llibre = esbLlibre ha estat eliminat
	public static void eliminarLlibre(Llibre esbLlibre) {
		GestioLlibre.esborrarLlibre(esbLlibre);
	}
	
	public static Llibre seleccionaLlibreT(String titol) {
		return GestioLlibre.getLlibreTitol(titol);
	}
	
	public static Llibre consultaLlibrePerISBN(String isbn){
		return GestioLlibre.getLlibreISBN(isbn);
	}
	
	public static ArrayList<Llibre> consultaLlibresAutor(String autor) {
		return GestioLlibre.getLlibresAutor(autor);
	}
	
	public static ArrayList<Llibre> consultaLlibresAny(int any) {
		return GestioLlibre.getLlibresAny(any);
	}
	
	public static ArrayList<Llibre> consultaLlibresEditorial(String editorial) {
		return GestioLlibre.getLlibresEditorial(editorial);
	}
	
	// GESTIO ESTANTERIA
	
	//pre: No existeix una Estanteria, tal que la seva posicio sigui posX = posX i posY = PosY
	//post: S'ha creat una nova Estanteria amb nunmFiles = numFiles, llargada = llargda, posX = posX i posY = posY
	public static int afegirEstanteria(int numFiles, int llargada, int posX, int posY) {
		Estanteria novaEstanteria = new Estanteria(numFiles, llargada, posX, posY);
		return novaEstanteria.getID();
	}
	
	//pre: Existeix una Estanteria tal que el seu Identificador = ID
	//post: La Estanteria amb identificador ID te numFiles = modNumFiles
	public static void modificarNumFilesEstanteria(int ID, int modNumFiles) {
		Estanteria modEstanteria = GestioEstanteria.getEstanteria(ID);
		modEstanteria.setNumFiles(modNumFiles);
	}
	
	//pre: Existeix una Estanteria tal que el seu Identificador = ID
	//post: La Estanteria amb identificador ID te llargada = modLlargada
	public static void modificarLlargadaEstanteria(int ID, int modLlargada) {
		Estanteria modEstanteria = GestioEstanteria.getEstanteria(ID);
		modEstanteria.setLlargada(modLlargada);
	}
	
	public static void modificarCoordenadesEstanteria(int ID, int modX, int modY) {
		Estanteria modEstanteria = GestioEstanteria.getEstanteria(ID);
		modEstanteria.setPosX(modX);
		modEstanteria.setPosX(modY);
	}
	
	//pre: Existeix una Estanteria tal que el seu Identificador = IDE
	//post: La Estanteria amb identificador = ID ha estat eliminada
	public static void eliminarEstanteria(int IDE) {
		GestioEstanteria.esborrarEstanteriaID(IDE);
	}
	
	public static Estanteria consultaEstanteria(int ID) {
		return GestioEstanteria.getEstanteria(ID);
	}
        
	//Consultores
	
	public static ArrayList<Llibre> seleccionaAllLlibres() {
		return GestioLlibre.getAllLlibres();
	}
	
	public static ArrayList<Estanteria> seleccionaAllEstanteries() {
		return GestioEstanteria.getAllEstanteries();
	}
	
	public static ArrayList<Tematica> seleccionaAllTematiques() {
		return GestioArea.getAllTematiques();
	}
	
	public static ArrayList<Seccio> seleccionaAllSeccions() {
		return GestioArea.getAllSeccions();
	}
	
	public static ArrayList<Area> seleccionaAllArees() {
		return GestioArea.getAllArees();
	}
	
	//pre: Existeix una area tal que el seu Identificador = IDA
	//post: Retorna els llibres continguts dins de l'area amb Identitificador IDA		
	public static ArrayList<Llibre> consultarLlibresArea(int IDA) {
		ArrayList<Llibre> llibresArea = new ArrayList<Llibre>();
		ArrayList<Llibre> aux = new ArrayList<Llibre>();
		ArrayList<Seccio> sA = GestioArea.getArea(IDA).getSeccions();
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
	public static ArrayList<Seccio> consultarSeccionsArea(int IDA) {
		Area consArea = GestioArea.getArea(IDA);
		return consArea.getSeccions();
	}
	
	//pre: Existeix una area tal que el seu Identificador = IDA
	//post: Retorna les tematiques contingudes dins de l'area amb Identitificador IDA	
	public static ArrayList<Tematica> consultarTematiquesArea(int IDA) {
		ArrayList<Tematica> tA = new ArrayList<Tematica>();
		ArrayList<Tematica> aux = new ArrayList<Tematica>();
                Area consArea = GestioArea.getArea(IDA);
		ArrayList<Seccio> sA = consArea.getSeccions();
		for (int i = 0; i < sA.size(); ++i) {
			aux = sA.get(i).getTematiques();
			for (int j = 0; j < aux.size(); ++j) {
				tA.add(aux.get(j));
			}
		}
		return tA;
	}
	
	//pre: Existeix una seccio tal que el seu Identificador = IDS
	//post: Retorna els llibres contingut dins de la seccio amb Identitificador IDS
	public static ArrayList<Llibre> consultarLlibresSeccio(int IDS) {
		ArrayList<Llibre> llibresSeccio = new ArrayList<Llibre>();
                ArrayList<Llibre> aux = new ArrayList<Llibre>();
		ArrayList<Tematica> tS = consultarTematiquesSeccio(IDS);
		for (int i = 0; i < tS.size(); ++i) {
			aux = tS.get(i).getLlibres();
			for (int j = 0; j < aux.size(); ++j) {
				llibresSeccio.add(aux.get(j));
			}
		}
		return llibresSeccio;
	}
	
	//pre: Existeix una seccio tal que el seu Identificador = IDS
	//post: Retorna les tematiques contingudes dins de la seccio amb Identitificador IDS
	public static ArrayList<Tematica> consultarTematiquesSeccio(int IDS) {
		Seccio consSeccio = GestioArea.getSeccio(IDS);
                return consSeccio.getTematiques();
	}
	
	//pre: Existeix una tematica tal que el seu Identificador = IDT
	//post: Retorna els llibres continguts dins de la tematica amb Identitificador IDT
	public static ArrayList<Llibre> consultarLlibresTematica(int IDT) {
		Tematica consTematica = GestioArea.getTematica(IDT);
		return consTematica.getLlibres();
	}
	
	//pre: Existeix una Estanteria tal que el seu Identificador = IDE
	//post: Retorna els llibres continguts dins de la estanteria amb Identitificador IDE
	public static ArrayList<Llibre> consultarLlibresEstanteria(int IDE) {
		Estanteria consEstanteria = GestioEstanteria.getEstanteria(IDE);
		return consEstanteria.getLlibres();
	}
	
	public static boolean existeixArea (int ID){
		return GestioArea.existeixArea(ID);
	}
	
	public static boolean existeixEstanteria(int ID){
		return GestioEstanteria.existeixEstanteria(ID);
	}
	
	public static boolean existeixSeccio(int ID){
		return GestioArea.existeixSeccio(ID);
	}
	
	public static boolean existeixTematica(int ID){
		return GestioArea.existeixTematica(ID);
	}
	
	public static boolean existeixLlibre(int ID){
		return GestioLlibre.existeixLlibre(ID);
	}
	
	public static void esborrarAreaID(int IDA){
		GestioArea.esborrarAreaID(IDA);
	}
	
	public static void esborrarEstanteriaID(int IDE){
		GestioEstanteria.esborrarEstanteriaID(IDE);
	}
	
	
	public static void esborrarLlibreID(int IDL){
		GestioLlibre.esborrarLlibreID(IDL);
	}
	
	
	public static void esborrarSeccioID(int IDS){
		GestioArea.esborrarSeccioID(IDS);
	}

	public static void esborrarTematicaID(int IDT){
		GestioArea.esborrarTematicaID(IDT);
	}

    public static void seleccionaAllEstanteria() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
