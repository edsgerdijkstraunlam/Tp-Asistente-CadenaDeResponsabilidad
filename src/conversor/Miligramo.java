package conversor;

public class Miligramo {
	
	public double aGramo(double cantidad) {
		return cantidad * 0.001;
	}
	
	public double aKilo(double cantidad) {
		return cantidad * 1e-6;
	}
	
	public double aTonelada(double cantidad) {
		return cantidad * 1e-9;
	}

	
	public double aOnza(double cantidad) {
		return cantidad * 3.5274e-5;
	}

}
