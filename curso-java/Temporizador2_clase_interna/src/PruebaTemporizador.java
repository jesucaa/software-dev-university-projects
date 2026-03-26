import javax.swing.*;

public class PruebaTemporizador {

	public static void main(String[] args) {
		
		Reloj miReloj = new Reloj(2000, true);
		
		miReloj.enMarcha();
		
		JOptionPane.showMessageDialog(null, "Pulsa Aceptar para terminar");
		
		System.exit(0);
		
	}
	
}
