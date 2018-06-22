package conversor;

public class Kilometro {
	
	public double aMetro(double cantidad){
		return cantidad*1000;
	}
	
	public double aCentimetro(double cantidad) {
		return cantidad * 100000;
	}
	
	public double aMilimetro(double cantidad){
		return cantidad*1000000;
	}
	
	
	public double aPulgada(double cantidad) {
		return cantidad * 39370.1;
	}

	
	public double aPie(double cantidad) {
		return cantidad * 3280.84;
	}

}
