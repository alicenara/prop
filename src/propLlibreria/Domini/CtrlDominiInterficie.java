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
	public static void reordenacioBiblioteca(boolean heuristic) throws Exception {
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
                                throw new Exception("massesLlibres");
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
		SolucionadorQAP solver;
                if(heuristic) solver = new TS(calcAfin, calcDist);
                else solver = new BB(calcAfin, calcDist);
                try {
                    Solucio solucio = new Solucio(solver, llibres, llocs);
                    ArrayList<Estanteria> all = GestioEstanteria.getAllEstanteries();
                    for(int i = 0; i < all.size(); ++i)
                            all.get(i).buidarLlibres();
                    for(int i = 0; i < llocsEstanteries.size(); ++i) {
                            Estanteria est = GestioEstanteria.getEstanteria(llocsEstanteries.get(i));
                            est.afegirLlibre(solucio.assignacions[i]);
                    }
                }
                catch(Exception exc) {
                    throw new Exception("errorAlgoritme");
                }
	}	
	
	//GESTIO AREA
	
	//pre: No existeix una Area, tal que el seu nom sigui nomArea
	//post: S'ha creat una nova Area amb nom = nomArea
	public static void afegirArea(String nomArea) {
		Area novaArea = new Area(nomArea);
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
	
	//pre: Existeix una Area = esbArea
	//post: L'Area = esbArea ha estat eliminada
	public static void esborrarArea(int IDA) {
		ArrayList<Seccio> sA = GestioArea.getSeccionsArea(IDA);
                for (int i = 0; i < sA.size(); ++i) {
                    esborrarSeccioArea(IDA,sA.get(i).getID());
                }
                GestioArea.esborrarAreaID(IDA);
	}
	
	public static int seleccionaAreaN(String nomA) throws Exception{
		Area areaN = GestioArea.getAreaN(nomA);
                if (areaN == null) throw new Exception("noExisteixArea");
                else return areaN.getID();
	}
        
        private static void esborrarSeccioArea(int IDA, int IDS) {
                Area modArea = GestioArea.getArea(IDA);
                esborrarTematiquesSeccio(IDS);
                modArea.esborrarSeccio(IDS);
	}
        
        public static boolean conteAreaSeccio(int IDA, int IDS) {
                Seccio seccio = GestioArea.getSeccio(IDS);
                ArrayList<Seccio> sA = GestioArea.getSeccionsArea(IDA);
                boolean trobat = false;
                for (int i = 0; i < sA.size() && !trobat; ++i) {
                    if (sA.get(i) == seccio) trobat = true;
                }
                return trobat;
        }
        
        public static ArrayList<ArrayList<String> > consultarSeccionsArea(int IDA) {
                ArrayList<ArrayList<String> > secA = new ArrayList<ArrayList<String> >();
                ArrayList<Seccio> sA = GestioArea.getSeccionsArea(IDA);
                for (int i = 0; i < sA.size(); ++i) {
                    ArrayList<String> sec = new ArrayList<String>();
                    Seccio s = sA.get(i);
                    Area a = GestioArea.getArea(s.getIDAreaSeccio());
                    sec.add(s.getNomSeccio());
                    sec.add(a.getNomArea());
                    secA.add(sec);
                    sec.clear();
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
			aux = consultarTematiquesSeccio(sA.get(i).getID());
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
	public static void afegirSeccio(String nomSeccio, int IDArea) {
		Seccio novaSeccio = new Seccio(nomSeccio, IDArea);
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
        
        private static void esborrarTematicaSeccio(int IDS, int IDT) {
		Seccio modSeccio = GestioArea.getSeccio(IDS);
		esborrarLlibresTematica(IDT);
                modSeccio.esborrarTematica(IDT);
	}
        
        private static void esborrarTematiquesSeccio(int IDS) {
                Seccio modSeccio = GestioArea.getSeccio(IDS);
                ArrayList<Tematica> tS = modSeccio.getTematiques();
                for (int i = 0; i < tS.size(); ++i) {
                    esborrarTematicaSeccio(IDS,tS.get(i).getID());
                }
        }
	
	public static void esborrarSeccio(int IDS) {
		Seccio s = GestioArea.getSeccio(IDS);
                Area modArea = GestioArea.getArea(s.getIDAreaSeccio());
                esborrarTematiquesSeccio(IDS);
                modArea.esborrarSeccio(IDS);
	}
	
	public static int seleccionaSeccioN(String nomS) throws Exception{
                Seccio seccioN = GestioArea.getSeccioN(nomS);
		if (seccioN == null) throw new Exception("noExisteixSeccio");
                else return seccioN.getID();
	}
        
        public static boolean conteSeccioTematica(int IDS, int IDT) {
                Tematica tematica = GestioArea.getTematica(IDT);
                ArrayList<Tematica> tS = GestioArea.getTematiquesSeccio(IDS);
                boolean trobat = false;
                for (int i = 0; i < tS.size() && !trobat; ++i) {
                    if (tS.get(i) == tematica) trobat = true;
                }
                return trobat;
        }
        
        public static ArrayList<ArrayList<String> > consultarTematiquesSeccio(int IDS) {
                ArrayList<ArrayList<String> > temS = new ArrayList<ArrayList<String> >();
                ArrayList<Tematica> tS = GestioArea.getTematiquesSeccio(IDS);
                for (int i = 0; i < tS.size(); ++i) {
                    ArrayList<String> tem = new ArrayList<String>();
                    Tematica t = tS.get(i);
                    Seccio s = GestioArea.getSeccio(t.getIDSeccioTematica());
                    Area a = GestioArea.getArea(s.getIDAreaSeccio());
                    tem.add(t.getNomTematica());
                    tem.add(s.getNomSeccio());
                    tem.add(a.getNomArea());
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
			aux = consultarLlibresTematica(tS.get(i).getID());
			for (int j = 0; j < aux.size(); ++j) {
				llibresSeccio.add(aux.get(j));
			}
		}
		return llibresSeccio;
	}
        
	
	//GESTIO TEMATICA
	
	//pre: No existeix una Tematica, tal que el seu nom sigui nomTematica
	//post: S'ha creat una nova Tematica amb nom = nomTematica
	public static void afegirTematica(String nomTematica, int IDSeccio) {
		Tematica novaTematica = new Tematica(nomTematica, IDSeccio);
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
	private static void esborrarLlibreTematica(int IDT, int IDL) {
		Tematica modTematica = GestioArea.getTematica(IDT);
		modTematica.esborrarLlibre(IDL);
	}
        
        private static void esborrarLlibresTematica(int IDT) {
                Tematica modTematica = GestioArea.getTematica(IDT);
                ArrayList<Llibre> llT = modTematica.getLlibres();
                for (int i = 0; i < llT.size(); ++i) {
                    modTematica.esborrarLlibre(llT.get(i).getID());
                }
        }
	
	//pre: Existeix una Tematica = esbTematica
	//post: La Tematica = esbTematica ha estat eliminada
	public static void esborrarTematica(int IDT) {
		Tematica t = GestioArea.getTematica(IDT);
                esborrarTematicaSeccio(t.getIDSeccioTematica(),IDT);
	}
	
	public static int seleccionaTematicaN(String nomT) throws Exception{
		Tematica tematicaN = GestioArea.getTematicaN(nomT);
                if (tematicaN == null) throw new Exception("noExisteixTematica");
                else return tematicaN.getID();
	}
        
        public static boolean conteTematicaLlibre(int IDT, int IDL) {
                Llibre llibre = GestioLlibre.getLlibre(IDL);
                ArrayList<Llibre> lT = GestioArea.getLlibresTematica(IDT);
                boolean trobat = false;
                for (int i = 0; i < lT.size() && !trobat; ++i) {
                    if (lT.get(i) == llibre) trobat = true;
                }
                return trobat;
        }
	
	public static ArrayList<ArrayList<String> > consultarLlibresTematica(int IDT) {
                ArrayList<ArrayList<String> > lliT = new ArrayList<ArrayList<String> >();
                ArrayList<Llibre> lT = GestioArea.getLlibresTematica(IDT);
                for (int i = 0; i < lT.size(); ++i) {
                    ArrayList<String> lli = new ArrayList<String>();
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
	public static void afegirLlibre(String isbn, String titol, String autor, String editorial, int any, int edicio, int IDTp) {
		Llibre nouLlibre = new Llibre(isbn, titol, autor, editorial, any, edicio, IDTp);
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
        
        public static int seleccionaLlibre(String titol, String autor, int any) throws Exception{
		Llibre llibre = GestioLlibre.getLlibreTAA(titol,autor,any);
                if (llibre == null) throw new Exception("noExisteixLlibre");
                else return llibre.getID();
	}
        
        public static boolean conteLlibreTS(int IDL, int IDTs) {
                Tematica t = GestioArea.getTematica(IDTs);
                ArrayList<Tematica> tL = GestioLlibre.getTematiquesSecundaries(IDL);
                boolean trobat = false;
                for (int i = 0; i < sA.size() && !trobat; ++i) {
                    if (sA.get(i) == seccio) trobat = true;
                }
                return trobat;
        }
	
	//pre: Existeix un Llibre = esbLlibre
	//post: El Llibre = esbLlibre ha estat eliminat
	public static void esborrarLlibre(int IDL) {
		Llibre l = GestioLlibre.getLlibre(IDL);
                esborrarLlibreTematica(l.getTemPrincipal(),IDL);
	}
	
	public static ArrayList<ArrayList<String> > consultaLlibresTitol(String titol) {
		ArrayList<Llibre> llTitol = GestioLlibre.getLlibreTitol(titol);
                ArrayList<ArrayList<String> > lliT = new ArrayList<ArrayList<String> >();
                for (int i = 0; i < llTitol.size(); ++i) {
                    ArrayList<String> lli = new ArrayList<String>();
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
	
	public static ArrayList<ArrayList<String> > consultaLlibresPerISBN(String isbn){
		ArrayList<Llibre> llIsbn = GestioLlibre.getLlibreISBN(isbn);
                ArrayList<ArrayList<String> > lliI = new ArrayList<ArrayList<String> >();
                for (int i = 0; i < llIsbn.size(); ++i) {
                    ArrayList<String> lli = new ArrayList<String>();
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
                ArrayList<ArrayList<String> > lliA = new ArrayList<ArrayList<String> >();
                for (int i = 0; i < llAutor.size(); ++i) {
                    ArrayList<String> lli = new ArrayList<String>();
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
                ArrayList<ArrayList<String> > lliA = new ArrayList<ArrayList<String> >();
                for (int i = 0; i < llAny.size(); ++i) {
                    ArrayList<String> lli = new ArrayList<String>();
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
                ArrayList<ArrayList<String> > lliE = new ArrayList<ArrayList<String> >();
                for (int i = 0; i < llEd.size(); ++i) {
                    ArrayList<String> lli = new ArrayList<String>();
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
	public static void afegirEstanteria(int numFiles, int llargada, int posX, int posY) {
		Estanteria novaEstanteria = new Estanteria(numFiles, llargada, posX, posY);
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
	public static void esborrarEstanteria(int IDE) {
		GestioEstanteria.esborrarEstanteriaID(IDE);
	}
	
	public static int seleccionaEstanteria(int posX, int posY) throws Exception{
		Estanteria estanteriaC = GestioEstanteria.getEstanteriaCoord(posX, posY);
                if (estanteriaC == null) throw new Exception("noExisteixEstanteria");
                else return estanteriaC.getID();
	}
        
        //pre: Existeix una Estanteria tal que el seu Identificador = IDE
	//post: Retorna els llibres continguts dins de la estanteria amb Identitificador IDE
	public static ArrayList<ArrayList<String> > consultarLlibresEstanteria(int IDE) {
		Estanteria consEstanteria = GestioEstanteria.getEstanteria(IDE);
		ArrayList<Llibre> lliE = consEstanteria.getLlibres();
                ArrayList<ArrayList<String> > lliEst = new ArrayList<ArrayList<String> >();
                for (int i = 0; i < lliE.size(); ++i) {
                    ArrayList<String> lli = new ArrayList<String>();
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
	
	public static ArrayList<ArrayList<String> > seleccionaAllLlibres() {
		ArrayList<ArrayList<String> > allLlibres = new ArrayList<ArrayList<String> >();
                ArrayList<Llibre> llibres = GestioLlibre.getAllLlibres();
                for (int i = 0; i < llibres.size(); ++i) {
                    ArrayList<String> lli = new ArrayList<String>();
                    Llibre l = llibres.get(i);
                    Tematica t = GestioArea.getTematica(l.getTemPrincipal());
                    lli.add(l.getIsbn());
                    lli.add(l.getTitol());
                    lli.add(l.getAutor());
                    lli.add(l.getEditorial());
                    lli.add(Integer.toString(l.getAny()));
                    lli.add(Integer.toString(l.getEdicio()));
                    lli.add(t.getNomTematica());
                    allLlibres.add(lli);
                }
                return allLlibres;
	}
	
	public static ArrayList<ArrayList<String> > seleccionaAllEstanteries() {
		ArrayList<ArrayList<String> > allEstanteries = new ArrayList<ArrayList<String> >();
                ArrayList<Estanteria> estanteries = GestioEstanteria.getAllEstanteries();
                for (int i = 0; i < estanteries.size(); ++i) {
                    ArrayList<String> est = new ArrayList<String>();
                    Estanteria e = estanteries.get(i);
                    est.add(Integer.toString(e.getPosX()));
                    est.add(Integer.toString(e.getPosY()));
                    est.add(Integer.toString(e.getNumFiles()));
                    est.add(Integer.toString(e.getLlargada()));
                    allEstanteries.add(est);
                }
                return allEstanteries;
	}
	
	public static ArrayList<ArrayList<String> > seleccionaAllTematiques() {
                ArrayList<ArrayList<String> > allTematiques = new ArrayList<ArrayList<String> >();
                ArrayList<Tematica> tematiques = GestioArea.getAllTematiques();
                for (int i = 0; i < tematiques.size(); ++i) {
                    ArrayList<String> tem = new ArrayList<String>();
                    Tematica t = tematiques.get(i);
                    Seccio s = GestioArea.getSeccio(t.getIDSeccioTematica());
                    Area a = GestioArea.getArea(s.getIDAreaSeccio());
                    tem.add(t.getNomTematica());
                    tem.add(s.getNomSeccio());
                    tem.add(a.getNomArea());
                    allTematiques.add(tem);
                }
                return allTematiques;
	}
	
	public static ArrayList<ArrayList<String> > seleccionaAllSeccions() {
		ArrayList<ArrayList<String> > allSeccions = new ArrayList<ArrayList<String> >();
                ArrayList<Seccio> seccions = GestioArea.getAllSeccions();
                for (int i = 0; i < seccions.size(); ++i) {
                    ArrayList<String> sec = new ArrayList<String>();
                    Seccio s = seccions.get(i);
                    Area a = GestioArea.getArea(s.getIDAreaSeccio());
                    sec.add(s.getNomSeccio());
                    sec.add(a.getNomArea());
                    allSeccions.add(sec);
                }
                return allSeccions;
	}
	
	public static ArrayList<ArrayList<String> > seleccionaAllArees() {
		ArrayList<ArrayList<String> > allArees = new ArrayList<ArrayList<String> >();
                ArrayList<Area> arees = GestioArea.getAllArees();
                for (int i = 0; i < arees.size(); ++i) {
                    ArrayList<String> area = new ArrayList<String>();
                    Area a = arees.get(i);
                    area.add(a.getNomArea());
                    allArees.add(area);
                }
                return allArees;
	} 
	
	public static boolean existeixArea (String nomA){
		return GestioArea.existeixArea(nomA);
	}
	
	public static boolean existeixEstanteria(int x, int y){
		return GestioEstanteria.existeixEstanteria(x,y);
	}
	
	public static boolean existeixSeccio(String nomS){
		return GestioArea.existeixSeccio(nomS);
	}
	
	public static boolean existeixTematica(String nomT){
		return GestioArea.existeixTematica(nomT);
	}
	
	public static boolean existeixLlibre(String titol, String autor, int any){
		return GestioLlibre.existeixLlibre(titol,autor,any);
	}
}
