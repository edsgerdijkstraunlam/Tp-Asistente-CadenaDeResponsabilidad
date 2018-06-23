package edsger_dijkstra_unlam.asistente.conversor;

public class Pulgada {
	
	public double aCentimetro(double cantidad) {
		return cantidad * 2.54;
	}
	
	public double aMetro(double cantidad){
		return cantidad*0.0254;
	}
	
	public double aMilimetro(double cantidad){
		return cantidad*25.4;
	}
		
	public double aKilometro(double cantidad){
		return cantidad*2.54e-5;
	}
	
	public double aPie(double cantidad){
		return cantidad*0.0833;
	}

}
