package graficos;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;

// main dentro de esta clase.
public class CreandoFrameCentrado {

	public static void main(String[] args) {
		MarcoCentrado miMarco = new MarcoCentrado();
		miMarco.setVisible(true);
		miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
}

class MarcoCentrado extends JFrame {
	
	public MarcoCentrado() {
		Toolkit miPantalla = Toolkit.getDefaultToolkit(); // obtenemos nuestro sistema nativo de ventana
		Dimension tamañoPantalla = miPantalla.getScreenSize(); // obtener resolución o tamaño de la ventana
		
		// Obtener el ancho y alto de la resolucion de la pantalla
		int alturaPantalla = tamañoPantalla.height;
		int anchoPantalla = tamañoPantalla.width;
		
		// Centrar ventana
		setSize(anchoPantalla/2, alturaPantalla/2);
		setLocation(anchoPantalla/4, alturaPantalla/4);
		
		// Establecer un titulo a la ventana
		setTitle("Marco Centrado");
		
		// Cambiar icono de la ventana
		Image miIcono = miPantalla.getImage("src/graficos/cafe.png");
		setIconImage(miIcono);
	}
	
}
