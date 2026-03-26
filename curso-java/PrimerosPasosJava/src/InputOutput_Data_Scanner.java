import  java.util.Scanner;

public class InputOutput_Data_Scanner {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Introduce tu nombre: ");
		
		String nombre = sc.nextLine();
		
		System.out.println("Introduce tu edad: ");
		
		int edad = sc.nextInt();
		
		System.out.println("Hola, " + nombre + " el año que viene tendrás " + (edad+1) + " años");

	}
}
