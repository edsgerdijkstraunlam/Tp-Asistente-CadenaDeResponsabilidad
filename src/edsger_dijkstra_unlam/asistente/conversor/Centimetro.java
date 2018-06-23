package edsger_dijkstra_unlam.asistente.conversor;

public class Centimetro {
	
	public double aMetro(double cantidad){
		return cantidad/100;
	}
	
	public double aMilimetro(double cantidad){
		return cantidad*10;
	}
		
	public double aKilometro(double cantidad){
		return cantidad*1E-5;
	}
	
	public double aPulgada(double cantidad){
		return cantidad*0.3937;
	}
	
	public double aPie(double cantidad){
		return cantidad*0.0328;
	}

}
