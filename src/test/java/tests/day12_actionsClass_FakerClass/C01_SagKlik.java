package tests.day12_actionsClass_FakerClass;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase_Each;



public class C01_SagKlik extends TestBase_Each {


    @Test
    public  void test01(){

       // 1- https://testotomasyonu.com/click sitesine gidin

        driver.get("https://testotomasyonu.com/click");

        ReusableMethods.bekle(1);


       // 2- “DGI Drones” uzerinde sag click yapin

        Actions actions = new Actions(driver);
        ReusableMethods.bekle(2);

        WebElement dgiDronesElementi = driver.findElement(By.id("pic2_thumb"));
        ReusableMethods.bekle(2);

        actions.contextClick(dgiDronesElementi).perform();
        ReusableMethods.bekle(2);


       // 3- Alert’te cikan yazinin “Tebrikler!... Sağ click yaptınız.” oldugunu test edin.

        String expectedYaziElementi = "Tebrikler!... Sağ click yaptınız.";
        String actualYaziElementi = driver.switchTo().alert().getText();

        Assertions.assertEquals(expectedYaziElementi,actualYaziElementi);
        ReusableMethods.bekle(2);


       //  4- Tamam diyerek alert’i kapatalim

        driver.switchTo().alert().accept();
        ReusableMethods.bekle(3);




    }
}
