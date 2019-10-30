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

import com.DigitalMyEE.pages.MyEEPAYMLandingPage;
import com.DigitalMyEE.pages.MyEEUpgradesPage;
import com.DigitalMyEE.pages.MyEEloginPage;
import com.DigitalMyEE.pages.RecommendationsUpgradeEEPage;

import junit.framework.Assert;

public class AllowanceRules  extends BaseTest
{

	//
	//TEST METHOD FOR ALLOWANCE RULES [SIMO CUSTOMERS]
	//
	
	@Test(groups = { "WEB" },enabled=false,dataProvider="standardUpgradeCTNs_SIMO",dataProviderClass=Dataprovider.class)
	public void allowanceRules_StandardUpgrade_SIMO(String dummy,String rownum,String upgradeStatus,String ctn,String un,String pw, String sheetNum) throws IOException, InterruptedException, AWTException
	{ 
		int sheetNum1 = Integer.parseInt(sheetNum);
		int rownum1 = Integer.parseInt(rownum);
		
		driver.get(urlForWEB);
		
		Reporter.log("***RUNNING allowanceRulesSIMO***",true);
		
		Reporter.log(upgradeStatus + " "+ ctn +" "+""+un, true);
		XSSFWorkbook workbook=Dataprovider.defaultValues();
		

		String MyEEloginTitle=workbook.getSheetAt(0).getRow(1).getCell(0).getStringCellValue();
		
		String MyEETitle=workbook.getSheetAt(0).getRow(1).getCell(1).getStringCellValue();
		
		String myUpgradesTitle=workbook.getSheetAt(0).getRow(1).getCell(2).getStringCellValue();
		
		String recommenadtionsTitle=workbook.getSheetAt(0).getRow(1).getCell(3).getStringCellValue();
		

		//
		//Operations on MyEElogin page
		//
		
		MyEEloginPage ml=new MyEEloginPage(driver);
		
		
		ml.myloginpageOperations(MyEEloginTitle, un, pw);
		
		
		
		//	
		//Operations on MyEEPAYMLanding page
		//
		
		MyEEPAYMLandingPage mpl=new MyEEPAYMLandingPage(driver);
		
		
		
	    mpl.verifyTheTitle(MyEETitle);
	    
		mpl.verifyElement(mpl.getSeeYourUpgradeOptions());
		
		mpl.verifyElement(mpl.getCurrentplan());
		
		JavascriptExecutor js= (JavascriptExecutor)driver;
		
		js.executeScript("scroll(0,1000)");
		

		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

	    FileUtils.copyFile(srcFile,new File("D:\\Users\\Default User\\Desktop\\screenshots\\Allowance Rules\\Currentpaln : "+ctn+".png"));
		
	    //File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	    
	    

	    // FileUtils.copyFile(srcFile,new File("D:\\Users\\Default User\\Desktop\\screenshots\\EUF\\EUF for "+ctn+".png"));
		
		String currentPlan=mpl.getCurrentplan().getText();
		
		//GenericUtils.getScreenShot(driver,"Current dataplan ");
		
		Reporter.log("Current plan :"+currentPlan,true);
		
		
		
        int currentDATA= mpl.giveCurrentData(currentPlan,workbook,rownum1,sheetNum1);
        
        workbook.getSheetAt(sheetNum1).getRow(rownum1).createCell(21).setCellValue(currentDATA+"GB");
        
        
        int currentMRC= mpl.giveCurrentMrc( currentPlan,workbook, rownum1,sheetNum1);
        
        workbook.getSheetAt(sheetNum1).getRow(rownum1).createCell(15).setCellValue(currentMRC+"£");
        
        
        Dataprovider.defaultValues1(workbook);
       
		
        	mpl.clickOnseeYourUpgradeOption();		
		
		//
		//Operations on MyEEUpgrades page
		//
		
		MyEEUpgradesPage mu=new MyEEUpgradesPage(driver);
		
		mu.verifyTitle(myUpgradesTitle);
		
		mu.verifyElement(mu.getUpgradeNow());
		
		mu.clickOnUpgradeNow(mu.getUpgradeNow());    
		
		

		//
		//Operations on Recommendations | Upgrade | EE
		//
		
		RecommendationsUpgradeEEPage ru=new RecommendationsUpgradeEEPage(driver);
		
		ru.verifyTitle(recommenadtionsTitle);
		
		
		ru.verifyElement(ru.getMoveTOSIMO());
		
		Thread.sleep(3000);
		
		ru.getMoveTOSIMO().click();
		
		Thread.sleep(3000);
		
		Robot rb=new Robot();
		
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_R);
		
		rb.keyRelease(KeyEvent.VK_R);
		rb.keyRelease(KeyEvent.VK_CONTROL);
		
		Thread.sleep(3000);
		
		
		ru.verifyElement(ru.getHeaderSIMO());
	
		
		
		ru.verifyElement(ru.getSimoPLAN1());
		
		JavascriptExecutor js1= (JavascriptExecutor)driver;
		
		js1.executeScript("scroll(0,600)");
		
		//Screenshot
        File srcFile1 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

	    FileUtils.copyFile(srcFile1,new File("D:\\Users\\Default User\\Desktop\\screenshots\\Allowance Rules\\Recommendedpalns : "+ctn+".png"));
		
		
		
		String recommendedPlan1= ru.getSimoPLAN1().getText();
		
		int recommendedDATA1=ru.giveRecommendedData(recommendedPlan1, workbook, rownum1);
		
		 			workbook.getSheetAt(sheetNum1).getRow(rownum1).createCell(22).setCellValue(recommendedDATA1+"GB");
		
		int recommendedMRC1=ru.giveRecommendedMrc(recommendedPlan1, workbook, rownum1);
		
		   			workbook.getSheetAt(sheetNum1).getRow(rownum1).createCell(16).setCellValue(recommendedMRC1+"£");
		 
		
		Dataprovider.defaultValues1(workbook);
		
		
		ru.verifyElement(ru.getSimoPLAN2());
		
		String recommendedPlan2= ru.getSimoPLAN2().getText();
		
		int recommendedDATA2=ru.giveRecommendedData(recommendedPlan2, workbook, rownum1);
		
					workbook.getSheetAt(sheetNum1).getRow(rownum1).createCell(23).setCellValue(recommendedDATA2+"GB");
		
		int recommendedMRC2=ru.giveRecommendedMrc(recommendedPlan2, workbook, rownum1);
					
					workbook.getSheetAt(sheetNum1).getRow(rownum1).createCell(17).setCellValue(recommendedMRC2+"£");
		
		
		
		Dataprovider.defaultValues1(workbook);			
					
		
		ru.verifyElement(ru.getSimoPLAN3());
		
		String recommendedPlan3= ru.getSimoPLAN3().getText();
		
		int recommendedDATA3=ru.giveRecommendedData(recommendedPlan3, workbook, rownum1);
		
					workbook.getSheetAt(sheetNum1).getRow(rownum1).createCell(24).setCellValue(recommendedDATA3+"GB");
		
		int recommendedMRC3=ru.giveRecommendedMrc(recommendedPlan3, workbook, rownum1);
		
					workbook.getSheetAt(sheetNum1).getRow(rownum1).createCell(18).setCellValue(recommendedMRC3+"£");
					
					
		Dataprovider.defaultValues1(workbook);
		
		
		
		ru.verifyElement(ru.getSimoPLAN4());
		
		String recommendedPlan4= ru.getSimoPLAN4().getText();
		
		int recommendedDATA4=ru.giveRecommendedData(recommendedPlan4, workbook, rownum1);
		
					workbook.getSheetAt(sheetNum1).getRow(rownum1).createCell(25).setCellValue(recommendedDATA4+"GB");
		
		int recommendedMRC4=ru.giveRecommendedMrc(recommendedPlan4, workbook, rownum1);
		
					workbook.getSheetAt(sheetNum1).getRow(rownum1).createCell(19).setCellValue(recommendedMRC4+"£");
		
		
		Dataprovider.defaultValues1(workbook);
		
		Thread.sleep(4000);
		
		ru.verifyElement(ru.getclickOnRight());
		
		ru.getclickOnRight().click();
		
		Thread.sleep(4000);
		
		ru.verifyElement(ru.getSimoPLAN5());
		
		String recommendedPlan5= ru.getSimoPLAN5().getText();
		
		int recommendedDATA5=ru.giveRecommendedData(recommendedPlan5, workbook, rownum1);
		
					workbook.getSheetAt(sheetNum1).getRow(rownum1).createCell(26).setCellValue(recommendedDATA5+"GB");
		
		
		int recommendedMRC5=ru.giveRecommendedMrc(recommendedPlan5, workbook, rownum1);
		
					workbook.getSheetAt(sheetNum1).getRow(rownum1).createCell(20).setCellValue(recommendedMRC5+"£");
		
		
		Dataprovider.defaultValues1(workbook);
		
		if(currentDATA<recommendedDATA1 && currentDATA<recommendedDATA2 && currentDATA<recommendedDATA3 && currentDATA<recommendedDATA4 && currentDATA<recommendedDATA5 )
		{
			Reporter.log("Recommended DATA is Greater than Current DATA",true);
			if(recommendedMRC1>currentMRC && recommendedMRC2>currentMRC && recommendedMRC3>currentMRC && recommendedMRC4>currentMRC && recommendedMRC5>currentMRC)
			{
				Reporter.log("Recommended MRC is Greater than Current",true);
				workbook.getSheetAt(sheetNum1).getRow(rownum1).createCell(27).setCellValue("PASS");
				Dataprovider.defaultValues1(workbook);
				Reporter.log("PASS",true);
				
			}
			
			else
			{
				Reporter.log("Recommended MRC is LESSER than Current",true);
				workbook.getSheetAt(sheetNum1).getRow(rownum1).createCell(27).setCellValue("FAIL");
				Dataprovider.defaultValues1(workbook);
				Reporter.log("FAIL",true);
				Assert.fail();
				
			}
			
		}
		
		else
		{
			Reporter.log("Recommended DATA is LESSER than Current",true);
			workbook.getSheetAt(sheetNum1).getRow(rownum1).createCell(27).setCellValue("FAIL");
			Dataprovider.defaultValues1(workbook);
			Reporter.log("FAIL",true);
			Assert.fail();
			
		}
		
    }
        
		
		
		

		

	
	//
	//TEST METHOD FOR ALLOWANCE RULES [PAYM CUSTOMERS]
	//
	
	@Test(groups = { "WEB" },dataProvider="earlyUpgradeCTNs_PAYM",dataProviderClass=Dataprovider.class)
	public void allowanceRules_Earlyupgrade_PAYM(String dummy,String rownum,String upgradeStatus,String ctn,String un,String pw, String sheetNum) throws IOException, InterruptedException, AWTException
	
	{ 
		int sheetNum1 = Integer.parseInt(sheetNum);
		int rownum1 = Integer.parseInt(rownum);
		Reporter.log("***RUNNING allowanceRulesPAYM***",true);
		Reporter.log(upgradeStatus + " "+ ctn +" "+""+un, true);
		driver.get(urlForWEB);
		Reporter.log("",true);
		
		
		XSSFWorkbook workbook=Dataprovider.defaultValues();
		

		String MyEEloginTitle=workbook.getSheetAt(0).getRow(1).getCell(0).getStringCellValue();
		
		String MyEETitle=workbook.getSheetAt(0).getRow(1).getCell(1).getStringCellValue();
		
		String myUpgradesTitle=workbook.getSheetAt(0).getRow(1).getCell(2).getStringCellValue();
		
		String recommenadtionsTitle=workbook.getSheetAt(0).getRow(1).getCell(3).getStringCellValue();
		
		

		//
		//Operations on MyEElogin page
		//
		
		MyEEloginPage ml=new MyEEloginPage(driver);
		
		//GenericUtils.getScreenShot(driver,"MyEElogin");
		
		ml.myloginpageOperations(MyEEloginTitle, un, pw);
		
		
		
		//	
		//Operations on MyEEPAYMLanding page
		//
		
		MyEEPAYMLandingPage mpl=new MyEEPAYMLandingPage(driver);
		
		
		
	    mpl.verifyTheTitle(MyEETitle);
	    
		mpl.verifyElement(mpl.getSeeYourUpgradeOptions());
		
		mpl.verifyElement(mpl.getCurrentplan());
		
		//To bottom of the page
		JavascriptExecutor js= (JavascriptExecutor)driver;
		
		js.executeScript("scroll(0,1000)");
		
		//Screenshot
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

	    //FileUtils.copyFile(srcFile,new File("D:\\Users\\Default User\\Desktop\\screenshots\\Allowance Rules\\Currentpaln : "+ctn+".png"));
		
		String currentPlan=mpl.getCurrentplan().getText();
		
		//File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

	     FileUtils.copyFile(srcFile,new File("D:\\Users\\Default User\\Desktop\\screenshots\\Allowance Rules\\Currentpaln : "+ctn+".png"));
		
		Reporter.log("Current plan :"+currentPlan,true);
		
		
		
		
		
        int currentDATA= mpl.giveCurrentData(currentPlan,workbook,rownum1,sheetNum1);
        
    	workbook.getSheetAt(sheetNum1).getRow(rownum1).createCell(12).setCellValue(currentDATA+"GB");
    	
        int currentMRC= mpl.giveCurrentMrc( currentPlan,workbook, rownum1,sheetNum1);
		
    	workbook.getSheetAt(sheetNum1).getRow(rownum1).createCell(11).setCellValue(currentMRC+"£");
    	
    	
		Dataprovider.defaultValues1(workbook);
			
		mpl.clickOnseeYourUpgradeOption();
		
		
		//
		//Operations on MyEEUpgrades page
		//
		
		MyEEUpgradesPage mu=new MyEEUpgradesPage(driver);
		
		mu.verifyTitle(myUpgradesTitle);
		
		mu.verifyElement(mu.getUpgradeNow());
		
		mu.clickOnUpgradeNow(mu.getUpgradeNow());
		
		

		//
		//Operations on Recommendations | Upgrade | EE
		//
		
		RecommendationsUpgradeEEPage ru=new RecommendationsUpgradeEEPage(driver);
		
		
		ru.verifyTheTitle(recommenadtionsTitle);
		
		
		ru.verifyElement(ru.getDataForRecommendedplan());
		
		String recommendedDataPlan=ru.getDataForRecommendedplan().getText();
		
		ru.verifyElement(ru.getRecommendeProductName());
		
		JavascriptExecutor js1= (JavascriptExecutor)driver;
		
		js1.executeScript("scroll(0,600)");
		
		//Screenshot
        File srcFile1 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

	    FileUtils.copyFile(srcFile1,new File("D:\\Users\\Default User\\Desktop\\screenshots\\Recommendedproduct : "+ctn+".png"));
		
		
		
		String nameoftheproduct=ru.getRecommendeProductName().getText();
		
		Reporter.log(nameoftheproduct,true);
		
		
		int recommendedDATA=ru.giveRecommendedData(recommendedDataPlan,workbook,rownum1);
		
		workbook.getSheetAt(sheetNum1).getRow(rownum1).createCell(14).setCellValue(recommendedDATA+"GB");
		
		int recommendedMRC=ru.giveRecommendedMrc(recommendedDataPlan, workbook, rownum1);
		
		workbook.getSheetAt(sheetNum1).getRow(rownum1).createCell(13).setCellValue(recommendedMRC+"£");
		
		Dataprovider.defaultValues1(workbook);
		
		Thread.sleep(5000);
		
		if(recommendedDATA>currentDATA)
		{
			Reporter.log("Recommended DATA is Greater than Current",true);
			if(recommendedMRC>currentMRC)
			{
			Reporter.log("Recommended MRC is Greater than Current",true);
			workbook.getSheetAt(sheetNum1).getRow(rownum1).createCell(15).setCellValue("PASS");
			Dataprovider.defaultValues1(workbook);
			}
			else
			{
				Reporter.log("Recommended MRC is LESSER than Current",true);
				workbook.getSheetAt(sheetNum1).getRow(rownum1).createCell(15).setCellValue("FAIL");
				Dataprovider.defaultValues1(workbook);
				Assert.fail();
			}
			
		}
		else
		{
			Reporter.log("Recommended DATA is LESSER than Current",true);
			workbook.getSheetAt(sheetNum1).getRow(rownum1).createCell(15).setCellValue("FAIL");
			Dataprovider.defaultValues1(workbook);
			Assert.fail();
		}
		
		
		
		
	}
	
	
	
	
	
	@Test(groups = { "WEB" },dataProvider="standardUpgradeCTNs_PAYM",dataProviderClass=Dataprovider.class)
	public void allowanceRules_StandardUpgrade_PAYM(String dummy,String rownum,String upgradeStatus,String ctn,String un,String pw, String sheetNum) throws IOException, InterruptedException, AWTException
	
	{ 
		int sheetNum1 = Integer.parseInt(sheetNum);
		
		int rownum1 = Integer.parseInt(rownum);
		
		Reporter.log("***RUNNING allowanceRulesPAYM***",true);
		Reporter.log(upgradeStatus + " "+ ctn +" "+""+un, true);
		driver.get(urlForWEB);
		
		Thread.sleep(5000);
		
		Robot rb=new Robot();
		
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_R);
		
		rb.keyRelease(KeyEvent.VK_R);
		rb.keyRelease(KeyEvent.VK_CONTROL);
		
		
		XSSFWorkbook workbook=Dataprovider.defaultValues();
		

		String MyEEloginTitle=workbook.getSheetAt(0).getRow(1).getCell(0).getStringCellValue();
		
		String MyEETitle=workbook.getSheetAt(0).getRow(1).getCell(1).getStringCellValue();
		
		String myUpgradesTitle=workbook.getSheetAt(0).getRow(1).getCell(2).getStringCellValue();
		
		String recommenadtionsTitle=workbook.getSheetAt(0).getRow(1).getCell(3).getStringCellValue();
		
		

		//
		//Operations on MyEElogin page
		//
		
		MyEEloginPage ml=new MyEEloginPage(driver);
		
		//GenericUtils.getScreenShot(driver,"MyEElogin");
		
		ml.myloginpageOperations(MyEEloginTitle, un, pw);
		
		
		
		//	
		//Operations on MyEEPAYMLanding page
		//
		
		MyEEPAYMLandingPage mpl=new MyEEPAYMLandingPage(driver);
		
		//GenericUtils.getScreenShot(driver,"MyEEPAYMLanding");
		
	    mpl.verifyTheTitle(MyEETitle);
	    
		mpl.verifyElement(mpl.getSeeYourUpgradeOptions());
		
		mpl.verifyElement(mpl.getCurrentplan());
		
		JavascriptExecutor js= (JavascriptExecutor)driver;
		
		js.executeScript("scroll(0,1000)");
		
		//File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

	   // FileUtils.copyFile(srcFile,new File("D:\\Users\\Default User\\Desktop\\screenshots\\Allowance Rules\\Currentpaln : "+ctn+".png"));
		
		
	    File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

	     FileUtils.copyFile(srcFile,new File("D:\\Users\\Default User\\Desktop\\screenshots\\EUF\\EUF for "+ctn+".png"));
	    
	    
		String currentPlan=mpl.getCurrentplan().getText();
		
		//GenericUtils.getScreenShot(driver,"Current dataplan ");
		
		Reporter.log("Current plan :"+currentPlan,true);
		
		
		
		
		
        int currentDATA= mpl.giveCurrentData(currentPlan,workbook,rownum1,sheetNum1);
        
        workbook.getSheetAt(sheetNum1).getRow(rownum1).createCell(12).setCellValue(currentDATA+"GB");
        
        int currentMRC= mpl.giveCurrentMrc( currentPlan,workbook, rownum1,sheetNum1);
        
        
    	workbook.getSheetAt(sheetNum1).getRow(rownum1).createCell(11).setCellValue(currentMRC+"£");
		
		
		Dataprovider.defaultValues1(workbook);
			
		mpl.clickOnseeYourUpgradeOption();
		
		
		//
		//Operations on MyEEUpgrades page
		//
		
		MyEEUpgradesPage mu=new MyEEUpgradesPage(driver);
		
		mu.verifyTitle(myUpgradesTitle);
		
		mu.verifyElement(mu.getUpgradeNow());
		
		mu.clickOnUpgradeNow(mu.getUpgradeNow());
		
		

		//
		//Operations on Recommendations | Upgrade | EE
		//
		
		RecommendationsUpgradeEEPage ru=new RecommendationsUpgradeEEPage(driver);
		
		ru.verifyTitle(recommenadtionsTitle);
		
		
		ru.verifyElement(ru.getDataForRecommendedplan());
		
		String recommendedDataPlan=ru.getDataForRecommendedplan().getText();
		
		ru.verifyElement(ru.getRecommendeProductName());
		
		JavascriptExecutor js1= (JavascriptExecutor)driver;
		
		js1.executeScript("scroll(0,600)");
		
		//Screenshot
        File srcFile1 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

	    FileUtils.copyFile(srcFile1,new File("D:\\Users\\Default User\\Desktop\\screenshots\\Allowance Rules\\Recommendedproduct : "+ctn+".png"));
		
		
		//GenericUtils.getScreenShot(driver,"Recommended dataplan ");
		
		String nameoftheproduct=ru.getRecommendeProductName().getText();
		
		Reporter.log(nameoftheproduct,true);
		
		
		int recommendedDATA=ru.giveRecommendedData(recommendedDataPlan,workbook,rownum1);
		
		workbook.getSheetAt(sheetNum1).getRow(rownum1).createCell(14).setCellValue(recommendedDATA+"GB");
		
		int recommendedMRC=ru.giveRecommendedMrc(recommendedDataPlan, workbook, rownum1);
		
		workbook.getSheetAt(sheetNum1).getRow(rownum1).createCell(13).setCellValue(recommendedMRC+"£");
		
		Dataprovider.defaultValues1(workbook);
		
		Thread.sleep(5000);
		
		if(recommendedDATA>currentDATA)
		{
			Reporter.log("Recommended DATA is Greater than Current",true);
			if(recommendedMRC>currentMRC)
			{
			Reporter.log("Recommended MRC is Greater than Current",true);
			workbook.getSheetAt(sheetNum1).getRow(rownum1).createCell(15).setCellValue("PASS");
			Dataprovider.defaultValues1(workbook);
			}
			else
			{
				Reporter.log("Recommended MRC is LESSER than Current",true);
				workbook.getSheetAt(sheetNum1).getRow(rownum1).createCell(15).setCellValue("FAIL");
				Dataprovider.defaultValues1(workbook);
				Assert.fail();
			}
			
		}
		else
		{
			Reporter.log("Recommended DATA is LESSER than Current",true);
			workbook.getSheetAt(sheetNum1).getRow(rownum1).createCell(15).setCellValue("FAIL");
			Dataprovider.defaultValues1(workbook);
			Assert.fail();
		}
		
		
		
		
	}


}
