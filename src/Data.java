
public class Data {

	// PROPIEDADES
	private int dia;
	private int mes;
	private int any;

	// CONSTRUCTORES
	public Data() { // por defecto
		corretgirDataIncorrecta();
	}

	public Data(int dia, int mes, int any) {
		this.dia = dia;
		this.mes = mes;
		this.any = any;
		corretgirDataIncorrecta();
	}

	// MÉTODOS

	// comprovem el format de la data, dona true o false
	public static boolean comprovarDataCorrecta(int dia, int mes) {
		boolean dataCorrecta = true;

		if (!(dia >= 1 && dia <= 31)) {
			dataCorrecta = false;
		}

		if (!(mes >= 1 && mes <= 12)) {
			dataCorrecta = false;
		}

		return dataCorrecta;

	}

	// utilitzant el mètode anterior, si dona fals (data Incorrecta) resetejem data
	private void corretgirDataIncorrecta() {

		// si la data no està bé
		boolean dataCorrecta = comprovarDataCorrecta(dia, mes);

		// la resetejem a 01/01/2021
		if (!dataCorrecta) {
			this.dia = 1;
			this.mes = 1;
			this.any = 2021;
		}

	}

	public int getDia() {
		return dia;
	}

	public void setDia(int dia) {
		this.dia = dia;
	}

	public int getMes() {
		return mes;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}

	public int getAny() {
		return any;
	}

	public void setAny(int any) {
		this.any = any;
	}

	// Funció que suma un dia
	public void sumarDia() {
		this.dia++;
		if (this.dia > 31) {
			this.mes++;
			this.dia = 1;
			if (this.mes > 12) {
				this.any++;
				this.mes = 1;
			}
		}

	}

	@Override
	public String toString() {
		return String.format("%02d/%02d/%04d", this.dia, this.mes, this.any);
	}

}
