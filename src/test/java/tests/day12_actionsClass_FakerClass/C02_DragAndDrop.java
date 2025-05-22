package tests.day12_actionsClass_FakerClass;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase_All;
import utilities.TestBase_Each;


public class C02_DragAndDrop extends TestBase_All {

@Test
    public void test01(){



   // 1- https://testotomasyonu.com/droppable adresine gidelim


    driver.get("https://testotomasyonu.com/droppable");

    // 2- Accept bolumunde “Acceptable” butonunu tutup “Drop Here” kutusunun ustune birakalim
    Actions actions = new Actions(driver);
    ReusableMethods.bekle(3);

    WebElement acceptableButton = driver.findElement(By.xpath("//*[@id='draggable2']"));

    WebElement dropHereButton = driver.findElement(By.xpath("//*[@id='droppable2']"));

    ReusableMethods.bekle(1);

    actions.dragAndDrop(acceptableButton,dropHereButton).perform();

    ReusableMethods.bekle(2);


   //3- “Drop here” yazisi yerine “Dropped!” oldugunu test edin

    String expectedYaziElementi = "Dropped!";
    String actualYaziElementi = dropHereButton.getText();

    Assertions.assertEquals(expectedYaziElementi,actualYaziElementi);
    ReusableMethods.bekle(1);

   //4- Sayfayi yenileyin

    driver.navigate().refresh();

    ReusableMethods.bekle(1);

   //5- “Not Acceptable” butonunu tutup “Drop Here” kutusunun ustune birakalim

    WebElement notAcceptableElementi = driver.findElement(By.xpath("//*[@id='draggable-nonvalid2']"));
    dropHereButton = driver.findElement(By.xpath("//*[@id='droppable2']"));
    // sayfayi yeniledikten sonra goremedigi icin tekrar locate ettik

    ReusableMethods.bekle(1);

    actions.dragAndDrop(notAcceptableElementi,dropHereButton).perform();
    ReusableMethods.bekle(1);

   //6- “Drop Here” yazisinin degismedigini test edin

    String dropHereYazi = "Drop Here";
    String actualYazi = dropHereButton.getText();

    Assertions.assertEquals(dropHereYazi,actualYazi);

    ReusableMethods.bekle(2);


}
}
