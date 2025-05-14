package tests.day06_jUnitFramework;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class C01_TestNotasyonu {

    /*
    Bir classin run edilebilir olmasi icin bugune kadar mutlaka
    main method olmali demistik

    Gercekten de main method olmadan
    methodlarin yaninda run tusu cikmaz

    JUnit frameworku ile gelen en buyuk promosyon
    @Test notasyonudur (annotaion)

    @Test notasyonu sayesinde herbir method bagimsiz
    olarak calistirilabilir hale gelir

     */

    @Test

    public void test04(){
        System.out.println("test4 calisti");

    }

    @Test // @Disabled
    public void test02(){
        System.out.println("test2 calisti");


    }
    @Test
    public void test03(){
        System.out.println("test3 calisti");


    }
}
