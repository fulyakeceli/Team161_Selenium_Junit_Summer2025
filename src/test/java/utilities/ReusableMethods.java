package utilities;

import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static jdk.internal.org.jline.reader.impl.LineReaderImpl.CompletionType.List;

public class ReusableMethods {

    public static void bekle (int saniye) {

        try {
            Thread.sleep(saniye * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

       // verilen WebElementşelerden olusan bir listedeki herbir webelementi ele alip
       // webelement uzerindeki yazıyı olusturacagımız bir listeye ekleyip
       // tum elementler elden gectikten sonra stringlerden olusan
        // listeyi donduren bir method olusturun

    public static List<String> stringListeDonustur (List<WebElement> webElementList){

        List<String> stringList = new ArrayList<>();

        for (WebElement eachElement:webElementList){
            stringList.add(eachElement.getText());

        }

        return stringList;


        }







    }



}
