import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DynamicArray numbers = new DynamicArray(10);
        MainMenu mainMenu = new MainMenu(scanner, numbers);
        mainMenu.handleMainMenu();
        scanner.close();
    }
}