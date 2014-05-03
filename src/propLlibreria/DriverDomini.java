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
		System.out.printIn("1 Gestiona Biblioteca");
		System.out.printIn("2 Consultar Biblioteca");
		System.out.printIn("3 Canviar contrasenya")
		System.out.printIn("4 Sortir");
	}
	System.out.
	public static void menuGestio() {
		System.out.printIn("Gestionar...");
		System.out.printIn("1 Area");
		System.out.printIn("2 Seccio");
		System.out.printIn("3 Tematica");
		System.out.printIn("4 Llibre");
		System.out.printIn("5 Estanteria");
		System.out.printIn("6 Tornar Enrere")
	}
	
		
	public static void menuGestio2() {
		System.out.("Selecciona acció:");
		System.out.("1 Insertar");
		System.out.("2 Modificar");
		System.out.("3 Eliminar");
		System.out.("4 Tornar Enrere")
	}
	
	public static void menuConsulta() {
		System.out.printIn("Consultar...");
		System.out.printIn("1 Area");
		System.out.printIn("2 Seccio");
		System.out.printIn("3 Tematica");
		System.out.printIn("4 Llibre");
		System.out.printIn("5 Estanteria");
		System.out.printIn("6 Tornar Enrere")
	}
	
	public static void entradaIncorrecta() {
		System.out.printIn("No existeix aquesta opció.Si us plau, torna a intentar-ho.");
	}
	
	
	public void gestioArea(String accio) {
		boolean accioFeta = false;
		while(!not accioFeta) {
			switch(accio) {
				case "1":		//Insertar
					afegirArea(String nomArea) {
					break;
				case "2":		//Modificar
					public void modificarNomArea(int ID, String nomA);
					public void afegirSeccioArea(int IDA, int IDS);
					public void esborrarSeccioArea(int IDA, int IDS) {
						
					}
					break;
				case "3":		//Eliminar
					public void eliminarArea(int ID);
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
		boolean accioFeta = false;
		while(!not accioFeta) {
			switch(accio) {
				case "1":		//Insertar
					public void afegirSeccio(String nomSeccio);
					break;
				case "2":		//Modificar
					public void modificarNomSeccio(int ID, String nomS);
					public void afegirTematicaSeccio(int IDS, int IDT);
					break;
				case "3":		//Eliminar
					public void eliminarSeccio(int ID);
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
		boolean accioFeta = false;
		while(!not accioFeta) {
			switch(accio) {
				case "1":		//Insertar
					afegirTematica(String nomTematica);
					break;
				case "2":		//Modificar
					
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
		boolean accioFeta = false;
		while(!not accioFeta) {
			switch(accio) {
				case "1":		//Insertar
	
					break;
				case "2":		//Modificar
					
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
		boolean accioFeta = false;
		while(!not accioFeta) {
			switch(accio) {
				case "1":		//Insertar
					biblio.afegirEstanteria();
					break;
				case "2":		//Modificar
					
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
									menuGestio2();
									accio = reader.readLine();
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