package tests.day09_jsAlerts_basicAuthentication;

import org.junit.jupiter.api.Test;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

public class C03_BasicAuthentication extends TestBase_Each {

    @Test
    public void basicAuthenticationTesti() {
        //1- Bir class olusturun : BasicAuthentication


        //2- https://testotomasyonu.com/basicauth sayfasina gidin
       // driver.get("https://testotomasyonu.com/basicauth");
        // normal yontemlerle gidersek kullanici adi ve sifre ister giris yapamam

        //3- asagidaki yontem ve test datalarini kullanarak authentication’i yapin

        //Html komutu : https://username:password@URL
        //	Username     : membername
        // 	password      : sunflower


        driver.get("https://membername:sunflower@testotomasyonu.com/basicauth");


        //4- Basarili sekilde sayfaya girildigini dogrulayin

        ReusableMethods.bekle(5);

    }
}