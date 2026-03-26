package EventoBotonNormal;
import javax.swing.JFrame;

public class Marco extends JFrame {
    public Marco() {
        setTitle("Botones y Eventos");
        setBounds(700, 300, 500, 300);
        LaminaBoton miLamina = new LaminaBoton();
        add(miLamina);
    }
}
