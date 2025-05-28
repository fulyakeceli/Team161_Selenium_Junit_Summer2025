package tests.day15_cookies_webTables;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class C01_Cookies extends TestBase_Each {



    @Test
    public void test01(){

        //1- google anasayfaya gidin
        driver.get("https://www.google.com");

        ReusableMethods.bekle(1);



        //2- cookies cikarsa kabul edin
        //utilities Testbase eachthen driver.quit()'i kapatmamiz lazım once
        //yoksa uyarı alamayız
        // locate alalım

        driver.findElement(By.xpath("//div[.='Accept all']")).click();


        //3- Sayfadaki cookies sayisinin 3 veya daha fazla oldugunu test edin

        Set<Cookie> cookieSet = driver.manage().getCookies();

        int expectedMinCookieSayisi = 3;
        int actualCookieSayisi = cookieSet.size();

        Assertions.assertTrue(actualCookieSayisi>= expectedMinCookieSayisi);



        //4- sayfadaki cookie'leri yazdirin
        System.out.println(cookieSet);

        // cookieleri daha duzenli sekilde yazdirmak icin for each loop kullanmaliyiz

        int siraNo = 1;
        for(Cookie eachCookie : cookieSet){

            System.out.println(siraNo + ". cookie: \n" + eachCookie);
            siraNo++;

            /*
            1. cookie:
            NID=524=ZLMlaOB7iJ0GG3Twhd13chFUehAQuzRdy-Qj6-YuW6PAMm2Bgf2CLZgJgJgruIHmjnWSxi6mvRWaKTrieu4Na1a-f-GVJV4_5-8cdK32eD8MYNlLi_hPna1V6Tl99ldNkHQFx_VttbbiMM5_cgDw-KiLMyKPqiDHn5kRW3c8nDu6rt538Cqzi-Q3WO9UcApnjdwiJm4hvOpsXoOzPHvrVVHN4T6HxzL3WFbTaw46F2MfVy-V1upd2PjA5dd4gxwm17dzpuj2dpI0PlQ; expires=Sun, 23 Nov 2025 18:00:00 GMT; path=/; domain=.google.com;secure;; sameSite=None
            2. cookie:
            SOCS=CAISHAgBEhJnd3NfMjAyNTA1MjItMF9SQzEaAmVuIAEaBgiAmMTBBg; expires=Tue, 23 Jun 2026 18:00:00 GMT; path=/; domain=.google.com;secure;; sameSite=Lax
            3. cookie:
            EUULE=a+cm9sZTogMQpwcm9kdWNlcjogMTIKdGltZXN0YW1wOiAxNzQ4MTA5NTk5MTU1MDAwCmxhdGxuZyB7CiAgbGF0aXR1ZGVfZTc6IDUxNDc3NTI2NwogIGxvbmdpdHVkZV9lNzogNjE4NDAxMTUKfQpyYWRpdXM6IDIxNzAwCnByb3ZlbmFuY2U6IDEyCg==; expires=Sat, 24 May 2025 18:09:59 GMT; path=/; domain=www.google.com;secure;; sameSite=Lax
            4. cookie:
            AEC=AVh_V2ix7byAspopZMhhcf5ODXS46SoEUS1nHUIExmBeROFLEYXSD5UN_Vc; expires=Thu, 20 Nov 2025 17:59:58 GMT; path=/; domain=.google.com;secure;; sameSite=Lax


             */
        }

        //5- cookie'lerin isimlerini yazdirin

         siraNo = 1;
        for(Cookie eachCookie : cookieSet){

            System.out.println(siraNo + ". cookie: \n" + eachCookie.getName());
            siraNo++;

            /*
            1. cookie ismi : NID
//          2. cookie ismi : SOCS
//          3. cookie ismi : EUULE
//          4. cookie ismi : AEC

             */





        //6- ismi “en sevdigim cookie” ve degeri “cikolatali” olan bir cookie olusturun ve sayfaya ekleyin
            Cookie cookieObjesi = new Cookie("en sevdigim cookie", "cikolatali");
            driver.manage().addCookie(cookieObjesi);


        //7- eklediginiz cookie’nin sayfaya eklendigini test edin
        //   alternatif yontemler

        //   A- tum cookieleri kaydedip, cookie isimlerini olusturacagim bir listeye atip,
        //      liste "en sevdigim cookie" iceriyor mu diye test edebilirim
        //   B- "en sevdigim cookie" 'nin value'sunun "cikolatali" oldugunu test edebilirim

        // B-yontemi (NullPointerException riski var)
          Cookie actualCookie =  driver.manage().getCookieNamed("en sevdigim cookie");
          String expectedCookieValue = "cikolatali";
          String actualCookieValue = actualCookie.getValue();

          Assertions.assertEquals(expectedCookieValue,actualCookieValue);

        // A yontemi

            cookieSet = driver.manage().getCookies();

        // tum cookie'lerin isimlerini olusturacagimiz bir listeye ekleyelim

            List<String> cookieIsimleriList = new ArrayList<>();

            for (Cookie eachCookie1 : cookieSet){
                cookieIsimleriList.add(eachCookie1.getName());

            }

            //listede en sevdigim cookie bulundugunu test edelim

               Assertions.assertTrue(cookieIsimleriList.contains("en sevdigim cookie"));

            //8- ismi SOCS olan cookie’yi silin ve silindigini test edin

            driver.manage().deleteCookieNamed("SOCKS");

            //silindigini test edlim
            cookieSet = driver.manage().getCookies(); // tum cookie isimlerini aldım

            cookieIsimleriList = new ArrayList<>(); // hepsini listeye ekledim

            for ( Cookie eachCookie2 : cookieSet){
                cookieIsimleriList.add(eachCookie2.getName());
            }

            Assertions.assertFalse(cookieIsimleriList.contains("SOCKS"));


             //9- tum cookie’leri silin

            driver.manage().deleteAllCookies();

            // silindigini test edin
            cookieSet = driver.manage().getCookies();

            Assertions.assertTrue(cookieSet.isEmpty());







    }




}
