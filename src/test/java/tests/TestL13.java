package test.java.tests;

import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.java.pages.HomePageL10;
import test.java.pages.NotebookPageL10;
import test.java.pages.TestBaseSetup13;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class TestL13 extends TestBaseSetup13 {
    HomePageL10 homePageL10;
    NotebookPageL10 notebookPageL10;
    String actualProducerModel = "";
    String produser[] = {"Acer", "Apple", "Asus", "Dell", "Dream Machines", "HP", "Huawei", "Lenovo", "MSI", "Microsoft", "Razer", "Xiaomi", "Alien", "Chuwi", "Compaq", "Digma", "Durabook", "Epic", "Fujitsu", "Fujitsu-siemens", "Gigabyte", "Google", "Jumper", "Mediacom", "Medion", "Mixzo", "NuVision", "Odys", "Panasonic", "Porsche Design", "Prestigio", "RCA", "Teclast", "Toshiba", "Vinga", "Yepo"};



    @BeforeMethod
    public void PageProducer() {
        homePageL10 = new HomePageL10 (driver);
        notebookPageL10 = new NotebookPageL10 (driver);
    }

    @Test
    public void Test () {

        int min = 10;
        int max = produser.length;
        int rand = (int)(Math.random () * (max - min + 1)) + min;
        String producerModel = produser[rand];

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
            }
            actualProducerModel = tmp;
        }

        assertEquals(
                actualProducerModel,
                producerModel,
                String.format ("Expected model: '%s', Seach model: '%s' ",  producerModel, actualProducerModel)
        );

    }

}
