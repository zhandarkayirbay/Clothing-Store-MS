import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("=== WEEK 4 TEST ===");

        ClothingItem shirtTest = new Shirt(
                "Winter Shirt",
                "L",
                25000,
                "Clothes",
                true,
                "Cotton"
        );

        ClothingItem jacketTest = new Jacket(
                "Winter Jacket",
                "XL",
                40000,
                "Outerwear",
                true,
                "Winter"
        );

        System.out.println(shirtTest);
        System.out.println(jacketTest);

        ArrayList<ClothingItem> items = new ArrayList<>();
        ArrayList<Customer> customers = new ArrayList<>();
        ArrayList<Order> orders = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {

            System.out.println();
            System.out.println("MENU");
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

            // ===== 1. Add item =====
            if (choice == 1) {

                System.out.println("Choose item type:");
                System.out.println("1. Shirt");
                System.out.println("2. Jacket");
                System.out.print("Type: ");
                int type = scanner.nextInt();
                scanner.nextLine();

                System.out.print("Enter name: ");
                String name = scanner.nextLine();

                System.out.print("Enter size: ");
                String size = scanner.nextLine();

                System.out.print("Enter price: ");
                double price = scanner.nextDouble();
                scanner.nextLine();

                System.out.print("Enter category: ");
                String category = scanner.nextLine();

                if (type == 1) {
                    System.out.print("Long sleeve (true/false): ");
                    boolean longSleeve = scanner.nextBoolean();
                    scanner.nextLine();

                    System.out.print("Enter material: ");
                    String material = scanner.nextLine();

                    ClothingItem item = new Shirt(
                            name,
                            size,
                            price,
                            category,
                            longSleeve,
                            material
                    );
                    items.add(item);
                }

                else if (type == 2) {
                    System.out.print("Waterproof (true/false): ");
                    boolean waterproof = scanner.nextBoolean();
                    scanner.nextLine();

                    System.out.print("Enter season: ");
                    String season = scanner.nextLine();

                    ClothingItem item = new Jacket(
                            name,
                            size,
                            price,
                            category,
                            waterproof,
                            season
                    );
                    items.add(item);
                }

                else {
                    System.out.println("Wrong item type");
                    continue;
                }

                System.out.println("Item added successfully");
            }

            // ===== 2. View items =====
            else if (choice == 2) {

                if (items.isEmpty()) {
                    System.out.println("No items available");
                } else {
                    System.out.println("Clothing items:");
                    for (ClothingItem item : items) {
                        System.out.println(item);

                        if (item instanceof Shirt) {
                            System.out.println("Item type: Shirt");
                        }
                        else if (item instanceof Jacket) {
                            System.out.println("Item type: Jacket");
                        }
                    }
                }
            }

            // ===== 3. Add customer =====
            else if (choice == 3) {

                System.out.print("Enter name: ");
                String name = scanner.nextLine();

                System.out.print("Enter phone: ");
                String phone = scanner.nextLine();

                System.out.print("Enter email: ");
                String email = scanner.nextLine();

                Customer customer = new Customer(name, phone, email);
                customers.add(customer);

                System.out.println("Customer added successfully");
            }

            // ===== 4. View customers =====
            else if (choice == 4) {

                if (customers.isEmpty()) {
                    System.out.println("No customers available");
                } else {
                    System.out.println("Customers:");
                    for (Customer customer : customers) {
                        System.out.println(customer);
                    }
                }
            }

            // ===== 5. Add order =====
            else if (choice == 5) {

                if (items.isEmpty()) {
                    System.out.println("No items available. Add item first.");
                } else {

                    int orderId = orders.size() + 1;
                    double totalPrice = items.get(0).getPrice();

                    System.out.print("Enter order date: ");
                    String orderDate = scanner.nextLine();

                    Order order = new Order(
                            orderId,
                            totalPrice,
                            orderDate,
                            "Created"
                    );
                    orders.add(order);

                    System.out.println("Order added successfully");
                }
            }

            // ===== 6. View orders =====
            else if (choice == 6) {

                if (orders.isEmpty()) {
                    System.out.println("No orders available");
                } else {
                    System.out.println("Orders:");
                    for (Order order : orders) {
                        System.out.println(order);
                    }
                }
            }

            // ===== Exit =====
            else if (choice == 0) {
                System.out.println("Program ended");
                running = false;
            }

            else {
                System.out.println("Wrong choice");
            }
        }
    }
}
