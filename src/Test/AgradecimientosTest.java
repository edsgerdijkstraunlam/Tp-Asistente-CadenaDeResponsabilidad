package Test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import asistente.Asistente;

public class AgradecimientosTest {
	Asistente jenkins;
	@Before

	public void setup() {
		jenkins = new Asistente("jenkins");
		jenkins.setUsuario("Franco");
	}
	@Test
	public void testAgradecimientos() {
		Assert.assertEquals(jenkins.getUsuario() +" de nada", jenkins.escuchar("Muchas gracias"));
		Assert.assertEquals(jenkins.getUsuario() +" de nada", jenkins.escuchar("gracias"));
		Assert.assertEquals(jenkins.getUsuario() +" gracias, no hay de que", jenkins.escuchar("Buen trabajo jenkins"));
		Assert.assertEquals(jenkins.getUsuario() +" muchas gracias", jenkins.escuchar("Bien hecho, eres genial"));
	}
}
