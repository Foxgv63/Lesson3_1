package test.java.Lesson7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PhoneSeach {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rozetka.com.ua/");
        driver.manage().window().maximize();

        By phone = By.cssSelector("div.header-phones button.header-phones__button");

        Thread.sleep (2000);
        WebElement phoneEl = driver.findElement(phone);
        String phoneValue = phoneEl.getText();
//        System.out.println(phoneValue);

        String s = phoneValue;
        s = s.replaceAll("[-,(,), ]", "");
        System.out.println("Phone format: " + s);

        driver.quit();
    }
}
