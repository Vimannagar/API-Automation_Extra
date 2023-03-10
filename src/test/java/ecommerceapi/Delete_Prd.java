package ecommerceapi;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class Delete_Prd extends BaseData {
	
	
	@Test
	public void placeProductOrder()
	{
		RestAssured.baseURI = "https://www.rahulshettyacademy.com";
		
		given()
		
		.header("Authorization", tokenid)
		.pathParam("prdid", productid)
		
		.when()
		
		.delete("/api/ecom/product/delete-product/{prdid}")
		
		.then()
		
		.log()
		
		.all()
		
		.extract()
		
		.response();
		
		
	}

}
