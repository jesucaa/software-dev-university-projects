package graficos;

import javax.swing.*;
import java.awt.*;

public class EscribiendoEnFrame {

	public static void main(String[] args) {
		MarcoConTexto frame = new MarcoConTexto();
		frame.setVisible(true);
	}
	
}

class MarcoConTexto extends JFrame {
	
	public MarcoConTexto() {
		//setVisible(true);
		setSize(600, 400);
		setTitle("Escribiendo en el frame");
		setLocationRelativeTo(null);
		setResizable(true);
		Lamina miLamina = new Lamina();
		add(miLamina);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
}

class Lamina extends JPanel {
	public void paintComponent(Graphics g) {
		super.paintComponent(g); // hace lo que hace la clase Padre 
		g.drawString("Estamos aprendiendo Swing", 100, 100); // hace lo que nosotros le decimos que escriba
	}
}
