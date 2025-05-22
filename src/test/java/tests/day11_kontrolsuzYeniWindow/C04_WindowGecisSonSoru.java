package tests.day11_kontrolsuzYeniWindow;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WindowType;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

public class C04_WindowGecisSonSoru extends TestBase_Each {

    @Test
    public void test01() {

        // testotomasyonu anasayfaya gidin
        driver.get("https://www.testotomasyonu.com");
        ReusableMethods.bekle(3);

        // yeni bir tab acarak, wisequarter.com.tr adresine gidin

        driver.switchTo().newWindow(WindowType.TAB).get("https://www.testotomasyonu.com");

        ReusableMethods.bekle(2);

        // bagimsiz yeni bir window acarak youtube sayfasina gidin

        driver.switchTo().newWindow(WindowType.WINDOW).get("https://youtube.com");


        // Reusable methods classindaki window degistirme method'unu kullanarak
        String hedefUrl= "https://testotomasyonu.com";
        ReusableMethods.urlIleWindowGecisi(driver,hedefUrl);

        // testotomasyonu'nun acik oldugu window'a donun



        // url'in testotomasyonu icerdigini test edin
        String expectedUrl = "testotomasyonu";
        String actualUrl = driver.getCurrentUrl();

        Assertions.assertTrue(actualUrl.contains(expectedUrl));

        ReusableMethods.bekle(2);


        // wise quarter'in acik oldugu window'a donun

        hedefUrl = "https://wisequarter.com";

        ReusableMethods.urlIleWindowGecisi(driver,hedefUrl);


        // title'in Wise icerdigini test edin,

        String expectedTitleIcerik = "Wise";
        String actualTitleIcerik = driver.getTitle();

        Assertions.assertTrue(actualTitleIcerik.contains(expectedTitleIcerik));

        ReusableMethods.bekle(2);


        // youtube'un acik oldugu window'a donun
        hedefUrl = "https://youtube.com";
        ReusableMethods.urlIleWindowGecisi(driver,hedefUrl);

        ReusableMethods.bekle(2);


        // url'in youtube icerdigini test edin

        String expectedUrlYT = "youtube";
        String actualUrlYT = driver.getCurrentUrl();

        Assertions.assertTrue(actualUrlYT.contains(expectedUrlYT));

        ReusableMethods.bekle(2);




    }



}
