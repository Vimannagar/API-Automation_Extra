package ecommerceapi;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

public class PlaceOrder extends BaseData {
	
	@Test
	public void placeProductOrder()
	{
		RestAssured.baseURI = "https://www.rahulshettyacademy.com";
		
		given()
		
		.header("Content-Type", "application/json")
		
		.header("Authorization", tokenid)
		
		.body(JsonBody.getBody(productid))
		
		.when()
		
		.post("api/ecom/order/create-order")
		
		.then()
		
		.log().all()
		
		.extract()
		
		.response();
		
	}

}
