package propLlibreria;

import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class DriverDomini {
	
	public static BufferedReader reader;
	
	//Menus
	
	public static void menuNavegacio() {
		System.out.println("Escull tasca a realitzar:");
		System.out.println("\t 1 Gestiona Biblioteca");
		System.out.println("\t 2 Consultar Biblioteca");
		System.out.println("\t 3 Guardar canvis realitzats");
		System.out.println("\t 4 Canviar contrasenya");
		System.out.println("\t 5 Sortir");
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
	public void printlnfoLlibres(ArrayList<Llibre> llibres) {
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
	
	public void modificacioArea() {
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
		catch (Exception e) {
			System.out.println("Execpcion general. Mensaje: " + e.getMessage());
		}
	}


	public void gestioArea() {
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
			catch (Exception e) {
				System.out.println("Execpcion general. Mensaje: " + e.getMessage());
			}
		}
	}
	
	public static void gestioTematica() {
		String llibre;
		String nomTematica;
		String accio;
		int IDT;							//ID Tematica
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
						IDT = tematica.getID();								//IDTematica
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
			catch (Exception e) {
				System.out.println("Execpcion general. Mensaje: " + e.getMessage());
			}
		}
	}
	

	
	
	public void modificacioLlibre() {
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
		catch (Exception e) {
			System.out.println("Execpcion general. Mensaje: " + e.getMessage());
		}
	}
	
	public static void gestioLlibre() {
		String llibre;
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
						System.out.println("Recorda que els valors per introduir un llibre son els següents: \n isbn, titol, autor, editorial, any, edicio, tematica principal(Escriu-ho tot seguit).");
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
						int IDL = llibre.getID();
						CtrlBiblioteca.eliminarLlibre(IDL);
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
			catch (Exception e) {
				System.out.println("Execpcion general. Mensaje: " + e.getMessage());
			}
		}
	}
	
	public void modificacioEstanteria() {
		String titolLlibre;
		Llibre llibre;
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
						// TODO afegir modificadora
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
						System.out.println("Inserta numero de files de la nova estanteria, la seva llarga i la seva colocació en el eix x i y en aquest ordre.");
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
						Estanteria estanteria= CtrlBiblioteca.seleccionaEstanteriaN(IDE);
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
		catch (Exception e) {
			System.out.println("Execpcion general. Mensaje: " + e.getMessage());
		}
	}
	
	public static void main() {
		Bibliotecari bbtecari = new Bibliotecari("javarules");
		reader = new BufferedReader(new InputStreamReader(System.in));
		String contrasenya;
		boolean permisAcces = false;
		System.out.println("Benvolgut/da a la Biblioteca");
		while (!permisAcces) {
			System.out.println("Per favor, introdueix la contrasenya per fer servir sistema:");
			contrasenya = reader.readLine();
			if (!bbtecari.logIn(contrasenya)) System.out.println("Ups! Contrasenya incorrecta...");
			else permisAcces = true;
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
								case "6";							//Sortir
									gestioFeta = true;
									break;
								default: 
									entradaIncorrecta();
									break;
							}
						}
						break;
					case "2":			//Consulta Biblioteca
						String area;
						String nomTematica;
						String seccio;
						String llibre;
						boolean consultaFeta = false;
						String consulta;
						while (!consultaFeta) {
							menuConsulta();
							consulta = reader.readLine();
							switch(consulta) {
									case "1":
										System.out.println("Llistat arees");
										int ultimaID = ultimaIDArea();
										for (int id = 0; id < ultimaID; ++id) {
											System.out.println("\t " + BD.getArea(id).getNomArea());
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
										System.out.println("Si vols consultar les tematiques de una seccio tecleja l'index de la llista de la seccio escollida. Si no, tecleja 0.");
										int seccioEscollida = Integer.Integer.parseInt(reader.readLine());
										seccioEscollida = seccioEscollida - 1;				//index de seccions
										if (seccioEscollida  > -1 and seccioEscollida < seccions.size()) {
											int IDS = seccions.get(seccioEscollida).getID();					//GET ID seccioEscollida
											ArrayList<Tematica> tematiques = CtrlBiblioteca.consultarTematiquesSeccio(IDS);
											System.out.println("Llistat tematiques de " + seccions.get(seccioEscollida) + ":");
											for (int i = 0; i < seccions.size(); i++) {
												System.out.println("\t " + (i+1) + " " + tematiques.get(i).getNomTematica());
											}
										}
										else 
										break;
									case "3":
										System.out.println("Introduiex nom tematica a consultar:");
										tematica = reader.readLine();
										int IDT = CtrlBiblioteca.seleccioArea(tematica).getID();
										ArrayList<Llibre> llibres = consultarLlibresTematica(IDT);
										System.out.println("Llistat llibres de " + tematica+ ":");
										for (int i = 0; i < llibres.size(); i++) {
											System.out.println("\t " + (i+1) + " " + seccions.get(i).getTitol() + " " + seccions.get(i).getAutor());
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
												String titol = reader.readLine();
												Llibre l= CtrlBiblioteca.seleccionaLlibreT(llibre);
												if (llibre == null) System.out.println("No existeixen llibres amb titol " + titol + ".");
												break;
											case "2":
												System.out.println("Introdueix autor:");
												String autor = reader.readLine();
												ArrayList<Llibre> llibres = consultaLlibresPerAutor(autor);			//consulta per autor
												if (llibres.size() == 0) System.out.println("No existeixen llibres de l'autor " + autor + ".");
												else printlnfoLlibres(llibres);
												break;
											case "3":
												System.out.println("Introdueix any:");
												String any = reader.readLine();
												ArrayList<Llibre> llibres = BD.consultaLlibresPerAny(Integer.Integer.parseInt(any));	//consulta per any
												break;
											case "4":
												System.out.println("Introdueix Editorial:");
												String editorial = reader.readLine();
												ArrayList<Llibre> llibres = consultaLlibresPerEditorial(editorial);	//consulta per editorial
												if (llibres.size() == 0) System.out.println("No existeixen llibres de la editorial "+ editorial + ".");
												else printlnfoLlibres(llibres);
												break;
											case "5":
												System.out.println("Introdueix ISBN:");
												String isbn = reader.readLine();
												Llibre l = consultaLlibrePerISBN(isbn);								//consulta per isbn
												if (l == null) System.out.println("No existeix cap llibre amb isbn " + isbn + ".");
												else {
													ArrayList<Llibre> llibres = new ArrayList<Llibre>;
													llibres.add(l);
													printlnfoLlibres(llibres);
												}
												break;
											case "6":
												System.out.println("Introdueix tematica principal:");							//consulta per tematica
												String nomTematica = reader.readLine();
												Tematica tematica = CtrlBiblioteca.seleccionaTematicaN(nomTematica);
												if (tematica == null) throw new Exception("No existe una tematica con este nombre");
												ArrayList<Llibre> llibres = consultarLlibresTematica(tematica.getID());
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
										int ultimaIDEstanteria = ultimaIDEstanteria();
										for (int id = 0; id < ultimaIDEstanteria; id++) {			//Check this, redundante
											System.out.println(CtrlBiblioteca.seleccionaEstanteriaN(id).getID());			//
										}															//
										System.out.println("Quina estanteria vols consultar?");
										String estanteria = reader.readLine();
										int IDE = Integer.Integer.parseInt(estanteria);
										if (estanteria == null) throw new Exception("No existe una estanteria con ID " + IDE + ".");
										ArrayList<Llibre> llibre = CtrlBiblioteca.consultarLlibresEstanteria(IDE);
										if (llibres.size() == 0) System.out.println("No conte cap llibre la estanteria " + IDE + ".");
										else printlnfoLlibres(llibres);
										printlnfoLlibres(llibres);
										//llistat llibres estanteria
										break;
									case "6":
										consultaFeta = true;
										break;
									default:
										entradaIncorrecta();
										break;
								}
						}
						break;
					case "3":			//Guardar Canvis
						CtrlBiblioteca.guardarSolucio();
						System.out.println("Canvis guardats.");
						break;
					case "4":			//Canviar contrasenya
						System.out.println("Si us plau, introdudeix la contrasenya actual.");
						String contrasenyaAnterior = reader.readLine();
						if (bbtecari.logIn(contrasenyaAnterior)) {
							System.out.println("I ara la nova contrasenya.");
							String contrasenyaNova = reader.readLine();
							bbtecari.restablirContrasenya(contrasenyaAnterior, contrasenyaNova);
						}
						else System.out.println("Contrasenya actual introduida es incorrecta.");
					case "5":			//Sortir
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
			catch (Exception e) {
				System.out.println("Execpcion general. Mensaje: " + e.getMessage());
			}
		}*/
	}
}