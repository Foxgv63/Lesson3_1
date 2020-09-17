package test.java.pages;

import io.qameta.allure.Step;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import test.java.utils.PropertyLoader;

public class HomePageL10 extends BasePage {

    WebDriver driver;
    Logger logger = LogManager.getLogger (this.getClass ().getName ());
    By seachCatalogProduct = By.cssSelector ("button.menu-toggler");
    By seachCompNote = By.xpath ("//ul[@class='menu-categories']//li[@class='menu-categories__item menu-categories__item_state_hovered']/a[contains(@href,'computers-notebooks')]");
    By inputToNotebook = By.cssSelector ("[class='tile-cats__heading tile-cats__heading_type_center'][title='Ноутбуки']");



    public HomePageL10 (WebDriver driver) {
        super (driver);
        this.driver = driver;
    }

    public HomePageL10 open() {
        driver.get(PropertyLoader.loadProperty ("baseurl"));
        this.logger.info ("Open Home page");
        return this;
    }

    @Step("Seach notebook")
    public HomePageL10 seachNotebook() {
        driver.findElement (seachCatalogProduct).click ();
        driver.findElement (seachCompNote).click ();
        wait.until (ExpectedConditions.elementToBeClickable (inputToNotebook));
        driver.findElement (inputToNotebook).click ();
        this.logger.info ("Seach notebooks");
        return this;
    }

}
