package conversor;

public class KilometroCubico {
	
	public double aMetroCubico(double cantidad){
		return cantidad*1e+9;
	}
	
	public double aCentimetroCubico(double cantidad) {
		return cantidad * 1e+15;
	}
	
	public double aMilimetroCubico(double cantidad){
		return cantidad*1e+18;
	}
	
	
	public double aPulgadaCubico(double cantidad) {
		return cantidad * 6.102e+13;
	}

	
	public double aPieCubico(double cantidad) {
		return cantidad * 3.531e+10;
	}

}
