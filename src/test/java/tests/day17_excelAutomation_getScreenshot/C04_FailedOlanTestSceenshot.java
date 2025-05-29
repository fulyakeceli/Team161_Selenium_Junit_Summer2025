package tests.day17_excelAutomation_getScreenshot;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

import java.io.File;
import java.io.IOException;

public class C04_FailedOlanTestSceenshot extends TestBase_Each {



    @Test
    public void test01() throws IOException {

        try {
            // testotomasyonu anasayfaya gidin
            driver.get("https://www.testotomasyonu.com");

            // java icin arama yapin
            WebElement aramaKutusu = driver.findElement(By.id("global-search"));
            aramaKutusu.sendKeys("java" + Keys.ENTER);

            ReusableMethods.bekle(1);

            // arama sonucunda urun bulunabildigini test edin
            WebElement aramaSonucElementi = driver.findElement(By.className("product-count-text"));

            String unExpectedAramaSonucu = "0 Products Found";
            String actualAramaSonucu = aramaSonucElementi.getText();

            Assertions.assertNotEquals(unExpectedAramaSonucu, actualAramaSonucu);

        } finally {

            // rapora eklemek icin arama sonuc sayfasinin screenshot'ini alin

            // 1.adim : TakesScreenshot objesi olustur
            TakesScreenshot tss = (TakesScreenshot) driver;



            // 2.adim : screenshot'i kaydedecegimiz dosyayi (File) olusturun
            // target'in altindan new => directory olusturduk onun altina new file .jpg uzantili dosya olusturduk
            File file = new File("target/screenshots/tumSayfaScreenshot.jpg");

            // dosya yolunu alabilmek icin new file .jpg dosyasini olusturduk alinca silebiliriz


            // 3.adim : screenshot'i alip gecici bir dosyaya kaydedin
            File geciciResim = tss.getScreenshotAs(OutputType.FILE);


            // 4.adim : geciciresim dosyasini, asil kaydetmek istedigimiz file'a kopyalayalim
            FileUtils.copyFile(geciciResim,file);

            //Test failed oldu fotografi cekmedi. neden??
            // -30. satirda test failed oldu bu nedenle de fotograf cekecegimiz yere gelemedi
            // Assertion failed error verdi bizim bunu bir try catch icerisine almamiz lazim
            // boylelikle test failed olsa bile screenshot alir
            // try finally yaptik raporun her durumda calismasini saglamak icin



            // Not: // dosya yolu 1 tane oldugundan
            // en son hangisi calistirdiysa o kalir bu yuzden 1 tane ss var method olusturmamiz lazim!!!

        }





    }
}

