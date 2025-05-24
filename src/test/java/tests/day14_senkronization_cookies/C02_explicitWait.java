package tests.day14_senkronization_cookies;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class C02_explicitWait {

    @Test
    public void explicitWaitTest(){
        // Wait'lerin islevini daha iyi anlayabilmek icin
        // mahserin 3 atlisini @Test() icinde olusturalim

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //1. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //2. Textbox’in etkin olmadigini(enabled) dogrulayın
        WebElement textbox= driver.findElement(By.xpath("//*[@type='text']"));

        Assertions.assertFalse(textbox.isEnabled());

        //3. Enable butonuna tıklayın
        driver.findElement(By.xpath("//*[.='Enable']"))
                .click();

        // ve textbox etkin oluncaya kadar bekleyin
        /*
            Explicit Wait;
            implicitly wait'in cozum olmadigi durumlarda
            spesifik bir webelement (textbox)
            ve spesifik bir durum (etkin oluncaya kadar bekleme) icin olusturulur

            explicitwait olusturmak icin 3 adim atmamiz lazim
         */
        // 1.adim : webdriver wait objesi olusturun
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
        // 2.adim : kullanilacak webelement'i locate edin
        //          biz textbox'i zaten locate edip kaydettik

        // 3.adim : wait objesi ile spesifik webelement ve spesifik sebebinizi yazin
        //          spesifik sebebi Selenium tarafindan olusturulmus olan
        //          ExpectedConditions()'dan seceriz
        wait.until(ExpectedConditions.elementToBeClickable(textbox));

        // hazir method'lar ile Selenium'a şunu dedik
        // "textbox clickable oluncaya kadar(maximum 20 sn) bekle"

        //4. Textbox’in etkin oldugunu(enabled) dogrulayın.

        Assertions.assertTrue(textbox.isEnabled());

        //5. “It’s enabled!” mesajinin goruntulendigini dogrulayın.
        WebElement itsEnabledYaziElementi = driver.findElement(By.xpath("//*[.=\"It's enabled!\"]"));

        Assertions.assertTrue(itsEnabledYaziElementi.isDisplayed());

        driver.quit();

    }
}