package tests.day14_senkronization_cookies;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class C03_ImplicitlyWaitTest {


    //1. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
    //2. Remove butonuna basin.
    //3. “It’s gone!” mesajinin goruntulendigini dogrulayin.
    //4. Add buttonuna basin
    //5. It’s back mesajinin gorundugunu test edin

    @Test
    public void implicitlyWaitTest() {
        // Wait'lerin islevini daha iyi anlayabilmek icin
        // mahserin 3 atlisini @Test() icinde olusturalim

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        //1. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //2. Remove butonuna basin.
        driver.findElement(By.xpath("//*[@onclick='swapCheckbox()']")).click();

        //3. “It’s gone!” mesajinin goruntulendigini dogrulayin.
        /*
            remove butonuna basar basmaz
            itsGoneElementi'ni locate ediyoruz

            Aslinda itsGoneElementi 3 saniye sonra geliyor
            ama olmayan bir webelement'in locate edilebilmesi icin bekleme gorevi
            implicitly wait'in gorev alanina girdigi icin
            implicitly wait bekleme islemini hallediyor

         */

        WebElement itsGoneElementi = driver.findElement(By.xpath("//*[.=\"It's gone!\"]"));

        Assertions.assertTrue(itsGoneElementi.isDisplayed());

        // 4. Add butonuna basın
        driver.findElement(By.xpath("//*[.='Add']")).click();

        //5. It’s back mesajinin gorundugunu test edin

        WebElement itsBackYaziElementi = driver.findElement(By.xpath("//*[.=\"It's back!\"]"));

        Assertions.assertTrue(itsBackYaziElementi.isDisplayed());

        driver.quit();


    }

}



