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
	public static void afegirSeccioArea(int IDA, int IDS) {
		Area modArea = GestioArea.getArea(IDA);
		Seccio afSeccio = GestioArea.getSeccio(IDS);
		modArea.afegirSeccio(afSeccio);
	}
        
        public static void eliminarSeccioArea(int IDA, int IDS) {
		Area modArea = GestioArea.getArea(IDA);
		modArea.esborrarSeccio(IDS);
	}
	
	//pre: Existeix una Area = esbArea
	//post: L'Area = esbArea ha estat eliminada
	public static void eliminarArea(int IDA) {
		GestioArea.esborrarAreaID(IDA);
	}
	
	public static int seleccionaAreaN(String nomA) {
		Area areaN = GestioArea.getAreaN(nomA);
                return areaN.getID();
	}
        
        public static ArrayList<ArrayList<String> > consultaSeccionsArea(int IDA) {
                ArrayList<String> sec = new ArrayList<String>();
                ArrayList<ArrayList<String> > secA = new ArrayList<ArrayList<String> >();
                ArrayList<Seccio> sA = GestioArea.getSeccionsArea(IDA);
                for (int i = 0; i < sA.size(); ++i) {
                    Seccio s = sA.get(i);
                    Area a = GestioArea.getArea(s.getIDAreaSeccio());
                    sec.add(s.getNomSeccio());
                    sec.add(a.getNomArea());
                    secA.add(sec);
                }
                return secA;
        }
        
        //pre: Existeix una area tal que el seu Identificador = IDA
	//post: Retorna les tematiques contingudes dins de l'area amb Identitificador IDA	
	public static ArrayList<ArrayList<String> > consultarTematiquesArea(int IDA) {
		ArrayList<ArrayList<String> > tA = new ArrayList<ArrayList<String> >();
		ArrayList<ArrayList<String> > aux = new ArrayList<ArrayList<String> >();
                Area consArea = GestioArea.getArea(IDA);
		ArrayList<Seccio> sA = consArea.getSeccions();
		for (int i = 0; i < sA.size(); ++i) {
			aux = consultaTematiquesSeccio(sA.get(i).getID());
			for (int j = 0; j < aux.size(); ++j) {
				tA.add(aux.get(j));
			}
		}
		return tA;
	}
        
        //pre: Existeix una area tal que el seu Identificador = IDA
	//post: Retorna els llibres continguts dins de l'area amb Identitificador IDA		
	public static ArrayList<ArrayList<String> > consultarLlibresArea(int IDA) {
		ArrayList<ArrayList<String> > llibresArea = new ArrayList<ArrayList<String> >();
		ArrayList<ArrayList<String> > aux = new ArrayList<ArrayList<String> >();
                Area consArea = GestioArea.getArea(IDA);
		ArrayList<Seccio> sA = consArea.getSeccions();
		for (int i = 0; i < sA.size(); ++i) {
			aux = consultarLlibresSeccio(sA.get(i).getID());
			for (int j = 0; j < aux.size(); ++j) {
				llibresArea.add(aux.get(j));
			}
		}
		return llibresArea;
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
	public static void afegirTematicaSeccio(int IDS, int IDT) {
		Seccio modSeccio = GestioArea.getSeccio(IDS);
		Tematica afTematica = GestioArea.getTematica(IDT);
		modSeccio.afegirTematica(afTematica);
	}
        
        public static void esborrarTematicaSeccio(int IDS, int IDT) {
		Seccio modSeccio = GestioArea.getSeccio(IDS);
		modSeccio.esborrarTematica(IDT);
	}
	
	//pre: Existeix una Seccio = esbSeccio
	//post: La Seccio = esbSeccio ha estat eliminada
	public static void eliminarSeccio(int IDS) {
		GestioArea.esborrarSeccioID(IDS);
	}
	
	public static int seleccionaSeccioN(String nomS) {
                Seccio seccioN = GestioArea.getSeccioN(nomS);
		return seccioN.getID();
	}
        
        public static ArrayList<ArrayList<String> > consultaTematiquesSeccio(int IDS) {
                ArrayList<String> tem = new ArrayList<String>();
                ArrayList<ArrayList<String> > temS = new ArrayList<ArrayList<String> >();
                ArrayList<Tematica> tS = GestioArea.getTematiquesSeccio(IDS);
                for (int i = 0; i < tS.size(); ++i) {
                    Tematica t = tS.get(i);
                    Seccio s = GestioArea.getSeccio(t.getIDSeccioTematica());
                    tem.add(t.getNomTematica());
                    tem.add(s.getNomSeccio());
                    temS.add(tem);
                }
                return temS;
        }
        
        //pre: Existeix una seccio tal que el seu Identificador = IDS
	//post: Retorna els llibres contingut dins de la seccio amb Identitificador IDS
	public static ArrayList<ArrayList<String> > consultarLlibresSeccio(int IDS) {
		ArrayList<ArrayList<String> > llibresSeccio = new ArrayList<ArrayList<String> >();
                ArrayList<ArrayList<String> > aux = new ArrayList<ArrayList<String> >();
                Seccio consSeccio = GestioArea.getSeccio(IDS);
		ArrayList<Tematica> tS = consSeccio.getTematiques();
		for (int i = 0; i < tS.size(); ++i) {
			aux = consultaLlibresTematica(tS.get(i).getID());
			for (int j = 0; j < aux.size(); ++j) {
				llibresSeccio.add(aux.get(j));
			}
		}
		return llibresSeccio;
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
	public static void eliminarTematica(int IDT) {
		GestioArea.esborrarTematicaID(IDT);
	}
	
	public static Tematica seleccionaTematicaN(String nomT) {
		return GestioArea.getTematicaN(nomT);
	}
	
	public static ArrayList<ArrayList<String> > consultaLlibresTematica(int IDT) {
                ArrayList<String> lli = new ArrayList<String>();
                ArrayList<ArrayList<String> > lliT = new ArrayList<ArrayList<String> >();
                ArrayList<Llibre> lT = GestioArea.getLlibresTematica(IDT);
                for (int i = 0; i < lT.size(); ++i) {
                    Llibre l = lT.get(i);
                    Tematica t = GestioArea.getTematica(l.getTemPrincipal());
                    lli.add(l.getIsbn());
                    lli.add(l.getTitol());
                    lli.add(l.getAutor());
                    lli.add(l.getEditorial());
                    lli.add(Integer.toString(l.getAny()));
                    lli.add(Integer.toString(l.getEdicio()));
                    lli.add(t.getNomTematica());
                    lliT.add(lli);
                }
                return lliT;
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
		modLlibre.eliminarTematicaSecundaria(IDT);
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
	public static void modificarTPrincipalLlibre(int IDL, int IDT) {
		Llibre modLlibre = GestioLlibre.getLlibre(IDL);
		modLlibre.setTemPrincipal(IDT);
	}
        
        public static int seleccionaLlibre(String titol, String autor, int any) {
		Llibre llibre = GestioLlibre.getLlibreTAA(titol,autor,any);
                return llibre.getID();
	}
	
	//pre: Existeix un Llibre = esbLlibre
	//post: El Llibre = esbLlibre ha estat eliminat
	public static void eliminarLlibre(int IDL) {
		GestioLlibre.esborrarLlibreID(IDL);
	}
	
	public static ArrayList<ArrayList<String> > seleccionaLlibreT(String titol) {
		ArrayList<Llibre> llTitol = GestioLlibre.getLlibreTitol(titol);
                ArrayList<String> lli = new ArrayList<String>();
                ArrayList<ArrayList<String> > lliT = new ArrayList<ArrayList<String> >();
                for (int i = 0; i < llTitol.size(); ++i) {
                    Llibre l = llTitol.get(i);
                    Tematica t = GestioArea.getTematica(l.getTemPrincipal());
                    lli.add(l.getIsbn());
                    lli.add(l.getTitol());
                    lli.add(l.getAutor());
                    lli.add(l.getEditorial());
                    lli.add(Integer.toString(l.getAny()));
                    lli.add(Integer.toString(l.getEdicio()));
                    lli.add(t.getNomTematica());
                    lliT.add(lli);
                }
                return lliT;
	}
	
	public static ArrayList<ArrayList<String> > consultaLlibrePerISBN(String isbn){
		ArrayList<Llibre> llIsbn = GestioLlibre.getLlibreISBN(isbn);
                ArrayList<String> lli = new ArrayList<String>();
                ArrayList<ArrayList<String> > lliI = new ArrayList<ArrayList<String> >();
                for (int i = 0; i < llIsbn.size(); ++i) {
                    Llibre l = llIsbn.get(i);
                    Tematica t = GestioArea.getTematica(l.getTemPrincipal());
                    lli.add(l.getIsbn());
                    lli.add(l.getTitol());
                    lli.add(l.getAutor());
                    lli.add(l.getEditorial());
                    lli.add(Integer.toString(l.getAny()));
                    lli.add(Integer.toString(l.getEdicio()));
                    lli.add(t.getNomTematica());
                    lliI.add(lli);
                }
                return lliI;
	}
	
	public static ArrayList<ArrayList<String> > consultaLlibresAutor(String autor) {
		ArrayList<Llibre> llAutor = GestioLlibre.getLlibresAutor(autor);
                ArrayList<String> lli = new ArrayList<String>();
                ArrayList<ArrayList<String> > lliA = new ArrayList<ArrayList<String> >();
                for (int i = 0; i < llAutor.size(); ++i) {
                    Llibre l = llAutor.get(i);
                    Tematica t = GestioArea.getTematica(l.getTemPrincipal());
                    lli.add(l.getIsbn());
                    lli.add(l.getTitol());
                    lli.add(l.getAutor());
                    lli.add(l.getEditorial());
                    lli.add(Integer.toString(l.getAny()));
                    lli.add(Integer.toString(l.getEdicio()));
                    lli.add(t.getNomTematica());
                    lliA.add(lli);
                }
                return lliA;
	}
	
	public static ArrayList<ArrayList<String> > consultaLlibresAny(int any) {
		ArrayList<Llibre> llAny = GestioLlibre.getLlibresAny(any);
                ArrayList<String> lli = new ArrayList<String>();
                ArrayList<ArrayList<String> > lliA = new ArrayList<ArrayList<String> >();
                for (int i = 0; i < llAny.size(); ++i) {
                    Llibre l = llAny.get(i);
                    Tematica t = GestioArea.getTematica(l.getTemPrincipal());
                    lli.add(l.getIsbn());
                    lli.add(l.getTitol());
                    lli.add(l.getAutor());
                    lli.add(l.getEditorial());
                    lli.add(Integer.toString(l.getAny()));
                    lli.add(Integer.toString(l.getEdicio()));
                    lli.add(t.getNomTematica());
                    lliA.add(lli);
                }
                return lliA;
	}
	
	public static ArrayList<ArrayList<String> > consultaLlibresEditorial(String editorial) {
		ArrayList<Llibre> llEd = GestioLlibre.getLlibresEditorial(editorial);
                ArrayList<String> lli = new ArrayList<String>();
                ArrayList<ArrayList<String> > lliE = new ArrayList<ArrayList<String> >();
                for (int i = 0; i < llEd.size(); ++i) {
                    Llibre l = llEd.get(i);
                    Tematica t = GestioArea.getTematica(l.getTemPrincipal());
                    lli.add(l.getIsbn());
                    lli.add(l.getTitol());
                    lli.add(l.getAutor());
                    lli.add(l.getEditorial());
                    lli.add(Integer.toString(l.getAny()));
                    lli.add(Integer.toString(l.getEdicio()));
                    lli.add(t.getNomTematica());
                    lliE.add(lli);
                }
                return lliE;
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
	
	public static int seleccionaEstanteria(int posX, int posY) {
		Estanteria estanteriaC = GestioEstanteria.getEstanteriaCoord(posX, posY);
                return estanteriaC.getID();
	}
        
        //pre: Existeix una Estanteria tal que el seu Identificador = IDE
	//post: Retorna els llibres continguts dins de la estanteria amb Identitificador IDE
	public static ArrayList<ArrayList<String> > consultarLlibresEstanteria(int IDE) {
		Estanteria consEstanteria = GestioEstanteria.getEstanteria(IDE);
		ArrayList<Llibre> lliE = consEstanteria.getLlibres();
                ArrayList<String> lli = new ArrayList<String>();
                ArrayList<ArrayList<String> > lliEst = new ArrayList<ArrayList<String> >();
                for (int i = 0; i < lliE.size(); ++i) {
                    Llibre l = lliE.get(i);
                    Tematica t = GestioArea.getTematica(l.getTemPrincipal());
                    lli.add(l.getIsbn());
                    lli.add(l.getTitol());
                    lli.add(l.getAutor());
                    lli.add(l.getEditorial());
                    lli.add(Integer.toString(l.getAny()));
                    lli.add(Integer.toString(l.getEdicio()));
                    lli.add(t.getNomTematica());
                    lliEst.add(lli);
                }
                return lliEst;
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
}
