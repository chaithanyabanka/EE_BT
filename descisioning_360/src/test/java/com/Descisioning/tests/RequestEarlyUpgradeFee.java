package com.Descisioning.tests;

import java.awt.AWTException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import com.Descisioning.generics.BaseTest;
import com.DigitalMyEE.pages.HomepageMyShopEEPage;
import com.DigitalMyEE.pages.MyEEPAYMLandingPage;
import com.DigitalMyEE.pages.MyEEUpgradesPage;
import com.DigitalMyEE.pages.MyEEloginPage;
import com.DigitalMyEE.pages.PhonesTabletsSIMsPage;
import com.DigitalMyEE.pages.RecommendationsUpgradeEEPage;

public class RequestEarlyUpgradeFee extends BaseTest 
{
	
	@Test(groups = { "WEB" },dataProvider="earlyUpgradeCTNs_PAYM",dataProviderClass=Dataprovider.class)
	public void earlyUpgradeFee_PAYM_WEB(String dummy,String rownum,String upgradeStatus,String ctn,String un,String pw,String sheetNum) throws IOException, InterruptedException, AWTException
	{  
		int sheetNum1=Integer.parseInt(sheetNum);
		int rownum1 = Integer.parseInt(rownum);
		driver.get(urlForWEB);
		
		Reporter.log("",true);
		
		System.out.println("***RUNNING earluUpgradeFee***");
		
		//System.out.println(MyEEloginTitle + " "+ MyEETitle +" "+""+myUpgradesTitle+" "+""+recommenadtionsTitle);
			
		System.out.println(upgradeStatus + " "+ ctn +" "+""+un);
		
		
		
		String file_path="C:\\Users\\cbanka\\eclipse-workspace\\descisioning_360\\Data sheet.xlsx";
		
		FileInputStream fis=new FileInputStream(file_path);
		
		
		
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		

		String MyEEloginTitle=workbook.getSheetAt(0).getRow(1).getCell(0).getStringCellValue();
		
		String MyEETitle=workbook.getSheetAt(0).getRow(1).getCell(1).getStringCellValue();
		
		String myUpgradesTitle=workbook.getSheetAt(0).getRow(1).getCell(2).getStringCellValue();
		
		String recommenadtionsTitle=workbook.getSheetAt(0).getRow(1).getCell(3).getStringCellValue();
		
		
		
		
		/*
		//
		//Operations on MyEElogin page
		//
		*/
		
		MyEEloginPage ml=new MyEEloginPage(driver);
		
		
		ml.myloginpageOperations(MyEEloginTitle, un, pw);
		
		/*
		//	
		//Operations on MyEEPAYMLanding page
		//
		*/
		
		MyEEPAYMLandingPage mpl=new MyEEPAYMLandingPage(driver);
		
		//GenericUtils.getScreenShot(driver,"MyEEPAYMLanding");
		
	    mpl.verifyTheTitle(MyEETitle);
	    
		mpl.verifyElement(mpl.getSeeYourUpgradeOptions());
		
		//mpl.clickOnstartUpgrade();
		
		mpl.clickOnseeYourUpgradeOption();
		
		
		
		/*
		//
		//Operations on MyEEUpgrades page
		//
		*/
		
		MyEEUpgradesPage mu=new MyEEUpgradesPage(driver);
		
		mu.verifyTitle(myUpgradesTitle);
		
		mu.verifyElement(mu.getUpgradeNow());
		
		mu.clickOnUpgradeNow(mu.getUpgradeNow());
		
		
		
		/*
		//
		//Operations on Recommendations | Upgrade | EE
		//
		*/
		
		RecommendationsUpgradeEEPage ru=new RecommendationsUpgradeEEPage(driver);
		
		/*JavascriptExecutor js1= (JavascriptExecutor)driver;
		
		js1.executeScript("scroll(0,800)");
		
		
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

	    FileUtils.copyFile(srcFile,new File("D:\\Users\\Default User\\Desktop\\screenshots\\EUF\\Earlyupgradefee : "+ctn+".png"));
			*/
		
		
		
		ru.verifyTitle(recommenadtionsTitle);
		
		JavascriptExecutor js= (JavascriptExecutor)driver;
		
		js.executeScript("scroll(0,900)");
		
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

	     FileUtils.copyFile(srcFile,new File("D:\\Users\\Default User\\Desktop\\screenshots\\EUF\\EUF for "+ctn+".png"));
			
	
		
		
		try
		{
		ru.verifyElement(ru.getearlyUpgradeFee());
		

	
		
		}
		catch(Exception e)
		{
			Reporter.log("Early upgrade fee is not availbale", true);
			workbook.getSheetAt(sheetNum1).getRow(rownum1).createCell(23).setCellValue("No EUF");
			workbook.getSheetAt(sheetNum1).getRow(rownum1).createCell(24).setCellValue("FAIL");
			Dataprovider.defaultValues1(workbook);
			Assert.fail();
		}
		
	//	GenericUtils.getScreenShot(driver,"Early upgrade Fee");
		
		
		
		workbook.getSheetAt(sheetNum1).getRow(rownum1).createCell(23).setCellValue(ru.fetchEUF(ru.getearlyUpgradeFee()));
		
	//	Reporter.log("Early upgrade fee is :"+ru.getearlyUpgradeFee() , true);
		
		workbook.getSheetAt(sheetNum1).getRow(rownum1).createCell(24).setCellValue("PASS");
		
		Dataprovider.defaultValues1(workbook);
			
	}	
	
	
	
	
	@Test(groups = { "SHOP" },enabled=false,dataProvider="earlyUpgradeCTNs_SIMO",dataProviderClass=Dataprovider.class)
	public void earlyUpgradeFee_SIMO_Shop(String dummy,String rownum,String upgradeStatus,String ctn,String un,String pw,String sheetNum) throws IOException, InterruptedException, AWTException
	{ 
		
		int sheetNum1=Integer.parseInt(sheetNum);
		int rownum1 = Integer.parseInt(rownum);
		Reporter.log("***RUNNING earlyUpgradeFee_SIMO_Shop***", true);
		
		
		Reporter.log(upgradeStatus + " "+ ctn +" "+""+un, true);
		
		
		driver.get(urlForSHOP);
		
		XSSFWorkbook workbook=Dataprovider.defaultValues();
		
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
		
		
		//String MyEEloginTitle="My EE login";
		
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
		
		//SHOPpageOpeartions spo=new SHOPpageOpeartions(un,pw);	
		
		
		/*
		//
		//Operations on Recommendations | Upgrade | EE
		//
		*/
		
		RecommendationsUpgradeEEPage ru=new RecommendationsUpgradeEEPage(driver);
		
		
		ru.verifyTitle(recommenadtionsTitle);
		
		JavascriptExecutor js1= (JavascriptExecutor)driver;
		
		js1.executeScript("scroll(0,600)");
		
		
		
		
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

	    FileUtils.copyFile(srcFile,new File("D:\\Users\\Default User\\Desktop\\screenshots\\EUF\\Earlyupgradefee : "+ctn+".png"));
			
		
		ru.verifyElement(ru.getearlyUpgradeFee());
		
		//GenericUtils.getScreenShot(driver,"Early upgrade Fee");

		
		try
		{
		ru.verifyElement(ru.getearlyUpgradeFee());
		
		
		}
		catch(Exception e)
		{
			Reporter.log("Early upgrade fee is not availbale", true);
			workbook.getSheetAt(sheetNum1).getRow(rownum1).createCell(23).setCellValue("No EUF");
			workbook.getSheetAt(sheetNum1).getRow(rownum1).createCell(24).setCellValue("FAIL");
			Dataprovider.defaultValues1(workbook);
			Assert.fail();
		}
		
	//	GenericUtils.getScreenShot(driver,"Early upgrade Fee");
		
		
		
		workbook.getSheetAt(sheetNum1).getRow(rownum1).createCell(23).setCellValue(ru.fetchEUF(ru.getearlyUpgradeFee()));
		
		Reporter.log("Early upgrade fee is :"+ru.getearlyUpgradeFee() , true);
		
		workbook.getSheetAt(sheetNum1).getRow(rownum1).createCell(24).setCellValue("PASS");
		
		Dataprovider.defaultValues1(workbook);
			
		
		
		/*
		//*******************************************************************
		//NEED TO CHECK WITH SIMO CTN WHERE THE EUF WILL BE DISPLAYED
		//*******************************************************************
		*/	
		
		
		
		
	}
	
	
			
	}
	
