package asistente;


public class Main {

	public static void main(String[] args) {


		String mensaje="evaluar sumar5(x) en 12.3";
		Asistente jenkins= new Asistente("jenkins");
		jenkins.setUsuario("Franco");
		System.out.println(jenkins.escuchar(mensaje));
		
	}

}
