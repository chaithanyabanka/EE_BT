package com.Descisioning.tests;

import java.awt.AWTException;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;
import com.Descisioning.generics.BaseTest;

import com.DigitalMyEE.pages.HomepageMyShopEEPage;
import com.DigitalMyEE.pages.MyEEloginPage;
import com.DigitalMyEE.pages.PhonesTabletsSIMsPage;
import com.DigitalMyEE.pages.RecommendationsUpgradeEEPage;

import junit.framework.Assert;

public class RelevanceRules extends BaseTest
{
	
	@Test(groups = { "SHOP" },dataProvider="earlyUpgradeCTNs_PAYM",dataProviderClass=Dataprovider.class)
	public void relevanceRules_EarlyUpgrade_PAYM_SHOP(String dummy,String rownum,String upgradeStatus,String ctn,String un,String pw,String sheetNum) throws IOException, InterruptedException, AWTException
	{
		int sheetNum1=Integer.parseInt(sheetNum);
		int rownum1 = Integer.parseInt(rownum);
		
		XSSFWorkbook workbook=Dataprovider.defaultValues();

		String login1=null;
		String login2=null;
		String login3=null;
		String login4=null;
		
		for(int i=1;i<5;i++)
		{
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			
		Reporter.log("***RUNNING RelevanceRules_EarlyUpgrade_PAYM_SHOP:::"+i, true);
		
		Reporter.log(upgradeStatus + " "+ ctn +" "+""+un, true);
		
	
		Thread.sleep(3000);
		
		
		driver.get(urlForSHOP);
		
		
		
		String MyEEloginTitle=workbook.getSheetAt(0).getRow(1).getCell(0).getStringCellValue();
		
		String recommenadtionsTitle=workbook.getSheetAt(0).getRow(1).getCell(3).getStringCellValue();
		
		
		/*
		//
		//Operations on PhonesTabletsSIMs
		//
		*/	
		
		PhonesTabletsSIMsPage pts=new PhonesTabletsSIMsPage(driver);
		
		
		String eTitle="4G Phones, Tablets & SIMs | Mobile Phone Deals | EE Shop";
		

		
		pts.verifyTitle(eTitle);
		
		pts.verifyElement(pts.getLoginShop());
		
		Thread.sleep(5000);
		
		pts.getLoginShop().click();
		
		
		/*
		//
		//Operations on MyEEloginPage
		//
		*/
		
		
		MyEEloginPage ml=new MyEEloginPage(driver);
		
		
		
		ml.myloginpageOperations(MyEEloginTitle, un, pw);
		
		
		/*
		//
		//Operations on HomepageMyShopEE
		//
		*/
		
		HomepageMyShopEEPage hps=new HomepageMyShopEEPage(driver);
		
		String homePageShopTitle="Homepage | My Shop | EE";
		
		hps.verifyTitle(homePageShopTitle);
		
		hps.verifyElement(hps.getSeeUpgradeOptionsShopforEarlyUpgrade());
		
		//hps.verifyElement(hps.getSeeUpgradeOptionsShop());
		
		//hps.getSeeUpgradeOptionsShop().click();
		
		hps.getSeeUpgradeOptionsShopforEarlyUpgrade().click();
		
		
		
		
		/*
		//
		//Operations on Recommendations | Upgrade | EE
		//
		*/
		
		
		RecommendationsUpgradeEEPage ru=new RecommendationsUpgradeEEPage(driver);
		
		
		ru.verifyTitle(recommenadtionsTitle);
		
		
		
		JavascriptExecutor js1= (JavascriptExecutor)driver;
		
		js1.executeScript("scroll(0,600)");
		
		//Screenshot
        File srcFile1 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

        //FileUtils.copyFile(srcFile1,new File("D:\\Users\\Default User\\Desktop\\screenshots\\Allowance Rules\\Currentpaln : "+ctn+".png"));
        
	   // FileUtils.copyFile(srcFile1,new File("D:\\Users\\Default User\\Desktop\\screenshots\\Relevancy rules\\Recommendedproduct : "+ctn+i+".png"));
		
        FileUtils.copyFile(srcFile1,new File("D:\\Users\\Default User\\Desktop\\screenshots\\Relevancy rules\\Recommendedproduct for "+ctn+"\\Login_"+i+".png"));
		
        ru.verifyElement(ru.getRecommendeProductName());
        
        String nameoftheproduct=ru.getRecommendeProductName().getText();
		
		//GenericUtils.getScreenShot(driver,"Relevance rules Login : "+i);
		
		Reporter.log("LOGIN : "+i+" "+nameoftheproduct, true);
		
		
		
		if (i==1)
		{
		workbook.getSheetAt(sheetNum1).getRow(rownum1).createCell(17).setCellValue(ru.getRecommendeProductName().getText());
		login1=ru.getRecommendeProductName().getText();
		Dataprovider.defaultValues1(workbook);
		}
		else if (i==2)
		{
		workbook.getSheetAt(sheetNum1).getRow(rownum1).createCell(18).setCellValue(ru.getRecommendeProductName().getText());
		login2=ru.getRecommendeProductName().getText();
		Dataprovider.defaultValues1(workbook);
		}
		
		else if (i==3)
		{
		workbook.getSheetAt(sheetNum1).getRow(rownum1).createCell(19).setCellValue(ru.getRecommendeProductName().getText());
		login3=ru.getRecommendeProductName().getText();
		Dataprovider.defaultValues1(workbook);
		}
		
		else if (i==4)
		{
		workbook.getSheetAt(sheetNum1).getRow(rownum1).createCell(20).setCellValue(ru.getRecommendeProductName().getText());
		login4=ru.getRecommendeProductName().getText();
		Dataprovider.defaultValues1(workbook);
		}
		
		
		
		// for storing the output
		
	  	
	  	driver.close();
	  	
	  	
		}
		
		int count =0;
	  	
	  	for(int o=1;o==1;o++)
	  	{
	  		if(login1.equalsIgnoreCase(login2))
	  		//if(login1==login2)
	  		{
	  			count++;
	  			//Reporter.log("**1==2**"+count, true);
	  		}
	  		
	  		if(login1.equalsIgnoreCase(login3))
	  		{
	  			count++;
	  			//Reporter.log("**1==3**"+count, true);
	  		}
	  		if(login1.equalsIgnoreCase(login4))
	  		{
	  			count++;
	  			//Reporter.log("**1==4**"+count, true);
	  		}
	  		
	  		Dataprovider.defaultValues1(workbook);
	  		
	  		if(count!=0)
	  		{
	  			if(count<3)
	  			{
	  				Reporter.log("*****"+count, true);
	  				Reporter.log("SUCCESS", true);
	  				workbook.getSheetAt(sheetNum1).getRow(rownum1).createCell(21).setCellValue("SUCCESS");
	  				Dataprovider.defaultValues1(workbook);
	  			}
	  		
	  			if(count==3)
	  			{
	  				Reporter.log("*****"+count, true);
	  				Reporter.log("FAIL", true);
	  				workbook.getSheetAt(sheetNum1).getRow(rownum1).createCell(21).setCellValue("FAIL");
	  				Dataprovider.defaultValues1(workbook);
	  				Assert.fail();
	  			}
	  		}
	  		
	  		
	  	}
	  	
	  	Dataprovider.defaultValues1(workbook);

	}
	
	
	
	
	@Test(groups = { "SHOP" },dataProvider="standardUpgradeCTNs_PAYM",dataProviderClass=Dataprovider.class)
	public void relevanceRules_StandardUpgrade_PAYM_SHOP(String dummy,String rownum,String upgradeStatus,String ctn,String un,String pw,String sheetNum) throws IOException, InterruptedException, AWTException
	{
		int sheetNum1=Integer.parseInt(sheetNum);
		int rownum1 = Integer.parseInt(rownum);
		
		XSSFWorkbook workbook=Dataprovider.defaultValues();

		String login1=null;
		String login2=null;
		String login3=null;
		String login4=null;
		
		for(int i=1;i<5;i++)
		{
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			
		Reporter.log("***RUNNING RelevanceRules_StandardUpgrade_PAYM_SHOP:::"+i, true);
		
		Reporter.log(upgradeStatus + " "+ ctn +" "+""+un, true);
		
	
		Thread.sleep(3000);
		
		
		driver.get(urlForSHOP);
		
		
		
		String MyEEloginTitle=workbook.getSheetAt(0).getRow(1).getCell(0).getStringCellValue();
		
		String recommenadtionsTitle=workbook.getSheetAt(0).getRow(1).getCell(3).getStringCellValue();
		
		
		/*
		//
		//Operations on PhonesTabletsSIMs
		//
		*/	
		
		PhonesTabletsSIMsPage pts=new PhonesTabletsSIMsPage(driver);
		
		
		String eTitle="4G Phones, Tablets & SIMs | Mobile Phone Deals | EE Shop";
		

		
		pts.verifyTitle(eTitle);
		
		pts.verifyElement(pts.getLoginShop());
		
		Thread.sleep(5000);
		
		pts.getLoginShop().click();
		
		
		/*
		//
		//Operations on MyEEloginPage
		//
		*/
		
		
		MyEEloginPage ml=new MyEEloginPage(driver);
		
		
		
		ml.myloginpageOperations(MyEEloginTitle, un, pw);
		
		
		/*
		//
		//Operations on HomepageMyShopEE
		//
		*/
		
		HomepageMyShopEEPage hps=new HomepageMyShopEEPage(driver);
		
		String homePageShopTitle="Homepage | My Shop | EE";
		
		hps.verifyTitle(homePageShopTitle);
		
		hps.verifyElement(hps.getSeeUpgradeOptionsShop());
		
		hps.getSeeUpgradeOptionsShop().click();
		
		
		
		
		
		/*
		//
		//Operations on Recommendations | Upgrade | EE
		//
		*/
		
		
		RecommendationsUpgradeEEPage ru=new RecommendationsUpgradeEEPage(driver);
		
		
		ru.verifyTitle(recommenadtionsTitle);
		
		
		
		JavascriptExecutor js1= (JavascriptExecutor)driver;
		
		js1.executeScript("scroll(0,600)");
		
		//Screenshot
        File srcFile1 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

        //FileUtils.copyFile(srcFile1,new File("D:\\Users\\Default User\\Desktop\\screenshots\\Relevancy rules\\Recommendedproduct for "+ctn+".png"));
		
        FileUtils.copyFile(srcFile1,new File("D:\\Users\\Default User\\Desktop\\screenshots\\Relevancy rules\\Recommendedproduct for "+ctn+"\\Login_"+i+".png"));
        
		//GenericUtils.getScreenShot(driver,"Relevance rules Login : "+i);
        
        ru.verifyElement(ru.getRecommendeProductName());
		
		String nameoftheproduct=ru.getRecommendeProductName().getText();
		
		Reporter.log("LOGIN : "+i+" "+nameoftheproduct, true);
		
		
		
		if (i==1)
		{
		workbook.getSheetAt(sheetNum1).getRow(rownum1).createCell(17).setCellValue(ru.getRecommendeProductName().getText());
		login1=ru.getRecommendeProductName().getText();
		}
		else if (i==2)
		{
		workbook.getSheetAt(sheetNum1).getRow(rownum1).createCell(18).setCellValue(ru.getRecommendeProductName().getText());
		login2=ru.getRecommendeProductName().getText();
		}
		
		else if (i==3)
		{
		workbook.getSheetAt(sheetNum1).getRow(rownum1).createCell(19).setCellValue(ru.getRecommendeProductName().getText());
		login3=ru.getRecommendeProductName().getText();
		}
		
		else if (i==4)
		{
		workbook.getSheetAt(sheetNum1).getRow(rownum1).createCell(20).setCellValue(ru.getRecommendeProductName().getText());
		login4=ru.getRecommendeProductName().getText();
		}
		
		
		
		// for storing the output
		
	  	
	  	driver.close();
	  	
	  	
		}
		
		int count =0;
	  	
	  	for(int o=1;o==1;o++)
	  	{
	  		if(login1.equalsIgnoreCase(login2))
	  		//if(login1==login2)
	  		{
	  			count++;
	  			Reporter.log("**1==2**"+count, true);
	  		}
	  		
	  		if(login1.equalsIgnoreCase(login3))
	  		{
	  			count++;
	  			Reporter.log("**1==3**"+count, true);
	  		}
	  		if(login1.equalsIgnoreCase(login4))
	  		{
	  			count++;
	  			Reporter.log("**1==4**"+count, true);
	  		}
	  		
	  		Dataprovider.defaultValues1(workbook);
	  		
	  		if(count!=0)
	  		{
	  			if(count<3)
	  			{
	  				Reporter.log("*****"+count, true);
	  				Reporter.log("SUCCESS", true);
	  				workbook.getSheetAt(sheetNum1).getRow(rownum1).createCell(21).setCellValue("SUCCESS");
	  				Dataprovider.defaultValues1(workbook);
	  			}
	  		
	  			if(count==3)
	  			{
	  				Reporter.log("*****"+count, true);
	  				Reporter.log("FAIL", true);
	  				workbook.getSheetAt(sheetNum1).getRow(rownum1).createCell(21).setCellValue("FAIL");
	  				Dataprovider.defaultValues1(workbook);
	  				Assert.fail();
	  			}
	  		}
	  		
	  		
	  	}
	  	
	  	Dataprovider.defaultValues1(workbook);

	}

}
