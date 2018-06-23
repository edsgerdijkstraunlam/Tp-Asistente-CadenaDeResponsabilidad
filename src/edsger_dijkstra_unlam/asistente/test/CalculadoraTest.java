package edsger_dijkstra_unlam.asistente.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import edsger_dijkstra_unlam.asistente.asistente.Asistente;

public class CalculadoraTest {

	Asistente jenkins;
	@Before

	public void setup() {
		jenkins = new Asistente("jenkins");
		jenkins.setUsuario("Franco");
	}
	@Test
	public void testCalculos() {
		Assert.assertEquals(jenkins.getUsuario() +" el resultado es: 5.0", jenkins.escuchar("cuanto es 10-5"));
		Assert.assertEquals(jenkins.getUsuario() +" el resultado es: -30.0", jenkins.escuchar("cuanto es 10*(5-8)"));
		Assert.assertEquals(jenkins.getUsuario() +" el resultado es: -6.0", jenkins.escuchar("cuanto es -1-5"));
		Assert.assertEquals(jenkins.getUsuario() +" el resultado es: 10.0", jenkins.escuchar("cuanto es 3r8*5"));
		Assert.assertEquals(jenkins.getUsuario() +" el resultado es: 3.13", jenkins.escuchar("cuanto es 6.26/2"));
		Assert.assertEquals(jenkins.getUsuario() +" el resultado es: 30.00", jenkins.escuchar("cuanto es el 15% de 200"));
		Assert.assertEquals(jenkins.getUsuario() +" el resultado es: -6.0", jenkins.escuchar("cuanto es (4-8)*2 + 4 / ( 1 + 1)"));
		Assert.assertEquals(jenkins.getUsuario() +" el resultado es: 18.0", jenkins.escuchar("cuanto es (4-8)^2 + 4 / ( 1 + 1)"));

	}
	
	@Test
	public void testFunciones() {
		
		Assert.assertEquals(jenkins.getUsuario()+" se ha definido la funcion f(x)", jenkins.escuchar("definir la funcion f(x)= 3+x*9"));
		Assert.assertEquals(jenkins.getUsuario()+" se ha definido la funcion alcuadrado(x)", jenkins.escuchar("definir alcuadrado(x)=x^2"));
		Assert.assertEquals(jenkins.getUsuario()+" el resultado es 48.0", jenkins.escuchar("cuanto es f(x) en 5"));
		Assert.assertEquals(jenkins.getUsuario()+" el resultado es 81.0", jenkins.escuchar("evaluar alcuadrado(x) en 9"));
		Assert.assertEquals(jenkins.getUsuario()+" la funcion f(x) ya existe", jenkins.escuchar("definir la funcion f(x)=2*x"));
		Assert.assertEquals(jenkins.getUsuario()+" no existe la funcion g(x)", jenkins.escuchar("evaluar g(x) en 9"));
		
		
		
		
		
	}
	
	

}
