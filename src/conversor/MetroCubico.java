package conversor;

public class MetroCubico {
	
	public double aCentimetroCubico(double cantidad) {
		return cantidad * 1000000;
	}
	
	public double aMilimetroCubico(double cantidad){
		return cantidad*1000000000;
	}
	
	
	public double aKilometroCubico(double cantidad) {
		return cantidad * 1e-9;
	}

	
	public double aPulgadaCubico(double cantidad) {
		return cantidad * 61023.7;
	}

	
	public double aPieCubico(double cantidad) {
		return cantidad * 35.3147;
	}

}
