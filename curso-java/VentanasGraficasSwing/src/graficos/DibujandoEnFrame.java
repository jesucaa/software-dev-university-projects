package graficos;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

import javax.swing.*;

public class DibujandoEnFrame {
	public static void main(String[] args) {
		MarcoConDibujos ventana = new MarcoConDibujos();
		ventana.setVisible(true);
		ventana.setLocationRelativeTo(null);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
}

class MarcoConDibujos extends JFrame {
	public MarcoConDibujos() {
		setTitle("prueba de dibujo");
		setSize(400, 400);
		LaminaConFiguras lamina = new LaminaConFiguras();
		add(lamina);
	}
}

class LaminaConFiguras extends JPanel {
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		//g.drawRect(50, 50, 200, 200); // cuadrado
		//g.drawLine(100, 100, 300, 200); // linea
		//g.drawArc(50, 100, 100, 200, 120, 150); // arco
		
		Graphics2D g2 = (Graphics2D) g;
		
		Rectangle2D rectangulo = new Rectangle2D.Double(100, 100, 200, 150);
		
		g2.draw(rectangulo);
		
		Ellipse2D elipse = new Ellipse2D.Double();
		
		elipse.setFrame(rectangulo); //Dibuja un cuadrado imaginario
		
		g2.draw(elipse);
		
		g2.draw(new Line2D.Double(100, 100, 300, 250));
		
		double centroEnX = rectangulo.getCenterX();
		
		double centroEnY = rectangulo.getCenterY();
		
		double radio = 150;
		
		Ellipse2D circulo = new Ellipse2D.Double();
		
		circulo.setFrameFromCenter(centroEnX, centroEnY, centroEnX+radio, centroEnY+radio);
		
		g2.draw(circulo);
		
	}
}
