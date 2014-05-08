package propLlibreria;
import java.io.*;
import java.util.*;

public class GestioDades {
	private static final String FITXERLLIBRE = new File("prop/resources/Llibre.txt").getAbsolutePath();
	private static final String FITXERTEMATICA = new File("prop/resources/Tematica.txt").getAbsolutePath();
	private static final String FITXERAREA = new File("prop/resources/Area.txt").getAbsolutePath();
	private static final String FITXERBIBLIOTECARI = new File("prop/resources/Bibliotecari.txt").getAbsolutePath();
	private static final String FITXERESTANTERIA = new File("prop/resources/Estanteria.txt").getAbsolutePath();
	private static final String FITXERSECCIO = new File("prop/resources/Seccio.txt").getAbsolutePath();
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
			case 2: fitxer=FITXERAREA;
				break;
			case 3: fitxer=FITXERBIBLIOTECARI;
				break;
			case 4: fitxer=FITXERESTANTERIA;
				break;
			case 5: fitxer=FITXERSECCIO;
		}	
		
		try{	
			//InputStream is = this.getClass().getResourceAsStream(fitxer);
			
			//br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
			//br = new BufferedReader(new FileReader(getClass().getClassLoader().getResourceAsStream(fitxer)));
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
	
	//funció que llegeix l'ultima ID de l'arxiu 
	
	public int llegirUltimaId(int file){
		String codi="";
		
		switch (file){
			case 0: fitxer=FITXERLLIBRE;
				break;
			case 1: fitxer=FITXERTEMATICA;
				break;
			case 2: fitxer=FITXERAREA;
				break;
			case 3: fitxer=FITXERBIBLIOTECARI;
				break;
			case 4: fitxer=FITXERESTANTERIA;
				break;
			case 5: fitxer=FITXERSECCIO;
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
			case 2: fitxer=FITXERAREA;
				break;
			case 3: fitxer=FITXERBIBLIOTECARI;
				break;
			case 4: fitxer=FITXERESTANTERIA;
				break;
			case 5: fitxer=FITXERSECCIO;
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
	
	public ArrayList<String[]> llegirTotsObjectes(int file){
		String[] objecte;
		ArrayList<String[]> resultat = new ArrayList<String[]>();	
		
		switch (file){
			case 0: fitxer=FITXERLLIBRE;
				break;
			case 1: fitxer=FITXERTEMATICA;
				break;
			case 2: fitxer=FITXERAREA;
				break;
			case 3: fitxer=FITXERBIBLIOTECARI;
				break;
			case 4: fitxer=FITXERESTANTERIA;
				break;
			case 5: fitxer=FITXERSECCIO;
		}	
			
		try{
			//InputStream is = this.getClass().getResourceAsStream(fitxer);
		
			//br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
		//br = new BufferedReader(new FileReader(getClass().getClassLoader().getResourceAsStream(fitxer)));
		
			br = new BufferedReader(new FileReader(fitxer));
			while ((linia = br.readLine()) != null) {
				objecte = linia.split(splitBy);
				resultat.add(objecte);
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
		return resultat;			
	}

	
	public boolean escriureTotsObjectes(ArrayList<String[]> obj,int file){
		String[] objecte;
		BufferedWriter writer = null;
		
		switch (file){
			case 0: fitxer=FITXERLLIBRE;
				break;
			case 1: fitxer=FITXERTEMATICA;
				break;
			case 2: fitxer=FITXERAREA;
				break;
			case 3: fitxer=FITXERBIBLIOTECARI;
				break;
			case 4: fitxer=FITXERESTANTERIA;
				break;
			case 5: fitxer=FITXERSECCIO;
		}	
		

		try {
		    writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fitxer), "utf-8"));
		   
		    for(int i=0;i<obj.size();i++){
		    	objecte=obj.get(i);
		    	String result="";
		    	for(int j=0;j<objecte.length;i++){
		    		result+=objecte[j];
		    		if(j < objecte.length-1) result+=";";
		    	}
		    	writer.write(result);
		    	writer.newLine();
		    }		    
		} catch (IOException ex) {
			return false;
		} finally {
			try {
			   writer.close();
		   } catch (Exception ex) {
			   return false;
		   }
		}
		return true;
	}
}
