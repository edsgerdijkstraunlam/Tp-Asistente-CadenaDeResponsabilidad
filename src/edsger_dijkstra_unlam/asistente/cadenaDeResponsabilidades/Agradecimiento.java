package edsger_dijkstra_unlam.asistente.cadenaDeResponsabilidades;

import edsger_dijkstra_unlam.asistente.asistente.ReceptorDeMensaje;

public class Agradecimiento extends ReceptorDeMensaje {

	private final String[] vectorAgradecimientos = {"gracias", "bien hecho", "buen trabajo","genial"};
	private final String[] vectorAgradecimientosRespuestas = {"de nada", "muchas gracias", "gracias, no hay de que","gracias"};
	
	
	
	@Override
	public String escuchar(String msg, String usuario) {

		boolean agradece=false;
		int j=0;
		
		while(!agradece&&j<vectorAgradecimientos.length) {
			if(msg.contains(vectorAgradecimientos[j]))
				agradece=true;
			j++;
		}
		
		if(agradece)
			return usuario+" "+ vectorAgradecimientosRespuestas[j-1];
		return next.escuchar(msg, usuario);
	}
	
	

	
	


}
