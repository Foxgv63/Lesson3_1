package test.java.Lesson3;

import main.java.Lesson3_1.Task1_1;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TestTask1_1 {

    @Test() //dataProvider = "dp"
    public void ComparisonNumbers(){
        Task1_1 task11 = new Task1_1 ();
        int numberToChange = 2;
        int actualNumber = task11.compare ();
        int expectedNumber = numberToChange;
        assertEquals (actualNumber, expectedNumber);
    }

   /* @DataProvider(name = "dp")
    public Object[][] provider(){
        return new Object[][] {
                {-1, 10, 3},
                {9, 5, 3},
                {7, -1, 1},
        };
    }*/

}
