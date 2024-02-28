public class Main {
    public static void main(String[] args) {
        DynamicArray numbers = new DynamicArray(1);
        
        long start = System.currentTimeMillis();

        for (int i = 0; i < 10; i+=1){
            numbers.insert(i);
        }
        long end = System.currentTimeMillis();

        double time = (end - start) / 1000.0;
        
        System.out.println("Time: " + time + " seconds");
        numbers.removeAt(2);
        numbers.removeAt(8);
        numbers.removeAt(0);

        numbers.show();

        
    }
}