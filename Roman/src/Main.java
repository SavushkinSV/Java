import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("1 - Перевод из римской записи в арабскую");
        System.out.println("2 - Перевод из арабской записи в римскую");
        System.out.println("exit - Выход");
        String str = "";

        Scanner scanner = new Scanner(System.in);
        while (!str.equals("exit")) {
            System.out.print("Введите пункт меню -> ");
            str = scanner.nextLine();
            switch (str) {
                case "1": {
                    Roman.inputRomanNumber();
                    break;
                }
                case "2": {
                    Roman.inputArabicNumber();
                    break;
                }
                case "exit": {
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