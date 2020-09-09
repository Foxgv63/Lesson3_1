package test.java.utils;

import java.util.ResourceBundle;

public class PropertyLoader {

    public static String loadProperty(String name) {
        return ResourceBundle.getBundle ("config").getString (name);
    }
}
