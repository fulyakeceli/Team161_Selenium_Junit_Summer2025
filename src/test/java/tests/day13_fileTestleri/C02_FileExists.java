package tests.day13_fileTestleri;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C02_FileExists {

    @Test
    public void test01(){

     // day 13 package'i altında notlar.txt bulundugunu test edin

        // dosya yolunu bulmak icin => notlar.tx'ye sag tik yapip
        // copy path reference seciyoruz

     String dosyaYolu = "src/test/java/tests/day13_fileTestleri/notlar.txt" ;

        Assertions.assertTrue(Files.exists(Paths.get(dosyaYolu))); // direkt dosyaYolunu yazamayız

        // not: extends olmadan da bu calisir cunku web'de bir yere gitmedik

        // masaustunde selenium txt dosyasının var oldugunu test edin

        dosyaYolu = "C:\\Users\\fatih\\OneDrive\\Masaüstü\\selenium.txt";

        Assertions.assertTrue(Files.exists(Paths.get(dosyaYolu)));





    }











}
