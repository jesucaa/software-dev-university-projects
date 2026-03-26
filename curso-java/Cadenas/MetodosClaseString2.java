package cadenas;

public class MetodosClaseString2 {
	
	public static void main(String[] args) {
		String frase = "Te quiero mucho jeje";
		
		String fraseResumen = frase.substring(0, 9);
		String fraseResumen2 = frase.substring(10);
		
		System.out.println("El resumen de la frase es " + fraseResumen
				+ "\nY el segundo resumen es " + fraseResumen2);
	}
}
