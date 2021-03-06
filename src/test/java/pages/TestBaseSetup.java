package test.java.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class TestBaseSetup {
    public WebDriver driver;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
//        driver = new ChromeDriver(options);
        try {
            driver = new RemoteWebDriver(new URL("http://ec2-18-217-223-209.us-east-2.compute.amazonaws.com:4444/wd/hub"), options);
        } catch (MalformedURLException e) {
            e.printStackTrace ();
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.MILLISECONDS);

    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        driver.quit();
    }

}
