package edsger_dijkstra_unlam.asistente.utilitarias;


public class Funcion implements Comparable<Object>{

	private String nombre;
	private String funcion;
	
	public Funcion(String nombre, String funcion) {
		this.nombre=nombre;
		this.funcion=funcion;
	}


	
	
	public String getNombre() {
		return this.nombre;
		}
	public String getFuncion() {
		return this.funcion;
	}
	
	@Override
	public int compareTo(Object o) {
		return (this.nombre.compareTo(((Funcion)o).getNombre()));
	}
	
}
