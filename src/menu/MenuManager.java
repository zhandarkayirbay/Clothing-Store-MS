package menu;

import exception.InvalidInputException;

import java.util.Scanner;

public class MenuManager implements Menu {

    @Override
    public void displayMenu() {
        System.out.println("MENU");
        System.out.println("1. Test input");
        System.out.println("0. Exit");
    }

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            try {
                displayMenu();
                System.out.print("Choose: ");

                int choice = scanner.nextInt();

                if (choice < 0 || choice > 1) {
                    throw new InvalidInputException("Invalid menu choice");
                }

                if (choice == 0) {
                    running = false;
                }

            } catch (InvalidInputException e) {
                System.out.println("Error: " + e.getMessage());
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println("Input must be a number");
                scanner.nextLine();
            }
        }
    }
}
