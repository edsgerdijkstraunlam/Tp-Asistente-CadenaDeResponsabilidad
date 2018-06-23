package edsger_dijkstra_unlam.asistente.test;

import org.junit.Before;
import org.junit.Test;

import edsger_dijkstra_unlam.asistente.asistente.Asistente;

import org.junit.Assert;

public class MemeTest {

	
	Asistente jenkins;
	
	@Before
	
	public void setup() {
		jenkins= new Asistente("Jenkins");
		jenkins.setUsuario("Franco");
	}
	
	
	
	@Test
	public void testMemes() {

		


		Assert.assertEquals("&meme:take_my_money.jpg", jenkins.escuchar("take my money"));
		Assert.assertEquals("&meme:its_a_trap.jpg", jenkins.escuchar("its a trap"));
		Assert.assertEquals("&meme:komo_lo_zupo.jpg", jenkins.escuchar("como lo supo"));
		Assert.assertEquals("&meme:komo_lo_zupo.jpg", jenkins.escuchar("komo lo zupo"));
		
		Assert.assertEquals("&meme:not_bad.jpg", jenkins.escuchar("meme de not bad"));
		Assert.assertEquals("&meme:vamo_a_calmarno.jpg", jenkins.escuchar("vamo a calmarno"));
		Assert.assertEquals("&meme:fuck_yea.jpg", jenkins.escuchar("fuck yea"));
		Assert.assertEquals("&meme:novio_distraido.jpg", jenkins.escuchar("novio distraido"));
		Assert.assertEquals("&meme:cant.jpg", jenkins.escuchar("cant "));
		Assert.assertEquals("&meme:cant.jpg", jenkins.escuchar("can't"));
		Assert.assertEquals("&meme:what.jpg", jenkins.escuchar("cuando todo funciona como deberia (???)"));
		Assert.assertEquals("&meme:not_so_simply.jpg", jenkins.escuchar("so simply"));
		Assert.assertEquals("&meme:simpsons.jpg", jenkins.escuchar("simpsons"));
		Assert.assertEquals("&meme:veo_gente_muerta.jpg", jenkins.escuchar("veo gente muerta"));
		Assert.assertEquals("&meme:memes_everywhere.jpg", jenkins.escuchar("memes everywhere"));
		Assert.assertEquals("&meme:aliens.jpg", jenkins.escuchar("aliens"));
		Assert.assertEquals("&meme:bad_luck_brian.jpg", jenkins.escuchar("bad luck"));
		Assert.assertEquals(jenkins.getUsuario()+" estos son los memes disponibles:\n"
				+ "1)take my money\n"
				+ "2)it's a trap\n"
				+ "3)komo lo zupo\n"
				+ "4)not bad\n"
				+ "5)vamo a calmarno\n"
				+ "6)fuck yea\n"
				+ "7)novio distraido\n"
				+ "8)they can't\n"
				+ "9)???\n"
				+ "10)bad luck brian\n"
				+ "11)it's not so simply\n"
				+ "12)veo gente muerta\n"
				+ "13)los simpsons\n"
				+ "14)aliens\n"
				+ "15)everywhere", jenkins.escuchar("dame una lista de los memes disponibles"));
		
		
		
		
		
		
	}

}
