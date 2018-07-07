package edsger_dijkstra_unlam.asistente.cadenaDeResponsabilidades;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

import edsger_dijkstra_unlam.asistente.asistente.ReceptorDeMensaje;

public class Youtube extends ReceptorDeMensaje{

	
	
	
	
	
	
	int last;
	ArrayList<String> lista = new ArrayList<String>();
	String subStringDir;

	public String obtenerEnlace(String busqueda){
		
		//FileWriter f= new FileWriter(new File("arch.txt"));
	

		String acumuladorDeTexto = "";
		
		String direccion = "https://www.youtube.com/results?search_query=" + busqueda.replace(" ", "+");
		
		try {
			System.setProperty("java.net.useSystemProxies", "true"); // sin esto no anda en la facu
			//System.setProperty("file.encoding", "UTF-8");
			URL url = new URL(direccion);
			InputStream is = url.openStream();
			try (BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
				String line;
				while ((line = br.readLine()) != null) {
				//f.append(line);
					last = line.indexOf("data-context-item-id=");

					if (last!=-1) {
					//	line = line.substring(last + 1);
						acumuladorDeTexto = line.substring(line.indexOf("data-context-item-id=")+22,line.indexOf("data-visibility")-2);

					//	acumuladorDeTexto = line.substring(0,line.indexOf("/hqdefault"));

						

						return "&yout&https://www.youtube.com/embed/"+acumuladorDeTexto;
					}

				}

			}
		} catch (Exception e) {
		//	f.close();
			return "&not&" ;
			
			
		}

		//f.close();

		return "&not&" ;

	}


	

	
	
	
	
	
	
	
	
	
	
	
	
	
	@Override
	public String escuchar(String msg, String usuario) {
		if (msg.contains("video")) {
			msg=msg.replace("video ", "");
			msg=msg.replace("video", "");
			
			return obtenerEnlace(msg);
		}
		
		return next.escuchar(msg, usuario);
	}



}
