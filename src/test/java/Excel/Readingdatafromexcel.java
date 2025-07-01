package Excel;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

//Excelfile ---->Workbook --->Worksheet --- contains ----Rows ---- contains --->cells--data 

public class Readingdatafromexcel {

	public static void main(String[] args) throws IOException
	
	{    //to open the excel file in reading mode - Fileinput stream class
		//FileInputStream - representing excel file - create file inputstream class object
		//15 line -excelfile open in the reading mode
		// System.getProperty("user.dir") - current project location and goto testdata
		//System.getProperty("user.dir")+"testdata\\Testdata.xlsx represent file 
		//path:D:\AUTOMATION\com.google.gmail\testdata\Testdata.xlsx
FileInputStream  file = new FileInputStream(System.getProperty("user.dir")+"\\testdata\\Testdata.xlsx");
	    
XSSFWorkbook workbook=new XSSFWorkbook (file); //open the workbook from excelfile
	  
	  XSSFSheet sheet=workbook.getSheet("sheet1"); // get the sheet form workbook
	  
	  // XSSFSheet sheet=workbook.getSheetAt(0);   //another method to get sheet form workbook
	  
	         int totalrows =sheet.getLastRowNum(); //to get the number of rows
	                         
	             int totalcells = sheet.getRow(1).getLastCellNum(); //to get the number of cells 
	             
	             System.out.println("number of rows"+totalrows);
	             System.out.println("number of columns"+totalcells);
	              
	            for(int r=0;r<totalrows;r++)     
	             {
	            	 XSSFRow currentrow = sheet.getRow(r);// get the entire row,  extract particular row
	            	 
	            	 for(int c=0;c<totalcells;c++) 
	            	 {                             
	            		 XSSFCell cell =currentrow.getCell(c);    //
	            		 System.out.print(cell.toString()+"\t");
	            	 }
	            	 
	            	 System.out.println();
	             }  
	  
	  
	
	
	}

}
