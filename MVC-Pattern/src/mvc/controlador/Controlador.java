package mvc.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import mvc.modelo.Modelo;
import mvc.vista.Vista;

/**
 * Para que este controlador, pueda escuchar o
 * pueda detectar los click en un botón (de la vista)
 * necesitamos implementar algo
 * @author jesuuca
 *
 */
public class Controlador implements ActionListener {
	
	/**
	 * declaramos variables de tipo objeto
	 * los objetos serán las clases que hemos creado
	 */
	private Vista vista;
	private Modelo modelo;

	public Controlador(Vista vista, Modelo modelo) {
		this.vista = vista;
		this.modelo = modelo;
		this.vista.btnMultiplicar.addActionListener(multiplicar); // traemos la accion del boton de vista. (con esto ccedemos a los controles de la vista)
		this.vista.btnRefrescar.addActionListener(refrescarCampos);;
	}
	
	// creamos un método que iniciara la vista
	public void iniciarVista() {
		vista.setTitle("MVC Multiplicar");
		vista.setLocationRelativeTo(vista);
	}
	
	
	public void actionPerformed(ActionEvent e) {
		
	}
	
	// función que realizará btnMultiplicar
	ActionListener multiplicar = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			modelo.setNumero1(Integer.parseInt(vista.txtNumero1.getText()));
			modelo.setNumero2(Integer.parseInt(vista.txtNumero2.getText()));
			modelo.multiplicar(); // este método por eso no recibe nada, porque o estoy encapsulando mediante los metodos set
			vista.txtResultado.setText(String.valueOf(modelo.getResultado())); // por ultimo, mostraremos el resultado en la caja de texto resultado
		}
	};
	
	// función que realizará btnRefrescar
	ActionListener refrescarCampos = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			vista.txtNumero1.setText(null);
			vista.txtNumero2.setText(null);
			vista.txtResultado.setText(null);
		}
	};
}
