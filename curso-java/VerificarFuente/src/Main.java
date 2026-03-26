import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) throws Exception {

        // Pedimos al usuario que introduzca el nombre de una fuente
        String fuente = JOptionPane.showInputDialog("Introduce el nombre de la fuente");
        
        // Obtenemos el nombre de las fuentes por defecto
        String[] nombresDeFuentes = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        
        boolean aux = false; // Variable auxiliar para saber si la fuente existe o no

        // Recorremos el array de nombres de fuentes
        for(int i = 0; i < nombresDeFuentes.length; i++) {
            if (nombresDeFuentes[i].equals(fuente)) // Si el nombre de la fuente introducida por el usuario es igual a uno de los nombres de las fuentes por defecto
                aux = true; // La fuente existe
        }

        if(aux) {
            JOptionPane.showMessageDialog(null, "La fuente " + fuente + " existe"); // Si aux es true, la fuente existe
        } else {
            JOptionPane.showMessageDialog(null, "La fuente " + fuente + " no existe"); // Si aux es false, la fuente no existe
        }
    }
}
