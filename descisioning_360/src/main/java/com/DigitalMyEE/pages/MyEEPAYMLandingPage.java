package com.DigitalMyEE.pages;

import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import com.Descisioning.generics.BasePage;

import junit.framework.Assert;

public class MyEEPAYMLandingPage extends BasePage
 
{
    
	// Declaration
	/*@FindBy(xpath="//*[@id=\"main\"]/section[4]/div[2]/div[3]/div/div/a[1]")
	private WebElement seeYourUpgradeOptions;*/
	
	@FindBy(xpath="//*[@id=\"main\"]/section[4]/div[2]/div[3]/div/div/a[1]")
	private WebElement seeYourUpgradeOptions;
	/*@FindBy(xpath="/html/body/div[3]/div[5]/section/section/main/section[3]/div[2]/div[3]/div/div/a[1]")
	private WebElement seeYourUpgradeOptions;*/
	
	@FindBy(xpath="//*[@id=\"main\"]/section[4]/div[2]/div[3]/div/div/span")
	private WebElement currentplan;
	

	@FindBy(xpath="//*[@id=\"main\"]/section[4]/div[2]/div[3]/div/div/span")
	private WebElement currentMrc;
	

	
	
	public WebElement getCurrentMrc() {
		return currentMrc;
	}


	public void setCurrentMrc(WebElement currentMrc) {
		this.currentMrc = currentMrc;
	}


	public WebElement getCurrentplan() {
		return currentplan;
	}


	public void setCurrentplan(WebElement currentplan) {
		this.currentplan = currentplan;
	}

	@FindBy(xpath="//*[@id=\"banner-dynamic-placeholder\"]/div/a")
	private WebElement startUpgrade;
	
	
	//getters and setters
	public WebElement getStartUpgrade() 
	{
		return startUpgrade;
	}


	public void setStartUpgrade(WebElement startUpgrade) 
	{
		this.startUpgrade = startUpgrade;
	}
	
	
	public WebElement getSeeYourUpgradeOptions() 
	{
		return seeYourUpgradeOptions;
	}


	public void setSeeYourUpgradeOptions(WebElement seeYourUpgradeOptions) 
	{
		this.seeYourUpgradeOptions = seeYourUpgradeOptions;
	}
	

	  // Initialization
		  public MyEEPAYMLandingPage(WebDriver driver) 
      	{
			super(driver);
			PageFactory.initElements(driver, this);
	    }
		  
		  
		// utilization
		  
		  public void verifyTheTitle(String title)
			{
				WebDriverWait wait=new WebDriverWait(driver,10);
				try
				{
					driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
					if(driver.getTitle()=="pit3-myaccount.intdigital.ee.co.uk"||driver.getTitle()=="pit3-id.intdigital.ee.co.uk")
					{
						driver.navigate().refresh();
					}
					wait.until(ExpectedConditions.titleContains(title));
					Reporter.log("Title is matching :"+title,true);
					
				}
				catch(Exception e)
				{
					Reporter.log("Title is not matching : Actual title is :"+driver.getTitle(),true);
					Assert.fail();
				}
				
			}
		
		  
		  //Utilisation
			public void clickOnstartUpgrade()
			{
				try
				{
					startUpgrade.click();
				}
				catch (Exception e)
				{
					
				}
			}
			
			public void clickOnseeYourUpgradeOption()
			{
				try
				{
				seeYourUpgradeOptions.click();
				}
				catch (Exception e)
				{
					
				}
			}
			
			
			public int giveCurrentData( String currentPlan, XSSFWorkbook workbook, int rownum1,int sheetNum1)
			{
				String allwords[]=currentPlan.split("\\s+");
				
				int size=allwords.length;
				String currentdataplan=null;
				
				String currentdata=null;
				
				int currentResult=0;
				
				for(int i=0;i<size;i++)
				{
					if(allwords[i].contains("GB")||allwords[i].contains("MB")||allwords[i].contains("£"))
					{
						if(allwords[i].contains("GB"))
						{
						currentdataplan=allwords[i].toString();
						
						Reporter.log("current Data plan :"+currentdataplan,true);
						
						
						currentdata=currentdataplan.replaceAll("[^0-9]+","");
						
						currentResult = Integer.parseInt(currentdata);
						
					//	Reporter.log("Current Data in number"+currentResult,true);
						
						}
						
						if(allwords[i].contains("MB"))
						{
							currentdataplan=allwords[i].toString();
							
							Reporter.log("current Data plan :"+currentdataplan,true);
							
							
							currentdata=currentdataplan.replaceAll("[^0-9]+","");
							
							currentResult = Integer.parseInt(currentdata);
							
							//Reporter.log("Current Data in number"+currentResult,true);
							
							
						}
						
					}
				}
				
				return currentResult;
			}
			
			
			public int giveCurrentMrc( String currentPlan, XSSFWorkbook workbook, int rownum1, int sheetNum1)
			{
				String allwords[]=currentPlan.split("\\s+");
				
				int size=allwords.length;
				String currentMrcplan=null;
				
				String currentmrc=null;
				
				int currentResult=0;
				
				for(int i=0;i<size;i++)
				{
				if(allwords[i].contains("£"))
				{
					currentMrcplan=allwords[i].toString();
					
					currentMrcplan=currentMrcplan.replaceAll("[a-zA-Z]+","");
					
					Reporter.log("current MRC :"+currentMrcplan,true);
					
					
					currentmrc=currentMrcplan.replaceAll("[^0-9]+","");
					
					currentResult = Integer.parseInt(currentmrc);
					
					//Reporter.log("Current MRC"+currentResult,true);
					
				}
				}
				
				return currentResult;
			}
			
			
		 
			
			
		
			
		

}
