package vista;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Color;

import javax.swing.JButton;

public class VentanaPrincipal extends JFrame {
    
    public VentanaPrincipal() {
        setTitle("Ventana Principal");
        setSize(600, 600);
        setLocationRelativeTo(null);
        //getContentPane().add(panel);
        iniciarComponentes();
    }

    public void iniciarComponentes() {
        colocarPanel();
        colocarEtiquetas();
        colocarBotones();
    }

    public void colocarPanel() {
        panel = new JPanel();
        panel.setLayout(null); // para poder mover los componentes libremente en el panel
        add(panel);
    }

    public void colocarEtiquetas() {
        bienvenidaLabel = new JLabel("Bienvenido Usuario");
        bienvenidaLabel.setHorizontalAlignment(SwingConstants.CENTER);
        bienvenidaLabel.setLocation(215, 80);
        bienvenidaLabel.setSize(160,16);
        bienvenidaLabel.setFont(new Font("mangal", Font.BOLD, 16));
        bienvenidaLabel.setForeground(Color.RED);
        panel.add(bienvenidaLabel);
    }

    public void colocarBotones() {
        
    }

    JPanel panel;
    JLabel bienvenidaLabel;
}
