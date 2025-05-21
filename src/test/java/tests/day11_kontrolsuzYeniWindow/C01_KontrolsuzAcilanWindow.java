package tests.day11_kontrolsuzYeniWindowKullanimi;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

import java.util.Set;

public class C01_KontrolsuzAcilanWindow extends TestBase_Each {

    @Test
    public void test01(){

        //1- https://testotomasyonu.com/discount adresine gidin

        driver.get("https://testotomasyonu.com/discount ");


        //2- Fashion bolumunde ilk urunu tiklayin
        //   Fashion bolumu bir iFrame icinde oldugundan, once o iFrame'e gecis yapmaliyiz

        WebElement iFrameFashion = driver.findElement(By.xpath("(//iframe)[2]"));
        driver.switchTo().frame(iFrameFashion);


        System.out.println("ilk urunu tiklamadan once ");
        System.out.println("window handle degeri: " + driver.getWindowHandle());
        System.out.println("window handles : " + driver.getWindowHandles());

        //1. adım : tıklamadan once ilk windowun WH degerini kaydedelim
        String ilkWindowWhd = driver.getWindowHandle();

        WebElement ilkUrun = driver.findElement(By.id("pic1_thumb"));
        ilkUrun.click();
        // driver bekliyor ki aynı windowda yeni bir sayfa acilsin ve men slim fit'in detayini gorelim
        // ama web sayfasi bizi ayri bir windowa goturuyor
        // driver ilk sayfada hala bekliyor ve bulamiyorr
        // ikinci sayfanin window handle degerini bilsek oraya gecis yapabiliriz.

        System.out.println("ilk urunu tikladiktan sonra ");
        System.out.println("window handle degeri: " + driver.getWindowHandle());
        System.out.println("window handles : " + driver.getWindowHandles());

        // 2. adim : tikladiktan sonra eski ve yeni windowlarin WHD'lerini bir Set olarak kaydedelim
        Set<String> ikiWindowunWhdSeti = driver.getWindowHandles();

        //3. adim: Elimizde 1. ve 2. window'un WHD oldugu bir set
        // bir de 1. window'un WHD'si var
        // hedef: setteki WHD'leri elden gecirip,
        // 1. window'un WHD'sine esit olmayani
        // 2. window'un WHD olarak kaydetmek
        // amac: ikinci window'un WHD'sini bulup kaydetmek

        // for each loop ile aratip 1. WHD'ye esit olmayani atama yapabiliriz

        String ikinciWhd = "";
        for (String eachWhd :ikiWindowunWhdSeti){

            if (!eachWhd.equals(ilkWindowWhd)){
                ikinciWhd = eachWhd;

            }

        }

        System.out.println("Yapilan islemlerden sonra :");
        System.out.println("1. Whd :" + ilkWindowWhd);
        System.out.println("2. Whd: " + ikinciWhd);

        // artik 2. windowa gecis yapabiliriz cunku Whd'yi biliyoruz
        driver.switchTo().window(ikinciWhd);

        System.out.println(driver.getCurrentUrl());

        ReusableMethods.bekle(2);


        //3- acilan urun sayfasinda urun ismininin
        //   case sensitive olmadan dress icerdigini test edin

        String expectedIsimIcerigi = "shirt";

        WebElement urunIsimElementi = driver.findElement(By.xpath("//*[@class=' heading-sm mb-4']"));

        String actualUrunIsmi = urunIsimElementi.getText().toLowerCase();

        Assertions.assertTrue(actualUrunIsmi.contains(expectedIsimIcerigi));

        // 4- Ilk window'a donun

        driver.switchTo().window(ilkWindowWhd);
        System.out.println(driver.getCurrentUrl()); //ilk windowa gectigimizi anlamak icin

        // zaten iframe'i kaydetmistim direkt gecis yapabilirim tekrar iframe'e gecmeme gerek yok

        // ve Fashion yazisinin gorunur oldugunu test edin

        WebElement fashionYaziElementi = driver.findElement(By.xpath("//h2[.='Fashion']"));

        Assertions.assertTrue(fashionYaziElementi.isDisplayed());



        ReusableMethods.bekle(3);
    }
}