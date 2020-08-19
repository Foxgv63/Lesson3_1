package test.java.Lesson6;

import main.java.Lesson4.Cat;
import org.testng.annotations.*;

import static org.testng.Assert.assertEquals;

public class TestCat {
    Cat cat;

    @BeforeMethod  //будет выполняться каждый раз перед каждым тестовым методом
    public void setUp() { //перед каждым тестом создаем новый экземпляр класса Cat
        System.out.println ("- Before Method");
        //some action
        cat = new Cat ("Vasiliy");
    }

   /* {
        {},
        {},
        {},
        {}
    }*/


    @Test(dataProvider = "dp")
    public void testGetAge(int ageToChange, int expectedAge) {
        System.out.printf ("Test 1 with age to change = '%d' and expected age = '%d'\n", ageToChange, expectedAge);
        Cat cat = new Cat ();
//        int ageToChange = 10;
        cat.setAge (ageToChange);
        int actualAge = cat.getAge ();
//        int expectedAge = ageToChange;
//        assertEquals(actualAge, expectedAge);
//        assertEquals(actualAge, 0, "Expected age to be " + expectedAge); //или через String.format
        assertEquals(actualAge, expectedAge, String.format ("Expected cat age to be '%d'", expectedAge));

    }

    @Test
    public void testGetMatrixShouldReturnRows() {  //подсчитать сколько выводится строк в матрице
        System.out.println ("Test2");
        String result = cat.getMatrix ();
//        System.out.println (result);
        int expectedRowAmount = 5; // ожидаемое значение строк равно 5
        int actualRowAmount = result.split ("\n").length; // split (разделить) возвращает массив и нам нужна длина массива
        assertEquals (actualRowAmount, expectedRowAmount);
    }


    @Test
    public void testGetMatrixShouldReturnRowsLength(){ // проверить, что длина каждой строки равна 5
        System.out.println ("Test3");
        String result = cat.getMatrix ();
        String rows[] = result.split ("\n");
        for (String row: rows) {
            int expectedRowLength = 5;
            int actualRowLength = row.split (" ").length;
            assertEquals (actualRowLength, expectedRowLength);
        }
    }

    @Parameters({"age", "salary"})
    @Test
    public void xmlParams(@Optional("10") int age, @Optional("500") int salary) {
        System.out.printf ("First: '%d', second: '%d'", age, salary);

    }


    @DataProvider(name = "dp")
    public Object[][] provider() {
        return new Object[][] {
                {-1, 20},
                {0, 20},
                {1, 1},
                {10, 10},
                {21, 21},
                {22, 20}
        };

    }

}
