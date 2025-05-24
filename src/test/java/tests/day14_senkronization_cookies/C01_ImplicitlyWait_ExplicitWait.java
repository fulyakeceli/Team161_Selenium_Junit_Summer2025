package tests.day14_senkronization_cookies;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.ReusableMethods;

import java.time.Duration;

public class C01_ImplicitlyWait_ExplicitWait {

    @Test
    public void implicitlyWaitTest() {
        // Wait'lerin islevini daha iyi anlayabilmek icin
        // mahserin 3 atlisini @Test() icinde olusturalim

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //1. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //2. Textbox’in etkin olmadigini(enabled) dogrulayın
        WebElement textbox = driver.findElement(By.xpath("//*[@type='text']"));

        Assertions.assertFalse(textbox.isEnabled());

        //3. Enable butonuna tıklayın
        driver.findElement(By.xpath("//*[.='Enable']"))
                .click();
        // ve textbox etkin oluncaya kadar bekleyin
        ReusableMethods.bekle(4);
        // beklemeyi kaldirinca kapatmadi
        // cunku implicitlywait'in iki gorevi var
        //1- sayfanin yuklenmesini beklemek
        //2- herbir webelement'in locate edilebilir hale gelmesini beklemek



        //4. Textbox’in etkin oldugunu(enabled) dogrulayın.
        Assertions.assertTrue(textbox.isEnabled());
        // testin bu adiminda sayfa zaten yuklu textboxta locate edilebilir durumda
        // dolayisiyla implicitlywait bu beklemeyi yapmaz
        // implicitly wait kullanamiyorsak 2 ihtimal var
        // 1- bekleme suresi sabitse thread.sleep ama bu yontem dinamik degildir ve
        // net'in durumuna gore calisip calismayabilir
        // fazladan bekleme yapildigi icin testimiz efektif olmaz
        // 2- bu tur durumlarda weblemente istedigimiz isleve ozel
        // explicitwait kullanabiliriz

        //5. “It’s enabled!” mesajinin goruntulendigini dogrulayın.
        WebElement itsEnabledYaziElementi = driver.findElement(By.xpath("//*[.=\"It's enabled!\"]"));

        Assertions.assertTrue(itsEnabledYaziElementi.isDisplayed());

        ReusableMethods.bekle(2);
        driver.quit();
    }
}

