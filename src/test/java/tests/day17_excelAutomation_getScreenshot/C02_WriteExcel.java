package tests.day17_excelAutomation_getScreenshot;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class C02_WriteExcel {

    @Test
    public void test01() throws IOException {



        // 1) Yeni bir Class olusturalim WriteExcel
        // 2) Yeni bir test method olusturalim writeExcelTest()
        //3) Adimlari takip ederek Sayfa1’e kadar gidelim

        String dosyaYolu = "src/test/java/tests/day16_webtables_excelOtomasyon/ulkeler.xlsx";
        FileInputStream fileInputStream = new FileInputStream(dosyaYolu);

        Workbook workbook = WorkbookFactory.create(fileInputStream);
        Sheet sayfa1 = workbook.getSheet("Sayfa1");


    //4) 1. satir 5.hucreye yeni bir cell olusturalim
        // 1. satir var 5. hucre yok olusturalim
        sayfa1.getRow(0).createCell(4);


    //5) Olusturdugumuz hucreye “Nufus” yazdiralim
        // 5. hucreye gittim deger atadim
        sayfa1.getRow(0).getCell(4).setCellValue("Nufus");


    //6) 2.satir nufus kolonuna 1500000 yazdiralim
        sayfa1.getRow(1).createCell(4).setCellValue(1500000);


    //7) 10.satir nufus kolonuna 250000 yazdiralim
        sayfa1.getRow(9).getCell(4).setCellValue(250000);


    //8) 15.satir nufus kolonuna 54000 yazdiralim
        sayfa1.getRow(14).getCell(4).setCellValue(54000);

        //NOT:
        // run'a basmıyoruz
        // biz bu atamalari intelliJde yaptik
        // exceldeki degisiklikler asagida yaninda cizgi olan sey
        // kapatirsak degisiklik yok olur kaydetmemiz lazim
        // ilk yapmamiz gereken sey excel kopyasini ortadan kaldirmak icin
        // ana excel dosyasini bilgisayarimizda kapatiriz
        // yoksa cakisma olabilir diye excel dosyamizi bozar ve dosya acilamaz hale gelir

        // fiziki exceldeki bilgileri dosyaYolu ve fileInputStream ile aldik
        // yaptigimiz degisiklikleri yollamak icin de dosyaYolu ve fileOutputStream kullaniriz.



        // ek gorev 191. ulke olarak JavaLand ekleyin
        // baskenti Malatya olsun

        int yeniSatirIndexi = sayfa1.getLastRowNum()+1;

         sayfa1.createRow(yeniSatirIndexi);

         // yeni satirda ulke ismi yazacagimiz hucreyi olusturalim
        sayfa1.getRow(yeniSatirIndexi).createCell(0).setCellValue("Javaland");
        sayfa1.getRow(yeniSatirIndexi).createCell(1).setCellValue("Malatya");



    //9) Dosyayi kaydedelim
        FileOutputStream fileOutputStream = new FileOutputStream(dosyaYolu);
        workbook.write(fileOutputStream);


    //10)Dosyayi kapatalim
        fileInputStream.close();
        fileOutputStream.close();
        workbook.close();



}
}
