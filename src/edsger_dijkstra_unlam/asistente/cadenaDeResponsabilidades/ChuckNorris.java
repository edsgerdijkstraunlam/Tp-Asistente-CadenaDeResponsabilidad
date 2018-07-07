package edsger_dijkstra_unlam.asistente.cadenaDeResponsabilidades;

import edsger_dijkstra_unlam.asistente.asistente.ReceptorDeMensaje;

public class ChuckNorris extends ReceptorDeMensaje{
	
	private String [] frases = {"Chuck Norris puede dividir por cero." , 
								"Chuck Norris puede encontrar el final de un circulo." , 
								"Chuck Norris puede hablar braille.",
								"Chuck Norris hace llorar a una cebolla.",
								"Cuando el apocalipsis zombie empiece, Chuck Norris no va a tratar de sobrevivir. Los zombies s�.",
								"Chuck Norris puede matar a tus amigos imaginarios.",
								"Chuck Norris puede extrangularte con un telefono inalambrico.",
								"Chuck Norris cont� hasta infinito. Dos veces.",
								"Chuck Norris puede sacar naranjas de un arbol de manzanas y hacer la mejor limonada del mundo.",
								"Chuck Norris juega a la ruleta rusa con un revolver totalmente cargado... y gana."
								} ;
	private int proximoTip = 0 ; 
	
	@Override
	public String escuchar(String msg, String usuario) {

		boolean flag = false ;
		if(msg.contains("cnf") || msg.contains("chuck norris facts") || msg.contains("chuck norris") || msg.contains("contas") || msg.contains("otro")){
			
			if(proximoTip == frases.length)
				proximoTip = 0 ;
			
			flag = true ;
			
		}
		
		if(flag){
			this.proximoTip ++ ;
			return usuario+" "+ frases[proximoTip-1];
		}
		
		return next.escuchar(msg, usuario);
	}

	
}
