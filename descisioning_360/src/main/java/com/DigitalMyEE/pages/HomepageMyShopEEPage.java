package com.DigitalMyEE.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Descisioning.generics.BasePage;

public class HomepageMyShopEEPage extends BasePage
{
	// Declaration
		/*@FindBy(xpath="//*[@id=\"CQ5MultisimLoginBannerComponent\"]/div[3]/div/section/div/article/div[2]/div/div/p[1]/a")
		private WebElement seeUpgradeOptionsShop;*/
		
		//*[@id="CQ5LoginBannerComponent"]/div[3]/div/section/div/article/div[2]/div/div/p[1]/a
		
		@FindBy(xpath="//*[@id=\"CQ5LoginBannerComponent\"]/div[3]/div/section/div/article/div[2]/div/div/p[1]/a")
		private WebElement seeUpgradeOptionsShop;
		
		@FindBy(xpath="//*[@id=\"main\"]/div[3]/div/div/div/div/div[2]/div/div[2]/a")
		private WebElement seeUpgradeOptionsShopforEarlyUpgrade;
		
		
		
		
		public WebElement getSeeUpgradeOptionsShop() {
			return seeUpgradeOptionsShop;
		}


		public void setSeeUpgradeOptionsShop(WebElement seeUpgradeOptionsShop) {
			this.seeUpgradeOptionsShop = seeUpgradeOptionsShop;
		}
		
		
		


		public WebElement getSeeUpgradeOptionsShopforEarlyUpgrade() {
			return seeUpgradeOptionsShopforEarlyUpgrade;
		}


		public void setSeeUpgradeOptionsShopforEarlyUpgrade(WebElement seeUpgradeOptionsShopforEarlyUpgrade) {
			this.seeUpgradeOptionsShopforEarlyUpgrade = seeUpgradeOptionsShopforEarlyUpgrade;
		}


		// Initialization
		  public HomepageMyShopEEPage(WebDriver driver) 
	  	{
			super(driver);
			PageFactory.initElements(driver, this);
			
	    }


}
