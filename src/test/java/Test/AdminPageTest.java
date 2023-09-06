package Test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.simplilearn.flightbooking.AddFligts;
import com.simplilearn.flightbooking.AdminLoginValid;
import com.simplilearn.flightbooking.Bookings;

import com.simplilearn.flightbooking.HomePage;
import com.simplilearn.flightbooking.LoginPage;
import com.simplilearn.flightbooking.SetFlight;
import com.simplilearn.flightbooking.SetPlaces;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AdminPageTest {

	ChromeDriver driver;
	
	@BeforeTest
	public void lunchBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://localhost:8081/FlyAway/");
		System.out.println("BeforeTest: launchbrowser");
	}
	@Test(priority = 1)
	public void adminLogin() throws InterruptedException {
		AdminLoginValid adminobj = new AdminLoginValid(driver);
		adminobj.adminCredential();
	}
	@Test
	public void testPassword() {
		boolean result = AdminLoginValid.isValid("aaaaaa");
		AssertJUnit.assertEquals(true, result);
	}
	
	@Test(priority = 2)
	public void homePageAdmin() throws InterruptedException {
		HomePage adminobj = new HomePage(driver);
		adminobj.adminhome();
	}
	
	@Test(priority = 3)
	public void setPlaces() throws InterruptedException {
		SetPlaces setobj = new SetPlaces(driver);
		setobj.place();
	}
	
	@Test(priority = 4)
	public void addFlightName() throws InterruptedException {
		AddFligts flightobj = new AddFligts(driver);
		flightobj.flightinsert();
	}
	
	@Test(priority = 5)
	public void setUpFlights() throws InterruptedException {
		SetFlight changeobj = new SetFlight(driver);
		changeobj.editflight();
	}
	
	@Test(priority=6)
	public void bookingValidation() throws InterruptedException {
		
		Bookings valid = new Bookings(driver);
		valid.browserMembers();
		Thread.sleep(1000);
		valid.bookingReports();
	}
	
	@Test(priority =7)
	public void admincredential() throws InterruptedException {
		AdminLoginValid credit = new AdminLoginValid(driver);
		credit.changePassword();
		Thread.sleep(1000);
		credit.logoutPage();
		driver.close();
	}	
}
