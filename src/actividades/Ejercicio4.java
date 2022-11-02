package actividades;

import java.util.HashMap;
import java.util.Map;

import us.lsi.common.IntTrio;

public class Ejercicio4 {
	//Recursivo sin memoria
	public static String recursivoSinMemoria(Integer a, Integer b, Integer c) {
		String res;
		if(a<2 && b<=2 || c<2) {
			res = "(" + a.toString() + "+" + b.toString() + "+" + c.toString() + ")";
		} else if (a<3 || b<3 && c<=3) {
			res = "(" + c.toString() + "-" + b.toString() + "-" + a.toString() + ")";
		} else if (b%a==0 &&(a%2==0 || b%3==0)) {
			res = "(" + recursivoSinMemoria(a-1,b/a,c-1) + "*" + recursivoSinMemoria(a-2,b/2,c/2) + ")";
		} else {
			res = "(" + recursivoSinMemoria(a/2,b-2,c/2) + "/" + recursivoSinMemoria(a/3,b-1,c/3) + ")";
		}
		return res;
	}
	
	//Recursivo con memoria
	public static String recursivoConMemoria (Integer a, Integer b, Integer c) {
		Map<IntTrio,String> m = new HashMap<>();
		return recursivoConMemoria(a,b,c,m);
	}
	
	private static String recursivoConMemoria (Integer a, Integer b, Integer c, Map<IntTrio,String> m) {
		IntTrio k = IntTrio.of(a,b,c);
		String res;
		
		if (m.containsKey(k)) {
			res = m.get(k);
		}
		else {
			if(a<2 && b<=2 || c<2) {
				res = "(" + a.toString() + "+" + b.toString() + "+" + c.toString() + ")";
			} else if (a<3 || b<3 && c<=3) {
				res = "(" + c.toString() + "-" + b.toString() + "-" + a.toString() + ")";
			} else if (b%a==0 &&(a%2==0 || b%3==0)) {
				res = "(" + recursivoSinMemoria(a-1,b/a,c-1) + "*" + recursivoSinMemoria(a-2,b/2,c/2) + ")";
			} else {
				res = "(" + recursivoSinMemoria(a/2,b-2,c/2) + "/" + recursivoSinMemoria(a/3,b-1,c/3) + ")";
			}
			m.put(k, res);
		}
		return res;
	}
	
	//Iterativo
	public static String iterativo(Integer a, Integer b, Integer c) {
		Map<IntTrio,String> m = new HashMap<>();
		String res;
		
		for (int i=0; i<=a; i++) {
			for(int j=0; j<=b; j++) {
				for(int k=0; k<=c; k++) {
					if(a<2 && b<=2 || c<2) {
						res = "(" + a.toString() + "+" + b.toString() + "+" + c.toString() + ")";
					} else if (a<3 || b<3 && c<=3) {
						res = "(" + c.toString() + "-" + b.toString() + "-" + a.toString() + ")";
					} else if (b%a==0 &&(a%2==0 || b%3==0)) {
						res = "(" + recursivoSinMemoria(a-1,b/a,c-1) + "*" + recursivoSinMemoria(a-2,b/2,c/2) + ")";
					} else {
						res = "(" + recursivoSinMemoria(a/2,b-2,c/2) + "/" + recursivoSinMemoria(a/3,b-1,c/3) + ")";
					}
					m.put(IntTrio.of(i,j,k), res);
				}
			}
		}
		return m.get(IntTrio.of(a,b,c));
	}
	
}
