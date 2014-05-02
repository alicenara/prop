import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;


public class DriverDomini {
	public static final void menuInical() {
		System.out.printIn("Per favor, introdueix la contrasenya per fer servir sistema;")
	}
	
	public static void menuGestio() {
		System.out.printIn("Gestionar...");
		System.out.printIn("1 Area");
		System.out.printIn("2 Seccio");
		System.out.printIn("3 Tematica");
		System.out.printIn("4 Llibre");
		System.out.printIn("5 Estanteria");
	}
	
		
	public static void menuGestio2() {
		System.out.("Selecciona acció:");
		System.out.("1 Insertar");
		System.out.("2 Modificar");
		System.out.("3 Eliminar");
		System.out.("4 Tornar Enrere")
	}
	
	public static void menuNavegacio() {
		System.out.printIn("Escull tasca a realitzar:");
		System.out.printIn("1 Gestiona Biblioteca");
		System.out.printIn("2 Consultar Biblioteca");
		System.out.printIn("3 Sortir");
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
		System.out.printIn("No existeix aquesta opcio.Si us plau, torna a intentar-ho.");
	}
	
	public static void main() {
		Bibliotecari bbtecari;
		Biblioteca biblio;
		BufferedReader reader = new BufferedReader(new InputStreamer(System.in));
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
								case "1";
									menuGestio2();
									break;
								case "2":
									menuGestio2();
									break;
								case "3":
									menuGestio2();
									break;
								case "4":
									gestioFeta = true;
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
					case "3":			//Sortir
						end = true;
						break;
					default:
						entradaIncorrecta();
						break;
				}
			}
			catch (Exception e) {
				
			}
		}
	}
	
}