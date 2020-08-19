package main.java.Lesson3_1;

public class Task5_1 {
    public String reversStr(String s) {
        String result = "";
        result = reverse("Hello world!!!");
        return result;
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
