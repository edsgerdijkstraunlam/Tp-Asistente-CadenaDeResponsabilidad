package cadenaDeResponsabilidades;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

import asistente.ReceptorDeMensaje;

public class BusquedaEnInternet implements ReceptorDeMensaje {

	int last;
	ArrayList<String> lista = new ArrayList<String>();
	String subStringDir;
	private ReceptorDeMensaje next;

	public String obtenerEnlace(String busqueda) {
		// busqueda = busqueda;

		String texto = "";
		String acumuladorDeTexto = "";
		String fin = "";
		String direccion = "https://es.wikipedia.org/wiki/" + busqueda.replace(" ", "_");
		try {
			System.setProperty("java.net.useSystemProxies", "true"); // sin esto no anda en la facu
			System.setProperty("file.encoding", "UTF-8");
			URL url = new URL(direccion);
			InputStream is = url.openStream();
			try (BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
				String line;
				while ((line = br.readLine()) != null) {
					last = line.indexOf("<p>");

					if (last != -1) {
						line = line.substring(last + 1);
						acumuladorDeTexto = line.substring(line.indexOf(">") + 1, line.indexOf("<"));

						while (texto.length() < 500) {

							// acumuladorDeTexto = line.substring(line.indexOf(">")+1, line.indexOf("<"));
							texto = texto.concat(acumuladorDeTexto);
							fin = line.substring(line.indexOf("<") + 1, line.indexOf("<") + 3);
							line = line.substring(line.indexOf("<") + 1);
							if (fin.contains("/p"))
								break;
							acumuladorDeTexto = line.substring(line.indexOf(">") + 1, line.indexOf("<"));

						}

						return direccion.length() + "&" + direccion + texto.replaceAll("\\[[0-9]\\]", "")
								+ (!fin.contains("/p") ? "..." : "");
					}

				}

			}
		} catch (Exception e) {
			direccion = "https://www.google.com/search?q=" + busqueda.replace(" ", "+");
			return "&not&" + direccion.length() + "&" + direccion;
			// return texto;
		}

		direccion = "https://www.google.com/search?q=" + busqueda.replace(" ", "+");

		return "&not&" + direccion.length() + "&" + direccion;

	}

	@Override
	public String escuchar(String msg, String usuario) {

		boolean busca = false;
		if (msg.contains("buscar en wikipedia")) {
			msg = msg.replace("buscar en wikipedia", "");
			busca = true;
		} else if (msg.contains("buscar en internet")) {
			msg = msg.replace("buscar en internet", "");
			busca = true;
		} else if (msg.contains("buscar ")) {
			msg = msg.replace("buscar ", "");
			busca = true;
		} else if (msg.contains("buscar")) {
			msg = msg.replace("buscar", "");
			busca = true;
		} else if (msg.contains("?")) {
			busca = true;
		}

		if (busca) {
			String resp = obtenerEnlace(msg);
			if (resp.contains("&not&")) {
				String aMayus[] = msg.split(" ");
				msg = "";
				for (String palabra : aMayus) {
					char[] a = palabra.toCharArray();
					if (a[0] >= 97 && a[0] <= 122) {
						a[0] -= 32;
					}
					msg = msg.concat(String.valueOf(a) + " ");
				}
				msg = msg.substring(0, msg.length() - 1);
			}
			resp = obtenerEnlace(msg);

			return "&wiki&" + resp;
		}
		return next.escuchar(msg, usuario);
	}

	@Override
	public void setNext(ReceptorDeMensaje sig) {
		this.next = sig;

	}

	@Override
	public ReceptorDeMensaje getNext() {
		return this.next;
	}

	public static void main(String[] args) {
		BusquedaEnInternet b = new BusquedaEnInternet();
		System.out.println(b.escuchar("buscar perro", "Franco"));
	}

}
