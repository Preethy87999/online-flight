package com.simplilearn.flightbooking;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Bookings {

	WebDriver driver;
	public Bookings(WebDriver driver) {
		this.driver = driver;
	}
	
	public void browserMembers() throws InterruptedException {
		driver.findElement(By.cssSelector("a[href='adminmembers']")).click();
		Thread.sleep(2000);
		// String actualemailid= "preethi@gmail.com";
		// String expectedemailid=driver.findElement(By.xpath("//tr/td[contains(.,'preethi@gmail.com')]")).getText();
	 //    Assert.assertEquals(actualemailid, expectedemailid);
	}
	
	public void bookingReports() throws InterruptedException {
		driver.findElement(By.cssSelector("a[href='adminbookings']")).click();
		Thread.sleep(1000);
		String actualname= "amit sengupta";
		String expectedname=driver.findElement(By.xpath("(//td[contains(text(),'amit sengupta')])[4]")).getText();
		Assert.assertEquals(actualname, expectedname);
	}
	
}
