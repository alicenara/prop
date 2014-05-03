package propLlibreria;

public class CtrlBD {
	
	//Codi dels arxius
	// 0 - Codi de la classe Llibre
	// 1 - Codi de la classe Tematica
	
	
	//CLASSE LLIBRE 
	
	public static int obtenirUltimaIDLlibre(){
		GestioDades g = new GestioDades();
		return g.llegirUltimaId(0)+1;
	}
	
	public static Tematica obtenirTemPrinLlibre(int id){
		GestioDades g = new GestioDades();
		String[] l = g.llegirObjecte(id,0);
		Tematica tem=null;
		if(l != null){
			String[] t = g.llegirObjecte(Integer.parseInt(l[0]),1);
			if (t != null)	tem= new Tematica(Integer.parseInt(t[0]),t[1]);
		}
		return tem;
	}
	
	
	//CLASSE TEMATICA
	
	public static int obtenirUltimaIDTematica(){
		GestioDades g = new GestioDades();
		return g.llegirUltimaId(1)+1;
	}
	
	public static Tematica obtenirTematica(int id){
		GestioDades g = new GestioDades();
		String[] t = g.llegirObjecte(id,1);
		Tematica tem=null;
		if(t != null) tem= new Tematica(Integer.parseInt(t[0]),t[1]);
		return tem;
	}
	
	
	/*public static Llibre obtenirLlibre(int id){
	 * 	//variables per facilitar la lectura
		int codi=-1;
		String isbn="";
		String titol="";
		String autor="";
		String editorial="";
		int any=-1;
		int edicio=-1;
		int gruix=-1;
		
		
		isbn=llibre[1];
		titol=llibre[2];
		autor=llibre[3];
		editorial=llibre[4];
		any=Integer.parseInt(llibre[5]);
		edicio=Integer.parseInt(llibre[6]);
		gruix=Integer.parseInt(llibre[7]);
	}*/

}
