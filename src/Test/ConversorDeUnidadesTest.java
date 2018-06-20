package Test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import asistente.Asistente;

public class ConversorDeUnidadesTest {
	Asistente jenkins;
	@Before

	public void setup() {
		jenkins = new Asistente("jenkins");
		jenkins.setUsuario("Franco");
	}
	@Test
	public void testConversor(){
		Assert.assertEquals(jenkins.getUsuario() +" 10 centimetro equivale a 100 milimetro", jenkins.escuchar("@jenkins cuantos milimetros son 10 centimetros"));
		Assert.assertEquals(jenkins.getUsuario() +" 100 centimetro equivale a 1 metro", jenkins.escuchar("@jenkins cuantos metros son 100 centimetros"));
		Assert.assertEquals(jenkins.getUsuario() +" 2 metro equivale a 6.56 pie", jenkins.escuchar("@jenkins cuantos pie son 2 metros"));
		Assert.assertEquals(jenkins.getUsuario() +" 2 metro equivale a 78.74 pulgada", jenkins.escuchar("@jenkins cuantas pulgadas son 2 metros"));
	}

}
