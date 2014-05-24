package propLlibreria.Domini;
import compartit.*;
import java.util.*;

public class CalcularAfinitatsBiblio extends CalcularAfinitats {
	
	public CalcularAfinitatsBiblio() {
		super();
	}
	
	@Override
	protected double afinitat (Objecte a, Objecte b) {
		Llibre aa = (Llibre) a;
		Llibre bb = (Llibre) b;
		double afins = 0;
		Tematica tPriA = aa.getTemPrincipal();
		Tematica tPriB = bb.getTemPrincipal();
		if (tPriA.getID() == tPriB.getID())	afins += 10;
		else {
			Seccio sA = GestioArea.getSeccio(tPriA.getIDSeccio());
			Seccio sB = GestioArea.getSeccio(tPriB.getIDSeccio());
			if (sA.getID() == sB.getID()) afins += 5;
			else {
				Area aA = GestioArea.getArea(sA.getIDAreaSeccio());
				Area aB = GestioArea.getArea(sB.getIDAreaSeccio());
				if (aA.getID() == aB.getID()) afins += 1.5;
			}
		}
		afins += comparaTSec(aa,bb);
		return afins;
	}
	
	private double comparaTSec(Llibre a, Llibre b) {
		double afin = 0.0;
		ArrayList<Tematica> tA = a.getTematiquesSecundaries();
		ArrayList<Tematica> tB = b.getTematiquesSecundaries();
		Tematica tpA = a.getTemPrincipal();
		Tematica tpB = b.getTemPrincipal();
		for(int i = 0; i < tA.size(); ++i) {
			if(tA.get(i).getID() == tpB.getID()) afin += 1;
			for(int j = 0; j < tB.size(); ++j) {
				if(tB.get(j).getID() == tA.get(i).getID()) {
					afin += 0.5;
					break;
				}
			}
		}
		for(int i = 0; i < tB.size(); ++i) {
			if(tB.get(i).getID() == tpA.getID()) {
				afin += 1;
				break;
			}
		}
		return afin;
	}
}
