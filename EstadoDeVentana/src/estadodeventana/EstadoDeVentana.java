/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package estadodeventana;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowStateListener;
import javax.swing.JFrame;

/**
 *
 * @author zS19017419
 */
public class EstadoDeVentana extends JFrame {

    public EstadoDeVentana() {
        this.setTitle("Estado de Ventana");
        this.setSize(600, 400);
        this.setLocationRelativeTo(null);
        
        CtrlEstadoDeVentana estadoVentana = new CtrlEstadoDeVentana();
        this.addWindowStateListener(estadoVentana);
    }
    
    public static void main(String[] args) {
        EstadoDeVentana ventana = new EstadoDeVentana();
        ventana.setVisible(true);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }  
}

class CtrlEstadoDeVentana implements WindowStateListener {

    @Override
    public void windowStateChanged(WindowEvent e) {
        if (e.getNewState() == Frame.ICONIFIED) {
            System.out.println("La ventana ha sido minimizada");
        }
    }
    
}