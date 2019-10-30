package com.Descisioning.generics;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class BaseTest implements ConstantData 
{	
	
	
	public WebDriver driver;
	
	@BeforeMethod
	public  void precondition()
	{
		
		System.setProperty(chrome_key, chrome_value);
		System.setProperty(gecko_key, gecko_value);
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		
		
		
	}
	
	@AfterMethod
	public void postCondition()
	{
		
		driver.quit();
		Reporter.log("",true);
		
		
	}
	
	
	
	
	
	
	
	
	

}
