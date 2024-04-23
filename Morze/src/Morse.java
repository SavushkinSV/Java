import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Morse {
    private final static Map<Character, String> morseAlphabet;

    static {
        Map<Character, String> hashMapMorseAlphabet = new HashMap<>();
        hashMapMorseAlphabet.put('A', ".-");
        hashMapMorseAlphabet.put('B', "-...");
        hashMapMorseAlphabet.put('C', "-.-.");
        hashMapMorseAlphabet.put('D', "-..");
        hashMapMorseAlphabet.put('E', ".");
        hashMapMorseAlphabet.put('F', "..-.");
        hashMapMorseAlphabet.put('G', "--.");
        hashMapMorseAlphabet.put('H', "....");
        hashMapMorseAlphabet.put('I', "..");
        hashMapMorseAlphabet.put('J', ".---");
        hashMapMorseAlphabet.put('K', "-.-");
        hashMapMorseAlphabet.put('L', ".-..");
        hashMapMorseAlphabet.put('M', "--");
        hashMapMorseAlphabet.put('N', "-.");
        hashMapMorseAlphabet.put('O', "---");
        hashMapMorseAlphabet.put('P', ".-.-");
        hashMapMorseAlphabet.put('Q', "--.-");
        hashMapMorseAlphabet.put('R', ".-.");
        hashMapMorseAlphabet.put('S', "...");
        hashMapMorseAlphabet.put('T', "-");
        hashMapMorseAlphabet.put('U', "..-");
        hashMapMorseAlphabet.put('V', "...-");
        hashMapMorseAlphabet.put('W', ".--");
        hashMapMorseAlphabet.put('X', "-..-");
        hashMapMorseAlphabet.put('Y', "-.--");
        hashMapMorseAlphabet.put('Z', "--..");
        hashMapMorseAlphabet.put('1', ".----");
        hashMapMorseAlphabet.put('2', "..---");
        hashMapMorseAlphabet.put('3', "...--");
        hashMapMorseAlphabet.put('4', "....-");
        hashMapMorseAlphabet.put('5', ".....");
        hashMapMorseAlphabet.put('6', "-....");
        hashMapMorseAlphabet.put('7', "--...");
        hashMapMorseAlphabet.put('8', "---..");
        hashMapMorseAlphabet.put('9', "----.");
        hashMapMorseAlphabet.put('0', "-----");
        hashMapMorseAlphabet.put(' ', "\t");
        morseAlphabet = Collections.unmodifiableMap(hashMapMorseAlphabet);
    }

    public static void convertStringToMorse(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        boolean errorDecoding = false;
        for (int i = 0; i < str.length(); i++) {
            errorDecoding = true;
            for (Map.Entry<Character, String> entry : morseAlphabet.entrySet()) {
                if (entry.getKey() == str.charAt(i)) {
                    stringBuilder.append(entry.getValue());
                    stringBuilder.append(" ");
                    errorDecoding = false;
                    break;
                }
            }
            if (errorDecoding) break;
        }
        if (errorDecoding) {
            System.out.println("n/a");
        } else {
            System.out.println(stringBuilder);
        }
    }

    public static void convertMorseToString(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        boolean errorDecoding = false;
        String[] split = str.split(" ");
        for (int i = 0; i < split.length; i++) {
            errorDecoding = true;
            for (Map.Entry<Character, String> entry : morseAlphabet.entrySet()) {
                if (split[i].equals(entry.getValue())) {
                    stringBuilder.append(entry.getKey());
                    errorDecoding = false;
                    break;
                }
            }
            if (errorDecoding) break;
        }
        if (errorDecoding) {
            System.out.println("n/a");
        } else {
            System.out.println(stringBuilder);
        }
    }
}
