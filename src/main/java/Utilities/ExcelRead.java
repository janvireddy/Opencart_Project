package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRead 
{
	String filePath1="src/test/resources/EXCEL/ChromeTestData.xlsx";//Intializing the excel file path to read the data
	
	String filePath2="src/test/resources/EXCEL/FirefoxTestData.xlsx";//Intializing the excel file path to read the data
	
	String sheetName="Sheet1";//Intializing the excel sheet name to read the data
	
	
	//Reads multiple rows of data at a time from the excel file and return the readed data
	public  String[][] readRows(String browser ,int n1,int n2)
	{
		String[][] s=new String[3][6];//String array to store the data read from the excel file
		int i,j,x,y;
		File f;
		
		try
		{
			if (browser.equals("chrome"))
			{
			    f=new File(filePath1);//chooses filepath1 if selected browser is chrome
			}
			else
			{
				f=new File(filePath2);//chooses filepath2 if selected browser is not chrome
			}
			
			FileInputStream fi=new FileInputStream(f);
			XSSFWorkbook w=new XSSFWorkbook(fi);
			XSSFSheet sh=w.getSheet(sheetName);
			
			for(i=n1,x=0;i<=n2;i++,x++)
			{
			   XSSFRow row=sh.getRow(i);//Row number from which data is to be read from the excel file
			
			         for(j=0,y=0;j<=5;j++,y++)
			         {
			              XSSFCell cell=row.getCell(j);//Cell number from which data is to be read from the excel file
			              
			              s[x][y]=cell.getStringCellValue();//gets the data and stored in array
			              
			              
			                        if(s[x][y].contains("\""))//To remove the Quotes(") for the numeric cells in excel file
			                        {
				                          int a=s[x][y].length();
				                          s[x][y]=s[x][y].substring(1,a-1);
			                         }
			                       
			          }
		    }
		}
		
		catch (FileNotFoundException e1)
		{
			e1.printStackTrace();
		}
		catch (IOException e2) 
		{
			e2.printStackTrace();
		}
		
		return s;//returns the readed data
	}
}
