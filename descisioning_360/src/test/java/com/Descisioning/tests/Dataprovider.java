package com.Descisioning.tests;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class Dataprovider 
{
	
	public static XSSFWorkbook defaultValues() throws IOException 
	{
		
		String file_path="C:\\Users\\cbanka\\eclipse-workspace\\descisioning_360\\Data sheet.xlsx";
		
		FileInputStream fis=new FileInputStream(file_path);
		
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		
		
		
		return workbook;
	}
	
	public static  void defaultValues1(XSSFWorkbook workbook) throws IOException, InterruptedException 
	{
		Thread.sleep(5000);
		
		String file_path="C:\\Users\\cbanka\\eclipse-workspace\\descisioning_360\\Data sheet.xlsx";
		
		FileOutputStream fout=new FileOutputStream(file_path);
		
     	workbook.write(fout);
     	
	  	fout.close();
		
		
		
	}
	


	
	
	@DataProvider
	public static Object[][] standardUpgradeCTNs_PAYM() throws IOException
	{
		
	XSSFWorkbook workbook=Dataprovider.defaultValues();
	
	//int rowcount =workbook.getSheetAt(1).getLastRowNum();
	
	int rowcount =5;
	
	int colcount=8;
	
	
	Object Data[][]= new Object[rowcount-1][colcount-1];
	
	int sheetnum=1;
	
	for(int k=1;k==sheetnum;k++)
	{
	
	for (int i = 2; i <rowcount-1; i++) 
	{
	// to get Standard upgrade CTNs
		
		XSSFRow row= workbook.getSheetAt(k).getRow(i);
	
				for (int j = 1; j <colcount-1; j++) 
					{
					
					if(row==null)
                        Data[i][j]= "";
					else
                    {
                        XSSFCell cell= row.getCell(j);
                        if(cell==null)
                            Data[i][j]= ""; //if it get Null value it pass no data
                        else
                        {
                            String value=row.getCell(j).getStringCellValue();
                            Data[i][j]=value; //This formatter get my all values as string i.e integer, float all type data value
                            //System.out.println(Data[i][j]);
                        }
						
						
					}			
				
				
					}
	
			}
	}
	
	workbook.close();
	 return Data;
	
	}
	
	@DataProvider
	public static Object[][] earlyUpgradeCTNs_PAYM() throws IOException
	{
			
		XSSFWorkbook workbook=Dataprovider.defaultValues();
		
		
		//int rowcount =workbook.getSheetAt(1).getLastRowNum();
		
		int rowcount =5;
		
		int colcount=8;
		
		
		Object Data[][]= new Object[rowcount-1][colcount-1];
		
		
		int sheetnum=3;
	
		for(int k=3;k==sheetnum;k++)
		{
			
		
		for (int i = 2; i <rowcount-1; i++) 
		{
			
		// to get Standard upgrade CTNs
			
			XSSFRow row= workbook.getSheetAt(k).getRow(i);
		
					for (int j = 1; j <colcount-1; j++) 
						{
						
						if(row==null)
	                        Data[i][j]= "";
						else
	                    {
	                        XSSFCell cell= row.getCell(j);
	                        if(cell==null)
	                            Data[i][j]= ""; //if it get Null value it pass no data
	                        else
	                        {
	                            String value=row.getCell(j).getStringCellValue();
	                            Data[i][j]=value; //This formatter get my all values as string i.e integer, float all type data value
	                            //System.out.println(Data[i][j]);
	                        }
							
							
						}			
					
					
						}
		
				}
		}
		
		workbook.close();
		 return Data;
	}
	
	
	
	@DataProvider
	public static Object[][] annualUpgradeCTNs() throws IOException
	{
		
	XSSFWorkbook workbook=Dataprovider.defaultValues();
	
	int rowcount =5;
	
	int colcount=7;
	
	
	
	Object Data[][]= new Object[rowcount-1][colcount-1];
	
	int sheetnum=5;
	
	for(int k=5;k==sheetnum;k++)
	{
	
	for (int i = 2; i <rowcount; i++) 
	{
	// to get Standard upgrade CTNs
		
		XSSFRow row= workbook.getSheetAt(k).getRow(i);
	
				for (int j = 1; j <colcount; j++) 
					{
					
					if(row==null)
                        Data[i][j]= "";
					else
                    {
                        XSSFCell cell= row.getCell(j);
                        if(cell==null)
                            Data[i][j]= ""; //if it get Null value it pass no data
                        else
                        {
                            String value=row.getCell(j).getStringCellValue();
                            Data[i][j]=value; //This formatter get my all values as string i.e integer, float all type data value
                            //System.out.println(Data[i][j]);
                        }
						
						
					}			
				
				
					}
	
			}
	}
	
	workbook.close();
	 return Data;
	
	}
	
	
	@DataProvider
	public static Object[][] upgradeAnytimeCTNs() throws IOException
	{	
		
	XSSFWorkbook workbook=Dataprovider.defaultValues();

	//int countOfSheets=workbook.getNumberOfSheets();
	
	
	int rowcount =4;
	
	int colcount=5;
	
	
	
	Object Data[][]= new Object[rowcount-1][colcount-1];
	
	int sheetnum=6;
	
	for(int k=6;k==sheetnum;k++)
	{
	
	for (int i = 1; i <rowcount; i++) 
	{
	// to get Standard upgrade CTNs
		
		XSSFRow row= workbook.getSheetAt(k).getRow(i);
	
				for (int j = 1; j <colcount; j++) 
					{
					
					if(row==null)
                        Data[i][j]= "";
					else
                    {
                        XSSFCell cell= row.getCell(j);
                        if(cell==null)
                            Data[i][j]= ""; //if it get Null value it pass no data
                        else
                        {
                            String value=row.getCell(j).getStringCellValue();
                            Data[i][j]=value; //This formatter get my all values as string i.e integer, float all type data value
                            //System.out.println(Data[i][j]);
                        }
						
						
					}			
				
				
					}
	
			}
	}
	
	workbook.close();
	 return Data;
	
	}
	
	
	@DataProvider
	public static Object[][] standardUpgradeCTNs_SIMO() throws IOException
	{
		
		XSSFWorkbook workbook=Dataprovider.defaultValues();
		
		//int rowcount =workbook.getSheetAt(1).getLastRowNum();
		
		int rowcount =5;
		
		int colcount=8;
		
		
		Object Data[][]= new Object[rowcount-1][colcount-1];
		
		int sheetnum=2;
		
		for(int k=2;k==sheetnum;k++)
		{
		
		for (int i = 2; i <rowcount-1; i++) 
		{
		// to get Standard upgrade CTNs
			
			XSSFRow row= workbook.getSheetAt(k).getRow(i);
		
					for (int j = 1; j <colcount-1; j++) 
						{
						
						if(row==null)
	                        Data[i][j]= "";
						else
	                    {
	                        XSSFCell cell= row.getCell(j);
	                        if(cell==null)
	                            Data[i][j]= ""; //if it get Null value it pass no data
	                        else
	                        {
	                            String value=row.getCell(j).getStringCellValue();
	                            Data[i][j]=value; //This formatter get my all values as string i.e integer, float all type data value
	                            //System.out.println(Data[i][j]);
	                        }
							
							
						}			
					
					
						}
		
				}
		}
		
		workbook.close();
		 return Data;
	}
		
		
	
	
	
	@DataProvider
	public static Object[][] earlyUpgradeCTNs_SIMO() throws IOException
	{
			
    XSSFWorkbook workbook=Dataprovider.defaultValues();
	
	
	//int rowcount =workbook.getSheetAt(4).getLastRowNum();
	
	int rowcount =5;
	
	int colcount=8;
			
	
	Object Data[][]= new Object[rowcount-1][colcount-1];
	
	int sheetnum=4;
	
	for(int k=4;k==sheetnum;k++)
	{
	
	for (int i = 2; i <rowcount-1; i++) 
	{
	// to get Standard upgrade CTNs
		
		XSSFRow row= workbook.getSheetAt(k).getRow(i);
	
				for (int j = 1; j <colcount-1; j++) 
					{
				
					
					if(row==null)
                        Data[i][j]= "";
					else
                    {
                        XSSFCell cell= row.getCell(j);
                        if(cell==null)
                            Data[i][j]= ""; //if it get Null value it pass no data
                        else
                        {
                            String value=row.getCell(j).getStringCellValue();
                            Data[i][j]=value; //This formatter get my all values as string i.e integer, float all type data value
                            //System.out.println(Data[i][j]);
                        }
						
						
					}			
				
				
					}
	
			}
	}
	
	workbook.close();
	 return Data;
	
	}
	
	
}
	
	
