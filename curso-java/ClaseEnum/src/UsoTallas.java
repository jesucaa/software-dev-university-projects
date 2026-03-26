import java.util.*;
public class UsoTallas {

	//enum Talla {MINI, MEDIANO, GRANDE, MUY_GRANDE};
	
	enum Talla {
		MINI("S"), MEDIANO("M"), GRANDE("L"), EXTRA_GRANDE("XL");
		
		private Talla(String abreviatura) {
			this.abreviatura = abreviatura;
		}
		
		public String dameAbreviatura() {
			return abreviatura;
		}
		
		private String abreviatura;
	}
	
	public static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		//Talla s = Talla.MINI;
		//Talla m = Talla.MEDIANO;
		//Talla l = Talla.GRANDE;
		//Talla xl = Talla.MUY_GRANDE;
		
		System.out.println("Escribe una talla: MINI, MEDIANO, GRANDE, EXTRA_GRANDE");
		
		String entradaDatos = sc.next().toUpperCase();
		
		Talla talla = Enum.valueOf(Talla.class, entradaDatos);
		
		System.out.println("Talla = "+talla);
		
		System.out.println("Abreviatura de la talla = "+talla.dameAbreviatura());
	}

}
