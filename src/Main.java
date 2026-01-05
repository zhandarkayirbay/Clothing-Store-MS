import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("=== WEEK 4 TEST ===");

        ArrayList<ClothingItem> items = new ArrayList<>();
        ArrayList<Customer> customers = new ArrayList<>();
        ArrayList<Order> orders = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {

            System.out.println("\nMENU");
            System.out.println("1. Add item");
            System.out.println("2. View items");
            System.out.println("3. Add customer");
            System.out.println("4. View customers");
            System.out.println("5. Add order");
            System.out.println("6. View orders");
            System.out.println("0. Exit");
            System.out.print("Choose: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            // ===== ADD ITEM =====
            if (choice == 1) {

                System.out.println("1. Shirt");
                System.out.println("2. Jacket");
                System.out.print("Type: ");
                int type = scanner.nextInt();
                scanner.nextLine();

                System.out.print("Enter name: ");
                String name = scanner.nextLine();
                if (name.trim().isEmpty()) {
                    System.out.println("Name cannot be empty");
                    continue;
                }

                System.out.print("Enter size: ");
                String size = scanner.nextLine();
                if (size.trim().isEmpty()) {
                    System.out.println("Size cannot be empty");
                    continue;
                }

                System.out.print("Enter price: ");
                double price = scanner.nextDouble();
                scanner.nextLine();
                if (price <= 0) {
                    System.out.println("Price must be greater than 0");
                    continue;
                }

                System.out.print("Enter category: ");
                String category = scanner.nextLine();
                if (category.trim().isEmpty()) {
                    System.out.println("Category cannot be empty");
                    continue;
                }

                if (type == 1) {
                    System.out.print("Long sleeve (true/false): ");
                    boolean longSleeve = scanner.nextBoolean();
                    scanner.nextLine();

                    System.out.print("Enter material: ");
                    String material = scanner.nextLine();
                    if (material.trim().isEmpty()) {
                        System.out.println("Material cannot be empty");
                        continue;
                    }

                    items.add(new Shirt(name, size, price, category, longSleeve, material));
                }

                else if (type == 2) {
                    System.out.print("Waterproof (true/false): ");
                    boolean waterproof = scanner.nextBoolean();
                    scanner.nextLine();

                    System.out.print("Enter season: ");
                    String season = scanner.nextLine();
                    if (season.trim().isEmpty()) {
                        System.out.println("Season cannot be empty");
                        continue;
                    }

                    items.add(new Jacket(name, size, price, category, waterproof, season));
                }

                else {
                    System.out.println("Wrong type");
                    continue;
                }

                System.out.println("Item added successfully");
            }

            // ===== VIEW ITEMS =====
            else if (choice == 2) {
                for (ClothingItem item : items) {
                    System.out.println(item);

                    if (item instanceof Shirt) {
                        System.out.println("Type: Shirt");
                    } else if (item instanceof Jacket) {
                        System.out.println("Type: Jacket");
                    }
                }
            }

            // ===== ADD CUSTOMER =====
            else if (choice == 3) {
                System.out.print("Enter name: ");
                String name = scanner.nextLine();
                if (name.trim().isEmpty()) continue;

                System.out.print("Enter phone: ");
                String phone = scanner.nextLine();
                if (phone.trim().isEmpty()) continue;

                System.out.print("Enter email: ");
                String email = scanner.nextLine();
                if (email.trim().isEmpty()) continue;

                customers.add(new Customer(name, phone, email));
                System.out.println("Customer added");
            }

            // ===== VIEW CUSTOMERS =====
            else if (choice == 4) {
                for (Customer c : customers) {
                    System.out.println(c);
                }
            }

            // ===== ADD ORDER =====
            else if (choice == 5) {
                if (items.isEmpty()) {
                    System.out.println("Add item first");
                    continue;
                }

                System.out.print("Enter order date: ");
                String date = scanner.nextLine();
                if (date.trim().isEmpty()) continue;

                orders.add(new Order(orders.size() + 1, items.get(0).getPrice(), date, "Created"));
                System.out.println("Order added");
            }

            // ===== VIEW ORDERS =====
            else if (choice == 6) {
                for (Order o : orders) {
                    System.out.println(o);
                }
            }

            else if (choice == 0) {
                running = false;
                System.out.println("Program ended");
            }
        }
    }
}
