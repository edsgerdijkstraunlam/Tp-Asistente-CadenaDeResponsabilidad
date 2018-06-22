package conversor;

public class MilimetroCubico {
	
	public double aCentimetroCubico(double cantidad) {
		return cantidad * 0.001;
	}
	
	public double aMetroCubico(double cantidad){
		return cantidad*1e-9;
	}
	
	
	public double aKilometroCubico(double cantidad) {
		return cantidad * 1e-18;
	}

	
	public double aPulgadaCubico(double cantidad) {
		return cantidad * 6.10237e-5;
	}

	
	public double aPieCubico(double cantidad) {
		return cantidad * 3.53147e-8;
	}

}
