package testActividades;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import actividades.Ejercicio4;
import us.lsi.common.List2;
import us.lsi.streams.Stream2;

public class TestEjercicio4 {

	public static void main(String[] args) {
		String fichero = "ficheros/PI1Ej4DatosEntrada.txt";
		Function <String, List<String>> parseAct4 = elem -> {
			String[] x = elem.split(",");
			return List2.of(x[0], x[1], x[2]);
		};
		
		List<List<String>> lista = Stream2.file(fichero).map(parseAct4).collect(Collectors.toList());
		
		lista.forEach(ls -> {
			Integer a = Integer.valueOf(ls.get(0));
			Integer b = Integer.valueOf(ls.get(1));
			Integer c = Integer.valueOf(ls.get(2));

			System.out.println("1- Solucion Act 4 Recursivo sin memoria: " + Ejercicio4.recursivoSinMemoria(a, b, c));
			System.out.println("2- Solucion Act 4 Recursivo con memoria: " + Ejercicio4.recursivoConMemoria(a, b, c));
			System.out.println("3- Solucion Act 4 Recursivo iterativo: " + Ejercicio4.iterativo(a, b, c));
			System.out.println("\n-------------------------------------------------\n");

		});

	}

}
