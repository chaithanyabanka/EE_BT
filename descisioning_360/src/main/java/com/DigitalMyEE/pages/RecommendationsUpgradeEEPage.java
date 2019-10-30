package com.DigitalMyEE.pages;

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

public class RecommendationsUpgradeEEPage extends BasePage
{
	
	// Declaration
			@FindBy(xpath="//*[@id=\"productHeroSection\"]/div[2]/div[1]/div[2]/div[5]/div/div[2]/span/span")
			private WebElement earlyUpgradeFee;
			
			@FindBy(xpath="//*[@id=\"productHeroSection\"]/div[1]/div[4]/div[1]/h1")
			private WebElement recommendeProductName;
			
			@FindBy(xpath="//*[@id=\"productHeroSection\"]/div[2]/div[1]/div[2]/div[1]/div")
			private WebElement dataForRecommendedplan;
			
			@FindBy(xpath="//*[@id=\"main\"]/div[1]/div/div[2]/form/div/div/div[2]")
			private WebElement moveTOSIMO;
			
			@FindBy(xpath="//*[@id=\"main\"]/div[1]/div/div[8]/header/h3[2]")
			private WebElement headerSIMO;
			
			
			@FindBy(xpath="//*[@id=\"plancontent-CQ5Content_PlansCarouselForRecommendationPageSimo12month-1\"]")
			private WebElement simoPLAN1;
			
			@FindBy(xpath="//*[@id=\"plancontent-CQ5Content_PlansCarouselForRecommendationPageSimo12month-1\"]/div/div[2]/div[1]")
			private WebElement simodata1;
			
			
			@FindBy(xpath="//*[@id=\"plancontent-CQ5Content_PlansCarouselForRecommendationPageSimo12month-1\"]/div/div[2]/div[2]")
			private WebElement simomrc1;
			
			
			@FindBy(xpath="//*[@id=\"plancontent-CQ5Content_PlansCarouselForRecommendationPageSimo12month-1\"]/div/div[2]/div[3]")
			private WebElement simominutes1;
			
			
			@FindBy(xpath="//*[@id=\"plancontent-CQ5Content_PlansCarouselForRecommendationPageSimo12month-2\"]")
			private WebElement simoPLAN2;
			
			
			@FindBy(xpath="//*[@id=\"plancontent-CQ5Content_PlansCarouselForRecommendationPageSimo12month-2\"]/div/div[2]/div[1]")
			private WebElement simodata2;
			
			
			@FindBy(xpath="//*[@id=\"plancontent-CQ5Content_PlansCarouselForRecommendationPageSimo12month-2\"]/div/div[2]/div[2]")
			private WebElement simomrc2;
			
			
			@FindBy(xpath="//*[@id=\"plancontent-CQ5Content_PlansCarouselForRecommendationPageSimo12month-2\"]/div/div[2]/div[3]")
			private WebElement simominutes2;
			
			
			
			@FindBy(xpath="//*[@id=\"plancontent-CQ5Content_PlansCarouselForRecommendationPageSimo12month-3\"]")
			private WebElement simoPLAN3;
			
			
			@FindBy(xpath="//*[@id=\"plancontent-CQ5Content_PlansCarouselForRecommendationPageSimo12month-3\"]/div/div[2]/div[1]")
			private WebElement simodata3;
			
			
			@FindBy(xpath="//*[@id=\"plancontent-CQ5Content_PlansCarouselForRecommendationPageSimo12month-3\"]/div/div[2]/div[2]")
			private WebElement simomrc3;
			
			@FindBy(xpath="//*[@id=\"plancontent-CQ5Content_PlansCarouselForRecommendationPageSimo12month-3\"]/div/div[2]/div[3")
			private WebElement simominutes3;
			
			@FindBy(xpath="//*[@id=\"plancontent-CQ5Content_PlansCarouselForRecommendationPageSimo12month-4\"]")
			private WebElement simoPLAN4;
			
			
			@FindBy(xpath="//*[@id=\"plancontent-CQ5Content_PlansCarouselForRecommendationPageSimo12month-5\"]")
			private WebElement simoPLAN5;
			
			
			@FindBy(xpath="//*[@id=\"plancontent-CQ5Content_PlansCarouselForRecommendationPageSimo12month-1\"]/div/div[3]/form/input[2]")
			private WebElement soc1;
			
			@FindBy(xpath="//*[@id=\"plancontent-CQ5Content_PlansCarouselForRecommendationPageSimo12month-2\"]/div/div[3]/form/input[2]")
			private WebElement soc2;
			
			@FindBy(xpath="//*[@id=\"plancontent-CQ5Content_PlansCarouselForRecommendationPageSimo12month-3\"]/div/div[3]/form/input[2]")
			private WebElement soc3;
			
			public WebElement getSoc1() {
				return soc1;
			}

			public void setSoc1(WebElement soc1) {
				this.soc1 = soc1;
			}

			public WebElement getSoc2() {
				return soc2;
			}

			public void setSoc2(WebElement soc2) {
				this.soc2 = soc2;
			}

			public WebElement getSoc3() {
				return soc3;
			}

			public void setSoc3(WebElement soc3) {
				this.soc3 = soc3;
			}

			public WebElement getSoc4() {
				return soc4;
			}

			public void setSoc4(WebElement soc4) {
				this.soc4 = soc4;
			}

			public WebElement getSoc5() {
				return soc5;
			}

			public void setSoc5(WebElement soc5) {
				this.soc5 = soc5;
			}

			public WebElement getClickOnRight() {
				return clickOnRight;
			}

			public void setClickOnRight(WebElement clickOnRight) {
				this.clickOnRight = clickOnRight;
			}


			@FindBy(xpath="//*[@id=\"plancontent-CQ5Content_PlansCarouselForRecommendationPageSimo12month-4\"]/div/div[3]/form/input[2]")
			private WebElement soc4;
			
			@FindBy(xpath="//*[@id=\"plancontent-CQ5Content_PlansCarouselForRecommendationPageSimo12month-5\"]/div/div[3]/form/input[2]")
			private WebElement soc5;
			
			
			
			@FindBy(xpath="//*[@id=\"ee-slick-slide11\"]/button")
			private WebElement clickOnRight;
			
			
			
			
			


		
	
			
			
			
			
			
			
			
			//getters and setters
			public WebElement getHeaderSIMO() {
				return headerSIMO;
			}

			public void setHeaderSIMO(WebElement headerSIMO) {
				this.headerSIMO = headerSIMO;
			}

			
			public WebElement getMoveTOSIMO() {
				return moveTOSIMO;
			}

			public void setMoveTOSIMO(WebElement moveTOSIMO) {
				this.moveTOSIMO = moveTOSIMO;
			}

			public WebElement getDataForRecommendedplan() {
				return dataForRecommendedplan;
			}

			public void setDataForRecommendedplan(WebElement dataForRecommendedplan) {
				this.dataForRecommendedplan = dataForRecommendedplan;
			}

			
			public WebElement getearlyUpgradeFee() {
				return earlyUpgradeFee;
			}

			public WebElement getRecommendeProductName() {
				return recommendeProductName;
			}

			public void setRecommendeProductName(WebElement recommendeProductName) {
				this.recommendeProductName = recommendeProductName;
			}

			public void setearlyUpgradeFee(WebElement earlyUpgradeFee) {
				this.earlyUpgradeFee = earlyUpgradeFee;
			}
			

			public WebElement getSimoPLAN4() {
				return simoPLAN4;
			}

			public void setSimoPLAN4(WebElement simoPLAN4) {
				this.simoPLAN4 = simoPLAN4;
			}

			public WebElement getSimoPLAN5() {
				return simoPLAN5;
			}

			public void setSimoPLAN5(WebElement simoPLAN5) {
				this.simoPLAN5 = simoPLAN5;
			}

			public WebElement getSimoPLAN1() {
				return simoPLAN1;
			}

			public void setSimoPLAN1(WebElement simoPLAN1) {
				this.simoPLAN1 = simoPLAN1;
			}

			public WebElement getSimodata1() {
				return simodata1;
			}

			public void setSimodata1(WebElement simodata1) {
				this.simodata1 = simodata1;
			}

			public WebElement getSimomrc1() {
				return simomrc1;
			}

			public void setSimomrc1(WebElement simomrc1) {
				this.simomrc1 = simomrc1;
			}

			public WebElement getSimominutes1() {
				return simominutes1;
			}

			public void setSimominutes1(WebElement simominutes1) {
				this.simominutes1 = simominutes1;
			}

			public WebElement getSimoPLAN2() {
				return simoPLAN2;
			}

			public void setSimoPLAN2(WebElement simoPLAN2) {
				this.simoPLAN2 = simoPLAN2;
			}

			public WebElement getSimodata2() {
				return simodata2;
			}

			public void setSimodata2(WebElement simodata2) {
				this.simodata2 = simodata2;
			}

			public WebElement getSimomrc2() {
				return simomrc2;
			}

			public void setSimomrc2(WebElement simomrc2) {
				this.simomrc2 = simomrc2;
			}

			public WebElement getSimominutes2() {
				return simominutes2;
			}

			public void setSimominutes2(WebElement simominutes2) {
				this.simominutes2 = simominutes2;
			}

			public WebElement getSimoPLAN3() {
				return simoPLAN3;
			}

			public void setSimoPLAN3(WebElement simoPLAN3) {
				this.simoPLAN3 = simoPLAN3;
			}

			public WebElement getSimodata3() {
				return simodata3;
			}

			public void setSimodata3(WebElement simodata3) {
				this.simodata3 = simodata3;
			}

			public WebElement getSimomrc3() {
				return simomrc3;
			}

			public void setSimomrc3(WebElement simomrc3) {
				this.simomrc3 = simomrc3;
			}

			public WebElement getSimominutes3() {
				return simominutes3;
			}

			public void setSimominutes3(WebElement simominutes3) {
				this.simominutes3 = simominutes3;
			}
			
			public WebElement getclickOnRight() {
				return clickOnRight;
			}

			public void setclickOnRight(WebElement clickOnRight) {
				this.clickOnRight = clickOnRight;
			}

			
			
			
	// Initialization
	  public RecommendationsUpgradeEEPage(WebDriver driver) 
	{
		super(driver);
		PageFactory.initElements(driver, this);
    }
	  
	  
	  
	  
	// utilization
	  
	  
	  public void verifyTheTitle(String title) throws InterruptedException
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
	  
	  
							
		public String fetchEUF(WebElement earlyUpgradeFee)
	{
			String fees=earlyUpgradeFee.getText();
			
			Reporter.log("Early upgrade fee :"+fees, true);
			
			return fees;							
								
	}
		
		/*
		//
		//
		//Method to return the recommended DATA from the data captured from the DIGITAL SHOP
		//
		//
		*/	
		
		public String  operation1(WebElement simoplan,WebElement simodata,WebElement simomrc)
		{
			
			
			
			String plan=simoplan.getText();
			
			Reporter.log(plan, true);
			
			String data=simodata.getText();
			
		//	Reporter.log(data, true);
			
			@SuppressWarnings("unused")
			String mrc=simomrc.getText();
			
			//Reporter.log(mrc, true);
			
			return data;
		}
		
		
		/*
		//
		//
		//Method to return the recommended DATA from the data captured from the DIGITAL SHOP
		//
		//
		*/	
		
		public int giveRecommendedData(String recommendedDataPlan, XSSFWorkbook workbook, int rownum1)
		{
			String allwords[]=recommendedDataPlan.split("\\s+");
			
			int size=allwords.length;
			
			int recommendedResult=0;
		
			String recommendedData=null;
			
			String recommendedData1=null;
			for(int i=0;i<size;i++)
			{

			if(allwords[i].contains("GB")||allwords[i].contains("MB")||allwords[i].contains("£"))
			{
				if(allwords[i].contains("GB"))
				{	
					recommendedData1=allwords[i];
				recommendedData=allwords[i].replaceAll("[a-zA-Z]+","");
				
				Reporter.log("Recommended Data :"+recommendedData1,true);
				
				
				/*
				if (recommendedData.contains("Max"))
				{
					recommendedData=recommendedData.replaceAll("Max ","");
					
					Reporter.log("Recommended Data :"+recommendedData,true);
				}
				*/
			
				recommendedResult = Integer.parseInt(recommendedData);
				
				//Reporter.log("Recommended Result"+recommendedResult,true);
				
				
				
				
				}
				
				if(allwords[i].contains("MB"))
				{
					recommendedData=allwords[i].replaceAll("[a-zA-Z]+","");
					
					//recommendedData=allwords[i].replaceAll("Max","");
					
					Reporter.log("Recommended Data"+recommendedData,true);
					
					
					recommendedResult = Integer.parseInt(recommendedData);
					
					//Reporter.log("Recommended Result"+recommendedResult,true);
					
					
				}
				
				
			}
			}
			
			return recommendedResult;
			
			
		}
		
		
		/*
		//
		//
		//Method to return the recommended MRC from the data captured from the DIGITAL SHOP
		//
		//
		*/	
		
		
		public int giveRecommendedMrc(String recommendedDataPlan, XSSFWorkbook workbook, int rownum1) 
		{
			String allwords[]=recommendedDataPlan.split("\\s+");
			
			int size=allwords.length;
			String recommendedmrc=null;
			String recommendedmrc1=null;
			
			int recommendedResult=0;
			
			for(int i=0;i<size;i++)
			{

			if(allwords[i].contains("£"))
			{	
				recommendedmrc1=allwords[i];
				recommendedmrc1=recommendedmrc1.replaceAll("[a-zA-Z]+","");
				
			recommendedmrc=allwords[i].replaceAll("[^0-9]+","");
			
			Reporter.log("Recommended MRC :"+recommendedmrc1,true);
			
			
			//recommendedResult = Integer.parseInt(recommendedmrc);
			
			recommendedResult = (int)Float.parseFloat(recommendedmrc);
			
		
			//Reporter.log("Recommended Result"+recommendedmrc,true);
			
			
	
			
			}
			}
			return recommendedResult;
		}
					
	

}
