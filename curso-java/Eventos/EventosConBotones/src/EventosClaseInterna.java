import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.event.*;

public class EventosClaseInterna {
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

class EventoBoton extends JPanel { // el oyente es la propia clase

    JButton botonAzul = new JButton("Botón Azul"); // fuente 1
    JButton botonAmarillo = new JButton("Botón Amarillo"); // fuente 2
    JButton botonRojo = new JButton("Botón Rojo"); // fuente 3

    public EventoBoton() {
        add(botonAzul);
        add(botonAmarillo);
        add(botonRojo);

        ColorFondo azul = new ColorFondo(Color.BLUE);
        ColorFondo amarillo = new ColorFondo(Color.yellow);
        ColorFondo rojo = new ColorFondo(Color.red);

        botonAzul.addActionListener(azul); // el evento quiere decir: al hacer click...
        botonAmarillo.addActionListener(amarillo);
        botonRojo.addActionListener(rojo);
    }

    private class ColorFondo implements ActionListener {

        public ColorFondo(Color color) {
            this.color = color;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            setBackground(color);
        }

        private Color color;
    }
}
