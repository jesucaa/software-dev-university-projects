import java.lang.Math;

/**
 * Operaciones:
 *  Math.sqrt(n): raiz cuadrada de un número
 *  Math.pow(base, exponente): potencia de un número. Base y exponente son doubles.
 *  Math.sin(angulo): calcula el seno de un angulo
 *  Math.cos(angulo): coseno de un angulo
 *  Math.tan(angulo): tangente de un angulo
 *  Math.atan(angulo): cotangente de un angulo
 *  Math.round(decimal): redondear un numero
 *  Math.PI: constante de clase con el número PI
 *  
 *  
 * @author Jesuuca
 *
 */

public class Calculo_conMath {
	
	public static void main(String[] args) {
		//double raiz = Math.sqrt(4);
		
		//double num1 = 9.85;
		
		double base = 5;
		double exponente = 3;
		
		int resultado = (int)Math.pow(base, exponente);
		System.out.println("El resultado de " + base + " elevado a "
				+ exponente + " es " + resultado);
	}
}
