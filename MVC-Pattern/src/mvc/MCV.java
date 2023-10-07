package mvc;

import mvc.controlador.Controlador;
import mvc.modelo.Modelo;
import mvc.vista.Vista;

public class MCV {

	public static void main(String[] args) {
		Modelo modelo = new Modelo();
		Vista vista = new Vista();
		
		Controlador controlador = new Controlador(vista, modelo);
		controlador.iniciarVista();
		vista.setVisible(true);
	}

	/**
	 * este patron de diseño nos sirve para:
	 * en caso de que la vista la cambiara
	 * imaginando que voy agregar otro diseño
	 * no tengo que estar cambiando todo el código
	 * lo único es que tenemos que respetar el nombre de la variable
	 * asi como los tipos de acceso
	 */
}
