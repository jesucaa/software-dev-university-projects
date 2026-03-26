package EventoBotonNormal;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

public class LaminaBoton extends JPanel implements ActionListener {
   JButton botonAzul = new JButton("Azul");
   
   public LaminaBoton() {
      add(botonAzul);
      botonAzul.addActionListener(this);
   }

   @Override
   public void actionPerformed(ActionEvent e) {
      setBackground(Color.BLUE);
   }
}
