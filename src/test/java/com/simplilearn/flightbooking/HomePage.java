package com.simplilearn.flightbooking;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.AssertJUnit;

public class HomePage {
	WebDriver driver = null;
	By source = By.cssSelector("select[name='source']");
	By location =By.cssSelector("select[name='source'] option");
	By selectlocation = By.cssSelector("select[name='source'] option[value='4']");
	By selectdestination = By.cssSelector("select[name='destination'] option[value='1']");
	
	public  HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void sourceLocation() {
		driver.findElement(By.cssSelector("a[href='home']")).click();
		driver.findElement(source).click();
		System.out.println(driver.findElements(location).size());
		driver.findElement(selectlocation).click();
		String actualSource =driver.findElement(selectlocation).getText();
		String expectedSource ="Chennai";
	}
	public void destinationLocation() {
		driver.findElement(selectdestination).click();
		String actualdestination =driver.findElement(selectdestination).getText();
		String expecteddestination ="Bangalore";
		Assert.assertEquals(actualdestination,expecteddestination);
	}
	
	public void adminhome() throws InterruptedException {
		
		driver.findElement(By.cssSelector("a[href='admindashboard']")).click();
		Thread.sleep(1000);
		String actualtext="ADMIN DASHBOARD";
		String expectedtext= driver.findElement(By.tagName("h3")).getText();
		Assert.assertEquals(expectedtext,actualtext);
	}
	
}
