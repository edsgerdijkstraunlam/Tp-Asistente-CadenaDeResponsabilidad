package edsger_dijkstra_unlam.asistente.asistente;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Asistente jenkins = new Asistente("jenkins");
		jenkins.setUsuario("Franco");
		String msg = sc.nextLine();
		while (!msg.equals("chau")) {
			System.out.println(jenkins.escuchar(msg));
			msg = sc.nextLine();
		}
		sc.close();

	}
}