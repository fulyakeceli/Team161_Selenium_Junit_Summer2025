package utilities;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TestBase_All {

   protected static WebDriver driver;
   /*
   BeforeAll'un BeforeEachten farkı static olmasıydı
   bu nedenle driver'i da static yaptik
   Baska classlardan kullanabilmek icin ise => protected yapiyoruz
    */

    @BeforeAll
    public static void srtUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


    }

    @AfterAll
    public static void teardown(){
        driver.quit();
    }
}
