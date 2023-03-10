package ecommerceapi;

public class JsonBody {

	
	public static String getBody(String prdid)
	{
		return "{\"orders\": [\r\n"
				+ "        {\r\n"
				+ "        \"country\": \"India\", \r\n"
				+ "        \"productOrderedId\" : \""+prdid+"\"\r\n"
				+ "        }\r\n"
				+ "    ]\r\n"
				+ "}";
	}
}
