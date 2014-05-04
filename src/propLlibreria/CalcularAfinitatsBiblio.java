package propLlibreria;
package compartit;
import java.util.*;

public class CalcularAfinitatsBiblio extends CalcularAfinitats {
	
	public CalcularAfinitatsBiblio() {
		super.CalcularAfinitats();
	}
	
	@Override
	protected double afinitat (Objecte a, Objecte b) {
		Llibre aa = (Llibre) a;
		Llibre bb = (Llibre) b;
		double afins = 0;
		Tematica tPriA = aa.getTematicaPrincipal();
		Tematica tPriB = bb.getTematicaPrincipal();
		if (tPriA == tPriB) {
			afins += 35;
			if (aa.getTematiquesSecundaries() == bb.getTematiquesSecundaries()) afins = 100;
			else afins += comparaTSec(aa,bb);
		}
		else {
			Seccio sA = BD.getSeccio(tPriA.getIDSeccioTematica());
			Seccio sB = BD.getSeccio(tPriB.getIDSeccioTematica());
			if (sA == sB) {
				afins += (25 + comparaTSec(aa,bb));
			}
			else {
				Area aA = BD.getArea(sA.getIDAreaSeccio());
				Area aB = BD.getArea(sB.getIDAreaSeccio());
				if (aA == aB) {
					afins += (15 + comparaTSec(aa,bb));
				}
			}
		}
		return afins;
	}
	
	private double comparaTSec(Llibre a, Llibre b) {
		ArrayList<> tematiquesA = a.
	}
}
