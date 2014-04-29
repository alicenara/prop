public class Biblioteca {
	
	private string nom_biblioteca;
	private Estanteria[] estanteries;

	public Biblioteca() {

	}

	public double calcularAfinitatLlibres(Llibre a, Llibre b) {

	}

	public void ordenarLlibres() {

	}

	public int[] consultarOrdreActual() {

	}

	public void afegirEstanteria(int files, int llargada) {
		Estanteria nova = new Estanteria(files, llargada);
		int pos = estanteries.length;
		estanteries[pos] = nova;
	}

	public void esborrarEstanteria(int id) {
		int noutamany = estanteries.length - 1;
		Estanteria[] nouestanteries = new Estanteria[noutamany];
		for (int i = 0; i < id; ++i) {
			nouestanteries[i] = estanteries[i];
		}
		for (int i = id; i < noutamany; ++i) {
			nouestanteries[i] = estanteries[i+1];
		}
		estanteries = nouestanteries;
	}
}