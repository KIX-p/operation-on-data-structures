import java.util.Scanner;

public class MainMenu {
    private Scanner scanner;
    private DynamicArray numbers;
    private ArrayOperations arrayOperations;

    public MainMenu(Scanner scanner, DynamicArray numbers) {
        this.scanner = scanner;
        this.numbers = numbers;
        this.arrayOperations = new ArrayOperations(numbers, scanner);
    }

    public void handleMainMenu() {
        int choice;
        do {
            displayMainMenu();
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    arrayOperations.handleArrayOperations();
                    break;
                case 2:
                    System.out.println("\nLinked List operations are not available yet.");
                    break;
                case 3:
                    System.out.println("\nDoubly Linked List operations are not available yet.");
                    break;
                case 4:
                    System.out.println("\nBinary Search Tree operations are not available yet.");
                    break;
                case 5:
                    System.out.println("\nExiting...");
                    break;
                default:
                    System.out.println("\nInvalid choice");
                    break;
            }
        } while (choice != 5);
    }
    private void displayMainMenu() {
        System.out.println("\nChoose a data structure:");
        System.out.println("1. Array");
        System.out.println("2. Linked List");
        System.out.println("3. Doubly Linked List");
        System.out.println("4. Binary Search Tree");
        System.out.println("5. Exit");
    }
}