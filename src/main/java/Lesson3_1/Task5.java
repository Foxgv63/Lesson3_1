package main.java.Lesson3_1;

public class Task5 {
    public static void main(String[] args) {
        System.out.println(reverse("Hello world!!!"));
    }

    public static String reverse(String str) {
        String result = "";
        int j = (str.length () - 1);
        for (int i = 0; i < str.length (); i++) {
            result += Character.toString (str.charAt (j));
            j--;
        }
        return result;
    }
}
