package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;

public class Conexion {
    private static Logger logger = Logger.getLogger(Conexion.class.getName());
    private static final String URL = "jdbc:mysql://localhost:3306/Universidad2";
    private static final String USER = "root";
    private static final String PASSWORD = "root";


    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static void closeConnection(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void Conexion() {

        Connection conn = null;
        try {
            conn = Conexion.getConnection();

            logger.info("Conexion Exitosa");

        } catch (SQLException ex) {
            ex.printStackTrace();
            logger.info("No se pudo conectar a la base de datos");

        } finally {
            Conexion.closeConnection(conn);
            logger.info("La conexion se cerro");
        }
    }


}
