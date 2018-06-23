package edsger_dijkstra_unlam.asistente.conversor;

public class Pie {
	
	public double aCentimetro(double cantidad) {
		return cantidad * 30.48;
	}
	
	public double aMetro(double cantidad){
		return cantidad*0.3048;
	}
	
	public double aMilimetro(double cantidad){
		return cantidad*304.8;
	}
		
	public double aKilometro(double cantidad){
		return cantidad*0.0003048;
	}
	
	public double aPulgada(double cantidad){
		return cantidad*12;
	}

}
