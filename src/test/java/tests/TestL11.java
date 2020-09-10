package test.java.tests;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import test.java.pages.HomePageL10;
import test.java.pages.NotebookPageL10;
import test.java.pages.TestBaseSetup11;

public class TestL11 extends TestBaseSetup11 {
    HomePageL10 homePageL10;
    NotebookPageL10 notebookPageL10;
    Logger logger = LogManager.getLogger (this.getClass ().getName ());
    String actualProducerModel = "";



    @BeforeMethod
    public void PageProducer(ITestContext testContext) {
        homePageL10 = new HomePageL10 (driver);
        notebookPageL10 = new NotebookPageL10 (driver);
        testContext.setAttribute("driver", driver);
    }

    @Test(dataProvider = "dp")
    public void Test (String produser) {
        String producerModel = produser;

        homePageL10
                .open ()
                .seachNotebook ();
//        notebookPageL10.seachProducers (producerModel);
//        List<WebElement> producers = notebookPageL10.getProdusers ();
//
//        String tmp = "";
//        for (WebElement producer: producers) {
//            String str = producer.getText ();
//            boolean trueProducer = producer.getText ().contains (producerModel);
//            if (trueProducer) {
//                int ind1 = str.indexOf (producerModel);
//                int ind2 = ind1 + producerModel.length ();
//                tmp = str.substring (ind1, ind2);
//            }
//            actualProducerModel = tmp;
//        }
//
////        this.logger.error ("Comparison of models");
//
//        assertEquals(
//                actualProducerModel,
//                producerModel,
//                String.format ("Expected model: '%s', Seach model: '%s' ",  producerModel, actualProducerModel)
//        );

    }

    @DataProvider(name = "dp")
    public Object[][] provider() {
        return new Object[][]{
                {"Acer" }, {"Apple" }, {"Asus" }//, {"Dell" }, {"Dream Machines" }, {"HP" }, {"Huawei" }, {"Lenovo" }, {"MSI" }, {"Microsoft" }, {"Razer" }, {"Xiaomi" }, {"Alien" }, {"Chuwi" }, {"Compaq" }, {"Digma" }, {"Durabook" }, {"Epic" }, {"Fujitsu" }, {"Fujitsu-siemens" }, {"Gigabyte" }, {"Google" }, {"Jumper" }, {"Mediacom" }, {"Medion" }, {"Mixzo" }, {"NuVision" }, {"Odys" }, {"Panasonic" }, {"Porsche Design" }, {"Prestigio" }, {"RCA" }, {"Teclast" }, {"Toshiba" }, {"Vinga" }, {"Yepo" }
        };
    }

}
