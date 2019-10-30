package com.Descisioning.generics;

import java.io.File;

import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class GenericUtils 
{
	
	//to take screenshot
	public static void getScreenShot(WebDriver driver,String name)
	{
		try
		{
			TakesScreenshot t=(TakesScreenshot)driver;
			File src = t.getScreenshotAs(OutputType.FILE);
			File dest=new File("./screenshots/"+name+".png");
			FileUtils.copyFile(src, dest);
		}
		catch(IOException e)
		{
			
		}
	}

	//to select by Index
	public static void selectByIndex(WebElement element, int index)
	{
		Select select=new Select(element);
		select.selectByIndex(index);
	}
	
	public static void selectByValue(WebElement element, String value)
	{
		Select select =new Select(element);
		select.selectByValue(value);
	}
	
	public static void selectByText(WebElement element, String text)
	{
		Select select=new Select(element);
		select.selectByVisibleText(text);
		
	}
	
	


	

		
		
	}
			



