package test.java.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class TestBaseSetup11 {
    public WebDriver driver;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.firefox.driver", "geckodriver.exe");
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--disable-notifications");
//        driver = new FirefoxDriver (options);
        try {
            driver = new RemoteWebDriver (new URL ("http://ec2-18-217-223-209.us-east-2.compute.amazonaws.com:4444/wd/hub"), options);
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
