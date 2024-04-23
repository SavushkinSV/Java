import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("1 - Перевод из строки в азбуку Морзе");
        System.out.println("2 - Перевод из азбуки Морзе в строку");
        System.out.println("0 - Выход");
        String str = "";

        Scanner scanner = new Scanner(System.in);
        while (!str.equals("0")) {
            System.out.print("Введите пункт меню -> ");
            str = scanner.nextLine();
            switch (str) {
                case "1": {
                    String input = scanner.nextLine();
                    Morse.convertStringToMorse(input);
                    break;
                }
                case "2": {
                    String input = scanner.nextLine();
                    Morse.convertMorseToString(input);
                    break;
                }
                case "0": {
                    break;
                }
                default: {
                    System.out.println("n/a");
                }
            }
        }
        scanner.close();
    }
}