package actividades;

import java.util.stream.Stream;

public class Ejercicio2 {
	//Recursividad no Final
		public static Integer RecNoFin(Integer a, Integer b, String s) {
			Integer res = 0;
			if(s.length() == 0) {					
				res = a*a+b*b;
			} else if (a<2 || b<2) {
				res = s.length() + a + b;
			} else if(a%s.length()<b%s.length()) {
				res = a + b + RecNoFin(a-1, b/2, s.substring(a%s.length(),b%s.length()));
			} else {
				res = a * b + RecNoFin(a/2, b-1, s.substring(b%s.length(),a%s.length()));				
			}
			return res;
		}
			
	//Recursividad Final
		public static Integer RecFin(Integer a, Integer b, String s) {
			return RecFin2(a, b, s, 0);
		}
		
		
		public static Integer RecFin2(Integer a, Integer b, String s, Integer acum) {
			Integer res = 0;
			if(s.length() == 0) {					
				res = acum + a*a+b*b;
			} else if (a<2 || b<2) {
				res = acum + s.length() + a + b;
			} else if(a%s.length()<b%s.length()) {
				res = RecFin2(a-1, b/2, s.substring(a%s.length(),b%s.length()), acum+res+a+b);
			} else {
				res = RecFin2(a/2, b-1, s.substring(b%s.length(),a%s.length()), acum+res+(a*b));				
			}
			return res;
		}
		
		
		
		
		
	//Iterativo
		public static Integer iterativo(Integer a, Integer b, String s) {
			Integer res = 0;
			while(s.length() != 0 && !(a<2 || b<2)) {
				if(a%s.length()<b%s.length()) {
					res = res + a + b;
					s= s.substring(a%s.length(),b%s.length());
					a=a-1;
					b=b/2;
				} else {
					res = res + a * b;
					s= s.substring(b%s.length(),a%s.length());
					a=a/2;
					b=b-1;
				}
			}
			if(s.length() == 0) {					
				res = res + a*a+b*b;
			} else {
				res = res + s.length() + a + b;
			}
			return res;
		}
		
		//Notación Funcional
		private static record Tupla (Integer a, Integer b, String s, Integer res) {
			public static Tupla of(Integer a, Integer b, String s, Integer res) {
				return new Tupla(a, b, s, res);
			}
			public static Tupla first(Integer a, Integer b, String s) {
				return new Tupla(a, b, s, 0);
			}
			public Tupla next() {
				if (a%s.length() < b%s.length()) {
					return of(a-1, b/2, s.substring(a%s.length(),b%s.length()), res+a+b);
				} else {
					return of(a/2, b-1, s.substring(b%s.length(),a%s.length()), res+a*b);
				}
			}
		}
		
		public static Integer funcional(Integer a, Integer b, String s) {
			Tupla res= Stream.iterate(
					Tupla.first(a, b, s), elem -> elem.next())
					.filter(elem->elem.s().length() == 0 || a<2 || b<2).findFirst().get();
			if (res.s().length() == 0) {
				return res.res() + res.a() * res.a() + res.b() * res.b();
			} else {
				return res.res() + res.s().length() + res.a() + res.b();
			}
		}
}
