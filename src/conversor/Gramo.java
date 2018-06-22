package conversor;

public class Gramo {
	
	public double aMiligramo(double cantidad) {
		return cantidad * 1000;
	}
	
	public double aKilo(double cantidad) {
		return cantidad * 0.001;
	}
	
	public double aTonelada(double cantidad) {
		return cantidad * 1e-6;
	}

	
	public double aOnza(double cantidad) {
		return cantidad * 0.035274;
	}

}
