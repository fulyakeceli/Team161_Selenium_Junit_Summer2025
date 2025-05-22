package tests.day11_kontrolsuzYeniWindow;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

public class C03_MethodIleWindowGecisi extends TestBase_Each {

    @Test
    public void test01() {
        //● https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");

        //● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        WebElement text = driver.findElement(By.xpath("//h3[.='Opening a new window']"));
        Assertions.assertTrue(text.isDisplayed());

        ReusableMethods.bekle(2);


        //● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        String expectedTitle = "The Internet";
        String actualTitle = driver.getTitle();

        Assertions.assertEquals(expectedTitle,actualTitle);

        ReusableMethods.bekle(2);


        //● Click Here butonuna basın.

         driver.findElement(By.linkText("Click Here")).click();

         ReusableMethods.bekle(2);


        //● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu test edin
        // ilk once driver'i acilan 2.window'a gecirmeliyiz
        // biz kaydettigimiz icin tekrardan kod yazmadik

        String hedefUrl = "https://the-internet.herokuapp.com/windows/new";
        ReusableMethods.urlIleWindowGecisi(driver, hedefUrl);


        //● Sayfadaki textin “New Window” olduğunu doğrulayın.


        WebElement titleElementi = driver.findElement(By.xpath("//h3['New Window']"));

        String expectedTitleNW = "New Window";
        String actualTitleNW = driver.getTitle();

        Assertions.assertEquals(expectedTitleNW,actualTitleNW);

        ReusableMethods.bekle(2);


        //● Bir önceki pencereye geri döndükten sonra
        // ilk window'a gecis yapalim

        hedefUrl = "https://the-internet.herokuapp.com/window";

        ReusableMethods.urlIleWindowGecisi(driver,hedefUrl);

        // sayfa başlığının “The Internet” olduğunu test edin

        String expectedTitleInt = "The Internet";
        String actualTitleInt = driver.getTitle();

        Assertions.assertEquals(expectedTitleInt,actualTitleInt);



    }
}
