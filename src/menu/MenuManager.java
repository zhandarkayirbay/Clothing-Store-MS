package menu;

import exception.InvalidInputException;
import model.ClothingItem;
import model.Jacket;
import model.Shirt;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuManager implements Menu {

    private ArrayList<ClothingItem> items;
    private Scanner scanner;

    public MenuManager() {
        this.items = new ArrayList<>();
        this.scanner = new Scanner(System.in);

        // Test data
        try {
            items.add(new Shirt("Classic Shirt", "M", 12000, true, "Cotton"));
            items.add(new Jacket("Winter Jacket", "L", 35000, true, "Winter"));
        } catch (IllegalArgumentException e) {
            System.out.println("Error initializing test data: " + e.getMessage());
        }
    }

    @Override
    public void displayMenu() {
        System.out.println("\n========================================");
        System.out.println("      CLOTHING STORE MANAGEMENT");
        System.out.println("========================================");
        System.out.println("1. Add Shirt");
        System.out.println("2. Add Jacket");
        System.out.println("3. View All Items");
        System.out.println("4. View Shirts Only");
        System.out.println("5. View Jackets Only");
        System.out.println("6. Demonstrate Polymorphism");
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
                    case 1 -> addShirt();
                    case 2 -> addJacket();
                    case 3 -> viewAllItems();
                    case 4 -> viewShirtsOnly();
                    case 5 -> viewJacketsOnly();
                    case 6 -> demonstratePolymorphism();
                    case 0 -> {
                        running = false;
                        System.out.println("\nThank you for using Clothing Store System!");
                        System.out.println("Goodbye!");
                    }
                    default -> throw new InvalidInputException("Invalid menu choice!");
                }

            } catch (NumberFormatException e) {
                System.out.println("❌ Error: Please enter a number!");
            } catch (InvalidInputException | IllegalArgumentException e) {
                System.out.println("❌ Error: " + e.getMessage());
            }
        }
    }

    // ===== MENU ACTION METHODS =====

    private void addShirt() {
        try {
            System.out.println("\n--- Add Shirt ---");

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

            Shirt shirt = new Shirt(name, size, price, longSleeve, material);
            items.add(shirt);

            System.out.println("✅ Shirt added successfully!");

        } catch (NumberFormatException e) {
            System.out.println("❌ Error: Price must be a number!");
        }
    }

    private void addJacket() {
        try {
            System.out.println("\n--- Add Jacket ---");

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

            System.out.println("✅ Jacket added successfully!");

        } catch (NumberFormatException e) {
            System.out.println("❌ Error: Price must be a number!");
        }
    }

    private void viewAllItems() {
        System.out.println("\n========================================");
        System.out.println("            ALL ITEMS");
        System.out.println("========================================");

        if (items.isEmpty()) {
            System.out.println("No items found.");
            return;
        }

        for (int i = 0; i < items.size(); i++) {
            System.out.println((i + 1) + ". " + items.get(i));
        }
    }

    private void viewShirtsOnly() {
        System.out.println("\n--- SHIRTS ONLY ---");

        boolean found = false;
        for (ClothingItem item : items) {
            if (item instanceof Shirt) {
                System.out.println(item);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No shirts found.");
        }
    }

    private void viewJacketsOnly() {
        System.out.println("\n--- JACKETS ONLY ---");

        boolean found = false;
        for (ClothingItem item : items) {
            if (item instanceof Jacket) {
                System.out.println(item);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No jackets found.");
        }
    }

    private void demonstratePolymorphism() {
        System.out.println("\n========================================");
        System.out.println("     POLYMORPHISM DEMONSTRATION");
        System.out.println("========================================");

        if (items.isEmpty()) {
            System.out.println("No items to demonstrate.");
            return;
        }

        for (ClothingItem item : items) {
            System.out.println("Item type: " + item.getType());
        }

        System.out.println("\n✅ Same method, different behavior!");
        System.out.println("This is POLYMORPHISM.");
    }
}
