package Test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import asistente.Asistente;

public class ChuckNorrisTest {
	Asistente jenkins;
	@Before

	public void setup() {
		jenkins = new Asistente("jenkins");
		jenkins.setUsuario("Franco");
	}
	@Test
	public void testChuckNorrisFacts(){
		
		Assert.assertEquals(jenkins.getUsuario() +" Chuck Norris puede dividir por cero.", jenkins.escuchar("Me contas un Chuck Norris Facts"));
		Assert.assertEquals(jenkins.getUsuario() +" Chuck Norris puede encontrar el final de un circulo.", jenkins.escuchar("Me contas otro"));
		Assert.assertEquals(jenkins.getUsuario() +" Chuck Norris puede hablar braille.", jenkins.escuchar("otro"));
		Assert.assertEquals(jenkins.getUsuario() +" Chuck Norris hace llorar a una cebolla.", jenkins.escuchar("contame otro"));
		Assert.assertEquals(jenkins.getUsuario() +" Cuando el apocalipsis zombie empiece, Chuck Norris no va a tratar de sobrevivir. Los zombies sí.", jenkins.escuchar("Me contas un Chuck Norris Facts"));
		Assert.assertEquals(jenkins.getUsuario() +" Chuck Norris puede matar a tus amigos imaginarios.", jenkins.escuchar("Me contas un Chuck Norris Facts"));
		Assert.assertEquals(jenkins.getUsuario() +" Chuck Norris puede extrangularte con un telefono inalambrico.", jenkins.escuchar("Me contas un Chuck Norris Facts"));
		Assert.assertEquals(jenkins.getUsuario() +" Chuck Norris contó hasta infinito. Dos veces.", jenkins.escuchar("Me contas un Chuck Norris Facts"));
		Assert.assertEquals(jenkins.getUsuario() +" Chuck Norris puede sacar naranjas de un arbol de manzanas y hacer la mejor limonada del mundo.", jenkins.escuchar("Me contas un Chuck Norris Facts"));
		Assert.assertEquals(jenkins.getUsuario() +" Chuck Norris juega a la ruleta rusa con un revolver totalmente cargado... y gana.", jenkins.escuchar("Me contas un Chuck Norris Facts"));
		Assert.assertEquals(jenkins.getUsuario() +" Chuck Norris puede dividir por cero.", jenkins.escuchar("Me contas un Chuck Norris Facts"));
	}
}
