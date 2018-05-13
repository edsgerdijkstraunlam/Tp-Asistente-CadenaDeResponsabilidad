package Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import asistente.Asistente;

public class AsistenteTest {

	Asistente jenkins;
	DateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
	DateFormat formatoHora = new SimpleDateFormat("HH:mm");

	@Before

	public void setup() {
		jenkins = new Asistente("jenkins");
		jenkins.setUsuario("Franco");
	}

	@Test
	public void testSaludo() {
		Assert.assertEquals("Hola "+jenkins.getUsuario(), jenkins.escuchar("Hola jenkins"));
		Assert.assertEquals("Buenos dias "+jenkins.getUsuario(), jenkins.escuchar("buenos dias jenkins"));
		Assert.assertEquals("Lo siento "+jenkins.getUsuario()+", no he podido ententender el mensaje", jenkins.escuchar("jenkins"));
		Assert.assertEquals("Buenas noches "+ jenkins.getUsuario(), jenkins.escuchar("Buenas noches jenkins"));
		Assert.assertEquals("Buenas tardes "+jenkins.getUsuario(), jenkins.escuchar("buenas tardes jenkins"));
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

	@Test

	public void testFecha() {
		Assert.assertEquals(jenkins.getUsuario() +" hoy es " + formatoFecha.format(new GregorianCalendar().getTime()),
				jenkins.escuchar("que dia es hoy?"));
		Assert.assertEquals(jenkins.getUsuario() +" son las " + formatoHora.format(new GregorianCalendar().getTime()),
				jenkins.escuchar("que hora es?"));
		Assert.assertEquals(jenkins.getUsuario() +" hoy es jueves", jenkins.escuchar("que dia de la semana es hoy?"));
		Assert.assertEquals(jenkins.getUsuario() +" dentro de 10 días será 13/05/2018",
				jenkins.escuchar("que dia sera dentro de 10 dias?"));
		Assert.assertEquals(jenkins.getUsuario() +" hace 2 días fue 01/05/2018", jenkins.escuchar("que dia fue hace 2 dias?"));
		Assert.assertEquals(jenkins.getUsuario() +" hace 2 meses fue 03/03/2018", jenkins.escuchar("que dia fue hace 2 meses?"));
		Assert.assertEquals(jenkins.getUsuario() +" hace 2 años fue 03/05/2016", jenkins.escuchar("que dia fue hace 2 años?"));
		Assert.assertEquals(jenkins.getUsuario() +" dentro de 2 años será 03/05/2020",
				jenkins.escuchar("que dia sera dentro de 2 años?"));
		Assert.assertEquals(jenkins.getUsuario() +" dentro de 2 meses será 03/07/2018",
				jenkins.escuchar("que dia sera dentro de 2 meses?"));
		Assert.assertEquals(jenkins.getUsuario() +" pasaron 2 días",
				jenkins.escuchar("@jenkins cuántos días pasaron desde el 1 de mayo de 2018?"));
		Assert.assertEquals(jenkins.getUsuario() +" pasaron 4 meses",
				jenkins.escuchar("@jenkins cuántos meses pasaron desde el 1 de enero de 2018?"));
		Assert.assertEquals(jenkins.getUsuario() +" pasaron 2 años",
				jenkins.escuchar("@jenkins cuántos años pasaron desde el 1 de enero de 2016?"));
	}

	@Test
	public void testAgradecimientos() {
		Assert.assertEquals(jenkins.getUsuario() +" de nada", jenkins.escuchar("Muchas gracias"));
		Assert.assertEquals(jenkins.getUsuario() +" de nada", jenkins.escuchar("gracias"));
		Assert.assertEquals(jenkins.getUsuario() +" gracias, no hay de que", jenkins.escuchar("Buen trabajo jenkins"));
		Assert.assertEquals(jenkins.getUsuario() +" muchas gracias", jenkins.escuchar("Bien hecho, eres genial"));
	}

}
