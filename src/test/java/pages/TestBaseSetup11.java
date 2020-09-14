package test.java.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class TestBaseSetup11 {
    public WebDriver driver;

    @Parameters({"browser"})
    @BeforeMethod
    public void setUp(String browser) {
        System.setProperty("webdriver.firefox.driver", "geckodriver.exe");
        ChromeOptions optionsChrome = new ChromeOptions();
        optionsChrome.addArguments("--disable-notifications");
        FirefoxOptions optionsFirefox = new FirefoxOptions();
        optionsFirefox.addArguments("--disable-notifications");

//        if(browser.equals ("firefox")) {
//            driver = new FirefoxDriver (optionsFirefox);
//        } else {
//            driver = new ChromeDriver (optionsChrome);
//        }


        try {
            if(browser.equals ("firefox")) {
                driver = new RemoteWebDriver(new URL("http://ec2-3-137-142-124.us-east-2.compute.amazonaws.com:4444/wd/hub"), optionsFirefox);
            } else {
                driver = new RemoteWebDriver (new URL ("http://ec2-3-137-142-124.us-east-2.compute.amazonaws.com:4444/wd/hub"), optionsChrome);
            }
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
