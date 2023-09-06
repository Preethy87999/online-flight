package com.simplilearn.flightbooking;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class SetPlaces {

	WebDriver driver;
	public SetPlaces(WebDriver driver) {
		this.driver = driver;
	}
	public void place() throws InterruptedException {
		driver.findElement(By.cssSelector("a[href='adminplaces']")).click();
		driver.findElement(By.cssSelector("a[href='admineditplace?id=0']")).click();
		String actualUrl="http://localhost:8081/FlyAway/admineditplace?id=0";
		String expectedUrl= driver.getCurrentUrl();
	    Assert.assertEquals(expectedUrl,actualUrl);
	    Thread.sleep(1000);
		driver.findElement(By.xpath("//td/input")).sendKeys("Goa");
		driver.findElement(By.tagName("button")).click();	
	}
}
