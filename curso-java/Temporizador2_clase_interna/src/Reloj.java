import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.*;

public class Reloj {
	
	// Clase interna
	private class DameLaHora implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			Date hora = new Date();
			int conversionSeg = intervalo / 1000;
			System.out.println("Te pongo la hora cada "+conversionSeg
					+" segundos: "+hora);
			
			if (sonido == true)
				Toolkit.getDefaultToolkit().beep();
			
		} 
		
	}
	
	public Reloj(int intervalo, boolean sonido) {
		
		this.intervalo = intervalo;
		this.sonido = sonido;
		
	}
	
	public Reloj() {
		
	}

	public void enMarcha() {
		ActionListener oyente = new DameLaHora();
		Timer miTemporizador = new Timer(intervalo, oyente);
		miTemporizador.start();
	}
	
	private int intervalo;
	private boolean sonido;
}
