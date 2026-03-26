package eventos;
import java.awt.event.*;

public class EventosDeVentana implements WindowListener{

    @Override
    public void windowOpened(WindowEvent e) {
        System.out.println("Ventana abierta");
    }

    @Override
    public void windowClosing(WindowEvent e) {
        System.out.println("Cerrando ventana");
    }

    @Override
    public void windowClosed(WindowEvent e) {
        
    }

    @Override
    public void windowIconified(WindowEvent e) {
        System.out.println("Ventana minimizada");
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        System.out.println("Ventana restaurada");
    }

    @Override
    public void windowActivated(WindowEvent e) {
        System.out.println("Ventana activada");
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        System.out.println("Ventana desactivada");
    }
    
}
