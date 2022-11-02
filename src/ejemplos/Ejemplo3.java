package ejemplos;

import java.util.HashMap;
import java.util.Map;

import us.lsi.common.IntPair;

public class Ejemplo3 {

		public static Integer recursivoSinMemoria (Integer a, Integer b) {
			Integer res;
			if (a < 2 || b < 2) {
				res = a*a +b;
			}
			else {
				res = recursivoSinMemoria(a/2, b-1) + recursivoSinMemoria(a/3,b-2);
			}
			return res;
		}
		
		
		public static Integer recursivoConMemoria (Integer a, Integer b) {
			Map<IntPair,Integer> m = new HashMap<>();
			return recursivoConMemoria(a,b,m);
		}
		
		private static Integer recursivoConMemoria (Integer a, Integer b, Map<IntPair,Integer> m) {
			IntPair k = IntPair.of(a,b);
			Integer res;
			
			if (m.containsKey(k)) {
				res = m.get(k);
			}
			else {
				if (a<2 || b<2) {
					res = a*a + b;
				}
				else {
					res = recursivoSinMemoria(a/2, b-1) + recursivoSinMemoria(a/3,b-2);
				}
				m.put(k, res);
			}
			return res;
		}
		
		public static Integer iterativo(Integer a, Integer b) {
			Map<IntPair,Integer> m = new HashMap<>();
			Integer v;
			
			for (int i=0; i<=a; i++) {
				for(int j=0; j<=b; j++) {
					if (a < 2 || b < 2) {
						v = i*i +j;
					}
					else {
						v = m.get(IntPair.of(i/2,j-1)) + m.get(IntPair.of(i/3,j-2));
					}
					m.put(IntPair.of(i,j), v);
				}
			}
			return m.get(IntPair.of(a,b));
		}
		
}
