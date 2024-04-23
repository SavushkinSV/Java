
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

public class MorseTest {
    protected final ByteArrayOutputStream output = new ByteArrayOutputStream();

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(output));
    }

    @Test
    public void testConvertStringToMorse() {
        Map<String, String> testMap = new HashMap<>();
        testMap.put("SOS", "... --- ...\n");
        testMap.put("S(", "n/a\n");
        testMap.put("i % sd", "n/a\n");
        testMap.put("15S", ".---- ..... ...\n");
        testMap.put("hello", ".... . .-.. .-.. ---\n");
        testMap.put("HeLlO", ".... . .-.. .-.. ---\n");
        testMap.put("Hello world", ".... . .-.. .-.. ---\t.-- --- .-. .-.. -..\n");
        testMap.put("We can do it", ".-- .\t-.-. .- -.\t-.. ---\t.. -\n");
        testMap.put("20 000 Leagues Under The Sea", "..--- -----\t----- ----- -----\t.-.. . .- --. ..- . ..." +
                "\t..- -. -.. . .-.\t- .... .\t... . .-\n");
        testMap.put("VIM", "...- .. --\n");
        testMap.put("IN WEEK 7 DAYS", ".. -.\t.-- . . -.-\t--...\t-.. .- -.-- ...\n");
        testMap.put("01 23 45 67 89", "----- .----\t..--- ...--\t....- .....\t-.... --...\t---.. ----.\n");

        for (Map.Entry<String, String> entry : testMap.entrySet()) {
            Morse.convertStringToMorse(entry.getKey());
            Assertions.assertEquals(entry.getValue(), output.toString());
            output.reset();
        }
    }

    @Test
    public void testConvertMorseToString() {
        Map<String, String> testMap = new HashMap<>();
        testMap.put("... --- ...", "SOS\n");
        testMap.put(".... . .-.. .-.. ---\t.-- --- .-. .-.. -..", "HELLO WORLD\n");
        testMap.put(".. -.\t.-- . . -.-\t--...\t-.. .- -.-- ...", "IN WEEK 7 DAYS\n");
        testMap.put("...-.. -.", "n/a\n");
        testMap.put("...x- -.", "n/a\n");

        for (Map.Entry<String, String> entry : testMap.entrySet()) {
            Morse.convertMorseToString(entry.getKey());
            Assertions.assertEquals(entry.getValue(), output.toString());
            output.reset();
        }
    }
}