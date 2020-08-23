package main.java.Lesson3_1;

public class Task1_1 {
   /* public int compare() {
        int result;
        result = min1(5, 2, 3);
        return result;
    }*/

    public static int min1(int arr[]) {
        int result = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (result > arr[i]) {
                result = arr[i];
            }
        }
        return result;

    }
}
