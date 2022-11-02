package testActividades;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import actividades.Ejercicio2;
import us.lsi.common.List2;
import us.lsi.streams.Stream2;

public class TestEjercicio2 {

	public static void main(String[] args) {
		String fichero = "ficheros/PI1Ej2DatosEntrada.txt";
		Function <String, List<String>> parseAct2 = elem -> {
			String[] x = elem.split(",");
			return List2.of(x[0], x[1], x[2]);
		};
		
		List<List<String>> lista = Stream2.file(fichero).map(parseAct2).collect(Collectors.toList());
		
		lista.forEach(ls -> {
			Integer a = Integer.valueOf(ls.get(0));
			Integer b = Integer.valueOf(ls.get(1));
			String s = ls.get(2);

			System.out.println("1- Solucion Act 2 Recursivo no final: " + Ejercicio2.RecNoFin(a, b, s));
			System.out.println("2- Solucion Act 2 Recursivo final: " + Ejercicio2.RecFin(a, b, s));
			System.out.println("3- Solucion Act 2 Iterativo: " + Ejercicio2.iterativo(a, b, s));
			System.out.println("4- Solucion Act 2 Notacion Funcional: " + Ejercicio2.funcional(a, b, s));

			System.out.println("\n-------------------------------------------------\n");
		});

	}

}
