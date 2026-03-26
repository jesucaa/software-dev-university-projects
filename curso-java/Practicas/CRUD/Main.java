import javax.swing.JFrame;

import vista.VentanaPrincipal;

public class Main {
    public static void main(String[] args) {
        VentanaPrincipal frame = new VentanaPrincipal();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}