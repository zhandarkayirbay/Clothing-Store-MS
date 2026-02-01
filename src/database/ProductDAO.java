package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductDAO {

    // =================================================
    // ================= WEEK 7 ========================
    // BASIC CRUD (INSERT + SELECT)
    // =================================================

    // ---------- INSERT ----------
    public boolean insertProduct(String name, String size, double price, int quantity) {

        String sql = """
                INSERT INTO product (name, size, price, quantity)
                VALUES (?, ?, ?, ?)
                """;

        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) return false;

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setString(1, name);
            stmt.setString(2, size);
            stmt.setDouble(3, price);
            stmt.setInt(4, quantity);

            stmt.executeUpdate();
            System.out.println("✅ Product inserted into database");
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;

        } finally {
            DatabaseConnection.close(connection);
        }
    }

    // ---------- SELECT ALL ----------
    public void getAllProducts() {

        String sql = "SELECT * FROM product ORDER BY product_id";

        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) return;

        try (
                PreparedStatement stmt = connection.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()
        ) {
            System.out.println("\n--- PRODUCTS FROM DATABASE ---");

            while (rs.next()) {
                System.out.println(
                        "ID: " + rs.getInt("product_id") +
                                ", Name: " + rs.getString("name") +
                                ", Size: " + rs.getString("size") +
                                ", Price: " + rs.getDouble("price") +
                                ", Quantity: " + rs.getInt("quantity")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            DatabaseConnection.close(connection);
        }
    }

    // =================================================
    // ================= WEEK 8 ========================
    // UPDATE / DELETE / SEARCH
    // =================================================

    // ---------- UPDATE PRICE ----------
    public boolean updatePrice(int id, double newPrice) {

        String sql = "UPDATE product SET price = ? WHERE product_id = ?";

        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) return false;

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setDouble(1, newPrice);
            stmt.setInt(2, id);
            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;

        } finally {
            DatabaseConnection.close(connection);
        }
    }

    // ---------- UPDATE QUANTITY ----------
    public boolean updateQuantity(int id, int quantity) {

        String sql = "UPDATE product SET quantity = ? WHERE product_id = ?";

        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) return false;

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setInt(1, quantity);
            stmt.setInt(2, id);
            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;

        } finally {
            DatabaseConnection.close(connection);
        }
    }

    // ---------- DELETE ----------
    public boolean deleteProduct(int id) {

        String sql = "DELETE FROM product WHERE product_id = ?";

        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) return false;

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;

        } finally {
            DatabaseConnection.close(connection);
        }
    }

    // ---------- SEARCH BY NAME ----------
    public void searchByName(String keyword) {

        String sql = """
                SELECT * FROM product
                WHERE name ILIKE ?
                """;

        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) return;

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setString(1, "%" + keyword + "%");
            ResultSet rs = stmt.executeQuery();

            System.out.println("\n--- SEARCH RESULT ---");

            while (rs.next()) {
                System.out.println(
                        rs.getInt("product_id") + " | " +
                                rs.getString("name") + " | " +
                                rs.getDouble("price")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            DatabaseConnection.close(connection);
        }
    }

    // ---------- SEARCH BY PRICE RANGE ----------
    public void searchByPriceRange(double min, double max) {

        String sql = """
                SELECT * FROM product
                WHERE price BETWEEN ? AND ?
                ORDER BY price DESC
                """;

        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) return;

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setDouble(1, min);
            stmt.setDouble(2, max);
            ResultSet rs = stmt.executeQuery();

            System.out.println("\n--- SEARCH RESULT ---");

            while (rs.next()) {
                System.out.println(
                        rs.getString("name") + " | " +
                                rs.getDouble("price")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            DatabaseConnection.close(connection);
        }
    }

    // ---------- SEARCH BY MIN PRICE ----------
    public void searchByMinPrice(double min) {

        String sql = """
                SELECT * FROM product
                WHERE price >= ?
                ORDER BY price DESC
                """;

        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) return;

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setDouble(1, min);
            ResultSet rs = stmt.executeQuery();

            System.out.println("\n--- SEARCH RESULT ---");

            while (rs.next()) {
                System.out.println(
                        rs.getString("name") + " | " +
                                rs.getDouble("price")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            DatabaseConnection.close(connection);
        }
    }
}
