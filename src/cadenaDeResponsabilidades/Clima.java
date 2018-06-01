package cadenaDeResponsabilidades;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import asistente.ReceptorDeMensaje;

public class Clima implements ReceptorDeMensaje {

	private ReceptorDeMensaje next;

	public String getClimaxPaisCiudad() throws IOException, SAXException, ParserConfigurationException {

		System.setProperty("java.net.useSystemProxies", "true"); // sin esto no anda en la facu

		URL url = new URL("http://api.wunderground.com/api/7a285327b21de2f4/conditions/lang:SP/q/autoip/.xml");

		// autoip AutoIP address location
		// autoip.json?geo_ip=38.102.136.138 specific IP address location

		InputStream is = url.openStream();

		DocumentBuilderFactory docbuildFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docbuildFactory.newDocumentBuilder();
		Document document = docBuilder.parse(is);

		document.getDocumentElement().normalize();

		Element element = document.getDocumentElement();

		return ("El clima en " + element.getElementsByTagName("full").item(0).getTextContent() + " es "
				+ element.getElementsByTagName("weather").item(0).getTextContent().toLowerCase()
				+ " con una temperatura de " + element.getElementsByTagName("temp_c").item(0).getTextContent()
				+ "Cº y humedad relativa del "
				+ element.getElementsByTagName("relative_humidity").item(0).getTextContent());

	}

	public String getClimaxPaisCiudad(String paisIn, String ciudadIn)
			throws IOException, SAXException, ParserConfigurationException {

		System.setProperty("java.net.useSystemProxies", "true"); // sin esto no anda en la facu

		ciudadIn = ciudadIn.trim();
		paisIn = paisIn.trim();

		ciudadIn = ciudadIn.replaceAll(" ", "_").toLowerCase();
		paisIn = paisIn.replaceAll(" ", "_").toLowerCase();

		// System.out.println(ciudadIn + " "+ paisIn);

		URL url = new URL("http://api.wunderground.com/api/7a285327b21de2f4/conditions/lang:SP/q/" + paisIn + '/'
				+ ciudadIn + ".xml");
		InputStream is = url.openStream();

		DocumentBuilderFactory docbuildFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docbuildFactory.newDocumentBuilder();
		Document document = docBuilder.parse(is);

		document.getDocumentElement().normalize();

		Element element = document.getDocumentElement();

		if (element.getElementsByTagName("full").item(0) == null) {
			return "Clima no encontrado :(";
		}

		return ("El clima en " + element.getElementsByTagName("full").item(0).getTextContent() + " es "
				+ element.getElementsByTagName("weather").item(0).getTextContent().toLowerCase()
				+ " con una temperatura de " + element.getElementsByTagName("temp_c").item(0).getTextContent()
				+ "Cº y humedad relativa del "
				+ element.getElementsByTagName("relative_humidity").item(0).getTextContent());

	}

	@Override
	public String escuchar(String msg, String usuario) {

		Clima c = new Clima();

		if (msg.contains("clima") && !(msg.contains("de") || msg.contains("en"))) {

			try {
				return usuario + " " + c.getClimaxPaisCiudad();

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SAXException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ParserConfigurationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		if (msg.contains("clima") && (msg.contains("de") || msg.contains("en"))) {

			// tomo como input valido "clima de <ciudad>,<pais>"

			String pais;
			String ciudad;
			String trimed;
			int startDe;

			startDe = msg.indexOf("de");

			if (startDe == -1) {
				startDe = msg.indexOf("en");
			}

			trimed = msg.substring(startDe + 2);
			
			if (trimed.contains(",")) {
				String[] partes = trimed.split(",");
				ciudad = partes[0];
				pais = partes[1];
			} else {
				pais = trimed;
				ciudad = " ";
			}
			
			try {
				return usuario + " " + c.getClimaxPaisCiudad(pais, ciudad);

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SAXException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ParserConfigurationException e) {
				// TODO Auto-generated catch block
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
