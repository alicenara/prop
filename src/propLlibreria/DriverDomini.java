package propLlibreria;

import java.util.*;
import java.io.*;

public class DriverDomini {
	
	public static BufferedReader reader;
	public static int IDB;					//per saber usuari actual
	
	//Menus
	
	public static void menuNavegacio() {
		System.out.println("Escull tasca a realitzar:");
		System.out.println("\t 1 Gestiona Biblioteca");
		System.out.println("\t 2 Consultar Biblioteca");
		System.out.println("\t 3 Guardar canvis realitzats");
		System.out.println("\t 4 Canviar contrasenya");
		System.out.println("\t 5 Afegir usuari");
		System.out.println("\t 6 Eliminar usuari");
		System.out.println("\t 7 Sortir");
	}
	public static void menuGestio() {
		System.out.println("Gestionar...");
		System.out.println("\t 1 Area");
		System.out.println("\t 2 Seccio");
		System.out.println("\t 3 Tematica");
		System.out.println("\t 4 Llibre");
		System.out.println("\t 5 Estanteria");
		System.out.println("\t 6 Tornar Enrere");
	}
	
		
	public static void menuGestio2() {
		System.out.println("Selecciona accio:");
		System.out.println("\t 1 Insertar");
		System.out.println("\t 2 Modificar");
		System.out.println("\t 3 Eliminar");
		System.out.println("\t 4 Tornar Enrere");
	}
	
	public static void menuConsulta() {
		System.out.println("Consultar...");
		System.out.println("\t 1 Area");
		System.out.println("\t 2 Seccio");
		System.out.println("\t 3 Tematica");
		System.out.println("\t 4 Llibre");
		System.out.println("\t 5 Estanteria");
		System.out.println("\t 6 Tornar Enrere");
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
		System.out.println("\t 10 Tornar enrere.");
	}
	
	//Prints
	
	public static void entradaIncorrecta() {
		System.out.println("No existeix aquesta opcio.Si us plau, torna a intentar-ho.");
	}
	public static void printlnfoLlibres(ArrayList<Llibre> llibres) {
		for (int i = 0; i < llibres.size(); i++) {
			System.out.println("Titulo : " + llibres.get(i).getTitol());
			System.out.println("Autor : " + llibres.get(i).getAutor());
			System.out.println("Any : " + llibres.get(i).getAny());
			System.out.println("Editorial : " + llibres.get(i).getEditorial());
			System.out.println("Edicio : " + llibres.get(i).getEdicio());
			System.out.println("Tematica Principal : " + llibres.get(i).getTemPrincipal().getNomTematica());
			ArrayList<Tematica> temSecundaries = llibres.get(i).getTematiquesSecundaries();
			System.out.println("Tematica Secundaries : ");
			for (int j = 0; j < temSecundaries.size(); j++) {
				System.out.println(temSecundaries.get(j).getNomTematica());
			}
		}
	}
	
	//Gestions
	
	public static void modificacioArea() {
		Area area;
		String nomArea;
		int IDA;
		try {
			boolean modFeta = false;
			while (!modFeta) {
				System.out.println("Que vols modificar?");
				System.out.println("\t 1 Nom de area existent.");
				System.out.println("\t 2 Afegir seccio a l'area.");
				System.out.println("\t 3 Tornar Enrere");
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
							System.out.println("Quina seccio vols introduir?");				//cal comprovar si area te aquesta seccio?
							String novaSeccio = reader.readLine();
							CtrlBiblioteca.afegirSeccio(novaSeccio,IDA);
						}
						break;
					case "3":
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
		boolean accioFeta = false;
		try {
			while(!accioFeta) {
				menuGestio2();
				accio = reader.readLine();
				switch(accio) {
					case "1":		//Insertar
						System.out.println("Introdueix nom de la nova area.");
						nomArea = reader.readLine();
						area = CtrlBiblioteca.seleccionaAreaN(nomArea);
						if (area == null) throw new Exception("Ya existe una area amb el nom " + nomArea + ".");
						else CtrlBiblioteca.afegirArea(nomArea);
						break;
					case "2":		//Modificar
						modificacioArea();
						break;
					case "3":		//Eliminar
						System.out.println("Quina area vols eliminar?");
						nomArea = reader.readLine();
						area = CtrlBiblioteca.seleccionaAreaN(nomArea);
						if (area == null) throw new Exception("No existe una area con nombre " + nomArea + ".");
						else CtrlBiblioteca.eliminarArea(area);
						break;
					case "4":		//Sortir
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
	
	public static void gestioSeccio() {
		int IDA;							//ID Area
		int IDS;							//ID Seccio
		//int IDT;							//ID Tematica
		String accio;
		String nomSeccio;
		Area area;
		Seccio seccio;
		boolean accioFeta = false;
		while(!accioFeta) {
			try {
				menuGestio2();
				accio = reader.readLine();
				switch(accio) {
					case "1":		//Insertar
						System.out.println("A quina area vols assignar la nova seccio?");
						String nomArea = reader.readLine();
						area = CtrlBiblioteca.seleccionaAreaN(nomArea);
						if (area == null) throw new Exception("No existe una area con nombre " + nomArea + ".");
						else {
							IDA = area.getID();
							System.out.println("Introdueix nom nova seccio");
							String novaSeccio = reader.readLine();
							CtrlBiblioteca.afegirSeccio(novaSeccio, IDA);
						}
						break;
					case "2":		//Modificar
						System.out.println("Que vols modificar?");
						System.out.println("\t 1 Canviar nom de seccio existent.");
						System.out.println("\t 2 Afegir tematica a seccio.");
						System.out.println("\t 3 Tornar Enrere");
						String modificacio = reader.readLine();
						switch(modificacio) {
							case "1":
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
								System.out.println("Introdueix seccio a afegir-li una tematica");
								nomSeccio = reader.readLine();
								seccio = CtrlBiblioteca.seleccionaSeccioN(nomSeccio);
								if (seccio == null) throw new Exception("No existe una seccio con nombre " + nomSeccio + ".");
								else {
									IDS = seccio.getID();
									System.out.println("Introdueix nom nova tematica a afegir a la seccio");
									String nomNovaTematica = reader.readLine();
									CtrlBiblioteca.afegirTematica(nomNovaTematica,IDS);
								}
								break;
							case "3":
								entradaIncorrecta();
								break;
							default:
								accioFeta = true;
								break;
						}
						break;
					case "3":		//Eliminar
						System.out.println("Introdueix area de la seccio a eliminar.");
						nomArea = reader.readLine();
						area = CtrlBiblioteca.seleccionaAreaN(nomArea);
						if (area == null) throw new Exception("No existe una area con nombre " + nomArea + ".");
						else {
							IDA = area.getID();
							System.out.println("Ara introdueix seccio a eliminar.");
							nomSeccio = reader.readLine();
							seccio = CtrlBiblioteca.seleccionaSeccioN(nomSeccio);
							if (seccio == null) throw new Exception("No existe una seccio con nombre " + nomSeccio + ".");
							else CtrlBiblioteca.eliminarSeccio(seccio);
						}
						break;
					case "4":		//Sortir
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
		String llibre;
		int IDL;
		int IDT;
		String modificacio;
		Tematica tematica;
		boolean modFeta = false;
		while (!modFeta) {
			try {
				System.out.println("Que vols modificar?");
				System.out.println("\t 1 Canviar nom de tematica existent.");
				System.out.println("\t 2 Afegir llibre a tematica");
				System.out.println("\t 3 Esborrar llibre de tematica");
				System.out.println("\t 4 Tornar Enrere");
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
					case "2":
						System.out.println("Introdueix tematica del llibre a afegir");
						nomTematica = reader.readLine();
						tematica = CtrlBiblioteca.seleccionaTematicaN(nomTematica);
						if (tematica == null) throw new Exception("No existe una tematica con este nombre");
						IDT = tematica.getID();							//IDTematica
						System.out.println("Introdueix llibre a afegir de la tematica");
						llibre = reader.readLine();	
						IDL = CtrlBiblioteca.seleccionaLlibreT(llibre).getID();								//IDLlibre
						CtrlBiblioteca.afegirLlibreTematica(IDT, IDL);
						break;
					case "3":
						System.out.println("Introdueix tematica del  llibre a eliminar");
						nomTematica = reader.readLine();
						tematica = CtrlBiblioteca.seleccionaTematicaN(nomTematica);
						if (tematica == null) throw new Exception("No existe una tematica con este nombre");
						IDT = tematica.getID();							//IDTematica
						System.out.println("Introdueix llibre a eliminar de la tematica");
						llibre = reader.readLine();
						IDL = CtrlBiblioteca.seleccionaLlibreT(llibre).getID();								//IDLlibre
						CtrlBiblioteca.eliminarLlibreTematica(IDT,IDL);
						break;
					case "4":
						entradaIncorrecta();
						break;
					default:
						modFeta = true;
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
						System.out.println("A quina seccio pertany la nova seccio?");
						String seccio = reader.readLine();
						int IDS = CtrlBiblioteca.seleccionaSeccioN(seccio).getID();
						System.out.println("Inserta nom nova tematica.");
						//comprova area
						String novaTematica = reader.readLine();
						CtrlBiblioteca.afegirTematica(novaTematica,IDS);
						break;
					case "2":		//Modificar
						modificacioTematica();
						break;
					case "3":		//Eliminar
						System.out.println("Introdueix tematica a eliminar");
						nomTematica = reader.readLine();
						Tematica tematica = CtrlBiblioteca.seleccionaTematicaN(nomTematica);
						if (tematica == null) throw new Exception("No existe una tematica con este nombre");
						CtrlBiblioteca.eliminarTematica(tematica);
						break;
					case "4":		//Sortir
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
			boolean modFeta = false;
			while(!modFeta) {
				menuModificacioLlibre();
				String modificacio = reader.readLine();
				switch (modificacio) {
					case "1":
						System.out.println("Introdueix nova tematica principal per el llibre.");
						String nomTematica = reader.readLine();
						tPrincipalMod = CtrlBiblioteca.seleccionaTematicaN(nomTematica);
						if (tPrincipalMod == null) throw new Exception("No existe una tematica con este nombre");
						CtrlBiblioteca.modificarTPrincipalLlibre(IDL,tPrincipalMod);
						break;
					case "2":
						System.out.println("Introdueix nova tematica secundaria per el llibre.");
						nomTemSecMod = reader.readLine();
						tPrincipalMod = CtrlBiblioteca.seleccionaTematicaN(nomTemSecMod);
						if (tPrincipalMod == null) throw new Exception("No existe una tematica con este nombre");
						IDT = tPrincipalMod.getID();
						CtrlBiblioteca.afegirTSecundaria(IDL, IDT);
						break;
					case "3":
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
					case "10":
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
						System.out.println("Recorda que els valors per introduir un llibre son els seg�ents: \n isbn, titol, autor, editorial, any, edicio, tematica principal(Escriu-ho tot seguit).");
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
						Llibre llibre = CtrlBiblioteca.seleccionaLlibreT(titolLlibre);
						if (llibre == null) throw new Exception ("No existeix cap llibre amb titol " + titolLlibre + ".");
						CtrlBiblioteca.eliminarLlibre(llibre);
						break;
					case "4":		//Sortir
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
					case "4":
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
						System.out.println("Inserta numero de files de la nova estanteria, la seva llarga i la seva colocaci� en el eix x i y en aquest ordre.");
						String paraula = reader.readLine();
						String[] input = paraula.split(" ");
						if (input.length > 4) throw new Exception("Son solo 4 elementos\n");
						if (Integer.parseInt(input[2]) < 0 && Integer.parseInt(input[3]) < 0 ) throw new Exception("Els eixos x i y son positius. \n");
						CtrlBiblioteca.afegirEstanteria(Integer.parseInt(input[0]), Integer.parseInt(input[1]), Integer.parseInt(input[2]),Integer.parseInt(input[3]));
						break;
					case "2":		//Modificar
						modificacioEstanteria();
						break;
					case "3":		//Eliminar
						System.out.println("Inserta ID de la estanteria a eliminar:");
						int IDE = Integer.parseInt(reader.readLine());
						Estanteria estanteria= CtrlBiblioteca.consultaEstanteria(IDE);
					    if (estanteria == null) throw new Exception("No existeix una tematica amb ID = " + IDE + ".");
					    CtrlBiblioteca.eliminarEstanteria(IDE);
						break;
					case "4":		//Sortir
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
	
	
	public static void ConsultaBiblioteca () {
		try {
			String area;
			String nomTematica;
			ArrayList<Llibre> llibres;
			boolean consultaFeta = false;
			String consulta;
			while (!consultaFeta) {
				menuConsulta();
				consulta = reader.readLine();
				switch(consulta) {
						case "1":
							System.out.println("Llistat arees");
							ArrayList<Area> arees = CtrlBiblioteca.seleccionaAllArees();
							for (int i = 0; i < arees.size(); ++i) {
								System.out.println("\t " + arees.get(i).getNomArea());
							}
							break;
						case "2":
							System.out.println("Introdueix nom de l'area de la que vols veure les seccions:");
							area = reader.readLine();
							int IDA = CtrlBiblioteca.seleccionaAreaN(area).getID();
							ArrayList<Seccio> seccions = CtrlBiblioteca.consultarSeccionsArea(IDA);
							System.out.println("Llistat seccions de " + area + ":");
							for (int i = 0; i < seccions.size(); i++) {
								System.out.println("\t " + (i+1) + " " + seccions.get(i).getNomSeccio());
							}
							System.out.println("Si vols consultar les tematiques de una seccio tecleja el nom la seccio escollida. Si no, tecleja 0.");
							String nomSeccio = reader.readLine();
							
							if (Integer.parseInt(nomSeccio) != 0) {
								Seccio seccio = CtrlBiblioteca.seleccionaSeccioN(nomSeccio);
								if (seccio == null) throw new Exception("No existe una seccio con nombre " + nomSeccio + ".");
								int IDS = seccio.getID();
								ArrayList<Tematica> tematiques = CtrlBiblioteca.consultarTematiquesSeccio(IDS);
								System.out.println("Llistat tematiques de " + nomSeccio + ":");
								for (int i = 0; i < seccions.size(); i++) {
									System.out.println("\t " + (i+1) + " " + tematiques.get(i).getNomTematica());
								}
							}
							break;
						case "3":
							System.out.println("Introduiex nom tematica a consultar:");
							nomTematica = reader.readLine();
							int IDT = CtrlBiblioteca.seleccionaAreaN(nomTematica).getID();
							llibres = CtrlBiblioteca.consultarLlibresTematica(IDT);
							System.out.println("Llistat llibres de " + nomTematica+ ":");
							for (int i = 0; i < llibres.size(); i++) {
								System.out.println("\t " + (i+1) + " " + llibres.get(i).getTitol() + " " + llibres.get(i).getAutor());
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
									else {
										ArrayList<Llibre> unLlibre = new ArrayList<Llibre>();
										unLlibre.add(l);
										printlnfoLlibres(unLlibre);
									}
									break;
								case "2":
									System.out.println("Introdueix autor:");
									String autor = reader.readLine();
									llibres = CtrlBiblioteca.consultaLlibresAutor(autor);			//consulta per autor
									if (llibres.size() == 0) System.out.println("No existeixen llibres de l'autor " + autor + ".");
									else printlnfoLlibres(llibres);
									break;
								case "3":
									System.out.println("Introdueix any:");
									String any = reader.readLine();
									llibres = CtrlBiblioteca.consultaLlibresAny(Integer.parseInt(any));	//consulta per any
									break;
								case "4":
									System.out.println("Introdueix Editorial:");
									String editorial = reader.readLine();
									llibres = CtrlBiblioteca.consultaLlibresEditorial(editorial);	//consulta per editorial
									if (llibres.size() == 0) System.out.println("No existeixen llibres de la editorial "+ editorial + ".");
									else printlnfoLlibres(llibres);
									break;
								case "5":
									System.out.println("Introdueix ISBN:");
									String isbn = reader.readLine();
									Llibre llibreISN = CtrlBiblioteca.consultaLlibrePerISBN(isbn);								//consulta per isbn
									if (llibreISN == null) System.out.println("No existeix cap llibre amb isbn " + isbn + ".");
									else {
										ArrayList<Llibre> unLlibre = new ArrayList<Llibre>();
										unLlibre.add(llibreISN);
										printlnfoLlibres(unLlibre);
									}
									break;
								case "6":
									System.out.println("Introdueix tematica principal:");							//consulta per tematica
									nomTematica = reader.readLine();
									Tematica tematica = CtrlBiblioteca.seleccionaTematicaN(nomTematica);
									if (tematica == null) throw new Exception("No existe una tematica con este nombre");
									llibres = CtrlBiblioteca.consultarLlibresTematica(tematica.getID());
									if (llibres.size() == 0) System.out.println("No conte cap llibre la tematica " + nomTematica + ".");
									else printlnfoLlibres(llibres);
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
							for (int i = 0; i < estanteries.size(); i++) {			//Check this, redundante
								System.out.println(estanteries.get(i).getID());			//
							}															//
							System.out.println("Quina estanteria vols consultar?");
							String estanteria = reader.readLine();
							int IDE = Integer.parseInt(estanteria);
							if (estanteria == null) throw new Exception("No existe una estanteria con ID " + IDE + ".");
							llibres = CtrlBiblioteca.consultarLlibresEstanteria(IDE);
							if (llibres.size() == 0) System.out.println("No conte cap llibre la estanteria " + IDE + ".");
							else printlnfoLlibres(llibres);      //llistat llibres estanteria
							break;
						case "6":
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
		boolean permisAcces = false;
		System.out.println("Benvolgut/da a la Biblioteca");
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
			boolean end = false;
			String input;
			while (!end) {
				try {									
					menuNavegacio();
					input = reader.readLine();
					switch(input) {
						case "1":			//Gestio Biblioteca
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
									case "6":							//Sortir
										gestioFeta = true;
										break;
									default: 
										entradaIncorrecta();
										break;
								}
							}
							break;
						case "2":			//Consulta Biblioteca
	
						case "3":			//Guardar Canvis
							CtrlBiblioteca.guardarSolucio();
							System.out.println("Canvis guardats.");
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
							System.out.println("Nou ID d'usuari �s " + nouID + " amb contrasenya " + novaContrasenya + ".");
							break;
						case "6":			//Sortir
							System.out.println("Introdueix ID usuari a eliminar");
							int IDEliminar = Integer.parseInt(reader.readLine());
							Bibliotecari bbtecariAEliminar = CtrlBiblioteca.consultaBibliotecari(IDEliminar);
							if (bbtecariAEliminar == null) throw new Exception("No existeix cap usuari " + IDEliminar + " per eliminar.");
							if (IDEliminar == IDB) throw new Exception("Estas intentant eliminar l'usuari de la sessio actual");
							CtrlBiblioteca.eliminarBibliotecari(bbtecariAEliminar);
							break;
						case "7":			//Sortir
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
		}
		catch (IOException io) {
			System.out.println("Excepcio provocada per fallada o interrupcio de operacio I/O . Mensaje :" + io.getMessage());
		}
	}
}