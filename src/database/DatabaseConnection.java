package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    // =================================================
    // ================= CONFIG ========================
    // =================================================

    private static final String URL =
            "jdbc:postgresql://localhost:5432/clothing_store_db";
    private static final String USER = "postgres";
    private static final String PASSWORD = "12345678";

    // =================================================
    // ================= CONNECTION ====================
    // =================================================

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.out.println("❌ Database connection failed");
            e.printStackTrace();
            return null;
        }
    }

    // =================================================
    // ================= CLOSE =========================
    // =================================================

    public static void close(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
