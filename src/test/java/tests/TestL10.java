package test.java.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import test.java.pages.HomePageL10;
import test.java.pages.NotebookPageL10;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class TestL10 {
    WebDriver driver;
    HomePageL10 homePageL10;
    NotebookPageL10 notebookPageL10;
    String actualProducerModel = "";



    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver (options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.MILLISECONDS);
        homePageL10 = new HomePageL10 (driver);
        notebookPageL10 = new NotebookPageL10 (driver);
    }

    @Test (dataProvider = "dp")
    public void Test (String produser) {

        String producerModel = produser;

        homePageL10
                .open ()
                .seachNotebook ();
        notebookPageL10.seachProducers (producerModel);
        List<WebElement> producers = notebookPageL10.getProdusers ();

        String tmp = "";
        for (WebElement producer: producers) {
            String str = producer.getText ();
            boolean trueProducer = producer.getText ().contains (producerModel);
            if (trueProducer) {
                int ind1 = str.indexOf (producerModel);
                int ind2 = ind1 + producerModel.length ();
                tmp = str.substring (ind1, ind2);
                System.out.println (tmp);
            }
            actualProducerModel = tmp;
        }
        assertEquals(
                actualProducerModel,
                producerModel,
                String.format ("Expected model: '%s', Seach model: '%s' ",  producerModel, actualProducerModel)
        );

    }

    @DataProvider(name = "dp")
    public Object[][] provider() {
        return new Object[][]{
                {"Acer" }, {"Apple" }, {"Asus" }//, {"Dell" }, {"Dream Machines" }, {"HP" }, {"Huawei" }, {"Lenovo" }, {"MSI" }, {"Microsoft" }, {"Razer" }, {"Xiaomi" }, {"Alien" }, {"Chuwi" }, {"Compaq" }, {"Digma" }, {"Durabook" }, {"Epic" }, {"Fujitsu" }, {"Fujitsu-siemens" }, {"Gigabyte" }, {"Google" }, {"Jumper" }, {"Mediacom" }, {"Medion" }, {"Mixzo" }, {"NuVision" }, {"Odys" }, {"Panasonic" }, {"Porsche Design" }, {"Prestigio" }, {"RCA" }, {"Teclast" }, {"Toshiba" }, {"Vinga" }, {"Yepo" }
        };
    }


    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
