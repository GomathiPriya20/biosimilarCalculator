package utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import driver.Driver;

public class DataInputProvider extends Driver {

       private static XSSFSheet ExcelWSheet;
       private static XSSFWorkbook ExcelWBook;
       private static XSSFCell Cell;
       private static XSSFRow Row;
       public static int iTestCaseRowNum;
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 //This method is to set the File path and to open the Excel file, Pass Excel Path and Sheetname as Arguments to this method
 public static void setExcelFile(String Path,String SheetName) throws Exception
 {
	  try
	  {
	   // Open the Excel file
	   FileInputStream ExcelFile = new FileInputStream(Path);
	   // Access the required test data sheet
	   ExcelWBook = new XSSFWorkbook(ExcelFile);
	   ExcelWSheet = ExcelWBook.getSheet(SheetName);
	   
	   } 
	  catch (Exception e)
	  {
	       throw (e);
	   }
   }
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//This method is to read the test data from the Excel cell, in this we are passing parameters as Row num and Col num
public static String getCellData(int RowNum, int ColNum) throws Exception{
	try
	{
		Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
		String CellData = Cell.getStringCellValue();
		return CellData;
	}
	catch (Exception e)
	{
	    return"";
	}
}

//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
public static int getRowNum(String sDataSheetName, String sTestCaseName) throws Exception
{
	ExcelWSheet = ExcelWBook.getSheet(sDataSheetName);
	//Get total number of rows in the excel
	int lastRowNum=ExcelWSheet.getLastRowNum();
	
	//Read all the row values and compare if it matches with TESTCASE NAME
	for(int i=1;i<lastRowNum+1;i++)
	{	
		String sActualTestCaseName = ExcelWSheet.getRow(i).getCell(1).toString();
		if (sActualTestCaseName.equalsIgnoreCase(sTestCaseName))
		{
			iTestCaseRowNum=i;
			break;
		}
	}
	return iTestCaseRowNum;
}
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
public static String getCellData_ColName(int iRowNum, String sColName, String sDataSheetName) throws Exception
{
	try
	{
		int iColNum=0;
		
		ExcelWSheet = ExcelWBook.getSheet(sDataSheetName);
		Row=ExcelWSheet.getRow(0);
		int lastCellNum = Row.getLastCellNum();
		for(int j=0;j<lastCellNum;j++)
		{
			if (Row.getCell(j).getStringCellValue().trim().equalsIgnoreCase(sColName.trim()))
			{
				iColNum=j;
			}
		}
		
		XSSFCell Cell = ExcelWSheet.getRow(iRowNum).getCell(iColNum);
		String cellValue=Cell.toString();
		return cellValue;
	}
	catch (Exception e)
	{
		e.printStackTrace();
		return null;
	}	
} 

//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 //This method is to write in the Excel cell, Row number and Column name are the parameters
public static void setCellData(String Result,  int RowNum, String sColName,String sSheetName) throws Exception    {
	try
	{
		int iColNum=0;
		//ExcelWSheet = ExcelWBook.getSheet(Driver.properties.getProperty("DriverSheetName"));
		ExcelWSheet = ExcelWBook.getSheet(sSheetName);
		
		Row=ExcelWSheet.getRow(0);
		int lastCellNum = Row.getLastCellNum();
		for(int j=0;j<lastCellNum;j++)
		{
			if (Row.getCell(j).getStringCellValue().trim().equalsIgnoreCase(sColName.trim()))
			{
				iColNum=j;
			}
		}
	     Row  = ExcelWSheet.getRow(RowNum);
	     Cell = Row.getCell(iColNum);
	     if (Cell == null)
	     {
	    	 Cell = Row.createCell(iColNum);
	    	 Cell.setCellValue(Result);
	     } 
	     else
	     {
	    	 Cell.setCellValue(Result);
	     }

		// Constant variables Test Data path and Test Data file name
		 FileOutputStream fileOut = new FileOutputStream(System.getProperty("user.dir")+"/data/"+Driver.properties.getProperty("DataFile"));
		 ExcelWBook.write(fileOut);
         fileOut.flush();
         fileOut.close();
	}
	catch(Exception e)
	{
       throw (e);
	}
}
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
public static int getRowCount(String sheetName) throws Exception
{
	try
	{
		ExcelWSheet = ExcelWBook.getSheet(sheetName);
		int rowCount = ExcelWSheet.getLastRowNum();
		//Log.info("Total number of Row used return as &lt; " + RowCount + " &gt;."); 
		return rowCount;
	}
	catch (Exception e)
	{
		System.out.println(e.getMessage());
		throw (e);
	}
}

}

