import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;

public final class Roman {
    private final static Map<Character, Integer> symbolRomanToArabic;
    private final static int[] arabicValues = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    private final static String[] arabicSymbol = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    static {
        Map<Character, Integer> hashMapRoman = new HashMap<>();
        hashMapRoman.put('I', 1);
        hashMapRoman.put('V', 5);
        hashMapRoman.put('X', 10);
        hashMapRoman.put('L', 50);
        hashMapRoman.put('C', 100);
        hashMapRoman.put('D', 500);
        hashMapRoman.put('M', 1000);
        symbolRomanToArabic = Collections.unmodifiableMap(hashMapRoman);
    }

    private Roman() {
    }

    public static void inputRomanNumber() {
        System.out.print("Введите число в римской записи -> ");
        Scanner scanner = new Scanner(System.in);
        String inputString = scanner.nextLine();
        if (isRomanNULL(inputString)) {
            System.out.println("0");
        } else if (isRomanNumber(inputString)) {
            convertRomanToArabic(inputString);
        } else {
            System.out.println("Введенная строка не является римским числом");
        }
    }

    public static void inputArabicNumber() {
        System.out.print("Введите число в арабской записи -> ");
        Scanner scanner = new Scanner(System.in);
        String inputString = scanner.nextLine();
        if (isArabicNumber(inputString)) {
            convertArabicToRoman(inputString);
        } else {
            System.out.println("Введенная строка не является арабским числом в диапазоне [0, 3999]");
        }
    }

    private static void convertArabicToRoman(String str) {
        int current = Integer.parseInt(str);
        if (current >= 4000) {
            System.out.println("n/a");
        } else if (current == 0) {
            System.out.println(current + " -> " + "N");
        } else {
            System.out.print(current + " -> ");
            for (int i = 0; i < arabicValues.length; i++) {
                while (arabicValues[i] <= current) {
                    System.out.print(arabicSymbol[i]);
                    current -= arabicValues[i];
                }
            }
            System.out.println();
        }
    }

    private static void convertRomanToArabic(String str) {
        int length = str.length() - 1;
        int result = getArabic(str.charAt(length));
        for (int i = length - 1; i >= 0; i--) {
            int arabic = getArabic(str.charAt(i));
            if (arabic < getArabic(str.charAt(i + 1))) {
                result -= arabic;
            } else {
                result += arabic;
            }
        }
        System.out.println(str + " -> " + result);
    }

    private static int getArabic(char c) {
        int result = 0;
        for (Map.Entry<Character, Integer> entry : symbolRomanToArabic.entrySet()) {
            if (entry.getKey() == c) {
                result = entry.getValue();
            }
        }

        return result;
    }

    private static boolean isRomanNULL(String str) {
        boolean N = str.equals("N");
        boolean nihil = str.equals("nihil");
        boolean nulla = str.equals("nulla");

        return N || nihil || nulla;
    }

    private static boolean isRomanNumber(String str) {
        String regex = "^(M{0,3})(D?C{0,3}|C[DM])(L?X{0,3}|X[LC])(V?I{0,3}|I[VX])$";

        return Pattern.matches(regex, str);
    }

    private static boolean isArabicNumber(String str) {
        String regex = "\\d+";

        return Pattern.matches(regex, str);
    }
}