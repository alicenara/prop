public class Bibliotecari {

	private string contrasenya;

	public Bibliotecari(string contra) {
		setContrasenya(contra);
	}

	public void setContrasenya(string contra) {
		contrasenya = contra;
	}

	public string getContrasenya() {
		return contrasenya;
	}

	public void restablirContrasenya(string contra) {
		setContrasenya(contra);
	}

}