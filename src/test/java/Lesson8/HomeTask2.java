package test.java.Lesson8;

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

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class HomeTask2 {

    WebDriver driver;
    WebDriverWait wait;
    By personalOfficeBy = By.cssSelector("[class='header-topline__user-link link-dashed']");
    By register1By = By.cssSelector("[class='auth-modal__register-link']");
    By inputSurname = By.xpath ("//div[2]/div[2]//register/div//fieldset[1]/input");
    By inputName = By.xpath ("//div[2]/div[2]//register/div//fieldset[2]/input");
    By inputMail = By.xpath ("//div[2]/div[2]//register/div//fieldset[3]/input");
    By inputPassword = By.cssSelector ("[class='form__row_with_button']>input");
    By register2By = By.xpath ("//button[contains(text(), 'Зарегистрироваться')]");
    By errorMsgSurname = By.xpath ("//div[2]/div[2]//div//fieldset[1]//p");
    By errorMsgName = By.xpath ("//div[2]/div[2]//div//fieldset[2]//p");
    By errorMsgMail = By.cssSelector ("[class='form__row js-contact']>input");
    By errorMsgPasw = By.cssSelector ("[class='form__row_with_button']>input");


    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications"); // убирает всплывающее окно
        driver = new ChromeDriver (options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.MILLISECONDS);
        wait = new WebDriverWait(driver, 10, 500);
    }

    @Test
    public void test1() {
        driver.get("https://rozetka.com.ua/");
        wait.until (ExpectedConditions.elementToBeClickable (personalOfficeBy));
        driver.findElement(personalOfficeBy).click();

        wait.until (ExpectedConditions.elementToBeClickable (register1By));
        driver.findElement(register1By).click();

        wait.until (ExpectedConditions.elementToBeClickable (inputSurname));
        driver.findElement (inputSurname).click ();
        driver.findElement (inputName).click ();
        driver.findElement (inputMail).sendKeys ("a@a.a");
        driver.findElement (inputPassword).sendKeys ("A12345678a");
        driver.findElement (register2By).click ();

        WebElement inputSurname = driver.findElement (errorMsgSurname);
        String actualColorSurname = inputSurname.getCssValue("border-color");
        String expendedColorSurname = "rgb(248, 65, 71)";
        assertEquals (actualColorSurname, expendedColorSurname);


        WebElement inputName = driver.findElement (errorMsgName);
        String actualColorName = inputName.getCssValue("border-color");
        String expendedColorName = "rgb(248, 65, 71)";
        assertEquals (actualColorName, expendedColorName);

        WebElement inputMail = driver.findElement (errorMsgMail);
        String actualColorMail = inputMail.getCssValue ("border-color");
        String expendedColorMail = "rgb(210, 210, 210)";
        assertEquals (actualColorMail, expendedColorMail);

        WebElement inputPasw = driver.findElement (errorMsgPasw);
        String actualColorPasw = inputPasw.getCssValue ("border-color");
        String expendedColorPasw = "rgb(209, 209, 209)";
        assertEquals (actualColorPasw, expendedColorPasw);


    }


    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}
