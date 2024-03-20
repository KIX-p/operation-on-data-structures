import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;


public class DynamicArray{
    private int[] items;
    private int count;

    public int getItem(int index){
        return items[index];
    }

    public DynamicArray(int length){
        items = new int[length];
    }

    // insert into array
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

    public void search(int item){
        for (int i = 0; i < count; i++){
            if (items[i] == item){
                System.out.println("Item found at index: " + i);
                return;
            }
        }
        System.out.println("Item not found");
    }

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

    public void show(){
        for(int i = 0; i < count; i++){// Iterate only to count
            System.out.print(items[i] + " ");
        }
    }
}