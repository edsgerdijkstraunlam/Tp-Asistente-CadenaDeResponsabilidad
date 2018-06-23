package edsger_dijkstra_unlam.asistente.asistente;

public interface ReceptorDeMensaje {

	public String escuchar(String msg,String usuario);	
	public void setNext(ReceptorDeMensaje sig);
	public ReceptorDeMensaje getNext();
	
	
}
