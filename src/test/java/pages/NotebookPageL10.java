package test.java.pages;

import io.qameta.allure.Step;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class NotebookPageL10 extends BasePage {

    WebDriver driver;
    Logger logger = LogManager.getLogger (this.getClass ().getName ());
    By inputMsgBy = By.xpath ("//div[3]//div[1]/input");
    By seachProducersBy = By.cssSelector ("a[href*='/notebooks/c80004/producer=']");



    public NotebookPageL10 (WebDriver driver) {
        super (driver);
        this.driver = driver;
    }

    @Step("Seach produser {producerModel}")
    public NotebookPageL10 seachProducers (String producerModel) {
        wait.until (ExpectedConditions.elementToBeClickable (inputMsgBy));
        driver.findElement (inputMsgBy).click ();
        driver.findElement (inputMsgBy).sendKeys (producerModel);
        wait.until(ExpectedConditions.numberOfElementsToBe (seachProducersBy, 1));
        driver.findElement (seachProducersBy).click ();
        this.logger.debug ("Seach producer nootbooks");
        return this;
    }

    public List<WebElement> getProdusers () {
        wait.until (ExpectedConditions.elementToBeClickable (By.cssSelector ("span.goods-tile__title")));
        List<WebElement> models = driver.findElements (By.cssSelector ("span.goods-tile__title"));
        return models;
    }

}
