public class Main {
    public static void main(String[] args) {
        DynamicArray numbers = new DynamicArray(100000);

        long start = System.currentTimeMillis();


        /* For testing
        for (int i = 0; i < 100000; i++){
            numbers.insertIntoArray(i, i + 1);
        }
        */


        long end = System.currentTimeMillis();

        double time = (end - start) / 1000.0;



        numbers.search(9);
        numbers.show();

        System.out.println("\nTime: " + time + " seconds");
    }
}