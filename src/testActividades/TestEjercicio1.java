package testActividades;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import actividades.Ejercicio1;
import us.lsi.common.List2;
import us.lsi.streams.Stream2;

public class TestEjercicio1 {

	public static void main(String[] args) {
		String fichero = "ficheros/PI1Ej1DatosEntrada.txt";
		Function <String, List<String>> parseAct1 = elem -> {
			String[] x = elem.split(",");
			return List2.of(x[0], x[1], x[2], x[3], x[4]);
		};
		
		List<List<String>> lista = Stream2.file(fichero).map(parseAct1).collect(Collectors.toList());
		
		lista.forEach(ls -> {
			Integer varA = Integer.valueOf(ls.get(0));
			String varB = ls.get(1);
			Integer varC = Integer.valueOf(ls.get(2));
			String varD = ls.get(3);
			Integer varE = Integer.valueOf(ls.get(4));

			System.out.println("\n1- Solucion Act 1 Ejercicio A: " + Ejercicio1.ejercicioA(varA, varB, varC, varD, varE));
			System.out.println("2- Solucion Act 1 Iterativo: " + Ejercicio1.iterativo(varA, varB, varC, varD, varE));
			System.out.println("3- Solucion Act 1 Recursivo Final: " + Ejercicio1.recursivoFinal(varA, varB, varC, varD, varE));
			System.out.println("\n-------------------------------------------------\n");

		});
		
	}
}
