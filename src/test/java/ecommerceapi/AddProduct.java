package ecommerceapi;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.io.File;

public class AddProduct extends BaseData {
	
	@Test
	public void addProductToApp()
	{
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		
		Response resp = given()
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
		
		JsonPath jp= resp.jsonPath();
		
		String prdid= jp.getString("productId");
		
		productid = prdid;
		
		
		
		
		
		
		
		
		
	}

}
