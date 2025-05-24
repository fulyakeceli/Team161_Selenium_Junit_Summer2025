package tests.day13_fileTestleri;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C04_DinamikDosyaYoluKullanma {

    @Test
    public void test01(){

        // day13 package'inda notlar.txt dosyasinin oldugunu test edin
        String dosyaYolu = "src/test/java/tests/day13_fileTestleri/notlar.txt";

        Assertions.assertTrue(Files.exists(Paths.get(dosyaYolu)));

        // dosya yolunu dinamik yapalim

        //   /Users/ahmetbulutluoz/Desktop/My Desktop/course/projeler/Team161_JUnit
        //   /src/test/java/tests/day13_fileTestleri/notlar.txt

        //NOT: eger bilgisayar turkce ise Desktop yerine Masaüstü yazmamız gerekir yoksa hata verir


        // Eger proje altindaki bir dosyaya ulasmak isterseniz
        // Java bilgisayardaki projemizin dosya yolunu bize dinamik olarak verir

        System.out.println(System.getProperty("user.dir"));
        // /Users/ahmetbulutluoz/Desktop/My Desktop/course/projeler/Team161_JUnit


        String dinamikDosyaYolu = System.getProperty("user.dir") // projeye kadar olan kısmı verir
                + "/src/test/java/tests/day13_fileTestleri/notlar.txt"; // projeden sonrasını notlar txtde path from content root ile alabiliriz.

        Assertions.assertTrue(Files.exists(Paths.get(dinamikDosyaYolu)));

        // package ve class isimleri ayni olmak sartiyla calisir.
    }
}