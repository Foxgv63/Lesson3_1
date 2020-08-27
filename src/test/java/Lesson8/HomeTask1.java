package test.java.Lesson8;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class HomeTask1 {
    WebDriver driver;
    WebDriverWait wait;
    By personalOfficeBy = By.cssSelector("[class='header-topline__user-link link-dashed']");
    By register1By = By.cssSelector("[class='auth-modal__register-link']");
    By inputSurname = By.xpath ("//div[2]/div[2]//register/div//fieldset[1]/input");
    By inputName = By.xpath ("//div[2]/div[2]//register/div//fieldset[2]/input");
    By inputMail = By.xpath ("//div[2]/div[2]//register/div//fieldset[3]/input");
    By inputPassword = By.xpath ("//div[2]//div//fieldset[4]/div/input");
    By register2By = By.xpath ("//button[contains(text(), 'Зарегистрироваться')]");
    By errorMsgSurname = By.xpath ("//div[2]/div[2]//div//fieldset[1]//p");
    By errorMsgName = By.xpath ("//div[2]/div[2]//div//fieldset[2]//p");
    By errorMsgMail = By.xpath ("//div[2]/div[2]//div//fieldset[3]//p");


    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications"); // убирает всплывающее окно
        driver = new ChromeDriver (options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.MILLISECONDS);
        wait = new WebDriverWait (driver, 10, 500);
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
        driver.findElement (inputMail).click ();
        driver.findElement (inputPassword).click ();
        driver.findElement (register2By).click ();

        String actualErrMsgSurname = driver.findElement (errorMsgSurname).getText ();
        String expendedErrMsgSurname = "Введите свою фамилию на кириллице";
        assertEquals(actualErrMsgSurname, expendedErrMsgSurname);

        String actualErrMsgName = driver.findElement (errorMsgName).getText ();
        String expendedErrMsgName = "Введите свое имя на кириллице";
        assertEquals(actualErrMsgName, expendedErrMsgName);

        String actualErrMsgMail = driver.findElement (errorMsgMail).getText ();
        String expendedErrMsgMail = "Введите свою эл. почту или телефон";
        assertEquals(actualErrMsgMail, expendedErrMsgMail);

    }


    @AfterMethod
    public void tearDown(){
        driver.quit();
    }


}
