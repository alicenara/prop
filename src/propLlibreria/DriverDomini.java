package propLlibreria;

import java.util.*;
import java.io.*;

public class DriverDomini {
	
	public static BufferedReader reader;
	public static int IDB;					//per saber usuari actual
	
	//Menus
	
	public static void menuNavegacio() {
		System.out.println("Escull tasca a realitzar:");
		System.out.println("\t 1 Introduir contrasenya");
		System.out.println("\t 2 Gestiona Biblioteca");
		System.out.println("\t 3 Consultar Biblioteca");
		System.out.println("\t 4 Canviar contrasenya");
		System.out.println("\t 5 Afegir usuari");
		System.out.println("\t 6 Eliminar usuari");
		System.out.println("\t 0 Sortir");
	}
	
	public static void menuGestio() {
		System.out.println("Gestionar...");
		System.out.println("\t 1 Area");
		System.out.println("\t 2 Seccio");
		System.out.println("\t 3 Tematica");
		System.out.println("\t 4 Llibre");
		System.out.println("\t 5 Estanteria");
		System.out.println("\t 0 Tornar Enrere");
	}
	
		
	public static void menuGestio2() {
		System.out.println("Selecciona accio:");
		System.out.println("\t 1 Insertar");
		System.out.println("\t 2 Modificar");
		System.out.println("\t 3 Eliminar");
		System.out.println("\t 0 Tornar Enrere");
	}
	
	public static void menuConsulta() {
		System.out.println("Consultar...");
		System.out.println("\t 1 Area");
		System.out.println("\t 2 Seccio");
		System.out.println("\t 3 Tematica");
		System.out.println("\t 4 Llibre");
		System.out.println("\t 5 Estanteria");
		System.out.println("\t 0 Tornar Enrere");
	}
	
	public static void  menuModificacioLlibre() {
		System.out.println("Que vols modificar?");
		System.out.println("\t 1 Modificar tematica principal del llibre.");
		System.out.println("\t 2 Afegir una tematica secundaria del llibre.");
		System.out.println("\t 3 Eliminar una tematica secundaria al llibre.");
		System.out.println("\t 4 Modificar isbn del llibre.");
		System.out.println("\t 5 Modificar titol llibre.");
		System.out.println("\t 6 Modificar autor llibre.");
		System.out.println("\t 7 Modificar editorial llibre.");
		System.out.println("\t 8 Modificar any llibre.");
		System.out.println("\t 9 Modificar edicio llibre.");
		System.out.println("\t 0 Tornar enrere.");
	}
	
	//Prints
	
	public static void entradaIncorrecta() {
		System.out.println("No existeix aquesta opcio.Si us plau, torna a intentar-ho.");
	}
	
	public static void printlnfoLlibre(Llibre l) {
			System.out.println("Titulo : " + l.getTitol());
			System.out.println("Autor : " + l.getAutor());
			System.out.println("Any : " + l.getAny());
			System.out.println("Editorial : " + l.getEditorial());
			System.out.println("Edicio : " + l.getEdicio());
			System.out.println("Tematica Principal : " + l.getTemPrincipal().getNomTematica());
			ArrayList<Tematica> temSecundaries = l.getTematiquesSecundaries();
			System.out.println("Tematica Secundaries : ");
			for (int j = 0; j < temSecundaries.size(); j++) {
				System.out.println(temSecundaries.get(j).getNomTematica());
			}
	}
	
	//Gestions
	
	public static void modificacioArea() {
		Area area;
		String nomArea;
		int IDA;
		ArrayList<Area> arees = CtrlBiblioteca.seleccionaAllArees();
		try {
			boolean modFeta = false;
			while (!modFeta) {
				System.out.println("Llistat arees:");
				PrintArees(arees);
				System.out.println("Que vols modificar?");
				System.out.println("\t 1 Nom d'una area existent.");
				System.out.println("\t 2 Afegir seccio a l'area.");
				System.out.println("\t 0 Tornar Enrere");
				String modificacio = reader.readLine();
				switch(modificacio) {
					case "1":
						System.out.println("Quina area vols modificar?");
						nomArea = reader.readLine();
						IDA = CtrlBiblioteca.seleccionaAreaN(nomArea).getID();
						System.out.println("Introdueix nou nom per l'area");
						String novaArea = reader.readLine();
						CtrlBiblioteca.modificarNomArea(IDA, novaArea);
						break;
					case "2":
						System.out.println("Quina area vols modificar?");
						nomArea = reader.readLine();
						area = CtrlBiblioteca.seleccionaAreaN(nomArea);
						if (area == null) throw new Exception("No existe una area con nombre " + nomArea + ".");
						else {
							IDA = area.getID();
							System.out.println("Quina seccio vols introduir?");	
							String novaSeccio = reader.readLine();
							CtrlBiblioteca.afegirSeccio(novaSeccio,IDA);
						}
						break;
					case "0":
							modFeta = true;
						break;
					default:
						entradaIncorrecta();
						break;
				}
			}
		}
		catch(RuntimeException re) {
			System.out.println("Excepcion tipo Runtime. Mensaje : " + re.getMessage());
		}
		catch (IOException io) {
			System.out.println("Excepcio provocada per fallada o interrupcio de operacio I/O . Mensaje :" + io.getMessage());
		}
		catch (Exception e) {
			System.out.println("Execpcion general. Mensaje: " + e.getMessage());
		}
	}


	public static void gestioArea() {
		String nomArea;
		String accio;
		Area area;
		ArrayList<Area> arees;
		boolean accioFeta = false;
		try {
			while(!accioFeta) {
				menuGestio2();
				accio = reader.readLine();
				switch(accio) {
					case "1":		//Insertar
						System.out.println("Llistat arees:");
						arees = CtrlBiblioteca.seleccionaAllArees();
						PrintArees(arees);
						System.out.println("Introdueix nom de la nova area.");
						nomArea = reader.readLine();
						area = CtrlBiblioteca.seleccionaAreaN(nomArea);
						if (area != null) throw new Exception("Ya existe una area amb el nom " + nomArea + ".");
						else CtrlBiblioteca.afegirArea(nomArea);
						break;
					case "2":		//Modificar
						modificacioArea();
						break;
					case "3":		//Eliminar
						System.out.println("Llistat arees:");
						arees = CtrlBiblioteca.seleccionaAllArees();
						PrintArees(arees);
						System.out.println("Quina area vols eliminar?");
						nomArea = reader.readLine();
						area = CtrlBiblioteca.seleccionaAreaN(nomArea);
						if (area == null) throw new Exception("No existe una area con nombre " + nomArea + ".");
						else CtrlBiblioteca.eliminarArea(area);
						break;
					case "0":		//Sortir
						accioFeta = true;
						break;
					default: 
						entradaIncorrecta();
						break;
				}
			}
		}
		catch(RuntimeException re) {
			System.out.println("Excepcion tipo Runtime. Mensaje : " + re.getMessage());
		}
		catch (IOException io) {
			System.out.println("Excepcio provocada per fallada o interrupcio de operacio I/O . Mensaje :" + io.getMessage());
		}
		catch (Exception e) {
			System.out.println("Execpcion general. Mensaje: " + e.getMessage());
		}
		
	}
	
	public static void modificacioGestio() {
		try {
			int IDS;							//ID Seccio
			String nomSeccio;
			Seccio seccio;
			boolean modFeta = false;
			ArrayList<Seccio> seccions = CtrlBiblioteca.seleccionaAllSeccions();
			while(!modFeta) {
				System.out.println("Que vols modificar?");
				System.out.println("\t 1 Canviar nom de seccio existent.");
				System.out.println("\t 2 Afegir tematica a seccio.");
				System.out.println("\t 3 Tornar Enrere");
				String modificacio = reader.readLine();
				switch(modificacio) {
					case "1":
						System.out.println("Llistat seccions:");
						for (int i = 0; i < seccions.size(); i++) {
							System.out.println("\t " + (i+1) + " " + seccions.get(i).getNomSeccio());
						}
						System.out.println("Introdueix la seccio a modificar el nom.");
						nomSeccio = reader.readLine();
						seccio = CtrlBiblioteca.seleccionaSeccioN(nomSeccio);
						if (seccio == null) throw new Exception("No existe una seccio con nombre " + nomSeccio + ".");
						else {
							System.out.println("Introdueix nou nom per la seccio");
							String nouNomSeccio = reader.readLine();
							IDS = seccio.getID();
							CtrlBiblioteca.modificarNomSeccio(IDS, nouNomSeccio);
						}
						break;
					case "2":
						System.out.println("Llistat seccions:");
						for (int i = 0; i < seccions.size(); i++) {
							System.out.println("\t " + (i+1) + " " + seccions.get(i).getNomSeccio());
						}
						System.out.println("Introdueix seccio a afegir-li una tematica");
						nomSeccio = reader.readLine();
						seccio = CtrlBiblioteca.seleccionaSeccioN(nomSeccio);
						if (seccio == null) throw new Exception("No existe una seccio con nombre " + nomSeccio + ".");
						else {
							IDS = seccio.getID();
							System.out.println("Introdueix nom nova tematica a afegir a la seccio");
							String nomNovaTematica = reader.readLine();
							Tematica tematica = CtrlBiblioteca.seleccionaTematicaN(nomNovaTematica);
							if (tematica != null) throw new Exception("Ya existe una tematica con este nombre");
							CtrlBiblioteca.afegirTematica(nomNovaTematica,IDS);
						}
						break;
					case "0":
						modFeta = true;
						break;
					default:
						entradaIncorrecta();
						break;
				}
			}
		}
		catch(RuntimeException re) {
			System.out.println("Excepcion tipo Runtime. Mensaje : " + re.getMessage());
		}
		catch (IOException io) {
			System.out.println("Excepcio provocada per fallada o interrupcio de operacio I/O . Mensaje :" + io.getMessage());
		}
		catch (Exception e) {
			System.out.println("Execpcion general. Mensaje: " + e.getMessage());
		}
	}
	
	public static void gestioSeccio() {
		String accio;
		String nomSeccio;
		Area area;
		Seccio seccio;
		ArrayList<Seccio> seccions;
		boolean accioFeta = false;
		while(!accioFeta) {
			try {
				menuGestio2();
				accio = reader.readLine();
				switch(accio) {
					case "1":		//Insertar
						System.out.println("Llistat seccions:");
						seccions = CtrlBiblioteca.seleccionaAllSeccions();
						for (int i = 0; i < seccions.size(); i++) {
							System.out.println("\t " + (i+1) + " " + seccions.get(i).getNomSeccio());
						}
						System.out.println("A quina area vols assignar la nova seccio?");
						String nomArea = reader.readLine();
						area = CtrlBiblioteca.seleccionaAreaN(nomArea);
						if (area == null) throw new Exception("No existe una area con nombre " + nomArea + ".");
						else {
							System.out.println("Introdueix nom nova seccio");
							String novaSeccio = reader.readLine();
							seccio = CtrlBiblioteca.seleccionaSeccioN(novaSeccio);
							if (seccio != null) throw new Exception("Ya existe una seccio con nombre " + novaSeccio + ".");
							CtrlBiblioteca.afegirSeccio(novaSeccio, area.getID());
						}
						break;
					case "2":		//Modificar
						modificacioGestio();
						break;
					case "3":		//Eliminar
						System.out.println("Llistat seccions:");
						seccions = CtrlBiblioteca.seleccionaAllSeccions();
						for (int i = 0; i < seccions.size(); i++) {
							System.out.println("\t " + (i+1) + " " + seccions.get(i).getNomSeccio());
						}
						System.out.println("Introdueix seccio a eliminar.");
						nomSeccio = reader.readLine();
						Seccio seccioAEliminar = CtrlBiblioteca.seleccionaSeccioN(nomSeccio);
						if (seccioAEliminar == null) throw new Exception("No existe una seccio con nombre " + nomSeccio + ".");
						CtrlBiblioteca.eliminarSeccio(seccioAEliminar);
						break;
					case "0":		//Sortir
						accioFeta = true;
						break;
					default:
						entradaIncorrecta();
						break;
				}
			}
			catch(RuntimeException re) {
				System.out.println("Excepcion tipo Runtime. Mensaje : " + re.getMessage());
			}
			catch (IOException io) {
				System.out.println("Excepcio provocada per fallada o interrupcio de operacio I/O . Mensaje :" + io.getMessage());
			}
			catch (Exception e) {
				System.out.println("Execpcion general. Mensaje: " + e.getMessage());
			}
		}
	}

	public static void modificacioTematica() {
		String nomTematica;
		int IDT;
		String modificacio;
		Tematica tematica;
		boolean modFeta = false;
		while (!modFeta) {
			try {
				System.out.println("Que vols modificar?");
				System.out.println("\t 1 Canviar nom de tematica existent.");
				System.out.println("\t 2 Tornar Enrere");
				modificacio = reader.readLine();
				switch(modificacio) {
					case "1":
						System.out.println("Quina tematica vols modificar?");
						nomTematica = reader.readLine();
						tematica = CtrlBiblioteca.seleccionaTematicaN(nomTematica);
						if (tematica == null) throw new Exception("No existe una tematica con este nombre");
						IDT = tematica.getID();										//IDTematica
						System.out.println("Introdueix nou nom per la tematica");
						String nomModTematica = reader.readLine();
						CtrlBiblioteca.modificarNomTematica(IDT,nomModTematica);
						break;
					case "0":
						modFeta = true;
						break;
					default:
						entradaIncorrecta();
						break;
				}
			}
			catch(RuntimeException re) {
				System.out.println("Excepcion tipo Runtime. Mensaje : " + re.getMessage());
			}
			catch (IOException io) {
				System.out.println("Excepcio provocada per fallada o interrupcio de operacio I/O . Mensaje :" + io.getMessage());
			}
			catch (Exception e) {
				System.out.println("Execpcion general. Mensaje: " + e.getMessage());
			}
		}
	}
	
	public static void gestioTematica() {
		String nomTematica;
		String accio;
		boolean accioFeta = false;
		while(!accioFeta) {
			try {
				menuGestio2();
				accio = reader.readLine();
				switch(accio) {
					case "1":		//Insertar
						System.out.println("A quina seccio pertany la nova tematica?");
						System.out.println("Llistat seccions:");
						ArrayList<Seccio> seccions = CtrlBiblioteca.seleccionaAllSeccions();
						for (int i = 0; i < seccions.size(); i++) {
							System.out.println("\t " + (i+1) + " " + seccions.get(i).getNomSeccio());
						}
						String seccio = reader.readLine();
						int IDS = CtrlBiblioteca.seleccionaSeccioN(seccio).getID();
						System.out.println("Inserta nom nova tematica.");
						String novaTematica = reader.readLine();
						Tematica tematica = CtrlBiblioteca.seleccionaTematicaN(novaTematica);
						if (tematica != null) throw new Exception("Ya existe una tematica con nombre "+ novaTematica+ ".");
						CtrlBiblioteca.afegirTematica(novaTematica,IDS);
						break;
					case "2":		//Modificar
						modificacioTematica();
						break;
					case "3":		//Eliminar
						System.out.println("Llistat tematiques:");
						ArrayList<Tematica> tematiques = CtrlBiblioteca.seleccionaAllTematiques();
						for (int i = 0; i < tematiques.size(); i++) {
							System.out.println("\t " + (i+1) + " " + tematiques.get(i).getNomTematica());
						}
						System.out.println("Introdueix tematica a eliminar.");
						nomTematica = reader.readLine();
						Tematica tematicaAEliminar = CtrlBiblioteca.seleccionaTematicaN(nomTematica);
						if (tematicaAEliminar == null) throw new Exception("No existe una tematica con este nombre");
						CtrlBiblioteca.eliminarTematica(tematicaAEliminar);
						break;
					case "0":		//Sortir
						accioFeta = true;
						break;
					default: 
						entradaIncorrecta();
						break;
				}
			}
			catch(RuntimeException re) {
				System.out.println("Excepcion tipo Runtime. Mensaje : " + re.getMessage());
			}
			catch (IOException io) {
				System.out.println("Excepcio provocada per fallada o interrupcio de operacio I/O . Mensaje :" + io.getMessage());
			}
			catch (Exception e) {
				System.out.println("Execpcion general. Mensaje: " + e.getMessage());
			}
		}
	}
	

	
	
	public static void modificacioLlibre() {
		try {
			System.out.println("Introdueix titol del llibre a modificar:");
			String titolLlibre = reader.readLine();
			String nomTemSecMod;
			Tematica tPrincipalMod;
			Llibre llibre = CtrlBiblioteca.seleccionaLlibreT(titolLlibre);
			if (llibre == null) throw new Exception ("No existeixen llibres amb titol " + titolLlibre + ".");
			int IDL = llibre.getID();
			int IDT;
			ArrayList<Tematica> tematiques = CtrlBiblioteca.seleccionaAllTematiques();
			ArrayList<Tematica> temSecLlibre;
			boolean modFeta = false;
			while(!modFeta) {
				menuModificacioLlibre();
				String modificacio = reader.readLine();
				switch (modificacio) {
					case "1":
						System.out.println("Introdueix nova tematica principal per el llibre.");
						System.out.println("Llistat tematiques:");
						for (int i = 0; i < tematiques.size(); i++) {
							System.out.println("\t " + (i+1) + " " + tematiques.get(i).getNomTematica());
						}
						String nomTematica = reader.readLine();
						tPrincipalMod = CtrlBiblioteca.seleccionaTematicaN(nomTematica);
						if (tPrincipalMod == null) throw new Exception("No existe una tematica con este nombre");
						CtrlBiblioteca.modificarTPrincipalLlibre(IDL,tPrincipalMod);
						break;
					case "2":
						System.out.println("Introdueix nova tematica secundaria per el llibre.");
						temSecLlibre = llibre.getTematiquesSecundaries();
						System.out.println("El llibre " + titolLlibre + "té aquestes tematiques secundaries:");
						for (int i = 0; i < temSecLlibre.size(); i++) System.out.println("\t  · "+ temSecLlibre.get(i).getNomTematica());
						System.out.println("Llistat tematiques:");
						for (int i = 0; i < tematiques.size(); i++) {
							System.out.println("\t " + (i+1) + " " + tematiques.get(i).getNomTematica());
						}
						nomTemSecMod = reader.readLine();
						tPrincipalMod = CtrlBiblioteca.seleccionaTematicaN(nomTemSecMod);
						if (tPrincipalMod == null) throw new Exception("No existe una tematica con este nombre");
						IDT = tPrincipalMod.getID();
						CtrlBiblioteca.afegirTSecundaria(IDL, IDT);
						break;
					case "3":
						temSecLlibre = llibre.getTematiquesSecundaries();
						System.out.println("El llibre " + titolLlibre + "té aquestes tematiques secundaries:");
						for (int i = 0; i < temSecLlibre.size(); i++) System.out.println("\t  · "+ temSecLlibre.get(i).getNomTematica());
						System.out.println("Introdueix la tematica secundaria a eliminar del llibre.");
						nomTemSecMod = reader.readLine();
						Tematica tematica = CtrlBiblioteca.seleccionaTematicaN(nomTemSecMod);
						if (tematica == null) throw new Exception("No existe una tematica con este nombre");
						IDT = tematica.getID();
						CtrlBiblioteca.esborrarTSecundaria(IDL, IDT);
						break;
					case "4":
						System.out.println("Introdueix nou isbn per el llibre");
						String isbnMod = reader.readLine();
						CtrlBiblioteca.modificarIsbnLlibre(IDL,isbnMod);
						break;
					case "5":
						System.out.println("Introdueix nou titol per el llibre");
						String titolMod = reader.readLine();
						CtrlBiblioteca.modificarTitolLlibre(IDL,titolMod);
						break;
					case "6":
						System.out.println("Introdueix nou autor per el llibre");
						String autorMod = reader.readLine();
						CtrlBiblioteca.modificarAutorLlibre(IDL,autorMod);
						break;
					case "7":
						System.out.println("Introdueix nova editorial per el llibre.");
						String editorialMod = reader.readLine();
						CtrlBiblioteca.modificarEditorialLlibre(IDL,editorialMod);
					case "8":
						System.out.println("Introdueix nou any per el llibre.");
						String anyMod = reader.readLine();
						CtrlBiblioteca.modificarAnyLlibre(IDL,Integer.parseInt(anyMod));
						break;
					case "9":
						System.out.println("Introdueix nova edicio per el llibre");
						String edicioMod = reader.readLine();
						CtrlBiblioteca.modificarEdicioLlibre(IDL,Integer.parseInt(edicioMod));
						break;
					case "0":
						modFeta = true;
						break;
					default:
						entradaIncorrecta();
						break;
				}
			}
		}
		catch(RuntimeException re) {
			System.out.println("Excepcion tipo Runtime. Mensaje : " + re.getMessage());
		}
		catch (IOException io) {
			System.out.println("Excepcio provocada per fallada o interrupcio de operacio I/O . Mensaje :" + io.getMessage());
		}
		catch (Exception e) {
			System.out.println("Execpcion general. Mensaje: " + e.getMessage());
		}
	}
	
	public static void gestioLlibre() {
		String accio;
		boolean accioFeta = false;
		String titolLlibre;
		while(!accioFeta) {
			try {
				menuGestio2();
				accio = reader.readLine();
				switch(accio) {
					case "1":		//Insertar
						System.out.println("Introdueix el valors del nou llibre.");
						System.out.println("Recorda que els valors per introduir un llibre son els segï¿½ents: \n isbn, titol, autor, editorial, any, edicio, tematica principal(Escriu-ho tot seguit).");
						String input = reader.readLine();
						String [] infoLlibre = input.split(" ");
						if (infoLlibre.length < 7 || infoLlibre.length > 7 ) throw new Exception("Has escrito una cantidad de atributos incorrectos");
						titolLlibre = infoLlibre[1];
						Llibre l = CtrlBiblioteca.seleccionaLlibreT(titolLlibre);
						if (l != null) throw new Exception ("Ja existeix un llibre amb titol " + titolLlibre + ".");
						String nomTematica = infoLlibre[7];
						Tematica tPrincipal = CtrlBiblioteca.seleccionaTematicaN(nomTematica);
						if (tPrincipal == null) throw new Exception("No existe una tematica con este nombre");
						CtrlBiblioteca.afegirLlibre(infoLlibre[0], titolLlibre, infoLlibre[2],infoLlibre[3],Integer.parseInt(infoLlibre[4]),Integer.parseInt(infoLlibre[5]), tPrincipal);
						break;
					case "2":		//Modificar
						modificacioLlibre();
						break;
					case "3":		//Eliminar
						System.out.println("Introdueix el titol del llibre a eliminar");
						titolLlibre = reader.readLine();
						Llibre llibreAEliminar = CtrlBiblioteca.seleccionaLlibreT(titolLlibre);
						if (llibreAEliminar == null) throw new Exception ("No existeix cap llibre amb titol " + titolLlibre + ".");
						CtrlBiblioteca.eliminarLlibre(llibreAEliminar);
						break;
					case "0":		//Sortir
						accioFeta = true;
						break;
					default: 
						entradaIncorrecta();
						break;
				}
			}
			catch(RuntimeException re) {
				System.out.println("Excepcion tipo Runtime. Mensaje : " + re.getMessage());
			}
			catch (IOException io) {
				System.out.println("Excepcio provocada per fallada o interrupcio de operacio I/O . Mensaje :" + io.getMessage());
			}
			catch (Exception e) {
				System.out.println("Execpcion general. Mensaje: " + e.getMessage());
			}
		}
	}
	
	public static void modificacioEstanteria() {
		boolean modFeta = false;
		while (!modFeta) {
			try {
				System.out.println("Introdueix ID de la estanteria a modificar");
				int IDE = Integer.parseInt(reader.readLine());								//Excepcio por si no existeix la estanteria
				if (CtrlBiblioteca.consultaEstanteria(IDE) == null) throw new Exception("No existe esta estanteria");
				System.out.println("Que vols modificar?");
				System.out.println("\t 1 Modificar numero de files estanteria.");
				System.out.println("\t 2 Modificar llargada estanteria.");
				System.out.println("\t 3 Modificar coordenades estanteria.");
				System.out.println("\t 4 Tornar enrere");
				String modificacio = reader.readLine();
				switch (modificacio) {
					case "1":
						System.out.println("Introdueix nou numero de files de la estanteria");
						String numFilesMod = reader.readLine();
						CtrlBiblioteca.modificarNumFilesEstanteria(IDE,Integer.parseInt(numFilesMod));
						break;
					case "2":
						System.out.println("Introdueix nova llargada de la estanteria");
						String llargadaMod = reader.readLine();
						CtrlBiblioteca.modificarLlargadaEstanteria(IDE, Integer.parseInt(llargadaMod));
						break;
					case "3":														//Te sentit afegir//eliminar llibres de una estanteria si 
						System.out.println("Introdueix noves coordenades:");
						int x = Integer.parseInt(reader.readLine());
						int y = Integer.parseInt(reader.readLine());
						if (x < 0 || y < 0) throw new Exception("Els eixos x i y sempre son positius.");
						CtrlBiblioteca.modificarCoordenadesEstanteria(IDE, x, y);
						break;
					case "0":
						modFeta = true;
						break;
					default:	
						entradaIncorrecta();
						break;
				}
			}
			catch(RuntimeException re) {
				System.out.println("Excepcion tipo Runtime. Mensaje : " + re.getMessage());
			}
			catch (IOException io) {
				System.out.println("Excepcio provocada per fallada o interrupcio de operacio I/O . Mensaje :" + io.getMessage());
			}
			catch (Exception e) {
				System.out.println("Execpcion general. Mensaje: " + e.getMessage());
			}
		}
	}
	public static void gestioEstanteria() {
		String accio;
		boolean accioFeta = false;
		try {
			while(!accioFeta) {
				menuGestio2();
				accio = reader.readLine();
				switch(accio) {
					case "1":		//Insertar
						System.out.println("Inserta numero de files de la nova estanteria, la seva llarga i la seva colocacio en el eix x i y en aquest ordre.");
						String paraula = reader.readLine();
						String[] input = paraula.split(" ");
						if (input.length > 4) throw new Exception("Son nomes 4 elements\n");
						if (Integer.parseInt(input[2]) < 0 && Integer.parseInt(input[3]) < 0 ) throw new Exception("Els eixos x i y son positius. \n");
						CtrlBiblioteca.afegirEstanteria(Integer.parseInt(input[0]), Integer.parseInt(input[1]), Integer.parseInt(input[2]),Integer.parseInt(input[3]));
						break;
					case "2":		//Modificar
						modificacioEstanteria();
						break;
					case "3":		//Eliminar
						System.out.println("Inserta ID de l'estanteria a eliminar:");
						int IDE = Integer.parseInt(reader.readLine());
						Estanteria estanteriaAEliminar= CtrlBiblioteca.consultaEstanteria(IDE);
					    if (estanteriaAEliminar == null) throw new Exception("No existeix una tematica amb ID = " + IDE + ".");
					    CtrlBiblioteca.eliminarEstanteria(IDE);
						break;
					case "0":		//Sortir
						accioFeta = true;
						break;
					default: 
						entradaIncorrecta();
						break;
				}
			}
		}
		catch(RuntimeException re) {
			System.out.println("Excepcion tipo Runtime. Mensaje : " + re.getMessage());
		}
		catch (IOException io) {
			System.out.println("Excepcio provocada per fallada o interrupcio de operacio I/O . Mensaje :" + io.getMessage());
		}
		catch (Exception e) {
			System.out.println("Execpcion general. Mensaje: " + e.getMessage());
		}
	}
	
	public static void PrintArees(ArrayList<Area> arees) {
		for (int i = 0; i < arees.size(); ++i) {
			System.out.println("\t " + (i+1)+ " " + arees.get(i).getNomArea());
		}
	}
	
	
	public static void ConsultaBiblioteca() {
		try {
			String nomTematica;
			int indexArea;
			int indexSeccio;
			ArrayList<Llibre> llibres;
			ArrayList<Area> arees = CtrlBiblioteca.seleccionaAllArees();
			ArrayList<Seccio> seccions;
			ArrayList<Tematica> tematiques;
			boolean consultaFeta = false;
			String consulta;
			while (!consultaFeta) {
				menuConsulta();
				consulta = reader.readLine();
				switch(consulta) {
						case "1":
							System.out.println("Llistat arees:");
							PrintArees(arees);
							System.out.println("Introdueix l'index de l'area a consultar.Si no, tecleja 0.");
							indexArea = Integer.parseInt(reader.readLine()) - 1;
							if (indexArea != -1) {
								seccions = CtrlBiblioteca.consultarSeccionsArea(arees.get(indexArea).getID());
								System.out.println("Llistat seccions de " + arees.get(indexArea).getNomArea() + ":");
								for (int i = 0; i < seccions.size(); i++) {
									System.out.println("\t " + (i+1) + " " + seccions.get(i).getNomSeccio());
								}
								System.out.println("Introdueix index de la seccio a consultar. Si no, tecleja 0.");
								indexSeccio = Integer.parseInt(reader.readLine()) - 1;
								if (indexSeccio != -1) {
									tematiques = CtrlBiblioteca.consultarTematiquesSeccio(seccions.get(indexSeccio).getID());
									System.out.println("Llistat tematiques de " + seccions.get(indexSeccio).getNomSeccio() + ":");
									for (int i = 0; i < seccions.size(); i++) {
										System.out.println("\t " + (i+1) + " " + tematiques.get(i).getNomTematica());
									}
									System.out.println("Introduiex index de la tematica a consultar.Si no, tecleja 0.");
									int indexTematica = Integer.parseInt(reader.readLine()) - 1;
									if (indexTematica != -1) {
										llibres = CtrlBiblioteca.consultarLlibresTematica(tematiques.get(indexTematica).getID());
										System.out.println("Llistat llibres de " + tematiques.get(indexTematica).getNomTematica()+ ":");
										for (int i = 0; i < llibres.size(); i++) printlnfoLlibre(llibres.get(i));
									}
								}
							}
							break;
						case "2":
							seccions = CtrlBiblioteca.seleccionaAllSeccions();
							for (int i = 0; i < seccions.size(); i++) {
								System.out.println("\t " + (i+1) + " " + seccions.get(i).getNomSeccio());
							}
							System.out.println("Introdueix index de la seccio a consultar. Si no, tecleja 0.");
							indexSeccio = Integer.parseInt(reader.readLine()) - 1; 
							if (indexSeccio != -1) {
								tematiques = CtrlBiblioteca.consultarTematiquesSeccio(seccions.get(indexSeccio).getID());
								System.out.println("Llistat tematiques de " + seccions.get(indexSeccio).getNomSeccio() + ":");
								for (int i = 0; i < tematiques.size(); i++) {
									System.out.println("\t " + (i+1) + " " + tematiques.get(i).getNomTematica());
								}
								System.out.println("Introduiex index de la tematica a consultar.Si no, tecleja 0.");
								int indexTematica = Integer.parseInt(reader.readLine()) - 1;
								if (indexTematica != -1) {
									llibres = CtrlBiblioteca.consultarLlibresTematica(tematiques.get(indexTematica).getID());
									System.out.println("Llistat llibres de " + tematiques.get(indexTematica).getNomTematica()+ ":");
									for (int i = 0; i < llibres.size(); i++) printlnfoLlibre(llibres.get(i));
								}
							}
							break;
						case "3":
							tematiques = CtrlBiblioteca.seleccionaAllTematiques();
							for (int i = 0; i < tematiques.size(); i++) {
								System.out.println("\t " + (i+1) + " " + tematiques.get(i).getNomTematica());
							}
							System.out.println("Introduiex index de la tematica a consultar.Si no, tecleja 0.");
							int indexTematica = Integer.parseInt(reader.readLine()) - 1;
							if (indexTematica != -1) {
								llibres = CtrlBiblioteca.consultarLlibresTematica(tematiques.get(indexTematica).getID());
								System.out.println("Llistat llibres de " + tematiques.get(indexTematica).getNomTematica()+ ":");
								for (int i = 0; i < llibres.size(); i++) {
									System.out.println("\t " + (i+1) + " " + llibres.get(i).getTitol() + " " + llibres.get(i).getAutor());
								}
							}
							break;
						case "4":
							System.out.println("Busqueda per: ");
							System.out.println("\t 1 Titol");
							System.out.println("\t 2 Autor");
							System.out.println("\t 3 Any");
							System.out.println("\t 4 Editorial");
							System.out.println("\t 5 ISBN");
							System.out.println("\t 6 Tematica");
							String tipusBusqueda = reader.readLine();
							switch (tipusBusqueda) {
								case "1":
									System.out.println("Introdueix titol:");							//consulta per titol
									String titolLlibre = reader.readLine();
									Llibre l= CtrlBiblioteca.seleccionaLlibreT(titolLlibre);
									if (l == null) System.out.println("No existeixen llibres amb titol " + titolLlibre + ".");
									else printlnfoLlibre(l);
									break;
								case "2":
									System.out.println("Introdueix autor:");
									String autor = reader.readLine();
									llibres = CtrlBiblioteca.consultaLlibresAutor(autor);			//consulta per autor
									if (llibres.size() == 0) System.out.println("No existeixen llibres de l'autor " + autor + ".");
									else for (int i = 0; i < llibres.size(); i++) printlnfoLlibre(llibres.get(i));
									break;
								case "3":
									System.out.println("Introdueix any:");
									int any = Integer.parseInt(reader.readLine());
									llibres = CtrlBiblioteca.consultaLlibresAny(any);	//consulta per any
									if (llibres.size() == 0)  System.out.println("No existeixen llibres de l'any " + any + ".");
									else for (int i = 0; i < llibres.size(); i++) printlnfoLlibre(llibres.get(i));
									break;
								case "4":
									System.out.println("Introdueix Editorial:");
									String editorial = reader.readLine();
									llibres = CtrlBiblioteca.consultaLlibresEditorial(editorial);	//consulta per editorial
									if (llibres.size() == 0) System.out.println("No existeixen llibres de la editorial "+ editorial + ".");
									else for (int i = 0; i < llibres.size(); i++) printlnfoLlibre(llibres.get(i));
									break;
								case "5":
									System.out.println("Introdueix ISBN:");
									String isbn = reader.readLine();
									Llibre llibreISBN = CtrlBiblioteca.consultaLlibrePerISBN(isbn);								//consulta per isbn
									if (llibreISBN == null) System.out.println("No existeix cap llibre amb isbn " + isbn + ".");
									else printlnfoLlibre(llibreISBN);
									break;
								case "6":
									System.out.println("Introdueix tematica principal:");							//consulta per tematica
									nomTematica = reader.readLine();
									Tematica tematica = CtrlBiblioteca.seleccionaTematicaN(nomTematica);
									if (tematica == null) throw new Exception("No existe una tematica con este nombre");
									llibres = CtrlBiblioteca.consultarLlibresTematica(tematica.getID());
									if (llibres.size() == 0) System.out.println("No conte cap llibre la tematica " + nomTematica + ".");
									else for (int i = 0; i < llibres.size(); i++) printlnfoLlibre(llibres.get(i));
									break;
								default:
									entradaIncorrecta();
									break;
							}
							break;
						case "5":					
							System.out.println("Llistat estanteries");
							//llistat
							ArrayList<Estanteria> estanteries = CtrlBiblioteca.seleccionaAllEstanteries();
							for (int i = 0; i < estanteries.size(); i++) {				//Check this, redundante
								System.out.println(estanteries.get(i).getID());			//
							}															//
							System.out.println("Quina estanteria vols consultar?");
							String estanteria = reader.readLine();
							int IDE = Integer.parseInt(estanteria);
							if (estanteria == null) throw new Exception("No existe una estanteria con ID " + IDE + ".");
							llibres = CtrlBiblioteca.consultarLlibresEstanteria(IDE);
							if (llibres.size() == 0) System.out.println("No conte cap llibre la estanteria " + IDE + ".");
							else  for (int i = 0; i < llibres.size(); i++) printlnfoLlibre(llibres.get(i));      //llistat llibres estanteria
							break;
						case "0":
							consultaFeta = true;
							break;
						default:
							entradaIncorrecta();
							break;
					}
			}
		}
		catch(RuntimeException re) {
			System.out.println("Excepcion tipo Runtime. Mensaje : " + re.getMessage());
		}
		catch (IOException io) {
			System.out.println("Excepcio provocada per fallada o interrupcio de operacio I/O . Mensaje :" + io.getMessage());
		}
		catch (Exception e) {
			System.out.println("Execpcion general. Mensaje: " + e.getMessage());
		}
	}
	
	public static void main(String[] args) {
		reader = new BufferedReader(new InputStreamReader(System.in));
		String contrasenya;
		CtrlBiblioteca.iniBD();
		boolean permisAcces = false;
		System.out.println("Benvolgut/da a la Biblioteca");
			boolean end = false;
			String input;
			while (!end) {
				try {									
					menuNavegacio();
					input = reader.readLine();
					switch(input) {
						case "1":
							try {														//try per fer catch per si error de I/O 
								while (!permisAcces) {
									System.out.println("Per favor, introdueix ID:");
									IDB = Integer.parseInt(reader.readLine());
									if (CtrlBiblioteca.consultaBibliotecari(IDB) == null) System.out.println("No existeix cap usuari amb aquesta ID");
									else {
										System.out.println("Per favor, ara Introdueix contrasenya:");
										contrasenya = reader.readLine();
										if (CtrlBiblioteca.iniciaSessioBibliotecari(IDB,contrasenya)) {
											permisAcces = true;
											System.out.println("Log-in correcte.");
										}
										else System.out.println("Ups! Contrasenya incorrecta...");
									}
								}
							}catch (IOException io) {
								System.out.println("Excepcio provocada per fallada o interrupcio de operacio I/O . Mensaje :" + io.getMessage());
							}
							break;
						case "2":			//Gestio Biblioteca
							boolean gestioFeta = false;
							String gestio;
							while(!gestioFeta) {
								menuGestio();
								gestio = reader.readLine();
								switch(gestio) {
									case "1":							//Eliminar, modificar o insertar Area
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
									case "5":							//Eliminar, modificar o insertar Estanteria
										gestioEstanteria();
										break;
									case "0":							//Sortir
										gestioFeta = true;
										break;
									default: 
										entradaIncorrecta();
										break;
								}
							}
							break;
						case "3":			//Consulta Biblioteca
							ConsultaBiblioteca();
							break;	
						case "4":			//Canviar contrasenya
							System.out.println("Si us plau, introdudeix la contrasenya actual.");
							String contrasenyaAnterior = reader.readLine();
							if (!CtrlBiblioteca.iniciaSessioBibliotecari(IDB, contrasenyaAnterior))System.out.println("Contrasenya actual introduida es incorrecta.");
							else {
									System.out.println("I ara la nova contrasenya.");
									String contrasenyaNova = reader.readLine();
									CtrlBiblioteca.restablirContrasenyaBibliotecari(IDB,contrasenyaAnterior,contrasenyaNova);
							}
						case "5":			//Afegir Usuari
							end = true;
							System.out.println("Introdueix contrasenya nou ususari");
							String novaContrasenya = reader.readLine();
							int nouID = CtrlBiblioteca.afegirBibliotecari(novaContrasenya);
							System.out.println("Nou ID d'usuari " + nouID + " amb contrasenya " + novaContrasenya + ".");
							break;
						case "6":			//Eliminar Usuari
							System.out.println("Introdueix ID usuari a eliminar");
							int IDEliminar = Integer.parseInt(reader.readLine());
							Bibliotecari bbtecariAEliminar = CtrlBiblioteca.consultaBibliotecari(IDEliminar);
							if (bbtecariAEliminar == null) throw new Exception("No existeix cap usuari " + IDEliminar + " per eliminar.");
							if (IDEliminar == IDB) throw new Exception("Estas intentant eliminar l'usuari de la sessio actual");
							CtrlBiblioteca.eliminarBibliotecari(bbtecariAEliminar);
							break;
						case "0":			//Sortir
							end = true;
							System.out.println("Log-out confirmat.");
							break;
						default:
							entradaIncorrecta();
							break;
					}
				}
				catch(RuntimeException re) {
					System.out.println("Excepcion tipo Runtime. Mensaje : " + re.getMessage());
				}
				catch (IOException io) {
					System.out.println("Excepcio provocada per fallada o interrupcio de operacio I/O . Mensaje :" + io.getMessage());
				}
				catch (Exception e) {
					System.out.println("Execpcion general. Mensaje: " + e.getMessage());
				}
			}
			try {
				CtrlBiblioteca.guardarSolucio();
			}
			catch (RuntimeException re) {
				System.out.println("Excepcion tipo Runtime. Mensaje : " + re.getMessage());
			}
	}
}