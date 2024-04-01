import java.util.Random;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class DynamicArray{
    private int[] items; // Array to hold items
    private int count; // Count of items in the array

    // Method to get an item at a specific index
    public int getItem(int index){
        if(index >= count || index < 0){
            throw new ArrayIndexOutOfBoundsException("Index out of bounds");
        }
        return items[index];
    }

    // Method to get the count of items
    public int getCount() {
        return count;
    }

    // Constructor to initialize the array with a specific length
    public DynamicArray(int length){
        items = new int[length];
    }

    // Method to insert a value into the array at a specific index
    public void insertIntoArray(int index, int value) {

        // If the provided index is greater than or equal to the length of the current array
        if (index >= items.length) {

            // Create a new array with a size of index + 1
            int newSize = index + 1;
            int[] newItems = new int[newSize];

            // Copy all existing items to the new array
            for (int i = 0; i < count; i++){
                newItems[i] = items[i];
            }

            // Replace the old array with the new one
            items = newItems;
        }

        // Insert the new value at the specified index
        items[index] = value;

        // If the index + 1 is greater than the current count, update the count
        if (index + 1 > count) {
            count = index + 1;
        }
    }

    // Method to remove an item by its value
    public int removeByValue(int value){
        int index = -1; // -1 means value not found
        for (int i = 0; i < count; i++){
            if (items[i] == value){
                index = i;
                break;
            }
        }

        if (index == -1){
            System.out.println("Value not found");
            return -1;
        }

        // Shift the items to the left
        for (int i = index; i < count - 1; i++){
            items[i] = items[i + 1];
        }

        count--;

        return index;
    }

    // Method to search for an item
    public void search(int item){
        for (int i = 0; i < count; i++){
            if (items[i] == item){
                System.out.println("Item found at index: " + i);
                return;
            }
        }
        System.out.println("Item not found");
    }

    // Method to load items from a file
    public void loadFromFile(String filename){
        File file = new File(filename);
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()){
                if (scanner.hasNextInt()) {
                    int nextInt = scanner.nextInt();
                    insertIntoArray(count, nextInt);
                } else {
                    System.out.println("Invalid number format: " + scanner.next());
                }
            }
            scanner.close();
        } catch (FileNotFoundException e){
            System.out.println("File not found" + filename);
        }
    }

    // Method to write data to a CSV file
    public void writeDataToCSV(String operationType, double executionTime) {
        String filename = "data.csv";
        FileWriter fileWriter = null;

        try {
            fileWriter = new FileWriter(filename, true); // Set true for append mode
            fileWriter.append(operationType + ", " + String.valueOf(executionTime) + "\n");
        } catch (Exception e) {
            System.out.println("Error in CsvFileWriter");
            e.printStackTrace();
        }
        finally {
            try {
                fileWriter.flush();
                fileWriter.close();
            }
            catch (IOException e) {
                System.out.println("Error while flushing/closing fileWriter");
                e.printStackTrace();
            }
        }
    }

    public void performOperations() {
        Random random = new Random();

        for (int i = 0; i < 100; i++) {
            // Generate a random number between 0 and 100
            int randomNumber = random.nextInt(101);

            // Measure the time taken to insert the random number into the array at the current index
            long startTime = System.nanoTime();
            insertIntoArray(i, randomNumber);
            long endTime = System.nanoTime();
            long insertTime = endTime - startTime;

            // Measure the time taken to remove the number if it is divisible by 10
            startTime = System.nanoTime();
            if (randomNumber % 10 == 0) {
                removeByValue(randomNumber);
            }
            endTime = System.nanoTime();
            long removeTime = endTime - startTime;

            // Measure the time taken to search for the number in the array
            startTime = System.nanoTime();
            search(randomNumber);
            endTime = System.nanoTime();
            long searchTime = endTime - startTime;

            // Write the operation times to a CSV file
            writeDataToCSV("insert", insertTime);
            writeDataToCSV("remove", removeTime);
            writeDataToCSV("search", searchTime);
        }
    }

    // Method to display all items in the array
    public void show(){
        for(int i = 0; i < count; i++){// Iterate only to count
            System.out.print(items[i] + " ");
        }
    }
}