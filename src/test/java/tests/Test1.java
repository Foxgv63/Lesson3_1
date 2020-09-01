package test.java.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.java.pages.HomePage;

import java.util.concurrent.TimeUnit;

public class Test1 {
    WebDriver driver;
    HomePage homePage;
    String phoneModel = "iPhone";


    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver (options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.MILLISECONDS);
        homePage = new HomePage(driver);
    }

    @Test
    public void Test() {
        homePage.open ()
                .seachLine (phoneModel)
                .compareModel (phoneModel);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
