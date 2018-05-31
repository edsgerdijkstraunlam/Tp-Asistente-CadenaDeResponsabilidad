package Test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import asistente.Asistente;

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

	}

}
