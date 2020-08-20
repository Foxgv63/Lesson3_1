package test.java.Lesson3;

import main.java.Lesson3_1.Task2_1;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TestTask2_1 {

    @Test
    public void testGetMatrixReturnRows() {
        System.out.println ("Test 1");
        Task2_1 task21 = new Task2_1 ();
        String result = task21.printName ();
        int expectedRow = 5;
        int actualRow = result.split ("\n").length;
        assertEquals (actualRow, expectedRow);
    }

    @Test
    public void testGetMatrixReturnRowsLength() {
        System.out.println ("Test 2");
        Task2_1 task21 = new Task2_1 ();
        String result = task21.printName ();
        String[] rows = result.split ("\n");
        for (String row: rows) {
            int expectedRowLength = 10;
            int actualRowLength = row.split (" ").length;
            assertEquals (actualRowLength, expectedRowLength);
        }

    }

}

