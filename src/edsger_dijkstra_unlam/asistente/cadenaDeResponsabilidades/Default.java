package edsger_dijkstra_unlam.asistente.cadenaDeResponsabilidades;

import edsger_dijkstra_unlam.asistente.asistente.ReceptorDeMensaje;

public class Default extends ReceptorDeMensaje {

	@Override
	public String escuchar(String msg, String usuario) {
		return "Lo siento " + usuario + ", no he podido entender el mensaje";
	}


}
