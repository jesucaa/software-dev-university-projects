import javax.swing.JOptionPane;

public class EntradaNumeros_printf {

	public static void main(String[] args) {
		double x = 1000.0;
		
		System.out.printf("%1.2f", x/3);
		
		System.out.println();
		
		String num1 = JOptionPane.showInputDialog("Introduce un numero");
		
		double num2 = Double.parseDouble(num1);
		
		System.out.print("La raíz de " + num2 + " es ");
		
		System.out.printf("%.2f", Math.sqrt(num2));
	}
}
