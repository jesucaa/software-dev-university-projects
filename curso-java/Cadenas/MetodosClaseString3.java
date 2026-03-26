package cadenas;

public class MetodosClaseString3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String alumno1, alumno2;
		
		alumno1 = "David";
		alumno2 = "David";
		
		System.out.println(alumno1.equals(alumno2));
		
		String alumno3, alumno4;
		
		alumno3 = "Roberto";
		alumno4 = "david";
		
		System.out.println(alumno1.equals(alumno4));
		System.out.println(alumno2.equalsIgnoreCase(alumno4));
		
	}

}
