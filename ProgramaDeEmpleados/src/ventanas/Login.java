package ventanas;

import conexion.ConexionSQL;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.ImageIcon;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JFrame {
    
    ConexionSQL con = new ConexionSQL();
    Connection conectar = con.conexion();
    
    public void refrescarCamposDeTexto() {
        txtUsuario.setText("");
        contraseñaField.setText("");
    }
    
    public void ingresarUsuario() {
        
        int resultado = 0;
        String contraseña = String.valueOf(contraseñaField.getPassword());
        String usuario = txtUsuario.getText();
        
        String sql = "select * from tabla_usuarios where usuario = '" + usuario 
                + "' and contraseña = '" + contraseña + "' ";
        
        try {
            Statement st = conectar.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            if(rs.next()) {
                
                JOptionPane.showMessageDialog(null, "Inicio de sesión exitoso",
                        "Iniciaste sesión", JOptionPane.INFORMATION_MESSAGE);
                
                resultado = 1;
                
                if(resultado == 1) {
                    MostrarUsuarios home = new MostrarUsuarios();
                    home.setLocationRelativeTo(home);
                    home.setVisible(true);
                    this.dispose();
                    System.out.println("Ventana con funciones en desarrollo...\n"
                            + "Esta ventana solo muestra todos los datos existentes "
                            + "dentro de la base de datos (usuarios registrados).\n"
                            + "En esta parte tengo pensado añadirle las funciones de "
                            + "eliminar, modificar y actualizar datos.");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Error de Acceso, Usuario No Registrado");
                refrescarCamposDeTexto();
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error " + e.getMessage());
        }  
    }

    private JPanel panel;
    public JTextField txtUsuario;
    public String nombreUsuario;
    private JPasswordField contraseñaField;
    private JButton btnOk;
    private JButton btnRegresar;
    private JButton btnSalir;

    //Constructor de la ventana
    public Login() {
        this.setBounds(50, 50, 650, 500); //Establecemos el tamaño de la ventana
        this.setTitle("Login"); //Titulo de la ventana
        this.setLocationRelativeTo(null); //Establecemos la ventana en el centro de la pantalla
        //setMinimumSize(new Dimension(200,200)); //Establecemos el tamaño minimo

        iniciarComponentes(); //Iniciamos los componentes

        setDefaultCloseOperation(EXIT_ON_CLOSE); //Cuando cierre la ventana, termina la ejecución
    }

    private void iniciarComponentes() {
        colocarPanel();
        colocarEtiqueta();
        cajaTxtUsuario();
        cajaTxtContraseña();
        colocarBoton();
    }

    private void colocarPanel() {
        panel = new JPanel(); //Creamos el panel
        panel.setLayout(null); //Desactivamos el diseño(layout) para poder mover de posición los componentes
        this.getContentPane().add(panel); //Agregamos el panel a la ventana
    }

    private void colocarEtiqueta() {
        //Etiqueta tipo imagen - Iniciar Sesión
        ImageIcon imagenIniciarSesion = new ImageIcon("Boton_ini_1.png"); //Llamanos a la imagen
        JLabel iconoIniciarSesion = new JLabel(); //Creamos una nueva etiqueta
        iconoIniciarSesion.setBounds(160, 30, 310, 130); //Establecemos la posición de la etiqueta y el tamaño
        iconoIniciarSesion.setIcon(new ImageIcon(imagenIniciarSesion.getImage().getScaledInstance(iconoIniciarSesion.getWidth(), 
                iconoIniciarSesion.getHeight(), Image.SCALE_SMOOTH)));  //Cambiamos el tamaño de  la imagen
        panel.add(iconoIniciarSesion); //Agregamos la etiqueta al panel

        //Etiqueta 2 - etiqueta de texto - "Usuario"
        JLabel usuarioLabel = new JLabel();
        usuarioLabel.setText("Usuario:");
        usuarioLabel.setFont(new Font("monaco", Font.BOLD, 15));
        usuarioLabel.setBounds(169, 180, 120, 20);
        panel.add(usuarioLabel);

        //Etiqueta 3 - etiqueta de texto - "Contraseña"
        JLabel contraseñaLabel = new JLabel();
        contraseñaLabel.setText("Contraseña:");
        contraseñaLabel.setFont(new Font("monaco", Font.BOLD, 15));
        contraseñaLabel.setBounds(169, 260, 120, 20);
        panel.add(contraseñaLabel);
    }

    public void cajaTxtUsuario() {
        //Caja de texto 1 - Nombre de Usuario
        txtUsuario = new JTextField();
        txtUsuario.setBounds(166, 210, 300, 30);
        panel.add(txtUsuario);
    }

    private void cajaTxtContraseña() {
        //Caja de texto 2 - Contraseña
        contraseñaField = new JPasswordField();
        contraseñaField.setBounds(166, 290, 300, 30);
        panel.add(contraseñaField);
    }

    private void colocarBoton() {
        //Botón - botón de imagen - Regresar
        btnRegresar = new JButton();
        btnRegresar.setBounds(50, 75, 50, 50);
        ImageIcon regresar = new ImageIcon("atras.png");
        btnRegresar.setIcon(new ImageIcon(regresar.getImage().getScaledInstance(btnRegresar.getWidth(), btnRegresar.getHeight(), Image.SCALE_SMOOTH)));
        panel.add(btnRegresar);
        
        btnOk = new JButton(); //Creamos el botón
        btnOk.setText("Ok");
        btnOk.setBounds(270, 350, 90, 40);
        btnOk.setForeground(Color.DARK_GRAY);
        btnOk.setFont(new Font("mangal", Font.BOLD, 15));
        panel.add(btnOk); //Agregamos el botón al panel
        
        //Botón - botón de imagen - Salir
        btnSalir = new JButton();
        btnSalir.setBounds(50, 360, 50, 50);
        //botonDeImagen.setOpaque(true);
        //botonDeImagen.setBackground(Color.BLACK); //Establecemos el color de fondo del botón
        ImageIcon exit = new ImageIcon("salida.png");
        btnSalir.setIcon(new ImageIcon(exit.getImage().getScaledInstance(btnSalir.getWidth(), btnSalir.getHeight(), Image.SCALE_SMOOTH)));
        panel.add(btnSalir);

        accionesOyentesDeBotones();
        eventoDelTeclado();
    }

    private void accionesOyentesDeBotones() {
        //Agregamos Evento de tipo ActionListener
        ActionListener accionOk = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ingresarUsuario();
            }
        };
        btnOk.addActionListener(accionOk);

    }

    private void eventoDelTeclado() {
        KeyListener eventoTeclado = new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {
                if (e.getKeyChar() == '\n') {
                    ingresarUsuario();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }
        };
        btnOk.addKeyListener(eventoTeclado);
        
        ActionListener accionOk = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                ingresarUsuario();
            }  
        };
        btnOk.addActionListener(accionOk);
        
        ActionListener accionRegresar = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                dispose();
                VentanaPrincipal ventanaPrincipal = new VentanaPrincipal();
                ventanaPrincipal.setVisible(true);
            }  
        };
        btnRegresar.addActionListener(accionRegresar);
        
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
