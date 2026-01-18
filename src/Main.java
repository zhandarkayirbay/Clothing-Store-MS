import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

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
            System.out.println("6. Pay order");
            System.out.println("0. Exit");
            System.out.print("Choose: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            // ADD ITEM
            if (choice == 1) {

                System.out.println("1. Shirt");
                System.out.println("2. Jacket");
                int type = scanner.nextInt();
                scanner.nextLine();

                System.out.print("Name: ");
                String name = scanner.nextLine();

                System.out.print("Size: ");
                String size = scanner.nextLine();

                System.out.print("Price: ");
                double price = scanner.nextDouble();
                scanner.nextLine();

                System.out.print("Category: ");
                String category = scanner.nextLine();

                if (type == 1) {
                    System.out.print("Long sleeve (true/false): ");
                    boolean longSleeve = scanner.nextBoolean();
                    scanner.nextLine();

                    System.out.print("Material: ");
                    String material = scanner.nextLine();

                    items.add(new Shirt(name, size, price, category, longSleeve, material));
                } else {
                    System.out.print("Waterproof (true/false): ");
                    boolean waterproof = scanner.nextBoolean();
                    scanner.nextLine();

                    System.out.print("Season: ");
                    String season = scanner.nextLine();

                    items.add(new Jacket(name, size, price, category, waterproof, season));
                }
            }

            // VIEW ITEMS
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

            // ADD CUSTOMER
            else if (choice == 3) {
                System.out.print("Name: ");
                String name = scanner.nextLine();
                System.out.print("Phone: ");
                String phone = scanner.nextLine();
                System.out.print("Email: ");
                String email = scanner.nextLine();

                customers.add(new Customer(name, phone, email));
            }

            // VIEW CUSTOMERS
            else if (choice == 4) {
                for (Customer c : customers) {
                    System.out.println(c);
                }
            }

            // ADD ORDER
            else if (choice == 5) {
                if (!items.isEmpty()) {
                    orders.add(new Order(orders.size() + 1,
                            items.get(0).getPrice(),
                            "2026-01-18"));
                }
            }

            // PAY ORDER
            else if (choice == 6) {
                if (!orders.isEmpty()) {
                    Payment payment = new Payment("Card", orders.get(0).toString().length());
                    orders.get(0).setPayment(payment);
                    System.out.println("Order paid");
                }
            }

            else if (choice == 0) {
                running = false;
            }
        }
    }
}
