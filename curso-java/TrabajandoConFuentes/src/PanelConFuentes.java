import javax.swing.*;
import java.awt.*;

public class PanelConFuentes extends JPanel {
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        Font miFuente = new Font("Lucida Sans", Font.BOLD, 24);
        g2.setFont(miFuente);
        g2.drawString("Me llamo Jesuuca", 100, 100);
        // alguna fuente cool para usar, las que son por defecto del sistema
        // son: Serif, SansSerif, Monospaced, Dialog, DialogInput

        g2.setFont(new Font("Serif", Font.ITALIC, 24));
        g2.drawString("Curso de java pildorasinformaticas", 100, 150);
}
    
}
