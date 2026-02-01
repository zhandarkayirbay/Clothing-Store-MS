package menu;

import database.ProductDAO;
import exception.InvalidInputException;
import model.ClothingItem;
import model.Jacket;
import model.Shirt;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuManager implements Menu {

    // =================================================
    // ================= WEEK 7 ========================
    // RAM + OOP + POLYMORPHISM
    // =================================================

    private ArrayList<ClothingItem> items;

    // =================================================
    // ================= COMMON ========================
    // =================================================

    private final Scanner scanner;
    private final ProductDAO productDAO;

    public MenuManager() {
        this.items = new ArrayList<>();
        this.scanner = new Scanner(System.in);
        this.productDAO = new ProductDAO();
    }

    @Override
    public void displayMenu() {
        System.out.println("\n========================================");
        System.out.println("      CLOTHING STORE MANAGEMENT");
        System.out.println("========================================");

        // -------- WEEK 7 --------
        System.out.println("1. Add Shirt (Week 7)");
        System.out.println("2. Add Jacket (Week 7)");
        System.out.println("3. View All Products (DB)");
        System.out.println("4. View Shirts Only (RAM)");
        System.out.println("5. View Jackets Only (RAM)");
        System.out.println("6. Demonstrate Polymorphism");

        // -------- WEEK 8 --------
        System.out.println("----------- WEEK 8 -----------");
        System.out.println("7. Update Product Price");
        System.out.println("8. Update Product Quantity");
        System.out.println("9. Delete Product by ID");
        System.out.println("10. Search Product by Name");
        System.out.println("11. Search by Price Range");
        System.out.println("12. Search by Min Price");

        System.out.println("0. Exit");
        System.out.println("========================================");
    }

    @Override
    public void run() {
        boolean running = true;

        while (running) {
            displayMenu();
            System.out.print("Enter your choice: ");

            try {
                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {

                    // ===== WEEK 7 =====
                    case 1 -> addShirt();
                    case 2 -> addJacket();
                    case 3 -> productDAO.getAllProducts();
                    case 4 -> viewShirtsOnly();
                    case 5 -> viewJacketsOnly();
                    case 6 -> demonstratePolymorphism();

                    // ===== WEEK 8 =====
                    case 7 -> updatePrice();
                    case 8 -> updateQuantity();
                    case 9 -> deleteProduct();
                    case 10 -> searchByName();
                    case 11 -> searchByPriceRange();
                    case 12 -> searchByMinPrice();

                    case 0 -> {
                        running = false;
                        System.out.println("Goodbye!");
                    }

                    default -> throw new InvalidInputException("Invalid menu choice!");

                }

            } catch (NumberFormatException e) {
                System.out.println("❌ Please enter a number!");
            } catch (InvalidInputException | IllegalArgumentException e) {
                System.out.println("❌ " + e.getMessage());
            }
        }
    }

    // =================================================
    // ================= WEEK 7 ========================
    // =================================================

    private void addShirt() {
        try {
            System.out.print("Name: ");
            String name = scanner.nextLine();

            System.out.print("Size: ");
            String size = scanner.nextLine();

            System.out.print("Price: ");
            double price = Double.parseDouble(scanner.nextLine());

            System.out.print("Long sleeve (true/false): ");
            boolean longSleeve = Boolean.parseBoolean(scanner.nextLine());

            System.out.print("Material: ");
            String material = scanner.nextLine();

            System.out.print("Quantity: ");
            int quantity = Integer.parseInt(scanner.nextLine());

            Shirt shirt = new Shirt(name, size, price, longSleeve, material, quantity);

            // RAM (Week 7)
            items.add(shirt);

            // DATABASE
            productDAO.insertProduct(name, size, price, quantity);

            System.out.println("✅ Shirt added (Week 7 + DB)");

        } catch (NumberFormatException e) {
            System.out.println("❌ Invalid input!");
        }
    }

    private void addJacket() {
        try {
            System.out.print("Name: ");
            String name = scanner.nextLine();

            System.out.print("Size: ");
            String size = scanner.nextLine();

            System.out.print("Price: ");
            double price = Double.parseDouble(scanner.nextLine());

            System.out.print("Waterproof (true/false): ");
            boolean waterproof = Boolean.parseBoolean(scanner.nextLine());

            System.out.print("Season: ");
            String season = scanner.nextLine();

            Jacket jacket = new Jacket(name, size, price, waterproof, season);
            items.add(jacket);

            System.out.println("✅ Jacket added (RAM only)");

        } catch (NumberFormatException e) {
            System.out.println("❌ Invalid input!");
        }
    }

    private void viewShirtsOnly() {
        for (ClothingItem item : items) {
            if (item instanceof Shirt) {
                System.out.println(item);
            }
        }
    }

    private void viewJacketsOnly() {
        for (ClothingItem item : items) {
            if (item instanceof Jacket) {
                System.out.println(item);
            }
        }
    }

    private void demonstratePolymorphism() {
        for (ClothingItem item : items) {
            System.out.println("Item type: " + item.getType());
        }
    }

    // =================================================
    // ================= WEEK 8 ========================
    // =================================================

    private void updatePrice() {
        System.out.print("Product ID: ");
        int id = Integer.parseInt(scanner.nextLine());

        System.out.print("New price: ");
        double price = Double.parseDouble(scanner.nextLine());

        productDAO.updatePrice(id, price);
    }

    private void updateQuantity() {
        System.out.print("Product ID: ");
        int id = Integer.parseInt(scanner.nextLine());

        System.out.print("New quantity: ");
        int qty = Integer.parseInt(scanner.nextLine());

        productDAO.updateQuantity(id, qty);
    }

    private void deleteProduct() {
        System.out.print("Product ID to delete: ");
        int id = Integer.parseInt(scanner.nextLine());

        System.out.print("Are you sure? (yes/no): ");
        String confirm = scanner.nextLine();

        if (confirm.equalsIgnoreCase("yes")) {
            productDAO.deleteProduct(id);
        } else {
            System.out.println("❌ Deletion cancelled");
        }
    }

    private void searchByName() {
        System.out.print("Enter keyword: ");
        String keyword = scanner.nextLine();
        productDAO.searchByName(keyword);
    }

    private void searchByPriceRange() {
        System.out.print("Min price: ");
        double min = Double.parseDouble(scanner.nextLine());

        System.out.print("Max price: ");
        double max = Double.parseDouble(scanner.nextLine());

        productDAO.searchByPriceRange(min, max);
    }

    private void searchByMinPrice() {
        System.out.print("Min price: ");
        double min = Double.parseDouble(scanner.nextLine());
        productDAO.searchByMinPrice(min);
    }
}
