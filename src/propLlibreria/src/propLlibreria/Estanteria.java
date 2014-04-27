package propLlibreria;
import java.util.*;

public class Estanteria {

	private int idEstanteria;
	private int numFiles;
	private int llargada;
	private int posX;
	private int posY;
	
	//Basic constructor
	public Estanteria(){}
	
	//All attributes constructor
	public Estanteria(int idEstanteria, int numFiles, int llargada, int posX, int posY) 
	{
		this.idEstanteria = idEstanteria;
		this.numFiles = numFiles;
		this.llargada = llargada;
		this.posX = posX;
		this.posY = posY;
	}

	//Getters and Setters
	public int getIdEstanteria() {
		return idEstanteria;
	}

	public void setIdEstanteria(int idEstanteria) {
		this.idEstanteria = idEstanteria;
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
	
	
	
	
}
