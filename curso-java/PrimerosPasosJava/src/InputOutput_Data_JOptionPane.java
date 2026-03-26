import javax.swing.JOptionPane;

public class InputOutput_Data_JOptionPane {
	
	public static void main(String[] args) {
		String nombreUsuario = JOptionPane.showInputDialog("Ingresa tu nombre:");
		
		int edadUsuario = Integer.parseInt(JOptionPane.showInputDialog("Ingresa tu edad:"));
		
		edadUsuario++;
		
		System.out.println("Hola, " + nombreUsuario + " el año que viene tendrás " + (edadUsuario) + " años");
	}
}
