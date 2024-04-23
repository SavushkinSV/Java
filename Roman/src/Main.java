import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("1 - Перевод из римской записи в арабскую");
        System.out.println("2 - Перевод из арабской записи в римскую");
        System.out.println("0 - Выход");
        String str = "";

        Scanner scanner = new Scanner(System.in);
        while (!str.equals("0")) {
            System.out.print("Введите пункт меню -> ");
            str = scanner.nextLine();
            switch (str) {
                case "1": {
                    System.out.print("Введите число в римской записи -> ");
                    String inputString = scanner.nextLine();
                    Roman.convertRomanNumber(inputString);
                    System.out.println();
                    break;
                }
                case "2": {
                    System.out.print("Введите число в арабской записи -> ");
                    String inputString = scanner.nextLine();
                    Roman.convertArabicNumber(inputString);
                    System.out.println();
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