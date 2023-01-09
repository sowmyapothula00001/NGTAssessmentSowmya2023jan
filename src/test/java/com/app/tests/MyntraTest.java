package com.app.tests;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.app.pages.Myntra;

public class MyntraTest {
	
	Myntra myt;
	WebDriver driver;

	@BeforeMethod
	public void Setup() throws Exception
	{
		
		System.out.println("Script started");
		driver = new ChromeDriver();
		 driver.manage().window().maximize();
		 Thread.sleep(2000);
		 
	   // myt = new Myntra(driver);
	}
	@Test
	  public void Launchandverify() throws Exception 
	  {
		
		myt = new Myntra(driver);
		myt.enterUrl1();
		myt.search();

		String exceptedPageTitle = "Redmi 10 - Buy Redmi 10 online in India";
	     String actualPageTitle = driver.getTitle();
		Assert.assertEquals(actualPageTitle,exceptedPageTitle,"Product is displayed");
		driver.quit();
	
		
		  
	  }
	@Test
	  public void  cart() throws Exception 
	  {
		
		
		//myt.launchBrowser();
		myt = new Myntra(driver);
		myt.enterUrl2();
		myt.login();
		 String exceptedPageTitle = "Hey, it feels so light!";
         String actualPageTitle = driver.findElement(By.xpath("//div[text()='Hey, it feels so light!']")).getText();
		Assert.assertEquals(actualPageTitle,exceptedPageTitle,"cart is empty");
		driver.findElement(By.xpath("//div[text()='ADD ITEMS FROM WISHLIST']")).click();
		//myt.emptyCardVerify();
	    myt.search();
	    myt.addtocart();
		  
	  }
}
