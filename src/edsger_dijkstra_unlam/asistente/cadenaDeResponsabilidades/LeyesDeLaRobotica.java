package edsger_dijkstra_unlam.asistente.cadenaDeResponsabilidades;

import edsger_dijkstra_unlam.asistente.asistente.ReceptorDeMensaje;

public class LeyesDeLaRobotica implements ReceptorDeMensaje{
	private ReceptorDeMensaje next;
	
	@Override
	public String escuchar(String msg, String usuario) {
		
		
		
		if(msg.contains("leyes de robotica")||msg.contains("robotica")||
				msg.contains("leyes de robótica")||msg.contains("ley")){
			
			return usuario+" estas son las 3 leyes de la robotica:"+"\n1° Un robot no hará daño a un ser humano, ni permitirá con su inacción que sufra daño.\n"
					   + "2° Un robot debe cumplir las órdenes dadas por los seres humanos, a excepción de aquellas que entrasen en conflicto con la primera ley.\n"
					   + "3° Un robot debe proteger su propia existencia en la medida en que esta protección no entre en conflicto con la primera o con la segunda ley.";

		}
		return next.escuchar(msg,usuario);

		
	}
	@Override
	public void setNext(ReceptorDeMensaje sig) {
		this.next=sig;
		
	}
	@Override
	public ReceptorDeMensaje getNext() {
		return this.next;
	}
	 
	
	
	
	
	
}
