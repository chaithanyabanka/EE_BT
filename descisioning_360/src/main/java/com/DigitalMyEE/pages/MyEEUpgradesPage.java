package com.DigitalMyEE.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Descisioning.generics.BasePage;

public class MyEEUpgradesPage extends BasePage
	{

	// Declaration
		@FindBy(xpath="//*[@id=\"upgrade-timeline\"]/div/div[2]/div/a")
		private WebElement upgradeNow;

		public WebElement getUpgradeNow() {
			return upgradeNow;
		}

		public void setUpgradeNow(WebElement upgradeNow) {
			this.upgradeNow = upgradeNow;
		}
		
		  // Initialization
		  public MyEEUpgradesPage(WebDriver driver) 
    	{
			super(driver);
			PageFactory.initElements(driver, this);
	    }
		  
		  
		// utilization
						
	    	public void clickOnUpgradeNow(WebElement upgradeNow)
		{
				upgradeNow.click();
				
							
							
		}
					
				
					
				
				
		  
		
}
