package edsger_dijkstra_unlam.asistente.cadenaDeResponsabilidades;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import edsger_dijkstra_unlam.asistente.asistente.ReceptorDeMensaje;

public class Noticias implements ReceptorDeMensaje {

	private ReceptorDeMensaje next;

	public String getHora() throws IOException {

		System.setProperty("java.net.useSystemProxies", "true"); // sin esto no anda en la facu

		int last;
		int ini;
		int fin;
		String subStringHora;

		URL url = new URL("http://horaoficial.com.ar/");
		InputStream is = url.openStream();
		try (BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
			String line;
			while ((line = br.readLine()) != null) {
				last = line.indexOf("Hora oficial argentina <b><span id='cet' lah='");

				if (last != -1) {

					ini = line.lastIndexOf("</span>");
					fin = line.lastIndexOf("</span>");

					subStringHora = line.substring(ini - 8, fin);

					return ("La hora es " + subStringHora);

				}

			}

		} catch (MalformedURLException e) {
			e.printStackTrace();

		} catch (IOException e) {
			e.printStackTrace();
			throw new IOException();
		}
		return ("Error hora");

	}

	public String getDolar() throws IOException {

		System.setProperty("java.net.useSystemProxies", "true"); // sin esto no anda en la facu

		int last;
		int ini;
		int fin;
		String subStringDolar;

		URL url = new URL("https://www.precio-dolar.com.ar/");
		InputStream is = url.openStream();
		try (BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
			String line;
			while ((line = br.readLine()) != null) {
				last = line.indexOf("lar = $  ");

				if (last != -1) {

					ini = last + 9;

					fin = ini + 5;

					subStringDolar = line.substring(ini, fin);

					return ("1 Dólar = " + subStringDolar + " Pesos argentinos");

				}

			}

		} catch (MalformedURLException e) {
			e.printStackTrace();

		} catch (IOException e) {
			e.printStackTrace();
			throw new IOException();
		}
		return ("Error Dolar");

	}

	public String getNot() throws IOException {

		System.setProperty("java.net.useSystemProxies", "true"); // sin esto no anda en la facu

		int last;
		int ini;
		int fin;
		int flagPrimero = 0;
		String subStringNoticia;
		String subStringDesc = null;

		String outgoing = "";

		URL url = new URL("http://www.telam.com.ar/rss2/ultimasnoticias.xml");
		InputStream is = url.openStream();
		try (BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"))) {
			String line;
			while (flagPrimero < 4 && (line = br.readLine()) != null) {
				last = line.indexOf("<title>");

				if (last != -1) {

					if (flagPrimero == 0) {
						flagPrimero = 1;
						continue;
					} else {
						flagPrimero++;
					}

					ini = last + 7;

					fin = line.indexOf("</title>");

					subStringNoticia = line.substring(ini, fin);

					line = br.readLine();
					line = br.readLine();
					line = br.readLine();

					ini = line.indexOf("<description><![CDATA[");

					fin = line.indexOf("</description>");

					if (fin == -1) {// en algunos casos son mas de una linea

						subStringDesc = line.substring(ini + 22, line.length() - 6);

						while (fin == -1) {

							line = br.readLine();

							fin = line.indexOf("</description>");

							if (fin == -1) {

								subStringDesc.concat(line.substring(0, line.length()));
							} else {

								subStringDesc.concat(line.substring(0, fin));
							}

						}
					} else {

						subStringDesc = line.substring(ini + 22, fin - 3);
					}

					outgoing = outgoing.concat("--" + subStringNoticia + "--\n" + subStringDesc + '\n');

				}

			}

			return outgoing.replace("ldquo;", "").replace("&amp;", "").replace("rdquo;", "");
		} catch (MalformedURLException e) {
			System.out.println("error");
			e.printStackTrace();

		} catch (IOException e) {
			e.printStackTrace();
			throw new IOException();
		}

		return "Error noticias";
	}

	@Override
	public String escuchar(String msg, String usuario) {

		Noticias n = new Noticias();
		Clima c = new Clima();

		if (msg.contains("noticias")) {

			try {
				return usuario + " " + c.getClimaxPaisCiudad() + '\n' + n.getHora() + '\n' + n.getDolar() + '\n'
						+ n.getNot();

			} catch (IOException e) {
				e.printStackTrace();
			} catch (SAXException e) {
				e.printStackTrace();
			} catch (ParserConfigurationException e) {
				e.printStackTrace();
			}

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

}