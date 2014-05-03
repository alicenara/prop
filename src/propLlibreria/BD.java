package propLlibreria;
import java.util.*;

public class BD {
	private static ArrayList<Area> area;
	private static ArrayList<Bibliotecari> bcari;
	private static ArrayList<Estanteria> est;
	private static ArrayList<Llibre> llibre;
	private static ArrayList<Seccio> sec;
	private static ArrayList<Tematica> tem;
	
	public static void omplirBD(){
		area=CtrlBD.obtenirTotesArees();
		bcari=CtrlBD.obtenirTotsBcaris();
		est=CtrlBD.obtenirTotesEstanteries();
		llibre=CtrlBD.obtenirTotsLlibres();
		sec=CtrlBD.obtenirTotesSec();
		tem=CtrlBD.obtenirTotesTem();
	}
	
	public static void desarBD(){
		//TODO
	}
	
	//Ultima ID Entitats
	public static int ultimaIDArea(){
		return area.get(area.size()-1).getID();
	}
	public static int ultimaIDEstanteria(){
		return est.get(est.size()-1).getID();
	}
	public static int ultimaIDLlibre(){
		return llibre.get(llibre.size()-1).getID();
	}
	public static int ultimaIDSeccio(){
		return sec.get(sec.size()-1).getID();
	}
	public static int ultimaIDTematica(){
		return tem.get(tem.size()-1).getID();
	}
}
