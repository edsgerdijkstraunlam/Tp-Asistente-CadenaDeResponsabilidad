package conversor;

import java.lang.reflect.Method;
import java.text.DecimalFormat;

import utilitarias.ExtraerEntero;

public class ConversionesDeUnidades {
	
	/**
	 * Metodo que obtendra todos los datos para la conversion
	 * 
	 * @param cadena Conversion que se quiere realizar
	 * @return Cadena ya convertida
	 */
	
	public static String convertido(String cadena){
		DecimalFormat decimalFormat = new DecimalFormat("##.##"); //Con dos decimales
		double resultado = 0;
		Integer cantidad = ExtraerEntero.extraerEntero(cadena);
		String uniOriginal = ConversionesDeUnidades.darUnidad(cadena.substring(cadena.indexOf(cantidad.toString())));
		String uniNueva = ConversionesDeUnidades.darUnidad(cadena.substring(0, cadena.indexOf(cantidad.toString())));
		
		try {
			//USO DE REFLECTION, perminete ejecutar o modificar el comportamiento en tiempo de ejecucion.
			
			//Obtengo la clase de la cual se va a realizar la conversion
			Class<?> clase = Class.forName(ConversionesDeUnidades.class.getPackage().getName()+ "." + uniOriginal);
			Object convertidor = clase.newInstance(); //Instancio un objeto de la clase, EJ: Centimetro = new Centimetro()
			Method convertir = clase.getMethod("a"+uniNueva, double.class); // Obtengo el metodo.
			resultado = (double)convertir.invoke(convertidor, cantidad); // Invoco al metodo pasandole la instancia y su parametro.
			
		} catch (Exception e) {
			System.out.println("La conversion no se pudo realizar");
			
		}
		
		if(uniOriginal.contains("Cubico")){
			uniOriginal = uniOriginal.substring(0,uniOriginal.indexOf("Cubico")) + " c�bico";
			uniNueva = uniNueva.substring(0,uniNueva.indexOf("Cubico")) + " c�bico";
		}
		
		return cantidad + " " + uniOriginal.toLowerCase() + " equivale a " + decimalFormat.format(resultado).replaceAll(",", ".") + " " + uniNueva.toLowerCase();
	}
	
	/**
	 * Metodo para obtener la unidad correspondiente
	 * 
	 * @param cadena De la cual se extraer� la unidad
	 * @return Unidad
	 */
	
	public static String darUnidad(String cadena) {
	
		String[] unidades = { "Miligramo", "Gramo","Kilometro", "Kilo", "Milimetro", "Centimetro", "Metro",
				"Kilometro", "Segundo", "Minuto", "Hora", "Pie", "Pulgada", "Onza" };
		
		int i = 0;
		
		while(!cadena.contains(unidades[i].toLowerCase()))
			i++;
		
		if(cadena.contains("c�bic"))
			return unidades[i]+="Cubico";

		return unidades[i];

	}

}
