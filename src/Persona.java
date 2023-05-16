
public class Persona {

	// PROPIEDADES
	private String nom;
	private Data data;
	private NIF nif;

	// CONSTRUCTORES
	public Persona(String nom, Data data, NIF nif) {
		this.nom = nom;
		this.data = data;
		this.nif = nif;
	}

	// METODOS
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Data getData() {
		return data;
	}

	public void setData(Data data) {
		this.data = data;
	}

	public NIF getNif() {
		return nif;
	}

	public void setNif(NIF nif) {
		this.nif = nif;
	}

	@Override
	public String toString() {
		return nom + " - " + data + " - " + nif;
	}

}
