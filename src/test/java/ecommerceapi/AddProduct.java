package ecommerceapi;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.*;

import java.io.File;

public class AddProduct extends BaseData {
	
	@Test
	public void addProductToApp()
	{
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		
		given()
		.header("Authorization", tokenid)
		
		.param("productName", "Ladies sports shoe")
		.param("productAddedBy", userid)
		.param("productCategory", "fashion")
		.param("productSubCategory", "shoes")
		.param("productPrice", "600")
		.param("productDescription", "Puma")
		.param("productFor", "women")
		.multiPart("productImage", new File("F:\\Desktop\\VimanNagar\\May 21\\ApiAutomationSession\\shoeimage.png"))
		.log().all()
		.when()
		
		.post("api/ecom/product/add-product")
		
		.then()
		.log().all()
		.extract()
		.response();
		
		
		
		
	}

}
