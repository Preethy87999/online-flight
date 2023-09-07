package Test;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.simplilearn.flightbooking.HomePage;
import com.simplilearn.flightbooking.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UserPageTest {

	ChromeDriver driver;

	@BeforeTest
	public void lunchBrowser() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Lenovo\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

		driver = new ChromeDriver();

		driver.manage().window().maximize();
		// WebDriverManager.chromedriver().setup();
		// driver = new ChromeDriver();
		// driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://localhost:8081/FlyAway/");
		System.out.println("BeforeTest: launchbrowser");
	}
	
	@Test(priority=0)
	public void validateSignUp() throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("a[href='login']")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("a[href='signup']")).click();
		LoginPage signup = new LoginPage(driver);
		signup.sendTextInSign("preethy@gmail.com", "Pree#123", "Pree#123", "preethy", "yyy", "chennai");
		Thread.sleep(2000);
		signup.clickBtnReg();	
	}
	@Test(priority = 1)
	public void loginPage() throws InterruptedException {	
		driver.findElement(By.cssSelector("body a:nth-child(3)")).click();
		Thread.sleep(1000);
		LoginPage loginPageObj = new LoginPage(driver);
		loginPageObj.sendTextInLogin("preethy@gmail.com", "Pree#123");
		Thread.sleep(1000);
		loginPageObj.clickBtnLogin();
		String expectedTitle = "Fly Away - Dashboard";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
	}

	@Test(priority = 2)
	public void editProfilePage() throws InterruptedException {
		driver.findElement(By.cssSelector("a[href='editprofile']")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("input[name='pwd']")).sendKeys("preethi123");
		driver.findElement(By.cssSelector("input[name='pwd2']")).sendKeys("preethi123");
		driver.findElement(By.cssSelector("input[name='name']")).clear();
		driver.findElement(By.cssSelector("input[name='name']")).sendKeys("pooja");
		Thread.sleep(1000);
		driver.findElement(By.tagName("button")).click();
	}
	@Test(priority = 3)
	public void userHomePageValid() throws InterruptedException {
		driver.findElement(By.cssSelector("a[href='home']")).click();
		HomePage homeobj = new HomePage(driver);
		homeobj.sourceLocation();
		Thread.sleep(1000);
		homeobj.destinationLocation();
		Thread.sleep(1000);
		driver.findElement(By.tagName("button")).click();
		driver.findElement(By.xpath("//body[1]/table[1]/tbody/tr")).getSize();
	}
	
	
	@Test(priority = 4)
	public void bookingFlight() throws InterruptedException {
		driver.findElement(By.cssSelector("a[href='home']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//body[1]/table[1]/tbody[1]/tr[2]/td[6]/a[1]")).click();
		Thread.sleep(1000);
		String expectedtext = "FLYAWAY - PAYMENT GATEWAY";
		String actualtext = driver.findElement(By.tagName("h3")).getText();
		Assert.assertEquals(actualtext, expectedtext);   
	}
	
	@Test(priority = 5)
	public void confirmFlight() throws InterruptedException {
		driver.findElement(By.cssSelector("a[href='completepurchase']")).click();
		Thread.sleep(1000);
		String expectedtext1 = "FLYAWAY - BOOKING CONFIRMATION";
		String actualtext1 = driver.findElement(By.tagName("h3")).getText();
		Assert.assertEquals(actualtext1, expectedtext1);
		driver.findElement(By.cssSelector("a[href='memberbookings']")).click();
	}
	
	@Test(priority = 6)
	public void logoutPage() throws InterruptedException {
		driver.findElement(By.cssSelector("a[href='logout']")).click();
		Thread.sleep(1000);
		driver.close();
	}
}
