package com.Pega.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Descisioning.generics.BasePage;

public class pegaLoginPage extends BasePage
{
	// Declaration
	
	@FindBy(xpath="//*[@id=\"txtUserID\"]")
	private WebElement pegaUN;
	
	@FindBy(xpath="//*[@id=\"txtPassword\"]")
	private WebElement pegaPW;

	
	@FindBy(xpath="//*[@id=\"sub\"]/span")
	private WebElement pegaLogin;
	

	//Getters and Setters
	
	  public WebElement getPegaUN() {
		return pegaUN;
	}


	public void setPegaUN(WebElement pegaUN) {
		this.pegaUN = pegaUN;
	}


	public WebElement getPegaPW() {
		return pegaPW;
	}


	public void setPegaPW(WebElement pegaPW) {
		this.pegaPW = pegaPW;
	}


	public WebElement getPegaLogin() {
		return pegaLogin;
	}


	public void setPegaLogin(WebElement pegaLogin) {
		this.pegaLogin = pegaLogin;
	}


		// Initialization
		  public pegaLoginPage(WebDriver driver) 
    	{
			super(driver);
			PageFactory.initElements(driver, this);
	    }
		  
		  
		//Utilisation
		  
		  public void verifyTheElements(WebElement pegaUN,WebElement pegaPW,WebElement pegaLogin)
			{
				verifyElement(pegaUN);
				verifyElement(pegaPW);
				verifyElement(pegaLogin);
				
			}
		  
		  public void loginToPega(String username, String password)
			{
			  pegaUN.sendKeys(username);
			  pegaPW.sendKeys(password);
			  pegaLogin.click();
			  
			}



}
