package cadenaDeResponsabilidades;

import asistente.ReceptorDeMensaje;
import conversor.ConversionesDeUnidades;

public class ConversorDeUnidades implements ReceptorDeMensaje {
	
	private String[] unidades = {"kilo", "gramo", "miligramo", "Kilometro", "metro", "centimetro", "milimetro", 
			"pie","pulgada","hora", "minuto", "segundo"};
	private ReceptorDeMensaje next;

	@Override
	public String escuchar(String msg, String usuario) {
		
		for(String unidad : unidades){
			if(msg.toLowerCase().contains(unidad))
				return usuario + " " + ConversionesDeUnidades.convertido(msg) ;
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
