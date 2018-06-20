package conversor;

public class Metro {
	
	public double aCentimetro(double cantidad) {
		return cantidad * 100;
	}
	
	public double aMilimetro(double cantidad){
		return cantidad*1000;
	}
	
	
	public double aKilometro(double cantidad) {
		return cantidad / 1000;
	}

	
	public double aPulgada(double cantidad) {
		return cantidad * 39.3701;
	}

	
	public double aPie(double cantidad) {
		return cantidad * 3.2808;
	}

}
