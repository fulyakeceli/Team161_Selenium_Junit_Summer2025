package tests.day16_webtables_excelOtomasyon;

import org.apache.poi.ss.usermodel.*;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class C02_ReadExcel_ExceldenDataAlma {



    @Test
    public void test01() throws IOException {

        // ulkeler excel'indeki
        // sayfa1'in 1.satir 1.sutunundaki datayi yazdirin

        // excel ozel bir yapi oldugundan, sorudan da anlasilacagi uzere adim adim ilerlemeliyiz

        // 1.adim : excel dosyasina (Java ile) ulasalim

        String dosyaYolu = "src/test/java/tests/day16_webtables_excelOtomasyon/ulkeler.xlsx";
        FileInputStream fileInputStream = new FileInputStream(dosyaYolu);


        //2. adim: excel dosyasindaki sayfa1e ulasalim
        // excel ozel bir yapi oldugundan sadece dosyaya ulasmak yetmez
        // sayfadaki datalari excel gibi tutacak bir objeye ihtiyacimiz var
        Workbook workbook = WorkbookFactory.create(fileInputStream);

        // workbook objesi bu classta bizim olusturdugumuz bir obje
        // yani biz aslinda bu classta islem yaparken
        // canli olarak excel ile bilgi alisverisi yapmiyoruz
        // 23. satirda olusturdugumuz fileInputStream ile 1 defalik tum bilgileri alip
        //31. satirda bizim olusturdugumuz workbook objesine bu datalari yukluyoruz
        // 31. satirdan itibaren excel ile degil workbook objesi ile calisayacagiz (datalari alip kopya olustururuz)


        //3. adim sayfa1deki 1. satira ulasalim
       Sheet sayfa1 = workbook.getSheet("Sayfa1");

       Row satir1 = sayfa1.getRow(0);
       // satirNo index kullanir, yani 0dan baslar
        // 1. satira ulasmak istiyorsak index 0 yazmaliyiz

        // 4. adim 1. satirdaki 1. datayi yazdiralim
        // data index kullanir yani 0dan baslar
        // satirdaki 1.dataya ulasmak istiyorsak index olarak 0 yazmaliyiz

        Cell ilkData = satir1.getCell(0); //

        System.out.println(ilkData); // Ulke / Ingilizce

        //2. satirdaki 3. datayi yazdirin
        // Her seferinde sayfa objesi(sheet), satirNo(Row) objesi, hucre(Cell) objesi olusturmak zorunda degiliz
        // workbook objesinden baslayarak hedef hucreye kadar adim adim ilerleyebiliriz

        System.out.println(workbook.getSheet("Sayfa1").getRow(1).getCell(2)); // Afganistan












    }
}
