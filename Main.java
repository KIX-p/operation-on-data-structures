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
                                System.out.print("Enter the value to remove: ");
                                int value1 = scanner.nextInt();
                                long start2 = System.currentTimeMillis();
                                System.out.println("\n-----------------------------------------");
                                int removedIndex = numbers.removeByValue(value1);
                                if (removedIndex != -1) {
                                    System.out.println("Removed value " + value1 + " from index " + removedIndex);
                                }
                                System.out.println("\n-----------------------------------------");
                                long end2 = System.currentTimeMillis();
                                double time2 = (end2 - start2)/1000.0;
                                System.out.println("Time: " + time2 + " seconds");
                                break;
                            case 3:
                                System.out.print("Enter the number to search: ");
                                int item = scanner.nextInt();
                                long start3 = System.currentTimeMillis();
                                System.out.println("\n-----------------------------------------");
                                numbers.search(item);
                                System.out.println("\n-----------------------------------------");
                                long end3 = System.currentTimeMillis();
                                double time3 = (end3 - start3)/1000.0;
                                System.out.println("Time: " + time3 + " seconds");
                                break;
                            case 4:
                                long start4 = System.currentTimeMillis();
                                System.out.println("\n-----------------Array----------------- ");
                                numbers.show();
                                System.out.println("\n-----------------Array----------------- ");
                                long end4 = System.currentTimeMillis();
                                double time4 = (end4 - start4)/1000.0;
                                System.out.println("Time: " + time4 + " seconds");
                                break;
                            case 5:
                                System.out.print("Enter the file name: ");
                                String filename = scanner.next();
                                long start5 = System.currentTimeMillis();
                                numbers.loadFromFile(filename);
                                long end5 = System.currentTimeMillis();
                                double time5 = (end5 - start5)/1000.0;
                                System.out.println("Time: " + time5 + " seconds");
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