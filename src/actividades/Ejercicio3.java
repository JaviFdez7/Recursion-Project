package actividades;

import java.util.Iterator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

import us.lsi.common.List2;
import us.lsi.geometria.Punto2D;
import us.lsi.geometria.Punto2D.Cuadrante;
import us.lsi.streams.Stream2;

public class Ejercicio3 {
	
	public static Iterator<Punto2D> Iterador (String fichero) {
		Function <String, Punto2D> parse = elem -> {
			String[] x = elem.split(",");
			return Punto2D.of(Double.valueOf(x[0]), Double.valueOf(x[1]));
		};	
		return Stream2.file(fichero).map(parse).iterator();
	}
	
	//Iterativo
	public static List <Punto2D> Iterativo (String fichero1, String fichero2){
		Iterator<Punto2D> f1 = Iterador(fichero1);
		Iterator<Punto2D> f2 = Iterador(fichero2);
		
		List<Punto2D> res = List2.empty();
		
		Punto2D p1 = f1.next();
		Punto2D p2 = f2.next();
		
		while (f1.hasNext()) {
			if(!(p1.getCuadrante() == Cuadrante.PRIMER_CUADRANTE || p1.getCuadrante() == Cuadrante.TERCER_CUADRANTE)) {
				p1 = f1.next();
			} else if (f2.hasNext()) {
				if (!(p2.getCuadrante() == Cuadrante.PRIMER_CUADRANTE || p2.getCuadrante() == Cuadrante.TERCER_CUADRANTE)) {
					p2 = f2.next();
				} else if (p1.compareTo(p2) == -1) {
					res.add(p1);
					p1 = f1.next();
				} else {
					res.add(p2);
					p2 = f2.next();
				}
			} else if (p2.getCuadrante() == Cuadrante.PRIMER_CUADRANTE || p2.getCuadrante() == Cuadrante.TERCER_CUADRANTE) {
				res.add(p2);
			} else {
				res.add(p1);
				p1 = f1.next();
			}
		}
		
		while (f2.hasNext()) {
			if (p2.getCuadrante() == Cuadrante.PRIMER_CUADRANTE || p2.getCuadrante() == Cuadrante.TERCER_CUADRANTE) {
				res.add(p2);
			} 
			p2 = f2.next();
		}
		
		if (p1.getCuadrante() == Cuadrante.PRIMER_CUADRANTE || p1.getCuadrante() == Cuadrante.TERCER_CUADRANTE) {
			res.add(p1);
		} else if (p2.getCuadrante() == Cuadrante.PRIMER_CUADRANTE || p2.getCuadrante() == Cuadrante.TERCER_CUADRANTE) {
			res.add(p2);
		}
		return res;
	}
	
	
	//Recursivo final
	public static List<Punto2D> RecFin(String fichero1, String fichero2) {
		Iterator<Punto2D> f1 = Iterador(fichero1);
		Iterator<Punto2D> f2 = Iterador(fichero2);
		
		Punto2D p1 = f1.next();
		Punto2D p2 = f2.next();
		
		return RecFin2(fichero1, fichero2, f1, f2, p1, p2, List2.empty());
	}
	
	
	public static List<Punto2D> RecFin2(String fichero1, String fichero2, Iterator<Punto2D> f1, 
			Iterator<Punto2D> f2, Punto2D p1, Punto2D p2, List<Punto2D> res) {
		
		if (f1.hasNext()) {
			if (!(p1.getCuadrante() == Cuadrante.PRIMER_CUADRANTE || p1.getCuadrante() == Cuadrante.TERCER_CUADRANTE)) {
				res = RecFin2(fichero1, fichero2, f1, f2, f1.next(), p2, res);
			} else if (f2.hasNext()) {
				if (!(p2.getCuadrante() == Cuadrante.PRIMER_CUADRANTE || p2.getCuadrante() == Cuadrante.TERCER_CUADRANTE)) {
					res = RecFin2(fichero1, fichero2, f1, f2, p1, f2.next(), res);
				} else if (p1.compareTo(p2) == -1) {
					res.add(p1);
					res = RecFin2(fichero1, fichero2, f1, f2, f1.next(), p2, res);
				} else {
					res.add(p2);
					res = RecFin2(fichero1, fichero2, f1, f2, p1, f2.next(), res);
				}
			} else if (p2.getCuadrante() == Cuadrante.PRIMER_CUADRANTE || p2.getCuadrante() == Cuadrante.TERCER_CUADRANTE) {
				res.add(p2);
			} else {
				res.add(p1);
				res = RecFin2(fichero1, fichero2, f1, f2, f1.next(), p2, res);
			}
		} else if (f2.hasNext()) {
			if (p2.getCuadrante() == Cuadrante.PRIMER_CUADRANTE || p2.getCuadrante() == Cuadrante.TERCER_CUADRANTE) {
				res.add(p2);
			}
			res = RecFin2(fichero1, fichero2, f1, f2, p1, f2.next(), res);
		} else if (p1.getCuadrante() == Cuadrante.PRIMER_CUADRANTE || p1.getCuadrante() == Cuadrante.TERCER_CUADRANTE) {
			res.add(p1);
		} else if (p2.getCuadrante() == Cuadrante.PRIMER_CUADRANTE || p2.getCuadrante() == Cuadrante.TERCER_CUADRANTE) {
			res.add(p2);
		}
		
		return res;
	}
	
	
	//Funcional
	public static List<Punto2D> Funcional(String fichero1, String fichero2) {
		List<Punto2D> res = List2.empty();
		
		Stream.of(Iterador(fichero1), Iterador(fichero2)).iterator()
				.forEachRemaining(elem -> {
					elem.forEachRemaining(x -> {
						res.add(x);
					});
				});	
		return res.stream().filter(elem -> elem.getCuadrante() == Cuadrante.PRIMER_CUADRANTE || elem.getCuadrante() == Cuadrante.TERCER_CUADRANTE)
				.sorted().toList();
		}
}
