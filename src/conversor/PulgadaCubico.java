package conversor;

public class PulgadaCubico {
	
	public double aCentimetroCubico(double cantidad) {
		return cantidad * 16.3871;
	}
	
	public double aMetroCubico(double cantidad){
		return cantidad*1.63871e-5;
	}
	
	public double aMilimetroCubico(double cantidad){
		return cantidad*16387.1;
	}
		
	public double aKilometroCubico(double cantidad){
		return cantidad*1.63871e-14;
	}
	
	public double aPieCubico(double cantidad){
		return cantidad*0.000578704;
	}

}
