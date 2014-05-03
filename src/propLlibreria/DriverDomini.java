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
		menuGestio2();
		String accio = reader.readLine();
		boolean accioFeta = false;
		String area;
		while(!not accioFeta) {
			switch(accio) {
				case "1":		//Insertar
					biblio.afegirArea(nomArea);
					break;
				case "2":		//Modificar
					System.out.printIn("Que vols modificar?");
					System.out.printIn("\t 1 Nom de l'àrea.");
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
							entradaIncorrecta();
							break;
						case default:
							accioFeta = true;
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
	
	public void gestioSeccio(String accio) {
		menuGestio2();
		String accio = reader.readLine();
		boolean accioFeta = false;
		while(!not accioFeta) {
			switch(accio) {
				case "1":		//Insertar
					System.out.printIn("A quina area vols assignar la nova seccio?");
					String area = reader.readLine();
					System.out.printIn("Introdueix nom nova seccio");
					String novaSeccio = reader.readLine();
					biblio.afegirSeccio(String nomSeccio);
					break;
				case "2":		//Modificar
					System.out.printIn("Que vols modificar?");
					System.out.printIn("\t 1 Nom de l'àrea.");
					System.out.printIn("\t 2 Afegir secció a l'area.");
					System.out.printIn("\t 3 Esborrar seccio de l'àrea.");
					System.out.printIn("\t 4 Tornar Enrere");
					modificarNomSeccio(int ID, String nomS);
					afegirTematicaSeccio(int IDS, int IDT);
					esborrarTematicaSeccio(int IDS, int IDT);
					break;
				case "3":		//Eliminar
					eliminarSeccio(int ID);
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
	
	public void gestioTematica(String accio) {
		menuGestio2();
		String accio = reader.readLine();
		boolean accioFeta = false;
		while(!not accioFeta) {
			switch(accio) {
				case "1":		//Insertar
					afegirTematica(String nomTematica);
					break;
				case "2":		//Modificar
					System.out.printIn("Que vols modificar?");
					System.out.printIn("\t 1 Nom de l'àrea.");
					System.out.printIn("\t 2 Afegir secció a l'area.");
					System.out.printIn("\t 3 Esborrar seccio de l'àrea.");
					System.out.printIn("\t 4 Tornar Enrere");
					modificarNomTematica(int ID, String nomT);
					afegirLlibreTematica(int IDT, int IDL);
					esborrarLlibreTematica(int IDT, int IDL);
					break;
				case "3":		//Eliminar
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
	public void gestioLlibre(String accio) {
		menuGestio2();
		String accio = reader.readLine();
		boolean accioFeta = false;
		while(!not accioFeta) {
			switch(accio) {
				case "1":		//Insertar
					afegirLlibre(String isbn, String titol, String autor, String editorial, int any, int edicio, Tematica tPrincipal);
					break;
				case "2":		//Modificar
					
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
		menuGestio2();
		String accio = reader.readLine();
		boolean accioFeta = false;
		while(!not accioFeta) {
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