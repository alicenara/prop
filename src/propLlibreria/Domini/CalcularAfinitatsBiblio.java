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
		Tematica tPriA = GestioArea.getTematica(aa.getTemPrincipal());
		Tematica tPriB = GestioArea.getTematica(bb.getTemPrincipal());
		if (tPriA.getID() == tPriB.getID())	afins += 20;
		else {
			Seccio sA = GestioArea.getSeccio(tPriA.getIDSeccioTematica());
			Seccio sB = GestioArea.getSeccio(tPriB.getIDSeccioTematica());
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
		Tematica tpA = GestioArea.getTematica(a.getTemPrincipal());
		Tematica tpB = GestioArea.getTematica(b.getTemPrincipal());
		for(int i = 0; i < tA.size(); ++i) {
			if(tA.get(i).getID() == tpB.getID()) afin += 0.2;
			for(int j = 0; j < tB.size(); ++j) {
				if(tB.get(j).getID() == tA.get(i).getID()) {
					afin += 0.1;
					break;
				}
			}
		}
		for(int i = 0; i < tB.size(); ++i) {
			if(tB.get(i).getID() == tpA.getID()) {
				afin += 0.2;
				break;
			}
		}
		return afin;
	}
}
