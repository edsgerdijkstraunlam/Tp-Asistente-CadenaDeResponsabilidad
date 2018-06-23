package edsger_dijkstra_unlam.asistente.conversor;

public class Milimetro {
	
	public double aCentimetro(double cantidad) {
		return cantidad * 0.1;
	}
	
	public double aMetro(double cantidad){
		return cantidad*0.001;
	}
	
	
	public double aKilometro(double cantidad) {
		return cantidad * 1e-6;
	}

	
	public double aPulgada(double cantidad) {
		return cantidad * 0.0393701;
	}

	
	public double aPie(double cantidad) {
		return cantidad * 0.00328084;
	}

}
