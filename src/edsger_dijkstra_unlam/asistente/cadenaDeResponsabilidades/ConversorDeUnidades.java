package edsger_dijkstra_unlam.asistente.cadenaDeResponsabilidades;

import edsger_dijkstra_unlam.asistente.asistente.ReceptorDeMensaje;
import edsger_dijkstra_unlam.asistente.conversor.ConversionesDeUnidades;

public class ConversorDeUnidades implements ReceptorDeMensaje {
	
	private String[] unidades = {"kilo", "gramo", "miligramo", "kilometro", "metro", "centimetro", "milimetro", 
			"pie","pulgada","hora", "minuto", "segundo", "onza"};
	private ReceptorDeMensaje next;

	@Override
	public String escuchar(String msg, String usuario) {
		String resp="";
		for(String unidad : unidades){
			if(msg.toLowerCase().contains(unidad)) {
				try {
					resp=ConversionesDeUnidades.convertido(msg) ;
				}catch(Exception e) {
					return next.escuchar(msg, usuario);
					}
				return usuario + " " + resp ;
			}
		}
		return next.escuchar(msg, usuario);
	}

	@Override
	public void setNext(ReceptorDeMensaje sig) {
		this.next = sig;
		
	}

	@Override
	public ReceptorDeMensaje getNext() {
		return this.next;
	}

}
