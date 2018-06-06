package Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import asistente.Asistente;

public class FechaYHoraTest {
	Asistente jenkins;
	DateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
	DateFormat formatoHora = new SimpleDateFormat("HH:mm");
	
	@Before

	public void setup() {
		
		
		
		jenkins = new Asistente("jenkins");
		jenkins.modoPrueba(true);
		jenkins.setUsuario("Franco");
	}

	@Test

	public void testFecha() {
		Assert.assertEquals(jenkins.getUsuario() +" hoy es 03/05/2018" ,
				jenkins.escuchar("que dia es hoy?"));
		Assert.assertEquals(jenkins.getUsuario() +" son las 00:00",
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

}
