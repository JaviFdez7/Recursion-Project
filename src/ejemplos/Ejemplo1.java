package ejemplos;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import us.lsi.geometria.Punto2D;
import us.lsi.geometria.Punto2D.Cuadrante;

public class Ejemplo1 {
	public static Map<Punto2D.Cuadrante,Double> funcional(List<Punto2D> ls){
		return ls.stream()
				.collect(Collectors.groupingBy(Punto2D::getCuadrante,
				Collectors.<Punto2D,Double>reducing(0.,x->x.x(),(x,y)->x+y)));
		}
	
	public static Map<Punto2D.Cuadrante,Double> iterativo(List<Punto2D> ls){
		Integer i = 0;
		Map<Cuadrante, Double> b = new HashMap<>();
		while(i<ls.size()) {
			Punto2D e = ls.get(i);
			Cuadrante c = e.getCuadrante();
			if(b.containsKey(c))
				b.put(c, b.get(c)+e.x());
			else
				b.put(c, e.x());
			i++;
			}
			return b;
		}
	
	public static Map<Punto2D.Cuadrante,Double> recursivo(List<Punto2D> ls){
		Integer i = 0;
		Map<Cuadrante, Double> b = new HashMap<>();
		
		return recursivo(i,b,ls);
		}
	
	private static Map<Punto2D.Cuadrante,Double> recursivo(Integer i, Map<Cuadrante, Double> b, List<Punto2D> ls){
		if(i<ls.size()) {
			Punto2D e = ls.get(i);
			Cuadrante c = e.getCuadrante();
			if(b.containsKey(c))
				b.put(c, b.get(c)+e.x());
			else
				b.put(c, e.x());
			b = recursivo(i+1,b,ls);
			}
			return b;
		}
}
