package edsger_dijkstra_unlam.asistente.cadenaDeResponsabilidades;

import edsger_dijkstra_unlam.asistente.asistente.ReceptorDeMensaje;

public class LeyesDeLaRobotica extends ReceptorDeMensaje{
	
	
	@Override
	public String escuchar(String msg, String usuario) {
		
		
		
		if(msg.contains("leyes de robotica")||msg.contains("robotica")||
				msg.contains("leyes de rob�tica")||msg.contains("ley")){
			
			return usuario+" estas son las 3 leyes de la robotica:"+"\n1� Un robot no har� da�o a un ser humano, ni permitir� con su inacci�n que sufra da�o.\n"
					   + "2� Un robot debe cumplir las �rdenes dadas por los seres humanos, a excepci�n de aquellas que entrasen en conflicto con la primera ley.\n"
					   + "3� Un robot debe proteger su propia existencia en la medida en que esta protecci�n no entre en conflicto con la primera o con la segunda ley.";

		}
		return next.escuchar(msg,usuario);

		
	}

	
	
	
	
	
}
