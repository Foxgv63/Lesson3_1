package test.java.Lesson3;

import main.java.Lesson3_1.Task5_1;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TestTask5_1 {

    @Test
    public void ReverseLetters() {
        Task5_1 task51 = new Task5_1();
        String letterToChange = "!!!dlrow olleH";
        String actualLetters = task51.reversStr ("Hello world!!!");
        String expectedLetters;
        expectedLetters = letterToChange;
        assertEquals (actualLetters, expectedLetters);
    }
}