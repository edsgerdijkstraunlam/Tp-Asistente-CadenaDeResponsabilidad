package asistente;

import java.util.GregorianCalendar;

import cadenaDeResponsabilidades.Agradecimiento;
import cadenaDeResponsabilidades.Calculadora;

import cadenaDeResponsabilidades.ChuckNorris;
import cadenaDeResponsabilidades.Clima;
import cadenaDeResponsabilidades.Default;
import cadenaDeResponsabilidades.FechayHora;
import cadenaDeResponsabilidades.LeyesDeLaRobotica;
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
	private ChuckNorris cn;
	private LeyesDeLaRobotica lr;
	private Default def;

	public Asistente(String nombre) {
		this.nombre = nombre;

		calc = new Calculadora();
		this.next = calc;

		saludo = new Saludo();
		calc.setNext(saludo);

		fyh = new FechayHora();
		saludo.setNext(fyh);

		agrad = new Agradecimiento();
		fyh.setNext(agrad);

		cli = new Clima();
		agrad.setNext(cli);

		noti = new Noticias();
		cli.setNext(noti);

		cn = new ChuckNorris();
		noti.setNext(cn);

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