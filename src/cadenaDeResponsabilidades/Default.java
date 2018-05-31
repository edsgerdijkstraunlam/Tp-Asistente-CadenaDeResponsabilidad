package cadenaDeResponsabilidades;

import asistente.ReceptorDeMensaje;

public class Default implements ReceptorDeMensaje {

	@Override
	public String escuchar(String msg, String usuario) {
		return "Lo siento " + usuario + ", no he podido entender el mensaje";
	}

	@Override
	public void setNext(ReceptorDeMensaje sig) {
		// TODO Auto-generated method stub

	}

	@Override
	public ReceptorDeMensaje getNext() {
		// TODO Auto-generated method stub
		return null;
	}

}
