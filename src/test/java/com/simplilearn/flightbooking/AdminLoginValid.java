package com.simplilearn.flightbooking;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.AssertJUnit;

public class AdminLoginValid {
	WebDriver driver ;
	public AdminLoginValid(WebDriver driver) {
		this.driver=driver;
	}
	public void adminCredential() {
		driver.get("http://localhost:8081/FlyAway/adminlogin");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		WebElement adminid=driver.findElement(By.cssSelector("input[name='admin_id']"));
		WebElement password=driver.findElement(By.cssSelector("input[name='admin_pwd']"));
		WebElement login=driver.findElement( By.tagName("button"));
		adminid.sendKeys("admin");
		password.sendKeys("aaaaaa");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		login.click();
		String actualUrl="http://localhost:8081/FlyAway/adminloginaction";
		String expectedUrl= driver.getCurrentUrl();
		Assert.assertEquals(expectedUrl,actualUrl);
	}
	
	public void changePassword() throws InterruptedException {
		driver.findElement(By.cssSelector("a[href='adminchangepassword']")).click();
		Thread.sleep(1000);
		String actualUrl="http://localhost:8081/FlyAway/adminchangepassword";
		String expectedUrl= driver.getCurrentUrl();
		Assert.assertEquals(expectedUrl,actualUrl);
	}
	
	public void logoutPage() throws InterruptedException {
		driver.findElement(By.cssSelector("a[href='adminlogout']")).click();
		Thread.sleep(1000);
		String actualUrl="http://localhost:8081/FlyAway/adminlogout";
		String expectedUrl= driver.getCurrentUrl();
		Assert.assertEquals(expectedUrl,actualUrl);
	}
	public static boolean isValid(String password) {
		if(password.isEmpty()) {
		return false;
		}
		else {
			if(password.length()>=5 && password.length()<=10) {
				return true;	
			}
			else {
				return false;
			}
		}
	}
}
