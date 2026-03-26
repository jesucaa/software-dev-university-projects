import javax.swing.*;
import eventos.EventosDeVentana;

public class App extends JFrame {

    public App() {
        this.setTitle("Eventos de ventana");
        this.setSize(350, 350);
        this.setLocationRelativeTo(this);
        this.setResizable(false); // no podemos redimensionar la ventana
        this.getContentPane().add(laminaFondo);
        EventosDeVentana eventosVentana = new EventosDeVentana();
        addWindowListener(eventosVentana);
    }

    public static void main(String[] args) throws Exception {
        App ventana = new App();
        ventana.setVisible(true);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        App ventana2 = new App();
        ventana2.setVisible(true);
        ventana2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // cerrar esta ventana sin cerrar la otra
    }

    private JPanel laminaFondo = new JPanel();
}
