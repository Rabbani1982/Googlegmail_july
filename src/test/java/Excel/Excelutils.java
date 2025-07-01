package Excel;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excelutils 
{
	
	public static FileInputStream fi;  // creating a variables only once we can access 
	public static FileOutputStream fo; // using class name or directly in static methods
	public static XSSFWorkbook wb;
	public static XSSFSheet ws;
	public static XSSFRow row;
	public static XSSFCell cell;
	public static CellStyle style; // CellStyle is  class for format cells (Assign colours)
	
	public static int getRowCount(String xlfile, String xlsheet) throws IOException  
	{
		fi=new FileInputStream(xlfile);  // open file in reading mode
		wb=new XSSFWorkbook(fi);         //get workbook
		ws=wb.getSheet(xlsheet);         // get the sheet
      int rowcount=  ws.getLastRowNum(); // finding the last row number
      wb.close(); // closing the workbook
      fi.close(); // close the file
	  return rowcount; // return the row count
	}
	
	// This method is return the row count
	//xlfile : File pathe we need to pass
	 // xlsheet  : sheet name we need to pass
	
	// while call  getRowCount method by passing the parameters it will return the row count 
	
	public static int getCellCount(String xlfile, String xlsheet,int rownum) throws IOException  
	{
		fi=new FileInputStream(xlfile);
		wb=new XSSFWorkbook(fi);
		ws=wb.getSheet(xlsheet);
       row=  ws.getRow(rownum);   // pass the rownum 
       int cellcount=row.getLastCellNum(); // find the cell count based on rowrum
       wb.close();
      fi.close();
	  return cellcount;  //return the cell count
	}
	
	//int rownum : on which row we want to find number of 
   //call this method getCellCount by passing the parameters to get cellcount
	
	public static String getCellData(String xlfile, String xlsheet,int rownum,int colnum) throws IOException
	{
		fi=new FileInputStream(xlfile); // pass 4 parameters
	    wb=new XSSFWorkbook(fi);
	    ws=wb.getSheet(xlsheet);
	    row=  ws.getRow(rownum);
	    cell =row.getCell(colnum);
	   //getCellData : read data from particulat cell/column  
	    String data;
		try 
		{  
			//data.toString();	 // using this method read the data from particular cell		
			DataFormatter formatter=new DataFormatter(); // Apache POI provided this to read data
			data=formatter.formatCellValue(cell);//Returns the formatted value of a cell as a String			
		}                                     //regardless of the cell type
		
		catch (Exception e)
		{
			data=" ";
		}
		
		wb.close();
		fi.close();
		return data;
	}
	
public static void setCellData(String xlfile, String xlsheet,int rownum,int colnum,String data) throws IOException
	{
		fi=new FileInputStream(xlfile);
	    wb=new XSSFWorkbook(fi);
	    ws=wb.getSheet(xlsheet);
	    row=ws.getRow(rownum);
	    
	    							// reading the data from same sheet
	    cell=row.createCell(colnum);
	    cell.setCellValue(data);
	    fo=new FileOutputStream(xlfile);
	    wb.write(fo);
	    wb.close();
		fi.close();
		fo.close();	    
					//writing the data into the same sheet
	}
	// setCellData : writing the data into the cell
	public static void fillGreenColour(String xlfile, String xlsheet,int rownum,int colnum) throws IOException
	{
		fi=new FileInputStream(xlfile);
	    wb=new XSSFWorkbook(fi);
	    ws=wb.getSheet(xlsheet);
	    row=ws.getRow(rownum);
	    cell =row.getCell(colnum);
	    
	         style  =wb.createCellStyle();
	         style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
	         style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
	         
	         cell.setCellStyle(style);
	         fo=new FileOutputStream(xlfile);
		     wb.write(fo);
		     wb.close();
		     fi.close();
		     fo.close();
	}
	
	public static void fillRedColour(String xlfile, String xlsheet,int rownum,int colnum) throws IOException
	{
		fi=new FileInputStream(xlfile);
	    wb=new XSSFWorkbook(fi);
	    ws=wb.getSheet(xlsheet);
	    row=ws.getRow(rownum);
	    cell =row.getCell(colnum);
	    
	         style  =wb.createCellStyle();
	         style.setFillForegroundColor(IndexedColors.RED.getIndex());
	         style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
	         
	         cell.setCellStyle(style);
	         fo=new FileOutputStream(xlfile);
		     wb.write(fo);
		     wb.close();
		     fi.close();
		     fo.close();
	}	

	
	
	

}
