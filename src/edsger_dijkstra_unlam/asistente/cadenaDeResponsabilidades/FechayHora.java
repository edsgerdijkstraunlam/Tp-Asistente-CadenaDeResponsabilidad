package edsger_dijkstra_unlam.asistente.cadenaDeResponsabilidades;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import edsger_dijkstra_unlam.asistente.asistente.ReceptorDeMensaje;

public class FechayHora extends ReceptorDeMensaje{
	
	

	GregorianCalendar gc=new GregorianCalendar();
	public Date FECHA_HORA;
	
	public FechayHora() {
		FECHA_HORA=gc.getTime();
	}
	public FechayHora(GregorianCalendar gc) {
		this.gc=gc;
		FECHA_HORA=gc.getTime();
	}
	
	
	
	public String fecha(String mensaje) {

		DateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
		return " hoy es " + formatoFecha.format(FECHA_HORA);

	}

	public String hora(String mensaje) {

		DateFormat formatoHora = new SimpleDateFormat("HH:mm");
		return " son las " + formatoHora.format(FECHA_HORA);

	}
	
	public String diaSemana(String mensaje){
		
		String[] diasSemana = new String[] { "domingo", "lunes", "martes", "miercoles", "jueves", "viernes", "sabado" };

		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTime(FECHA_HORA);
		int dia = calendar.get(Calendar.DAY_OF_WEEK) - 1;
		
		return " hoy es " + diasSemana[dia] ;
	}
	
	public String diaDentroNdias(String msg){
		String []cant=msg.substring(msg.indexOf("dentro de")+10,msg.length()).split(" ");
		
		 int dias = Integer.valueOf(cant[0]);
		 
		 GregorianCalendar c1 = (GregorianCalendar)gc.clone(); 
		 SimpleDateFormat formatofecha = new SimpleDateFormat("dd/MM/yyyy");
		 
	     c1.add(Calendar.DATE, dias);
	     
	     return " dentro de " + dias + " días será " + formatofecha.format(c1.getTime());
		
	}
	
	public String diaDentroNmeses(String msg){
		String []cant=msg.substring(msg.indexOf("dentro de")+10,msg.length()).split(" ");
		
		 int meses = Integer.valueOf(cant[0]);
		 
		 GregorianCalendar c1 = (GregorianCalendar)gc.clone();  
		 SimpleDateFormat formatofecha = new SimpleDateFormat("dd/MM/yyyy");
		 
	     c1.add(Calendar.MONTH, meses);
	     
	     return " dentro de " + meses + " meses será " + formatofecha.format(c1.getTime());
		
	}
	
	public String diaDentroNaños(String msg){
		String []cant=msg.substring(msg.indexOf("dentro de")+10,msg.length()).split(" ");
		
		 int años = Integer.valueOf(cant[0]);
		 
		 GregorianCalendar c1 = (GregorianCalendar)gc.clone(); 
		 SimpleDateFormat formatofecha = new SimpleDateFormat("dd/MM/yyyy");
		 
	     c1.add(Calendar.YEAR, años);
	     
	     return " dentro de " + años + " años será " + formatofecha.format(c1.getTime());
		
	}
	
	public String diaHaceNdias(String msg){
		
		String []cant=msg.substring(msg.indexOf("hace")+5,msg.length()).split(" ");
		
		 int dias = Integer.valueOf(cant[0]);
		 GregorianCalendar c1 = (GregorianCalendar)gc.clone(); 
		
		 SimpleDateFormat formatofecha = new SimpleDateFormat("dd/MM/yyyy");
		 
	     c1.add(Calendar.DATE, -dias);
	     
	     return " hace " + dias + " días fue " + formatofecha.format(c1.getTime());
		
	}
	
	public String diaHaceNmeses(String msg){
		
		
		String []cant=msg.substring(msg.indexOf("hace")+5,msg.length()).split(" ");
		
		 int meses = Integer.valueOf(cant[0]);
		 GregorianCalendar c1 = (GregorianCalendar)gc.clone();  
		 SimpleDateFormat formatofecha = new SimpleDateFormat("dd/MM/yyyy");
		 
	     c1.add(Calendar.MONTH, -meses);
	     
	     return " hace " + meses + " meses fue " + formatofecha.format(c1.getTime());
		
	}
	
	public String diaHaceNaños(String msg){
		
		
		String []cant=msg.substring(msg.indexOf("hace")+5,msg.length()).split(" ");
		
		 int años = Integer.valueOf(cant[0]);
		 GregorianCalendar c1 = (GregorianCalendar)gc.clone();  
		 SimpleDateFormat formatofecha = new SimpleDateFormat("dd/MM/yyyy");
		 
	     c1.add(Calendar.YEAR, -años);
	     
	     return " hace " + años + " años fue " + formatofecha.format(c1.getTime());
		
	}
	
	//hay otra forma haciendo la resta entre los milisegundos y dividirlos por 1 dia=1000 * 60 * 60 * 24
	//cuántos días pasaron desde el 1 de abril de 2017
	public String diasDesdeXHastaY(String msg){
		
		String [] meses = {"enero" , "febrero" , "marzo" , "abril" ,"mayo", "junio" , "julio" ,"agosto" ,"septiembre","octubre","noviembre","diciembre"};		
		
		String cadena=msg.substring(msg.indexOf("desde")+9,msg.length());
		cadena=cadena.replace("?", "");
		cadena=cadena.replace("de ", "");
		String[]fecha=cadena.split(" ");
		
		int dia=Integer.valueOf(fecha[0]);
		int años = Integer.valueOf(fecha[2]);
		
		
		int mes=0,j=0;
		
		for(String z : meses){
			
			if(fecha[1].equals(z))
				mes = j ;
			j++;
		}
		
	
		
		LocalDate d1=LocalDate.of(años, mes+1, dia);
		LocalDate d2=LocalDate.of(gc.get(Calendar.YEAR),gc.get(Calendar.MONTH)+1,gc.get(Calendar.DAY_OF_MONTH));
		
		
		long diasEntre= ChronoUnit.DAYS.between(d1, d2);
		
		  
		return " pasaron " + diasEntre  + " días";
	}
	
	public String mesesDesdeXHastaY(String msg){
		
		String [] meses = {"enero" , "febrero" , "marzo" , "abril" ,"mayo", "junio" , "julio" ,"agosto" ,"septiembre","octubre","noviembre","diciembre"};		
		
		String cadena=msg.substring(msg.indexOf("desde")+9,msg.length());
		cadena=cadena.replace("?", "");
		cadena=cadena.replace("de ", "");
		String[]fecha=cadena.split(" ");
		
		int dia=Integer.valueOf(fecha[0]);
		int años = Integer.valueOf(fecha[2]);
		
		
		int mes=0,j=0;
		
		for(String z : meses){
			
			if(fecha[1].equals(z))
				mes = j ;
			j++;
		}
		
		LocalDate d1=LocalDate.of(años, mes+1, dia);
		//LocalDate d2=LocalDate.now();
		LocalDate d2=LocalDate.of(gc.get(Calendar.YEAR),gc.get(Calendar.MONTH)+1,gc.get(Calendar.DAY_OF_MONTH));
		

		
		long monthBetween = ChronoUnit.MONTHS.between(d1, d2);
		return " pasaron " + monthBetween  + " meses";
	}
	
	public String añosDesdeXHastaY(String msg){
		
		String [] meses = {"enero" , "febrero" , "marzo" , "abril" ,"mayo", "junio" , "julio" ,"agosto" ,"septiembre","octubre","noviembre","diciembre"};		
		
		String cadena=msg.substring(msg.indexOf("desde")+9,msg.length());
		cadena=cadena.replace("?", "");
		cadena=cadena.replace("de ", "");
		String[]fecha=cadena.split(" ");
		
		int dia=Integer.valueOf(fecha[0]);
		int años = Integer.valueOf(fecha[2]);
		
		
		int mes=0,j=0;
		
		for(String z : meses){
			
			if(fecha[1].equals(z))
				mes = j ;
			j++;
		}
		
		LocalDate d1=LocalDate.of(años, mes+1, dia);
		LocalDate d2=LocalDate.of(gc.get(Calendar.YEAR),gc.get(Calendar.MONTH)+1,gc.get(Calendar.DAY_OF_MONTH));
		

		  
		long monthBetween = ChronoUnit.YEARS.between(d1, d2);
	 
		return " pasaron " + monthBetween  + " años";
	}

	@Override
	public String escuchar(String msg, String usuario) {
	
		if (msg.contains("hora")) {
	
			return usuario + (hora(msg));
			
		}

		if (msg.contains("meses") ||msg.contains("año") ||(msg.contains("fecha") || msg.contains("día") || msg.contains("dia"))) {
		
			if (msg.contains("semana"))
				return usuario + (diaSemana(msg));
			
			else if(msg.contains("dentro de ")) {
				
				if(msg.contains("meses")||msg.contains("mes"))
					return usuario+ (diaDentroNmeses(msg));
				
				else if(msg.contains("años")||msg.contains("año"))
					return usuario + (diaDentroNaños(msg));
				
				else
				return usuario + (diaDentroNdias(msg));
				
			}

			else if(msg.contains("mañana"))
				return usuario + (diaDentroNdias("dentro de 1 dia"));
			
			else if(msg.contains("hace ")) {
				
				if(msg.contains("meses")||msg.contains("mes"))
					return usuario +(diaHaceNmeses(msg));
				
				else if(msg.contains("años")||msg.contains("año"))
					return usuario +(diaHaceNaños(msg));
				
				else
					return usuario +(diaHaceNdias(msg));
				
			}
			else if(msg.contains("desde")){
				
				if(msg.contains("meses")||msg.contains("mes"))
					return usuario +(mesesDesdeXHastaY(msg));
				
				else if(msg.contains("años")||msg.contains("año"))
					return usuario +(añosDesdeXHastaY(msg));
				
				else
					return usuario +(diasDesdeXHastaY(msg));
				
			}
			else
				return usuario +(fecha(msg));
			
			
		}
		
		return next.escuchar(msg,usuario);
	}


	
}
