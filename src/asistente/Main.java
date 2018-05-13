package asistente;


public class Main {

	public static void main(String[] args) {


		String mensaje="hola,cuanto es 12*12";
		Asistente jenkins= new Asistente("jenkins");
		jenkins.setUsuario("Gise");
		System.out.println(jenkins.escuchar(mensaje));
		
	}

}
