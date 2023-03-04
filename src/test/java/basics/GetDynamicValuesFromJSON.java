package basics;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class GetDynamicValuesFromJSON {
	
	
	@Test
	public void getEmail()
	{
		RestAssured.baseURI = "https://reqres.in";
	
Response response	=	given()
		
		.log().all()
		
		.when()
		
		.get("api/users?page=2")
		
		.then()
		
		.log().all()
		
		.extract()
		
		.response();

	String stringresponse = response.asPrettyString();


	JsonPath jp = new JsonPath(stringresponse);
	
	
	int numberofelementsindataarray = jp.getInt("data.size()");// size of data array in json response
	
	System.out.println(numberofelementsindataarray);//6

	
	for(int i =0; i<numberofelementsindataarray; i++)
	{
		int idvalue = jp.getInt("data["+i+"].id");
		
		System.out.println(idvalue);
		
		if(idvalue == 10)
		{
			String firstname = jp.getString("data["+i+"].first_name");
			System.out.println(firstname);
		}
	}


	}

}
