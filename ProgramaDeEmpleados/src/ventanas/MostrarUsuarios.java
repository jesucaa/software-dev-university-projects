package ventanas;

import com.mysql.cj.xdevapi.Statement;
import conexion.ConexionSQL;
import java.awt.Font;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

//Esta ventana aún está en desarrollo
public class MostrarUsuarios extends JFrame {
    ConexionSQL con = new ConexionSQL();
    Connection conectar = con.conexion();
    
    private JLabel enDesarrollo;
    private JLabel explicacion;
    private JPanel panel;
    public String nombreUsuario;
    
    public MostrarUsuarios() {
        this.setSize(800, 800); //Establecemos el tamaño de la ventana
        this.setLocationRelativeTo(null); //Centramos la ventana en la pantalla
        this.setTitle("Mostrar Usuarios"); //Establecemos el titulo de la ventana

        iniciarComponentes(); //Iniciamos los componentes

        setDefaultCloseOperation(EXIT_ON_CLOSE); //Cuando cierre la ventana, termina la ejecución
    }

    private void iniciarComponentes() {
        colocarPanel();
        //colocarEtiqueta(); //Iniciamos la etiqueta
        mostrarUsuarios();
    }

    private void colocarPanel() {
        panel = new JPanel();
        panel.setLayout(null); //Desactivamos el diseño(layout) para poder mover de posición los componentes
        this.getContentPane().add(panel); //Agregamos el panel a la ventana

    }
    
    
    //Etiquetas sin ocupar
    private void colocarEtiqueta() {
        enDesarrollo = new JLabel();
        enDesarrollo.setFont(new Font("monaco", Font.BOLD, 30));
        enDesarrollo.setBounds(10, 100, 500, 30);
        enDesarrollo.setText("En desarrollo...");
        panel.add(enDesarrollo);
        
        explicacion = new JLabel();
        explicacion.setFont(new Font("monaco", Font.PLAIN, 15));
        explicacion.setBounds(80, 200, 600, 600);
        panel.add(explicacion);
    }
    
    
    private void mostrarUsuarios() {
        
        String sql = "select * from tabla_usuarios";
        DefaultTableModel model = new DefaultTableModel();
        
        JTable tabla = new JTable();
            
        model.addColumn("Nombre");
        model.addColumn("Contraseña");
        model.addColumn("Número de telefono");
        model.addColumn("Correo electronico");
        tabla.setModel(model);
        tabla.setBounds(50, 60, 800, 800);
        
        panel.add(tabla); 
        
        String[] dato = new String[4];
        
        try {
            java.sql.Statement st = conectar.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()) {
                dato[0] = rs.getString(1);
                dato[1] = rs.getString(2);
                dato[2] = rs.getString(3);
                dato[3] = rs.getString(4);
                model.addRow(dato);
            }
            tabla.setModel(model);
            
            //Mostramos en junto la tabla los nombres de las columnas
            JScrollPane sc = new JScrollPane(tabla);
            this.add(sc);
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error " + e.getMessage());
        }  
    }
    

    public JLabel getEnDesarrollo() {
        return enDesarrollo;
    }

    public void setEnDesarrollo(JLabel enDesarrollo) {
        this.enDesarrollo = enDesarrollo;
    }

    public JPanel getPanel() {
        return panel;
    }

    public void setPanel(JPanel panel) {
        this.panel = panel;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }
}
