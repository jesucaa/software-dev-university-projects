import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.event.*;

public class EventosNormal {
    public static void main(String[] args) throws Exception {
        VentanaBotones ventana = new VentanaBotones();
        ventana.setVisible(true);
        ventana.setLocationRelativeTo(null);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class VentanaBotones extends JFrame {

    public VentanaBotones() {
        setTitle("Ventana Botones");
        setBounds(700, 300, 500, 300);
        EventoBoton boton = new EventoBoton();
        add(boton);
    }
}

class EventoBoton extends JPanel implements ActionListener { // el oyente es la propia clase

    JButton botonAzul = new JButton("Botón Azul"); // fuente 1
    JButton botonAmarillo = new JButton("Botón Amarillo"); // fuente 2
    JButton botonRojo = new JButton("Botón Rojo"); // fuente 3

    public EventoBoton() {
        add(botonAzul);
        add(botonAmarillo);
        add(botonRojo);

        botonAzul.addActionListener(this); // el evento quiere decir: al hacer click...
        botonAmarillo.addActionListener(this);
        botonRojo.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Object botonPulsado = e.getSource(); // para obtener el botón pulsado

        if (botonPulsado == botonAzul)
            setBackground(Color.BLUE);
        if (botonPulsado == botonAmarillo)
            setBackground(Color.YELLOW);
        if (botonPulsado == botonRojo)
            setBackground(Color.RED);
    }
}
