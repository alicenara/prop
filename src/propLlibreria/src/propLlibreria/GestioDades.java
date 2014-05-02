package propLlibreria;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class GestioDades {
	private static final String FITXERLLIBRE = "./resources/Llibres.txt";
	String fitxer;
	BufferedReader br = null;
	String linia = "";
	String splitBy = ";";
	
	public GestioDades(){}
	
	//GESTI� DE LA CLASSE LLIBRE
	
	//funci� que llegeix la primera ID de l'arxiu amb tots els llibres 
	
	public int llegirPrimeraIdLlibre(){
		fitxer=FITXERLLIBRE;
		String codi="";
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
	
	//funci� que llegeix l'ultima ID de l'arxiu amb tots els llibres
	
	public int llegirUltimaIdLlibre(){
		fitxer=FITXERLLIBRE;
		String codi="";
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
	
	//funci� que retorna totes les dades d'un llibre
	
	public Llibre llegirLlibre(int id){
		fitxer=FITXERLLIBRE;
		Llibre result;
		String identificador=Integer.toString(id);
		
		//variables per facilitar la lectura
		
		int codi=-1;
		String isbn="";
		String titol="";
		String autor="";
		String editorial="";
		int any=-1;
		int edicio=-1;
		int gruix=-1;
		
		try{			
			br = new BufferedReader(new FileReader(fitxer));
			
			while ((linia = br.readLine()) != null) {
				String[] llibre = linia.split(splitBy);
				if (llibre[0]==identificador){
					//nom�s carrega les dades si coincideixen amb la id
					codi=Integer.parseInt(llibre[0]);
					isbn=llibre[1];
					titol=llibre[2];
					autor=llibre[3];
					editorial=llibre[4];
					any=Integer.parseInt(llibre[5]);
					edicio=Integer.parseInt(llibre[6]);
					gruix=Integer.parseInt(llibre[7]);					
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
		if (codi==-1) return null;
		else{
			result = new Llibre(codi,isbn,titol,autor,editorial,any,edicio,gruix);
			return result;			
		}
	}

}
