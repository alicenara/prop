package propLlibreria;
package compartit;
import java.util.*;

public class CalcularAfinitatsBiblio extends CalcularAfinitats {
	
	public CalcularAfinitatsBiblio() {
		super.CalcularAfinitats();
	}
	
	public double afinitat (Llibre a, Llibre b) {
		double afins = 0;
		Tematica tPriA = a.getTematicaPrincipal();
		Tematica tPriB = b.getTematicaPrincipal();
		if (tPriA == tPriB) {
			afins += 35;
			if (a.getTematiquesSecundaries() == b.getTematiquesSecundaries()) afins = 100;
			else afins += comparaTSec(a,b);
		}
		else {
			Seccio sA = BD.getSeccio(tPriA.getIDSeccioTematica());
			Seccio sB = BD.getSeccio(tPriB.getIDSeccioTematica());
			if (sA == sB) {
				afins += (25 + comparaTSec(a,b));
			}
			else {
				Area aA = BD.getArea(sA.getIDAreaSeccio());
				Area aB = BD.getArea(sB.getIDAreaSeccio());
				if (aA == aB) {
					afins += (15 + comparaTSec(a,b));
				}
			}
		}
		return afins;
	}
	
	private double comparaTSec(Llibre a, Llibre b) {
		ArrayList<> tematiquesA = a.
	}
}