package cadenaDeResponsabilidades;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import asistente.ReceptorDeMensaje;
import utilitarias.Funcion;

public class Calculadora implements ReceptorDeMensaje {
	private char[] operadoresValidos = new char[] { '+', '-', '/', '*', 'r', '^', '(' };

	private ReceptorDeMensaje next;
	private ArrayList<Funcion> listaDeFunciones;

	public Calculadora() {
		listaDeFunciones = new ArrayList<Funcion>();
		this.cargarFunciones();
	}

	public void cargarFunciones() {
		FileReader fr;

		File file = new File("src\\utilitarias\\Funciones.txt");

		try {

			try {
				fr = new FileReader(file);
			} catch (FileNotFoundException e) {
				PrintWriter pw = new PrintWriter("src\\utilitarias\\Funciones.txt");
				fr = new FileReader(file);
				pw.close();
			}
			BufferedReader br = new BufferedReader(fr);
			String lin = br.readLine();

			while (lin != null) {
				String linea[] = lin.split(" ");

				Funcion f = new Funcion(linea[1], linea[0]);
				if (!listaDeFunciones.isEmpty())
					for (Funcion elem : listaDeFunciones) {
						if (elem.compareTo(f) == 0)
							break;
					}
				listaDeFunciones.add(f);

				lin = br.readLine();

			}
			br.close();

		} catch (Exception e) {
			
			e.printStackTrace();
		}
		System.out.println();
	}

	public String definirFuncion(String exp, String nombre) {
		Funcion f = new Funcion(nombre, exp);
		if (!listaDeFunciones.isEmpty())
			for (Funcion elem : listaDeFunciones) {
				if (elem.compareTo(f) == 0)
					return "La funcion ya existe";
			}
		listaDeFunciones.add(f);
		try {
			File file = new File("src\\utilitarias\\Funciones.txt");

			FileWriter textOut = new FileWriter(file, true);
			textOut.append(exp + " " + nombre+"\r\n");
			
			textOut.close();
		} catch (Exception e) {
			return "Ha habido un error ";
		}

		return "Se ha definido la funcion " + nombre+"(X)";

	}
	
	
	
	public String evaluarFuncionEnX(String nombre,double x){
		Funcion f = new Funcion(nombre,null);
		if (!listaDeFunciones.isEmpty())
			for (Funcion elem : listaDeFunciones) {
				if (elem.compareTo(f) == 0){
					f=elem;
					try {
						return "el resultado es "+evaluar(f.getFuncion(), x);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						return "Error";
					}
					
				}
			}
		
		
		
		
		
		
		return "No existe la funcion "+ nombre;
		
	}
	
	

	private int evaluarPrecedencia(char op1, char op2) {

		int precOp1 = 0;
		int precOp2 = 0;
		switch (op1) {
		case '(':
			precOp1 = 4;
			break;
		case '^':
			precOp1 = 3;

			break;
		case 'r':
			precOp1 = 3;
			break;

		case '*':
			precOp1 = 2;

			break;
		case '/':
			precOp1 = 2;

			break;
		case '+':
			precOp1 = 1;

			break;
		case '-':
			precOp1 = 1;

			break;

		default:
			break;
		}

		switch (op2) {
		case '(':
			precOp2 = 4;
			break;
		case '^':
			precOp2 = 3;

			break;
		case 'r':
			precOp2 = 3;
			break;

		case '*':
			precOp2 = 2;

			break;
		case '/':
			precOp2 = 2;

			break;
		case '+':
			precOp2 = 1;

			break;
		case '-':
			precOp2 = 1;

			break;

		default:

			break;
		}
		return (precOp1 - precOp2);
	}

	private boolean vectorContiene(char[] vec, String c) {
		for (int i = 0; i < vec.length; i++)
			if (c.charAt(0) == (vec[i]))
				return true;
		return false;
	}

	private Queue<String> pasarAPosfija(String exp) {

		exp = exp.replaceAll("\\s", "");

		Stack<String> pilaAux = new Stack<String>();
		Queue<String> colaSalida = new LinkedList<String>();

		int i = 0, j = i;
		String elem = null;

		while (i < exp.length()) {
			j = i + 1;

			if ((exp.charAt(i) == '-') && ((i == 0)
					|| ((i > 0) && (vectorContiene(operadoresValidos, String.valueOf(exp.charAt(i - 1))))))) {

				while (j < exp.length() && (exp.charAt(j) <= '9' && exp.charAt(j) >= '0' || exp.charAt(j) == '.')) {
					j++;
				}
				elem = exp.substring(i, j);
				colaSalida.add(elem);
				i = j;

			}

			else if (exp.charAt(i) <= '9' && exp.charAt(i) >= '0' || exp.charAt(i) == 'x') { // Que
																								// reconozca
																								// la
																								// x
																								// como
																								// valor
				while (j < exp.length() && (exp.charAt(j) <= '9' && exp.charAt(j) >= '0' || exp.charAt(j) == '.'
						|| exp.charAt(j) == 'x')) {
					j++;
				}
				elem = exp.substring(i, j);
				colaSalida.add(elem);
				i = j;

			}

			else {

				elem = Character.toString(exp.charAt(i));

				if (vectorContiene(operadoresValidos, elem)) {
					while (!pilaAux.isEmpty() && evaluarPrecedencia(elem.charAt(0), pilaAux.peek().charAt(0)) <= 0
							&& pilaAux.peek().charAt(0) != '(') {
						colaSalida.add(pilaAux.pop());
					}
					pilaAux.push(elem);
				}

				else if (elem.charAt(0) == ')') {
					while (!pilaAux.isEmpty() && pilaAux.peek().charAt(0) != '(') {
						colaSalida.add(pilaAux.pop());
					}
					if (pilaAux.isEmpty())
						return null;
					pilaAux.pop();

				} else
					return null;

				i++;

			}

		}

		while (!pilaAux.isEmpty()) {
			colaSalida.add(pilaAux.pop());
		}
		return colaSalida;

	}

	public double evaluar(String exp,Double x) throws Exception {

		Queue<String> cola;
		cola = this.pasarAPosfija(exp);
		return evaluarEnPostfija(cola,x);

	}

	private double evaluarEnPostfija(Queue<String> cola,Double x) {

		Stack<Double> aux = new Stack<Double>();

		String elem;
		double result = 0;
		while (!cola.isEmpty()) {

			elem = (cola.poll());
			if (elem.length() > 1 || !vectorContiene(operadoresValidos, elem)) {
				if(elem.equals("x")&&x!=null){
					aux.add(x);
				}
				else 
					aux.add(Double.valueOf(elem));
			} 
			
			
			else {

				switch (elem.charAt(0)) {
				case '+':
					result = aux.pop() + aux.pop();
					break;
				case '-':
					result = -(aux.pop() - aux.pop());
					break;
				case '*':
					result = aux.pop() * aux.pop();
					break;
				case '/':
					double primero = aux.pop();
					if (primero == 0)
						throw new NumberFormatException();
					result = aux.pop() / primero;
					break;
				case 'r':

					result = Math.pow(aux.pop(), (1 / aux.pop()));
					break;
				case '^':
					result = Math.pow(aux.pop(), aux.pop());
					break;

				default:
					break;
				}

				aux.add(result);
			}

		}
		return aux.pop();
	}

	@Override
	public String escuchar(String msg, String usuario) {

		Double x= null;
		if (msg.contains("cuanto es el") || msg.contains("cuánto es el") && msg.contains("%")) {
			msg = msg.replace("de", "");
			msg = msg.replace(" ", "");
			String[] exp = msg.substring(msg.indexOf("cuantoes") + 10, msg.length()).split("%");
			return usuario + " el resultado es: "
					+ String.format("%.02f", (Double.valueOf(exp[1]) / 100) * Double.valueOf(exp[0])).replace(',', '.');

		}

		else if (msg.contains("cuanto es") || msg.contains("cuánto es")) {
			String exp = msg.substring(msg.indexOf("cuanto es") + 9, msg.length());
			Calculadora c = new Calculadora();
			try {
				double res = c.evaluar(exp,x);
				return usuario + " el resultado es: " + String.valueOf(res).replace(',', '.');

			} catch (Exception e) {
				return "Lo siento " + usuario + ", hubo un error con la evaluación de la expresión";
			}

		}

		else if (msg.contains("definir")) {
			String exp = msg.substring(msg.indexOf("=") + 1, msg.length());
			exp = exp.replace(" ", "");
			return usuario+" "+definirFuncion(exp, msg.substring(msg.indexOf("definir") + 8, msg.indexOf("(x")).replace(" ", ""));
		}
		else if (msg.contains("evaluar")) {
			String exp = msg.substring(msg.indexOf("evaluar ") +8, msg.indexOf("(x)") );
			exp = exp.replace(" ", "");
			return usuario+" "+evaluarFuncionEnX(exp, Double.parseDouble(msg.substring(msg.indexOf(" en ") +4, msg.length() )));
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
