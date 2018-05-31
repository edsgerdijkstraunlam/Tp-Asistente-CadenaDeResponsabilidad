package cadenaDeResponsabilidades;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import asistente.ReceptorDeMensaje;

public class FechayHora implements ReceptorDeMensaje{
	
	
	private ReceptorDeMensaje next;

	public final static Date FECHA_HORA = new GregorianCalendar().getTime();
	//public final static Date FECHA_HORA = new GregorioanCalendar().getTime();
	//Sin parametros da la fecha actual
	
	public static String fecha(String mensaje) {

		DateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
		return " hoy es " + formatoFecha.format(FECHA_HORA);

	}

	public static String hora(String mensaje) {

		DateFormat formatoHora = new SimpleDateFormat("HH:mm");
		return " son las " + formatoHora.format(FECHA_HORA);

	}
	
	public static String diaSemana(String mensaje){
		
		String[] diasSemana = new String[] { "domingo", "lunes", "martes", "miercoles", "jueves", "viernes", "sabado" };

		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTime(FECHA_HORA);
		int dia = calendar.get(Calendar.DAY_OF_WEEK) - 1;
		
		return " hoy es " + diasSemana[dia] ;
	}
	
	public static String diaDentroNdias(String msg){
		String []cant=msg.substring(msg.indexOf("dentro de")+10,msg.length()).split(" ");
		
		 int dias = Integer.valueOf(cant[0]);
		 Calendar c1 = Calendar.getInstance(); 
		 SimpleDateFormat formatofecha = new SimpleDateFormat("dd/MM/yyyy");
		 
	     c1.add(Calendar.DATE, dias);
	     
	     return " dentro de " + dias + " días será " + formatofecha.format(c1.getTime());
		
	}
	
	public static String diaDentroNmeses(String msg){
		String []cant=msg.substring(msg.indexOf("dentro de")+10,msg.length()).split(" ");
		
		 int meses = Integer.valueOf(cant[0]);
		 
		 Calendar c1 = Calendar.getInstance(); 
		 SimpleDateFormat formatofecha = new SimpleDateFormat("dd/MM/yyyy");
		 
	     c1.add(Calendar.MONTH, meses);
	     
	     return " dentro de " + meses + " meses será " + formatofecha.format(c1.getTime());
		
	}
	
	public static String diaDentroNaños(String msg){
		String []cant=msg.substring(msg.indexOf("dentro de")+10,msg.length()).split(" ");
		
		 int años = Integer.valueOf(cant[0]);
		 
		 Calendar c1 = Calendar.getInstance(); 
		 SimpleDateFormat formatofecha = new SimpleDateFormat("dd/MM/yyyy");
		 
	     c1.add(Calendar.YEAR, años);
	     
	     return " dentro de " + años + " años será " + formatofecha.format(c1.getTime());
		
	}
	
	public static String diaHaceNdias(String msg){
		
		String []cant=msg.substring(msg.indexOf("hace")+5,msg.length()).split(" ");
		
		 int dias = Integer.valueOf(cant[0]);
	
		 Calendar c1 = Calendar.getInstance(); 
		 SimpleDateFormat formatofecha = new SimpleDateFormat("dd/MM/yyyy");
		 
	     c1.add(Calendar.DATE, -dias);
	     
	     return " hace " + dias + " días fue " + formatofecha.format(c1.getTime());
		
	}
	
	public static String diaHaceNmeses(String msg){
		
		
		String []cant=msg.substring(msg.indexOf("hace")+5,msg.length()).split(" ");
		
		 int meses = Integer.valueOf(cant[0]);
		 Calendar c1 = Calendar.getInstance(); 
		 SimpleDateFormat formatofecha = new SimpleDateFormat("dd/MM/yyyy");
		 
	     c1.add(Calendar.MONTH, -meses);
	     
	     return " hace " + meses + " meses fue " + formatofecha.format(c1.getTime());
		
	}
	
	public static String diaHaceNaños(String msg){
		
		
		String []cant=msg.substring(msg.indexOf("hace")+5,msg.length()).split(" ");
		
		 int años = Integer.valueOf(cant[0]);
		 Calendar c1 = Calendar.getInstance(); 
		 SimpleDateFormat formatofecha = new SimpleDateFormat("dd/MM/yyyy");
		 
	     c1.add(Calendar.YEAR, -años);
	     
	     return " hace " + años + " años fue " + formatofecha.format(c1.getTime());
		
	}
	
	//hay otra forma haciendo la resta entre los milisegundos y dividirlos por 1 dia=1000 * 60 * 60 * 24
	//cuántos días pasaron desde el 1 de abril de 2017
	public static String diasDesdeXHastaY(String msg){
		
		String [] meses = {"enero" , "febrero" , "marzo" , "abril" ,"mayo", "junio" , "julio" ,"agosto" ,"septiembre","octubre","noviembre","diciembre"};		
		
		String cadena=msg.substring(msg.indexOf("desde")+9,msg.length());
		cadena=cadena.replace("?", "");
		cadena=cadena.replace("de ", "");
		String[]fecha=cadena.split(" ");
		
		int dia=Integer.valueOf(fecha[0]);
		int años = Integer.valueOf(fecha[2]);
		
		//Calendar fechaInicio = new GregorianCalendar() ;
		//Calendar fechaFin = new GregorianCalendar(); 
		
		int mes=0,j=0;
		
		for(String z : meses){
			
			if(fecha[1].equals(z))
				mes = j ;
			j++;
		}
		
		LocalDate d1=LocalDate.of(años, mes+1, dia);
		LocalDate d2=LocalDate.now();
		long diasEntre= ChronoUnit.DAYS.between(d1, d2);
		
		  
	    //fechaInicio.setTime(FECHA_HORA);

		//fechaFin.set(años, mes, dia);		 
		//long retorno = fechaInicio.getTime().getTime() - fechaFin.getTime().getTime();
		//retorno /= (1000 * 60 * 60 * 24) ;
		
		return " pasaron " + diasEntre  + " días";
	}
	
	public static String mesesDesdeXHastaY(String msg){
		
		String [] meses = {"enero" , "febrero" , "marzo" , "abril" ,"mayo", "junio" , "julio" ,"agosto" ,"septiembre","octubre","noviembre","diciembre"};		
		
		String cadena=msg.substring(msg.indexOf("desde")+9,msg.length());
		cadena=cadena.replace("?", "");
		cadena=cadena.replace("de ", "");
		String[]fecha=cadena.split(" ");
		
		int dia=Integer.valueOf(fecha[0]);
		int años = Integer.valueOf(fecha[2]);
		
		//Calendar fechaInicio = new GregorianCalendar() ;
		//Calendar fechaFin = new GregorianCalendar(); 
		
		int mes=0,j=0;
		
		for(String z : meses){
			
			if(fecha[1].equals(z))
				mes = j ;
			j++;
		}
		
		LocalDate d1=LocalDate.of(años, mes+1, dia);
		LocalDate d2=LocalDate.now();
		/*long diasEntre= ChronoUnit.DAYS.between(d1, d2);
		*/
		  
		long monthBetween = ChronoUnit.MONTHS.between(d1, d2);
	    //fechaInicio.setTime(FECHA_HORA);
		//fechaFin.set(años, mes, dia);		 

		
		return " pasaron " + monthBetween  + " meses";
	}
	
	public static String añosDesdeXHastaY(String msg){
		
		String [] meses = {"enero" , "febrero" , "marzo" , "abril" ,"mayo", "junio" , "julio" ,"agosto" ,"septiembre","octubre","noviembre","diciembre"};		
		
		String cadena=msg.substring(msg.indexOf("desde")+9,msg.length());
		cadena=cadena.replace("?", "");
		cadena=cadena.replace("de ", "");
		String[]fecha=cadena.split(" ");
		
		int dia=Integer.valueOf(fecha[0]);
		int años = Integer.valueOf(fecha[2]);
		
		//Calendar fechaInicio = new GregorianCalendar() ;
		//Calendar fechaFin = new GregorianCalendar(); 
		
		int mes=0,j=0;
		
		for(String z : meses){
			
			if(fecha[1].equals(z))
				mes = j ;
			j++;
		}
		
		LocalDate d1=LocalDate.of(años, mes+1, dia);
		LocalDate d2=LocalDate.now();
		/*long diasEntre= ChronoUnit.DAYS.between(d1, d2);
		*/
		  
		long monthBetween = ChronoUnit.YEARS.between(d1, d2);
	    //fechaInicio.setTime(FECHA_HORA);
		//fechaFin.set(años, mes, dia);		 

		
		return " pasaron " + monthBetween  + " años";
	}

	@Override
	public String escuchar(String msg, String usuario) {
		String msjParaMetodo;
		if (msg.contains("hora")) {
			msjParaMetodo = "" + msg;
			return usuario + (FechayHora.hora(msjParaMetodo));
			
		}

		if (msg.contains("meses") ||msg.contains("año") ||(msg.contains("fecha") || msg.contains("día") || msg.contains("dia"))) {
			msjParaMetodo = "" + msg;
			if (msg.contains("semana"))
				return usuario + (FechayHora.diaSemana(msjParaMetodo));
			
			else if(msg.contains("dentro de ")) {
				
				if(msg.contains("meses")||msg.contains("mes"))
					return usuario+ (FechayHora.diaDentroNmeses(msg));
				
				else if(msg.contains("años")||msg.contains("año"))
					return usuario + (FechayHora.diaDentroNaños(msg));
				
				else
				return usuario + (FechayHora.diaDentroNdias(msg));
				
			}

			else if(msg.contains("mañana"))
				return usuario + (FechayHora.diaDentroNdias("dentro de 1 dia"));
			
			else if(msg.contains("hace ")) {
				
				if(msg.contains("meses")||msg.contains("mes"))
					return usuario +(FechayHora.diaHaceNmeses(msg));
				
				else if(msg.contains("años")||msg.contains("año"))
					return usuario +(FechayHora.diaHaceNaños(msg));
				
				else
					return usuario +(FechayHora.diaHaceNdias(msg));
				
			}
			else if(msg.contains("desde")){
				
				if(msg.contains("meses")||msg.contains("mes"))
					return usuario +(FechayHora.mesesDesdeXHastaY(msg));
				
				else if(msg.contains("años")||msg.contains("año"))
					return usuario +(FechayHora.añosDesdeXHastaY(msg));
				
				else
					return usuario +(FechayHora.diasDesdeXHastaY(msg));
				
			}
			else
				return usuario +(FechayHora.fecha(msjParaMetodo));
			
			
		}
		
		return next.escuchar(msg,usuario);
	}

	@Override
	public void setNext(ReceptorDeMensaje sig) {
		this.next=sig;
		
	}

	@Override
	public ReceptorDeMensaje getNext() {
		// TODO Auto-generated method stub
		return this.next;
	}
	
}
