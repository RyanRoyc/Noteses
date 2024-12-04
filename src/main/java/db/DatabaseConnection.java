package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:postgresql://localhost:5432/notepad";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "pineapples";
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
