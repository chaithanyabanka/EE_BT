package com.Pega.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Descisioning.generics.BasePage;

public class pegaMarketingPage extends BasePage
{
	
	// Declaration
	
		@FindBy(xpath="//*[@id=\"txtUserID\"]")
		private WebElement pegaUN;
		
		
	// Initialization
	public pegaMarketingPage(WebDriver driver) 
	{
		super(driver);
		
		PageFactory.initElements(driver, this);
	}
	
	
	
	//Utilisation
	public void clicklogin()
	{
		
		
	}
	

}
