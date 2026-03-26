package graficos;
import javax.swing.*;

import java.awt.*;
import javax.imageio.*;
import java.io.*;

public class PruebaImagenes {
    
    public static void main(String[] args) {
        MarcoConImagenes miMarco = new MarcoConImagenes();
        miMarco.setVisible(true);
        miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        miMarco.setLocationRelativeTo(null);
    }

}

class MarcoConImagenes extends JFrame {

    public MarcoConImagenes() {
        setTitle("Marco con Imagen");
        setBounds(750, 300, 600, 600);
        LaminaConImagenes miLamina = new LaminaConImagenes();
        add(miLamina);
    }   

}

class LaminaConImagenes extends JPanel {

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        File miImagen = new File("src/graficos/cafe.png");
        try {
            imagen = ImageIO.read(miImagen);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "La imagen no se encuentra");
            
            System.out.println("la imagen no se encuentra");
            e.printStackTrace();

            // si el usario le da ok, el programa se cerrará
            System.exit(0);
        }

        g.drawImage(imagen, 0, 0, null);
        g.copyArea(0, 0, 15, 15, 150, 75);

    }

    private Image imagen;

}