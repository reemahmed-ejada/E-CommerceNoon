package TestCases;

import base.BasePage;
import org.testng.Assert;
import org.testng.annotations.*;

public class addProductstoCart extends BasePage {

    @BeforeTest
    public void initTest(){
     // setUp();
    }

    @Test (groups = {"Sanity"})
public void test1(){
        System.out.println("inside test 1 ");
    }



    @Test(groups = {"Regression"})
    public void test2(){
        System.out.println("inside test 2 ");
    }


    @Test(groups = {"Regression" , "Sanity"})
    public void test3(){
        System.out.println("inside test 3 ");
    }


    @Test(dependsOnMethods = "test3")
    public void test4(){
        Assert.assertEquals(0,1);
        System.out.println("inside test 4 ");
    }

    @Ignore
    @Test()
    public void test5(){
        System.out.println("inside test 5  ");
    }

    @Test(groups = {"retry"},retryAnalyzer = listeners.PageListener.class)
    public void test6(){
        Assert.assertEquals(0,1);
        System.out.println("inside test 6  ");
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}
