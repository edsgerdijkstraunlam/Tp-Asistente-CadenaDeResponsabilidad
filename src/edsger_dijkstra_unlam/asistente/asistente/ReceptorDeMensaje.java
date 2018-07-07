package edsger_dijkstra_unlam.asistente.asistente;

public abstract class ReceptorDeMensaje {

	protected ReceptorDeMensaje next;
	
	public abstract String escuchar(String msg,String usuario);	
	
	public final void setNext(ReceptorDeMensaje sig) {
			this.next=sig;
	};
	public final ReceptorDeMensaje getNext() {
		return this.next;
	};
	
	
}
