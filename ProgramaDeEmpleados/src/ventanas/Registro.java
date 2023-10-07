package ventanas;

import java.sql.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import conexion.*;
import java.awt.Image;

import javax.swing.*;

public class Registro extends JFrame {
    ConexionSQL con = new ConexionSQL();
    Connection conectar = con.conexion();
    
    private void actualizarVentana() {
        txtUsuario.setEnabled(true);
        refrescarCamposDeTexto();
    }

    private void refrescarCamposDeTexto() {
        txtUsuario.setText(null);
        contraseñaField.setText(null);
        txtNumeroDeTelefono.setText(null);
        txtCorreoElectronico.setText(null);
    }
    
    private void registrarUsuario() {
        //Connection con = null;
        String contraseña = String.valueOf(contraseñaField.getPassword());
        String sql = "insert into tabla_usuarios (usuario, contraseña, numero_telefono, correo_electronico) values(?,?,?,?)"; 
                
        try {
            PreparedStatement ps = conectar.prepareStatement(sql); // PrepareStatement es para escribir como script en una base de datos
            ps.setString(1, txtUsuario.getText());
            ps.setString(2, contraseña);
            ps.setString(3, txtNumeroDeTelefono.getText());
            ps.setString(4, txtCorreoElectronico.getText());

            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Usuario Guardado", "Registro Exitoso", 1);

            refrescarCamposDeTexto();

            //conectar.close(); //Cerramos conexión

        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", 0);
            refrescarCamposDeTexto();
        }
    }
    
    private void buscarUsuario() {
        try {
            PreparedStatement ps = conectar.prepareStatement("SELECT * FROM  tabla_usuarios WHERE usuario = ?");
            ps.setString(1, txtUsuario.getText());

            ResultSet rs;
            rs = ps.executeQuery();

            if(rs.next()) {
                txtUsuario.setText(rs.getString("usuario"));
                contraseñaField.setText(rs.getString("contraseña"));
                txtNumeroDeTelefono.setText(rs.getString("numero_telefono"));
                txtCorreoElectronico.setText(rs.getString("correo_electronico"));

                JOptionPane.showMessageDialog(null, "Usuario encontrado", "Encontrado", 1);
            } else {
                JOptionPane.showMessageDialog(null, "No existe este nombre de usuario", "error", 0);
                refrescarCamposDeTexto();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            System.err.println(e);
        }
        
        txtUsuario.setEnabled(false);
    }
    
    private void modificarUsuario() {
        String contraseña = String.valueOf(contraseñaField.getPassword());
        String sql = "UPDATE tabla_usuarios SET usuario=?, contraseña=?, numero_telefono=?, correo_electronico=? WHERE usuario=?"; 
                
        try {
            PreparedStatement ps = conectar.prepareStatement(sql); // PrepareStatement es para escribir como script en una base de datos
            ps.setString(1, txtUsuario.getText());
            ps.setString(2, contraseña);
            ps.setString(3, txtNumeroDeTelefono.getText());
            ps.setString(4, txtCorreoElectronico.getText());
            ps.setString(5, txtUsuario.getText());
            
            

            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Datos del usuario Modificados", "Modificación Exitosa", 1);
            txtUsuario.setEnabled(true);

            refrescarCamposDeTexto();

            //conectar.close(); //Cerramos conexión

        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", 0);
            txtUsuario.setEnabled(true);
            refrescarCamposDeTexto();
        }
    }
    
    private void eliminarUsuario() {
        String contraseña = String.valueOf(contraseñaField.getPassword());
        String sql = "DELETE FROM tabla_usuarios WHERE usuario=?"; 
                
        try {
            PreparedStatement ps = conectar.prepareStatement(sql); // PrepareStatement es para escribir como script en una base de datos
            ps.setString(1, txtUsuario.getText());

            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Usuario '"+txtUsuario.getText()+"' Eliminado", "Eliminado", 1);
            txtUsuario.setEnabled(true);

            refrescarCamposDeTexto();

            //conectar.close(); //Cerramos conexión

        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", 0);
            txtUsuario.setEnabled(true);
            refrescarCamposDeTexto();
        }
    }
    
    private void regresarVentanaPrincipal() {
        dispose();
        VentanaPrincipal ventanaPrincipal = new VentanaPrincipal();
        ventanaPrincipal.setVisible(true);
    }
    
    private JPanel panel;
    private JLabel registroLabel;
    private JLabel nombreDeUsuarioLabel;
    private JLabel numeroDeTelefonoLabel;
    private JLabel correoElectronicoLabel;
    private JTextField txtUsuario;
    private JPasswordField contraseñaField;
    private JTextField txtNumeroDeTelefono;
    private JTextField txtCorreoElectronico;
    private JButton btnRegistrar;
    private JButton btnModificar;
    private JButton btnEliminar;
    private JButton btnBuscar;
    private JButton btnActualizarVentana;
    private JButton btnRegresar;
    private JButton btnSalir;
    
    //Creación de la ventana
    public Registro() {
        this.setSize(700, 700);
        this.setTitle("Registro");
        this.setLocationRelativeTo(null);

        iniciarComponentes();

        setDefaultCloseOperation(EXIT_ON_CLOSE); //Cuando cierre la ventana, termina la ejecución
    }

    private void iniciarComponentes() {
        colocarPanel();
        colocarEtiquetas();
        colocarCajaTxt();
        colocarBoton();
    }

    private void colocarPanel() {
        panel = new JPanel(); //Creamos el panel
        panel.setLayout(null); //Desactivamos el diseño(layout) para poder mover de posición los componentes
        this.getContentPane().add(panel); //Agregamos el panel a la ventana
    }

    private void colocarEtiquetas() {
        //Etiqueta tipo imagen - Registro
        ImageIcon imagenRegistro = new ImageIcon("registro.png"); //Llamanos a la imagen
        JLabel iconoRegistro = new JLabel(); //Creamos una nueva etiqueta
        iconoRegistro.setBounds(170, 30, 310, 122); //Establecemos la posición de la etiqueta y el tamaño
        iconoRegistro.setIcon(new ImageIcon(imagenRegistro.getImage().getScaledInstance(iconoRegistro.getWidth(), iconoRegistro.getHeight(), Image.SCALE_SMOOTH)));  //Cambiamos el tamaño de  la imagen
        panel.add(iconoRegistro); //Agregamos la etiqueta al panel

        //Etiqueta - Crea un nombre de usuario
        nombreDeUsuarioLabel = new JLabel(); //Creamos la etiqueta
        //nombreDeUsuarioLabel.setOpaque(true);
        //nombreDeUsuarioLabel.setBackground(Color.DARK_GRAY); //Cambiamos el color de  fondo de la etiqueta
        nombreDeUsuarioLabel.setBounds(182, 170, 235, 20);
        nombreDeUsuarioLabel.setHorizontalAlignment(SwingConstants.CENTER); //Establecemos la alineación horizontal del texto
        nombreDeUsuarioLabel.setForeground(Color.BLACK); //Cambiamos el color de la etiqueta
        nombreDeUsuarioLabel.setFont(new Font("monaco", Font.BOLD, 15)); //Establecemos la fuente
        nombreDeUsuarioLabel.setText("Crea un nombre de usuario:"); //Establecemos el texto de la etiqueta
        panel.add(nombreDeUsuarioLabel); //Agregamos la etiqueta al panel

        //Etiqueta - Crea una contraseña
        registroLabel = new JLabel(); //Creamos la etiqueta
        //registroLabel.setOpaque(true); //Estamos dando permiso para poder pintar el fondo de la etiqueta
        //registroLabel.setBackground(Color.DARK_GRAY); //Cambiamos el color de  fondo de la etiqueta
        registroLabel.setBounds(182, 270, 180, 20);
        registroLabel.setHorizontalAlignment(SwingConstants.CENTER); //Establecemos la alineación horizontal del texto
        registroLabel.setForeground(Color.BLACK); //Cambiamos el color de la etiqueta
        registroLabel.setFont(new Font("monaco", Font.BOLD, 15)); //Establecemos la fuente
        registroLabel.setText("Crea una contraseña:"); //Establecemos el texto de la etiqueta
        panel.add(registroLabel); //Agregamos la etiqueta al panel

        //Etiqueta - Ingresa tu número de télefono
        numeroDeTelefonoLabel = new JLabel(); //Creamos la etiqueta
        //numeroDeTelefonoLabel.setOpaque(true); //Estamos dando permiso para poder pintar el fondo de la etiqueta
        //numeroDeTelefonoLabel.setBackground(Color.DARK_GRAY); //Cambiamos el color de  fondo de la etiqueta
        numeroDeTelefonoLabel.setBounds(182, 370, 270, 20);
        numeroDeTelefonoLabel.setHorizontalAlignment(SwingConstants.CENTER); //Establecemos la alineación horizontal del texto
        numeroDeTelefonoLabel.setForeground(Color.BLACK); //Cambiamos el color de la etiqueta
        numeroDeTelefonoLabel.setFont(new Font("monaco", Font.BOLD, 15)); //Establecemos la fuente
        numeroDeTelefonoLabel.setText("Ingresa un número de télefono:"); //Establecemos el texto de la etiqueta
        panel.add(numeroDeTelefonoLabel); //Agregamos la etiqueta al panel

        //Etiqueta - Ingresa tu correo electronico
        correoElectronicoLabel = new JLabel(); //Creamos la etiqueta
        //correoElectronicoLabel.setOpaque(true); //Estamos dando permiso para poder pintar el fondo de la etiqueta
        //correoElectronicoLabel.setBackground(Color.DARK_GRAY); //Cambiamos el color de  fondo de la etiqueta
        correoElectronicoLabel.setBounds(180, 470, 270, 20);
        correoElectronicoLabel.setHorizontalAlignment(SwingConstants.CENTER); //Establecemos la alineación horizontal del texto
        correoElectronicoLabel.setForeground(Color.BLACK); //Cambiamos el color de la etiqueta
        correoElectronicoLabel.setFont(new Font("monaco", Font.BOLD, 15)); //Establecemos la fuente
        correoElectronicoLabel.setText("Ingresa un correo electronico:"); //Establecemos el texto de la etiqueta
        panel.add(correoElectronicoLabel); //Agregamos la etiqueta al panel
    }

    private void colocarCajaTxt() {
        //Caja de texto 1 - Nombre de Usuario
        txtUsuario = new JTextField();
        txtUsuario.setBounds(186, 205, 300, 30);
        panel.add(txtUsuario);

        //x = 96					y = 310 
        //Caja de texto 2 - Contraseña
        contraseñaField = new JPasswordField();
        contraseñaField.setBounds(186, 305, 300, 30);
        panel.add(contraseñaField);

        //x = 96					y = 390
        //Caja de texto 3 - Número de télefono
        txtNumeroDeTelefono = new JTextField();
        txtNumeroDeTelefono.setBounds(186, 405, 300, 30);
        panel.add(txtNumeroDeTelefono);

        //x = 96					y = 470
        //Caja de texto 4 - Correo Electronico
        txtCorreoElectronico = new JTextField();
        txtCorreoElectronico.setBounds(186, 505, 300, 30);
        panel.add(txtCorreoElectronico);
    }

    private void colocarBoton() {
        //Botón - Registrar
        btnRegistrar = new JButton();
        btnRegistrar.setBounds(258, 570, 160, 30);
        btnRegistrar.setForeground(Color.DARK_GRAY);
        btnRegistrar.setFont(new Font("mangal", Font.BOLD, 15));
        btnRegistrar.setText("Registrar");
        panel.add(btnRegistrar);
        
        //Botón - Buscar
        btnBuscar = new JButton();
        btnBuscar.setBounds(520, 205, 120, 30);
        btnBuscar.setForeground(Color.DARK_GRAY);
        btnBuscar.setFont(new Font("monaco", Font.BOLD, 15));
        btnBuscar.setText("Buscar");
        panel.add(btnBuscar);
        
        //Botón - Eliminar
        btnEliminar = new JButton();
        btnEliminar.setBounds(30, 280, 115, 30);
        btnEliminar.setForeground(Color.DARK_GRAY);
        btnEliminar.setFont(new Font("monaco", Font.BOLD, 15));
        btnEliminar.setText("Eliminar");
        panel.add(btnEliminar);
        
        //Botón - Modificar
        btnModificar = new JButton();
        btnModificar.setBounds(30, 340, 115, 30);
        btnModificar.setForeground(Color.DARK_GRAY);
        btnModificar.setFont(new Font("monaco", Font.BOLD, 15));
        btnModificar.setText("Modificar");
        panel.add(btnModificar);
        
        //Botón - Actualizar Ventana
        btnActualizarVentana = new JButton();
        btnActualizarVentana.setBounds(290, 15, 190, 30);
        btnActualizarVentana.setForeground(Color.DARK_GRAY);
        btnActualizarVentana.setFont(new Font("monaco", Font.BOLD, 15));
        btnActualizarVentana.setText("Actualizar Ventana");
        panel.add(btnActualizarVentana);
        
        //Botón - botón de imagen - Regresar
        btnRegresar = new JButton();
        btnRegresar.setBounds(50, 75, 50, 50);
        ImageIcon regresar = new ImageIcon("atras.png");
        btnRegresar.setIcon(new ImageIcon(regresar.getImage().getScaledInstance(btnRegresar.getWidth(), btnRegresar.getHeight(), Image.SCALE_SMOOTH)));
        panel.add(btnRegresar);
        
        //Botón - botón de imagen - Salir
        btnSalir = new JButton();
        btnSalir.setBounds(50, 570, 50, 50);
        //botonDeImagen.setOpaque(true);
        //botonDeImagen.setBackground(Color.BLACK); //Establecemos el color de fondo del botón
        ImageIcon exit = new ImageIcon("salida.png");
        btnSalir.setIcon(new ImageIcon(exit.getImage().getScaledInstance(btnSalir.getWidth(), btnSalir.getHeight(), Image.SCALE_SMOOTH)));
        panel.add(btnSalir);

        accionesOyentesDeBotones();
    }
    
    private void accionesOyentesDeBotones() {
        //Evento de botón - Acción Actualizar Ventana
        ActionListener accionActualizarVentana = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                actualizarVentana();
            }
        };
        btnActualizarVentana.addActionListener(accionActualizarVentana);
        
        //Evento de botón - Acción Registrar
        ActionListener accionRegistrar = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                registrarUsuario();
            }
        };
        btnRegistrar.addActionListener(accionRegistrar);
        
        //Evento de botón - Acción Buscar
        ActionListener accionBuscar = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                buscarUsuario();
            }
        };
        btnBuscar.addActionListener(accionBuscar);
        
        //Evento de botón - Acción Regresar
        ActionListener accionRegresar = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                regresarVentanaPrincipal();
            }  
        };
        btnRegresar.addActionListener(accionRegresar);
        
        //Evento de botón - Acción Eliminar
        ActionListener accionEliminar = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                eliminarUsuario();
            }  
        };
        btnEliminar.addActionListener(accionEliminar);
        
        //Evento de botón - Acción Modificar
        ActionListener accionModificar = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                modificarUsuario();
            }  
        };
        btnModificar.addActionListener(accionModificar);
        
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
