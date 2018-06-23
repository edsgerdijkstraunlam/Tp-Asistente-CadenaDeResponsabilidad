package edsger_dijkstra_unlam.asistente.utilitarias;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtraerEntero {
	
	public static int extraerEntero(String cadena){
		Pattern pattern = Pattern.compile("([0-9]+)", Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(cadena);
		matcher.find();
		return Integer.valueOf(matcher.group());

	}

}
