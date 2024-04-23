import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

class RomanTest {
    protected final ByteArrayOutputStream output = new ByteArrayOutputStream();

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(output));
    }

    @Test
    void testConvertRomanNumber() {
        Map<String, String> testMap = new HashMap<>();
        testMap.put("MMXXIV", "2024");
        testMap.put("MCMLXXXIX", "1989");
        testMap.put("MMCCLXXXVIII", "2288");
        testMap.put("I", "1");
        testMap.put("II", "2");
        testMap.put("nulla", "0");
        testMap.put("nihil", "0");
        testMap.put("N", "0");
        testMap.put("MMCCLXXXVIIII", "n/a");
        testMap.put("MCMLXXXXIX", "n/a");
        testMap.put("MMXXIVL", "n/a");

        for (Map.Entry<String, String> entry : testMap.entrySet()) {
            Roman.convertRomanNumber(entry.getKey());
            Assertions.assertEquals(entry.getValue(), output.toString());
            output.reset();
        }
    }

    @Test
    void testConvertArabicNumber() {
        Map<String, String> testMap = new HashMap<>();
        testMap.put("2288", "MMCCLXXXVIII");
        testMap.put("734", "DCCXXXIV");
        testMap.put("5", "V");
        testMap.put("9", "IX");
        testMap.put("0", "N");
        testMap.put("-1", "n/a");
        testMap.put("4000", "n/a");
        testMap.put("m", "n/a");
        testMap.put("3.5", "n/a");

        for (Map.Entry<String, String> entry : testMap.entrySet()) {
            Roman.convertArabicNumber(entry.getKey());
            Assertions.assertEquals(entry.getValue(), output.toString());
            output.reset();
        }
    }
}