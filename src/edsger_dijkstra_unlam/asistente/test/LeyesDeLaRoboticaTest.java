package edsger_dijkstra_unlam.asistente.test;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import edsger_dijkstra_unlam.asistente.asistente.Asistente;

public class LeyesDeLaRoboticaTest {
	Asistente jenkins;

	@Before

	public void setup() {
		jenkins = new Asistente("jenkins");
		jenkins.setUsuario("Franco");
	}

	@Test
	public void testLeyes() {
		Assert.assertEquals(jenkins.getUsuario() + " estas son las 3 leyes de la robotica:"+"\n1° Un robot no hará daño a un ser humano, ni permitirá con su inacción que sufra daño.\n"
				+ "2° Un robot debe cumplir las órdenes dadas por los seres humanos, a excepción de aquellas que entrasen en conflicto con la primera ley.\n"
				+ "3° Un robot debe proteger su propia existencia en la medida en que esta protección no entre en conflicto con la primera o con la segunda ley.",
				jenkins.escuchar("Leyes"));
		Assert.assertEquals(jenkins.getUsuario() + " estas son las 3 leyes de la robotica:"+"\n1° Un robot no hará daño a un ser humano, ni permitirá con su inacción que sufra daño.\n"
				+ "2° Un robot debe cumplir las órdenes dadas por los seres humanos, a excepción de aquellas que entrasen en conflicto con la primera ley.\n"
				+ "3° Un robot debe proteger su propia existencia en la medida en que esta protección no entre en conflicto con la primera o con la segunda ley.", 
				jenkins.escuchar("robotica"));

	}

}
