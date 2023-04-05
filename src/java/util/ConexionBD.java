package util;

import java.sql.*;
import javax.swing.JOptionPane;

public class ConexionBD {

    Connection con;
    String url = "jdbc:mysql://localhost:3306/bdcitamedicaweb";
    String user = "root";
    String password = "";

    public Connection Conexion() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Error de Conexión, " + e.getMessage(), JOptionPane.ERROR_MESSAGE);
        }

        return con;
    }
        public static void main(String[] args) {
        ConexionBD ob = new ConexionBD();
        try {
            ob.Conexion();
            System.out.println("conectado");
        } catch (Exception e) {
            System.out.println("Desconectado");
        }
    }
}
