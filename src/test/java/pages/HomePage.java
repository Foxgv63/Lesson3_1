package test.java.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class HomePage {
    WebDriver driver;
    WebDriverWait wait;
//    String phoneModel = "iPhone";
    By inputMsgBy = By.cssSelector ("input[name*='search']");
    By buttonSeachBy = By.xpath ("//button[contains(text(), 'Найти')]");


    public HomePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait (driver, 10, 500);
    }

    public HomePage open() {
        this.driver.get ("https://rozetka.com.ua/");
        return this;
    }

    public HomePage seachLine(String phoneModel) {
        WebElement msgSeach = this.driver.findElement (inputMsgBy);
        wait.until (ExpectedConditions.elementToBeClickable (msgSeach));
        msgSeach.click ();
        msgSeach.sendKeys (phoneModel);
        WebElement btnSeach = this.driver.findElement (buttonSeachBy);
        btnSeach.findElement (buttonSeachBy).click ();
        return this;
    }

    public HomePage compareModel(String phoneModel) {
        wait.until (ExpectedConditions.elementToBeClickable (By.cssSelector ("span.goods-tile__title")));
        List<WebElement> models = driver.findElements (By.cssSelector ("span.goods-tile__title"));
        String tmp = "";
        for (WebElement model : models) {
            String str = model.getText ();
            boolean truePhoneModel = model.getText ().contains (phoneModel);
            if (truePhoneModel) {
                int ind1 = str.indexOf (phoneModel);
                int ind2 = ind1 + phoneModel.length ();
                tmp = str.substring (ind1, ind2);
            }
        }
        String expectedPhoneModel = phoneModel;
        String actualPhoneModel = tmp;
        assertEquals(
                actualPhoneModel,
                expectedPhoneModel,
                String.format ("Expected model: '%s', Seach model: '%s' ", actualPhoneModel, expectedPhoneModel)
        );
        return this;
    }
}

