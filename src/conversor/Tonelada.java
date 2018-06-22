package conversor;

public class Tonelada {
	
	public double aKilo(double cantidad) {
		return cantidad * 1000;
	}
	
	public double aGramo(double cantidad) {
		return cantidad * 1000000;
	}
	
	public double aMiligramo(double cantidad) {
		return cantidad * 1e+9;
	}
	
	public double aOnza(double cantidad) {
		return cantidad * 35274;
	}

}
