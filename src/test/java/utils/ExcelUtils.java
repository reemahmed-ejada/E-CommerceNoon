package utils;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;

public class ExcelUtils {

    public static XSSFWorkbook newWorkBook;
    public static  XSSFSheet sheet;

    public static void main (String[] args){
       //RowCounts();

    }
//create constructor to input the path and sheetname
   public ExcelUtils( String path , String sheetName){
       try {
           newWorkBook= new XSSFWorkbook(path);
       } catch (IOException e) {
           throw new RuntimeException(e);
       }
       sheet= newWorkBook.getSheet(sheetName);
    }
    public int getRowCounts(){

            int rowCount =sheet.getPhysicalNumberOfRows();
            System.out.println("number of row is excel file is "+rowCount);
            return rowCount;
    }

    public int getColumnsCounts(){

        int columnCount =sheet.getRow(0).getPhysicalNumberOfCells();
        System.out.println("number of columns is excel file is "+columnCount);
        return columnCount;
    }

    public int getCellDatanumber(int row,int column){

        int cell = (int) sheet.getRow(row).getCell(column).getNumericCellValue();
        return cell;
    }

    public String getCellData(int row,int column){

        String cell = sheet.getRow(row).getCell(column).getStringCellValue();
        return cell;
    }
    public Object[][] dataReader( ){
        //ExcelUtils excel =new ExcelUtils(path,sheetname);
        int Rows=getRowCounts();
        int col=getColumnsCounts();
        Object [][] testDataArray= new Object[Rows][col];
        for (int i=1;i<Rows;i++){
            for (int j=0 ; j<col;j++){
                //String cell= getCellData(i,j);
               // Sheet sheet = workbook.getSheet(sheetName);
                Row row = sheet.getRow(i);
                Cell cell = row.getCell(j);

                Object cellValue;

                if (cell == null) {
                    cellValue = "";
                } else {
                    switch (cell.getCellType()) {
                        case STRING:
                            cellValue = cell.getStringCellValue();
                            break;

                        case NUMERIC:
                            if (DateUtil.isCellDateFormatted(cell)) {
                                cellValue = cell.getDateCellValue();
                            } else {
                                int value =(int) cell.getNumericCellValue();
                                if (value == Math.floor(value)) {
                                    cellValue = (int) value; // treat as integer if no decimal
                                } else {
                                    cellValue = value;
                                }
                                cellValue=value;
                            }
                            break;

                        case BOOLEAN:
                            cellValue = cell.getBooleanCellValue();
                            break;

                        case FORMULA:
                            cellValue = cell.getCellFormula();
                            break;

                        case BLANK:
                            cellValue = "";
                            break;

                        default:
                            cellValue = cell.toString();
                    }
                }

                testDataArray[i-1][j]=cellValue;
            }
        }
        return testDataArray;
    }

}
