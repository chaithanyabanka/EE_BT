package com.Descisioning.generics;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import junit.framework.Assert;


public class BasePage
{
	public  WebDriver driver;

	public  BasePage(WebDriver driver)
	{
		this.driver=driver;		
				
	}
	
	//to verify the title
	public void verifyTitle(String eTitle) throws AWTException
	{
		WebDriverWait wait=new WebDriverWait(driver,10);
		try
		{	
			
			
			/*if(driver.getTitle()=="pit3-myaccount.intdigital.ee.co.uk"||driver.getTitle()=="pit3-id.intdigital.ee.co.uk")
			{
				Robot rb=new Robot();
				
				rb.keyPress(KeyEvent.VK_CONTROL);
				rb.keyPress(KeyEvent.VK_R);
				
				rb.keyRelease(KeyEvent.VK_R);
				rb.keyRelease(KeyEvent.VK_CONTROL);
				
			}*/
			wait.until(ExpectedConditions.titleIs(eTitle));
			
			
			Reporter.log("Title is matching :"+eTitle,true);
			
		}
		catch(Exception e)
		{
			try
			{
			int i=1;
			if(i==1)
			{
				Robot rb=new Robot();
				
				rb.keyPress(KeyEvent.VK_CONTROL);
				rb.keyPress(KeyEvent.VK_R);
				
				rb.keyRelease(KeyEvent.VK_R);
				rb.keyRelease(KeyEvent.VK_CONTROL);
			}
			
			wait.until(ExpectedConditions.titleIs(eTitle));
			}
			catch(Exception e1)
			{
			
			Reporter.log("Title is not matching : Actual title is :"+driver.getTitle(),true);
			Assert.fail();
			}
		}
	}
	
	//to verify the element
	public void verifyElement(WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver,10);
		try
		{
			wait.until(ExpectedConditions.visibilityOf(element));
			Reporter.log("Element is present :"+element.getText(),true);
			
		}
		catch(Exception e)
		{
			Reporter.log("Element is not present :"+element.getText(),true);
			Assert.fail();
		
		}
	}
	
	// to perform actions class for click on element
	
	public void clickOnElement(WebElement target)
	{
		Actions act = new Actions(driver);
		
		act.moveToElement(target).click();
	}
	
	
	

		
		
	


}
