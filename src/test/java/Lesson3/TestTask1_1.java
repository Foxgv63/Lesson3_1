package test.java.Lesson3;

import main.java.Lesson3_1.Task1_1;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TestTask1_1 {

    @Test(dataProvider = "dp")
    public void ComparisonNumbers(int arr[], int expectedNumber){
        Task1_1 task11 = new Task1_1 ();
        int actualNumber = Task1_1.min1(arr);
        System.out.print("Actual number: " + actualNumber + "\n" + "Expected number: " + expectedNumber);
        assertEquals (actualNumber, expectedNumber);
    }


    @DataProvider(name = "dp")
    public Object[][] provider() {
        return new Object[][]{
                {new int[] {1, 2, 3, 4}, 1},
                {new int[] {1, 2, 3, -4}, -4},
                {new int[] {1, 8, -2, 9}, -2}
        };
    }

}
