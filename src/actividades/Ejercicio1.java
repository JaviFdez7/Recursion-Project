package actividades;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import us.lsi.common.List2;

public class Ejercicio1 {
	public static record EnteroCadena (Integer a, String s) {
		public static EnteroCadena of(Integer a, String s) {
			return new EnteroCadena(a,s);
		}
	}
	
	
	public static Map<Integer,List<String>> ejercicioA(Integer varA, String varB, Integer varC, String varD, Integer varE) {
		UnaryOperator<EnteroCadena> nx = elem->
		{
			return EnteroCadena.of(elem.a()+2,
							elem.a()%3==0?
							elem.s()+elem.a().toString():
							elem.s().substring(elem.a()%elem.s().length()));
		};
		return Stream.iterate(EnteroCadena.of(varA, varB), elem -> elem.a() < varC, nx)
				.map(elem -> elem.s()+varD)
				.filter(nom->nom.length() < varE)
				.collect(Collectors.groupingBy(String::length));
	}
	
	//Iterativo
	public static Map<Integer,List<String>> iterativo(Integer varA, String varB, Integer varC, String varD, Integer varE) {
		EnteroCadena elem = EnteroCadena.of(varA, varB);
		Map<Integer, List<String>> res = new HashMap<>();
		
		while(elem.a() < varC) {
			String sumPalabra = elem.s()+varD;
			Integer contPalabra = sumPalabra.length();
			if (contPalabra<varE) {
				if(res.containsKey(contPalabra)) {
					List<String> aux = res.get(contPalabra);
					aux.add(sumPalabra);
					res.put(contPalabra, aux);
				}
				else {
					res.put(contPalabra, List2.of(sumPalabra));
				}
			}
			if (elem.a()%3==0) {
				elem = EnteroCadena.of(elem.a()+2, elem.s() + elem.a().toString());
			}
			else {
				elem = EnteroCadena.of(elem.a()+2, elem.s().substring(elem.a()%elem.s().length()));
			}
		}
		return res;
	}
	
	//Recursivo final
	public static Map<Integer,List<String>> recursivoFinal(Integer varA, String varB, Integer varC, String varD, Integer varE) {
		return recFin(varA, varB, varC, varD, varE, EnteroCadena.of(varA, varB), new HashMap<>());
	}
	
	public static Map<Integer,List<String>> recFin(Integer varA, String varB, Integer varC, String varD, Integer varE, 
			EnteroCadena elem, Map<Integer, List<String>> res) {
		if(elem.a() < varC) {
			String sumPalabra = elem.s()+varD;
			Integer contPalabra = sumPalabra.length();
			if (contPalabra<varE) {
				if(res.containsKey(contPalabra)) {
					List<String> aux = res.get(contPalabra);
					aux.add(sumPalabra);
					res.put(contPalabra, aux);
				}
				else {
					res.put(contPalabra, List2.of(sumPalabra));
				}
			}
			if (elem.a()%3==0) {
				return recFin(varA, varB, varC, varD, varE, 
						EnteroCadena.of(elem.a()+2, elem.s()+elem.a().toString()), res);
			}
			else {
				return recFin(varA, varB, varC, varD, varE, EnteroCadena.of(elem.a()+2, elem.s().substring(elem.a()%elem.s().length())), res);
			}
		}
		return res;
	}
}
