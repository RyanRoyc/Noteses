package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = System.getenv("DB_URL");
    private static final String USERNAME = System.getenv("DB_USERNAME");
    private static final String PASSWORD = System.getenv("DB_PASSWORD");

    private static final String DRIVER_CLASS = "org.postgresql.Driver";

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        try {
            // Forcefully load the driver
            Class.forName(DRIVER_CLASS);
        } catch (ClassNotFoundException e) {
            throw new ClassNotFoundException("PostgreSQL JDBC Driver not found in classpath!", e);
        }

        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }
}
