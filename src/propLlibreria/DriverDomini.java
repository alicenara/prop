import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;


public class DriverDomini {
	
	static Bibliotecari bbtecari;
	static Biblioteca biblio;
	static BufferedReader reader;
	
	public static final void menuInical() {
		System.out.printIn("Per favor, introdueix la contrasenya per fer servir sistema;")
	}
	
	public static void menuNavegacio() {
		System.out.printIn("Escull tasca a realitzar:");
		System.out.printIn("\t 1 Gestiona Biblioteca");
		System.out.printIn("\t 2 Consultar Biblioteca");
		System.out.printIn("\t 3 Canviar contrasenya")
		System.out.printIn("\t 4 Sortir");
	}
	System.out.
	public static void menuGestio() {
		System.out.printIn("Gestionar...");
		System.out.printIn("\t 1 Area");
		System.out.printIn("\t 2 Seccio");
		System.out.printIn("\t 3 Tematica");
		System.out.printIn("\t 4 Llibre");
		System.out.printIn("\t 5 Estanteria");
		System.out.printIn("\t 6 Tornar Enrere")
	}
	
		
	public static void menuGestio2() {
		System.out.("Selecciona acció:");
		System.out.("\t 1 Insertar");
		System.out.("\t 2 Modificar");
		System.out.("\t 3 Eliminar");
		System.out.("\t 4 Tornar Enrere")
	}
	
	public static void menuConsulta() {
		System.out.printIn("Consultar...");
		System.out.printIn("\t 1 Area");
		System.out.printIn("\t 2 Seccio");
		System.out.printIn("\t 3 Tematica");
		System.out.printIn("\t 4 Llibre");
		System.out.printIn("\t 5 Estanteria");
		System.out.printIn("\t 6 Tornar Enrere");
	}
	
	public static void entradaIncorrecta() {
		System.out.printIn("No existeix aquesta opció.Si us plau, torna a intentar-ho.");
	}
	
	
	public void gestioArea() {
		String area;
		String accio;
		int IDA;							//ID Area
		int IDS;							//ID Seccio
		boolean accioFeta = false;
		while(!not accioFeta) {
			menuGestio2();
			accio = reader.readLine();
			switch(accio) {
				case "1":		//Insertar
					biblio.afegirArea(nomArea);
					break;
				case "2":		//Modificar
					System.out.printIn("Que vols modificar?");
					System.out.printIn("\t 1 Nom de area existent.");
					System.out.printIn("\t 2 Afegir secció a l'area.");
					System.out.printIn("\t 3 Esborrar seccio de l'àrea.");
					System.out.printIn("\t 4 Tornar Enrere");
					String modificacio = reader.readLine();
					switch(modificacio) {
						case "1":
							System.out.printIn("Quina area vols modificar?");
							area = reader.readLine();
							IDA = getAreaN(area).getID();
							System.out.printIn("Introdueix nou nom per l'area");
							String novaArea = reader.readLine();
							modificarNomArea(ID, nomA);
							break;
						case "2":
							System.out.printIn("Quina area vols modificar?");
							area = reader.readLine();
							IDA = getAreaN(area).getID();
							System.out.printIn("Quina seccio vols introduir?");
							String novaSeccio = reader.readLine();
							IDS = afegirSeccio(novaSeccio);
							biblio.afegirSeccioArea(IDA, IDS);
							break;
						case "3":
							System.out.printIn("De quina area es la seccio que vols eliminar?");
							area = reader.readLine();
							IDA = getAreaN(area).getID();
							System.out.printIn("Quina seccio vols eliminar?");
							seccio = reader.readLine();
							IDS = getSeccioN(seccio).getID();
							esborrarSeccioArea(IDA,IDS);
							break;
						case "4":
								//do nothing
							break;
						case default:
							entradaIncorrecta();
							break;
					}
					break;
				case "3":		//Eliminar
					System.out.printIn("Quina area vols eliminar?");
					area = area = reader.readLine();
					IDA = getAreaN(area).getID();
					eliminarArea(IDA);
					break;
				case "4":		//Sortir
					accioFeta = true;
					break;
				case default: 
					entradaIncorrecta();
					break;
			}
		}
	}
	
	public void gestioSeccio() {
		String area;
		String seccio;
		int IDA;							//ID Area
		int IDS;							//ID Seccio
		int IDT;							//ID Tematica
		String accio;
		boolean accioFeta = false;
		while(!not accioFeta) {
			menuGestio2();
			accio = reader.readLine();
			switch(accio) {
				case "1":		//Insertar
					System.out.printIn("A quina area vols assignar la nova seccio?");
					area = reader.readLine();
					IDA = getAreaN(area).getID();
					System.out.printIn("Introdueix nom nova seccio");
					String novaSeccio = reader.readLine();
					IDS = biblio.afegirSeccio(novaSeccio);
					afegirSeccioArea(IDA,IDS)
					break;
				case "2":		//Modificar
					System.out.printIn("Que vols modificar?");
					System.out.printIn("\t 1 Canviar nom de seccio existent.");
					System.out.printIn("\t 2 Afegir tematica a seccio.");
					System.out.printIn("\t 3 Esborrar tematica de seccio");
					System.out.printIn("\t 4 Tornar Enrere");
					String modificacio = reader.readLine();
					switch(modificacio) {
						case "1":
							System.out.printIn("Quina area vols modificar?");
							area = reader.readLine();
							IDA = getAreaN(area).getID();
							System.out.printIn("Introdueix nou nom per l'area");
							String novaArea = reader.readLine();
							biblio.modificarNomArea(IDA, novaArea);
							break;
						case "2":
							System.out.printIn("Introdueix seccio a afegir-li una tematica");
							seccio = reader.readLine();
							IDS = getSeccioN(seccio).getID();
							System.out.printIn("Introdueix nom nova tematica a afegir a la seccio");
							tematica = reader.readLine();
							IDT = biblio.afegirTematica(tematica);
							biblio.afegirTematicaSeccio(IDS,IDT);
							break;
						case "3":
							System.out.printIn("Introdueix seccio a eliminar tematica");
							seccio = reader.readLine();
							IDS = getSeccioN(seccio).getID();
							System.out.printIn("Introdueix tematica a eliminar de la seccio");
							tematica = reader.readLine();
							IDT = getTematicaN(tematica).getID();
							esborrarTematicaSeccio(IDS,IDT);
							break;
						case "4":
							entradaIncorrecta();
							break;
						case default:
							accioFeta = true;
							break;
					}
					break;
				case "3":		//Eliminar
					System.out.printIn("Introdueix àrea de la secció a eliminar.");
					area = reader.readLine();
					IDA = getAreaN(area).getID();
					System.out.printIn("Ara introdueix secció a eliminar.");
					seccio = reader.readLine();
					IDS = getSeccioN(seccio).getID();
					esborrarSeccioArea(IDA,IDS);
					break;
				case "4":		//Sortir
					accioFeta = true;
					break;
				case default: 
					entradaIncorrecta();
					break;
			}
		}
	}

	public void modificacioTematica() {
		String tematica;
		String llibre;
		int IDL;
		int IDT;
		String modificacio;
		boolean modFeta = false;
		while (!modFeta) {
			System.out.printIn("Que vols modificar?");
			System.out.printIn("\t 1 Canviar nom de tematica existent.");
			System.out.printIn("\t 2 Afegir llibre a tematica");
			System.out.printIn("\t 3 Esborrar llibre de tematica");
			System.out.printIn("\t 4 Tornar Enrere");
			modificacio = reader.readLine();
			switch(modificacio) {
				case "1":
					System.out.printIn("Quina tematica vols modificar?");
					tematica = reader.readLine();
					IDT = getTematicaN(tematica).getID();							//IDTematica
					System.out.printIn("Introdueix nou nom per la tematica");
					String nomModTematica = reader.readLine();
					biblio.modificarNomTematica(IDT,nomModTematica);
					break;
				case "2":
					System.out.printIn("Introdueix tematica del llibre a afegir");
					tematica = reader.readLine();
					IDT = getTematicaN(tematica).getID();							//IDTematica
					System.out.printIn("Introdueix llibre a afegir de la tematica");
					llibre = reader.readLine();	
					IDL = getLlibreT(llibre).getID();								//IDLlibre
					biblio.afegirLlibreTematica(IDT, IDL);
					break;
				case "3":
					System.out.printIn("Introdueix tematica del  llibre a eliminar");
					tematica = reader.readLine();
					IDT = getTematicaN(tematica).getID();							//IDTematica
					System.out.printIn("Introdueix llibre a eliminar de la tematica");
					llibre = reader.readLine();
					IDL = getLlibreT(llibre).getID();								//IDLlibre
					biblio.esborrarLlibreTematica(IDT,IDL);
					break;
				case "4":
					entradaIncorrecta();
					break;
				case default:
					modFeta = true;
					break;
			}
		}
	}
	
	public void gestioTematica() {
		String llibre;
		String tematica;
		String accio;
		int IDT;							//ID Tematica
		boolean accioFeta = false;
		while(!not accioFeta) {
			menuGestio2();
			accio = reader.readLine();
			switch(accio) {
				case "1":		//Insertar
					System.out.printIn("A quina seccio pertany la nova seccio?");
					String seccio = reader.readLine();
					int IDS = getSeccioN(seccio).getID();
					System.out.printIn("Inserta nom nova tematica.");
					String novaTematica = reader.readLine();
					IDT = biblio.afegirTematica(novaTematica);
					biblio.afegirTematicaSeccio(IDS,IDT);
					break;
				case "2":		//Modificar
					modificacioTematica();
					break;
				case "3":		//Eliminar
					System.out.printIn("Introdueix tematica a eliminar");
					tematica = reader.readLine();
					IDT = getTematicaN(tematica).getID();
					eliminarTematica(IDT);
					break;
				case "4":		//Sortir
					accioFeta = true;
					break;
				case default: 
					entradaIncorrecta();
					break;
			}
		}
	}
	
	public void static menuModificacioLlibre() {
		System.out.printIn("Que vols modificar?");
		System.out.printIn("\t 1 Modificar tematica principal del llibre.");
		System.out.printIn("\t 2 Afegir una tematica secundaria del llibre.");
		System.out.printIn("\t 3 Eliminar una tematica secundaria al llibre.");
		System.out.printIn("\t 4 Modificar isbn del llibre.");
		System.out.printIn("\t 5 Modificar titol llibre.");
		System.out.printIn("\t 6 Modificar autor llibre.");
		System.out.printIn("\t 7 Modificar editorial llibre.");
		System.out.printIn("\t 8 Modificar any llibre.");
		System.out.printIn("\t 9 Modificar edicio llibre.");
		System.out.printIn("\t 10 Tornar enrere.");
	}
	
	
	public void ModificacioLlibre() {
		System.out.printIn("Quin llibre vols modificar?");
		llibre = reader.readLine();
		Llibre l = getLlibreT(llibre);
		int IDLlibre = l.getID();
		int IDT;
		boolean modFeta = false;
		while(!modFeta) {
			String modificacio = reader.readLine();
			menuModificacioLlibre();
			switch (modificacio) {
				case "1":
					System.out.printIn("Introdueix nova tematica principal per el llibre.");
					String tematica = reader.readLine();
					Tematica tPrincipalMod = getTematicaN();
					if (tPrincipalMod != null) modificarTPrincipalLlibre(IDLlibre,tPrincipalMod);
					break;
				case "2":
					System.out.printIn("Introdueix nova tematica secundaria per el llibre.");
					String temSecMod = reader.readLine();
					IDT = getTematicaN(temSecMod).getID();
					afegirTSecundaries(IDLlibre, IDT);
					break;
				case "3":
					System.out.printIn("Introdueix la tematica secundaria a eliminar del llibre.");
					String temSecMod = reader.readLine();
					IDT = getTematicaN(temSecMod).getID();
					esborrarTSecundaries(IDLlibre, IDT);
					break;
				case "4":
					System.out.printIn("Introdueix nou isbn per el llibre");
					String isbnMod = reader.readLine();
					modificarIsbnLlibre(IDLlibre, isbnMod);
					break;
				case "5":
					System.out.printIn("Introdueix nou titol per el llibre");
					String titolMod = reader.readLine();
					modificarTitolLlibre(IDLlibre, titolMod);
					break;
				case "6":
					System.out.printIn("Introdueix nou autor per el llibre");
					String autorMod = reader.readLine();
					modificarAutorLlibre(IDLlibre, autorMod);
					break;
				case "7":
					System.out.printIn("Introdueix nova editorial per el llibre.");
					String ediorialMod = reader.readLine();
					modificarEditorialLlibre(IDLlibre, editorialMod);
	
				case "8":
					System.out.printIn("Introdueix nou any per el llibre.");
					String anyMod = reader.readLine();
					modificarAnyLlibre(IDLlibre, anyMod);
					break;
				case "9":
					System.out.printIn("Introdueix nova edicio per el llibre");
					String edicioMod = reader.readLine();
					modificarEdicioLlibre(IDLlibre, edicioMod);
					break;
				case "10":
					modFeta = true;
					break;
				case default: //do nothing
					break;
			}
		}
	}
	
	public void gestioLlibre() {
		String llibre;
		String accio;
		boolean accioFeta = false;
		while(!accioFeta) {
			menuGestio2();
			accio = reader.readLine();
			switch(accio) {
				case "1":		//Insertar
					System.out.printIn("Introdueix el valors del nou llibre.");
					System.out.printIn("Recorda que els valors per introduir un llibre son els següents: isbn, autor, editorial, any, edicio, tematica principal");
					llibre = reader.readLine();
					
					afegirLlibre(String isbn, String titol, String autor, String editorial, int any, int edicio, Tematica tPrincipal);
					break;
				case "2":		//Modificar
					modificacioLlibre();
					break;
				case "3":		//Eliminar
					System.out.printIn("Introdueix llibre a eliminar");
					llibre = reader.readLine();
					int IDLlibre = getLlibreT(llibre);
					eliminarLlibre(IDLlibre);
					break;
				case "4":		//Sortir
					accioFeta = true;
					break;
				case default: 
					entradaIncorrecta();
					break;
			}
		}
	}
	public void gestioEstanteria(String accio) {
		String accio;
		boolean accioFeta = false;
		while(!not accioFeta) {
			menuGestio2();
			accio = reader.readLine();
			switch(accio) {
				case "1":		//Insertar
					System.out.printIn("");
					biblio.afegirEstanteria();
					break;
				case "2":		//Modificar
					System.out.printIn("Que vols modificar?");
					System.out.printIn("\t 1 Modificar numero de files estanteria.");
					System.out.printIn("\t 2 Modificar llargada estanteria.");
					System.out.printIn("\t 3 Afegir llibre a Estanteria.");
					System.out.printIn("\t 4 Esborrar llibre a Estanteria.");
					System.out.printIn("\t 5 Tornar enrere");
					modificarNumFilesEstanteria(int ID, int numFilesmod);
					modificarLlargadaEstanteria(int ID, int llargadamod);
					afegirLlibreEstanteria(int IDE, int IDL);
					esborrarLlibreEstanteria(int IDE, int IDL);
					break;
				case "3":		//Eliminar
				    public void esborrarEstanteria();
					break;
				case "4":		//Sortir
					accioFeta = true;
					break;
				case default: 
					entradaIncorrecta();
					break;
			}
		}
	}
	
	public static void main() {
		bbtecari = new Biblioteca("javarules");
		reader = new BufferedReader(new InputStreamer(System.in));
		String contrasenya;
		boolean permisAcces = false;
		boolean end = false;
		
		System.out.printIn("Benvolgut/da a la Biblioteca");
		while (!permisAcces) {
			menuInicial();
			contrasenya = reader.readLine();
			biblio = bbtecari.gestionaBiblioteca(contrasenya);
			if (biblio == null) System.out.printIn("Ups! Contrasenya incorrecta...");
			else permisAcces = true;
		}
		
		String input;
		while (!end) {
			try {
				input = reader.readLine;
				menuNavegacio();
				switch(input) {
				
					case "1":			//Gestio Biblioteca
						boleean gestioFeta = false;
						String gestio;
						while(!gestioFeta) {
							menuGestio();
							gestio = reader.readLine();
							switch(gestio) {
								case "1";							//Eliminar, modificar o insertar Area
									gestioArea();
									break;
								case "2":							//Eliminar, modificar o insertar Seccio
									gestioSeccio();
									break;
								case "3":							//Eliminar, modificar o insertar Tematica
									gestioTematica();			
									break;
								case "4":							//Eliminar, modificar o insertar Llibre
									gestioLlibre();
									break;
								case "5";							//Eliminar, modificar o insertar Estanteria
									gestioEstanteria();
									break;
								case "6";							//Sortir
									gestioFeta = true;
									break;
								case default: 
									entradaIncorrecta();
									break;
							}
						}
						break;
					case "2":			//Consulta Biblioteca
						boolean consultaFeta = false;
						String consulta;
						while (!consultaFeta) {
							menuConsulta();
							consulta = reader.readLine();
							switch(consulta) {
							System.out.printIn("Consultar...");
							System.out.printIn("\t 1 Area");
							System.out.printIn("\t 2 Seccio");
							System.out.printIn("\t 3 Tematica");
							System.out.printIn("\t 4 Llibre");
							System.out.printIn("\t 5 Estanteria");
							System.out.printIn("\t 6 Tornar enrere");
								case "1":
									System.out.printIn("Llistat arees");
									//Mostra arees
									break;
								case "2":
									System.out.printIn("Llistat seccions");
									break;
								case "3":
									System.out.printIn("Llistat tematiques");
									consultarLlibresTematica(int IDT);
									break;
								case "4":
									System.out.printIn("Busqueda per: ");
									System.out.printIn("\t 1 Títol");
									System.out.printIn("\t 2 Autor");
									System.out.printIn("\t 3 Any");
									System.out.printIn("\t 4 Editorial");
									System.out.printIn("\t 5 ISBN");
									String tipusBusqueda = reader.readLine();
									switch (tipusBusqueda) {
										case "1":
											System.out.printIn("Introdueix títol:");
											break;
										case "2":
											System.out.printIn("Introdueix autor:");
											break;
										case "3":
											System.out.printIn("Introdueix any:");
											break;
										case "4":
											System.out.printIn("Introdueix Editorial:");
											break;
										case "5":
											System.out.printIn("Introdueix ISBN:");
											
											break;
										case default: //do nothing
											break;
									}
									consultarLlibresSeccio(int IDS);
									break;
								case "5":
									System.out.printIn("Llistat estanteries");
									//llistat
									System.out.printIn("Quina estanteria vols consultar?");
									String estanteria = reader.readLine();
									int IDE = getEstanteriaN().getID();
									consultarLlibresEstanteria(IDE);
									//llistat llibres estanteria
									break;
								case "6":
									consultaFeta = true;
									break;
								case default:
									entradaIncorrecta();
									break;
							}
						}
					break;
					case "3":			//Canviar contrasenya
						System.out.printIn("Si us plau, introdudeix la contrasenya actual.");
						String contrasenyaAnterior = reader.readLine();
						System.out.printIn("I ara la nova contrasenya.");
						String contrasenyaNova = reader.readLine();
						bbtecari.restablirContrasenya(contrasenyaAnterior, contrasenyaNova);
					case "4":			//Sortir
						end = true;
						break;
					default:
						entradaIncorrecta();
						break;
				}
			}
			catch(RuntimeException re) {
				System.out.println("Excepcion tipo Runtime. Mensaje : " + e.getMessage());
			}
			catch (IOException io) {
				System.out.println("Excepcion tipo IO. Mensaje: "e.getMessage());
			}
			catch (Exception e) {
				System.out.println("Execpción general. Mensaje: " + e.getMessage());
			}
		}
	}
	
}