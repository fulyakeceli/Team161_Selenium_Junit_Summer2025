package tests.day17_excelAutomation_getScreenshot;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C01_ExceldeKullanilmayanSatirlar {


    @Test public void test() throws IOException {

        // ulkeler excel'inde Sayfa2'ye gidin
        File file = new File("src/test/resources/ulkeler.xlsx");
        FileInputStream fileInputStream = new FileInputStream(file);

        // excel gibi kullanabilecegimiz bir objeye ihtiyacımız var
        Workbook workbook = WorkbookFactory.create(fileInputStream);
        Sheet sayfa2 = workbook.getSheet("Sayfa2");
        // bilgiler workbooka yuklendi


        // kullanilan en son satirin 20.satir oldugunu test edin

        int expectedSonSatirIndexi = 19;
        int actualSonSatirIndexi = sayfa2.getLastRowNum();

        Assertions.assertEquals(expectedSonSatirIndexi,actualSonSatirIndexi);


      // reel olarak data yazilan satir sayisinin 8 oldugunu test edin

        // fiziki kullanilan satir sayisi istiyor yani
        int expectedKullanilanSatirSayisi = 8;
        int actualKullanilanSatirSayisi = sayfa2.getPhysicalNumberOfRows();

        Assertions.assertEquals(expectedKullanilanSatirSayisi,actualKullanilanSatirSayisi);

     // 4.satir, 1.sutun'daki sayinin 3 oldugunu test edin
        // kullanilan bir hucre (icinde data var)
        double expectedDeger = 3;
        double actualDeger = sayfa2.getRow(3).getCell(0).getNumericCellValue();

        Assertions.assertEquals(expectedDeger,actualDeger);

        // 4.satir, 2.sutun'daki datayi yazdirin
        // kullanilan satirdaki kullanilmayan hucre (kullanilan satirdaki bos hucre)

        System.out.println(sayfa2.getRow(3).getCell(1)); // null

     // 5.satir, 3.sutun'daki datayi yazdirin
        //kullanilmayan satirdaki kullanilmayan hucre

        System.out.println(sayfa2.getRow(4).getCell(2)); //NullPointerException


    }
}
