package edsger_dijkstra_unlam.asistente.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import edsger_dijkstra_unlam.asistente.asistente.Asistente;

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
		Assert.assertEquals(jenkins.getUsuario() +" 2 pie equivale a 0.61 metro", jenkins.escuchar("@jenkins cuantas metros son 2 pies"));
		Assert.assertEquals(jenkins.getUsuario() +" 2 kilo equivale a 2000 gramo", jenkins.escuchar("@jenkins cuantas gramos son 2 kilos"));
		Assert.assertEquals(jenkins.getUsuario() +" 2000 gramo equivale a 2 kilo", jenkins.escuchar("@jenkins cuantas kilos son 2000 gramos"));
		Assert.assertEquals(jenkins.getUsuario() +" 60 onza equivale a 1700.97 gramo", jenkins.escuchar("@jenkins cuantos gramos son 60 onzas"));
		Assert.assertEquals(jenkins.getUsuario() +" 2 centimetro cúbico equivale a 2000 milimetro cúbico", jenkins.escuchar("@jenkins cuantos milimetros cúbicos son 2 centimetros cúbicos"));
		Assert.assertEquals(jenkins.getUsuario() +" 6 metro cúbico equivale a 211.89 pie cúbico", jenkins.escuchar("@jenkins cuantos pie cúbicos son 6 metros cúbicos"));
		Assert.assertEquals(jenkins.getUsuario() +" 2 hora equivale a 120 minuto", jenkins.escuchar("@jenkins cuantos minutos son 2 horas"));
		Assert.assertEquals(jenkins.getUsuario() +" 400 minuto equivale a 6.67 hora", jenkins.escuchar("@jenkins cuantos horas son 400 minutos"));
		Assert.assertEquals(jenkins.getUsuario() +" 3600 segundo equivale a 1 hora", jenkins.escuchar("@jenkins cuantos horas son 3600 segundos"));
		Assert.assertEquals(jenkins.getUsuario() +" 60 hora equivale a 216000 segundo", jenkins.escuchar("@jenkins cuantos segundos son 60 horas"));
	}

}
