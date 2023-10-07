package ventanas;

import conexion.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

/**
 *
 * @author jesuuca
 */
public class VentanaPrincipal extends JFrame { //Ventana heredada del JFrame

    private JPanel panel;
    private JButton btnIniciarSesion;
    private JButton btnRegistrarse;
    private JButton btnSalir;

    //Constructor de la clase VentanaPrincipal
    public VentanaPrincipal() {
        this.setTitle("Programa de Empleados"); //Establecemos el titulo de la ventana
        this.setSize(600, 600); //Establecemos el tamaño de la ventana
        setLocationRelativeTo(null); //Establecemos la ventana en el centro de la pantalla
        setMinimumSize(new Dimension(200, 200)); //Establecemos el tamaño minimo

        iniciarComponentes();

        setDefaultCloseOperation(EXIT_ON_CLOSE); //Cuando cierre la ventana, termina la ejecución
    }

    //En este método iniciaremos los diferentes tipos de componentes: panel, botones, etiquetas, etc
    private void iniciarComponentes() {
        colocarPanel();
        colocarEtiquetas();
        colocarBotones();
    }

    //Creación de panel
    private void colocarPanel() {
        panel = new JPanel(); //Creamos un panel
        //panel.setBackground(Color.PINK); //Establecemos el color del panel
        panel.setLayout(null); //Desactivamos el diseño(layout) para poder mover de posición los componentes
        this.getContentPane().add(panel); //Obtenemos el contenido con getContentPane() y con add(panel) agregamos el panel a la ventana
    }

    // Creación de etiquetas
    private void colocarEtiquetas() {
        //Etiqueta tipo imagen - titulo de la ventana principal
        ImageIcon imagenTitulo = new ImageIcon("srv-icono.png"); //Llamanos a la imagen
        JLabel iconoSRV = new JLabel(); //Creamos una nueva etiqueta
        iconoSRV.setBounds(258, 125, 80, 30); //Establecemos la posición de la etiqueta y el tamaño
        iconoSRV.setIcon(new ImageIcon(imagenTitulo.getImage().getScaledInstance(iconoSRV.getWidth(), iconoSRV.getHeight(), Image.SCALE_SMOOTH)));  //Cambiamos el tamaño de  la imagen
        panel.add(iconoSRV); //Agregamos la etiqueta al panel
        
        //Etiqueta de texto - Tlayudas
        JLabel tituloHome = new JLabel(); //Creamos una etiqueta
        tituloHome.setText("Tlayudas");
        tituloHome.setHorizontalAlignment(SwingConstants.CENTER); //Establecemos la alineación horizontal del texto
        //tituloHome.setOpaque(true); //Estamos dando permiso para poder pintar el fondo de la etiqueta
        tituloHome.setBounds(80, 95, 440, 200);
        tituloHome.setForeground(Color.BLACK); //Cambiamos el color de la etiqueta de texto
        //tituloHome.setBackground(Color.DARK_GRAY); //Cambiamos el color de  fondo de la etiqueta
        tituloHome.setFont(new Font("monaco", Font.BOLD, 40)); //Establecemos la fuente del texto
        panel.add(tituloHome); //Agregamos la etiqueta al panel

    }

    //Creación de botonesdministrarUsuarios
    private void colocarBotones() {
        //Botón - Iniciar Sesión
        btnIniciarSesion = new JButton(); //Creamos un botón
        btnIniciarSesion.setText("Iniciar Sesión");
        btnIniciarSesion.setBounds(150, 260, 300, 60);
        btnIniciarSesion.setForeground(Color.DARK_GRAY);
        btnIniciarSesion.setFont(new Font("mangal", Font.BOLD, 16));
        panel.add(btnIniciarSesion); //Agregamos el botón al panel

        //Botón - Registrarse
        btnRegistrarse = new JButton(); //Creamos un botón
        btnRegistrarse.setText("Registrarse");
        btnRegistrarse.setBounds(150, 360, 300, 60);
        //botonAdministrarUsuarios.setEnabled(false); //Esto sirve para habilitar y deshabilitar las funciones del botón
        //botonAdministrarUsuarios.setMnemonic('a'); //Establecemos alt + letra escrita dentro de este método para hacer funcionar al botón
        btnRegistrarse.setForeground(Color.DARK_GRAY);  //Establecemos el color de la letra del botón
        btnRegistrarse.setFont(new Font("mangal", Font.BOLD, 16)); //Establecemos la fuente de la letra del botón
        panel.add(btnRegistrarse); //Agregamos el botón al panel

        //Botón - botón de imagen 
        btnSalir = new JButton();
        btnSalir.setBounds(50, 460, 50, 50);
        //botonDeImagen.setOpaque(true);
        //botonDeImagen.setBackground(Color.BLACK); //Establecemos el color de fondo del botón
        ImageIcon exit = new ImageIcon("salida.png");
        btnSalir.setIcon(new ImageIcon(exit.getImage().getScaledInstance(btnSalir.getWidth(), btnSalir.getHeight(), Image.SCALE_SMOOTH)));
        panel.add(btnSalir);

        accionesOyentesDeBotones();
    }

    private void accionesOyentesDeBotones() {
        //Evento oyente del botón 1 - IniciarSesion
        ActionListener accionIniciarSesion = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Login login = new Login(); //Llamamos a la ventana Login
                login.setVisible(true); //Hacemos visible la ventana Login
                dispose(); //Cierra la ventana actual
            }
        };
        btnIniciarSesion.addActionListener(accionIniciarSesion);

        //Evento oyente del botón 2 - Administrar Usuarios
        ActionListener accionRegistrar = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Registro registro = new Registro();
                registro.setVisible(true);
                dispose();
            }
        };
        btnRegistrarse.addActionListener(accionRegistrar);

        //Evento oyente del botón 3 - Botón de imagen - Salir
        ActionListener accionSalir = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                int confirmarSalida = JOptionPane.showConfirmDialog(null, 
                        "¿Quieres salir del programa?", "exit", 
                        JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
                //0=yes, 1=no, 2=cancel
                if(confirmarSalida == 0) {
                    System.out.println("Saliendo del programa...");
                    JOptionPane.showMessageDialog(null, "¡Nos vemos pronto!", "exit", 1);
                    dispose();
                } else if(confirmarSalida == 1) {
                    System.out.println("Regresando al programa...");
                } else if(confirmarSalida == 2) {
                    System.out.println("Cancelando Salida...");
                }
            }
        };
        btnSalir.addActionListener(accionSalir);
    }

}
