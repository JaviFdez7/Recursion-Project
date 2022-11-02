package testEjemplos;

import java.util.List;
import java.util.function.Function;

import ejemplos.Ejemplo1;
import us.lsi.common.Files2;
import us.lsi.geometria.Punto2D;

public class TestEjemplo1 {

	public static void main(String[] args) {	
			String nombre = "ficheros/Ejemplo1DatosEntrada.txt";
			
			Function<String,Punto2D> parse = s -> {
				String[] s2 = s.split(",");
				return Punto2D.of(Double.valueOf(s2[0]),Double.valueOf(s2[1]));
			};
			List<Punto2D> ls = Files2.streamFromFile(nombre)
									.map(parse)
									.toList();
			
			System.out.println("EJEMPLO 1 Datos de entrada: \n"+ls);
			System.out.println("\n1) Resultado Notación Funcional; \n\t"+Ejemplo1.funcional(ls));
			System.out.println("\n1) Resultado Notación iterativo; \n\t"+Ejemplo1.iterativo(ls));
			System.out.println("\n1) Resultado Notación recursivo; \n\t"+Ejemplo1.recursivo(ls));


	}
}
