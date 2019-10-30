package com.DigitalMyEE.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import com.Descisioning.generics.BasePage;

import junit.framework.Assert;

public class MyEEloginPage extends BasePage
{
	
		
		// Declaration
		@FindBy(xpath="//*[@id=\"capture_signIn_traditionalSignIn_emailAddress\"]")
		private WebElement username;
		
		@FindBy(xpath="//*[@id=\"capture_signIn_traditionalSignIn_password\"]")
		private WebElement password;
		
		@FindBy(xpath="//*[@id=\"capture_signIn_traditionalSignIn_signInButton\"]/p")
		private WebElement login;
		
		@FindBy(xpath="//*[@id=\"eed-off-canvas\"]/div[2]/dialog/div[2]/div[2]/div/div/div[2]/button")
		private WebElement handlePopup;
		
		
		
		
		//getters and setters
		public WebElement getusername() {
			return username;
		}



		public void setusername(WebElement username) {
			this.username = username;
		}
		
		public WebElement getpassword() {
			return password;
		}



		public void setpassword(WebElement password) {
			this.password = password;
		}
		
		public WebElement getlogin() {
			return login;
		}



		public void setlogin(WebElement login) {
			this.login = login;
		}
		
		
		  // Initialization
			  public MyEEloginPage(WebDriver driver) 
	        	{
				super(driver);
				PageFactory.initElements(driver, this);
				
				try
				{
				if(handlePopup.isDisplayed())
				{
					handlePopup.click();
					
				}
				}
				catch(Exception e)
				{
					
				}
		        }
			
			
			  
			// utilization
				
				public void verifyTheTitle(String title)
				{
					
					WebDriverWait wait=new WebDriverWait(driver,10);
					
					
					try
					{
						if(driver.getTitle()=="pit3-myaccount.intdigital.ee.co.uk"||driver.getTitle()=="pit3-id.intdigital.ee.co.uk")
						{
							
							driver.navigate().refresh();//pit3-id.intdigital.ee.co.uk
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
				
				public void verifyTheElements(WebElement username,WebElement password,WebElement login)
				{
					verifyElement(username);
					verifyElement(password);
					verifyElement(login);
					
				}
				
				
				public void enterCredentials(String un,String pw)
				{
					username.sendKeys(un);
					password.sendKeys(pw);
					
				}
						
				
				public void clicklogin()
				{
					login.click();
					
				}
				
				
				public void myloginpageOperations(String MyEEloginTitle,String un,String pw)
				{
					verifyTheTitle(MyEEloginTitle);
					
					
					verifyTheElements(getusername(),getpassword(),getlogin());
					
				
				    enterCredentials(un,pw);
				    
				    login.click();
					
					
				}
				
	
	

}
