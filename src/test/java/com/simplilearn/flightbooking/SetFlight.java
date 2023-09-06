package com.simplilearn.flightbooking;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class SetFlight {

	WebDriver driver;
	
	public SetFlight(WebDriver driver) {
		this.driver = driver;
		
	}
	
	public void editflight() throws InterruptedException {
		driver.findElement(By.cssSelector("a[href='adminflights']")).click();
		driver.findElement(By.cssSelector("a[href='admineditflight?id=0']")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("select[name='source'] option[value='1']")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("select[name='destination'] option[value='6']")).click();
		driver.findElement(By.cssSelector("select[name='airline'] option[value='2']")).click();
		driver.findElement(By.cssSelector("input[name='departure']")).sendKeys("6 AM");
		driver.findElement(By.cssSelector("input[name='arrival']")).sendKeys("7:10 AMx");
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("input[name='duration']")).sendKeys("1.10 HOURS");
		driver.findElement(By.cssSelector("input[name='price']")).sendKeys("2400.00");
		Thread.sleep(1000);
		driver.findElement(By.tagName("button")).click();
		String actualURL= "http://localhost:8081/FlyAway/adminflights";
		String expectedURL=driver.getCurrentUrl();
	    Assert.assertEquals(actualURL, expectedURL);
	    Thread.sleep(2000);
		driver.findElement(By.xpath("(//a[contains(text(),'Delete')])[1]")).click();
		String expecteddestination= "Bangalore Chennai AirAsia 4500.00 Edit | Delete";
		String actualdestination=driver.findElement(By.xpath("//tr[contains(.,'Chennai')]")).getText();
	    Assert.assertEquals(expecteddestination, actualdestination);
		
	}
}
