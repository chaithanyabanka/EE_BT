package com.DigitalMyEE.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Descisioning.generics.BasePage;

public class PhonesTabletsSIMsPage extends BasePage
{

	// Declaration
	@FindBy(xpath="//*[@id=\"eed-header\"]/div[2]/div/ul[2]/li[5]/div/div[1]/a[1]")
	private WebElement loginShop;
	
	
	
	@FindBy(xpath="//*[@id=\"eed-off-canvas\"]/div[3]/div/div[1]/dialog/div[2]/div[2]/div/div/div[2]/button")
	private WebElement handlePopup;
	
	
	 public WebElement getLoginShop() {
		return loginShop;
	}


	public void setLoginShop(WebElement loginShop) {
		this.loginShop = loginShop;
	}


	public WebElement getHandlePopup() {
		return handlePopup;
	}


	public void setHandlePopup(WebElement handlePopup) {
		this.handlePopup = handlePopup;
	}


	// Initialization
	  public PhonesTabletsSIMsPage(WebDriver driver) 
  	{
		super(driver);
		PageFactory.initElements(driver, this);
		try
		{
		if(handlePopup.isDisplayed())
		{
			handlePopup.click();
			System.out.println("***handled popupRUNNING upgradeRecommendations_PAYM_SHOP***");
			
		}
		}
		catch(Exception e)
		{
			
		}

      }

}
