package com.simplilearn.flightbooking;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddFligts {

	WebDriver driver;
	public  AddFligts(WebDriver driver) {
		this.driver= driver;
	}
	 public void flightinsert() throws InterruptedException {
		 driver.findElement(By.cssSelector("a[href='adminplaces']")).click();
			driver.findElement(By.cssSelector("a[href='admineditplace?id=0']")).click();
			driver.findElement(By.cssSelector("input[name='name']")).sendKeys("Jet Airways");
			Thread.sleep(1000);
			driver.findElement(By.tagName("button")).click();	
			driver.findElement(By.xpath("(//a[contains(text(),'Edit')])[3]")).click();
			Thread.sleep(2000);
			driver.findElement(By.cssSelector("input[name='name']")).clear();
			driver.findElement(By.cssSelector("input[name='name']")).sendKeys("IndiGo");
			Thread.sleep(1000);
	 }
}
