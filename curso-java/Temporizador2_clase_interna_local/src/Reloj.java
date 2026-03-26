import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.*;

public class Reloj {

	public void enMarcha(int intervalo, boolean sonido) {
		
		// Clase interna local
		class DameLaHora implements ActionListener {

			@Override
			public void actionPerformed(ActionEvent e) {
				Date hora = new Date();
				int conversionSeg = intervalo / 1000;
				System.out.println("Te pongo la hora cada "+conversionSeg
						+" segundos: "+hora);
				
				if (sonido)
					Toolkit.getDefaultToolkit().beep();
				
			} 
			
		}
		
		ActionListener oyente = new DameLaHora();
		Timer miTemporizador = new Timer(intervalo, oyente);
		miTemporizador.start();
	}
	
	private int intervalo;
	private boolean sonido;
}
