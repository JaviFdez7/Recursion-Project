package testEjemplos;

import java.util.function.Function;

import ejemplos.Ejemplo2;
import us.lsi.common.Files2;
import us.lsi.common.IntPair;

import java.util.List;

public class TestEjemplo2 {

	public static void main(String[] args) {
		String fichero = "ficheros/Ejemplo2DatosEntrada.txt";
		
		Function<String,IntPair> parseIntPair = s -> {
			String s2[] = s.split(",");
			return IntPair.of(Integer.valueOf(s2[0]), Integer.valueOf(s2[1]));
		};

		
		List<IntPair> pares = Files2.streamFromFile(fichero).map(parseIntPair).toList();
		
		
		Integer i=0;
		System.out.println("Ejemplo 2: ");
		while(i<pares.size()) {
			IntPair par = pares.get(i);
			System.out.println("\nDatos de entrada: "+par);
			Integer a= par.first();
			Integer b= par.second();
			System.out.println("1) Resultado Rec no final: "+Ejemplo2.recursivoNoFinal(a, b));
			System.out.println("2) Resultado Rec final: "+Ejemplo2.recursivoFinal(a, b));
			System.out.println("3) Resultado iterativo: "+Ejemplo2.iterativo(a, b));
			System.out.println("4) Resultado notación funcional: "+Ejemplo2.funcional(a, b));
			
			i++;
		}
		
	}
}
