package propLlibreria;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class GestioDades {
	private static final String FITXERLLIBRE = "./resources/Llibre.txt";
	private static final String FITXERTEMATICA = "./resources/Tematica.txt";
	String fitxer;
	BufferedReader br = null;
	String linia = "";
	String splitBy = ";";
	
	public GestioDades(){}
	
	//GESTIÓ DE LA CLASSE LLIBRE
	
	//funció que llegeix la primera ID de l'arxiu amb tots els llibres 
	
	public int llegirPrimeraId(int file){
		String codi="";

		switch (file){
			case 0: fitxer=FITXERLLIBRE;
				break;
			case 1: fitxer=FITXERTEMATICA;
				break;
			default:
		}	
		
		try{			
			br = new BufferedReader(new FileReader(fitxer));
			
				linia = br.readLine();
				String[] llibre = linia.split(splitBy);
				codi= llibre[0];			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}			
		}
		linia="";
		if(codi=="") return 0;
		else return Integer.parseInt(codi);		
	}
	
	//funció que llegeix l'ultima ID de l'arxiu amb tots els llibres
	
	public int llegirUltimaId(int file){
		String codi="";
		
		switch (file){
			case 0: fitxer=FITXERLLIBRE;
				break;
			case 1: fitxer=FITXERTEMATICA;
				break;
			default:
		}	
		
		try{			
			br = new BufferedReader(new FileReader(fitxer));
			
			while ((linia = br.readLine()) != null) {
				String[] llibre = linia.split(splitBy);
				codi= llibre[0];
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}			
		}
		linia="";
		if(codi=="") return 0;
		else return Integer.parseInt(codi);		
	}	
	
	//funció que retorna totes les dades d'un llibre
	
	public String[] llegirObjecte(int id, int file){
		String[] objecte=null;
		String identificador=Integer.toString(id);
		boolean noTrobat=true;
		
		switch (file){
			case 0: fitxer=FITXERLLIBRE;
				break;
			case 1: fitxer=FITXERTEMATICA;
				break;
			default:
		}	
		
		try{			
			br = new BufferedReader(new FileReader(fitxer));
			
			while (noTrobat || (linia = br.readLine()) != null) {
				objecte = linia.split(splitBy);
				if (objecte[0]==identificador){
					//només carrega les dades si coincideixen amb la id
					noTrobat=false;
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}			
		}
		linia="";
		return objecte;			
	}

}
