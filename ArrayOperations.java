import java.util.Scanner;

public class ArrayOperations {
    private DynamicArray numbers;
    private Scanner scanner;

    public ArrayOperations(DynamicArray numbers, Scanner scanner) {
        this.numbers = numbers;
        this.scanner = scanner;
    }

    public void handleArrayOperations() {
        int choice;
        do {
            displayArrayMenu();
            choice = scanner.nextInt();

            switch (choice){
                case 1:
                    handleInsertOperation();
                    break;
                case 2:
                    handleRemoveOperation();
                    break;
                case 3:
                    handleSearchOperation();
                    break;
                case 4:
                    handleShowOperation();
                    break;
                case 5:
                    handleLoadFromFileOperation();
                    break;
                case 6:
                    System.out.println("\nExiting to main menu...");
                    break;
                default:
                    System.out.println("\nInvalid choice");
                    break;
            }
        } while (choice != 6);
    }
    private void displayArrayMenu() {
        System.out.println("\nChoose an operation:");
        System.out.println("1. Insert");
        System.out.println("2. Remove");
        System.out.println("3. Search");
        System.out.println("4. Show");
        System.out.println("5. Load from file");
        System.out.println("6. Exit");
    }
    
    private void handleInsertOperation() {
        System.out.print("Enter the index: ");
        int index = scanner.nextInt();
        System.out.print("Enter the value: ");
        int value = scanner.nextInt();
        long start = System.currentTimeMillis();
        numbers.insertIntoArray(index, value);
        long end = System.currentTimeMillis();
        double time = (end - start) / 1000.0;
        System.out.println("Time: " + time + " seconds");
    }

    private void handleRemoveOperation() {
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
        numbers.writeDataToCSV("remove", time2, numbers.getCount());
        System.out.println("Time: " + time2 + " seconds");
    }
    
    private void handleSearchOperation() {
        System.out.print("Enter the number to search: ");
        int item = scanner.nextInt();
        long start3 = System.currentTimeMillis();
        System.out.println("\n-----------------------------------------");
        numbers.search(item);
        System.out.println("\n-----------------------------------------");
        long end3 = System.currentTimeMillis();
        double time3 = (end3 - start3)/1000.0;
        numbers.writeDataToCSV("search", time3, numbers.getCount());
        System.out.println("Time: " + time3 + " seconds");
    }
    
    private void handleShowOperation() {
        long start4 = System.currentTimeMillis();
        System.out.println("\n-----------------Array----------------- ");
        numbers.show();
        System.out.println("\n-----------------Array----------------- ");
        long end4 = System.currentTimeMillis();
        double time4 = (end4 - start4)/1000.0;
        System.out.println("Time: " + time4 + " seconds");
    }
    
    private void handleLoadFromFileOperation() {
        System.out.print("Enter the file name: ");
        String filename = scanner.next();
        long start5 = System.currentTimeMillis();
        numbers.loadFromFile(filename);
        long end5 = System.currentTimeMillis();
        double time5 = (end5 - start5)/1000.0;
        numbers.writeDataToCSV("insert", time5, numbers.getCount());
        System.out.println("Time: " + time5 + " seconds");
    }
}