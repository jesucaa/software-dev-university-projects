package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author jesuuca
 */
public class ConexionSQL {
    public static final String url = "jdbc:mysql://localhost:3306/db_programadeclientes"; // ruta de la base de datos
    public static final String username = "root";
    public static final String password = "355479@Kijete";
    
    //Conexión de la base de datos
    public static Connection conexion() {
        Connection conectar = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conectar = (Connection) DriverManager.getConnection(url, username, password);
            System.out.println("Conexión Exitosa");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de Conexión " + e.getMessage()); //Muestra el mensaje de error si no se puede conectar a la base de datos
        }
        return conectar;
    }
}
