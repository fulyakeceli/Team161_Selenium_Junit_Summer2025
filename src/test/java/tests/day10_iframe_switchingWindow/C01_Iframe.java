package tests.day10_iframe_switchingWindow;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

public class C01_Iframe extends TestBase_Each {



    @Test
    public void iframeTest(){

        ///1- https://testotomasyonu.com/discount adresine gidin
        driver.get("https://testotomasyonu.com/discount");

        //2- Electronics Products yazisinin gorunur olduğunu test edin

        // Electronic Products'i bulamadi demek, bu bir iframe'in icerisinde
        // webelement'i kullanmak icin driverî iframe'e switch yapmamiz gerekir
        // aramakismina //iframe yaziyorum ve istedigim indexteki iframe'i seciyorum

        WebElement iframeElectronics = driver.findElement(By.xpath("(//iframe)[1]"));
        driver.switchTo().frame(iframeElectronics);

        WebElement electronicsProductsElementi = driver.findElement(By.xpath("//h2[.='Electronics Products']"));

        Assertions.assertTrue(electronicsProductsElementi.isDisplayed());

        ReusableMethods.bekle(2);

        //3- Dell bilgisayar urun isminin ‘DELL Core I3 11th Gen’ olduğunu test edin
        //biz artik Electronic Products paralel evrenine gecis yaptik
        // Dell bu sayfada mi anasayfada mi? - iframe'in icinde hemen kullanabilirim

        WebElement dellBilgisayarElementi = driver.findElement(By.id("pictext1"));
        String expectedUrunIsmi = "DELL Core I3 11th Gen";
        String actualUrunIsmi = dellBilgisayarElementi.getText();

        Assertions.assertEquals(expectedUrunIsmi,actualUrunIsmi);

        //4- ‘Here are some products’ yazisinin gorunur olduğunu test edin

        // aranan yazi anasayfada, biz ise iframeElectronics ifarame'nin icindeyiz
        // o zaman oncelikle anasayfaya gecis yapmaliyiz
        driver.switchTo().defaultContent();

        String expectedYazi = "Here are some products.";

        WebElement yaziElementi = driver.findElement(By.xpath("//p[@class='desc']"));

        Assertions.assertEquals(expectedYazi,yaziElementi.getText());

        //5- ‘Fashion’ yazisinin gorunur olduğunu test edin
        //    fashion yazisi 2. iframe'in icinde oldugundan once o iframe'e gecis yapmaliyiz

        WebElement iframeFashion = driver.findElement(By.xpath("(//iframe)[2]"));
        driver.switchTo().frame(iframeFashion);


       WebElement fashionElementi = driver.findElement(By.xpath("//h2[.='Fashion']"));
       Assertions.assertTrue(fashionElementi.isDisplayed());

        //6- Fashion bolumundeki ilk urunu tiklayin
        //   ilk urunu tikladigimizda YENI BIR TAB'da urun aciliyor
        //   bu gorevi yapabilmek icin ONCE WINDOW'LAR ARASINDA NASIL GECIS YAPABILECEGIMIZI ogrenelim


        //   ve ilk urun isminde "Men Slim Fit" gectigini test edin

        ReusableMethods.bekle(2);

    }
}
