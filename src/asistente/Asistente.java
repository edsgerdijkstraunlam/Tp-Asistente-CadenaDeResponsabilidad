package asistente;

import java.util.GregorianCalendar;

import cadenaDeResponsabilidades.Agradecimiento;
import cadenaDeResponsabilidades.Calculadora;

import cadenaDeResponsabilidades.ChuckNorris;
import cadenaDeResponsabilidades.Clima;
import cadenaDeResponsabilidades.Default;
import cadenaDeResponsabilidades.FechayHora;
import cadenaDeResponsabilidades.Gif;
import cadenaDeResponsabilidades.LeyesDeLaRobotica;
import cadenaDeResponsabilidades.Meme;
import cadenaDeResponsabilidades.Noticias;
import cadenaDeResponsabilidades.Saludo;

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

	public Asistente(String nombre) {
		this.nombre = nombre;

		calc = new Calculadora();
		this.next = calc;

		gif= new Gif();
		calc.setNext(gif);
		
		saludo = new Saludo();
		gif.setNext(saludo);

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

		def = new Default();
		lr.setNext(def);
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