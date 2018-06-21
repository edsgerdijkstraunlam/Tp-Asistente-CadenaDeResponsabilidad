package cadenaDeResponsabilidades;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

import asistente.ReceptorDeMensaje;

public class NueveGag implements ReceptorDeMensaje{
	
	int last;
	int ini;
	int fin;
	ArrayList<String> lista = new ArrayList<String>();
	String []categorias = {"starwars","pokemon","cute","gaming","relationship","politics","wtf","superhero","science","comic"};	
	String subStringDir;
	private ReceptorDeMensaje next ;
	
	public String getImagen() {
		
		try {
			
			System.setProperty("java.net.useSystemProxies", "true"); // sin esto no anda en la facu
			int categoriaRandom = (int)(Math.random()*categorias.length) ;
			URL url = new URL("https://9gag.com/"+categorias[categoriaRandom]);
			InputStream is = url.openStream();
			
			try (BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
				
				String line;
				while ((line = br.readLine()) != null) {
					
					last = line.indexOf("\"data\":");
					
					if (last != -1) {

						while (line.contains("\"type\":\"Photo\"") ){

							line = line.substring(line.indexOf("\"type\":\"Photo\""));
							fin = line.indexOf(".jpg") + 4;
							int principio = line.indexOf("\"url\":\"");
							subStringDir = line.substring(principio+7, fin);
							
							//subStringDir = subStringDir.replace("\\", "") ;
							System.out.println(subStringDir);
							lista.add(subStringDir);
							line = line.substring(fin);
						}

					}

				}

			}
		} catch (IOException e) {
			
			return null;
		}

		if (!lista.isEmpty()) {
			
			String direccion = lista.get((int)(Math.random()*lista.size()));
			lista.clear();
			return direccion;
		}

		return null;
	}
	
	
	@Override
	public String escuchar(String msg, String usuario) {
		
		String resp;

		if (msg.contains("9gag")) {
			resp = getImagen() ;
			return "&9gag&:" + resp ;
		}

		return this.next.escuchar(msg, usuario);
	}

	@Override
	public void setNext(ReceptorDeMensaje sig) {
		this.next = sig;
	}

	@Override
	public ReceptorDeMensaje getNext() {
		return this.next ;
	}

}
