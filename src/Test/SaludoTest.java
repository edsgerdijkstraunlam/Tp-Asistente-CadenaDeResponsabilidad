package Test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import asistente.Asistente;

public class SaludoTest {

	Asistente jenkins;
	@Before

	public void setup() {
		jenkins = new Asistente("jenkins");
		jenkins.setUsuario("Franco");
	}
	@Test
	public void testSaludo() {
		Assert.assertEquals("Hola "+jenkins.getUsuario(), jenkins.escuchar("Hola jenkins"));
		Assert.assertEquals("Buenos dias "+jenkins.getUsuario(), jenkins.escuchar("buenos dias jenkins"));
		Assert.assertEquals("Lo siento "+jenkins.getUsuario()+", no he podido entender el mensaje", jenkins.escuchar("jenkins"));
		Assert.assertEquals("Buenas noches "+ jenkins.getUsuario(), jenkins.escuchar("Buenas noches jenkins"));
		Assert.assertEquals("Buenas tardes "+jenkins.getUsuario(), jenkins.escuchar("buenas tardes jenkins"));
	}


}
