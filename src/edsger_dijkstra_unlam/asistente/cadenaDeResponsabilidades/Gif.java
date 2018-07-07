package edsger_dijkstra_unlam.asistente.cadenaDeResponsabilidades;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

import edsger_dijkstra_unlam.asistente.asistente.ReceptorDeMensaje;

public class Gif extends ReceptorDeMensaje {

	int last;
	int ini;
	int fin;
	ArrayList<String> lista = new ArrayList<String>();
	String subStringDir;

	public String getMeme(String meme) {
		meme = meme.replace(" ", "_");

		try {
			System.setProperty("java.net.useSystemProxies", "true"); // sin esto no anda en la facu

			URL url = new URL("https://giphy.com/search/" + meme);
			InputStream is = url.openStream();
			try (BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
				String line;
				while ((line = br.readLine()) != null) {
					last = line.indexOf("gifs:");

					if (last != -1) {


						while (line.contains("\"fixed_height\"")&&lista.size()<15) {

							line = line.substring(line.indexOf("\"fixed_height\"") + 25);
							fin = line.indexOf(".gif") + 4;

							subStringDir = line.substring(0, fin);
							String igip = subStringDir.substring(subStringDir.indexOf("https://") + 8,
									subStringDir.indexOf(".com"));

							lista.add(subStringDir.replace(igip, "i.giphy"));
							line = line.substring(fin);
						}

					}

				}

			}
		} catch (IOException e) {
			return null;
		}

		if (!lista.isEmpty()) {
			String direccion = lista.get((int)(Math.random()*100)%lista.size());
			lista.clear();
			return direccion;
		}

		return null;

	}

	@Override
	public String escuchar(String msg, String usuario) {

		String resp;

		if (msg.contains("gif") || msg.contains("imagen animada")) {
			if (msg.contains("sobre")) {
				String busqueda = msg.substring(msg.indexOf("sobre") + 6);
				resp = getMeme(busqueda);
				resp = (resp == null) ? "&not&" : resp;
				return "&gif_&:" + resp;
			}

			if (msg.contains("de")) {
				String busqueda = msg.substring(msg.indexOf("de") + 3);
				resp = getMeme(busqueda);
				resp = (resp == null) ? "&not&" : resp;
				return "&gif_&:" + resp;
			}
			msg = msg.replaceFirst("gif ", "");
			resp = getMeme(msg);
			resp = (resp == null) ? "&not&" : resp;
			return "&gif_&:" + resp;
		}

		return this.next.escuchar(msg, usuario);
	}


}
