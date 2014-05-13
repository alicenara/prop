package propLlibreria;
import java.util.*;

public class Estanteria {

	private final int ID;
	private int numFiles;
	private int llargada;
	private int posX;
	private int posY;
	private ArrayList<Integer> llibresEstanteria;
	
	//All attributes constructor
	public Estanteria(int numFiles, int llargada, int posX, int posY)  {
		this.numFiles = numFiles;
		this.llargada = llargada;
		this.posX = posX;
		this.posY = posY;
		this.ID = BD.ultimaIDEstanteria();
		BD.afegirEstanteria(this);
	}
	
	public Estanteria(int ID, int numFiles, int llargada, int posX, int posY, ArrayList<Integer> llE)  {
		this.numFiles = numFiles;
		this.llargada = llargada;
		this.posX = posX;
		this.posY = posY;
		llibresEstanteria = llE;
		this.ID = ID;
	}

	//Getters and Setters
	public int getID() {
		return ID;
	}

	public int getNumFiles() {
		return numFiles;
	}

	public void setNumFiles(int numFiles) {
		this.numFiles = numFiles;
	}

	public int getLlargada() {
		return llargada;
	}

	public void setLlargada(int llargada) {
		this.llargada = llargada;
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}	
	
	public ArrayList<Llibre> getLlibres() {
		ArrayList<Llibre> llibres = new ArrayList<Llibre>(); 
		for (int i = 0; i < llibresEstanteria.size(); ++i) {
			llibres.add(BD.getLlibre(llibresEstanteria.get(i)));
		}
		return llibres;
	}
	
	public void afegirLlibre(int IDL) {
		llibresEstanteria.add(IDL);
	}
	
	public void esborrarLlibre(int IDL) {
		llibresEstanteria.remove((Object)new Integer(IDL));
	}
	
	public void buidarLlibres() {
		llibresEstanteria.clear();
	}
}
