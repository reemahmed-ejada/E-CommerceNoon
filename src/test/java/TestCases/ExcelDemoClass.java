package TestCases;

import utils.ExcelUtils;

public class ExcelDemoClass {

  public static ExcelUtils excelinstance;
    public static void main(String[] args){
         excelinstance = new ExcelUtils("src/test/java/resources/TestData.xlsx","testData");
        // excelinstance.RowCounts();

    }
}
