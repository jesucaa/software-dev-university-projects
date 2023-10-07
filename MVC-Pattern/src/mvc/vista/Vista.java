package mvc.vista;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Vista extends JFrame {
	
	// Atributos
	private JPanel panel;
	public JTextField txtNumero1, txtNumero2, txtResultado; // es public para que el controlador tenga acceso
	private JLabel signo;
	public JButton btnMultiplicar, btnRefrescar;
	
	// Constructor de la ventana
	public Vista() {
		this.setSize(600, 300);
		//this.setTitle("Multiplicación"); // no se ocupa en este ejemplo
		// this.setLocationRelativeTo(null); // no se ocupa en este ejemplo
		
		iniciarComponentes();
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	private void iniciarComponentes() {
		colocarPanel();
		colocarCamposTxt();
		colocarEtiqueta();
		colocarBoton();
	}

	private void colocarPanel() {
		panel = new JPanel(); // creamos el panel
		panel.setLayout(null); // desactivamos el diseño para poder mover de posición los componentes
		this.getContentPane().add(panel); // agregamos el panel a la ventana
	}
	
	private void colocarCamposTxt() {
		// Número 1
		txtNumero1 = new JTextField();
		txtNumero1.setBounds(60, 70, 120, 40);
		panel.add(txtNumero1);
		
		// Número 2
		txtNumero2 = new JTextField();
		txtNumero2.setBounds(230, 70, 120, 40);
		panel.add(txtNumero2);
		
		// Resultado
		txtResultado = new JTextField();
		txtResultado.setBounds(150, 150, 120, 40);
		panel.add(txtResultado);
	}
	
	private void colocarEtiqueta() {
		// Signo de multiplicación
        signo = new JLabel(); //Creamos la etiqueta
        signo.setBounds(199, 82, 10, 20);
        signo.setHorizontalAlignment(SwingConstants.CENTER); //Establecemos la alineación horizontal del texto
        signo.setForeground(Color.BLACK); //Cambiamos el color de la etiqueta
        signo.setFont(new Font("monaco", Font.BOLD, 15)); //Establecemos la fuente
        signo.setText("X"); //Establecemos el texto de la etiqueta
        panel.add(signo); //Agregamos la etiqueta al panel
	}
	
	private void colocarBoton() {
		
		// Botón multiplicar
		btnMultiplicar = new JButton();
		btnMultiplicar.setBounds(400, 70, 100, 40);
		btnMultiplicar.setForeground(Color.DARK_GRAY);
		btnMultiplicar.setFont(new Font("mangal", Font.BOLD, 15));
		btnMultiplicar.setText("Multiplicar");
		panel.add(btnMultiplicar);
		
		// Botón refrescar campos de texto
		btnRefrescar = new JButton();
		btnRefrescar.setBounds(400, 150, 100, 40);
		btnRefrescar.setForeground(Color.DARK_GRAY);
		btnRefrescar.setFont(new Font("mangal", Font.BOLD, 15));
		btnRefrescar.setText("Refrescar");
		panel.add(btnRefrescar);
	}
		
}
