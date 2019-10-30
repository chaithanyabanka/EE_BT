package com.Descisioning.tests;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Reporter;
import org.testng.annotations.Test;
import com.Descisioning.generics.BaseTest;

import com.DigitalMyEE.pages.HomepageMyShopEEPage;
import com.DigitalMyEE.pages.MyEEloginPage;
import com.DigitalMyEE.pages.PhonesTabletsSIMsPage;
import com.DigitalMyEE.pages.RecommendationsUpgradeEEPage;

import junit.framework.Assert;

public class UpgradeRecommendations extends BaseTest
{
	
	//
	//TEST METHOD FOR UPGRADE Recommendations [PAYM CUSTOMERS]
	//
	
	@Test(groups = { "SHOP" },enabled=false,dataProvider="standardUpgradeCTNs_PAYM",dataProviderClass=Dataprovider.class)
	public void upgradeRecommendations_StandardUpgrade_PAYM_SHOP(String dummy,String rownum,String upgradeStatus,String ctn,String un,String pw,String sheetNum ) throws IOException, InterruptedException, AWTException
	{
		int sheetNum1=Integer.parseInt(sheetNum);
		int rownum1 = Integer.parseInt(rownum);
		Reporter.log("***RUNNING upgradeRecommendations_StandardUpgrade_PAYM_SHOP***", true);
		
		Reporter.log(upgradeStatus + " "+ ctn +" "+""+un, true);
		
		
		driver.get(urlForSHOP);
		
		XSSFWorkbook workbook=Dataprovider.defaultValues();
		
		String MyEEloginTitle=workbook.getSheetAt(0).getRow(1).getCell(0).getStringCellValue();
		
		String recommenadtionsTitle=workbook.getSheetAt(0).getRow(1).getCell(3).getStringCellValue();
		
		String expectedResult=workbook.getSheetAt(sheetNum1).getRow(rownum1).getCell(7).getStringCellValue();
		
		Reporter.log("expecetd result :  " +expectedResult, true);
		
		
		
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
		
		JavascriptExecutor js= (JavascriptExecutor)driver;
		
		js.executeScript("scroll(0,600)");
		
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

	    FileUtils.copyFile(srcFile,new File("D:\\Users\\Default User\\Desktop\\screenshots\\Upgrade Recommendations\\Recommendedproduct for "+ctn+".png"));
			
		
		ru.verifyElement(ru.getRecommendeProductName());
		
		
		
		
		String nameoftheproduct=ru.getRecommendeProductName().getText();
		
		//GenericUtils.getScreenShot(driver,"Recommended Product ");
		
		Reporter.log(nameoftheproduct, true);
		
		
		
		workbook.getSheetAt(sheetNum1).getRow(rownum1).createCell(8).setCellValue(ru.getRecommendeProductName().getText());
		
		// for storing the output
		Dataprovider.defaultValues1(workbook);
		
		Thread.sleep(5000);
		
		int countforExpected=0;
		

		if(expectedResult.equalsIgnoreCase(nameoftheproduct));
		{
			expectedResult.compareTo(nameoftheproduct);
			
			if(expectedResult.contentEquals(nameoftheproduct))
			{	
			countforExpected++;
			
			}
					
		}
		
		if(countforExpected>0)
		{
			
			workbook.getSheetAt(sheetNum1).getRow(rownum1).createCell(9).setCellValue("PASS");
			Reporter.log("PASS", true);
			Dataprovider.defaultValues1(workbook);
		}
		else
		{
			workbook.getSheetAt(sheetNum1).getRow(rownum1).createCell(9).setCellValue("FAIL");
			Dataprovider.defaultValues1(workbook);
			Reporter.log("FAIL", true);
			Assert.fail();
		}

		
			
	
		
	}
	
	
	

	@Test(groups = { "SHOP" },enabled=false,dataProvider="earlyUpgradeCTNs_PAYM",dataProviderClass=Dataprovider.class)
	public void upgradeRecommendations_EarlyUpgrade_PAYM_SHOP(String dummy,String rownum,String upgradeStatus,String ctn,String un,String pw,String sheetNum ) throws IOException, InterruptedException, AWTException
	{
		int sheetNum1=Integer.parseInt(sheetNum);
		int rownum1 = Integer.parseInt(rownum);
		Reporter.log("***RUNNING upgradeRecommendations_EarlyUpgrade_PAYM_PAYM_SHOP***", true);
		
		Reporter.log(upgradeStatus + " "+ ctn +" "+""+un, true);
		
		
		driver.get(urlForSHOP);
		
		XSSFWorkbook workbook=Dataprovider.defaultValues();
		
		String MyEEloginTitle=workbook.getSheetAt(0).getRow(1).getCell(0).getStringCellValue();
		
		String recommenadtionsTitle=workbook.getSheetAt(0).getRow(1).getCell(3).getStringCellValue();
		
		String expectedResult=workbook.getSheetAt(sheetNum1).getRow(rownum1).getCell(7).getStringCellValue();
		
		Reporter.log("expecetd result :  " +expectedResult, true);
		
		
		
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
		
		 JavascriptExecutor js= (JavascriptExecutor)driver;
			
			js.executeScript("scroll(0,600)");
			

			 File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

		     FileUtils.copyFile(srcFile,new File("D:\\Users\\Default User\\Desktop\\screenshots\\Upgrade Recommendations\\Recommendedproduct for "+ctn+".png"));
				
		
		ru.verifyElement(ru.getRecommendeProductName());
		
		
		
		String nameoftheproduct=ru.getRecommendeProductName().getText();
		
		
		
		Reporter.log(nameoftheproduct, true);
		
		
		
		workbook.getSheetAt(sheetNum1).getRow(rownum1).createCell(8).setCellValue(ru.getRecommendeProductName().getText());
		
		// for storing the output
		Dataprovider.defaultValues1(workbook);
		
		Thread.sleep(5000);
		
		int countforExpected=0;
		

		if(expectedResult.equalsIgnoreCase(nameoftheproduct));
		{
			expectedResult.compareTo(nameoftheproduct);
			
			if(expectedResult.contentEquals(nameoftheproduct))
			{	
			countforExpected++;
			
			}
					
		}
		
		if(countforExpected>0)
		{
			
			workbook.getSheetAt(sheetNum1).getRow(rownum1).createCell(9).setCellValue("PASS");
			Reporter.log("PASS", true);
			Dataprovider.defaultValues1(workbook);
		}
		else
		{
			workbook.getSheetAt(sheetNum1).getRow(rownum1).createCell(9).setCellValue("FAIL");
			Dataprovider.defaultValues1(workbook);
			Reporter.log("FAIL", true);
			Assert.fail();
		}

		
			
	
		
	}

	
	//
	//TEST METHOD FOR UPGRADE Recommendations [SIMO CUSTOMERS]
	//
	
	@Test(groups = { "SHOP" },dataProvider="standardUpgradeCTNs_SIMO",dataProviderClass=Dataprovider.class)
	public void upgradeRecommendations_StandardUpgrade_SIMO_SHOP(String dummy,String rownum,String upgradeStatus,String ctn,String un,String pw,String sheetNum) throws IOException, InterruptedException, AWTException
	{
		int sheetNum1=Integer.parseInt(sheetNum);
		int rownum1 = Integer.parseInt(rownum);
		Reporter.log("***RUNNING upgradeRecommendations_StandardUpgrade_SIMO_SHOP***", true);
		
		Reporter.log(upgradeStatus + " "+ ctn +" "+""+un, true);
		
		driver.get(urlForSHOP);
		
		XSSFWorkbook workbook=Dataprovider.defaultValues();
		
		String MyEEloginTitle=workbook.getSheetAt(0).getRow(1).getCell(0).getStringCellValue();
		
		String recommenadtionsTitle=workbook.getSheetAt(0).getRow(1).getCell(3).getStringCellValue();
		
		String expectedResult=workbook.getSheetAt(sheetNum1).getRow(rownum1).getCell(7).getStringCellValue();

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
		
		
		/*
		//
		//Operations on Recommendations | Upgrade | EE
		//
		*/
		
		RecommendationsUpgradeEEPage ru=new RecommendationsUpgradeEEPage(driver);
		
		
		ru.verifyTitle(recommenadtionsTitle);
		
		//ru.verifyElement(ru.getRecommendeProductName());
		
		//String nameoftheproduct=ru.getRecommendeProductName().getText();
		
		
		
		//Reporter.log(nameoftheproduct, true);
		
		
		ru.verifyElement(ru.getMoveTOSIMO());
		
		ru.getMoveTOSIMO().click();
		
		Thread.sleep(3000);
		
		Robot rb=new Robot();
		
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_R);
		
		rb.keyRelease(KeyEvent.VK_R);
		rb.keyRelease(KeyEvent.VK_CONTROL);
		
		Thread.sleep(3000);
		
		ru.verifyElement(ru.getHeaderSIMO());
		
		JavascriptExecutor js= (JavascriptExecutor)driver;
		
		js.executeScript("scroll(0,600)");
		
		 File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

	     FileUtils.copyFile(srcFile,new File("D:\\Users\\Default User\\Desktop\\screenshots\\Upgrade Recommendations\\Recommended plans for "+ctn+".png"));
		
		
		//
		//
		//
		ru.verifyElement(ru.getSimoPLAN1());
		
		
		
		
		
		//ru.verifyElement(ru.getSoc1());
		
		String soc1=ru.getSoc1().getAttribute("value");
		
		Reporter.log(soc1, true);
		
		workbook.getSheetAt(sheetNum1).getRow(rownum1).createCell(8).setCellValue(soc1);
		
		//workbook.getSheetAt(2).getRow(rownum1).createCell(8).setCellValue(ru.getSimoPLAN1().getText());
		
		//
		//
		//
		ru.verifyElement(ru.getSimoPLAN2());
		
		//ru.verifyElement(ru.getSoc2());
		
		String soc2=ru.getSoc2().getAttribute("value");
		
		Reporter.log(soc2, true);
		
		
		workbook.getSheetAt(sheetNum1).getRow(rownum1).createCell(9).setCellValue(soc2);
		
		//workbook.getSheetAt(2).getRow(rownum1).createCell(9).setCellValue(ru.getSimoPLAN2().getText());
		
		//
		//
		//
		ru.verifyElement(ru.getSimoPLAN3());
		
		//ru.verifyElement(ru.getSoc3());
		
		String soc3=ru.getSoc3().getAttribute("value");
		
		Reporter.log(soc3, true);
		
		workbook.getSheetAt(2).getRow(rownum1).createCell(10).setCellValue(soc3);
		
		//workbook.getSheetAt(2).getRow(rownum1).createCell(10).setCellValue(ru.getSimoPLAN3().getText());
		
		//
		//
		//
		ru.verifyElement(ru.getSimoPLAN4());
		
		//ru.verifyElement(ru.getSoc4());
		
		String soc4=ru.getSoc4().getAttribute("value");
		
		Reporter.log(soc4, true);
		
		workbook.getSheetAt(sheetNum1).getRow(rownum1).createCell(11).setCellValue(soc4);
		
		//workbook.getSheetAt(2).getRow(rownum1).createCell(11).setCellValue(ru.getSimoPLAN4().getText());
		
		Thread.sleep(5000);
		
		
		ru.verifyElement(ru.getclickOnRight());
		
		ru.getclickOnRight().click();
		
		//
		//
		//
		ru.verifyElement(ru.getSimoPLAN5());
		
		//ru.verifyElement(ru.getSoc5());
		
		String soc5=ru.getSoc5().getAttribute("value");
		
		Reporter.log(soc5, true);
		
		workbook.getSheetAt(sheetNum1).getRow(rownum1).createCell(12).setCellValue(soc5);
		
		//workbook.getSheetAt(2).getRow(rownum1).createCell(12).setCellValue(ru.getSimoPLAN5().getText());
			
		
		// for storing the output
		Dataprovider.defaultValues1(workbook);
		
		int countforExpected=0;
		
		Thread.sleep(5000);
		
		for(int i=0;i==0;i++)
		{
			if(expectedResult.contentEquals(soc1))
			{
				countforExpected++;
				Reporter.log("if soc1 is expected:"+countforExpected, true);
			}
			else if(expectedResult.contentEquals(soc2))
			{
				countforExpected++;
				Reporter.log("if soc2 is expected:"+countforExpected, true);
			}
			else if(expectedResult.contentEquals(soc3))
			{
				countforExpected++;
				Reporter.log("if soc3 is expected:"+countforExpected, true);
			}
		
			else if(expectedResult.contentEquals(soc4))
			{
				countforExpected++;
				Reporter.log("if soc4 is expected:"+countforExpected, true);
			}
		
			else if(expectedResult.contentEquals(soc5))
			{
				countforExpected++;
				Reporter.log("if soc5 is expected:"+countforExpected, true);
			}
		}
		
		Thread.sleep(5000);
		
		if(countforExpected>0)
		{
			Reporter.log("total count of soc "+countforExpected, true);
			
			workbook.getSheetAt(sheetNum1).getRow(rownum1).createCell(13).setCellValue("PASS");
			
			// for storing the output
			Dataprovider.defaultValues1(workbook);
			Reporter.log("PASS", true);
		}
		else
		{
			Reporter.log("total count of soc "+countforExpected, true);
			workbook.getSheetAt(sheetNum1).getRow(rownum1).createCell(13).setCellValue("FAIL");
			
			// for storing the output
			Dataprovider.defaultValues1(workbook);
			Reporter.log("FAIL", true);
			Assert.fail();
		}
		
		
	}
	
	
	
	
	

	//
	//TEST METHOD FOR UPGRADE Recommendations [SIMO_EarlyUpgrade CUSTOMERS]
	//
	
	@Test(groups = { "SHOP" },dataProvider="earlyUpgradeCTNs_SIMO",dataProviderClass=Dataprovider.class)
	public void upgradeRecommendations_EarlyUpgrade_SIMO_SHOP(String dummy,String rownum,String upgradeStatus,String ctn,String un,String pw,String sheetNum) throws IOException, InterruptedException, AWTException
	{
		int sheetNum1=Integer.parseInt(sheetNum);
		int rownum1 = Integer.parseInt(rownum);
		Reporter.log("***RUNNING upgradeRecommendations_EarlyUpgrade_SIMO_SHOP***", true);
		
		Reporter.log(upgradeStatus + " "+ ctn +" "+""+un, true);
		
		driver.get(urlForSHOP);
		
		XSSFWorkbook workbook=Dataprovider.defaultValues();
		
		String MyEEloginTitle=workbook.getSheetAt(0).getRow(1).getCell(0).getStringCellValue();
		
		String recommenadtionsTitle=workbook.getSheetAt(0).getRow(1).getCell(3).getStringCellValue();
		
		String expectedResult=workbook.getSheetAt(sheetNum1).getRow(rownum1).getCell(7).getStringCellValue();

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
		
		
		/*
		//
		//Operations on Recommendations | Upgrade | EE
		//
		*/
		
		RecommendationsUpgradeEEPage ru=new RecommendationsUpgradeEEPage(driver);
		
		
		ru.verifyTitle(recommenadtionsTitle);
		
		//ru.verifyElement(ru.getRecommendeProductName());
		
		//String nameoftheproduct=ru.getRecommendeProductName().getText();
		
		//GenericUtils.getScreenShot(driver,"Recommended Plan ");
		
		//Reporter.log(nameoftheproduct, true);
		
		
		ru.verifyElement(ru.getMoveTOSIMO());
		
		ru.getMoveTOSIMO().click();
		
		Thread.sleep(3000);
		
		Robot rb=new Robot();
		
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_R);
		
		rb.keyRelease(KeyEvent.VK_R);
		rb.keyRelease(KeyEvent.VK_CONTROL);
		
		Thread.sleep(3000);
		
		ru.verifyElement(ru.getHeaderSIMO());
		
		

		JavascriptExecutor js= (JavascriptExecutor)driver;
		
		js.executeScript("scroll(0,600)");
		
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

	     FileUtils.copyFile(srcFile,new File("D:\\Users\\Default User\\Desktop\\screenshots\\Upgrade Recommendations\\Recommended plans for "+ctn+".png"));
			
	     //
			//
			//
			ru.verifyElement(ru.getSimoPLAN1());
		
		//ru.verifyElement(ru.getSoc1());
		
		String soc1=ru.getSoc1().getAttribute("value");
		
		Reporter.log(soc1, true);
		
		workbook.getSheetAt(sheetNum1).getRow(rownum1).createCell(8).setCellValue(soc1);
		
		//workbook.getSheetAt(2).getRow(rownum1).createCell(8).setCellValue(ru.getSimoPLAN1().getText());
		
		//
		//
		//
		ru.verifyElement(ru.getSimoPLAN2());
		
		//ru.verifyElement(ru.getSoc2());
		
		String soc2=ru.getSoc2().getAttribute("value");
		
		Reporter.log(soc2, true);
		
		
		workbook.getSheetAt(sheetNum1).getRow(rownum1).createCell(9).setCellValue(soc2);
		
		//workbook.getSheetAt(2).getRow(rownum1).createCell(9).setCellValue(ru.getSimoPLAN2().getText());
		
		//
		//
		//
		ru.verifyElement(ru.getSimoPLAN3());
		
		//ru.verifyElement(ru.getSoc3());
		
		String soc3=ru.getSoc3().getAttribute("value");
		
		Reporter.log(soc3, true);
		
		workbook.getSheetAt(2).getRow(rownum1).createCell(10).setCellValue(soc3);
		
		//workbook.getSheetAt(2).getRow(rownum1).createCell(10).setCellValue(ru.getSimoPLAN3().getText());
		
		//
		//
		//
		ru.verifyElement(ru.getSimoPLAN4());
		
		//ru.verifyElement(ru.getSoc4());
		
		String soc4=ru.getSoc4().getAttribute("value");
		
		Reporter.log(soc4, true);
		
		workbook.getSheetAt(sheetNum1).getRow(rownum1).createCell(11).setCellValue(soc4);
		
		//workbook.getSheetAt(2).getRow(rownum1).createCell(11).setCellValue(ru.getSimoPLAN4().getText());
		
		Thread.sleep(5000);
		
		
		ru.verifyElement(ru.getclickOnRight());
		
		ru.getclickOnRight().click();
		
		//
		//
		//
		ru.verifyElement(ru.getSimoPLAN5());
		
		//ru.verifyElement(ru.getSoc5());
		
		String soc5=ru.getSoc5().getAttribute("value");
		
		Reporter.log(soc5, true);
		
		workbook.getSheetAt(sheetNum1).getRow(rownum1).createCell(12).setCellValue(soc5);
		
		//workbook.getSheetAt(2).getRow(rownum1).createCell(12).setCellValue(ru.getSimoPLAN5().getText());
			
		
		// for storing the output
		Dataprovider.defaultValues1(workbook);
		
		int countforExpected=0;
		
		Thread.sleep(5000);
		
		for(int i=0;i==0;i++)
		{
			if(expectedResult.contentEquals(soc1))
			{
				countforExpected++;
				Reporter.log("if soc1 is expected:"+countforExpected, true);
			}
			else if(expectedResult.contentEquals(soc2))
			{
				countforExpected++;
				Reporter.log("if soc2 is expected:"+countforExpected, true);
			}
			else if(expectedResult.contentEquals(soc3))
			{
				countforExpected++;
				Reporter.log("if soc3 is expected:"+countforExpected, true);
			}
		
			else if(expectedResult.contentEquals(soc4))
			{
				countforExpected++;
				Reporter.log("if soc4 is expected:"+countforExpected, true);
			}
		
			else if(expectedResult.contentEquals(soc5))
			{
				countforExpected++;
				Reporter.log("if soc5 is expected:"+countforExpected, true);
			}
		}
		
		Thread.sleep(5000);
		
		if(countforExpected>0)
		{
			Reporter.log("total count of soc "+countforExpected, true);
			
			workbook.getSheetAt(sheetNum1).getRow(rownum1).createCell(13).setCellValue("PASS");
			
			// for storing the output
			Dataprovider.defaultValues1(workbook);
			Reporter.log("PASS", true);
		}
		else
		{
			Reporter.log("total count of soc "+countforExpected, true);
			workbook.getSheetAt(sheetNum1).getRow(rownum1).createCell(13).setCellValue("FAIL");
			
			// for storing the output
			Dataprovider.defaultValues1(workbook);
			Reporter.log("FAIL", true);
			Assert.fail();
		}
		
		
	}
	

}
