package edsger_dijkstra_unlam.asistente.asistente;

import java.util.GregorianCalendar;

import edsger_dijkstra_unlam.asistente.cadenaDeResponsabilidades.Agradecimiento;
import edsger_dijkstra_unlam.asistente.cadenaDeResponsabilidades.BusquedaEnInternet;
import edsger_dijkstra_unlam.asistente.cadenaDeResponsabilidades.Calculadora;
import edsger_dijkstra_unlam.asistente.cadenaDeResponsabilidades.ChuckNorris;
import edsger_dijkstra_unlam.asistente.cadenaDeResponsabilidades.Clima;
import edsger_dijkstra_unlam.asistente.cadenaDeResponsabilidades.ConversorDeUnidades;
import edsger_dijkstra_unlam.asistente.cadenaDeResponsabilidades.Default;
import edsger_dijkstra_unlam.asistente.cadenaDeResponsabilidades.FechayHora;
import edsger_dijkstra_unlam.asistente.cadenaDeResponsabilidades.Gif;
import edsger_dijkstra_unlam.asistente.cadenaDeResponsabilidades.LeyesDeLaRobotica;
import edsger_dijkstra_unlam.asistente.cadenaDeResponsabilidades.Meme;
import edsger_dijkstra_unlam.asistente.cadenaDeResponsabilidades.Noticias;
import edsger_dijkstra_unlam.asistente.cadenaDeResponsabilidades.NueveGag;
import edsger_dijkstra_unlam.asistente.cadenaDeResponsabilidades.Saludo;
import edsger_dijkstra_unlam.asistente.cadenaDeResponsabilidades.Youtube;

public class Asistente {

	private ReceptorDeMensaje next;

	private String nombre;
	private String usuario;

	private FechayHora fyh;
	private Calculadora calc;
	private Saludo saludo;
	private Agradecimiento agrad;
	private Clima cli;
	private Noticias noti;
	private Gif gif;
	private ChuckNorris cn;
	private LeyesDeLaRobotica lr;
	private Default def;
	private Meme meme;
	private NueveGag gag;
	private ConversorDeUnidades conversor;
	private BusquedaEnInternet wiki;
	private Youtube youtube;
	
	public Asistente(String nombre) {
		
		this.nombre = nombre;
		
		gag = new NueveGag() ;
		this.next = gag;
		
		calc = new Calculadora();
		gag.setNext(calc);

		gif= new Gif();
		calc.setNext(gif);
		
		conversor = new ConversorDeUnidades();
		gif.setNext(conversor);
		
		
		saludo = new Saludo();
		conversor.setNext(saludo);

		fyh = new FechayHora();
		saludo.setNext(fyh);

		agrad = new Agradecimiento();
		fyh.setNext(agrad);

		cli = new Clima();
		agrad.setNext(cli);

		noti = new Noticias();
		cli.setNext(noti);

		meme = new Meme();
		noti.setNext(meme);

		cn = new ChuckNorris();
		meme.setNext(cn);

		lr = new LeyesDeLaRobotica();
		cn.setNext(lr);
		
		wiki = new BusquedaEnInternet();
		lr.setNext(wiki);
		
		youtube = new Youtube();
		wiki.setNext(youtube);
		
		def = new Default();
		youtube.setNext(def);
		
	}

	public void modoPrueba(boolean prueba) {
		if (prueba) {
			GregorianCalendar gc = new GregorianCalendar(2018, 4, 03);
			fyh = new FechayHora(gc);
		} else {
			fyh = new FechayHora();
		}
		saludo.setNext(fyh);
		fyh.setNext(agrad);
	}

	public String getName() {
		return this.nombre;
	}

	public void setUsuario(String usuario) {
		this.usuario = "@" + usuario;
	}

	public String getUsuario() {
		return this.usuario;
	}

	public String escuchar(String msg) {
		return next.escuchar(msg.toLowerCase(), usuario);
	}
}