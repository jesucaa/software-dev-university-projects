package graficos;

import javax.swing.JFrame;

public class CreandoFrames {

	public static void main(String[] args) {
		
		
		MiFrame frame = new MiFrame();
		frame.crearVentana();
	}
	
}

//La creación de un frame se puede hacer de diferentes maneras, la cuales están documentadas en el código.
class MiFrame extends JFrame {
	
	// Constructor: le damos estado inicial a los componentes de nuestra ventana
	public MiFrame() {
		//setSize(500, 300); // establecemos el tamaño de la ventana
		//setLocation(500, 300); // establecemos la localizacion de la ventana
		setBounds(500, 300, 550, 300); // combinacion de setSize y setLocation
		setResizable(false); // determinamos si podemos o no, rediensionar la ventana
		//setExtendedState(Frame.MAXIMIZED_BOTH); // permite que el frame se abra en pantalla completa
		setTitle("Mi Ventana"); // establecemos el titulo de la ventana
		
		/**
		 * Directamente en nuestro constructor podemos iniciar nuestra ventana
		 * setVisible(true);
		 * setLocationRelativeTo(null);
		 * setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 */
	}
	
	// MÉTODO PARA CREAR VENTANTA: llamaremos este método en la clase principal
	public void crearVentana() {
		setVisible(true); // hacemos visible a la ventana
		//setLocationRelativeTo(null); // centramos la ventana en nuestra pantalla
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // le decimos al programa que es lo que tiene que hacer cuando se cierre el programa (se acabará)
		//setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE); // ocultar ventana
	}
}
