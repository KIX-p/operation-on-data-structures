import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int arraySize = scanner.nextInt();
        DynamicArray numbers = new DynamicArray(arraySize);

        while (true){
            System.out.println("\nChoose the data structure to use:");
            System.out.println("1. Array");
            System.out.println("2. Singly Linked List");
            System.out.println("3. Doubly Linked List");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice){
                case 1:
                    int choice2;
                    do {
                        System.out.println("\n1. Insert a number into Array: ");
                        System.out.println("2. remove a number from Array:");
                        System.out.println("3. Search for a number in Array:");
                        System.out.println("4. Show Array");
                        System.out.println("5. Load from file");
                        System.out.println("6. Exit to main menu");
                        System.out.print("Enter your choice: ");
                        choice2 = scanner.nextInt();

                        switch (choice2){
                            case 1:
                                System.out.print("Enter the index: ");
                                int index = scanner.nextInt();
                                System.out.print("Enter the value: ");
                                int value = scanner.nextInt();
                                long start = System.currentTimeMillis();
                                numbers.insertIntoArray(index, value);
                                long end = System.currentTimeMillis();
                                double time = (end - start) / 1000.0;
                                System.out.println("Time: " + time + " seconds");
                                break;
                            case 2:
                                System.out.print("Enter the index to remove: ");
                                int index2 = scanner.nextInt();
                                System.out.println("\n-----------------------------------------");
                                System.out.println("Removing " + numbers.getItem(index2) + " from index " + index2);
                                numbers.removeAt(index2);
                                System.out.println("\n-----------------------------------------");
                                break;
                            case 3:
                                System.out.print("Enter the number to search: ");
                                int item = scanner.nextInt();
                                System.out.println("\n-----------------------------------------");
                                numbers.search(item);
                                System.out.println("\n-----------------------------------------");
                                break;
                            case 4:
                                System.out.println("\n-----------------Array----------------- ");
                                numbers.show();
                                System.out.println("\n-----------------Array----------------- ");
                                break;
                            case 5:
                                System.out.print("Enter the file name: ");
                                String filename = scanner.next();
                                numbers.loadFromFile(filename);
                                break;
                            case 6:
                                System.out.println("\nExiting to main menu...");
                                break;
                            default:
                                System.out.println("\nInvalid choice");
                                break;
                        }
                    } while (choice2 != 6);
                    break;
                case 2:
                    System.out.println("\nSingly Linked List");
                    break;
                case 3:
                    System.out.println("\nDoubly Linked List");
                    break;
                case 4:
                    System.out.println("\nExiting...");
                    System.exit(0);
                default:
                    System.out.println("\nInvalid choice");
                    break;
            }
        }
    }
}