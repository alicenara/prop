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
	
	public static void printInfoLlibre(Llibre l) {
			System.out.println("Titulo : " + l.getTitol());
			System.out.println("Autor : " + l.getAutor());
			System.out.println("Any : " + l.getAny());
			System.out.println("Editorial : " + l.getEditorial());
			System.out.println("Edicio : " + l.getEdicio());
			System.out.println("Tematica Principal : " + l.getTemPrincipal().getNomTematica());
			ArrayList<Tematica> temSecundaries = l.getTematiquesSecundaries();
			System.out.println("Tematica Secundaries : ");
			for (int j = 0; j < temSecundaries.size(); j++) {
				System.out.println("                    · " + temSecundaries.get(j).getNomTematica());
			}
	}
	
	//Gestions
	
	public static void modificacioArea() {
		int IDA;
		ArrayList<Area> arees = CtrlBiblioteca.seleccionaAllArees();
		try {
			boolean modFeta = false;
			while (!modFeta) {
				System.out.println("Llistat arees:");
				printArees(arees);
				System.out.println("Que vols modificar?");
				System.out.println("\t 1 Nom d'una area existent.");
				System.out.println("\t 2 Afegir seccio a l'area.");
				System.out.println("\t 0 Tornar Enrere");
				String modificacio = reader.readLine();
				switch(modificacio) {
					case "1":
						System.out.println("Introdueix ID de l'area que vols modificar.");
						IDA = Integer.parseInt(reader.readLine());
						if (!CtrlBiblioteca.existeixArea(IDA)) throw new Exception("ID introduit es incorrecte.");
						System.out.println("Introdueix nou nom per l'area");
						String novaArea = reader.readLine();
						if(CtrlBiblioteca.seleccionaAreaN(novaArea) != null) throw new Exception("Ja existeix una area amb aquest nom.");
						CtrlBiblioteca.modificarNomArea(IDA, novaArea);
						break;
					case "2":
						System.out.println("Introdueix ID de l'area que vols modificar.");
						IDA = Integer.parseInt(reader.readLine());
						if (!CtrlBiblioteca.existeixArea(IDA)) throw new Exception("ID introduit es incorrecte.");
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
		try {
			while(!accioFeta) {
				menuGestio2();
				accio = reader.readLine();
				switch(accio) {
					case "1":		//Insertar
						try {
							System.out.println("Llistat arees:");
							arees = CtrlBiblioteca.seleccionaAllArees();
							printArees(arees);
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
							printArees(arees);
							System.out.println("Introdueix ID de l'area que vols eliminar.");
							int IDA = Integer.parseInt(reader.readLine());
							if (!CtrlBiblioteca.existeixArea(IDA)) throw new Exception("ID introduit es incorrecte.");
							CtrlBiblioteca.eliminarArea(IDA);
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
	
	public static void modificacioSeccio() {
		try {
			int IDS;							//ID Seccio
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
						printSeccions(seccions);
						System.out.println("Introdueix ID de la seccio que vols modificar.");
						IDS = Integer.parseInt(reader.readLine());
						if (!CtrlBiblioteca.existeixSeccio(IDS)) throw new Exception("ID introduit es incorrecte.");
						System.out.println("Introdueix nou nom per la seccio");
						String nouNomSeccio = reader.readLine();
						if(CtrlBiblioteca.seleccionaSeccioN(nouNomSeccio) != null) throw new Exception("Ja existeix una seccio amb aquest nom");
						CtrlBiblioteca.modificarNomSeccio(IDS, nouNomSeccio);
						break;
					case "2":
						System.out.println("Llistat seccions:");
						printSeccions(seccions);
						System.out.println("Introdueix ID de la seccio que vols modificar.");
						IDS = Integer.parseInt(reader.readLine());
						if (!CtrlBiblioteca.existeixSeccio(IDS)) throw new Exception("ID introduit es incorrecte.");
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
		Seccio seccio;
		ArrayList<Seccio> seccions;
		boolean accioFeta = false;
		try {
			while(!accioFeta) {
					menuGestio2();
					accio = reader.readLine();
					switch(accio) {
						case "1":		//Insertar
							try {
								System.out.println("Llistat arees:");
								ArrayList<Area> arees = CtrlBiblioteca.seleccionaAllArees();
								printArees(arees);
								System.out.println("Introdueix ID de l'area a la que vols afegir una seccio.");
								int IDA = Integer.parseInt(reader.readLine());
								System.out.println("Introdueix nom nova seccio");
								String novaSeccio = reader.readLine();
								seccio = CtrlBiblioteca.seleccionaSeccioN(novaSeccio);
								if (seccio != null) throw new Exception("Ya existe una seccio con nombre " + novaSeccio + ".");
								CtrlBiblioteca.afegirSeccio(novaSeccio, IDA);
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
								printSeccions(seccions);
								System.out.println("Introdueix ID de la seccio que vols eliminar.");
								int IDS = Integer.parseInt(reader.readLine());
								if (!CtrlBiblioteca.existeixSeccio(IDS)) throw new Exception("ID introduit es incorrecte.");
								CtrlBiblioteca.eliminarSeccio(seccions.get(IDS));
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
							System.out.println("\t " + tematiques.get(i).getID() + " " + tematiques.get(i).getNomTematica());
						}
						System.out.println("Introdueix ID de la tematica que vols modificar.");
						IDT = Integer.parseInt(reader.readLine());
						if (!!CtrlBiblioteca.existeixTematica(IDT)) throw new Exception("ID introduit es incorrecte.");
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
		try {
			while(!accioFeta) {
				menuGestio2();
				accio = reader.readLine();
				switch(accio) {
					case "1":		//Insertar
						try {
							System.out.println("A quina seccio pertany la nova tematica?");
							System.out.println("Llistat seccions:");
							ArrayList<Seccio> seccions = CtrlBiblioteca.seleccionaAllSeccions();
							printSeccions(seccions);
							System.out.println("Introdueix ID de la seccio a la que vols afegir tematica.");
							int IDS = Integer.parseInt(reader.readLine());
							if (!CtrlBiblioteca.existeixSeccio(IDS)) throw new Exception("ID introduit es incorrecte.");
							System.out.println("Llistat tematiques:");
							tematiques = CtrlBiblioteca.seleccionaAllTematiques();
							for (int i = 0; i < tematiques.size(); i++) {
								System.out.println("\t " + tematiques.get(i).getID() + " " + tematiques.get(i).getNomTematica());
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
								System.out.println("\t " + tematiques.get(i).getID() + " " + tematiques.get(i).getNomTematica());
							}
							System.out.println("Introdueix ID de la tematica que vols eliminar.");
							int IDT = Integer.parseInt(reader.readLine());
							if (!!CtrlBiblioteca.existeixTematica(IDT)) throw new Exception("ID introduit es incorrecte.");
							CtrlBiblioteca.eliminarTematica(tematiques.get(IDT));
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
	

	
	
	public static void modificacioLlibre() {
		try {
			System.out.println("Introdueix titol del llibre a modificar:");
			String titolLlibre = reader.readLine();
			Llibre llibre = CtrlBiblioteca.seleccionaLlibreT(titolLlibre);
			if (llibre == null) throw new Exception ("No existeixen llibres amb titol " + titolLlibre + ".");
			int IDL = llibre.getID();
			int IDT;
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
							System.out.println("\t " + tematiques.get(i).getID() + " " + tematiques.get(i).getNomTematica());
						}
						System.out.println("Introdueix ID de la tematica que vols que sigui tematica principal del llibre.");
						IDT = Integer.parseInt(reader.readLine());
						if (!!CtrlBiblioteca.existeixTematica(IDT)) throw new Exception("ID introduit es incorrecte.");
						CtrlBiblioteca.modificarTPrincipalLlibre(IDL,tematiques.get(IDT));
						break;
					case "2":
						System.out.println("El llibre " + titolLlibre + " te aquestes tematiques secundaries:");
						for (int i = 0; i < temSecLlibre.size(); i++) System.out.println("\t   "+ temSecLlibre.get(i).getNomTematica());
						System.out.println("Llistat tematiques:");
						for (int i = 0; i < tematiques.size(); i++) {
							System.out.println("\t " + tematiques.get(i).getID() + " " + tematiques.get(i).getNomTematica());
						}
						System.out.println("Introdueix ID de la tematica que vols afegir com a secundaria.");
						IDT = Integer.parseInt(reader.readLine());
						if (!!CtrlBiblioteca.existeixTematica(IDT)) throw new Exception("ID introduit es incorrecte.");
						CtrlBiblioteca.afegirTSecundaria(IDL, IDT);
						break;
					case "3":
						temSecLlibre = llibre.getTematiquesSecundaries();
						System.out.println("El llibre " + titolLlibre + "titol aquestes tematiques secundaries:");
						for (int i = 0; i < temSecLlibre.size(); i++) System.out.println("\t  "+ temSecLlibre.get(i).getID() + " " + temSecLlibre.get(i).getNomTematica());
						System.out.println("Introdueix la index de la tematica secundaria a eliminar del llibre.");
						IDT = Integer.parseInt(reader.readLine());
						if (!!CtrlBiblioteca.existeixTematica(IDT)) throw new Exception("ID introduit es incorrecte.");
						IDT = Integer.parseInt(reader.readLine());
						
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
		try {
			while(!accioFeta) {
				menuGestio2();
				accio = reader.readLine();
				switch(accio) {
					case "1":		//Insertar
						try {
							System.out.println("Introdueix el valors del nou llibre.");
							System.out.println("Recorda que els valors per introduir un llibre son els segï¿½ï¿½ï¿½ents: \n isbn, titol, autor, editorial, any, edicio, tematica principal(Escriu-ho tot seguit).");
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
	
	public static void printArees(ArrayList<Area> arees) {
		for (int i = 0; i < arees.size(); ++i) {
			System.out.println("\t " + arees.get(i).getID() + " " + arees.get(i).getNomArea());
		}
	}
	
	public static void printSeccions(ArrayList<Seccio> seccions) {
		for (int i = 0; i < seccions.size(); i++) {
			System.out.println("\t " + seccions.get(i).getID() + " " + seccions.get(i).getNomSeccio());
		}
	}
	public static void printEstanteries(ArrayList<Estanteria> estanteries) {
		for (int i = 0; i < estanteries.size(); i++) {
			System.out.println("\t " + estanteries.get(i).getID());			
		}
	}
	
	public static void ConsultaBiblioteca() {
			String nomTematica;
			int IDA;
			int IDS;
			ArrayList<Llibre> llibres;
			ArrayList<Area> arees = CtrlBiblioteca.seleccionaAllArees();
			ArrayList<Seccio> seccions;
			ArrayList<Tematica> tematiques;
			boolean consultaFeta = false;
			String consulta;
			while (!consultaFeta) {
				menuConsulta();
				try {
					consulta = reader.readLine();
					switch(consulta) {
							case "1":									//Area
								try {
									System.out.println("Llistat arees:");
									printArees(arees);
									System.out.println("Introdueix l'index de l'area a consultar.Si no, tecleja 0.");
									IDA = Integer.parseInt(reader.readLine());
									if (CtrlBiblioteca.existeixArea(IDA)) throw new Exception("Index area introduit es incorrecte.");
									if (IDA != -1) {
										ArrayList<Seccio> seccionsArea = CtrlBiblioteca.consultarSeccionsArea(IDA);
										System.out.println("Llistat seccions de " + arees.get(IDA).getNomArea() + ":");
										printSeccions(seccionsArea);
										System.out.println("Introdueix ID de la seccio a consultar. Si no, tecleja 0.");
										IDS = Integer.parseInt(reader.readLine());
										if (!CtrlBiblioteca.existeixSeccio(IDS)) throw new Exception("ID seccio introduit es incorrecte.");
										if (IDS != -1) {
											tematiques = CtrlBiblioteca.consultarTematiquesSeccio(IDS);
											System.out.println("Llistat tematiques de " + seccionsArea.get(IDS).getNomSeccio() + ":");
											for (int i = 0; i < tematiques.size(); i++) {
												System.out.println("\t " + tematiques.get(i).getID() + " " + tematiques.get(i).getNomTematica());
											}
											System.out.println("Introdueix ID de la tematica a consultar.Si no, tecleja 0.");
											int IDT = Integer.parseInt(reader.readLine());
											if (!CtrlBiblioteca.existeixTematica(IDT)) throw new Exception("Index tematica introduit es incorrecte.");
											if (IDT != -1) {
												llibres = CtrlBiblioteca.consultarLlibresTematica(IDT);
												System.out.println("Llistat llibres de " + tematiques.get(IDT).getNomTematica()+ ":");
												for (int i = 0; i < llibres.size(); i++) printInfoLlibre(llibres.get(i));
											}
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
								break;
							case "2":											//Seccio
								try {
									seccions = CtrlBiblioteca.seleccionaAllSeccions();
									printSeccions(seccions);
									System.out.println("Introdueix ID de la seccio a consultar. Si no, tecleja 0.");
									IDS = Integer.parseInt(reader.readLine());
									if (!CtrlBiblioteca.existeixSeccio(IDS)) throw new Exception("ID seccio introduit es incorrecte.");
									if (IDS != -1) {
										tematiques = CtrlBiblioteca.consultarTematiquesSeccio(IDS);
										System.out.println("Llistat tematiques de " + seccions.get(IDS).getNomSeccio() + ":");
										for (int i = 0; i < tematiques.size(); i++) {
											System.out.println("\t " + tematiques.get(i).getID() + " " + tematiques.get(i).getNomTematica());
										}
										System.out.println("Introdueix ID de la tematica a consultar.Si no, tecleja 0.");
										int IDT = Integer.parseInt(reader.readLine());
										if (!CtrlBiblioteca.existeixTematica(IDT)) throw new Exception("Index tematica introduit es incorrecte.");
										if (IDT != -1) {
											llibres = CtrlBiblioteca.consultarLlibresTematica(IDT);
											System.out.println("Llistat llibres de " + tematiques.get(IDT).getNomTematica()+ ":");
											for (int i = 0; i < llibres.size(); i++) printInfoLlibre(llibres.get(i));
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
								break;
							case "3":											//Tematica
								try {
									tematiques = CtrlBiblioteca.seleccionaAllTematiques();
									for (int i = 0; i < tematiques.size(); i++) {
										System.out.println("\t " + tematiques.get(i).getID() + " " + tematiques.get(i).getNomTematica());
									}
									System.out.println("Introdueix ID de la tematica a consultar.Si no, tecleja 0.");
									int IDT = Integer.parseInt(reader.readLine());
									if (!CtrlBiblioteca.existeixTematica(IDT)) throw new Exception("Index tematica introduit es incorrecte.");
									if (IDT != -1) {
										llibres = CtrlBiblioteca.consultarLlibresTematica(IDT);
										System.out.println("Llistat llibres de " + tematiques.get(IDT).getNomTematica()+ ":");
										for (int i = 0; i < 0; ++i) printInfoLlibre(llibres.get(i));
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
							case "4":											//Llibre
								boolean consultaLlibreFeta = false;
								while (!consultaLlibreFeta) {
									try {
										System.out.println("Busqueda per: ");
										System.out.println("\t 1 Titol");
										System.out.println("\t 2 Autor");
										System.out.println("\t 3 Any");
										System.out.println("\t 4 Editorial");
										System.out.println("\t 5 ISBN");
										System.out.println("\t 6 Tematica");
										System.out.println("\t 0 Tornar enrere");
										String tipusBusqueda = reader.readLine();
										switch (tipusBusqueda) {
											case "1":
												System.out.println("Introdueix titol:");							//consulta per titol
												String titolLlibre = reader.readLine();
												Llibre l= CtrlBiblioteca.seleccionaLlibreT(titolLlibre);
												if (l == null) System.out.println("No existeixen llibres amb titol " + titolLlibre + ".");
												else printInfoLlibre(l);
												break;
											case "2":
												System.out.println("Introdueix autor:");
												String autor = reader.readLine();
												llibres = CtrlBiblioteca.consultaLlibresAutor(autor);			//consulta per autor
												if (llibres.size() == 0) System.out.println("No existeixen llibres de l'autor " + autor + ".");
												else for (int i = 0; i < llibres.size(); i++) printInfoLlibre(llibres.get(i));
												break;
											case "3":
												System.out.println("Introdueix any:");
												int any = Integer.parseInt(reader.readLine());
												llibres = CtrlBiblioteca.consultaLlibresAny(any);	//consulta per any
												if (llibres.size() == 0)  System.out.println("No existeixen llibres de l'any " + any + ".");
												else for (int i = 0; i < llibres.size(); i++) printInfoLlibre(llibres.get(i));
												break;
											case "4":
												System.out.println("Introdueix Editorial:");
												String editorial = reader.readLine();
												llibres = CtrlBiblioteca.consultaLlibresEditorial(editorial);	//consulta per editorial
												if (llibres.size() == 0) System.out.println("No existeixen llibres de la editorial "+ editorial + ".");
												else for (int i = 0; i < llibres.size(); i++) printInfoLlibre(llibres.get(i));
												break;
											case "5":
												System.out.println("Introdueix ISBN:");
												String isbn = reader.readLine();
												Llibre llibreISBN = CtrlBiblioteca.consultaLlibrePerISBN(isbn);								//consulta per isbn
												if (llibreISBN == null) System.out.println("No existeix cap llibre amb isbn " + isbn + ".");
												else printInfoLlibre(llibreISBN);
												break;
											case "6":
												
												System.out.println("Introdueix tematica principal:");							//consulta per tematica
												//TODO
												nomTematica = reader.readLine();
												Tematica tematica = CtrlBiblioteca.seleccionaTematicaN(nomTematica);
												if (tematica == null) throw new Exception("No existe una tematica con este nombre");
												llibres = CtrlBiblioteca.consultarLlibresTematica(tematica.getID());
												if (llibres.size() == 0) System.out.println("No conte cap llibre la tematica " + nomTematica + ".");
												else for (int i = 0; i < llibres.size(); i++) printInfoLlibre(llibres.get(i));
												break;
											case "0":
												consultaLlibreFeta = true;
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
								break;
							case "5":											//Estanteria		
								try {
									System.out.println("Llistat estanteries");
									ArrayList<Estanteria> estanteries = CtrlBiblioteca.seleccionaAllEstanteries();
									
									System.out.println("Introdueix ID de l'estanteria a consultar. Si no, tecleja 0.");
									int IDE = Integer.parseInt(reader.readLine());
									while (IDE != 0) {
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
												else  for (int i = 0; i < llibres.size(); i++) printInfoLlibre(llibres.get(i));      //llistat llibres estanteria
												break;
											default:
												break;
										}
										System.out.println("Introdueix ID de l'estanteria a consultar. Si no, tecleja 0.");
										IDE = Integer.parseInt(reader.readLine());
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
							case "0":
								consultaFeta = true;
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
							}
							catch (IOException io) {
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