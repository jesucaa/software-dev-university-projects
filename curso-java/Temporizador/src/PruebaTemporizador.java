import javax.swing.*;

public class PruebaTemporizador {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		DameLaHora oyente = new DameLaHora();
		// o
		// ActionListener oyente = DameLaHora();

		Timer miTemporizador = new Timer(5000, oyente); // 5000 milisegundos = cada 5 segundos, esto repetirá la acción cada 5 seg
		
		miTemporizador.start();
		
		JOptionPane.showMessageDialog(null, "Pulsa Aceptar para detener");
		
		System.exit(0);
	}

}
