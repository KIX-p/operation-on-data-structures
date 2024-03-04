public class DynamicArray{
    private int[] items;
    private int count;

    public DynamicArray(int length){
        items = new int[length];
    }

    public void insertIntoArray(int index, int value) {
        if (index > count) {
            System.out.println("Invalid index");
        }

        if (items.length == count) {
            int[] newItems = new int[count * 2];
            for (int i = 0; i < count; i++)
                newItems[i] = items[i];
            items = newItems;
        }

        for (int i = count - 1; i >= index; i--)
            items[i + 1] = items[i];

        items[index] = value;
        count++;
    }

    public void removeAt(int index){
        if (index < 0 || index >= count){
            System.out.println("Invalid index");
            return;
        }

        for (int i = index; i < count - 1; i++){
            items[i] = items[i + 1];
        }
        count--;
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

    public void show(){
        for(int i = 0; i < items.length; i++){
            System.out.print(items[i] + " ");
        }
    }
}