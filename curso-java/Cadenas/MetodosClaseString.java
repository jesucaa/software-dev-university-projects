package cadenas;

/**
 * Métodos de la clase String: *(solo algunos)*
 * 
 * length(): devuelve la longitud de una cadena de caracteres
 * charAt(n): devuelve la posición de un carácter dentro de una cadena. (las posiciones empiezan a contar de 0) 
 * substring(x, y): extrae dentro de una cadena equis caracteres.
 * equals(cadena): devuelve true si dos cadenas que se comparan son iguales y false si no lo son. distingue mayúsculas y minusculas
 * equalsIgnoreCase(cadena): igual que el anterior pero sin tener en cuenta mayúsculas y minusculas.
 * @author jesuuca
 *
 */

public class MetodosClaseString {
	
	public static void main(String[] args) {
		
		String miNombre = "te culeo bien rico mami";
		System.out.println("Mi nombre es " + miNombre);
		int tamaño = miNombre.length();
		System.out.println("Mi nombre tiene " + tamaño + " letras");
		char letra = miNombre.charAt(2);
		System.out.println("La tercer letra de " + miNombre + " es " + letra);
		
		int ultimaLetra;
		
		ultimaLetra = miNombre.length()-1;
		
		System.out.println("La ultima letra de " + miNombre + " es "
				+ miNombre.charAt(ultimaLetra));
	}
}
