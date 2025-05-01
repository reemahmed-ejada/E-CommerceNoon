package utils;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ExcelDataProvider {
public ExcelUtils excel;
 @BeforeTest
 public void setUP(){
      excel = new ExcelUtils("src/test/java/resources/TestData.xlsx","testData");
 }

    @DataProvider(name="test1")
    public Object[][] dataReaderfortest( ){
        Object[][] testdata1= excel.dataReader();
        return testdata1;
    }
@Test(dataProvider = "test1")
public void testExcel( String username,int password,String assertion){
// the inputs to testmethod should be equal to the colulmns in excel data provider and with same data types
    System.out.println("username is "+username +"password is"+password );
}





}
