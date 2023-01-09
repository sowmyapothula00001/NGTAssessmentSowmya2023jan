package com.app.pages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class Myntra
{
	WebDriver driver;
	static String rootFolder = System.getProperty("user.dir");
	 public Myntra(WebDriver driver)
	 {
		 this.driver=driver;
		 
		 PageFactory.initElements(driver,this);
		 
	 }
	
	public void enterUrl1() throws Exception 
		 {
			 Properties a = new Properties();
			 a.load(new FileInputStream(rootFolder + "//src//test//resources//Myfile.properties"));
			 driver.get(a.getProperty("url")); 
		 }
	public void search()throws Exception
		{
		 Properties a = new Properties();
		 a.load(new FileInputStream(rootFolder + "//src//test//resources//Myfile.properties"));
		 driver.findElement(By.xpath("//input[@placeholder='Search for products, brands and more']")).sendKeys(a.getProperty("product"));
		 driver.findElement(By.xpath("//span[@class='myntraweb-sprite desktop-iconSearch sprites-search']")).click();
	 }
	
	public void enterUrl2()throws Exception
	 {
		/* Properties a = new Properties();
		 a.load(new FileInputStream(rootFolder + "//src//test//resources//Myfile.properties"));
		 driver.get(a.getProperty("url1"));*/
		driver.get(" https://www.myntra.com/login/password");
	 
}
	public void login() throws Exception
	 {
		Properties a = new Properties();
		a.load(new FileInputStream(rootFolder + "//src//test//resources//Myfile.properties"));
		driver.findElement(By.id("mobileNumberPass")).sendKeys(a.getProperty("email")); 
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys(a.getProperty("password"));
		driver.findElement(By.xpath("//button[text()='LOGIN']")).click();
		Thread.sleep(34000);
		driver.findElement(By.xpath("//button[text()='LOGIN']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[@class='myntraweb-sprite desktop-iconBag sprites-headerBag']")).click();
		Thread.sleep(3000);
}

	/*public void emptyCardVerify()
	 {
		 String exceptedPageTitle = "Hey, it feels so light!";
         String actualPageTitle = driver.findElement(By.xpath("//div[text()='Hey, it feels so light!']")).getText();
		Assert.assertEquals(actualPageTitle,exceptedPageTitle,"cart is empty");
		driver.findElement(By.xpath("//div[text()='ADD ITEMS FROM WISHLIST']")).click();
		
	}*/
	public void addtocart() throws Exception
	{
		driver.findElement(By.xpath("//img[@title='DressBerry Lavender Textured Structured Mobile Pouch']")).click();
		ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
        //switch to new tab
        driver.switchTo().window(newTab.get(1));
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[contains(text(),\"ADD TO BAG\")]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[@class='myntraweb-sprite desktop-iconBag sprites-headerBag']")).click();
        String exceptedPageTitle = "Lavender Textured Structured Mobile Pouch";
        String actualPageTitle = driver.findElement(By.xpath("//a[contains(@class,\"itemContainer-base-itemLink\")]")).getText();
		Assert.assertEquals(actualPageTitle,exceptedPageTitle,"iteam is added");
		driver.quit();
	}
	
}
