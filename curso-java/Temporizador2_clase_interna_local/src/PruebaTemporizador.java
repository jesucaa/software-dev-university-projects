import javax.swing.*;

public class PruebaTemporizador {

	public static void main(String[] args) {
		
		Reloj miReloj = new Reloj();
		
		miReloj.enMarcha(2000, true);
		
		JOptionPane.showMessageDialog(null, "Pulsa Aceptar para terminar");
		
		System.exit(0);
		
	}
	
}
