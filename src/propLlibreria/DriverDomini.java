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
							//check ID area
							area = reader.readLine();
							System.out.printIn("Introdueix nou nom per l'area");
							String novaArea = reader.readLine();
							modificarNomArea(ID, nomA);
							break;
						case "2":
							System.out.printIn("Quina area vols modificar?");
							area = reader.readLine();
							System.out.printIn("Quina seccio vols introduir?");
							String novaSeccio = reader.readLine();
							//GET IDs
							afegirSeccioArea(int IDA, int IDS);
							break;
						case "3":
							System.out.printIn("Quina seccio vols eliminar?");
							esborrarSeccioArea(int IDA, int IDS);
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
					//GET ID area
					eliminarArea(int ID);
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
		menuGestio2();
		String area;
		String seccio;
		String accio;
		boolean accioFeta = false;
		while(!not accioFeta) {
			menuGestio2();
			accio = reader.readLine();
			switch(accio) {
				case "1":		//Insertar
					System.out.printIn("A quina area vols assignar la nova seccio?");
					area = reader.readLine();
					System.out.printIn("Introdueix nom nova seccio");
					String novaSeccio = reader.readLine();
					biblio.afegirSeccio(String nomSeccio);
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
							//check ID area
							area = reader.readLine();
							System.out.printIn("Introdueix nou nom per l'area");
							String novaArea = reader.readLine();
							modificarNomArea(ID, nomA);
							break;
						case "2":
							System.out.printIn("Introdueix seccio a afegir-li una tematica");
							seccio = reader.readLine();
							System.out.printIn("Introdueix nom nova tematica a afegir a la seccio");
							tematica = reader.readLine();
							//GET IDs
							biblio.afegirTematicaSeccio(int IDS, int IDT);
							break;
						case "3":
							System.out.printIn("Introdueix seccio a eliminar tematica");
							seccio = reader.readLine();
							System.out.printIn("Introdueix tematica a eliminar de la seccio");
							tematica = reader.readLine();
							//GET IDs
							esborrarTematicaSeccio(int IDS, int IDT);
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
					System.out.printIn("Ara introdueix secció a eliminar.");
					seccio = reader.readLine();
					//GET IDs
					esborrarSeccioArea(int IDA, int IDS);
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
	
	public void gestioTematica() {
		String llibre;
		String tematica;
		String accio;
		boolean accioFeta = false;
		while(!not accioFeta) {
			menuGestio2();
			accio = reader.readLine();
			switch(accio) {
				case "1":		//Insertar
					System.out.printIn("A quina seccio pertany la nova seccio?");
					String seccio = reader.readLine();
					System.out.printIn("Inserta nom nova tematica.");
					String novaTematica = reader.readLine();
					//GET IDs
					biblio.afegirTematicaSeccio(int IDS, int IDT);
					break;
				case "2":		//Modificar
					System.out.printIn("Que vols modificar?");
					System.out.printIn("\t 1 Canviar nom de tematica existent.");
					System.out.printIn("\t 2 Afegir llibre a tematica");
					System.out.printIn("\t 3 Esborrar llibre de tematica");
					System.out.printIn("\t 4 Tornar Enrere");
					String modificacio = reader.readLine();
					switch(modificacio) {
						case "1":
							System.out.printIn("Quina tematica vols modificar?");
							//check ID area
							tematica = reader.readLine();
							System.out.printIn("Introdueix nou nom per la tematica");
							String novaTematica = reader.readLine();
							biblio.modificarNomTematica(int ID, String nomT);
							break;
						case "2":
							System.out.printIn("Introdueix tematica del llibre a afegir");
							tematica = reader.readLine();
							System.out.printIn("Introdueix llibre a afegir de la tematica");
							llibre = reader.readLine();
							//GET IDs
							biblio.afegirLlibreTematica(int IDT, int IDL);
							break;
						case "3":
							System.out.printIn("Introdueix tematica del  llibre a eliminar");
							tematica = reader.readLine();
							System.out.printIn("Introdueix llibre a eliminar de la tematica");
							llibre = reader.readLine();
							//GET IDs
							biblio.esborrarLlibreTematica(int IDT, int IDL);
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
					System.out.printIn("Introdueix tematica a eliminar");
					tematica = reader.readLine();
					//GET ID
					eliminarTematica(int ID);
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
	
	public void ModificacioLlibre(String llibre) {
		System.out.printIn("Que vols modificar?");
		System.out.printIn("\t 1 Modificar tematica principal del llibre.");
		System.out.printIn("\t 2 Afegir una tematica secundaria del llibre.");
		System.out.printIn("\t 3 Modificar isbn del llibre.");
		System.out.printIn("\t 4 Modificar titol llibre.");
		System.out.printIn("\t 5 Modificar autor llibre.");
		System.out.printIn("\t 6 Modificar editorial llibre.");
		System.out.printIn("\t 7 Modificar any llibre");
		System.out.printIn("\t 8 Modificar autor llibre");
		System.out.printIn("\t 9 Modificar edicio llibre");
		System.out.printIn("\t 10 Modificar tematica principal de un llibre.");
		System.out.printIn("\t 11 Afegir una tematica secundaria a un llibre.");
		System.out.printIn("\t 12 Eliminar una tematica secundaria a un llibre.");
		String modificacio = reader.readLine();
		switch (modificacio) {
			case "1":
				break;
			case "2":
				break;
			case "3":
				break;
			case "4":
				break;
			case "5":
				break;
			case "6":
				break;
			case "7":
				break;
			case "8":
				break;
			case "9":
				break;
			case "10":
				break;
			case "11":
				break;
				
				
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
					System.out.printIn("Quin llibre vols modificar?");
					llibre = reader.readLine();
					modificacioLlibre();
					
					afegirTSecundaries(int IDL, int IDT);
					modificarIsbnLlibre(int ID, String isbnmod);
					modificarTitolLlibre(int ID, String titolmod);
					modificarAutorLlibre(int ID, String autormod);
					modificarEditorialLlibre(int ID, String editorialmod);
					modificarAnyLlibre(int ID, int anymod);
					modificarAutorLlibre(int ID, String autormod);
					modificarEditorialLlibre(int ID, String editorialmod);
					modificarAnyLlibre(int ID, int anymod);
					modificarEdicioLlibre(int ID, int ediciomod);
					modificarTPrincipalLlibre(int ID, Tematica tPrincipalmod);
					eliminarLlibre(int ID);
					break;
				case "3":		//Eliminar
					System.out.printIn("Introdueix llibre a eliminar");
					llibre = reader.readLine();
					//GET ID
					eliminarLlibre(ID);
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
					System.out.printIn("\t 5 Tornar Enrere");
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
							String accio;
							switch(gestio) {
								case "1";
									menuGestio2();
									accio = reader.readLine();		//Eliminar, modificar o insertar Area
									gestioArea(accio);
									break;
								case "2":							//Eliminar, modificar o insertar Seccio
									menuGestio2();
									accio = reader.readLine();
									gestioSeccio(accio);
									break;
								case "3":							//Eliminar, modificar o insertar Tematica
									menuGestio2();
									accio = reader.readLine();
									gestioTematica(accio);			
									break;
								case "4":							//Eliminar, modificar o insertar Llibre
									menuGestio2();
									accio = reader.readLine();
									gestioLlibre(accio);
									break;
								case "5";							//Eliminar, modificar o insertar Estanteria
									
									gestioEstanteria(accio);
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
							System.out.printIn("\t 6 Tornar Enrere");
								case "1":
									
									break;
								case "2":
									
									break;
								case "3":
									
									break;
								case "4":
									
									break;
								case "5":
									
									break;
								case "6":
									
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