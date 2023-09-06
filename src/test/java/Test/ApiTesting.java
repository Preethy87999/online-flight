package Test;

import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
public class ApiTesting {
	
	@Test
	public void getAllFlights() {
		
		String url = "http://localhost:8081/FlyAway/";
		RestAssured.baseURI = url;
		RestAssured.given().get("adminbookings").then().log().body().statusCode(200);
	}
	@Test
	public void getBookSeat() {
		 RequestSpecification httpRequest = RestAssured.given();

		Response response = httpRequest.get("http://localhost:8081/FlyAway/");
		response.then().log().status()
	      .statusCode(200);		 
	}
}
