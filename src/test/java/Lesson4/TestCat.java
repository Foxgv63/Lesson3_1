package test.java.Lesson4;

import main.java.Lesson4.Cat;

public class TestCat {
    public static void main(String[] args) {
        Cat cat = new Cat ("Barsik");
        int age = 105;
        cat.setAge (age);
        int actualAge = cat.getAge ();
        int expectedAge = age;
//        System.out.println (actualAge == expectedAge);
        if (actualAge != expectedAge) {
            throw new Error ("Validation failed"); // метод - выбросить ошибку
        }

        int age2 = 2;
        cat.setAge (age2);
        int actualAge2 = cat.getAge ();
        int expectedAge2 = age2;
        if (actualAge2 != expectedAge2) {
            throw new Error ("Validation failed"); // метод - выбросить ошибку
        }
    }

}
