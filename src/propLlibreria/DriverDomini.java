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
		int IDA;
		int indexArea;
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
						System.out.println("Introdueix index de l'area que vols modificar.");
						indexArea = Integer.parseInt(reader.readLine())-1;
						if (indexArea < 0 || indexArea >= arees.size()) throw new Exception("Index introduit es incorrecte.");
						IDA = arees.get(indexArea).getID();
						System.out.println("Introdueix nou nom per l'area");
						String novaArea = reader.readLine();
						if(CtrlBiblioteca.seleccionaAreaN(novaArea) != null) throw new Exception("Ja existeix una area amb aquest nom.");
						CtrlBiblioteca.modificarNomArea(IDA, novaArea);
						break;
					case "2":
						System.out.println("Introdueix index de l'area que vols modificar.");
						indexArea = Integer.parseInt(reader.readLine())-1;
						if (indexArea < 0 || indexArea >= arees.size()) throw new Exception("Index introduit es incorrecte.");
						IDA = arees.get(indexArea).getID();
						System.out.println("Quina seccio vols introduir?");	
						String novaSeccio = reader.readLine();
						CtrlBiblioteca.afegirSeccio(novaSeccio,IDA);
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
		while(!accioFeta) {
			menuGestio2();
			accio = reader.readLine();
			switch(accio) {
				case "1":		//Insertar
					try {
						System.out.println("Llistat arees:");
						arees = CtrlBiblioteca.seleccionaAllArees();
						PrintArees(arees);
						System.out.println("Introdueix nom de la nova area.");
						nomArea = reader.readLine();
						area = CtrlBiblioteca.seleccionaAreaN(nomArea);
						if (area != null) throw new Exception("Ja existeix una area amb el nom " + nomArea + ".");
						else CtrlBiblioteca.afegirArea(nomArea);
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
					break;
				case "2":		//Modificar
					modificacioArea();
					break;
				case "3":		//Eliminar
					try {
						System.out.println("Llistat arees:");
						arees = CtrlBiblioteca.seleccionaAllArees();
						PrintArees(arees);
						System.out.println("Introdueix index de l'area que vols eliminar.");
						int indexArea = Integer.parseInt(reader.readLine())-1;
						if (indexArea < 0 || indexArea >= arees.size()) throw new Exception("Index introduit es incorrecte.");
						CtrlBiblioteca.eliminarArea(arees.get(indexArea));
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
	
	public static void modificacioSeccio() {
		try {
			int IDS;							//ID Seccio
			int indexSeccio;
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
						System.out.println("Introdueix index de la seccio que vols modificar.");
						indexSeccio = Integer.parseInt(reader.readLine())-1;
						if (indexSeccio < 0 || indexSeccio >= seccions.size()) throw new Exception("Index introduit es incorrecte.");
						System.out.println("Introdueix nou nom per la seccio");
						String nouNomSeccio = reader.readLine();
						if(CtrlBiblioteca.seleccionaSeccioN(nouNomSeccio) != null) throw new Exception("Ja existeix una seccio amb aquest nom");
						IDS = seccions.get(indexSeccio).getID();
						CtrlBiblioteca.modificarNomSeccio(IDS, nouNomSeccio);
						break;
					case "2":
						System.out.println("Llistat seccions:");
						for (int i = 0; i < seccions.size(); i++) {
							System.out.println("\t " + (i+1) + " " + seccions.get(i).getNomSeccio());
						}
						System.out.println("Introdueix index de la seccio que vols modificar.");
						indexSeccio = Integer.parseInt(reader.readLine())-1;
						if (indexSeccio < 0 || indexSeccio >= seccions.size()) throw new Exception("Index introduit es incorrecte.");
						IDS = seccions.get(indexSeccio).getID();
						System.out.println("Introdueix nom nova tematica a afegir a la seccio");
						String nomNovaTematica = reader.readLine();
						Tematica tematica = CtrlBiblioteca.seleccionaTematicaN(nomNovaTematica);
						if (tematica != null) throw new Exception("Ja existeix una amb aquest nom");
						CtrlBiblioteca.afegirTematica(nomNovaTematica,IDS);
						
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
		Area area;
		Seccio seccio;
		ArrayList<Seccio> seccions;
		boolean accioFeta = false;
		while(!accioFeta) {
				menuGestio2();
				accio = reader.readLine();
				switch(accio) {
					case "1":		//Insertar
					try {
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
						break;
					case "2":		//Modificar
						modificacioSeccio();
						break;
					case "3":		//Eliminar
						try {
							System.out.println("Llistat seccions:");
							seccions = CtrlBiblioteca.seleccionaAllSeccions();
							for (int i = 0; i < seccions.size(); i++) {
								System.out.println("\t " + (i+1) + " " + seccions.get(i).getNomSeccio());
							}
							System.out.println("Introdueix index de la seccio que vols eliminar.");
							int indexSeccio = Integer.parseInt(reader.readLine())-1;
							if (indexSeccio < 0 || indexSeccio >= seccions.size()) throw new Exception("Index introduit es incorrecte.");
							CtrlBiblioteca.eliminarSeccio(seccions.get(indexSeccio));
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

	public static void modificacioTematica() {
		int IDT;
		String modificacio;
		boolean modFeta = false;
		while (!modFeta) {
			try {
				System.out.println("Que vols modificar?");
				System.out.println("\t 1 Canviar nom de tematica existent.");
				System.out.println("\t 2 Tornar Enrere");
				modificacio = reader.readLine();
				switch(modificacio) {
					case "1":
						System.out.println("Llistat tematiques:");
						ArrayList<Tematica> tematiques = CtrlBiblioteca.seleccionaAllTematiques();
						for (int i = 0; i < tematiques.size(); i++) {
							System.out.println("\t " + (i+1) + " " + tematiques.get(i).getNomTematica());
						}
						System.out.println("Introdueix index de la tematica que vols modificar.");
						int indexTematica = Integer.parseInt(reader.readLine())-1;
						if (indexTematica < 0 || indexTematica >= tematiques.size()) throw new Exception("Index introduit es incorrecte.");
						IDT = tematiques.get(indexTematica).getID();										//IDTematica
						System.out.println("Introdueix nou nom per la tematica");
						String nomModTematica = reader.readLine();
						Tematica tematica = CtrlBiblioteca.seleccionaTematicaN(nomModTematica);
						if (tematica != null) throw new Exception("Ja existeix una tematica amb aquest nom "+ nomModTematica+ ".");
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
		String accio;
		ArrayList<Tematica> tematiques;
		boolean accioFeta = false;
		while(!accioFeta) {
			menuGestio2();
			accio = reader.readLine();
			switch(accio) {
				case "1":		//Insertar
					try {
						System.out.println("A quina seccio pertany la nova tematica?");
						System.out.println("Llistat seccions:");
						ArrayList<Seccio> seccions = CtrlBiblioteca.seleccionaAllSeccions();
						for (int i = 0; i < seccions.size(); i++) {
							System.out.println("\t " + (i+1) + " " + seccions.get(i).getNomSeccio());
						}
						System.out.println("Introdueix index de la seccio a la que vols afegir tematica.");
						int indexSeccio = Integer.parseInt(reader.readLine())-1;
						if (indexSeccio < 0 || indexSeccio >= seccions.size()) throw new Exception("Index introduit es incorrecte.");
						int IDS = seccions.get(indexSeccio).getID();
						System.out.println("Llistat tematiques:");
						tematiques = CtrlBiblioteca.seleccionaAllTematiques();
						for (int i = 0; i < tematiques.size(); i++) {
							System.out.println("\t " + (i+1) + " " + tematiques.get(i).getNomTematica());
						}
						System.out.println("Inserta nom nova tematica.");
						String novaTematica = reader.readLine();
						Tematica tematica = CtrlBiblioteca.seleccionaTematicaN(novaTematica);
						if (tematica != null) throw new Exception("Ja existeix una tematica amb aquest nom "+ novaTematica+ ".");
						CtrlBiblioteca.afegirTematica(novaTematica,IDS);
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
					break;
				case "2":		//Modificar
					modificacioTematica();
					break;
				case "3":		//Eliminar
					try {
						System.out.println("Llistat tematiques:");
						tematiques = CtrlBiblioteca.seleccionaAllTematiques();
						for (int i = 0; i < tematiques.size(); i++) {
							System.out.println("\t " + (i+1) + " " + tematiques.get(i).getNomTematica());
						}
						System.out.println("Introdueix index de la tematica que vols eliminar.");
						int indexTematica = Integer.parseInt(reader.readLine())-1;
						if (indexTematica < 0 || indexTematica >= tematiques.size()) throw new Exception("Index introduit es incorrecte.");
						CtrlBiblioteca.eliminarTematica(tematiques.get(indexTematica));
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
	

	
	
	public static void modificacioLlibre() {
		try {
			System.out.println("Introdueix titol del llibre a modificar:");
			String titolLlibre = reader.readLine();
			Llibre llibre = CtrlBiblioteca.seleccionaLlibreT(titolLlibre);
			if (llibre == null) throw new Exception ("No existeixen llibres amb titol " + titolLlibre + ".");
			int IDL = llibre.getID();
			int IDT;
			int indexTematica;
			ArrayList<Tematica> tematiques = CtrlBiblioteca.seleccionaAllTematiques();
			ArrayList<Tematica> temSecLlibre = llibre.getTematiquesSecundaries();
			boolean modFeta = false;
			while(!modFeta) {
				menuModificacioLlibre();
				String modificacio = reader.readLine();
				switch (modificacio) {
					case "1":
						System.out.println("Llistat tematiques:");
						for (int i = 0; i < tematiques.size(); i++) {
							System.out.println("\t " + (i+1) + " " + tematiques.get(i).getNomTematica());
						}
						System.out.println("Introdueix index de la tematica que vols que sigui tematica principal del llibre.");
						indexTematica = Integer.parseInt(reader.readLine())-1;
						if (indexTematica < 0 || indexTematica >= tematiques.size()) throw new Exception("Index introduit es incorrecte.");
						CtrlBiblioteca.modificarTPrincipalLlibre(IDL,tematiques.get(indexTematica));
						break;
					case "2":
						System.out.println("El llibre " + titolLlibre + "t� aquestes tematiques secundaries:");
						for (int i = 0; i < temSecLlibre.size(); i++) System.out.println("\t  � "+ temSecLlibre.get(i).getNomTematica());
						System.out.println("Llistat tematiques:");
						for (int i = 0; i < tematiques.size(); i++) {
							System.out.println("\t " + (i+1) + " " + tematiques.get(i).getNomTematica());
						}
						System.out.println("Introdueix index de la tematica que vols afegir com a secundaria.");
						indexTematica = Integer.parseInt(reader.readLine())-1;
						if (indexTematica < 0 || indexTematica >= tematiques.size()) throw new Exception("Index introduit es incorrecte.");
						CtrlBiblioteca.afegirTSecundaria(IDL, tematiques.get(indexTematica).getID());
						break;
					case "3":
						temSecLlibre = llibre.getTematiquesSecundaries();
						System.out.println("El llibre " + titolLlibre + "t� aquestes tematiques secundaries:");
						for (int i = 0; i < temSecLlibre.size(); i++) System.out.println("\t  "+ i+1 + " " + temSecLlibre.get(i).getNomTematica());
						System.out.println("Introdueix la index de la tematica secundaria a eliminar del llibre.");
						indexTematica = Integer.parseInt(reader.readLine())-1;
						if (indexTematica < 0 || indexTematica >= tematiques.size()) throw new Exception("Index introduit es incorrecte.");
						indexTematica = Integer.parseInt(reader.readLine());
						IDT = temSecLlibre.get(indexTematica).getID();
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
			menuGestio2();
			accio = reader.readLine();
			switch(accio) {
				case "1":		//Insertar
					try {
						System.out.println("Introdueix el valors del nou llibre.");
						System.out.println("Recorda que els valors per introduir un llibre son els seg���ents: \n isbn, titol, autor, editorial, any, edicio, tematica principal(Escriu-ho tot seguit).");
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
					break;
				case "2":		//Modificar
					modificacioLlibre();
					break;
				case "3":		//Eliminar
					try {
						System.out.println("Introdueix el titol del llibre a eliminar");
						titolLlibre = reader.readLine();
						Llibre llibreAEliminar = CtrlBiblioteca.seleccionaLlibreT(titolLlibre);
						if (llibreAEliminar == null) throw new Exception ("No existeix cap llibre amb titol " + titolLlibre + ".");
						CtrlBiblioteca.eliminarLlibre(llibreAEliminar);
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
			while(!accioFeta) {
				menuGestio2();
				accio = reader.readLine();
				switch(accio) {
					case "1":		//Insertar
						try {
							System.out.println("Inserta numero de files de la nova estanteria, la seva llarga i la seva colocacio en el eix x i y en aquest ordre.");
							String paraula = reader.readLine();
							String[] input = paraula.split(" ");
							if (input.length > 4) throw new Exception("Son nomes 4 elements\n");
							if (Integer.parseInt(input[2]) < 0 && Integer.parseInt(input[3]) < 0 ) throw new Exception("Els eixos x i y son positius. \n");
							CtrlBiblioteca.afegirEstanteria(Integer.parseInt(input[0]), Integer.parseInt(input[1]), Integer.parseInt(input[2]),Integer.parseInt(input[3]));
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
						break;
					case "2":		//Modificar
						modificacioEstanteria();
						break;
					case "3":		//Eliminar
						try {
							System.out.println("Inserta ID de l'estanteria a eliminar:");
							int IDE = Integer.parseInt(reader.readLine());
							Estanteria estanteriaAEliminar= CtrlBiblioteca.consultaEstanteria(IDE);
						    if (estanteriaAEliminar == null) throw new Exception("No existeix una tematica amb ID = " + IDE + ".");
						    CtrlBiblioteca.eliminarEstanteria(IDE);
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
						case "1":									//Area
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
						case "2":											//Seccio
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
						case "3":											//Tematica
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
						case "4":											//Llibre
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
									//TODO
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
						case "5":											//Estanteria		
							System.out.println("Llistat estanteries");
							ArrayList<Estanteria> estanteries = CtrlBiblioteca.seleccionaAllEstanteries();
							for (int i = 0; i < estanteries.size(); i++) {				//Check this, redundante
								System.out.println("\t " + estanteries.get(i).getID());			//
							}
							System.out.println("Introdueix index de l'estanteria a consultar. Si no, tecleja 0.");
							int IDE = Integer.parseInt(reader.readLine());
							if (IDE != 0) {
								if (!CtrlBiblioteca.existeixEstanteria(IDE)) throw new Exception("No existe una estanteria con ID " + IDE + ".");
								Estanteria e = CtrlBiblioteca.consultaEstanteria(IDE);
								System.out.println("Que vols consultar?");
								System.out.println("\t 1 Consultar propietats estanteria.");
								System.out.println("\t 2 Consultar llibres estanteria.");
								switch (reader.readLine()) {
									case "1":
										System.out.println("L'estanteria amb id = " + IDE + " te llargada = " + e.getLlargada() + " i esta situada a (" + e.getPosX() + ","+ e.getPosY() + ")" );
										break;
									case "2":
										llibres = CtrlBiblioteca.consultarLlibresEstanteria(IDE);
										if (llibres.size() == 0) System.out.println("No conte cap llibre la estanteria " + IDE + ".");
										else  for (int i = 0; i < llibres.size(); i++) printlnfoLlibre(llibres.get(i));      //llistat llibres estanteria
										break;
									default:
										
										break;
								}
							}
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