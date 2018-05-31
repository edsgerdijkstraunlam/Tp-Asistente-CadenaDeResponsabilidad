package asistente;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc=new Scanner(System.in);
		String mensaje="evaluar sumar5(x) en 12.3";
		Asistente jenkins= new Asistente("jenkins");
		jenkins.setUsuario("Franco");
		String msg=sc.nextLine();
		while (!msg.equals("chau")) {
			System.out.println(jenkins.escuchar(msg));
			msg=sc.nextLine();
		}
		sc.close();
		
		System.out.println(jenkins.escuchar("definir la funcion sumar5(x)=x+5"));
		System.out.println(jenkins.escuchar("definir la funcion sumar5(x)=x+6"));
		System.out.println(jenkins.escuchar("evaluar la funcion sumar5(x) en 2"));
		System.out.println(jenkins.escuchar("cuanto es sumar5(x) en 0"));
		System.out.println(jenkins.escuchar("cuanto es sumar(x) en 0"));
		System.out.println(jenkins.escuchar(mensaje));
		
	}

}
