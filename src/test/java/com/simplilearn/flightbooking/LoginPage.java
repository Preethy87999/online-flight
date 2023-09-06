package com.simplilearn.flightbooking;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	WebDriver driver = null;
	By emailenter = By.cssSelector("input[name='email_id']");
	By passwordenter = By.cssSelector("input[name='pwd']");
	By confirmpass = By.cssSelector("input[name='pwd2']");
	By address = By.cssSelector("input[name='address']");
	By name = By.cssSelector("input[name='name']");
	By city = By.cssSelector("input[name='city']");
	By btnreg = By.tagName("button");
	By btnlogin = By.tagName("button");
	
	public  LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	public void sendTextInLogin(String text,String text2) {
		driver.findElement(emailenter).sendKeys(text);
		driver.findElement(passwordenter).sendKeys(text2);
	}
	
	public void sendTextInSign(String text,String text2,String text3,String text4,String text5,String text6) {
		driver.findElement(emailenter).sendKeys(text);
		driver.findElement(passwordenter).sendKeys(text2);
		driver.findElement(confirmpass).sendKeys(text3);
		driver.findElement(name).sendKeys(text4);
		driver.findElement(address).sendKeys(text5);
		driver.findElement(city).sendKeys(text6);
	}
	
	
	public void clickBtnLogin() {
		driver.findElement(btnlogin).sendKeys(Keys.RETURN);
	}
	public void clickBtnReg() {
		driver.findElement(btnreg).sendKeys(Keys.RETURN);
	}
}
