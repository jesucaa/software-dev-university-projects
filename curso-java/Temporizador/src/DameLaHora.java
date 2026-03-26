import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class DameLaHora implements ActionListener {
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Date hora = new Date();
		
		System.out.println("Te pongo la hora cada 5 segundos: "+hora);
		
		Toolkit.getDefaultToolkit().beep();
		
	}

}
