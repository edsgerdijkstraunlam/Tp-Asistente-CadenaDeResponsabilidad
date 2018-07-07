package edsger_dijkstra_unlam.asistente.cadenaDeResponsabilidades;

import edsger_dijkstra_unlam.asistente.asistente.ReceptorDeMensaje;

public class Saludo extends ReceptorDeMensaje{
	private final String[] vectorSaludos = new String[] { "Hola","Buen dia", "Buen d�a", "Buenos dias", "Buenos d�as", "Buenas tardes",
			"Buenas noches", "Chau","Adios","Hasta pronto" };

	@Override
	public String escuchar(String msg, String usuario) {
		
		int i=0;
		boolean haySaludo=false;
		
		while (!haySaludo && i < vectorSaludos.length) {
			if (msg.contains(vectorSaludos[i].toLowerCase()))
				haySaludo = true;
			i++;
		}
		if(haySaludo)
			return vectorSaludos[i-1]+" "+ usuario;
		
		return next.escuchar(msg, usuario);
	}

	
	
	
	
	
	
	
}
