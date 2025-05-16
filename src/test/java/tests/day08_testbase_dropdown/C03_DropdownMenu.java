package tests.day08_testbase_dropdown;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

public class C03_DropdownMenu extends TestBase_Each {

    @Test
    public void test01(){

        //https://the-internet.herokuapp.com/dropdown adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dropdown");


        //1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın

        // 1. adim: dropdown webelementi locate edip, kaydedin

        WebElement dropdownElementi = driver.findElement(By.xpath("//select[@id='dropdown']"));

        //2. adim: select objesi olusturup dropdown'i parametre olarak girin
        Select select = new Select(dropdownElementi);

        //3. adim: Select objesi ile istenen islemi yapin
        select.selectByIndex(1);
        System.out.println(select.getFirstSelectedOption().getText()); //Option 1

        ReusableMethods.bekle(2);



        //2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
        //  ayni dropdown oldugu icin, ayni select objesi ile islem yapabiliriz

        select.selectByValue("2");
        select.getFirstSelectedOption().getText(); // Option 2


        //3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        select.selectByVisibleText("Option 1");
        select.getFirstSelectedOption().getText();


        //4.Tüm dropdown değerleri(value) yazdırın

        System.out.println(ReusableMethods.stringListeDonustur(select.getOptions()));



        //5. Dropdown’un boyutunun 4 olduğunu test edin
        ReusableMethods.bekle(2);

        int expectedDropdownBoyutu = 4;
        int actualDropdownBoyutu = select.getOptions().size();

        Assertions.assertEquals(expectedDropdownBoyutu,actualDropdownBoyutu);

        ReusableMethods.bekle(2);

        /*

        org.opentest4j.AssertionFailedError:
        Expected :4
        Actual   :3

         */



    }
}
