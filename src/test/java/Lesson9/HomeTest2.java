package test.java.Lesson9;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class HomeTest2 {

    WebDriver driver;
    WebDriverWait wait;
    By inputMsg = By.cssSelector ("input[name*='search']");
    By buttonSeach = By.xpath ("//button[contains(text(), 'Найти')]");


    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.MILLISECONDS);
        wait = new WebDriverWait(driver, 10, 500);
    }

    @Test
    public void test1() {
        String phoneModel = "Samsung";
        driver.get("https://rozetka.com.ua/");
        wait.until (ExpectedConditions.elementToBeClickable (inputMsg));
        driver.findElement (inputMsg).click ();
        driver.findElement (inputMsg).sendKeys (phoneModel);
        driver.findElement (buttonSeach).click ();

        wait.until (ExpectedConditions.elementToBeClickable (By.cssSelector ("span.goods-tile__title")));

        List<WebElement> models = driver.findElements (By.cssSelector ("span.goods-tile__title"));

        String expectedPhoneModel = phoneModel;
        String tmp = "";

        for (WebElement model: models) {
            String str = model.getText ();
            boolean truePhoneModel = model.getText ().contains (phoneModel);
            if (truePhoneModel) {
                int ind1 = str.indexOf(phoneModel);
                int ind2 = ind1 + phoneModel.length();
                tmp = str.substring(ind1, ind2);
            }

            String actualPhoneModel = tmp;
            assertEquals(
                    actualPhoneModel,
                    expectedPhoneModel,
                    String.format ("Expected model: '%s', Seach model: '%s' ", model.getText (), phoneModel)
            );
        }
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}
