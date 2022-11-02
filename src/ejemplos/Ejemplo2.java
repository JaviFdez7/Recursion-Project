package ejemplos;

import java.util.stream.Stream;

public class Ejemplo2 {
	public static String recursivoNoFinal (Integer a, Integer b) {
		String res;
		if(a<5 || b<5)
			res = String.format("(%d)", a*b);
		else
			res = String.format("(%d)", a+b) + recursivoNoFinal(a/2,b-2);
		return res;
	}
	
	public static String recursivoFinal (Integer a, Integer b) {
		String ba = "";
		return recursivoFinal(ba,a,b);	
	}
	
	private static String recursivoFinal (String ba, Integer a, Integer b) {
		String res;
		if(a<5 || b<5)
			res = ba + String.format("(%d)", a*b);
		else
			res = recursivoFinal(ba+String.format("(%d)", a+b),a/2,b-2);
		return res;
	}
	
	public static String iterativo (Integer a, Integer b) {
		String ba = "";
		while(!(a<5 || b<5)) {
			ba = ba+String.format("(%d)", a+b);
			a= a/2;
			b= b-2;
		}
		ba = ba + String.format("(%d)", a*b);
		return ba;
	}
	
	private static record TuplaEjemplo2 (String ba, Integer a, Integer b) {
		public static TuplaEjemplo2 of(String ba, Integer a, Integer b) {
			return new TuplaEjemplo2(ba, a, b);
		}
		public static TuplaEjemplo2 first(Integer a, Integer b) {
			return new TuplaEjemplo2("", a, b);
		}
		public TuplaEjemplo2 next() {
			return of(ba + String.format("%d", a+b), a/2, b-2);
		}
		public Boolean isBaseCase() {
			return a < 5 || b < 5;
		}
	}
	
	public static String funcional(Integer a, Integer b) {
		TuplaEjemplo2 elementoFinal= Stream.
				iterate(TuplaEjemplo2.first(a, b), elem -> elem.next())
				.dropWhile(elem->!elem.isBaseCase()).findFirst().get();
		return elementoFinal.ba + String.format("(%d)", elementoFinal.a*elementoFinal.b);
	}
}
