
public class NIF {

	// PROPIEDADES
	private int numeroDNI;
	private char letraDNI;

	// CONSTRUCTORES

	// por defecto habrá que pasarle el numDNI
	public NIF(int numeroDNI) {
		this.numeroDNI = numeroDNI;
		this.letraDNI = calcularLetraDNI(numeroDNI);
	}

	// MÉTODOS
	private static char calcularLetraDNI(int dni) {
		// obtenemos el resto de dividir el número de DNI por 23
		int resto = dni % 23;

		// letras del DNI, en orden
		String letras = "TRWAGMYFPDXBNJZSQVHLCKE";

		// devolvemos la letra correspondiente al resto obtenido
		return letras.charAt(resto);
	}

	@Override
	public String toString() {
		return this.numeroDNI + "-" + this.letraDNI;
	}

}
