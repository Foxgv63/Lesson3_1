package main.java.Lesson3_1;

public class Task1_1 {
    public int compare() {
        int result;
        result = min1(5, 2, 3);
        return result;
    }

    public static int min1(int a, int b, int c) {
        int result;
        if ((a < b) && (a < c)) {
            result = a;
        } else if ((b < a) && (b < c)) {
            result = b;
        } else {
            result = c;
        }
        return result;

    }
}
