package testActividades;

import actividades.Ejercicio3;

public class TestEjercicio3 {

	public static void main(String[] args) {
		String fichero1A = "ficheros/PI1Ej3DatosEntrada1A.txt";
		String fichero1B = "ficheros/PI1Ej3DatosEntrada1B.txt";
		String fichero2A = "ficheros/PI1Ej3DatosEntrada2A.txt";
		String fichero2B = "ficheros/PI1Ej3DatosEntrada2B.txt";
		String fichero3A = "ficheros/PI1Ej3DatosEntrada3A.txt";
		String fichero3B = "ficheros/PI1Ej3DatosEntrada3B.txt";

		System.out.println("- Solucion fichero1A Y fichero 1B -");
		System.out.println("1- Solucion Act 3 TEST 1 Iterativo: " + Ejercicio3.Iterativo(fichero1A, fichero1B));
		System.out.println("Numero de puntos: "  + Ejercicio3.Iterativo(fichero1A, fichero1B).size());
		System.out.println("2- Solucion Act 3 TEST 1 Recursivo Final: " + Ejercicio3.RecFin(fichero1A, fichero1B));
		System.out.println("Numero de puntos: "  + Ejercicio3.RecFin(fichero1A, fichero1B).size());
		System.out.println("3- Solucion Act 3 TEST 1 Funcional: " + Ejercicio3.Funcional(fichero1A, fichero1B));
		System.out.println("Numero de puntos: "  + Ejercicio3.Funcional(fichero1A, fichero1B).size());


		System.out.println("\n-------------------------------------\n");

		System.out.println("- Solucion fichero2A Y fichero 2B -");
		System.out.println("1- Solucion Act 3 TEST 2 Iterativo: " + Ejercicio3.Iterativo(fichero2A, fichero2B));
		System.out.println("Numero de puntos: "  + Ejercicio3.Iterativo(fichero2A, fichero2B).size());
		System.out.println("2- Solucion Act 3 TEST 2 Recursivo Final: " + Ejercicio3.RecFin(fichero2A, fichero2B));
		System.out.println("Numero de puntos: "  + Ejercicio3.RecFin(fichero2A, fichero2B).size());
		System.out.println("3- Solucion Act 3 TEST 2 Funcional: " + Ejercicio3.Funcional(fichero2A, fichero2B));
		System.out.println("Numero de puntos: "  + Ejercicio3.Funcional(fichero2A, fichero2B).size());


		System.out.println("\n-------------------------------------\n");

		System.out.println("- Solucion fichero3A Y fichero 3B -");
		System.out.println("1- Solucion Act 3 TEST 3 Iterativo: " + Ejercicio3.Iterativo(fichero3A, fichero3B));
		System.out.println("Numero de puntos: "  + Ejercicio3.Iterativo(fichero3A, fichero3B).size());
		System.out.println("2- Solucion Act 3 TEST 3 Recursivo Final: " + Ejercicio3.RecFin(fichero3A, fichero3B));
		System.out.println("Numero de puntos: "  + Ejercicio3.RecFin(fichero3A, fichero3B).size());
		System.out.println("3- Solucion Act 3 TEST 3 Funcional: " + Ejercicio3.Funcional(fichero3A, fichero3B));
		System.out.println("Numero de puntos: "  + Ejercicio3.Funcional(fichero3A, fichero3B).size());

	}

}
