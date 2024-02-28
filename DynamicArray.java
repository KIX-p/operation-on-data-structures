public class DynamicArray{
    private int[] items;
    private int count;


    // constructor to initialize the dynamic array with a length
    public DynamicArray(int length){
        items = new int[length];
    }

    public void insert(int item){
        // if the array is full, resize it
        if (items.length == count){
            // create a new array (plus one the size)
            int[] newItems = new int[count + 1];
            // copy all the existing items
            for (int i = 0; i < count; i++){
                newItems[i] = items[i];
            }
            // set "items" to this new array
            items = newItems;
        }
        // add the new item
        items[count++] = item;
    }

    // removeAt method to remove an item at a specific index
    public void removeAt(int index){
        // validate the index
        if (index < 0 || index >= count){
            throw new IllegalArgumentException();
        }
        // shift the items to the left to fill the hole
        for (int i = index; i < count - 1; i++){
            items[i] = items[i + 1];
        }
        count--;
    }

    // implement the show method to display the items in the array
    public void show(){
            for(int i = 0; i < count; i++){
                System.out.print(items[i] + " ");
            }
    }
}