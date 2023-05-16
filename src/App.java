import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class App {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		Persona arrayPersonas[] = crearPersonasDeFichero("entrada.txt");

		// mostrem per persona l'array que hem a partir del fitxer (proves dev)
		mostrarPersonas(arrayPersonas);

		System.out.println(personaMesJove(arrayPersonas));
		esribirFicheroSalida("salida.txt", arrayPersonas);

	}

	public static Persona llegirPersona(String data, String nif, String nomICognom) {

		// partimos la fecha en String[] para procesarla
		String[] dataStringPartes = data.split("-");

		// creamos data conviertiendo las partes en int para Data(int dia, int mes, int
		// año)
		Data dataBien = new Data(Integer.parseInt(dataStringPartes[0]), Integer.parseInt(dataStringPartes[1]),
				Integer.parseInt(dataStringPartes[2]));

		NIF nifBien = new NIF(Integer.parseInt(nif));

		Persona persona = new Persona(nomICognom, dataBien, nifBien);

		return persona;
	}

	// Leemos data, creamos. NIF, creamos. nom, creamos. cPersona, ponemos en
	// Persona[]
	public static Persona[] crearPersonasDeFichero(String nombreFichero) throws FileNotFoundException {

		Scanner ficheroEntrada = new Scanner(new File(nombreFichero));

		int cantidadPersonas = ficheroEntrada.nextInt();

		Persona[] arrayPersonas = new Persona[cantidadPersonas];

		// MANERA 1 BRUTA while si no supieramos cuantos hay, habria que
		// pasar una vez para leer todas las lineas, y de ahi hacer el array vacio
		// int indice = 0;
//		while (ficheroEntrada.hasNextLine() && indice < cantidadPersonas) {
//
//			arrayPersonas[indice] = llegirPersona(ficheroEntrada.next(), ficheroEntrada.next(),
//					ficheroEntrada.nextLine().trim()); // trim() elimina en un String los espacios antes y después del
//														// contenido
//			indice++;
//		}

		// MANERA 2 CLEAN
		for (int i = 0; i < cantidadPersonas; i++) {

			arrayPersonas[i] = llegirPersona(ficheroEntrada.next(), ficheroEntrada.next(),
					ficheroEntrada.nextLine().trim());

		}

		ficheroEntrada.close();

		return arrayPersonas;
	}

	public static String personaMesJove(Persona[] arrayPersonas) {
		Persona personaJove = arrayPersonas[0];

		for (int i = 1; i < arrayPersonas.length; i++) {

			if (arrayPersonas[i].getData().getAny() > personaJove.getData().getAny()) {// comparem any
				personaJove = arrayPersonas[i];
			} else if (arrayPersonas[i].getData().getAny() == personaJove.getData().getAny()) { // si son mateix any,
				if (arrayPersonas[i].getData().getMes() > personaJove.getData().getMes()) { // comparem més
					personaJove = arrayPersonas[i];
				} else if (arrayPersonas[i].getData().getMes() == personaJove.getData().getMes()) { // siateix any-mes
					if (arrayPersonas[i].getData().getDia() > personaJove.getData().getDia()) { // comparem dia
						personaJove = arrayPersonas[i];
					}
				}
			}
		}

		return "\nPersona més jove: " + personaJove.getNom();
	}

	// Escribimos en ficheroSalida el toString() de cada objeto del arrayPersonas[]
	public static void esribirFicheroSalida(String nombreFichero, Persona[] arrayPersonas) throws IOException {
		PrintWriter ficheroSalida = new PrintWriter(new FileWriter(nombreFichero));

		for (int i = 0; i < arrayPersonas.length; i++) {
			ficheroSalida.println(arrayPersonas[i]);
		}

		ficheroSalida.println(personaMesJove(arrayPersonas));

		ficheroSalida.close();
	}

	// método para comprobaciones en consola
	public static void mostrarPersonas(Persona[] arrayPersonas) {
		for (int i = 0; i < arrayPersonas.length; i++) {
			System.out.println(arrayPersonas[i]);
		}
	}

}
