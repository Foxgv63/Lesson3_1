package test.java.Lesson3;

import main.java.Lesson3_1.Task5_1;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TestTask5_1 {

    @Parameters({"directSymbols", "reverseSymbols"})
    @Test
    public void ReverseLetters(String directSymbols, String reverseSymbols) {
        Task5_1 task51 = new Task5_1();
        String actualLetters = task51.reverse(directSymbols);
        String expectedLetters = reverseSymbols;
        assertEquals (actualLetters, expectedLetters);
    }
}