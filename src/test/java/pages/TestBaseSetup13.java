package test.java.pages;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class TestBaseSetup13 {
    public WebDriver driver;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.firefox.driver", "geckodriver.exe");
        FirefoxOptions optionsFirefox = new FirefoxOptions();
        optionsFirefox.addArguments("--disable-notifications");
        driver = new FirefoxDriver (optionsFirefox);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.MILLISECONDS);
    }

    @AfterMethod
    public void tearDown(ITestContext result) {
        result.setAttribute ("driver", driver);
        saveScreenshot (result);
        driver.quit();
    }


    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] saveScreenshot(ITestContext testContext) {
        WebDriver driver = (WebDriver) testContext.getAttribute ("driver");
        return ((TakesScreenshot) driver).getScreenshotAs (OutputType.BYTES);
    }

}
