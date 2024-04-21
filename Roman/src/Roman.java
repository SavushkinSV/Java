import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;

public final class Roman {
    private final static Map<Character, Integer> symbolRomanToArabic;

    static {
        Map<Character, Integer> hashMap = new HashMap<>();
        hashMap.put('I', 1);
        hashMap.put('V', 5);
        hashMap.put('X', 10);
        hashMap.put('L', 50);
        hashMap.put('C', 100);
        hashMap.put('D', 500);
        hashMap.put('M', 1000);
        symbolRomanToArabic = Collections.unmodifiableMap(hashMap);
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
}