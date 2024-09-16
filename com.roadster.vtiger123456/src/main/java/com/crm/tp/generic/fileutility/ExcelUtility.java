package com.crm.tp.generic.fileutility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	public String getTestDataFromExcel(String sheetname,int rowNum, int celNum) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("./TestData/TestSpecificData.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		String data=wb.getSheet(sheetname).getRow(rowNum).getCell(celNum).getStringCellValue();
		wb.close();
		return data;
	}
      public int getRowCount(String sheetname) throws EncryptedDocumentException, IOException {
    	  FileInputStream fis = new FileInputStream("./TestData/TestSpecificData.xlsx");
  		  Workbook wb=WorkbookFactory.create(fis);
  		 int rowCount = wb.getSheet(sheetname).getLastRowNum();
  		 wb.close();
    	  return rowCount;
      }
      public void setDataIntoExcel(String sheetname,int rowNum, int celNum,String data) throws EncryptedDocumentException, IOException {
    	  FileInputStream fis = new FileInputStream("./TestData/TestSpecificData.xlsx");
  		  Workbook wb=WorkbookFactory.create(fis);
  		  wb.getSheet(sheetname).getRow(rowNum).getCell(celNum);
  		  FileOutputStream fos = new FileOutputStream("./TestData/TestSpecificData.xlsx");
  		  wb.write(fos);
  		  wb.close();

      }
}
