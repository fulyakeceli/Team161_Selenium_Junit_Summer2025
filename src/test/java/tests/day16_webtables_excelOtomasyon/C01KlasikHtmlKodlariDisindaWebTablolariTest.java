package tests.day16_webtables_excelOtomasyon;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

import java.util.List;

public class C01KlasikHtmlKodlariDisindaWebTablolariTest extends TestBase_Each {

    @Test
    public void test01(){

        //                  //*[@role='trow'][3]/*[@role='tdata'][2]


        //  1. “https://testotomasyonu.com/webtables2” sayfasina gidin


        driver.get("https://testotomasyonu.com/webtables2");

        //  2. Headers da bulunan basliklari bir liste olarak yazdirin

        List<WebElement> baslikDataElementleriList = driver.findElements(By.xpath("//*[@role='hrow']/*[@role='hdata']"))

         // sadece role = 'hrow' yapsaydik tum baslik satirini tek bir element olarak getirir
        // ve yazdirirsak boyle yazdirir ve hangisi hangisi bilemem Product Name mi ? Name category mi?
        // Product Name Category   Price Actions

        List<String> baslikDataList = ReusableMethods.stringListeDonustur(baslikDataElementleriList);
        System.out.println(baslikDataList);
        // [Product Name, Category, Price, Actions] burada net bir skeilde anlayabiliriz


        //  3. 3.sutunun basligini yazdirin
        System.out.println(baslikDataList.get(2));


        //  4. Tablodaki tum datalari yazdirin
        // 1.yontem tum table'i tek bir webelement olarak locate edip yazdiralim

        WebElement tumTabloElementi = driver.findElement(By.xpath("//*[@class='table']"));
        System.out.println("Tum tablo :" + tumTabloElementi.getText());

        //2. yontem tablo bodysindeki datalarin role attribute'unu kullanarak bir liste seklinde tum datalari alalim
        List<WebElement> dataElementleriList = driver.findElements(By.xpath("//*[@role='tdata']"));
        List<String> dataList = ReusableMethods.stringListeDonustur(dataElementleriList);

        System.out.println("liste olarak datalar : \n" + dataList);


        //  5. Tabloda kac tane cell (data) oldugunu yazdirin
        System.out.println("Tablodaki hucre sayisi :" + dataList.size());

        //6. Tablodaki satir sayisini yazdirin
        List<WebElement> satirElementleriList = driver.findElements(By.xpath("//*[@role='trow']"));
        System.out.println("satir sayisi :" + satirElementleriList.size()); //5
        // satirlari demedigi icin string'e cevirmemize gerek yok

        // 7. tablodaki sutun sayisini yazdirin
        // web tablolarinda sutun  yok
        // bunun yerine herhangş bir satirdaki data sayisini bulabiliriz.

        //ilk gorevde basliktaki datalari list olarak kaydetmistik onu kullanalim
        System.out.println("sutun sayisi:" + baslikDataList.size()); //4

        //8. tablodaki 3. kolonu yazdirin
        // web tablosunda sutun yoktur
        // her satirdaki 3. datayi yazdirmaliyiz

        List<WebElement> ucuncuSutunElementleriList = driver.findElements(By.xpath("//*[@role='trow'][*]/*[@role='tdata'][3]"));

        List<String> ucuncuSutunDatalariList = ReusableMethods.stringListeDonustur(ucuncuSutunElementleriList);

        System.out.println("3.Sutun : " + ucuncuSutunDatalariList);
        // 3.Sutun : [$399.00, $399.00, $399.00, $40.00, $15.00]

        // 9. bir method olusturun , Test method'undan satir ve sutun verildiginde datayi dondursun
        System.out.println(getCellData(1,2));
        System.out.println(getCellData(4,1));
        System.out.println(getCellData(3,3));


        //10. Tabloda " Category" si Furniture olan urunun fiyatini yazdirin
        //        //     tum satirlari elden gecirip
        //        //     satirdaki category ( 2.data) Furniture ise
        //        //     satirdaki fiyati (3.data) yazdirmaliyiz

        int satirSayisi = satirElementleriList.size();

        for (int i = 1;  i< satirSayisi ; i++) {

            String satirdakiCategoryElementi = getCellData(i,2);
            String satirdakiFiyat = getCellData(i,3);

            if (satirdakiCategoryElementi.equalsIgnoreCase("Furniture"));
            System.out.println(satirdakiFiyat);

        }

    }

    public String getCellData (int satirNo, int sutunNo){

        // //*[@role='trow'][3]/*[@role='tdata'][2]

        String dinamikXpath = "//*[@role='trow'][" + satirNo + "]/*[@role='tdata'][" + sutunNo +"]";

        WebElement hedefCellElementi = driver.findElement(By.xpath(dinamikXpath));

        return hedefCellElementi.getText();


    }
}
