package asistente;

import cadenaDeResponsabilidades.Agradecimiento;
import cadenaDeResponsabilidades.Calculadora;

import cadenaDeResponsabilidades.ChuckNorris;
import cadenaDeResponsabilidades.Default;
import cadenaDeResponsabilidades.FechayHora;
import cadenaDeResponsabilidades.Saludo;

public class Asistente {

	private ReceptorDeMensaje next;

	private String nombre;
	private String usuario;

	public Asistente(String nombre) {
		this.nombre = nombre;

		Calculadora calc = new Calculadora();
		this.next = calc;

		Saludo saludo = new Saludo();
		calc.setNext(saludo);

		FechayHora fyh = new FechayHora();
		saludo.setNext(fyh);

		Agradecimiento agrad = new Agradecimiento();
		fyh.setNext(agrad);

		ChuckNorris cn = new ChuckNorris();
		agrad.setNext(cn);

		Default def = new Default();
		cn.setNext(def);
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